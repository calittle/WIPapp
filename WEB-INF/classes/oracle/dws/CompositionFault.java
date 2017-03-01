/*    */ package oracle.dws;
/*    */ 
/*    */ import javax.xml.ws.WebFault;
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebFault(faultBean="oracle.dws.types.CompositionFault", targetNamespace="oracle/documaker/schema/ws/composition", name="CompositionFault")
/*    */ public class CompositionFault
/*    */   extends Exception
/*    */ {
/*    */   private oracle.dws.types.CompositionFault faultInfo;
/*    */   
/*    */   public CompositionFault(String message, oracle.dws.types.CompositionFault faultInfo)
/*    */   {
/* 15 */     super(message);
/* 16 */     this.faultInfo = faultInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CompositionFault(String message, oracle.dws.types.CompositionFault faultInfo, Throwable t)
/*    */   {
/* 23 */     super(message, t);
/* 24 */     this.faultInfo = faultInfo;
/*    */   }
/*    */   
/*    */   public oracle.dws.types.CompositionFault getFaultInfo()
/*    */   {
/* 29 */     return this.faultInfo;
/*    */   }
/*    */   
/*    */   public void setFaultInfo(oracle.dws.types.CompositionFault faultInfo)
/*    */   {
/* 34 */     this.faultInfo = faultInfo;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/CompositionFault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */