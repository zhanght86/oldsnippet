package net.gmcc.pboss.comswebservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.3.8
 * 2012-06-20T09:14:02.467+08:00
 * Generated source version: 2.3.8
 * 
 */
@WebServiceClient(name = "COMSWebService", 
                  //wsdlLocation = "file:wsdl/COMSWebService.wsdl",
                  wsdlLocation = "data/COMSWebService.wsdl",
                  targetNamespace = "http://www.gmcc.net/pboss/COMSWebService/") 
public class COMSWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.gmcc.net/pboss/COMSWebService/", "COMSWebService");
    public final static QName COMSWebServiceSOAP = new QName("http://www.gmcc.net/pboss/COMSWebService/", "COMSWebServiceSOAP");
    static {
        URL url = null;
        try {
            //url = new URL("file:wsdl/COMSWebService.wsdl");
        	url = COMSWebService.class.getClassLoader().getResource("data/COMSWebService.wsdl");
        } catch (Exception e) {//MalformedURLException
            java.util.logging.Logger.getLogger(COMSWebService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:wsdl/COMSWebService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public COMSWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public COMSWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public COMSWebService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns COMSWebServicePort
     */
    @WebEndpoint(name = "COMSWebServiceSOAP")
    public COMSWebServicePort getCOMSWebServiceSOAP() {
    	COMSWebServicePort port = super.getPort(COMSWebServiceSOAP, COMSWebServicePort.class);
    	org.apache.cxf.endpoint.Client client = org.apache.cxf.frontend.ClientProxy.getClient(port);
    	org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
    	cxfEndpoint.getOutInterceptors().add(new org.apache.cxf.interceptor.LoggingOutInterceptor());
    	cxfEndpoint.getInInterceptors().add(new org.apache.cxf.interceptor.LoggingInInterceptor());
    	
    	return port;    	
    	//return super.getPort(COMSWebServiceSOAP, COMSWebServicePort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns COMSWebServicePort
     */
    @WebEndpoint(name = "COMSWebServiceSOAP")
    public COMSWebServicePort getCOMSWebServiceSOAP(WebServiceFeature... features) {
        return super.getPort(COMSWebServiceSOAP, COMSWebServicePort.class, features);
    }

}
