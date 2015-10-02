package sysmobpay.zrna;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import SysMobPayModel.Order;

/**
 * Session Bean implementation class SprejmiZahtevekMobilnegaPlacilaZrno
 */
@JMSDestinationDefinition(name="java:jboss/jms/SMPQueue", interfaceName = "javax.jms.Queue")
@Stateless
public class SprejmiZahtevekMobilnegaPlacilaZrno implements SprejmiZahtevekMobilnegaPlacilaZrnoRemote, SprejmiZahtevekMobilnegaPlacilaZrnoLocal {

    /**
     * Default constructor. 
     */
	@Resource(mappedName = "jms/sysmobpay_cf")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:jboss/jms/SMPQueue")
	private Queue queue;
	
    public SprejmiZahtevekMobilnegaPlacilaZrno() { }

	@Override
	public void sprejmiPaketPogodb(List<Order> order) {
		Connection connection = null;
		Session session = null;
		MessageProducer posiljatelj = null;
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(true, Session.SESSION_TRANSACTED);
			posiljatelj = session.createProducer(queue);
			for(Order pogodba : order) {
				ObjectMessage objektnoSporocilo = session.createObjectMessage();
				objektnoSporocilo.setObject(pogodba);
				posiljatelj.send(objektnoSporocilo);
			}
		} catch (JMSException ex) {
			System.out.println("Error while sending the message: " + ex);
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
				System.out.println("Error while closing the connection: " + e);
			}
		}
	}

}
