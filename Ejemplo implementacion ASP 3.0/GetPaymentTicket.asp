<%@ Language=VBScript %>
<%Option Explicit%> 

<!-- #include file = "_hex_md5_js.asp" -->

<!-- 
	<summary>
		GetPaymentTicket: Permite obtener un cupón de pago de cualquier proveedor de código de barras y lo asigna al comercio.
	</summary>
	<param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
	<param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
	<param name="Crypt">Indica si se envian los datos encriptados</param>
	<param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
	<param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
	
	<param name="Provider">Identifica el proveedor con el cual se desea realizar el pago</param>
	<param name="_Currency">Identificador de la moneda para el importe a enviar</param>
	<param name="Amount">Importe a enviar</param>
	
	<param name="Hash">Cadena a encriptar</param>
	<param name="NSpace">NameSpace del Servicio</param>
	<param name="WsdlPath">WebService endPoint</param>
	<returns>
		Estado de la operación
	</returns>
-->
<%
	Dim APIPassword           : APIPassword = "TEST-TEST-TEST-TEST-TEST"
	Dim APIUserName           : APIUserName = "TEST"
	Dim Crypt                 : Crypt = "false"
	Dim MerchantTransactionId : MerchantTransactionId = "1"
	Dim UniqueMessageId       : UniqueMessageId = "10"
	Dim Provider              : Provider = "servipag"
	Dim cCurrency             : cCurrency = "USD"
	Dim Amount                : Amount = "10.55"
	Dim Hash                  : Hash = ""
	Dim NSpace                : NSpace = "https://api.dineromail.com/GetPaymentTicket"
	Dim WsdlPath              : WsdlPath = "https://api.dineromail.com/DMAPI.asmx?WSDL"
	
	Dim objXmlHTTP, SOAPRequest, xmlResp
	Dim objXMLDoc, nodeMerchantTransactionId, nodeTransactionId, nodeMessage, nodeStatus, nodeUniqueMessageId, nodeVoucherUrl, nodeBarcodeImageUrl, nodeBarcodeDigits
    
	On Error Resume Next

	' El $Hash es el cálculo MD5 de los valores 
	' de los siguientes parámetros en orden especificado.
	Hash = MerchantTransactionId & UniqueMessageId & APIPassword
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
			"<GetPaymentTicket xmlns=""https://api.dineromail.com/"">" &_
			  "<Credential>" &_
				"<APIUserName>" & APIUserName & "</APIUserName>" &_
				"<APIPassword>" & APIPassword & "</APIPassword>" &_			
			  "</Credential>" &_
			  "<Crypt>" & Crypt & "</Crypt>" &_
			  "<MerchantTransactionId>" & MerchantTransactionId & "</MerchantTransactionId>" &_
			  "<UniqueMessageId>" & UniqueMessageId & "</UniqueMessageId>" &_
			  "<Currency>" & cCurrency & "</Currency>" &_
			  "<Amount>" & Amount & "</Amount>" &_
			  "<Provider>" & Provider & "</Provider>" &_
			  "<Hash>" & Hash & "</Hash>" &_
			"</GetPaymentTicket>" &_
		  "</soap:Body>" &_
		"</soap:Envelope>"

	' Enviamos los datos al Metodo GetPaymentTicket de la API de DineroMail
	objXmlHTTP.send SOAPRequest	
	' Cargamos objXMLDoc con el resultado del Webservice
	objXMLDoc.load(objXmlHTTP.responseXML) 
	
	' Mostramos en pantalla el resultado de la operación. 
    Set nodeMerchantTransactionId = objXMLDoc.documentElement.selectNodes("//MerchantTransactionId")
    Set nodeTransactionId = objXMLDoc.documentElement.selectNodes("//TransactionId")
	Set nodeMessage = objXMLDoc.documentElement.selectNodes("//Message")
	Set nodeStatus = objXMLDoc.documentElement.selectNodes("//Status")
	Set nodeUniqueMessageId = objXMLDoc.documentElement.selectNodes("//UniqueMessageId")
	Set nodeVoucherUrl = objXMLDoc.documentElement.selectNodes("//VoucherUrl")
	Set nodeBarcodeImageUrl = objXMLDoc.documentElement.selectNodes("//BarcodeImageUrl")
	Set nodeBarcodeDigits = objXMLDoc.documentElement.selectNodes("//BarcodeDigits")
	
	Response.Write ("MerchantTransactionId: " & nodeMerchantTransactionId(0).text & "<br />")
	Response.Write ("TransactionId: " & nodeTransactionId(0).text & "<br />")
	Response.Write ("UniqueMessageId: " & nodeUniqueMessageId(0).text & "<br />")
	Response.Write ("Message: " & nodeMessage(0).text & "<br />")
	Response.Write ("Status: " & nodeStatus(0).text & "<br />")
	Response.Write ("VoucherUrl: " & nodeVoucherUrl(0).text & "<br />")
    Response.Write ("BarcodeImageUrl: " & nodeBarcodeImageUrl(0).text & "<br />")
    Response.Write ("BarcodeDigits: " & nodeBarcodeDigits(0).text & "<br />")
		
	If Err.Number <> 0 Then
		Response.Write ("Error number " & Err.Number & " - Faultstring: " & Err.Description)
	End If

%>