<%-- 
    Document   : GetPaymentTicket
    Created on : 22/02/2013, 15:11:44
    Author     : gpantanetti
--%>

<%@page import="Dineromail.*" %>
<%@page import="https.api_dineromail.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

// <summary>
// 	GetPaymentTicket: Permite obtener un cupón de pago de cualquier proveedor de código de barras y lo asigna al comercio.
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="provider">Identifica el proveedor con el cual se desea realizar el pago</param>
// <param name="currency">Identificador de la moneda para el importe a enviar</param>
// <param name="amount">Importe a enviar</param>
// <param name="hash">Cadena a encriptar</param>
// <returns>
//	Estado de la operación
// </returns>

String apiPassword              = "TEST-TEST-TEST-TEST-TEST";
String apiUserName              = "TEST";
Boolean crypt                   = true;
String merchantTransactionId    = "1";
String uniqueMessageId          = "1";
String currency                 = "USD";
String amount                   = "10.55";
String provider                 = "servipag";
String hash                     = "";

ResultGetPaymentTicket result   = new ResultGetPaymentTicket();
DMCrypt oCrypt                  = new DMCrypt();
DMAPI service                   = new DMAPI();
DMAPISoap port                  = service.getDMAPISoap();
    
try {

    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    hash = merchantTransactionId + uniqueMessageId + currency + amount + provider + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt) {
        
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
	merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
        currency                = oCrypt.encryptText( apiPassword, currency );
        amount                  = oCrypt.encryptText( apiPassword, amount );
        provider                = oCrypt.encryptText( apiPassword, provider );
        
    }

    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );

    // Consultamos el servicio web
    // Llamamos al Metodo getPaymentTicket de la API de DineroMail
    result = port.getPaymentTicket(   credential
                                    , crypt
                                    , currency
                                    , amount
                                    , provider
                                    , merchantTransactionId
                                    , uniqueMessageId
                                    , hash  );
    
    // Mostramos en pantalla el resultado de la operación. 
    out.println( "MerchantTransactionId: " + result.getMerchantTransactionId() + "<br/>" );
    out.println( "TransactionId: " + result.getTransactionId() + "<br/>" );
    out.println( "Status: " + result.getStatus().toString() + "<br/>" );
    out.println( "Message: " + result.getMessage() + "<br/>" );
    out.println( "UniqueMessageId: " + result.getUniqueMessageId() + "<br/>" );
    out.println( "BarcodeDigits: " + result.getBarcodeDigits() + "<br/>" );
    out.println( "BarcodeImageUrl: " + result.getBarcodeImageUrl() + "<br/>" );
    out.println( "VoucherUrl: " + result.getVoucherUrl() + "<br/>" );

} catch (Exception ex) {
    ex.printStackTrace();
}

%>

