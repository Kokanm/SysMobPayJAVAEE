package sysmobpay.zrna;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * Session Bean implementation class SpremljanjeIzvajanjaZrno
 */
@Stateless
public class SpremljanjeIzvajanjaZrno implements SpremljanjeIzvajanjaZrnoLocal {

	@Resource(mappedName = "jms/sysmobpay_cf")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:jboss/exported")
	private Topic topic;
    /**
     * Default constructor. 
     */
    public SpremljanjeIzvajanjaZrno(String sporocilo) {
    	Connection connection = null;
		Session session = null;
		MessageProducer posiljatelj = null;
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			posiljatelj = session.createProducer(topic);
			TextMessage textSporocilo = session.createTextMessage();
			textSporocilo.setText(sporocilo);
			posiljatelj.send(textSporocilo);
		} catch (JMSException ex) {
			System.out.println("Napaka pri posiljanju sporocil: " + ex);
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(session != null) {
					session.close();
				}
				if(posiljatelj != null) {
					posiljatelj.close();
				}
			} catch (JMSException e) {
				System.out.println("Napaka pri zapiranju povezav: " + e);
			}
		}
    }

}
