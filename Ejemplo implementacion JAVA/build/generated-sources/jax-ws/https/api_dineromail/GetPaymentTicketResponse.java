
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetPaymentTicketResult" type="{https://api.dineromail.com/}ResultGetPaymentTicket" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getPaymentTicketResult"
})
@XmlRootElement(name = "GetPaymentTicketResponse")
public class GetPaymentTicketResponse {

    @XmlElement(name = "GetPaymentTicketResult")
    protected ResultGetPaymentTicket getPaymentTicketResult;

    /**
     * Obtiene el valor de la propiedad getPaymentTicketResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultGetPaymentTicket }
     *     
     */
    public ResultGetPaymentTicket getGetPaymentTicketResult() {
        return getPaymentTicketResult;
    }

    /**
     * Define el valor de la propiedad getPaymentTicketResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultGetPaymentTicket }
     *     
     */
    public void setGetPaymentTicketResult(ResultGetPaymentTicket value) {
        this.getPaymentTicketResult = value;
    }

}
