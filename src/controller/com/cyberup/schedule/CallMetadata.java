/*
 * Created on 2005. 9. 1.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cyberup.schedule;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import net.dcollection.common.net.WebMethod;

import org.apache.log4j.Logger;
import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

import com.cyberup.util.DateFormatter;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java -
 * Code Style - Code Templates
 */
public class CallMetadata {
	public final static String PARAM_VERB = "verb";
	public final static String PARAM_METHOD = "method";
	public final static String PARAM_METADATA_PREFIX = "metadataPrefix";
	public final static String PARAM_IDENTIFIER = "identifier";
	public final static String PARAM_MODE = "mode";
	public final static String PARAM_FROM = "from";
	public final static String PARAM_UNTIL = "until";
	public final static String PARAM_RESUMPTION_TOKEN = "resumptionToken";
	
	public final static int DEFAULT_PAGE_SIZE = 10;
	
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    
    private String endpointUrl = "";
    private String methodName = "requestOAI";
    private String javaEncoding = "euc-kr";
    
    private Response response;

    public CallMetadata(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }
    
    public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setJavaEncoding(String javaEncoding) {
		this.javaEncoding = javaEncoding;
	}

	public Response getResponse() {
		return response;
	}
	
	public static int getTotalPage(int totalCnt, int pageSize)
	{
		return (totalCnt % pageSize == 0)?(totalCnt / pageSize):(totalCnt / pageSize + 1);
	}

	public static void main(String[] args) {
    	try {
    		URL url = new URL("http://localhost/axis/WebService/ItemHandler");
    		
    		CallMetadata callMetadata = new CallMetadata("http://localhost/axis/WebService/ItemHandler");
    		
    		Map param = new HashMap();
    		param.put("verb", "Identify");
    		
    		System.out.println(callMetadata.get(param));

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    
    public static String getQueryString(Map param)
    {
    	StringBuffer query = new StringBuffer();
    	
    	Iterator keys = param.keySet().iterator();
    	while(keys.hasNext())
    	{
    		String key = (String)keys.next();
    		String value = (String)param.get(key);
    		
    		if(query.length() > 0)
    			query.append("&");
    		query.append(key + "=" + value);
    	}
    	
    	return query.toString();
    }

    public String get(Map param) throws SoapException {
        // AXIS initialize
        try {
        	URL url = new URL(endpointUrl);
    		
    		Call oaiCall = new Call();
            oaiCall.setTargetObjectURI("urn:item-handler");
            oaiCall.setMethodName(methodName);
            oaiCall.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
            
            Vector params = new Vector();
            params.addElement(new Parameter("args", String.class, getQueryString(param), null));
            oaiCall.setParams(params);
            logger.debug("***************************url :: '" + url + "'");
            response = oaiCall.invoke(url, "");
            
            if(response.generatedFault())
            {
            	List errors = response.getFault().getDetailEntries();
            	for(int i = 0; i < errors.size(); i++)
            	{
            		logger.error(errors.get(i));
            	}
            	throw new SoapException(response.getFault());
            }
            
            /*
            System.out.println("1 = " + ((String)response.getReturnValue().getValue()).getBytes("euc-kr"));
            System.out.println("2 = " + new String(((String)response.getReturnValue().getValue()).getBytes("euc-kr"), "8859_1"));
            System.out.println("3 = " + new String(((String)response.getReturnValue().getValue()).getBytes("utf-8"), "8859_1"));
            System.out.println("4 = " + ((String)response.getReturnValue().getValue()).getBytes("utf-8"));
            System.out.println("5 = " + ((String)response.getReturnValue().getValue()));
            
            if (javaEncoding.equals("8859_1"))
                return new String(((String)response.getReturnValue().getValue()).getBytes("euc-kr"), "8859_1");
            else
                return (String)response.getReturnValue().getValue();
            */
            
            return (String)response.getReturnValue().getValue();
            
            
            
            
            
            
            

        } catch (SOAPException soapException) {
        	logger.error(soapException.getMessage(), soapException);
        	Fault fault = new Fault(soapException);
        	throw new SoapException(fault);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        	Fault fault = new Fault();
        	fault.setFaultCode("exception ocurred");
        	fault.setFaultString(e.getMessage());
        	throw new SoapException(fault);
        }
    }
    
    public class SoapException extends Exception
    {
    	private Fault fault;
    	public SoapException(Fault fault)
    	{
    		super(fault.getFaultString() + "(code : "+fault.getFaultCode()+")");
    		
    		this.fault = fault;
    	}
		public Fault getFault() {
			return fault;
		}
    }
}
