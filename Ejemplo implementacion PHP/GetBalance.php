<?php

// <summary>
// 		GetBalance: Consulta del balance en la cuenta del usuario.
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">url WebService</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>
//		GetBalanceResult: (Status, Currency, Amount)
// </returns>

$APIPassword 			= "QAZXSWEDTGBYHNUJPLMOKNIJ"; 
$APIUserName 			= "TESTDMAPIPRO001";
$Crypt 					= false;
$MerchantTransactionId	= "1";
$UniqueMessageId		= "18";
$Hash					= "";
$ns						= "https://api.dineromail.com/";
$wsdlPath				= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{	
	// El $Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	$Hash = $MerchantTransactionId . $UniqueMessageId . $APIPassword;
	$Hash = MD5($Hash);

	if ($Crypt==true)
	{
		// Los datos de la API viajarán con una encriptación del tipo TripleDES
		$MerchantTransactionId = encryptTripleDES($APIPassword,$MerchantTransactionId);
		$UniqueMessageId = encryptTripleDES($APIPassword,$UniqueMessageId);
	}
			
	$soap_options = array('trace' => 1, 'exceptions' => 1);	
	$client = new SoapClient($wsdlPath,$soap_options); 	
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(  
								array('APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns
							);

	$request = array(	'Credential' => $credential
						,'Crypt' => $Crypt
						,'MerchantTransactionId' => $MerchantTransactionId
						,'UniqueMessageId' => $UniqueMessageId
						,'Hash' => $Hash);
						
	// Llamamos al Metodo GetBalance de la API de DineroMail
	$result = $client->GetBalance($request);
	
	// Mostramos en pantalla el resultado de la operación. 
    echo "MerchantTransactionId: " . $result->GetBalanceResult->MerchantTransactionId . "<br/>";
	echo "TransactionId: " . $result->GetBalanceResult->TransactionId . "<br/>";
	echo "Message: " . $result->GetBalanceResult->Message . "<br/>";
	echo "Status: " . $result->GetBalanceResult->Status . "<br/>";
	echo "UniqueMessageId: " . $result->GetBalanceResult->UniqueMessageId . "<br/>";
	
	if ($result->GetBalanceResult->Status == "OK")
	{
		echo "Currency: " . $result->GetBalanceResult->Balance->Balance->Currency . "<br/>";
		echo "Amount: " . $result->GetBalanceResult->Balance->Balance->Amount . "<br/>";
	}
}
catch (SoapFault $sf)
{
	echo "faultstring:". $sf->faultstring;
}

?>





