<%-- 
    Document   : GetBalance
    Created on : 22/02/2013, 11:57:20
    Author     : Dineromail.com 
--%>

<%@page import="Dineromail.*" %>
<%@page import="https.api_dineromail.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

// <summary>
// 	Refund: Realizar Reembolsos
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="currency">Identificador de la moneda</param>
// <param name="amount">Importe a reembolsar</param>
// <param name="subject">Concepto o asunto del reembolso</param>
// <param name="message">Mensaje del vendedor hacia el comprador</param>
// <param name="hash">Cadena a encriptar</param>
// <returns>
// 	Estado de la Operación
// </returns>

String apiPassword              = "QAZXSWEDTGBYHNUJPLMOKNIJ";
String apiUserName              = "TESTDMAPIPRO001";
Boolean crypt                   = true;
String merchantTransactionId    = "1";
String uniqueMessageId          = "20";
String currency                 = "ARG";
String amount                   = "10.40";
String subject                  = "Subject";
String message                  = "Message";
String hash                     = ""; 

DMCrypt oCrypt                  = new DMCrypt();
ResultRefund result             = new ResultRefund();
DMAPI service                   = new DMAPI();
DMAPISoap port                  = service.getDMAPISoap();
    
try {

    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    hash = merchantTransactionId + uniqueMessageId + currency + amount + subject + message + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt) {
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
		merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
        currency                = oCrypt.encryptText( apiPassword, currency );
        amount                  = oCrypt.encryptText( apiPassword, amount );
        subject                 = oCrypt.encryptText( apiPassword, subject );
        message                 = oCrypt.encryptText( apiPassword, message );   
    }
    
    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );

    // Consultamos el servicio web
    // Llamamos al Metodo getBalance de la API de DineroMail
    result = port.refund(  credential
                         , crypt
                         , merchantTransactionId
                         , currency
                         , amount
                         , subject
                         , message
                         , uniqueMessageId
                         , hash );    
    
    // Mostramos en pantalla el resultado de la operación. 
    out.println( "MerchantTransactionId: " + result.getMerchantTransactionId() + "<br/>" );
    out.println( "TransactionId: " + result.getTransactionId() + "<br/>" );
    out.println( "Message: " + result.getMessage() + "<br/>" );
    out.println( "Status: " + result.getStatus() + "<br/>" );

} catch (Exception ex) {
    ex.printStackTrace();
}
%>
