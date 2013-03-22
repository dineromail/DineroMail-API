
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
 *         &lt;element name="DoPaymentWithCreditCardThirdPartyResult" type="{https://api.dineromail.com/}ResultDoPaymentWithCreditCardThirdParty" minOccurs="0"/>
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
    "doPaymentWithCreditCardThirdPartyResult"
})
@XmlRootElement(name = "DoPaymentWithCreditCardThirdPartyResponse")
public class DoPaymentWithCreditCardThirdPartyResponse {

    @XmlElement(name = "DoPaymentWithCreditCardThirdPartyResult")
    protected ResultDoPaymentWithCreditCardThirdParty doPaymentWithCreditCardThirdPartyResult;

    /**
     * Obtiene el valor de la propiedad doPaymentWithCreditCardThirdPartyResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultDoPaymentWithCreditCardThirdParty }
     *     
     */
    public ResultDoPaymentWithCreditCardThirdParty getDoPaymentWithCreditCardThirdPartyResult() {
        return doPaymentWithCreditCardThirdPartyResult;
    }

    /**
     * Define el valor de la propiedad doPaymentWithCreditCardThirdPartyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDoPaymentWithCreditCardThirdParty }
     *     
     */
    public void setDoPaymentWithCreditCardThirdPartyResult(ResultDoPaymentWithCreditCardThirdParty value) {
        this.doPaymentWithCreditCardThirdPartyResult = value;
    }

}
