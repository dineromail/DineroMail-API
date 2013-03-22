
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
 *         &lt;element name="DoPaymentWithCreditCardResult" type="{https://api.dineromail.com/}ResultDoPaymentWithCreditCard" minOccurs="0"/>
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
    "doPaymentWithCreditCardResult"
})
@XmlRootElement(name = "DoPaymentWithCreditCardResponse")
public class DoPaymentWithCreditCardResponse {

    @XmlElement(name = "DoPaymentWithCreditCardResult")
    protected ResultDoPaymentWithCreditCard doPaymentWithCreditCardResult;

    /**
     * Obtiene el valor de la propiedad doPaymentWithCreditCardResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultDoPaymentWithCreditCard }
     *     
     */
    public ResultDoPaymentWithCreditCard getDoPaymentWithCreditCardResult() {
        return doPaymentWithCreditCardResult;
    }

    /**
     * Define el valor de la propiedad doPaymentWithCreditCardResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDoPaymentWithCreditCard }
     *     
     */
    public void setDoPaymentWithCreditCardResult(ResultDoPaymentWithCreditCard value) {
        this.doPaymentWithCreditCardResult = value;
    }

}
