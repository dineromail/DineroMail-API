
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ResultGetPaymentTicket complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResultGetPaymentTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VoucherUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BarcodeImageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BarcodeDigits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UniqueMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{https://api.dineromail.com/}GetPaymentTicketStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultGetPaymentTicket", propOrder = {
    "transactionId",
    "voucherUrl",
    "barcodeImageUrl",
    "barcodeDigits",
    "merchantTransactionId",
    "message",
    "uniqueMessageId",
    "status"
})
public class ResultGetPaymentTicket {

    @XmlElement(name = "TransactionId")
    protected String transactionId;
    @XmlElement(name = "VoucherUrl")
    protected String voucherUrl;
    @XmlElement(name = "BarcodeImageUrl")
    protected String barcodeImageUrl;
    @XmlElement(name = "BarcodeDigits")
    protected String barcodeDigits;
    @XmlElement(name = "MerchantTransactionId")
    protected String merchantTransactionId;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "UniqueMessageId")
    protected String uniqueMessageId;
    @XmlElement(name = "Status", required = true)
    protected GetPaymentTicketStatus status;

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
     * Obtiene el valor de la propiedad voucherUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherUrl() {
        return voucherUrl;
    }

    /**
     * Define el valor de la propiedad voucherUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherUrl(String value) {
        this.voucherUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad barcodeImageUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcodeImageUrl() {
        return barcodeImageUrl;
    }

    /**
     * Define el valor de la propiedad barcodeImageUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcodeImageUrl(String value) {
        this.barcodeImageUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad barcodeDigits.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcodeDigits() {
        return barcodeDigits;
    }

    /**
     * Define el valor de la propiedad barcodeDigits.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcodeDigits(String value) {
        this.barcodeDigits = value;
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
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link GetPaymentTicketStatus }
     *     
     */
    public GetPaymentTicketStatus getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPaymentTicketStatus }
     *     
     */
    public void setStatus(GetPaymentTicketStatus value) {
        this.status = value;
    }

}
