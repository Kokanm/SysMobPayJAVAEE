package sysmobpay.zrna;

import java.math.BigDecimal;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sysmobpay.napake.NedovoljeniPogojiPlacilaException;
import SysMobPayModel.Order;
import SysMobPayModel.User;

/**
 * Session Bean implementation class UpravljavecUporabnikovZrno
 */
@Stateless
public class UpravljavecUporabnikovZrno implements UpravljavecUporabnikovZrnoRemote, UpravljavecUporabnikovZrnoLocal {

	@PersistenceContext(unitName = "SysMobPayPU")
	private EntityManager em;
	
    public UpravljavecUporabnikovZrno() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @RolesAllowed({ "User", "Administrator", "System" })
    public boolean check(Order order){
    	
    	if(order.getPrice().compareTo(order.getUser().getMaxDaily()) > 0){
    		System.out.println("You've reached your daily limit!");
    		return false;
    	}else{    		
    		return true;
    	}    	
    }   
    
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @RolesAllowed({ "User", "Administrator", "System" })
    public boolean checkBonus(Order order){
    	User user = order.getUser();
    	
    	if(user.getBonusPoints()>order.getBonusUsed()){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @RolesAllowed({ "User", "Administrator", "System" })
    public void changeDaily(Order order) throws NedovoljeniPogojiPlacilaException{
    	User user = order.getUser();
    	
    	if(check(order)){
    		if(checkBonus(order)){
    			order.setPrice(order.getPrice().subtract(new BigDecimal(order.getBonusUsed())));
    		}
    		user.setMaxDaily(user.getMaxDaily().subtract(order.getPrice()));
    		System.out.println("Limit: "+user.getMaxDaily());
    	}else{
    		throw new NedovoljeniPogojiPlacilaException();
    	}
    }
    
    @PermitAll
	public User getUser(Integer idUser){
		User user = em.find(User.class, idUser);
		return user;
	}

}
