
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
 *         &lt;element name="UserRefundAccessResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "userRefundAccessResult"
})
@XmlRootElement(name = "UserRefundAccessResponse")
public class UserRefundAccessResponse {

    @XmlElement(name = "UserRefundAccessResult")
    protected boolean userRefundAccessResult;

    /**
     * Obtiene el valor de la propiedad userRefundAccessResult.
     * 
     */
    public boolean isUserRefundAccessResult() {
        return userRefundAccessResult;
    }

    /**
     * Define el valor de la propiedad userRefundAccessResult.
     * 
     */
    public void setUserRefundAccessResult(boolean value) {
        this.userRefundAccessResult = value;
    }

}
