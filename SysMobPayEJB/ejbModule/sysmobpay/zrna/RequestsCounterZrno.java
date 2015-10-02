package sysmobpay.zrna;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class RequestsCounterZrno
 */
@Singleton
public class RequestsCounterZrno {

    /**
     * Default constructor. 
     */
    public RequestsCounterZrno() {
        // TODO Auto-generated constructor stub
    }
    
    private int requestCounter;
    
    @PostConstruct
    public void setCounter(){
    	requestCounter = 0;
    }

    
    public void increase(){
    	requestCounter++;
    	System.out.println("Requests: "+requestCounter);
    }

}
