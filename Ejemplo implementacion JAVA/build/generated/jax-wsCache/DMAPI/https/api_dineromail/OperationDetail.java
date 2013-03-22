
package https.api_dineromail;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para OperationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OperationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="State" type="{https://api.dineromail.com/}OperationDetailState"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Buyer" type="{https://api.dineromail.com/}OperationBuyer" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NetAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Shares" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Items" type="{https://api.dineromail.com/}ArrayOfOperationItem" minOccurs="0"/>
 *         &lt;element name="Seller" type="{https://api.dineromail.com/}OperationSeller" minOccurs="0"/>
 *         &lt;element name="CurrencyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationDetail", propOrder = {
    "id",
    "date",
    "state",
    "number",
    "buyer",
    "amount",
    "netAmount",
    "paymentMethod",
    "shares",
    "items",
    "seller",
    "currencyId"
})
public class OperationDetail {

    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "State", required = true)
    protected OperationDetailState state;
    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "Buyer")
    protected OperationBuyer buyer;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "NetAmount", required = true)
    protected BigDecimal netAmount;
    @XmlElement(name = "PaymentMethod")
    protected String paymentMethod;
    @XmlElement(name = "Shares")
    protected String shares;
    @XmlElement(name = "Items")
    protected ArrayOfOperationItem items;
    @XmlElement(name = "Seller")
    protected OperationSeller seller;
    @XmlElement(name = "CurrencyId")
    protected int currencyId;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link OperationDetailState }
     *     
     */
    public OperationDetailState getState() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationDetailState }
     *     
     */
    public void setState(OperationDetailState value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad number.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Define el valor de la propiedad number.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Obtiene el valor de la propiedad buyer.
     * 
     * @return
     *     possible object is
     *     {@link OperationBuyer }
     *     
     */
    public OperationBuyer getBuyer() {
        return buyer;
    }

    /**
     * Define el valor de la propiedad buyer.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationBuyer }
     *     
     */
    public void setBuyer(OperationBuyer value) {
        this.buyer = value;
    }

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad netAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    /**
     * Define el valor de la propiedad netAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetAmount(BigDecimal value) {
        this.netAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentMethod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Define el valor de la propiedad paymentMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad shares.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShares() {
        return shares;
    }

    /**
     * Define el valor de la propiedad shares.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShares(String value) {
        this.shares = value;
    }

    /**
     * Obtiene el valor de la propiedad items.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOperationItem }
     *     
     */
    public ArrayOfOperationItem getItems() {
        return items;
    }

    /**
     * Define el valor de la propiedad items.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOperationItem }
     *     
     */
    public void setItems(ArrayOfOperationItem value) {
        this.items = value;
    }

    /**
     * Obtiene el valor de la propiedad seller.
     * 
     * @return
     *     possible object is
     *     {@link OperationSeller }
     *     
     */
    public OperationSeller getSeller() {
        return seller;
    }

    /**
     * Define el valor de la propiedad seller.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationSeller }
     *     
     */
    public void setSeller(OperationSeller value) {
        this.seller = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyId.
     * 
     */
    public int getCurrencyId() {
        return currencyId;
    }

    /**
     * Define el valor de la propiedad currencyId.
     * 
     */
    public void setCurrencyId(int value) {
        this.currencyId = value;
    }

}
