
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ResultGetRefundStatus complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResultGetRefundStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{https://api.dineromail.com/}ResultGetRefundStatusStatus"/>
 *         &lt;element name="MerchantTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UniqueMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefundTransactions" type="{https://api.dineromail.com/}ArrayOfRefundTransaction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultGetRefundStatus", propOrder = {
    "status",
    "merchantTransactionId",
    "message",
    "uniqueMessageId",
    "refundTransactions"
})
public class ResultGetRefundStatus {

    @XmlElement(name = "Status", required = true)
    protected ResultGetRefundStatusStatus status;
    @XmlElement(name = "MerchantTransactionId")
    protected String merchantTransactionId;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "UniqueMessageId")
    protected String uniqueMessageId;
    @XmlElement(name = "RefundTransactions")
    protected ArrayOfRefundTransaction refundTransactions;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link ResultGetRefundStatusStatus }
     *     
     */
    public ResultGetRefundStatusStatus getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultGetRefundStatusStatus }
     *     
     */
    public void setStatus(ResultGetRefundStatusStatus value) {
        this.status = value;
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
     * Obtiene el valor de la propiedad refundTransactions.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRefundTransaction }
     *     
     */
    public ArrayOfRefundTransaction getRefundTransactions() {
        return refundTransactions;
    }

    /**
     * Define el valor de la propiedad refundTransactions.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRefundTransaction }
     *     
     */
    public void setRefundTransactions(ArrayOfRefundTransaction value) {
        this.refundTransactions = value;
    }

}
