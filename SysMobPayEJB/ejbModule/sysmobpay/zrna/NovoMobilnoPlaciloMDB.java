package sysmobpay.zrna;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import sysmobpay.napake.NedovoljeniPogojiPlacilaException;
import SysMobPayModel.Order;

/**
 * Message-Driven Bean implementation class for: NovoMobilnoPlaciloMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "SMPQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
				@ActivationConfigProperty( propertyName = "maxSession", propertyValue = "1")
		}, 
		mappedName = "SMPQueue")
@TransactionManagement(TransactionManagementType.BEAN)
public class NovoMobilnoPlaciloMDB implements MessageListener {

	@EJB
	private UpravljavecObdelaveMobilnihPlacilZrno uompz;
	
    /**
     * Default constructor. 
     */
    public NovoMobilnoPlaciloMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	if(message instanceof ObjectMessage) {
    		ObjectMessage objektnoSporocilo = (ObjectMessage) message;
			try {
		    	if(objektnoSporocilo.getObject() instanceof Order) {
		    		Order ord = (Order) objektnoSporocilo.getObject();
		    		uompz.purchaseProcess(ord);
		    	}
			} catch (JMSException | NedovoljeniPogojiPlacilaException e) {
				System.out.println("Napaka pri procesiranju sprocila: " + e);
			}
		}        
    }

}
