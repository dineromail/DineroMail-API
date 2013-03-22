<%@ Language=VBScript %>
<%Option Explicit%> 

<!-- #include file = "_hex_md5_js.asp" -->

<!-- 
	<summary>
		GetOperations: Obtener lista operaciones de DineroMail por parte de los vendedores
	</summary>
	<param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
	<param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
	<param name="Crypt">Indica si se envian los datos encriptados</param>
	<param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
	<param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
	<param name="StartDate">Fecha inicial, en un rango de fecha</param>
	<param name="EndDate">Fecha final, en un rango de fecha</param>
	<param name="OperationId">Identificador de la operación en DineroMail</param>
	<param name="Hash">Cadena a encriptar</param>
	<param name="NSpace">NameSpace del Servicio</param>
	<param name="WsdlPath">WebService endPoint</param>
	<returns>
		Lista de Operaciones
	</returns>
-->
<%
	Dim APIPassword           : APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ"
	Dim APIUserName           : APIUserName = "TESTDMAPIPRO001"
	Dim Crypt                 : Crypt = "false"
	Dim MerchantTransactionId : MerchantTransactionId = "1"
	Dim UniqueMessageId       : UniqueMessageId = "24"
	Dim StartDate             : StartDate = "2012-09-17"
	Dim EndDate               : EndDate = "2012-10-01"
	Dim OperationId           : OperationId = ""
	Dim Hash                  : Hash = ""
	Dim NSpace                : NSpace = "https://api.dineromail.com/GetOperations"
	Dim WsdlPath              : WsdlPath = "https://api.dineromail.com/DMAPI.asmx?WSDL"
	
	Dim objXmlHTTP, SOAPRequest
	Dim objXMLDoc, xmlOperation, nodeMerchantTransactionId, nodeMessage, nodeStatus, nodeUniqueMessageId
	
	On Error Resume Next

	' El $Hash es el cálculo MD5 de los valores 
	' de los siguientes parámetros en orden especificado.
	Hash = MerchantTransactionId & UniqueMessageId & OperationId & StartDate & EndDate & APIPassword
	Hash = hex_md5(Hash)

	Set objXmlHTTP = CreateObject("MSXML2.XMLHTTP")
	Set objXMLDoc =Server.CreateObject("MSXML2.DOMDocument")
	
	objXmlHTTP.Open "POST", WsdlPath, False 
	objXmlHTTP.setRequestHeader "Content-Type", "text/xml; charset=utf-8" 
	objXmlHTTP.setRequestHeader "SOAPAction", NSpace

	' Datos de la solicitud para SOAP 1.1					
	SOAPRequest = _
		"<?xml version=""1.0"" encoding=""utf-8""?>" &_
		"<soap:Envelope xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance"" xmlns:xsd=""http://www.w3.org/2001/XMLSchema"" xmlns:soap=""http://schemas.xmlsoap.org/soap/envelope/"">" &_
		  "<soap:Body>" &_
			"<GetOperations xmlns=""https://api.dineromail.com/"">" &_
			  "<Credential>" &_
				"<APIUserName>" & APIUserName & "</APIUserName>" &_
				"<APIPassword>" & APIPassword & "</APIPassword>" &_			
			  "</Credential>" &_
			  "<Crypt>" & Crypt & "</Crypt>" &_
			  "<MerchantTransactionId>" & MerchantTransactionId & "</MerchantTransactionId>" &_
			  "<UniqueMessageId>" & UniqueMessageId & "</UniqueMessageId>" &_
			  "<StartDate>" & StartDate & "</StartDate>" &_
			  "<EndDate>" & EndDate & "</EndDate>" &_
			  "<OperationId>" & OperationId & "</OperationId>" &_
			  "<Hash>" & Hash & "</Hash>" &_
			"</GetOperations>" &_
		  "</soap:Body>" &_
		"</soap:Envelope>"

	' Enviamos los datos al Metodo GetOperations de la API de DineroMail
	objXmlHTTP.send SOAPRequest
	
	' Cargamos objXMLDoc con el resultado del Webservice	
	objXMLDoc.load(objXmlHTTP.responseXML)	
		
	' Mostramos en pantalla el resultado de la operación.             
	SET nodeMerchantTransactionId = objXMLDoc.documentElement.selectNodes("//MerchantTransactionId")
	SET nodeUniqueMessageId = objXMLDoc.documentElement.selectNodes("//UniqueMessageId")
	SET nodeMessage = objXMLDoc.documentElement.selectNodes("//Message")
	SET nodeStatus = objXMLDoc.documentElement.selectNodes("//Status")
		
	Response.Write ("MerchantTransactionId: " & nodeMerchantTransactionId(0).text & "<br />")
	Response.Write ("UniqueMessageId: " & nodeUniqueMessageId(0).text & "<br />")
	Response.Write ("Message: " & nodeMessage(0).text & "<br />")
	Response.Write ("Status: " & nodeStatus(0).text & "<br />")			
	
	For Each xmlOperation In objXMLDoc.documentElement.selectNodes("//Operations//OperationDetail")				
		
		IF (xmlOperation.length > 0) THEN
		
			Response.Write ("<h1>Operation</h1><br/>")
			Response.Write ("Id: " & xmlOperation.selectSingleNode("//Id").Text & "<br/>")
			Response.Write ("Amount: " & xmlOperation.selectSingleNode("//Amount").Text & "<br/>")
			Response.Write ("Date: " & xmlOperation.selectSingleNode("//Date").Text & "<br/>")
			Response.Write ("NetAmount: " & xmlOperation.selectSingleNode("//NetAmount").Text & "<br/>")
			Response.Write ("PaymentMethod: " & xmlOperation.selectSingleNode("//PaymentMethod").Text & "<br/>")
			Response.Write ("Shares: " & xmlOperation.selectSingleNode("//Shares").Text & "<br/>")
			Response.Write ("State: " & xmlOperation.selectSingleNode("//State").Text & "<br/>")
			
			Response.Write ("<h2>Buyer</h2><br/>")				
			Response.Write ("Address: " & xmlOperation.selectSingleNode("//Buyer//Address").Text & "<br/>")
			Response.Write ("Comments: " & xmlOperation.selectSingleNode("//Buyer//Comments").Text & "<br/>")
			Response.Write ("DocumentType: " & xmlOperation.selectSingleNode("//Buyer//DocumentType").Text & "<br/>")
			Response.Write ("DocumentNumber: " & xmlOperation.selectSingleNode("//Buyer//DocumentNumber").Text & "<br/>")
			Response.Write ("DocumentNumber: " & xmlOperation.selectSingleNode("//Buyer//DocumentNumber").Text & "<br/>")
			Response.Write ("LastName: " & xmlOperation.selectSingleNode("//Buyer//LastName").Text & "<br/>")			
			Response.Write ("Name: " & xmlOperation.selectSingleNode("//Buyer//Name").Text & "<br/>")			
			Response.Write ("Phone: " & xmlOperation.selectSingleNode("//Buyer//Phone").Text & "<br/>")	
			Response.Write ("Email: " & xmlOperation.selectSingleNode("//Buyer//Email").Text & "<br/>")
			
			
			Response.Write ("<h2>Seller</h2><br/>")				
			Response.Write ("LastName: " & xmlOperation.selectSingleNode("//Seller//LastName").Text & "<br/>")			
			Response.Write ("Name: " & xmlOperation.selectSingleNode("//Seller//Name").Text & "<br/>")			
			Response.Write ("Phone: " & xmlOperation.selectSingleNode("//Seller//Phone").Text & "<br/>")	
			Response.Write ("Email: " & xmlOperation.selectSingleNode("//Seller//Email").Text & "<br/>")
			Response.Write ("DocumentType: " & xmlOperation.selectSingleNode("//Seller//DocumentType").Text & "<br/>")
			Response.Write ("DocumentNumber: " & xmlOperation.selectSingleNode("//Seller//DocumentNumber").Text & "<br/>")
			
			Response.Write ("<h2>Items</h2><br/>")				
			Response.Write ("Description: " & xmlOperation.selectSingleNode("//Items//OperationItem//Description").Text & "<br/>")
			Response.Write ("Currency: " & xmlOperation.selectSingleNode("//Items//OperationItem//Currency").Text & "<br/>")
			Response.Write ("UnitPrice: " & xmlOperation.selectSingleNode("//Items//OperationItem//UnitPrice").Text & "<br/>")
			Response.Write ("Quantity: " & xmlOperation.selectSingleNode("//Items//OperationItem//Quantity").Text & "<br/>")
						
		ELSE
		
			Response.Write ("<h3>No Hay Operaciones</h3><br/>")
			
		END IF
	Next	

	If Err.Number <> 0 Then
		Response.Write ("Error number " & Err.Number & " - Faultstring: " & Err.Description)
	End If
%>