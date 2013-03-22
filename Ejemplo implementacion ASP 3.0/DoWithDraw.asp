<%@ Language=VBScript %>
<%Option Explicit%> 

<!-- #include file = "hex_md5_js.asp" -->

<!-- 
	<summary>
		DoWithDraw: Realizar "Retiro de fondos" de la cuenta de DineroMail
	</summary>
	<param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
	<param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
	<param name="Crypt">Indica si se envian los datos encriptados</param>
	<param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
	<param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
	<param name="cCurrency">Moneda del importe a retirar</param>
	<param name="Amount">Importe a retirar</param>
	<param name="Method">Identificador del método a utilizar para el retiro defondos</param>

	<param name="Street">Calle donde recibirá el cheque</param>
	<param name="Number">Altura de la calle donde recibirá el cheque</param>
	<param name="Floor">Piso en caso de vivir en edificio.</param>
	<param name="Appartment">Departamento.</param>
	<param name="Zip">Código postal.</param>
	<param name="City">Identificador de Ciudad</param>
	<param name="State">Identificador de Estado o provincia</param>

	<param name="Bank">Identificador del banco</param>
	<param name="BankNumber">Número de la cuenta bancaria</param>
	<param name="bType">Identifica el tipo de cuenta bancaria</param>
	<param name="Name">Nombre del titular de la cuenta bancaria</param>
	<param name="LastName">Apellido del titular de la cuenta bancaria</param>
	<param name="DocumentType">Tipo de documento del titular</param>
	<param name="DocumentNumber">Número de documento del titular</param>
	<param name="Branch">Solamente necesario en Brasil. Por defecto enviar 0 cero.</param>

	<param name="Hash">Cadena a encriptar</param>
	<param name="NSpace">NameSpace del Servicio</param>
	<param name="WsdlPath">WebService endPoint</param>
	
	<returns>
		Estado de la operación
	</returns>
-->
<%
	Dim APIPassword           : APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ"
	Dim APIUserName           : APIUserName = "TESTDMAPIPRO001"
	Dim Crypt                 : Crypt = "false"
	Dim MerchantTransactionId : MerchantTransactionId = "1"
	Dim UniqueMessageId       : UniqueMessageId = "11"
	                            
	Dim cCurrency             : cCurrency = "BRL"
	Dim Amount                : Amount = "10.40"
	Dim Method                : Method = "BANK"
                                
	Dim Street                : Street = "Street"
	Dim Number                : Number = "123"
	Dim Floor                 : Floor = "1"
	Dim Appartment            : Appartment = "B"
	Dim Zip                   : Zip = "134"
	Dim City                  : City = "Brasilia"
	Dim State                 : State = "Brasilia"
                                
	Dim Bank                  : Bank = "72"
	Dim BankNumber            : BankNumber = "12341234"
	Dim bType                 : bType = "CA"
	Dim Name                  : Name = "Juan"
	Dim LastName              : LastName = "Lopez"
	Dim DocumentType          : DocumentType = "1"
	Dim DocumentNumber        : DocumentNumber = "29200100"
	Dim Branch                : Branch = "1"
	                           
	Dim Hash                  : Hash = ""
	Dim NSpace                : NSpace = "https://api.dineromail.com/DoWithDraw"
	Dim WsdlPath              : WsdlPath = "https://api.dineromail.com/DMAPI.asmx?WSDL"
	
	Dim objXmlHTTP, SOAPRequest
	Dim objXMLDoc, nodeMerchantTransactionId, nodeTransactionId, nodeMessage, nodeStatus, nodeUniqueMessageId

	On Error Resume Next

	' El Hash es el cálculo MD5 de los valores 
	' de los siguientes parámetros en orden especificado.
	Dim FullAddressDetail     : FullAddressDetail = Street & Number & Floor & Appartment & Zip & City & State
	Dim FullBankAccountDetail : FullBankAccountDetail = Bank & BankNumber & bType & Name & LastName & DocumentType & DocumentNumber & Branch
	Hash = MerchantTransactionId & UniqueMessageId & Method & cCurrency & Amount & FullAddressDetail & FullBankAccountDetail & APIPassword
	Hash = hex_md5(Hash)

	Set objXmlHTTP = CreateObject("MSXML2.XMLHTTP")
	Set objXMLDoc = Server.CreateObject("MSXML2.DOMDocument")

	objXmlHTTP.Open "POST", WsdlPath, False 
	objXmlHTTP.setRequestHeader "Content-Type", "text/xml charset=utf-8" 
	objXmlHTTP.setRequestHeader "SOAPAction", NSpace

	' Datos de la solicitud para SOAP 1.1					
	SOAPRequest = _
		"<?xml version=""1.0"" encoding=""utf-8""?>" &_
		"<soap:Envelope xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance"" xmlns:xsd=""http://www.w3.org/2001/XMLSchema"" xmlns:soap=""http://schemas.xmlsoap.org/soap/envelope/"">" &_
		  "<soap:Body>" &_
			"<DoWithDraw xmlns=""https://api.dineromail.com/"">" &_
			  "<Credential>" &_
				"<APIUserName>" & APIUserName & "</APIUserName>" &_
				"<APIPassword>" & APIPassword & "</APIPassword>" &_			
			  "</Credential>" &_
			  "<Crypt>" & Crypt & "</Crypt>" &_
			  "<MerchantTransactionId>" & MerchantTransactionId & "</MerchantTransactionId>" &_
			  "<UniqueMessageId>" & UniqueMessageId & "</UniqueMessageId>" &_
			  "<Method>" & Method & "</Method>" &_
			  "<Currency>" & cCurrency & "</Currency>" &_
			  "<Amount>" & Amount & "</Amount>" &_
			  "<AddressDetail>" &_
				"<Street>" & Street & "</Street>" &_
				"<Number>" & Number & "</Number>" &_
				"<Floor>" & Floor & "</Floor>" &_
				"<Appartment>" & Appartment & "</Appartment>" &_
				"<Zip>" & Zip & "</Zip>" &_
				"<City>" & City & "</City>" &_
				"<State>" & State & "</State>" &_
			  "</AddressDetail>" &_
			  "<BankAccountDetail>" &_
				"<Bank>" & Bank & "</Bank>" &_
				"<Type>" & bType & "</Type>" &_
				"<Name>" & Name & "</Name>" &_
				"<LastName>" & LastName & "</LastName>" &_
				"<DocumentType>" & DocumentType & "</DocumentType>" &_
				"<DocumentNumber>" & DocumentNumber & "</DocumentNumber>" &_
				"<Branch>" & Branch & "</Branch>" &_
				"<BankNumber>" & BankNumber & "</BankNumber>" &_
			  "</BankAccountDetail>" &_
			  "<Hash>" & Hash & "</Hash>" &_
			"</DoWithDraw>" &_
		  "</soap:Body>" &_
		"</soap:Envelope>"
		
	' Enviamos los datos al Metodo DoWithDraw de la API de DineroMail
	objXmlHTTP.send SOAPRequest	

	' Cargamos objXMLDoc con el resultado del Webservice
	objXMLDoc.load(objXmlHTTP.responseXML) 
	
	' Mostramos en pantalla el resultado de la operación.             
	SET nodeMerchantTransactionId = objXMLDoc.documentElement.selectNodes("//MerchantTransactionId")
	SET nodeUniqueMessageId = objXMLDoc.documentElement.selectNodes("//UniqueMessageId")
	SET nodeTransactionId = objXMLDoc.documentElement.selectNodes("//TransactionId")
	SET nodeMessage = objXMLDoc.documentElement.selectNodes("//Message")
	SET nodeStatus = objXMLDoc.documentElement.selectNodes("//Status")			
		
	Response.Write ("MerchantTransactionId: " & nodeMerchantTransactionId(0).text & "<br />")
	Response.Write ("UniqueMessageId: " & nodeUniqueMessageId(0).text & "<br />")
	Response.Write ("TransactionId: " & nodeTransactionId(0).text & "<br />")
	Response.Write ("Message: " & nodeMessage(0).text & "<br />")
	Response.Write ("Status: " & nodeStatus(0).text & "<br />")		

	If Err.Number <> 0 Then
		Response.Write ("Error number " & cStr(Err.Number) & " - Faultstring: " & Err.Description)
	End If
%>