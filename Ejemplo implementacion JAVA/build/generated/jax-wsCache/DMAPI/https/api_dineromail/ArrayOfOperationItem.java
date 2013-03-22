
package https.api_dineromail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfOperationItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOperationItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationItem" type="{https://api.dineromail.com/}OperationItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOperationItem", propOrder = {
    "operationItem"
})
public class ArrayOfOperationItem {

    @XmlElement(name = "OperationItem", nillable = true)
    protected List<OperationItem> operationItem;

    /**
     * Gets the value of the operationItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationItem }
     * 
     * 
     */
    public List<OperationItem> getOperationItem() {
        if (operationItem == null) {
            operationItem = new ArrayList<OperationItem>();
        }
        return this.operationItem;
    }

}
