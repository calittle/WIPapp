/*    */ package oracle.dws.types;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlSeeAlso;
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
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="doComposeResponseBase", propOrder={"results", "serviceTimeMillis"})
/*    */ @XmlSeeAlso({DoCallIDSResponse.class})
/*    */ public abstract class DoComposeResponseBase
/*    */ {
/*    */   @XmlElement(name="Results", required=true)
/*    */   protected Results results;
/*    */   @XmlElement(name="ServiceTimeMillis", namespace="oracle/documaker/schema/common")
/*    */   protected long serviceTimeMillis;
/*    */   
/*    */   public Results getResults()
/*    */   {
/* 55 */     return this.results;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setResults(Results value)
/*    */   {
/* 67 */     this.results = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getServiceTimeMillis()
/*    */   {
/* 75 */     return this.serviceTimeMillis;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setServiceTimeMillis(long value)
/*    */   {
/* 83 */     this.serviceTimeMillis = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/DoComposeResponseBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */