
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CreditCard complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CreditCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Installment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Holder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressComplement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Neighborhood" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCard", propOrder = {
    "installment",
    "creditCardNumber",
    "holder",
    "expirationDate",
    "securityCode",
    "documentNumber",
    "address",
    "addressNumber",
    "addressComplement",
    "zipCode",
    "neighborhood",
    "city",
    "state",
    "country",
    "bankId"
})
public class CreditCard {

    @XmlElement(name = "Installment")
    protected String installment;
    @XmlElement(name = "CreditCardNumber")
    protected String creditCardNumber;
    @XmlElement(name = "Holder")
    protected String holder;
    @XmlElement(name = "ExpirationDate")
    protected String expirationDate;
    @XmlElement(name = "SecurityCode")
    protected String securityCode;
    @XmlElement(name = "DocumentNumber")
    protected String documentNumber;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "AddressNumber")
    protected String addressNumber;
    @XmlElement(name = "AddressComplement")
    protected String addressComplement;
    @XmlElement(name = "ZipCode")
    protected String zipCode;
    @XmlElement(name = "Neighborhood")
    protected String neighborhood;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "BankId", defaultValue = "0")
    protected Integer bankId;

    /**
     * Obtiene el valor de la propiedad installment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstallment() {
        return installment;
    }

    /**
     * Define el valor de la propiedad installment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstallment(String value) {
        this.installment = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCardNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Define el valor de la propiedad creditCardNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardNumber(String value) {
        this.creditCardNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad holder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHolder() {
        return holder;
    }

    /**
     * Define el valor de la propiedad holder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHolder(String value) {
        this.holder = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Define el valor de la propiedad expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad securityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityCode() {
        return securityCode;
    }

    /**
     * Define el valor de la propiedad securityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityCode(String value) {
        this.securityCode = value;
    }

    /**
     * Obtiene el valor de la propiedad documentNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Define el valor de la propiedad documentNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNumber(String value) {
        this.documentNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define el valor de la propiedad address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Obtiene el valor de la propiedad addressNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     * Define el valor de la propiedad addressNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressNumber(String value) {
        this.addressNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad addressComplement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressComplement() {
        return addressComplement;
    }

    /**
     * Define el valor de la propiedad addressComplement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressComplement(String value) {
        this.addressComplement = value;
    }

    /**
     * Obtiene el valor de la propiedad zipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Define el valor de la propiedad zipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Obtiene el valor de la propiedad neighborhood.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Define el valor de la propiedad neighborhood.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeighborhood(String value) {
        this.neighborhood = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
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
     * Obtiene el valor de la propiedad bankId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBankId() {
        return bankId;
    }

    /**
     * Define el valor de la propiedad bankId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBankId(Integer value) {
        this.bankId = value;
    }

}
