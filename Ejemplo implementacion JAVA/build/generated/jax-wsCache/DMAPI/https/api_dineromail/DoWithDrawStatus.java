
package https.api_dineromail;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DoWithDrawStatus.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="DoWithDrawStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="DENIED"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="PROCESING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoWithDrawStatus")
@XmlEnum
public enum DoWithDrawStatus {

    COMPLETED,
    ERROR,
    DENIED,
    PENDING,
    PROCESING;

    public String value() {
        return name();
    }

    public static DoWithDrawStatus fromValue(String v) {
        return valueOf(v);
    }

}
