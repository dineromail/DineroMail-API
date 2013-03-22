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
// 		GetBalance: Consulta del balance en la cuenta del usuario.
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="hash">Cadena a encriptar</param>
// <returns>
//		GetBalanceResult: (Status, Currency, Amount)
// </returns>

String apiPassword              = "QAZXSWEDTGBYHNUJPLMOKNIJ";
String apiUserName              = "TESTDMAPIPRO001";
Boolean crypt                   = true;
String merchantTransactionId    = "1";
String uniqueMessageId          = "20";
String hash                     = ""; 

DMCrypt oCrypt                  = new DMCrypt();
ResultGetBalance result         = new ResultGetBalance();
DMAPI service                   = new DMAPI();
DMAPISoap port                  = service.getDMAPISoap();
    
try {

    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    hash = merchantTransactionId + uniqueMessageId + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt) {
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
	merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
    }

    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );

    // Consultamos el servicio web
    // Llamamos al Metodo getBalance de la API de DineroMail
    result = port.getBalance(  credential
                             , crypt
                             , merchantTransactionId
                             , uniqueMessageId
                             , hash );
    
    
    // Mostramos en pantalla el resultado de la operación. 
    out.println( "MerchantTransactionId: " + result.getMerchantTransactionId() + "<br/>" );
    out.println( "TransactionId: " + result.getTransactionId() + "<br/>" );
    out.println( "Message: " + result.getMessage() + "<br/>" );
    out.println( "Status: " + result.getStatus() + "<br/>" );
    out.println( "UniqueMessageId: " + result.getUniqueMessageId() + "<br/>" );
    
    if (result.getStatus().toString() == "OK")
    {
        Balance balance = result.getBalance().getBalance().get(0);
        out.println( "Currency: " + balance.getCurrency() + "<br/>" );
        out.println( "Amount: " + balance.getAmount().toString() + "<br/>" );
    }

} catch (Exception ex) {
    ex.printStackTrace();
}
%>
