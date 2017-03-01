/*    */ package oracle.dws;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServiceClient(wsdlLocation="http://192.168.1.72:7001/DWSV0AL1/CompositionService?WSDL", targetNamespace="oracle/documaker/schema/ws/composition", name="CompositionService")
/*    */ public class CompositionService
/*    */   extends Service
/*    */ {
/*    */   private static URL wsdlLocationURL;
/*    */   private static Logger logger;
/*    */   
/*    */   static
/*    */   {
/*    */     try
/*    */     {
/* 34 */       logger = Logger.getLogger("oracle.dws.CompositionService");
/* 35 */       URL baseUrl = CompositionService.class.getResource(".");
/* 36 */       if (baseUrl == null)
/*    */       {
/* 38 */         wsdlLocationURL = CompositionService.class.getResource("http://192.168.1.72:7001/DWSV0AL1/CompositionService?WSDL");
/*    */         
/* 40 */         if (wsdlLocationURL == null)
/*    */         {
/* 42 */           baseUrl = new File(".").toURL();
/* 43 */           wsdlLocationURL = new URL(baseUrl, "http://192.168.1.72:7001/DWSV0AL1/CompositionService?WSDL");
/*    */         }
/*    */         
/*    */       }
/*    */       else
/*    */       {
/* 49 */         if (!baseUrl.getPath().endsWith("/")) {
/* 50 */           baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
/*    */         }
/* 52 */         wsdlLocationURL = new URL(baseUrl, "http://192.168.1.72:7001/DWSV0AL1/CompositionService?WSDL");
/*    */       }
/*    */       
/*    */     }
/*    */     catch (MalformedURLException e)
/*    */     {
/* 58 */       logger.log(Level.ALL, "Failed to create wsdlLocationURL using http://192.168.1.72:7001/DWSV0AL1/CompositionService?WSDL", e);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CompositionService()
/*    */   {
/* 66 */     super(wsdlLocationURL, new QName("oracle/documaker/schema/ws/composition", "CompositionService"));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CompositionService(URL wsdlLocation, QName serviceName)
/*    */   {
/* 73 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   @WebEndpoint(name="CompositionServicePort")
/*    */   public CompositionServicePortType getCompositionServicePort()
/*    */   {
/* 79 */     return (CompositionServicePortType)super.getPort(new QName("oracle/documaker/schema/ws/composition", "CompositionServicePort"), CompositionServicePortType.class);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @WebEndpoint(name="CompositionServicePort")
/*    */   public CompositionServicePortType getCompositionServicePort(WebServiceFeature... features)
/*    */   {
/* 87 */     return (CompositionServicePortType)super.getPort(new QName("oracle/documaker/schema/ws/composition", "CompositionServicePort"), CompositionServicePortType.class, features);
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/CompositionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */