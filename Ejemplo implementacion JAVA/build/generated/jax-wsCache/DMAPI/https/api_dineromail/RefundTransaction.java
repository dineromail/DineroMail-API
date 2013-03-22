
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RefundTransaction complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RefundTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UniqueMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{https://api.dineromail.com/}RefundTransactionStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundTransaction", propOrder = {
    "merchantTransactionId",
    "currency",
    "country",
    "subject",
    "message",
    "uniqueMessageId",
    "amount",
    "status"
})
public class RefundTransaction {

    @XmlElement(name = "MerchantTransactionId")
    protected String merchantTransactionId;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "Subject")
    protected String subject;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "UniqueMessageId")
    protected String uniqueMessageId;
    @XmlElement(name = "Amount")
    protected String amount;
    @XmlElement(name = "Status", required = true)
    protected RefundTransactionStatus status;

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
     * Obtiene el valor de la propiedad currency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Define el valor de la propiedad currency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad subject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Define el valor de la propiedad subject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
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
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link RefundTransactionStatus }
     *     
     */
    public RefundTransactionStatus getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundTransactionStatus }
     *     
     */
    public void setStatus(RefundTransactionStatus value) {
        this.status = value;
    }

}
