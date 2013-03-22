<%-- 
    Document   : DoPaymentWithReference
    Created on : 22/02/2013, 17:48:42
    Author     : Dineromail.com
--%>

<%@page import="Dineromail.*" %>
<%@page import="https.api_dineromail.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

// <summary>
//      DoPaymentWithReference: "Realizar pago" de Botón o Carrito de compras, con códigos de barra.
// </summary>
// <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="crypt">Indica si se envian los datos encriptados</param>
// <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>

// <param name="provider">Identifica el proveedor con el cual se desea realizar el pago</param>
// <param name="subject">Concepto o asunto del comprador hacia el vendedor</param>
// <param name="message">Mensaje del comprador hacia el vendedor</param>

// <param name="currency">Identificador de la moneda para el ítem</param>
// <param name="amount">Importe del ítem</param>
// <param name="code">Identificador generado por el comercio</param>
// <param name="description">Descripción del ítem</param>
// <param name="itemName">Nombre o titulo del ítem</param>
// <param name="quantity">Cantidad de ítems a pagar</param>

// <param name="address">Dirección del comprador</param>
// <param name="city">Ciudad o provincia del comprador</param>
// <param name="country">País del comprador</param>
// <param name="email">Email del comprador</param>
// <param name="name">Nombre del comprador</param>
// <param name="lastName">Apellido del comprador</param>
// <param name="phone">Teléfono del comprador</param>

// <param name="hash">Cadena a encriptar</param>
// <returns>
//      BarcodeDigits, BarcodeImageUrl, VoucherUrl
// </returns>

String apiPassword                  = "TEST-TEST-TEST-TEST-TEST";
String apiUserName                  = "TEST";
Boolean crypt                       = true;
String merchantTransactionId        = "1";
String uniqueMessageId              = "1";

String provider                     = "pagofacil";
String subject                      = "Subject";
String message                      = "Message";
 
String currency                     = "BRL";
String amount                       = "10.40";
String code                         = "A001";
String description                  = "Product A001";
String itemName                     = "LCD Monitor";
String quantity                     = "1";

String address                      = "123";
String city                         = "Brasilia";
String country                      = "Brasilia";
String email                        = "mailtest@mailtest.com";
String name                         = "Carlos";
String lastName                     = "Lopez";
String phone                        = "12341234";

String hash                         = "";

ResultDoPaymentWithReference result = new ResultDoPaymentWithReference();
DMCrypt oCrypt                      = new DMCrypt();
DMAPI service                       = new DMAPI();
DMAPISoap port                      = service.getDMAPISoap();

try {
    
    // El Hash es el cálculo MD5 de los valores 
    // de los siguientes parámetros en orden especificado.
    String items = amount + code + currency + description + itemName + quantity;
    String buyer = name + lastName + email + address + phone + country + city;
    hash = merchantTransactionId + uniqueMessageId + items + buyer + provider + subject + message + apiPassword;
    hash = oCrypt.MD5( hash );

    if (crypt){
        
        // Los datos de la API viajarán con una encriptación del tipo TripleDES
	merchantTransactionId   = oCrypt.encryptText( apiPassword, merchantTransactionId );
        uniqueMessageId         = oCrypt.encryptText( apiPassword, uniqueMessageId );
        currency                = oCrypt.encryptText( apiPassword, currency );
        amount                  = oCrypt.encryptText( apiPassword, amount );
        provider                = oCrypt.encryptText( apiPassword, provider );
        subject                 = oCrypt.encryptText( apiPassword, subject );
        currency                = oCrypt.encryptText( apiPassword, currency );
        code                    = oCrypt.encryptText( apiPassword, code );
        description             = oCrypt.encryptText( apiPassword, description );
        itemName                = oCrypt.encryptText( apiPassword, itemName );
        quantity                = oCrypt.encryptText( apiPassword, quantity );
        address                 = oCrypt.encryptText( apiPassword, address );
        city                    = oCrypt.encryptText( apiPassword, city );
        country                 = oCrypt.encryptText( apiPassword, country );
        email                   = oCrypt.encryptText( apiPassword, email );
        name                    = oCrypt.encryptText( apiPassword, name );
        lastName                = oCrypt.encryptText( apiPassword, lastName );
        phone                   = oCrypt.encryptText( apiPassword, phone );

    }


    Item oItem = new Item();
    oItem.setAmount( amount );
    oItem.setCode( code );
    oItem.setCurrency( currency );
    oItem.setDescription( description );
    oItem.setName( itemName );
    oItem.setQuantity( quantity );

    ArrayOfItem oItemList = new  ArrayOfItem();
    oItemList.getItem().add( oItem );
               
    Buyer oBuyer = new Buyer();
    oBuyer.setAddress( address );
    oBuyer.setCity( city );
    oBuyer.setCountry( country );
    oBuyer.setEmail( email );
    oBuyer.setLastName( lastName );
    oBuyer.setName( name );
    oBuyer.setPhone( phone );

    // La Credential es la tarjeta de acceso a la API de DineroMail
    APICredential credential = new APICredential();
    credential.setAPIUserName( apiUserName );
    credential.setAPIPassword( apiPassword );

    
    // Llamamos al Metodo doPaymentWithReference de la API de DineroMail
    result = port.doPaymentWithReference(  credential
                                         , crypt
                                         , merchantTransactionId
                                         , oItemList
                                         , oBuyer
                                         , provider
                                         , subject
                                         , message
                                         , uniqueMessageId
                                         , hash );


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
