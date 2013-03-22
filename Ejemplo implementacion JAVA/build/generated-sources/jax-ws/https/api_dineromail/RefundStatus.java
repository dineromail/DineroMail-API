
package https.api_dineromail;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RefundStatus.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="RefundStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="DENIED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RefundStatus")
@XmlEnum
public enum RefundStatus {

    COMPLETED,
    PENDING,
    ERROR,
    DENIED;

    public String value() {
        return name();
    }

    public static RefundStatus fromValue(String v) {
        return valueOf(v);
    }

}
