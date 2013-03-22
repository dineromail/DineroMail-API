<?PHP  

// <summary>
// 		DoPaymentWithCreditCard: Realizar pagos con "Tarjetas de Credito".
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilizaci�n de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacci�n, corresponde al identificador de transacci�n del Comerciente</param>
// <param name="$UniqueMessageId">Identificador �nico de mensaje, no puede repetirse en futuras conexiones. (Autonum�rico)</param>
// <param name="$Provider">Proveedor con el cual se realiza el pago</param>
// <param name="$Subject">Concepto o asunto del comprador hacia el vendedor</param>
// <param name="$Message">Mensaje del comprador hacia el vendedor</param>

// <param name="$Currency">Moneda correspondiente al precio del �tem</param>
// <param name="$Amount">Precio del �tem</param>
// <param name="$Code">Identificador (ID) generado por el vendedor</param>
// <param name="$Description">Descripci�n del �tem</param>
// <param name="$ItemName">Nombre del �tem</param>
// <param name="$Quantity">Cantidad de �tems</param>

// <param name="$Address">Direcci�n del comprador</param>
// <param name="$City">Ciudad del comprador</param>
// <param name="$Country">Pais del comprador</param>
// <param name="$Email">Email del comprador</param>
// <param name="$Name">Nombre del comprador</param>
// <param name="$LastName">Apellido del comprador</param>
// <param name="$Phone">Telefono del comprador</param>

// <param name="$ccAddress">Direcci�n del titular de la tarjeta de cr�dito</param>
// <param name="$ccAddressComplement">Complemento de la direcci�n del titular de latarjeta de cr�dito</param>
// <param name="$ccAddressNumber">N�mero de la direcci�n del titular de la tarjetade cr�dito</param>
// <param name="$ccCity">Ciudad de residencia del titular de la tarjetade cr�dito.</param>
// <param name="$ccCountry">Pa�s de residencia del titular de la tarjeta decr�dito</param>
// <param name="$ccNeighborhood">Barrio del titular de la tarjeta de cr�dito</param>
// <param name="$ccState">Estado de residencia del titular de la tarjeta decr�dito</param>
// <param name="$ccZipCode">C�digo postal de la direcci�n del titular de latarjeta de cr�dito</param>
// <param name="$ccBankId">Identificador del Banco emisor de la tarjeta de cr�dito</param>

// <param name="$ccCreditCardNumber">N�mero de tarjeta de cr�dito</param>
// <param name="$ccDocumentNumber">N�mero de documento del titular de latarjeta de cr�dito</param>
// <param name="$ccExpirationDate">Fecha de expiraci�n de la tarjeta de cr�dito</param>
// <param name="$ccHolder">Titular de la tarjeta de cr�dito</param>
// <param name="$ccInstallment">Cantidad de cuotas en las cuales se va arealizar el pago</param>
// <param name="$ccSecurityCode">C�digo de seguridad de la tarjeta de cr�dito</param>

// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>
// 		Estado de la operaci�n
// </returns>

$APIUserName 			= "TEST-TEST-TEST-TEST";
$APIPassword 			= "TEST";
$Crypt 					= false;
$MerchantTransactionId	= "1";
$UniqueMessageId		= "1";  
$Provider  				= "AR_MASTER";
$Subject 				= "Subject";
$Message 				= "Message";
$Hash					= "";

$Currency 				= "ARS";
$Amount 				= "10";
$Code	 				= "1234567";
$Description 			= "TestOrder";
$ItemName 				= "TestOrder";
$Quantity 				= "1";

$Address 				= "123 Street";
$City 					= "";
$Country 				= "ARGENTINA";
$Email 					= "integrationdm01@gmail.com";
$Name 					= "int";
$LastName 				= "support";
$Phone 					= "1234567890";

$ccAddress	 			= "Street";
$ccAddressComplement 	= "";
$ccAddressNumber 		= "123" ;
$ccCity 				= "";
$ccCountry 				= "";
$ccNeighborhood 		= "";
$ccState 				= "";
$ccZipCode 				= "";
$ccBankId 				= 0;

$ccCreditCardNumber 	= "5114920090135851";
$ccDocumentNumber 		= "27000000";
$ccExpirationDate 		= "11/14";
$ccHolder 				= "test";
$ccInstallment 			= "1";
$ccSecurityCode 		= "111";



$ns 					= "https://api.dineromail.com/";
$wsdlPath 				= "https://api.dineromail.com/DMAPI.asmx?WSDL";

try
{
	$Items = $Amount . $Code . $Currency . $Description . $ItemName . $Quantity;
	$Buyer = $Name . $LastName . $Email . $Address . $Phone . $Country . $City;
	$CreditCard = $ccInstallment . $ccCreditCardNumber . $ccHolder . $ccExpirationDate . 
				  $ccSecurityCode . $ccDocumentNumber . $ccAddress . $ccAddressNumber . 
				  $ccAddressComplement . $ccZipCode . $ccNeighborhood . $ccCity . 
				  $ccState . $ccCountry;
	$Hash = $MerchantTransactionId . $UniqueMessageId . $Items . $Buyer . $CreditCard . 
			$Provider . $Subject . $Message . $APIPassword;
	$Hash = MD5( $Hash );

	$soap_options = array('trace' => 1,'exceptions' => 1);
	$client = new SoapClient($wsdlPath, $soap_options);

	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(	array('APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns	);

	// Detalla el Item a pagar
	$Item = new SOAPVar(array('Amount' => $Amount
							 ,'Code' => $Code
							 ,'Currency' => $Currency
							 ,'Description' => $Description
							 ,'Name' => $ItemName
							 ,'Quantity' => $Quantity)
						, SOAP_ENC_OBJECT
						, 'Item'
						, $ns);

	$Items=array($Item);

	$BuyerObject = new SOAPVar(array( 'Address' => $Address
									 ,'City' => $City
									 ,'Country' => $Country
									 ,'Email' => $Email
									 ,'LastName' => $LastName
									 ,'Name' => $Name
									 ,'Phone' => $Phone)
							  , SOAP_ENC_OBJECT
							  , 'Buyer'
							  , $ns);

	$CartaoObject = new SOAPVar(array( 'Installment' => $ccInstallment
									  ,'CreditCardNumber' => $ccCreditCardNumber
									  ,'DocumentNumber' => $ccDocumentNumber
									  ,'Holder' => $ccHolder
									  ,'ExpirationDate' => $ccExpirationDate
									  ,'SecurityCode' => $ccSecurityCode
									  ,'Address' => $ccAddress
									  ,'AddressNumber' => $ccAddressNumber
									  ,'AddressComplement' => $ccAddressComplement
									  ,'ZipCode' => $ccZipCode
									  ,'Neighborhood' => $ccNeighborhood
									  ,'City' => $ccCity
									  ,'State' => $ccState
									  ,'Country' => $ccCountry
									  ,'BankId' => $ccBankId)																	
							    , SOAP_ENC_OBJECT
								, 'CreditCard'
								, $ns);



	$request = array('Credential' =>$credential
					,'Crypt' =>  $Crypt
					,'MerchantTransactionId' => $MerchantTransactionId
					,'Items'=>$Items
					,'Buyer'=>$BuyerObject
					,'Provider' => $Provider
					,'CreditCard' => $CartaoObject
					,'Subject' => $Subject
					,'Message' => $Message
					,'UniqueMessageId' => $UniqueMessageId
					,'Hash' => $Hash
				);

	$result = $client->DoPaymentWithCreditCard($request);

	echo "MerchantTransactionId: " . $result->DoPaymentWithCreditCardResult->MerchantTransactionId . "<br/>";
	echo "Message: " . $result->DoPaymentWithCreditCardResult->Message . "<br/>";
	echo "Status: " . $result->DoPaymentWithCreditCardResult->Status . "<br/>";
	echo "TransactionId: " . $result->DoPaymentWithCreditCardResult->TransactionId . "<br/>";
}
catch (SoapFault $sf)
{
	echo "faultstring:". $sf->faultstring;
}
?>

