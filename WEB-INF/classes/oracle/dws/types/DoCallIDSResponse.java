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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"dsimsg"})
/*    */ @XmlRootElement(name="DoCallIDSResponse")
/*    */ public class DoCallIDSResponse
/*    */   extends DoComposeResponseBase
/*    */ {
/*    */   @XmlElement(name="DSIMSG", required=true)
/*    */   protected DSIMSG dsimsg;
/*    */   
/*    */   public DSIMSG getDSIMSG()
/*    */   {
/* 51 */     return this.dsimsg;
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
/* 63 */     this.dsimsg = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/DoCallIDSResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */