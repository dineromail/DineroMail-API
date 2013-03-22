
package https.api_dineromail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfOperationDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOperationDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationDetail" type="{https://api.dineromail.com/}OperationDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOperationDetail", propOrder = {
    "operationDetail"
})
public class ArrayOfOperationDetail {

    @XmlElement(name = "OperationDetail", nillable = true)
    protected List<OperationDetail> operationDetail;

    /**
     * Gets the value of the operationDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationDetail }
     * 
     * 
     */
    public List<OperationDetail> getOperationDetail() {
        if (operationDetail == null) {
            operationDetail = new ArrayList<OperationDetail>();
        }
        return this.operationDetail;
    }

}
