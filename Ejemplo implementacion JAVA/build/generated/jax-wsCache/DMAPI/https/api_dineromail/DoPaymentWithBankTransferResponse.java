
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
 *         &lt;element name="DoPaymentWithBankTransferResult" type="{https://api.dineromail.com/}ResultDoPaymentWithBankTransfer" minOccurs="0"/>
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
    "doPaymentWithBankTransferResult"
})
@XmlRootElement(name = "DoPaymentWithBankTransferResponse")
public class DoPaymentWithBankTransferResponse {

    @XmlElement(name = "DoPaymentWithBankTransferResult")
    protected ResultDoPaymentWithBankTransfer doPaymentWithBankTransferResult;

    /**
     * Obtiene el valor de la propiedad doPaymentWithBankTransferResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultDoPaymentWithBankTransfer }
     *     
     */
    public ResultDoPaymentWithBankTransfer getDoPaymentWithBankTransferResult() {
        return doPaymentWithBankTransferResult;
    }

    /**
     * Define el valor de la propiedad doPaymentWithBankTransferResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDoPaymentWithBankTransfer }
     *     
     */
    public void setDoPaymentWithBankTransferResult(ResultDoPaymentWithBankTransfer value) {
        this.doPaymentWithBankTransferResult = value;
    }

}
