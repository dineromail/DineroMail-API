<?php
// <summary>
// SendMoney: Realizar un "Envío de dinero".
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Currency">Moneda del importe a enviar</param>
// <param name="$Amount">Importe a enviar</param>
// <param name="$MailTo">Email del usuario que recibe el dinero</param>
// <param name="$Subject">Concepto del envío de dinero</param>
// <param name="$Message">Mensaje al usuario destinatario del dinero</param>
// <param name="$PayOff">Identifica el origen del envío de dinero</param>
// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>Estado de la operación</returns>

$APIPassword 			= "QAZXSWEDTGBYHNUJPLMOKNIJ";
$APIUserName 			= "TESTDMAPIPRO001";
$Crypt 					= true;
$MerchantTransactionId	= "1";
$UniqueMessageId		= "1";
$Currency				= "BRL";
$Amount					= "10.40";
$MailTo					= "testdineromail@testdineromail.com";
$Subject				= "Subject";
$Message				= "Message";
$PayOff					= "Producto Sale";
$Hash					= ""; 
$ns 					= "https://api.dineromail.com/";
$wsdlPath				= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{	
	// El $Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	$Hash = $MerchantTransactionId . $UniqueMessageId . $Currency . $Amount . $MailTo . $Subject . $Message . $APIPassword;
	$Hash = MD5($Hash);
	
	if ($Crypt==true)
	{
		// Los datos de la API viajarán con una encriptación del tipo TripleDES
		$MerchantTransactionId = encryptTripleDES($APIPassword,$MerchantTransactionId);
		$UniqueMessageId =encryptTripleDES($APIPassword,$UniqueMessageId);
		$Currency=encryptTripleDES($APIPassword,$Currency);
		$Amount=encryptTripleDES($APIPassword,$Amount);
		$MailTo=encryptTripleDES($APIPassword,$MailTo);
		$Subject=encryptTripleDES($APIPassword,$Subject);
		$Message=encryptTripleDES($APIPassword,$Message);
		$PayOff=encryptTripleDES($APIPassword,$PayOff);
	}
			
	$soap_options = array('trace' =>1,'exceptions'=>1);	
	$client = new SoapClient($wsdlPath,$soap_options); 	
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(	array(	'APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns	);
	
	// Datos de la solicitud
	$request = array('Credential' =>$credential
					,'Crypt' =>  $Crypt
					,'MerchantTransactionId' => $MerchantTransactionId
					,'UniqueMessageId' => $UniqueMessageId
					,'Currency' => $Currency
					,'Amount' => $Amount
					,'MailTo' => $MailTo
					,'Subject' => $Subject
					,'Message' => $Message
					,'PayOff' => $PayOff
					,'Hash' => $Hash);
	
	// Llamamos al Metodo SendMoney de la API de DineroMail
	$result = $client->SendMoney($request);
	
	echo "<br/>";
	echo "MerchantTransactionId: " . $result->SendMoneyResult->MerchantTransactionId . "<br/>";
	echo "TransactionId: " . $result->SendMoneyResult->TransactionId . "<br/>";
	echo "Message: " . $result->SendMoneyResult->Message . "<br/>";
	echo "Status: " . $result->SendMoneyResult->Status . "<br/>";
	echo "UniqueMessageId: " . $result->SendMoneyResult->UniqueMessageId . "<br/>";
	
	// Status values:
	// 	COMPLETED = 0,
    // 	ERROR = 1,        
    // 	DENIED = 2,
    // 	PENDING = 3	
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