package net.tot3g.omclient.webapp.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.tot3g.omclient.model.Transactiondata;



/**
 * Servlet Filter implementation class SimpleTPSFilter
 */
public class TransactionPerMinuteFilter implements Filter {
	
	public static HashMap<String,Transactiondata> filterdata = new HashMap<String,Transactiondata>();
    
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String ip = request.getRemoteAddr();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;        
	    if(httpRequest.getMethod().equalsIgnoreCase("POST")){
	    	
	    	Transactiondata counttps = filterdata.get(ip);
			if(counttps==null)
			{
				Transactiondata data = new Transactiondata();
				data.setCounttransaction(1);
				
				Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");	    				
				data.setDateiput(sdf.format(cal.getTime()));
				
				System.out.println(ip+" : "+sdf.format(cal.getTime())+" : 1");
				
				filterdata.put(ip, data);
			}
			else
			{
				Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");	    						
				
				if(counttps.getDateiput().equals(sdf.format(cal.getTime())))
				{
					
					int count = counttps.getCounttransaction();
					count++;
					
					System.out.println(ip+" : "+counttps.getDateiput()+" : "+count);
					
					Transactiondata data = new Transactiondata();
					data.setCounttransaction(count);										
					data.setDateiput(counttps.getDateiput());
					
					filterdata.remove(ip);
					filterdata.put(ip, data);				
				}
				else
				{
					filterdata.remove(ip);
				}
			}
	    }
						
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
