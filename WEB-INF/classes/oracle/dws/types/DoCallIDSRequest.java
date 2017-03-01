/*    */ package oracle.dws.types;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.XmlType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"dsimsg", "responseProperties"})
/*    */ @XmlRootElement(name="DoCallIDSRequest")
/*    */ public class DoCallIDSRequest
/*    */   extends DoComposeRequestBase
/*    */ {
/*    */   @XmlElement(name="DSIMSG", required=true)
/*    */   protected DSIMSG dsimsg;
/*    */   @XmlElement(name="ResponseProperties")
/*    */   protected ResponseProperties responseProperties;
/*    */   
/*    */   public DSIMSG getDSIMSG()
/*    */   {
/* 55 */     return this.dsimsg;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setDSIMSG(DSIMSG value)
/*    */   {
/* 67 */     this.dsimsg = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ResponseProperties getResponseProperties()
/*    */   {
/* 79 */     return this.responseProperties;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setResponseProperties(ResponseProperties value)
/*    */   {
/* 91 */     this.responseProperties = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/DoCallIDSRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */