<%@ Language=VBScript %>
<%Option Explicit%> 

<!-- #include file = "hex_md5_js.asp" -->

<!-- 
	<summary>
		DoPaymentWithCreditCard: Realizar pagos con "Tarjetas de Credito".
	</summary>
	<param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
	<param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
	<param name="Crypt">Indica si se envian los datos encriptados</param>
	<param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente</param>
	<param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
	<param name="Provider">Proveedor con el cual se realiza el pago</param>
	<param name="Subject">Concepto o asunto del comprador hacia el vendedor</param>
	<param name="Message">Mensaje del comprador hacia el vendedor</param>
	
	<param name="Currency">Moneda correspondiente al precio del ítem</param>
	<param name="Amount">Precio del ítem</param>
	<param name="Code">Identificador (ID) generado por el vendedor</param>
	<param name="Description">Descripción del ítem</param>
	<param name="ItemName">Nombre del ítem</param>
	<param name="Quantity">Cantidad de ítems</param>
	
	<param name="Address">Dirección del comprador</param>
	<param name="City">Ciudad del comprador</param>
	<param name="_Country">Pais del comprador</param>
	<param name="Email">Email del comprador</param>
	<param name="Name">Nombre del comprador</param>
	<param name="LastName">Apellido del comprador</param>
	<param name="Phone">Telefono del comprador</param>
	
	<param name="ccAddress">Dirección del titular de la tarjeta de crédito</param>
	<param name="ccAddressComplement">Complemento de la dirección del titular de latarjeta de crédito</param>
	<param name="ccAddressNumber">Número de la dirección del titular de la tarjetade crédito</param>
	<param name="ccCity">Ciudad de residencia del titular de la tarjetade crédito.</param>
	<param name="ccCountry">País de residencia del titular de la tarjeta decrédito</param>
	<param name="ccNeighborhood">Barrio del titular de la tarjeta de crédito</param>
	<param name="ccState">Estado de residencia del titular de la tarjeta decrédito</param>
	<param name="ccZipCode">Código postal de la dirección del titular de latarjeta de crédito</param>
	<param name="ccZipCode">Identificador del Banco emisor de latarjeta de crédito</param>
	
	<param name="ccCreditCardNumber">Número de tarjeta de crédito</param>
	<param name="ccDocumentNumber">Número de documento del titular de latarjeta de crédito</param>
	<param name="ccExpirationDate">Fecha de expiración de la tarjeta de crédito</param>
	<param name="ccHolder">Titular de la tarjeta de crédito</param>
	<param name="ccInstallment">Cantidad de cuotas en las cuales se va arealizar el pago</param>
	<param name="ccSecurityCode">Código de seguridad de la tarjeta de crédito</param>
	
	<param name="Hash">Cadena a encriptar</param>
	<param name="NSpace">NameSpace del Servicio</param>
	<param name="WsdlPath">WebService endPoint</param>
	<returns>Estado de la operación</returns>
-->
<%
	Dim APIPassword           : APIPassword = "10D404028B6BE3238FF0E6851"
	Dim APIUserName           : APIUserName = "3A249B9C-0DBD-4ABA-99FA-9329316C4DB4"
	Dim Crypt                 : Crypt = "false"
	Dim MerchantTransactionId : MerchantTransactionId = "1"
	Dim UniqueMessageId       : UniqueMessageId = "10"
	
	Dim Provider              : Provider = "MX_SANTANDER_TC"
	Dim Subject               : Subject = "Subject"
	Dim Message               : Message = "Message"

	Dim cCurrency             : cCurrency = "MXN"
	Dim Amount                : Amount = "10"
	Dim Code                  : Code = "1234567"
	Dim Description           : Description = "TestOrder"
	Dim ItemName              : ItemName = "TestOrder"
	Dim Quantity              : Quantity = "1"
                              : 
	Dim Address               : Address = "123 Street"
	Dim City                  : City = ""
	Dim Country               : Country = "MEXICO"
	Dim Email                 : Email = "edominguez@bazaya.com.mx"
	Dim Name                  : Name = "Aldo"
	Dim LastName              : LastName = "Dominguez"
	Dim Phone                 : Phone = "1234567890"

	Dim ccAddress             : ccAddress = "Street"
	Dim ccAddressComplement   : ccAddressComplement = ""
	Dim ccAddressNumber       : ccAddressNumber = "123" ;
	Dim ccCity                : ccCity = ""
	Dim ccCountry             : ccCountry = ""
	Dim ccNeighborhood        : ccNeighborhood = ""
	Dim ccState               : ccState = ""
	Dim ccZipCode             : ccZipCode = ""
	Dim ccBankId			  : ccBankId = 0
	
	Dim ccCreditCardNumber    : ccCreditCardNumber = "0123456789012345"
	Dim ccDocumentNumber      : ccDocumentNumber = "12345678"
	Dim ccExpirationDate      : ccExpirationDate = "01/01"
	Dim ccHolder              : ccHolder = "test"
	Dim ccInstallment         : ccInstallment = "1"
	Dim ccSecurityCode        : ccSecurityCode = "537"
	
	Dim Hash                  : Hash = ""
	Dim NSpace                : NSpace = "https://api.dineromail.com/DoPaymentWithCreditCard"
	Dim WsdlPath              : WsdlPath = "https://api.dineromail.com/DMAPI.asmx?WSDL"
	
	Dim objXmlHTTP, SOAPRequest, xmlResp
	Dim objXMLDoc, nodeMerchantTransactionId, nodeTransactionId, nodeMessage, nodeStatus, nodeUniqueMessageId, nodeAmount, nodeCurrency
    
	On Error Resume Next

	' El $Hash es el cálculo MD5 de los valores 
	' de los siguientes parámetros en orden especificado.
	Dim Items		: Items = Amount & Code & cCurrency & Description & ItemName & Quantity
	Dim Buyer		: Buyer = Name & LastName & Email & Address & Phone & Country & City
	Dim CreditCard	: CreditCard = 	 ccInstallment & ccCreditCardNumber & ccHolder & ccExpirationDate & _
									 ccSecurityCode & ccDocumentNumber & ccAddress & ccAddressNumber & _
									 ccAddressComplement & ccZipCode & ccNeighborhood & ccCity & _
									 ccState & ccCountry

	Hash = MerchantTransactionId & UniqueMessageId & Items & Buyer & CreditCard & _
		   Provider & Subject & Message & APIPassword

	Hash = hex_md5(Hash)

	Set objXmlHTTP = CreateObject("MSXML2.XMLHTTP")
	Set objXMLDoc = Server.CreateObject("MSXML2.DOMDocument")
	
	objXmlHTTP.Open "POST", WsdlPath, False 
	objXmlHTTP.setRequestHeader "Content-Type", "text/xml; charset=utf-8" 
	objXmlHTTP.setRequestHeader "SOAPAction", NSpace

	' Datos de la solicitud para SOAP 1.1					
	SOAPRequest = _
		"<?xml version=""1.0"" encoding=""utf-8""?>" &_
		"<soap:Envelope xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance"" xmlns:xsd=""http://www.w3.org/2001/XMLSchema"" xmlns:soap=""http://schemas.xmlsoap.org/soap/envelope/"">" &_
		  "<soap:Body>" &_
			"<GetBalance xmlns=""https://api.dineromail.com/"">" &_
			  "<Credential>" &_
				"<APIUserName>" & APIUserName & "</APIUserName>" &_
				"<APIPassword>" & APIPassword & "</APIPassword>" &_			
			  "</Credential>" &_
			  "<Crypt>" & Crypt & "</Crypt>" &_
			  "<MerchantTransactionId>" & MerchantTransactionId & "</MerchantTransactionId>" &_
			  "<UniqueMessageId>" & UniqueMessageId & "</UniqueMessageId>" &_
			  "<Items>
				"<Item>
				  "<Amount>" & Amount & "</Amount>" &_
				  "<Code>" & Code & "</Code>" &_
				  "<Currency>" & cCurrency & "</Currency>" &_
				  "<Description>" & Description & "</Description>" &_
				  "<Name>" & ItemName & "</Name>" &_
				  "<Quantity>" & Quantity & "</Quantity>" &_
				"</Item>" &_
			  "</Items>" &_
			  "<Buyer>" &_
				"<Name>" & Name & "</Name>" &_
				"<LastName>" & LastName & "</LastName>" &_
				"<Email>" & Email & "</Email>" &_
				"<Address>" & Address & "</Address>" &_
				"<Phone>" & Phone & "</Phone>" &_
				"<Country>" & Country & "</Country>" &_
				"<City>" & City & "</City>" &_
			  "</Buyer>" &_
			  "<Provider>" & Provider & "</Provider>" &_
			  "<CreditCard>" &_
				"<Installment>" & ccInstallment & "</Installment>" &_
				"<CreditCardNumber>" & ccCreditCardNumber & "</CreditCardNumber>" &_
				"<Holder>" & ccHolder & "</Holder>" &_
				"<ExpirationDate>" & ccExpirationDate & "</ExpirationDate>" &_
				"<SecurityCode>" & ccSecurityCode & "</SecurityCode>" &_
				"<DocumentNumber>" & ccDocumentNumber & "</DocumentNumber>" &_
				"<Address>" & ccAddress & "</Address>" &_
				"<AddressNumber>" & ccAddressNumber & "</AddressNumber>" &_
				"<AddressComplement>" & ccAddressComplement & "</AddressComplement>" &_
				"<ZipCode>" & ccZipCode & "</ZipCode>" &_
				"<Neighborhood>" & ccNeighborhood & "</Neighborhood>" &_
				"<City>" & ccCity & "</City>" &_
				"<State>" & ccState & "</State>" &_
				"<Country>" & ccCountry & "</Country>" &_
				"<BankId>" & ccBankId & "</BankId>" &_
			  "</CreditCard>" &_
			  "<Subject>" & Subject & "</Subject>" &_
			  "<Message>" & Message & "</Message>" &_
			  "<Hash>" & Hash & "</Hash>" &_
			"</GetBalance>" &_
		  "</soap:Body>" &_
		"</soap:Envelope>"

	' Enviamos los datos al Metodo GetBalance de la API de DineroMail
	objXmlHTTP.send SOAPRequest
	
	' Cargamos objXMLDoc con el resultado del Webservice
	objXMLDoc.load(objXmlHTTP.responseXML) 
	
	Set nodeMerchantTransactionId = objXMLDoc.documentElement.selectNodes("//MerchantTransactionId")
    Set nodeTransactionId = objXMLDoc.documentElement.selectNodes("//TransactionId")
	Set nodeMessage = objXMLDoc.documentElement.selectNodes("//Message")
	Set nodeStatus = objXMLDoc.documentElement.selectNodes("//Status")
	Set nodeUniqueMessageId = objXMLDoc.documentElement.selectNodes("//UniqueMessageId")
	
	Response.Write ("MerchantTransactionId: " & nodeMerchantTransactionId(0).text & "<br />")
	Response.Write ("TransactionId: " & nodeTransactionId(0).text & "<br />")
	Response.Write ("UniqueMessageId: " & nodeUniqueMessageId(0).text & "<br />")
	Response.Write ("Message: " & nodeMessage(0).text & "<br />")
	Response.Write ("Status: " & nodeStatus(0).text & "<br />")	
	
	If Err.Number <> 0 Then
		Response.Write ("Error number " & Err.Number & " - Faultstring: " & Err.Description)
	End If

%>