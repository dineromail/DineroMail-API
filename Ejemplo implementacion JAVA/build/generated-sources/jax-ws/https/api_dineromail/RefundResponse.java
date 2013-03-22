
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
 *         &lt;element name="RefundResult" type="{https://api.dineromail.com/}ResultRefund" minOccurs="0"/>
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
    "refundResult"
})
@XmlRootElement(name = "RefundResponse")
public class RefundResponse {

    @XmlElement(name = "RefundResult")
    protected ResultRefund refundResult;

    /**
     * Obtiene el valor de la propiedad refundResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultRefund }
     *     
     */
    public ResultRefund getRefundResult() {
        return refundResult;
    }

    /**
     * Define el valor de la propiedad refundResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultRefund }
     *     
     */
    public void setRefundResult(ResultRefund value) {
        this.refundResult = value;
    }

}
