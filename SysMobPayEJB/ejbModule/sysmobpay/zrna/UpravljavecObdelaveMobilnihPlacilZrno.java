package sysmobpay.zrna;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sysmobpay.napake.NedovoljeniPogojiPlacilaException;
import sysmobpay.prestrezniki.Intercept;
import SysMobPayModel.Order;

/**
 * Session Bean implementation class UpravljavecObdelaveMobilnihPlacilZrno
 */
@Stateless
@DeclareRoles({ "User", "Administrator", "System" })
@RunAs("User")
@Interceptors({Intercept.class})
public class UpravljavecObdelaveMobilnihPlacilZrno implements UpravljavecObdelaveMobilnihPlacilZrnoRemote, UpravljavecObdelaveMobilnihPlacilZrnoLocal {

	@PersistenceContext(unitName="SysMobPayPU")
	private EntityManager em;
	
	@EJB
    private UpravljavecPlacilZrnoLocal upravljavecPlacil;
    
    @EJB
    private UpravljavecObvestilZrnoLocal upravljavecObvestil;
    
    @EJB
    private UpravljavecUporabnikovZrnoLocal upravljavecUporabnikov;
   
   
    public UpravljavecObdelaveMobilnihPlacilZrno() {
        // TODO Auto-generated constructor stub
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @PermitAll
    public Order purchaseProcess(Order order) throws NedovoljeniPogojiPlacilaException{
    	
    	if(upravljavecUporabnikov.check(order)){
    		order = upravljavecPlacil.savePayment(order);
    		upravljavecUporabnikov.changeDaily(order);
    		if(order.getBonusUsed()>0){
    			if(upravljavecUporabnikov.checkBonus(order)){
    				System.out.println("You have payed with bonus points!");
    			}else{
    				System.out.println("You don't have enough bonus points!");
    			}
    		}
    		upravljavecObvestil.prepareReceipt(order);
    	}else{
    		throw new NedovoljeniPogojiPlacilaException();
    	}
    	return order;
    }
    
    @PermitAll
    public List<Order> getAllOrders(){
    	TypedQuery<Order> poizvedba = em.createNamedQuery("Order.findAll",Order.class);
		List<Order> order = (List<Order>)poizvedba.getResultList();
		return order;
    }
    
    @PermitAll
    public Order getOrder(int idOrder){
    	return em.find(Order.class, idOrder);
    }   
    
    @PermitAll
    public void updateOrder(Order order) {
    	em.merge(order);
    	em.flush();
    }

}
