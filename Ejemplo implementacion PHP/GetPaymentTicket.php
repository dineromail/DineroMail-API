<?php
// <summary>
// 		GetPaymentTicket: Permite obtener un cupón de pago de cualquier proveedor de código de barras y lo asigna al comercio.
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Provider">Identifica el proveedor con el cual se desea realizar el pago</param>
// <param name="$Currency">Identificador de la moneda para el importe a enviar</param>
// <param name="$Amount">Importe a enviar</param>
// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>
//		Estado de la operación
// </returns>

$APIPassword 			= "TEST-TEST-TEST-TEST-TEST";
$APIUserName 			= "TEST";
$Crypt 					= false;
$MerchantTransactionId 	= "1";
$UniqueMessageId 		= "4";
$Provider 				= "servipag";
$Currency 				= "ARS";
$Amount 				= "10.55";
$Hash					= "";
$ns 					= "https://api.dineromail.com/";
$wsdlPath 				= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{	
	$Hash = $MerchantTransactionId . $UniqueMessageId . $Currency . $Amount . $Provider . $APIPassword;
	$Hash = MD5($Hash);	
			
	$soap_options = array('trace' => 1,'exceptions' => 1);	
	$client = new SoapClient($wsdlPath, $soap_options); 	
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(  
								array('APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns
							);									
	
	// Datos de la solicitud
	$request = array('Credential' => $credential
					,'Crypt' => $Crypt
					,'MerchantTransactionId' => $MerchantTransactionId
					,'UniqueMessageId' => $UniqueMessageId
					,'Provider' => $Provider
					,'Amount' => $Amount
					,'Currency' => $Currency
					,'Hash' => $Hash);	
	
	// Llamamos al Metodo GetPaymentTicket de la API de DineroMail
	$result = $client->GetPaymentTicket($request);
	
	// Mostramos en pantalla el resultado de la operación. 
	echo "MerchantTransactionId: " . $result->GetPaymentTicketResult->MerchantTransactionId . "<br/>";
	echo "Status: " . $result->GetPaymentTicketResult->TransactionId . "<br/>";
	echo "Message: " . $result->GetPaymentTicketResult->Message . "<br/>";
	echo "Status: " . $result->GetPaymentTicketResult->Status . "<br/>";
	echo "TransactionId: " . $result->GetPaymentTicketResult->TransactionId . "<br/>";
	echo "BarcodeDigits: " . $result->GetPaymentTicketResult->BarcodeDigits . "<br/>";
	echo "BarcodeImageUrl: " . $result->GetPaymentTicketResult->BarcodeImageUrl . "<br/>";
	echo "VoucherUrl: " . $result->GetPaymentTicketResult->VoucherUrl . "<br/>";
	
}
catch (SoapFault $sf)
{
	echo "faultstring:". $sf->faultstring;
}
?>





