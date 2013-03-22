<?php

// <summary>
// GetOperations: Obtener lista operaciones de DineroMail por parte de los vendedores
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$StartDate">Fecha inicial, en un rango de fecha</param>
// <param name="$EndDate">Fecha final, en un rango de fecha</param>
// <param name="$OperationId">Identificador de la operación en DineroMail</param>
// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>Lista de Operaciones</returns>

$APIPassword 			= "QAZXSWEDTGBYHNUJPLMOKNIJ";
$APIUserName 			= "TESTDMAPIPRO001";
$Crypt 					= false;
$MerchantTransactionId	= "1";
$UniqueMessageId		= "25";
$StartDate 				= "2012-09-17";
$EndDate 				= "2012-10-01";
$OperationId			= "";
$Hash					= "";
$ns 					= "https://api.dineromail.com/";
$wsdlPath				= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{	
	// El $Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	$Hash = $MerchantTransactionId . $UniqueMessageId . $OperationId . $StartDate . $EndDate . $APIPassword;
	$Hash = MD5($Hash);
	
	if ($Crypt==true)
	{
		// Los datos de la API viajarán con una encriptación del tipo TripleDES
		$MerchantTransactionId = encryptTripleDES($APIPassword,$MerchantTransactionId);
		$UniqueMessageId =encryptTripleDES($APIPassword,$UniqueMessageId);
		$OperationId=encryptTripleDES($APIPassword,$OperationId);
		$StartDate=encryptTripleDES($APIPassword,$StartDate);
		$EndDate=encryptTripleDES($APIPassword,$EndDate);
	}
			
	$soap_options = array('trace' =>1,'exceptions'=>1);	
	$client = new SoapClient($wsdlPath,$soap_options); 	
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(	array('APIUserName' => $APIUserName,'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns	);
									
	// Datos de la solicitud					
	$request = array('Credential' =>$credential
					,'Crypt' =>  $Crypt
					,'MerchantTransactionId' => $MerchantTransactionId
					,'UniqueMessageId' => $UniqueMessageId
					,'OperationId' => $OperationId
					,'StartDate' => $StartDate
					,'EndDate' => $EndDate
					,'Hash' => $Hash);	
					
	// Llamamos al Metodo GetOperations de la API de DineroMail
	$result = $client->GetOperations($request);
	echo "<br/>";
	
	echo "Status: " . $result->GetOperationsResult->Status . "<br/>";
	echo "Message: " . $result->GetOperationsResult->Message . "<br/>";
	echo "MerchantTransactionId: " . $result->GetOperationsResult->MerchantTransactionId . "<br/>";
	echo "UniqueMessageId: " . $result->GetOperationsResult->UniqueMessageId . "<br/>";
	
	if($result->GetOperationsResult->Status == "OK")
	{
		foreach($result->GetOperationsResult->Operations->OperationDetail as $Operation)
		{
			echo "<h2>Operation</h2><br/>";
			echo "Id: " . $Operation->Id . "<br/>";
			echo "Amount: " . $Operation->Amount . "<br/>";
			echo "Date: " . $Operation->Date . "<br/>";
			echo "NetAmount: " . $Operation->NetAmount . "<br/>";
			echo "PaymentMethod: " . $Operation->PaymentMethod . "<br/>";
			echo "Shares: " . $Operation->Shares . "<br/>";
			echo "State: " . $Operation->State . "<br/>";
			
			echo "<h3>Buyer</h3><br/>";
			echo "Address: " . $Operation->Buyer->Address . "<br/>";
			echo "Comments: " . $Operation->Buyer->Comments . "<br/>";
			echo "DocumentType: " . $Operation->Buyer->DocumentType . "<br/>";
			echo "DocumentNumber: " . $Operation->Buyer->DocumentNumber . "<br/>";
			echo "LastName: " . $Operation->Buyer->LastName . "<br/>";			
			echo "Name: " . $Operation->Buyer->Name . "<br/>";			
			echo "Phone: " . $Operation->Buyer->Phone . "<br/>";	
			echo "Email: " . $Operation->Buyer->Email . "<br/>";
			
			echo "<h3>Seller</h3><br/>";
			echo "LastName: " . $Operation->Seller->LastName . "<br/>";			
			echo "Name: " . $Operation->Seller->Name . "<br/>";			
			echo "Phone: " . $Operation->Seller->Phone . "<br/>";	
			echo "Email: " . $Operation->Seller->Email . "<br/>";
			echo "DocumentType: " . $Operation->Seller->DocumentType . "<br/>";
			echo "DocumentNumber: " . $Operation->Seller->DocumentNumber . "<br/>";
			
			echo "<h2>Items</h2><br/>";	
			echo "Description: " . $Operation->Items->OperationItem->Description . "<br/>";
			echo "Currency: " . $Operation->Items->OperationItem->Currency . "<br/>";
			echo "UnitPrice: " . $Operation->Items->OperationItem->UnitPrice . "<br/>";
			echo "Quantity: " . $Operation->Items->OperationItem->Quantity . "<br/>";
			
			echo "<h2>----------------------------------------------------------------------</h2><br/>";			
		}	
	}
}
catch (SoapFault $sf)
{
	echo "faultstring:". $sf->faultstring;
}


// <summary>
// Metodo de Encriptación del tipo TripleDES
// </summary>
// <param name="$key">Clave secreta cuyo valor debe setear el usuario en DineroMail</param>
// <param name="$text">Cadena a encriptar</param>
// <returns>La cadena encriptada en 64 bits</returns>
function encryptTripleDES($key, $text){
	
	$vector = "uL%&(#(f";
    
	$td = mcrypt_module_open (MCRYPT_3DES, '', MCRYPT_MODE_CBC, '');

    // Complete the key
    $key_add = 24-strlen($key);
    $key .= substr($key,0,$key_add);

    // Padding the text
    $text_add = strlen($text)%8;
    for($i=$text_add; $i<8; $i++){
        $text .= chr(8-$text_add);
    }

    mcrypt_generic_init ($td, $key, $vector);
    $encrypt64 = mcrypt_generic ($td, $text);
    mcrypt_generic_deinit($td);
    mcrypt_module_close($td);
	
    return base64_encode($encrypt64);
}

?>





