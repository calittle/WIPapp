/*     */ package oracle.dws.types;
/*     */ 
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"http", "mq", "msmq", "jms"})
/*     */ @XmlRootElement(name="Properties")
/*     */ public class Properties
/*     */ {
/*     */   @XmlElement(name="HTTP")
/*     */   protected HTTP http;
/*     */   @XmlElement(name="MQ")
/*     */   protected MQ mq;
/*     */   @XmlElement(name="MSMQ")
/*     */   protected MSMQ msmq;
/*     */   @XmlElement(name="JMS")
/*     */   protected JMS jms;
/*     */   
/*     */   public HTTP getHTTP()
/*     */   {
/*  61 */     return this.http;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHTTP(HTTP value)
/*     */   {
/*  73 */     this.http = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MQ getMQ()
/*     */   {
/*  85 */     return this.mq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMQ(MQ value)
/*     */   {
/*  97 */     this.mq = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MSMQ getMSMQ()
/*     */   {
/* 109 */     return this.msmq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMSMQ(MSMQ value)
/*     */   {
/* 121 */     this.msmq = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JMS getJMS()
/*     */   {
/* 133 */     return this.jms;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJMS(JMS value)
/*     */   {
/* 145 */     this.jms = value;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/Properties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */