package fri.uni.lj.si.prpo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;

import SysMobPayModel.User;
import sysmobpay.zrna.UpravljavecUporabnikovZrnoLocal;


@RequestScoped
@Path("/users")
public class UsersREST {

	@EJB
	private UpravljavecUporabnikovZrnoLocal uuz;
	
	@GET
	@Produces("application/json")
	@Path("/{userID}")
	public User vrniUporabnika(@PathParam("userID") Integer userID){
		
		User uporabnik = uuz.getUser(userID);
		return uporabnik;
	}
}
