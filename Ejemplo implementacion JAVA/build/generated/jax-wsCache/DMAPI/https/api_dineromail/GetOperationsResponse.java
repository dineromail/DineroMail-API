
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
 *         &lt;element name="GetOperationsResult" type="{https://api.dineromail.com/}ResultGetOperations" minOccurs="0"/>
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
    "getOperationsResult"
})
@XmlRootElement(name = "GetOperationsResponse")
public class GetOperationsResponse {

    @XmlElement(name = "GetOperationsResult")
    protected ResultGetOperations getOperationsResult;

    /**
     * Obtiene el valor de la propiedad getOperationsResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultGetOperations }
     *     
     */
    public ResultGetOperations getGetOperationsResult() {
        return getOperationsResult;
    }

    /**
     * Define el valor de la propiedad getOperationsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultGetOperations }
     *     
     */
    public void setGetOperationsResult(ResultGetOperations value) {
        this.getOperationsResult = value;
    }

}
