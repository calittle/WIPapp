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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"var", "rowset"})
/*     */ @XmlRootElement(name="MSGVARS")
/*     */ public class MSGVARS
/*     */ {
/*     */   @XmlElement(name="VAR")
/*     */   protected List<VAR> var;
/*     */   @XmlElement(name="ROWSET")
/*     */   protected List<ROWSET> rowset;
/*     */   
/*     */   public List<VAR> getVAR()
/*     */   {
/*  69 */     if (this.var == null) {
/*  70 */       this.var = new ArrayList();
/*     */     }
/*  72 */     return this.var;
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
/*     */   public List<ROWSET> getROWSET()
/*     */   {
/*  98 */     if (this.rowset == null) {
/*  99 */       this.rowset = new ArrayList();
/*     */     }
/* 101 */     return this.rowset;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/MSGVARS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */