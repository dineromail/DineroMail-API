
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ResultDoPaymentWithDirectBankTransfer complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResultDoPaymentWithDirectBankTransfer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UniqueMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Instructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{https://api.dineromail.com/}DoPaymentWithDirectBankTransferStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultDoPaymentWithDirectBankTransfer", propOrder = {
    "transactionId",
    "merchantTransactionId",
    "message",
    "uniqueMessageId",
    "instructions",
    "status"
})
public class ResultDoPaymentWithDirectBankTransfer {

    @XmlElement(name = "TransactionId")
    protected String transactionId;
    @XmlElement(name = "MerchantTransactionId")
    protected String merchantTransactionId;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "UniqueMessageId")
    protected String uniqueMessageId;
    @XmlElement(name = "Instructions")
    protected String instructions;
    @XmlElement(name = "Status", required = true)
    protected DoPaymentWithDirectBankTransferStatus status;

    /**
     * Obtiene el valor de la propiedad transactionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Define el valor de la propiedad transactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Obtiene el valor de la propiedad merchantTransactionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    /**
     * Define el valor de la propiedad merchantTransactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantTransactionId(String value) {
        this.merchantTransactionId = value;
    }

    /**
     * Obtiene el valor de la propiedad message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define el valor de la propiedad message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtiene el valor de la propiedad uniqueMessageId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueMessageId() {
        return uniqueMessageId;
    }

    /**
     * Define el valor de la propiedad uniqueMessageId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueMessageId(String value) {
        this.uniqueMessageId = value;
    }

    /**
     * Obtiene el valor de la propiedad instructions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Define el valor de la propiedad instructions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructions(String value) {
        this.instructions = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link DoPaymentWithDirectBankTransferStatus }
     *     
     */
    public DoPaymentWithDirectBankTransferStatus getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link DoPaymentWithDirectBankTransferStatus }
     *     
     */
    public void setStatus(DoPaymentWithDirectBankTransferStatus value) {
        this.status = value;
    }

}
