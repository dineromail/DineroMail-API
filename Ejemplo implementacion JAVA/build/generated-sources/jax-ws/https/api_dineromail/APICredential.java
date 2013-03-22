
package https.api_dineromail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para APICredential complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="APICredential">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APIUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APIPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userPrefs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMOTE_HOST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_ACCEPT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_ACCEPT_ENCODING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_ACCEPT_CHARSET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_USER_AGENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_ACCEPT_LANGUAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMOTE_ADDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_REFERER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HTTP_CONNECTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APICredential", propOrder = {
    "apiUserName",
    "apiPassword",
    "userPrefs",
    "sessionID",
    "remotehost",
    "httpaccept",
    "httpacceptencoding",
    "httpacceptcharset",
    "httpuseragent",
    "httpacceptlanguage",
    "remoteaddr",
    "httpreferer",
    "httpconnection"
})
public class APICredential {

    @XmlElement(name = "APIUserName")
    protected String apiUserName;
    @XmlElement(name = "APIPassword")
    protected String apiPassword;
    protected String userPrefs;
    @XmlElement(name = "SessionID")
    protected String sessionID;
    @XmlElement(name = "REMOTE_HOST")
    protected String remotehost;
    @XmlElement(name = "HTTP_ACCEPT")
    protected String httpaccept;
    @XmlElement(name = "HTTP_ACCEPT_ENCODING")
    protected String httpacceptencoding;
    @XmlElement(name = "HTTP_ACCEPT_CHARSET")
    protected String httpacceptcharset;
    @XmlElement(name = "HTTP_USER_AGENT")
    protected String httpuseragent;
    @XmlElement(name = "HTTP_ACCEPT_LANGUAGE")
    protected String httpacceptlanguage;
    @XmlElement(name = "REMOTE_ADDR")
    protected String remoteaddr;
    @XmlElement(name = "HTTP_REFERER")
    protected String httpreferer;
    @XmlElement(name = "HTTP_CONNECTION")
    protected String httpconnection;

    /**
     * Obtiene el valor de la propiedad apiUserName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPIUserName() {
        return apiUserName;
    }

    /**
     * Define el valor de la propiedad apiUserName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPIUserName(String value) {
        this.apiUserName = value;
    }

    /**
     * Obtiene el valor de la propiedad apiPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPIPassword() {
        return apiPassword;
    }

    /**
     * Define el valor de la propiedad apiPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPIPassword(String value) {
        this.apiPassword = value;
    }

    /**
     * Obtiene el valor de la propiedad userPrefs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPrefs() {
        return userPrefs;
    }

    /**
     * Define el valor de la propiedad userPrefs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPrefs(String value) {
        this.userPrefs = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Define el valor de la propiedad sessionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

    /**
     * Obtiene el valor de la propiedad remotehost.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMOTEHOST() {
        return remotehost;
    }

    /**
     * Define el valor de la propiedad remotehost.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMOTEHOST(String value) {
        this.remotehost = value;
    }

    /**
     * Obtiene el valor de la propiedad httpaccept.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPACCEPT() {
        return httpaccept;
    }

    /**
     * Define el valor de la propiedad httpaccept.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPACCEPT(String value) {
        this.httpaccept = value;
    }

    /**
     * Obtiene el valor de la propiedad httpacceptencoding.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPACCEPTENCODING() {
        return httpacceptencoding;
    }

    /**
     * Define el valor de la propiedad httpacceptencoding.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPACCEPTENCODING(String value) {
        this.httpacceptencoding = value;
    }

    /**
     * Obtiene el valor de la propiedad httpacceptcharset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPACCEPTCHARSET() {
        return httpacceptcharset;
    }

    /**
     * Define el valor de la propiedad httpacceptcharset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPACCEPTCHARSET(String value) {
        this.httpacceptcharset = value;
    }

    /**
     * Obtiene el valor de la propiedad httpuseragent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPUSERAGENT() {
        return httpuseragent;
    }

    /**
     * Define el valor de la propiedad httpuseragent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPUSERAGENT(String value) {
        this.httpuseragent = value;
    }

    /**
     * Obtiene el valor de la propiedad httpacceptlanguage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPACCEPTLANGUAGE() {
        return httpacceptlanguage;
    }

    /**
     * Define el valor de la propiedad httpacceptlanguage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPACCEPTLANGUAGE(String value) {
        this.httpacceptlanguage = value;
    }

    /**
     * Obtiene el valor de la propiedad remoteaddr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMOTEADDR() {
        return remoteaddr;
    }

    /**
     * Define el valor de la propiedad remoteaddr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMOTEADDR(String value) {
        this.remoteaddr = value;
    }

    /**
     * Obtiene el valor de la propiedad httpreferer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPREFERER() {
        return httpreferer;
    }

    /**
     * Define el valor de la propiedad httpreferer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPREFERER(String value) {
        this.httpreferer = value;
    }

    /**
     * Obtiene el valor de la propiedad httpconnection.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHTTPCONNECTION() {
        return httpconnection;
    }

    /**
     * Define el valor de la propiedad httpconnection.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHTTPCONNECTION(String value) {
        this.httpconnection = value;
    }

}
