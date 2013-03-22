
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
 *         &lt;element name="DoPaymentWithDirectBankTransferResult" type="{https://api.dineromail.com/}ResultDoPaymentWithDirectBankTransfer" minOccurs="0"/>
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
    "doPaymentWithDirectBankTransferResult"
})
@XmlRootElement(name = "DoPaymentWithDirectBankTransferResponse")
public class DoPaymentWithDirectBankTransferResponse {

    @XmlElement(name = "DoPaymentWithDirectBankTransferResult")
    protected ResultDoPaymentWithDirectBankTransfer doPaymentWithDirectBankTransferResult;

    /**
     * Obtiene el valor de la propiedad doPaymentWithDirectBankTransferResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultDoPaymentWithDirectBankTransfer }
     *     
     */
    public ResultDoPaymentWithDirectBankTransfer getDoPaymentWithDirectBankTransferResult() {
        return doPaymentWithDirectBankTransferResult;
    }

    /**
     * Define el valor de la propiedad doPaymentWithDirectBankTransferResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDoPaymentWithDirectBankTransfer }
     *     
     */
    public void setDoPaymentWithDirectBankTransferResult(ResultDoPaymentWithDirectBankTransfer value) {
        this.doPaymentWithDirectBankTransferResult = value;
    }

}
