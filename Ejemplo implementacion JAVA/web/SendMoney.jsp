<%-- 
    Document   : SendMoney
    Created on : 22/02/2013, 14:51:11
    Author     : Dineromail.com
--%>

<%@page import="Dineromail.*" %>
<%@page import="https.api_dineromail.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
// <summary>
//      SendMoney: Realizar un "Envío de dinero".
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="currency">Moneda del importe a enviar</param>
// <param name="amount">Importe a enviar</param>
// <param name="mailTo">Email del usuario que recibe el dinero</param>
// <param name="subject">Concepto del envío de dinero</param>
// <param name="message">Mensaje al usuario destinatario del dinero</param>
// <param name="payOff">Identifica el origen del envío de dinero</param>
// <param name="hash">Cadena a encriptar</param>
// <returns>
//      Estado de la operación
// </returns>

String apiPassword              = "TEST-TEST-TEST-TEST-TEST";
String apiUserName              = "TEST";
Boolean crypt                   = true;
String merchantTransactionId    = "1";
String uniqueMessageId          = "1";
String currency                 = "BRL";
String amount                   = "10.40";
String mailTo                   = "testdineromail@testdineromail.com";
String subject                  = "Subject";
String message                  = "Message";
String payOff                   = "Producto Sale";
String hash                     = "";

ResultSendMoney result          = new ResultSendMoney();
DMCrypt oCrypt                  = new DMCrypt();
DMAPI service                   = new DMAPI();
DMAPISoap port                  = service.getDMAPISoap();
    
try {

    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    hash = merchantTransactionId + uniqueMessageId + currency + amount + mailTo + payOff + subject + message + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt){
        
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
	merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
        currency                = oCrypt.encryptText( apiPassword, currency );
        amount                  = oCrypt.encryptText( apiPassword, amount );
        mailTo                  = oCrypt.encryptText( apiPassword, mailTo );
        subject                 = oCrypt.encryptText( apiPassword, subject );
        message                 = oCrypt.encryptText( apiPassword, message );
        payOff                  = oCrypt.encryptText( apiPassword, payOff );
    }

    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );
    
    // Consultamos el servicio web
    // Llamamos al Metodo sendMoney de la API de DineroMail
    result = port.sendMoney(  credential
                            , crypt
                            , currency
                            , amount
                            , mailTo
                            , payOff
                            , subject
                            , message
                            , merchantTransactionId
                            , uniqueMessageId
                            , hash );
    
    // Mostramos en pantalla el resultado de la operación. 
    out.println( "MerchantTransactionId: " + result.getMerchantTransactionId() + "<br/>" );
    out.println( "TransactionId: " + result.getTransactionId() + "<br/>" );
    out.println( "Status: " + result.getStatus().toString() + "<br/>" );
    out.println( "Message: " + result.getMessage() + "<br/>" );
    out.println( "UniqueMessageId: " + result.getUniqueMessageId() + "<br/>" );
        
} catch (Exception ex) {
    ex.printStackTrace();
}
%>


