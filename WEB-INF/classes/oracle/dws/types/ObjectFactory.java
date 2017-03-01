/*     */ package oracle.dws.types;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
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
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  27 */   private static final QName _Result_QNAME = new QName("oracle/documaker/schema/common", "Result");
/*  28 */   private static final QName _ServiceTimeMillis_QNAME = new QName("oracle/documaker/schema/common", "ServiceTimeMillis");
/*  29 */   private static final QName _CompositionFault_QNAME = new QName("oracle/documaker/schema/ws/composition", "CompositionFault");
/*  30 */   private static final QName _Password_QNAME = new QName("oracle/documaker/schema/common", "Password");
/*  31 */   private static final QName _UniqueId_QNAME = new QName("oracle/documaker/schema/common", "UniqueId");
/*  32 */   private static final QName _UserId_QNAME = new QName("oracle/documaker/schema/common", "UserId");
/*  33 */   private static final QName _Priority_QNAME = new QName("oracle/documaker/schema/common", "Priority");
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
/*     */   public HTTP createHTTP()
/*     */   {
/*  47 */     return new HTTP();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Property createProperty()
/*     */   {
/*  55 */     return new Property();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ROW createROW()
/*     */   {
/*  63 */     return new ROW();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public VAR createVAR()
/*     */   {
/*  71 */     return new VAR();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public JMS createJMS()
/*     */   {
/*  79 */     return new JMS();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Errors createErrors()
/*     */   {
/*  87 */     return new Errors();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Error createError()
/*     */   {
/*  95 */     return new Error();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Diagnosis createDiagnosis()
/*     */   {
/* 103 */     return new Diagnosis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DoCallIDSRequest createDoCallIDSRequest()
/*     */   {
/* 111 */     return new DoCallIDSRequest();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Properties createProperties()
/*     */   {
/* 119 */     return new Properties();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MQ createMQ()
/*     */   {
/* 127 */     return new MQ();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MSMQ createMSMQ()
/*     */   {
/* 135 */     return new MSMQ();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DSIMSG createDSIMSG()
/*     */   {
/* 143 */     return new DSIMSG();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MSGVARS createMSGVARS()
/*     */   {
/* 151 */     return new MSGVARS();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ROWSET createROWSET()
/*     */   {
/* 159 */     return new ROWSET();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Attachment createAttachment()
/*     */   {
/* 167 */     return new Attachment();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Content createContent()
/*     */   {
/* 175 */     return new Content();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ResponseProperties createResponseProperties()
/*     */   {
/* 183 */     return new ResponseProperties();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CompositionFault createCompositionFault()
/*     */   {
/* 191 */     return new CompositionFault();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DoCallIDSResponse createDoCallIDSResponse()
/*     */   {
/* 199 */     return new DoCallIDSResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Results createResults()
/*     */   {
/* 207 */     return new Results();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DoCallIDSOneWayRequest createDoCallIDSOneWayRequest()
/*     */   {
/* 215 */     return new DoCallIDSOneWayRequest();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ResponseAttachment createResponseAttachment()
/*     */   {
/* 223 */     return new ResponseAttachment();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/common", name="Result")
/*     */   public JAXBElement<Integer> createResult(Integer value)
/*     */   {
/* 232 */     return new JAXBElement(_Result_QNAME, Integer.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/common", name="ServiceTimeMillis")
/*     */   public JAXBElement<Long> createServiceTimeMillis(Long value)
/*     */   {
/* 241 */     return new JAXBElement(_ServiceTimeMillis_QNAME, Long.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/ws/composition", name="CompositionFault")
/*     */   public JAXBElement<CompositionFault> createCompositionFault(CompositionFault value)
/*     */   {
/* 250 */     return new JAXBElement(_CompositionFault_QNAME, CompositionFault.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/common", name="Password")
/*     */   public JAXBElement<String> createPassword(String value)
/*     */   {
/* 259 */     return new JAXBElement(_Password_QNAME, String.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/common", name="UniqueId")
/*     */   public JAXBElement<String> createUniqueId(String value)
/*     */   {
/* 268 */     return new JAXBElement(_UniqueId_QNAME, String.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/common", name="UserId")
/*     */   public JAXBElement<String> createUserId(String value)
/*     */   {
/* 277 */     return new JAXBElement(_UserId_QNAME, String.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="oracle/documaker/schema/common", name="Priority")
/*     */   public JAXBElement<Integer> createPriority(Integer value)
/*     */   {
/* 286 */     return new JAXBElement(_Priority_QNAME, Integer.class, null, value);
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */