<%-- 
    Document   : GetOperations
    Created on : 22/02/2013, 14:22:43
    Author     : gpantanetti
--%>

<%@page import="Dineromail.*" %>
<%@page import="https.api_dineromail.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

// <summary>
//      GetOperations: Obtener lista operaciones de DineroMail por parte de los vendedores
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="startDate">Fecha inicial, en un rango de fecha</param>
// <param name="endDate">Fecha final, en un rango de fecha</param>
// <param name="operationId">Identificador de la operación en DineroMail</param>
// <param name="hash">Cadena a encriptar</param>
// <returns>
//      Listado de Operaciones
// </returns>

String apiPassword              = "QAZXSWEDTGBYHNUJPLMOKNIJ"; // TEST-TEST-TEST-TEST-TEST
String apiUserName              = "TESTDMAPIPRO001"; // TEST
Boolean crypt                   = true;
String merchantTransactionId    = "1";
String uniqueMessageId          = "27";
String startDate                = "2012-09-17";
String endDate                  = "2012-09-18";
String operationId              = "";
String hash                     = "";

ResultGetOperations result      = new ResultGetOperations();
DMCrypt oCrypt                  = new DMCrypt();
DMAPI service                   = new DMAPI();
DMAPISoap port                  = service.getDMAPISoap();

try {

    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    hash = merchantTransactionId + uniqueMessageId + operationId + startDate + endDate + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt){
        
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
	merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
        startDate               = oCrypt.encryptText( apiPassword, startDate );
        endDate                 = oCrypt.encryptText( apiPassword, endDate );
        operationId             = oCrypt.encryptText( apiPassword, operationId );
        
    }

    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );

    // Consultamos el servicio web
    // Llamamos al Metodo getOperations de la API de DineroMail
    result = port.getOperations(  credential
                                , crypt
                                , merchantTransactionId
                                , operationId
                                , startDate
                                , endDate
                                , uniqueMessageId
                                , hash );

    // Mostramos en pantalla el resultado de la operación. 
    out.println( "MerchantTransactionId: " + result.getMerchantTransactionId() + "<br/>" );
    out.println( "Status: " + result.getStatus() + "<br/>" );
    out.println( "Message: " + result.getMessage() + "<br/>" );
    out.println( "UniqueMessageId: " + result.getUniqueMessageId() + "<br/>" );

    if (result.getStatus().toString() == "OK")
    {
        for(OperationDetail Operation: result.getOperations().getOperationDetail())
        {
            out.println( "<h2>Operation</h2>" );
            out.println( "Id: " + Operation.getId().toString() + "<br/>");
            out.println( "Amount: " + Operation.getAmount().toString() + "<br/>" );
            out.println( "Date: " + Operation.getDate().toString() + "<br/>" );
            out.println( "NetAmount: " + Operation.getNetAmount().toString() + "<br/>" );
            out.println( "PaymentMethod: " + Operation.getPaymentMethod().toString() + "<br/>" );
            out.println( "Shares: " + Operation.getShares().toString() + "<br/>" );
            out.println( "State: " + Operation.getState().toString() + "<br/>" );
            out.println( "<h3>Buyer</h3>" );
            out.println( "Address: " + Operation.getBuyer().getAddress().toString() + "<br/>" );
            out.println( "Comments: " + Operation.getBuyer().getComments().toString() + "<br/>" );
            out.println( "DocumentNumber: " + Operation.getBuyer().getDocumentNumber().toString() + "<br/>" );
            out.println( "DocumentType: " + Operation.getBuyer().getDocumentType().toString() + "<br/>" );
            out.println( "Email: " + Operation.getBuyer().getEmail().toString() + "<br/>" );
            out.println( "LastName: " + Operation.getBuyer().getLastName().toString() + "<br/>" );
            out.println( "Name: " + Operation.getBuyer().getName().toString() + "<br/>" );
            out.println( "Phone: " + Operation.getBuyer().getPhone().toString() + "<br/>" );
            out.println( "<h3>Seller</h3>" );
            out.println( "DocumentNumber: " + Operation.getSeller().getDocumentNumber().toString() + "<br/>" );
            out.println( "DocumentType: " + Operation.getSeller().getDocumentType().toString() + "<br/>" );
            out.println( "Email: " + Operation.getSeller().getEmail().toString() + "<br/>" );
            out.println( "LastName: " + Operation.getSeller().getLastName().toString() + "<br/>" );
            out.println( "Name: " + Operation.getSeller().getName().toString() + "<br/>" );
            out.println( "Phone: " + Operation.getSeller().getPhone().toString() + "<br/>" );
        }
    }
        
} catch (Exception ex) {
    ex.printStackTrace();
}
%>
        