package sysmobpay.zrna;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: NovoObvestiloMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "SMPQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty( propertyName = "maxSession", propertyValue = "1")
		}, 
		mappedName = "SMPQueue")
@TransactionManagement(TransactionManagementType.BEAN)
public class NovoObvestiloMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public NovoObvestiloMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	if(message instanceof TextMessage) {
    		TextMessage sporocilo = (TextMessage) message;
    		try {
    			if (sporocilo != null) {
    				System.out.println(sporocilo.getText());
    			}
			} catch (JMSException e) {
				System.out.println("Napaka pri branju sporocila tipa email: " + e);
			}
    	}        
    }

}
