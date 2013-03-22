
package https.api_dineromail;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DoPaymentWithCreditCardThirdPartyStatus.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DoPaymentWithCreditCardThirdPartyStatus">
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
@XmlType(name = "DoPaymentWithCreditCardThirdPartyStatus")
@XmlEnum
public enum DoPaymentWithCreditCardThirdPartyStatus {

    COMPLETED,
    ERROR,
    DENIED,
    PENDING;

    public String value() {
        return name();
    }

    public static DoPaymentWithCreditCardThirdPartyStatus fromValue(String v) {
        return valueOf(v);
    }

}
