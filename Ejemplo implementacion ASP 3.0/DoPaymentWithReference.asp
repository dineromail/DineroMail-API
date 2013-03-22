<%@ Language=VBScript %>
<%Option Explicit%> 

<!-- #include file = "hex_md5_js.asp" -->

<!-- 
	<summary>
		DoPaymentWithReference: "Realizar pago" de Botón o Carrito de compras, con códigos de barra.
	</summary>
	<param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
	<param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
	<param name="Crypt">Indica si se envian los datos encriptados</param>
	<param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
	<param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
	<param name="Provider">Identifica el proveedor con el cual se desea realizar el pago</param>
	<param name="Subject">Concepto o asunto del comprador hacia el vendedor</param>
	<param name="Message">Mensaje del comprador hacia el vendedor</param>
	
	<param name="Currency">Identificador de la moneda para el ítem</param>
	<param name="Amount">Importe del ítem</param>
	<param name="Code">Identificador generado por el comercio</param>
	<param name="Description">Descripción del ítem</param>
	<param name="ItemName">Nombre o titulo del ítem</param>
	<param name="Quantity">Cantidad de ítems a pagar</param>
	
	<param name="Address">Dirección del comprador</param>
	<param name="City">Ciudad o provincia del comprador</param>
	<param name="Country">País del comprador</param>
	<param name="Email">Email del comprador</param>
	<param name="Name">Nombre del comprador</param>
	<param name="LastName">Apellido del comprador</param>
	<param name="Phone">Teléfono del comprador</param>
	
	<param name="Hash">Cadena a encriptar</param>
	<param name="NSpace">NameSpace del Servicio</param>
	<param name="WsdlPath">WebService endPoint</param>
	<returns>
		Estado de la operación
	</returns>
-->
<%
	Dim APIPassword           : APIPassword = "10D404028B6BE3238FF0E6851"
	Dim APIUserName           : APIUserName = "3A249B9C-0DBD-4ABA-99FA-9329316C4DB4"
	Dim Crypt                 : Crypt = "false"
	Dim MerchantTransactionId : MerchantTransactionId = "1"
	Dim UniqueMessageId       : UniqueMessageId = "10"
	Dim Provider              : Provider = "pagofacil"
	Dim Subject               : Subject = "Subject"
	Dim Message               : Message = "Message"
     
	Dim cCurrency             : cCurrency = "ARG"
	Dim Amount                : Amount = "10.40"
	Dim Code                  : Code = "A001"
	Dim Description           : Description = "Product A001"
	Dim ItemName              : ItemName = "LCD Monitor"
	Dim Quantity              : Quantity = "1"
                              
	Dim Address               : Address = "Charcas 2034"
	Dim City                  : City = "Buenos Aires"
	Dim Country               : Country = "Argentina"
	Dim Email                 : Email = "mailtest@mailtest.com"
	Dim Name                  : Name = "Carlos"
	Dim LastName              : LastName = "Lopez"
	Dim Phone                 : Phone  = "45556565"
	
	Dim Hash                  : Hash = ""
	Dim NSpace                : NSpace = "https://api.dineromail.com/"
	Dim WsdlPath              : WsdlPath = "https://api.dineromail.com/DMAPI.asmx?WSDL"
	
	Dim objXmlHTTP, SOAPRequest, xmlResp
	Dim objXMLDoc, nodeMerchantTransactionId, nodeTransactionId, nodeMessage, nodeStatus, nodeUniqueMessageId,nodeBarcodeDigits, nodeBarcodeImageUrl, nodeVoucherUrl

	// El Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	Dim Items : Items = Amount & Code & cCurrency & Description & ItemName & Quantity
	Dim Buyer : Buyer = Name & LastName & Email & Address & Phone & Country & City
	Hash = MerchantTransactionId & UniqueMessageId & Items & Buyer & Provider & Subject & Message & APIPassword
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
			"<DoPaymentWithReference xmlns=""https://api.dineromail.com/"">" &_
			  "<Credential>" &_
				"<APIUserName>" & APIUserName & "</APIUserName>" &_
				"<APIPassword>" & APIPassword & "</APIPassword>" &_			
			  "</Credential>" &_
			  "<Crypt>" & Crypt & "</Crypt>" &_
			  "<Items>" &_				
				"<Item>" &_
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
				"<DocumentTypeAbbreviation></DocumentTypeAbbreviation>" &_
				"<DocumentNumber></DocumentNumber>" &_
			  "</Buyer>" &_
			  "<Provider>" & Provider & "</Provider>" &_
			  "<Subject>" & Subject & "</Subject>" &_			  
			  "<Message>" & Message & "</Message>" & _
			  "<MerchantTransactionId>" & MerchantTransactionId & "</MerchantTransactionId>" &_
			  "<UniqueMessageId>" & UniqueMessageId & "</UniqueMessageId>" &_
			  "<Hash>" & Hash & "</Hash>" &_
			"</DoPaymentWithReference>" &_
		  "</soap:Body>" &_
		"</soap:Envelope>"

	' Enviamos los datos al Metodo DoPaymentWithReference de la API de DineroMail
	objXmlHTTP.send SOAPRequest	
	' Cargamos objXMLDoc con el resultado del Webservice
	objXMLDoc.load(objXmlHTTP.responseXML) 
	
	Set nodeMerchantTransactionId=objXMLDoc.documentElement.selectNodes("//MerchantTransactionId")
    Set nodeTransactionId=objXMLDoc.documentElement.selectNodes("//TransactionId")
	Set nodeMessage=objXMLDoc.documentElement.selectNodes("//Message")
	Set nodeStatus=objXMLDoc.documentElement.selectNodes("//Status")
	Set nodeUniqueMessageId=objXMLDoc.documentElement.selectNodes("//UniqueMessageId")
	
	Response.Write ("MerchantTransactionId: " & nodeMerchantTransactionId(0).text & "<br />")
	Response.Write ("TransactionId: " & nodeTransactionId(0).text & "<br />")
	Response.Write ("UniqueMessageId: " & nodeUniqueMessageId(0).text & "<br />")
	Response.Write ("Message: " & nodeMessage(0).text & "<br />")
	Response.Write ("Status: " & nodeStatus(0).text & "<br />")	
	
	IF nodeStatus(0).text = "OK" THEN
		Set nodeBarcodeDigits=objXMLDoc<.documentElement.selectNodes("//BarcodeDigits")
		Set nodeBarcodeImageUrl=objXMLDoc.documentElement.selectNodes("//BarcodeImageUrl")
		Set nodeVoucherUrl=objXMLDoc.documentElement.selectNodes("//VoucherUrl")
		Response.Write ("BarcodeDigits: " & nodeBarcodeDigits(0).text & "<br />")	
		Response.Write ("BarcodeImageUrl: " & nodeBarcodeImageUrl(0).text & "<br />")
		Response.Write ("VoucherUrl: " & nodeVoucherUrl(0).text & "<br />")
	END IF
	
	If Err.Number <> 0 Then
		Response.Write ("Error number " & Err.Number & " - Faultstring: " & Err.Description)
	End If

%>