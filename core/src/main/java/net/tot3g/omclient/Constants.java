package net.tot3g.omclient;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.core.io.ClassPathResource;

import net.tot3g.omclient.service.ApplicationConfigService;



/**
 * Constant values used throughout the application.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

    private Constants() {
        // hide me
    }
    //~ Static fields/initializers =============================================

    /**
     * The name of the ResourceBundle used in this application
     */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /**
     * File separator from System properties
     */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /**
     * User home from System properties
     */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

    /**
     * The request scope attribute under which an editable user form is stored
     */
    public static final String USER_KEY = "userForm";

    /**
     * The request scope attribute that holds the user list
     */
    public static final String USER_LIST = "userList";

    /**
     * The request scope attribute for indicating a newly-registered user
     */
    public static final String REGISTERED = "registered";

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "ROLE_ADMIN";
    
    /**
     * The name of the Manager role, as specified in web.xml
     */
    public static final String MANAGER_ROLE = "ROLE_MANAGER";

    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "ROLE_USER";
    
    /**
     * The name of the User role, as specified in web.xml
     */
    // Wanatsanan 01/03/2016
    public static final String ROLE_CHECKERROR = "ROLE_CHECKERROR";
    
    /*
     * The name of Editor role, as specified in web.xml
     */
    public static final String EDITOR_ROLE ="ROLE_EDITOR";

    /**
     * The name of the user's role list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String USER_ROLES = "userRoles";

    /**
     * The name of the available roles list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";
    
    /*
     * MVNO NAME
     * 
     */
    
    public static  String MVNO_ID="";
    
    public static  String MVNO_Code="";
    
    public static  String isPolicyChangeplanAllow="";
    
    public static  String isAllowPostpaidSUBMIT="";
    
    /** TRANSACTION PER MINUTE **/
    public static String TRANSPERMINUTE = "";
    
    /** Server Central Date Format */
    public static final String HQ_DATE_FORMAT = "yyyy/MM/dd";
    
    public static String PROMOTION_CANSUBVOICETOPPING = "";
    
    // Edit By Wanatsanan 31/03/2017
    public static String MAX_VOICETOPPING = "";
    
    
    public static String IMSI_COOPERATE_RANGE = "";
    
    // Edit by Wanatsanan 21/04/2016
    public static String CDR_RATING = "";
    
    public static boolean CGW_ACT = true;
    
    public static boolean MODPCS_TIMEROLLING = false;
    
    public static boolean MODPCS_DATAROLLING = false;
    
    public static boolean MODPCS_SUBINTIME = false;
    
    public static boolean VOICETOPPING_SUBINTIME = false;
    
    public static String IN_SERVICERETAILERNAME = "";
    
    public static String OMWEBSERVICE_LOGINCREDENTIAL = "";
    
    public static String WHITELISTIP ="";
    
    public static boolean DEBUG = false;
    
    public static String[] MAPPINGOM;
    
    public static String[] DESCRIPTIONMAPPINGOM;
    
    public static String[] SMSSENDING;

    /**
     * The name of the CSS Theme setting.
     */
    public static final String CSS_THEME = "csstheme";	
    
    static Properties p = new Properties();
    
    /*
     *  SIMM TimeOut
     * 
     */
    public static String SIMM_TIMEOUT = "1000";
    public static String NORMAL_TIMEOUT = "1000";
    
    public static final String IPSERVER ="http://localhost:8080";
    
    public static StaticApplicationContext ctx;
    
	static {	
			
			try
			{
				ctx = new StaticApplicationContext();
				XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
				xmlReader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
				ctx.refresh();
								
				MVNO_ID = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("mvno_id").getValue().toString();		
				MVNO_Code = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("mvno").getValue().toString();
				isPolicyChangeplanAllow = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("ispolicychangeplanallow").getValue().toString();			
				isAllowPostpaidSUBMIT = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("isAllowPostpaidSUBMIT").getValue().toString();				
				TRANSPERMINUTE = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("tpm").getValue().toString();
				
				PROMOTION_CANSUBVOICETOPPING = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("voicetoppingpromotion").getValue().toString();
				IMSI_COOPERATE_RANGE =((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("imsi_cooperate").getValue().toString();
				
				// Edit by Wanatsanan 21/04/2016
				CDR_RATING = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("cdr_rating").getValue().toString();
				
				// ACTIVATE TIME ROLLING FUNCTION WHEN NEW SUBSCRIBE
				MODPCS_TIMEROLLING = Boolean.valueOf(((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("modpcs_timerolling").getValue().toString());
				
				// ACTIVATE CGW
				CGW_ACT = Boolean.valueOf(((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("cgw_act").getValue().toString());
				
				// ACTIVATE DATA ROLLING FUNCTION WHEN NEW SUBSCRIBE
				MODPCS_DATAROLLING = Boolean.valueOf(((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("modpcs_datarolling").getValue().toString());
				
				//ACTIVATE SUBSCRIBE IN TIME
				MODPCS_SUBINTIME = Boolean.valueOf(((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("modpcs_subintime").getValue().toString());
				
				
				SIMM_TIMEOUT = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("SIMM_TIMEOUT").getValue().toString();
				NORMAL_TIMEOUT = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("NORMAL_TIMEOUT").getValue().toString();
				
				MAX_VOICETOPPING = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("voicetoppinglimit").getValue().toString();
				VOICETOPPING_SUBINTIME = Boolean.valueOf(((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("voicetopping_subintime").getValue().toString());
							
				IN_SERVICERETAILERNAME = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("IN_SERVICERETAILERNAME").getValue().toString();				
				OMWEBSERVICE_LOGINCREDENTIAL = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("OMWEBSERVICE_LOGINCREDENTIAL").getValue().toString();
				
				//WEBSERVICE PARAMETER
				WHITELISTIP = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("WHITELISTIP").getValue().toString();
				MAPPINGOM = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("SMSMAPPING").getValue().split(",");	
				DESCRIPTIONMAPPINGOM = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("SMSMAPPINGDESCRIPTION").getValue().toString().split(",");		
				SMSSENDING = ((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("SMSSENDINGPARAMETER").getValue().toString().split(",");
				DEBUG  = Boolean.valueOf(((ApplicationConfigService)ctx.getBean("applicationconfigService")).get("DEBUG").getValue().toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}
	
		   
		    
		}	
}
