
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
 *         &lt;element name="Credential" type="{https://api.dineromail.com/}APICredential" minOccurs="0"/>
 *         &lt;element name="Crypt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MerchantTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressDetail" type="{https://api.dineromail.com/}AddressDetail" minOccurs="0"/>
 *         &lt;element name="BankAccountDetail" type="{https://api.dineromail.com/}BankAccountDetail" minOccurs="0"/>
 *         &lt;element name="UniqueMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Hash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "credential",
    "crypt",
    "merchantTransactionId",
    "method",
    "currency",
    "amount",
    "addressDetail",
    "bankAccountDetail",
    "uniqueMessageId",
    "hash"
})
@XmlRootElement(name = "DoWithDraw")
public class DoWithDraw {

    @XmlElement(name = "Credential")
    protected APICredential credential;
    @XmlElement(name = "Crypt")
    protected boolean crypt;
    @XmlElement(name = "MerchantTransactionId")
    protected String merchantTransactionId;
    @XmlElement(name = "Method")
    protected String method;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "Amount")
    protected String amount;
    @XmlElement(name = "AddressDetail")
    protected AddressDetail addressDetail;
    @XmlElement(name = "BankAccountDetail")
    protected BankAccountDetail bankAccountDetail;
    @XmlElement(name = "UniqueMessageId")
    protected String uniqueMessageId;
    @XmlElement(name = "Hash")
    protected String hash;

    /**
     * Obtiene el valor de la propiedad credential.
     * 
     * @return
     *     possible object is
     *     {@link APICredential }
     *     
     */
    public APICredential getCredential() {
        return credential;
    }

    /**
     * Define el valor de la propiedad credential.
     * 
     * @param value
     *     allowed object is
     *     {@link APICredential }
     *     
     */
    public void setCredential(APICredential value) {
        this.credential = value;
    }

    /**
     * Obtiene el valor de la propiedad crypt.
     * 
     */
    public boolean isCrypt() {
        return crypt;
    }

    /**
     * Define el valor de la propiedad crypt.
     * 
     */
    public void setCrypt(boolean value) {
        this.crypt = value;
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
     * Obtiene el valor de la propiedad method.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Define el valor de la propiedad method.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
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
     * Obtiene el valor de la propiedad addressDetail.
     * 
     * @return
     *     possible object is
     *     {@link AddressDetail }
     *     
     */
    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    /**
     * Define el valor de la propiedad addressDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressDetail }
     *     
     */
    public void setAddressDetail(AddressDetail value) {
        this.addressDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad bankAccountDetail.
     * 
     * @return
     *     possible object is
     *     {@link BankAccountDetail }
     *     
     */
    public BankAccountDetail getBankAccountDetail() {
        return bankAccountDetail;
    }

    /**
     * Define el valor de la propiedad bankAccountDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccountDetail }
     *     
     */
    public void setBankAccountDetail(BankAccountDetail value) {
        this.bankAccountDetail = value;
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
     * Obtiene el valor de la propiedad hash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHash() {
        return hash;
    }

    /**
     * Define el valor de la propiedad hash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHash(String value) {
        this.hash = value;
    }

}
