package oracle.dws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import oracle.dws.types.DoCallIDSOneWayRequest;
import oracle.dws.types.DoCallIDSRequest;
import oracle.dws.types.DoCallIDSResponse;
import oracle.dws.types.ObjectFactory;

@WebService(wsdlLocation="http://192.168.1.72:7001/DWSV0AL1/CompositionService?WSDL", targetNamespace="oracle/documaker/schema/ws/composition", name="CompositionServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, parameterStyle=SOAPBinding.ParameterStyle.BARE)
public abstract interface CompositionServicePortType
{
  @WebMethod(action="doCallIDS")
  @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
  @Action(input="doCallIDS", fault={@javax.xml.ws.FaultAction(value="oracle/documaker/schema/ws/composition/CompositionServicePortType/doCallIDS/Fault/CompositionFault", className=CompositionFault.class)}, output="oracle/documaker/schema/ws/composition/CompositionServicePortType/doCallIDSResponse")
  @WebResult(targetNamespace="oracle/documaker/schema/ws/composition", partName="DoCallIDSResponse", name="DoCallIDSResponse")
  public abstract DoCallIDSResponse doCallIDS(@WebParam(targetNamespace="oracle/documaker/schema/ws/composition", partName="DoCallIDSRequest", name="DoCallIDSRequest") DoCallIDSRequest paramDoCallIDSRequest)
    throws CompositionFault;
  
  @WebMethod(action="doCallIDSOneWay")
  @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
  @Action(input="doCallIDSOneWay")
  @Oneway
  public abstract void doCallIDSOneWay(@WebParam(targetNamespace="oracle/documaker/schema/ws/composition", partName="DoCallIDSOneWayRequest", name="DoCallIDSOneWayRequest") DoCallIDSOneWayRequest paramDoCallIDSOneWayRequest);
}


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/CompositionServicePortType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */