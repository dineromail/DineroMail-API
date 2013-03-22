
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
 *         &lt;element name="SendMoneyResult" type="{https://api.dineromail.com/}ResultSendMoney" minOccurs="0"/>
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
    "sendMoneyResult"
})
@XmlRootElement(name = "SendMoneyResponse")
public class SendMoneyResponse {

    @XmlElement(name = "SendMoneyResult")
    protected ResultSendMoney sendMoneyResult;

    /**
     * Obtiene el valor de la propiedad sendMoneyResult.
     * 
     * @return
     *     possible object is
     *     {@link ResultSendMoney }
     *     
     */
    public ResultSendMoney getSendMoneyResult() {
        return sendMoneyResult;
    }

    /**
     * Define el valor de la propiedad sendMoneyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultSendMoney }
     *     
     */
    public void setSendMoneyResult(ResultSendMoney value) {
        this.sendMoneyResult = value;
    }

}
