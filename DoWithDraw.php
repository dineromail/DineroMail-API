<?php
// <summary>
// DoWithDraw: Realizar "Retiro de fondos" de la cuenta de DineroMail
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Currency">Moneda del importe a retirar</param>
// <param name="$Amount">Importe a retirar</param>
// <param name="$Method">Identificador del método a utilizar para el retiro defondos</param>

// <param name="$Street">Calle donde recibirá el cheque</param>
// <param name="$Number">Altura de la calle donde recibirá el cheque</param>
// <param name="$Floor">Piso en caso de vivir en edificio.</param>
// <param name="$Appartment">Departamento.</param>
// <param name="$Zip">Código postal.</param>
// <param name="$City">Identificador de Ciudad</param>
// <param name="$State">Identificador de Estado o provincia</param>

// <param name="$Bank">Identificador del banco</param>
// <param name="$BankNumber">Número de la cuenta bancaria</param>
// <param name="$Type">Identifica el tipo de cuenta bancaria</param>
// <param name="$Name">Nombre del titular de la cuenta bancaria</param>
// <param name="$LastName">Apellido del titular de la cuenta bancaria</param>
// <param name="$DocumentType">Tipo de documento del titular</param>
// <param name="$DocumentNumber">Número de documento del titular</param>
// <param name="$Branch">Solamente necesario en Brasil. Por defecto enviar 0 cero.</param>

// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>Estado de la operación</returns>

$APIPassword 			= "QAZXSWEDTGBYHNUJPLMOKNIJ";
$APIUserName 			= "TESTDMAPIPROBR1";
$Crypt 					= false;
$MerchantTransactionId	= "1";
$UniqueMessageId		= "1";
$Currency				= "BRL";
$Amount					= "10.40";
$Method					= "Bank";
                          
$Street					= "Street";
$Number					= "123";
$Floor					= "1";
$Appartment				= "B";
$Zip					= "134";
$City					= "Brasilia";
$State					= "Brasilia";
                          
$Bank					= "Banco Santander";
$BankNumber				= "12341234";
$Type					= "CA";
$Name					= "Juan";
$LastName				= "Lopez";
$DocumentType			= "1";
$DocumentNumber			= "29200100";
$Branch					= "1";
                          
$Hash					= "";
$ns 					= "https://api.dineromail.com/";
$wsdlPath				= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{	
	// El $Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	$FullAddressDetail = $Street . $Number . $Floor . $Appartment . $Zip . $City . $State;
	$FullBankAccountDetail = $Bank . $BankNumber . $Type . $Name . $LastName . $DocumentType . $DocumentNumber . $Branch;
	$Hash = $MerchantTransactionId . $UniqueMessageId . $Method . $Currency . $Amount . $FullAddressDetail . $FullBankAccountDetail . $APIPassword;
	$Hash = MD5($Hash);
			
	$soap_options = array('trace' => 1,'exceptions' => 1);	
	$client = new SoapClient($wsdlPath,$soap_options); 	
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(	array('APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns	);
	
	// Detalla la dirección de entrega
	$addressDetail = new SOAPVar(   array(	'Street' => $Street
											,'Number' => $Number
											,'Floor' => $Floor
											,'Appartment' => $Appartment
											,'Zip' => $Zip
											,'City' => $City
											,'State' => $State)
									, SOAP_ENC_OBJECT
									, 'AddressDetail'
									, $ns	);
	
	// Detalla la cuenta bancaria
	$bankAccountDetail = new SOAPVar(	array(	'Bank' => $Bank
												,'Type' => $Type
												,'Name' => $Name
												,'LastName' => $LastName
												,'DocumentType' => $DocumentType
												,'DocumentNumber' => $DocumentNumber
												,'Branch' => $Branch
												,'BankNumber' => $BankNumber)
										, SOAP_ENC_OBJECT
										, 'BankAccountDetail'
										, $ns	);								
									
	// Datos de la solicitud
	$request = array(	'Credential' => $credential
						,'Crypt' => $Crypt
						,'MerchantTransactionId' => $MerchantTransactionId
						,'UniqueMessageId' => $UniqueMessageId
						,'Currency' => $Currency
						,'Amount' => $Amount
						,'Method' => $Method
						,'AddressDetail' => $addressDetail
						,'BankAccountDetail' => $bankAccountDetail
						,'Hash' => $Hash);	
	
	// Llamamos al Metodo DoWithDraw de la API de DineroMail
	$result = $client->DoWithDraw($request);
	
	// Mostramos en pantalla el resultado de la operación. 
    echo "MerchantTransactionId: " . $result->DoWithDrawResult->MerchantTransactionId . "<br/>";
	echo "UniqueMessageId: " . $result->DoWithDrawResult->UniqueMessageId . "<br/>";
	echo "TransactionId: " . $result->DoWithDrawResult->TransactionId . "<br/>";
	echo "Message: " . $result->DoWithDrawResult->Message . "<br/>";
	echo "Status: " . $result->DoWithDrawResult->Status . "<br/>";
	
}
catch (SoapFault $sf)
{
	echo "faultstring:". $sf->faultstring;
}
?>





