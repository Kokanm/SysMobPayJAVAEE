package sysmobpay.zrna;

import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import SysMobPayModel.Order;

/**
 * Session Bean implementation class UpravljavecPlacilZrno
 */
@Stateless
public class UpravljavecPlacilZrno implements UpravljavecPlacilZrnoRemote, UpravljavecPlacilZrnoLocal {

	@PersistenceContext(unitName = "SysMobPayPU")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljavecPlacilZrno() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @RolesAllowed({ "User", "Administrator", "System" })
    public Order savePayment(Order order) {
    	order.setDateOfOrder(new Date());
    	/*Order order1 = new Order();
    	order1.setOrder_ID(order.getOrder_ID());    	    
    	order1.setUser(order.getUser());
    	order1.setAddress(order.getAddress());
    	order1.setBonusUsed(order.getBonusUsed());
    	order1.setPrice(order.getPrice());
    	order1.setTaxPrice(order.getTaxPrice());
    	order1.setOrderdetails(order.getOrderdetails());
    	order1.setBonusReward(order.getBonusReward());
		*/
    	em.merge(order);
    	
		return order;		
	}
}
