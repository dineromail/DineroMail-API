
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
    "uniqueMessageId",
    "hash"
})
@XmlRootElement(name = "GetBalance")
public class GetBalance {

    @XmlElement(name = "Credential")
    protected APICredential credential;
    @XmlElement(name = "Crypt")
    protected boolean crypt;
    @XmlElement(name = "MerchantTransactionId")
    protected String merchantTransactionId;
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
