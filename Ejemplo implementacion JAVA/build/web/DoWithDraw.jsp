<%-- 
    Document   : DoWithDraw
    Created on : 22/02/2013, 16:49:30
    Author     : Dineromail.com
--%>

<%@page import="Dineromail.*" %>
<%@page import="https.api_dineromail.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
// <summary>
//      DoWithDraw: Realizar "Retiro de fondos" de la cuenta de DineroMail
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="currency">Moneda del importe a retirar</param>
// <param name="amount">Importe a retirar</param>
// <param name="method">Identificador del método a utilizar para el retiro defondos</param>

// <param name="street">Calle donde recibirá el cheque</param>
// <param name="number">Altura de la calle donde recibirá el cheque</param>
// <param name="floor">Piso en caso de vivir en edificio.</param>
// <param name="appartment">Departamento.</param>
// <param name="zip">Código postal.</param>
// <param name="city">Identificador de Ciudad</param>
// <param name="state">Identificador de Estado o provincia</param>

// <param name="bank">Identificador del banco</param>
// <param name="bankNumber">Número de la cuenta bancaria</param>
// <param name="type">Identifica el tipo de cuenta bancaria</param>
// <param name="name">Nombre del titular de la cuenta bancaria</param>
// <param name="lastName">Apellido del titular de la cuenta bancaria</param>
// <param name="documentType">Tipo de documento del titular</param>
// <param name="documentNumber">Número de documento del titular</param>
// <param name="branch">Solamente necesario en Brasil. Por defecto enviar 0 cero.</param>

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
String method                   = "Bank";
String street                   = "Street";
String number                   = "123";
String floor                    = "1";
String appartment               = "B";
String zip                      = "123";
String city                     = "Brasilia";
String state                    = "Brasilia";
String bank                     = "Banco Santander";
String type                     = "CA";
String name                     = "Juan";
String lastName                 = "Lopez";
String documentType             = "29200100";
String documentNumber           = "1";
String branch                   = "1";
String bankNumber               = "12341234";
String hash                     = "";

ResultDoWithDraw result         = new ResultDoWithDraw();
DMCrypt oCrypt                  = new DMCrypt();
DMAPI service                   = new DMAPI();
DMAPISoap port                  = service.getDMAPISoap();

try {

    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    String fullAddressDetail = street + number + floor + appartment + zip + city + state;
    String fullBankAccountDetail = bank + bankNumber + type + name + lastName + documentType + documentNumber + branch;
    hash = merchantTransactionId + uniqueMessageId + method + currency + amount + fullAddressDetail + fullBankAccountDetail + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt){
        
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
	merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
        currency                = oCrypt.encryptText( apiPassword, currency );
        amount                  = oCrypt.encryptText( apiPassword, amount );
        method                  = oCrypt.encryptText( apiPassword, method );
        street                  = oCrypt.encryptText( apiPassword, street );
        floor                   = oCrypt.encryptText( apiPassword, floor );
        appartment              = oCrypt.encryptText( apiPassword, appartment );
        zip                     = oCrypt.encryptText( apiPassword, zip );
        city                    = oCrypt.encryptText( apiPassword, city );
        state                   = oCrypt.encryptText( apiPassword, state );
        
        bank                    = oCrypt.encryptText( apiPassword, bank );
        type                    = oCrypt.encryptText( apiPassword, type );
        name                    = oCrypt.encryptText( apiPassword, name );
        lastName                = oCrypt.encryptText( apiPassword, lastName );
        documentType            = oCrypt.encryptText( apiPassword, documentType );
        documentNumber          = oCrypt.encryptText( apiPassword, documentNumber );
        branch                  = oCrypt.encryptText( apiPassword, branch );
        bankNumber              = oCrypt.encryptText( apiPassword, bankNumber );
        
    }

    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );

    // Detalla la cuenta bancaria
    BankAccountDetail bankAccountDetail = new BankAccountDetail();
    bankAccountDetail.setBank( bank );
    bankAccountDetail.setType( type );
    bankAccountDetail.setName( name );
    bankAccountDetail.setLastName( lastName );
    bankAccountDetail.setDocumentType( documentType );
    bankAccountDetail.setDocumentNumber( documentNumber );
    bankAccountDetail.setBranch( branch );
    bankAccountDetail.setBankNumber( bankNumber );

    // Detalla la dirección de entrega
    AddressDetail addressDetail = new AddressDetail();
    addressDetail.setStreet( street );
    addressDetail.setNumber( number );
    addressDetail.setFloor( floor );
    addressDetail.setAppartment( appartment );
    addressDetail.setZip( zip );
    addressDetail.setCity( city );
    addressDetail.setState( state );
        
    // Consultamos el servicio web
    // Llamamos al Metodo doWithDraw de la API de DineroMail
    result = port.doWithDraw(     credential
                                , crypt
                                , merchantTransactionId
                                , method
                                , currency
                                , amount
                                , addressDetail
                                , bankAccountDetail
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
