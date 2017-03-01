/*     */ package oracle.dws.types;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"code", "severity", "category", "description", "diagnosis"})
/*     */ @XmlRootElement(name="Error")
/*     */ public class Error
/*     */ {
/*     */   @XmlElement(name="Code", required=true)
/*     */   protected String code;
/*     */   @XmlElement(name="Severity", required=true)
/*     */   protected String severity;
/*     */   @XmlElement(name="Category", required=true)
/*     */   protected String category;
/*     */   @XmlElement(name="Description", required=true)
/*     */   protected String description;
/*     */   @XmlElement(name="Diagnosis", required=true)
/*     */   protected List<Diagnosis> diagnosis;
/*     */   
/*     */   public String getCode()
/*     */   {
/*  67 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCode(String value)
/*     */   {
/*  79 */     this.code = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSeverity()
/*     */   {
/*  91 */     return this.severity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSeverity(String value)
/*     */   {
/* 103 */     this.severity = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCategory()
/*     */   {
/* 115 */     return this.category;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCategory(String value)
/*     */   {
/* 127 */     this.category = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 139 */     return this.description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDescription(String value)
/*     */   {
/* 151 */     this.description = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Diagnosis> getDiagnosis()
/*     */   {
/* 177 */     if (this.diagnosis == null) {
/* 178 */       this.diagnosis = new ArrayList();
/*     */     }
/* 180 */     return this.diagnosis;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/Error.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */