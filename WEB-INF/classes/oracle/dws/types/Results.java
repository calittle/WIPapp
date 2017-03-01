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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="", propOrder={"result", "errors"})
/*    */ @XmlRootElement(name="Results")
/*    */ public class Results
/*    */ {
/*    */   @XmlElement(name="Result", namespace="oracle/documaker/schema/common")
/*    */   protected int result;
/*    */   @XmlElement(name="Errors")
/*    */   protected Errors errors;
/*    */   
/*    */   public int getResult()
/*    */   {
/* 49 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setResult(int value)
/*    */   {
/* 57 */     this.result = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Errors getErrors()
/*    */   {
/* 69 */     return this.errors;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setErrors(Errors value)
/*    */   {
/* 81 */     this.errors = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/Results.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */