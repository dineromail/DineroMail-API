
package https.api_dineromail;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DoPaymentWithCreditCardStatus.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DoPaymentWithCreditCardStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="DENIED"/>
 *     &lt;enumeration value="PENDING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoPaymentWithCreditCardStatus")
@XmlEnum
public enum DoPaymentWithCreditCardStatus {

    COMPLETED,
    ERROR,
    DENIED,
    PENDING;

    public String value() {
        return name();
    }

    public static DoPaymentWithCreditCardStatus fromValue(String v) {
        return valueOf(v);
    }

}
