<?php

// <summary>
// 		Refund: Realizar Reembolsos
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Currency">Identificador de la moneda</param>
// <param name="$Amount">Importe a reembolsar</param>
// <param name="$Subject">Concepto o asunto del reembolso</param>
// <param name="$Message">Mensaje del vendedor hacia el comprador</param>// <param name="$Hash">Cadena a encriptar</param>
// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>
// 		Estado de la Operación
// </returns>

$APIPassword 					= "QAZXSWEDTGBYHNUJPLMOKNIJ";
$APIUserName 					= "TESTDMAPIPRO001";
$Crypt 							= false;
$MerchantTransactionId 			= "14324234";
$UniqueMessageId 				= "7398234234995";
$Currency 						= "ARG";
$Amount 						= "10.40";
$Subject 						= "Subject";
$Message 						= "Message";
$Hash							= "";
$ns 							= "https://api.dineromail.com/";
$wsdlPath						= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{                           
	// El $Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	$Hash = $MerchantTransactionId . $UniqueMessageId . $Currency . $Amount . $Subject . $Message . $APIPassword;
	$Hash = MD5( $Hash );

	$soap_options = array('trace' => 1,'exceptions' => 1);
	$client = new SoapClient($wsdlPath,$soap_options);
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(  array('APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns	);
   
	// Datos de la solicitud
	$request = array(	'Credential' => $credential
						,'Crypt' => $Crypt
						,'MerchantTransactionId' => $MerchantTransactionId
						,'UniqueMessageId' => $UniqueMessageId
						,'Currency' => $Currency
						,'Amount' => $Amount
						,'Subject' => $Subject
						,'Message' => $Message
						,'Hash' => $Hash);

	// Llamamos al Metodo Refund de la API de DineroMail
	$result = $client->Refund($request);				

	echo "<br/>";
	echo "MerchantTransactionId: " . $result->RefundResult->MerchantTransactionId . "<br/>";
	echo "Message: " . $result->RefundResult->Message . "<br/>";
	echo "Status: " . $result->RefundResult->Status . "<br/>";
	echo "TransactionId: " . $result->RefundResult->TransactionId . "<br/>";
}
catch (SoapFault $sf)
{
		echo "faultstring:". $sf->faultstring;
} 
?>