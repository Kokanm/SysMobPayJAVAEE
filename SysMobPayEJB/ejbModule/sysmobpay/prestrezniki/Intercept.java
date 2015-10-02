package sysmobpay.prestrezniki;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import sysmobpay.zrna.RequestsCounterZrno;

public class Intercept {
	@EJB
	private RequestsCounterZrno rqz;
	
	@AroundInvoke
	public Object interception(InvocationContext interceptionContext) throws Exception {
		rqz.increase();
		return interceptionContext.proceed();
	}
}
