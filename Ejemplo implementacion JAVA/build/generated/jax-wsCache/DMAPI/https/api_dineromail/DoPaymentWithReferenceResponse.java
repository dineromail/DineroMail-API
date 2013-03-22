
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
 *         &lt;element name="DoPaymentWithReferenceResult" type="{https://api.dineromail.com/}ResultDoPaymentWithReference" minOccurs="0"/>
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
    "doPaymentWithReferenceResult"
})
@XmlRootElement(name = "DoPaymentWithReferenceResponse")
public class DoPaymentWithReferenceResponse {

    @XmlElement(name = "DoPaymentWithReferenceResult")
    protected ResultDoPaymentWithReference doPaymentWithReferenceResult;

    /**
     * Obtiene el valor de la propiedad doPaymentWithReferenceResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultDoPaymentWithReference }
     *     
     */
    public ResultDoPaymentWithReference getDoPaymentWithReferenceResult() {
        return doPaymentWithReferenceResult;
    }

    /**
     * Define el valor de la propiedad doPaymentWithReferenceResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDoPaymentWithReference }
     *     
     */
    public void setDoPaymentWithReferenceResult(ResultDoPaymentWithReference value) {
        this.doPaymentWithReferenceResult = value;
    }

}
