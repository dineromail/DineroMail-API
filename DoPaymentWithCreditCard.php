<?PHP  

// <summary>
// 		DoPaymentWithCreditCard: Realizar pagos con "Tarjetas de Credito".
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Provider">Proveedor con el cual se realiza el pago</param>
// <param name="$Subject">Concepto o asunto del comprador hacia el vendedor</param>
// <param name="$Message">Mensaje del comprador hacia el vendedor</param>

// <param name="$Currency">Moneda correspondiente al precio del ítem</param>
// <param name="$Amount">Precio del ítem</param>
// <param name="$Code">Identificador (ID) generado por el vendedor</param>
// <param name="$Description">Descripción del ítem</param>
// <param name="$ItemName">Nombre del ítem</param>
// <param name="$Quantity">Cantidad de ítems</param>

// <param name="$Address">Dirección del comprador</param>
// <param name="$City">Ciudad del comprador</param>
// <param name="$Country">Pais del comprador</param>
// <param name="$Email">Email del comprador</param>
// <param name="$Name">Nombre del comprador</param>
// <param name="$LastName">Apellido del comprador</param>
// <param name="$Phone">Telefono del comprador</param>

// <param name="$ccAddress">Dirección del titular de la tarjeta de crédito</param>
// <param name="$ccAddressComplement">Complemento de la dirección del titular de latarjeta de crédito</param>
// <param name="$ccAddressNumber">Número de la dirección del titular de la tarjetade crédito</param>
// <param name="$ccCity">Ciudad de residencia del titular de la tarjetade crédito.</param>
// <param name="$ccCountry">País de residencia del titular de la tarjeta decrédito</param>
// <param name="$ccNeighborhood">Barrio del titular de la tarjeta de crédito</param>
// <param name="$ccState">Estado de residencia del titular de la tarjeta decrédito</param>
// <param name="$ccZipCode">Código postal de la dirección del titular de latarjeta de crédito</param>
// <param name="$ccBankId">Identificador del Banco emisor de la tarjeta de crédito</param>

// <param name="$ccCreditCardNumber">Número de tarjeta de crédito</param>
// <param name="$ccDocumentNumber">Número de documento del titular de latarjeta de crédito</param>
// <param name="$ccExpirationDate">Fecha de expiración de la tarjeta de crédito</param>
// <param name="$ccHolder">Titular de la tarjeta de crédito</param>
// <param name="$ccInstallment">Cantidad de cuotas en las cuales se va arealizar el pago</param>
// <param name="$ccSecurityCode">Código de seguridad de la tarjeta de crédito</param>

// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>
// 		Estado de la operación
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

