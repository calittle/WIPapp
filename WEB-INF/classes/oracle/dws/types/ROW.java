/*    */ package oracle.dws.types;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlAttribute;
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
/*    */ @XmlType(name="", propOrder={"var"})
/*    */ @XmlRootElement(name="ROW")
/*    */ public class ROW
/*    */ {
/*    */   @XmlElement(name="VAR", required=true)
/*    */   protected List<VAR> var;
/*    */   @XmlAttribute(name="NUM", required=true)
/*    */   protected int num;
/*    */   
/*    */   public List<VAR> getVAR()
/*    */   {
/* 69 */     if (this.var == null) {
/* 70 */       this.var = new ArrayList();
/*    */     }
/* 72 */     return this.var;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNUM()
/*    */   {
/* 80 */     return this.num;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setNUM(int value)
/*    */   {
/* 88 */     this.num = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/ROW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */