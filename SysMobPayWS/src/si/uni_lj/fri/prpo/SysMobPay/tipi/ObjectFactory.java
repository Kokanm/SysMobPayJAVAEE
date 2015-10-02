
package si.uni_lj.fri.prpo.SysMobPay.tipi;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si.uni_lj.fri.prpo.sysmobpay.tipi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si.uni_lj.fri.prpo.sysmobpay.tipi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WebOrderTip }
     * 
     */
    public WebOrderTip createWebOrderTip() {
        return new WebOrderTip();
    }

    /**
     * Create an instance of {@link ProductTip }
     * 
     */
    public ProductTip createProductTip() {
        return new ProductTip();
    }

    /**
     * Create an instance of {@link DetailsTip }
     * 
     */
    public DetailsTip createDetailsTip() {
        return new DetailsTip();
    }

    /**
     * Create an instance of {@link UserTip }
     * 
     */
    public UserTip createUserTip() {
        return new UserTip();
    }

    /**
     * Create an instance of {@link CompanyTip }
     * 
     */
    public CompanyTip createCompanyTip() {
        return new CompanyTip();
    }

    /**
     * Create an instance of {@link OrderDetailsTip }
     * 
     */
    public OrderDetailsTip createOrderDetailsTip() {
        return new OrderDetailsTip();
    }

    /**
     * Create an instance of {@link AddressTip }
     * 
     */
    public AddressTip createAddressTip() {
        return new AddressTip();
    }

    /**
     * Create an instance of {@link SysMobPayTip }
     * 
     */
    public SysMobPayTip createSysMobPayTip() {
        return new SysMobPayTip();
    }

}
