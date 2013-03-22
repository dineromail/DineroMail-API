<?php
// <summary>
// DoPaymentWithReference: "Realizar pago" de Botón o Carrito de compras, con códigos de barra.
// </summary>
// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
// <param name="$Crypt">Indica si se envian los datos encriptados</param>
// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
// <param name="$Provider">Identifica el proveedor con el cual se desea realizar el pago</param>
// <param name="$Subject">Concepto o asunto del comprador hacia el vendedor</param>
// <param name="$Message">Mensaje del comprador hacia el vendedor</param>

// <param name="$Currency">Identificador de la moneda para el ítem</param>
// <param name="$Amount">Importe del ítem</param>
// <param name="$Code">Identificador generado por el comercio</param>
// <param name="$Description">Descripción del ítem</param>
// <param name="$ItemName">Nombre o titulo del ítem</param>
// <param name="$Quantity">Cantidad de ítems a pagar</param>

// <param name="$Address">Dirección del comprador</param>
// <param name="$City">Ciudad o provincia del comprador</param>
// <param name="$Country">País del comprador</param>
// <param name="$Email">Email del comprador</param>
// <param name="$Name">Nombre del comprador</param>
// <param name="$LastName">Apellido del comprador</param>
// <param name="$Phone">Teléfono del comprador</param>

// <param name="$Hash">Cadena a encriptar</param>
// <param name="$ns">NameSpace del Servicio</param>
// <param name="$wsdlPath">WebService endPoint</param>
// <returns>BarcodeDigits, BarcodeImageUrl, VoucherUrl</returns>

$APIPassword 			= "TEST-TEST-TEST-TEST-TEST";
$APIUserName 			= 'TEST';
$Crypt 					= true;
$MerchantTransactionId	= "1";
$UniqueMessageId		= "1";
$Provider				= "pagofacil";
$Subject				= "Subject";
$Message				= "Message";
                          
$Currency				= "ARG";
$Amount					= "10.40";
$Code					= "A001";
$Description			= "Product A001";
$ItemName				= "LCD Monitor";
$Quantity				= "1";
                          
$Address				= 'Charcas 2034';
$City					= 'Buenos Aires';
$Country				= 'Argentina';
$Email					= 'mailtest@mailtest.com';
$Name					= 'Carlos';
$LastName				= 'Lopez';
$Phone 					= '45556565';
                          
$Hash					= "";
$ns 					=  'https://sandboxapi.dineromail.com/';
$wsdlPath				= "https://sandboxapi.dineromail.com/DMAPI.asmx?WSDL";

try
{	
	// El $Hash es el cálculo MD5 de los valores 
	// de los siguientes parámetros en orden especificado.
	$Items = $Amount . $Code . $Currency . $Description . $ItemName . $Quantity;
	$Buyer = $Name . $LastName . $Email . $Address . $Phone . $Country . $City;
	$Hash = $MerchantTransactionId . $UniqueMessageId . $Items . $Buyer . $Provider . $Subject . $Message . $APIPassword;
	$Hash = MD5( $Hash );
	
	$soap_options = array('trace' => 1,'exceptions' => 1);	
	$client = new SoapClient( $wsdlPath, $soap_options ); 	
	
	// La Credential es la tarjeta de acceso a la API de DineroMail
	$credential = new SOAPVar(	array('APIUserName' => $APIUserName, 'APIPassword' => $APIPassword)
								, SOAP_ENC_OBJECT
								, 'APICredential'
								, $ns	);
									
	// Detalla el Item a pagar
	$Item = new SOAPVar(   array('Amount' => $Amount
								,'Code' => $Code
								,'Currency' => $Currency
								,'Description' => $Description
								,'Name' => $ItemName
								,'Quantity' => $Quantity)
								, SOAP_ENC_OBJECT, 'Item', $ns);	

	$Items=array($Item);
											
	// Detalla datos del comprador
	$BuyerObject = new SOAPVar(array('Address' => $Address
								,'City' => $City
								,'Country' => $Country
								,'Email' => $Email
								,'LastName' => $LastName
								,'Name' => $Name
								,'Phone' => $Phone)
								, SOAP_ENC_OBJECT, 'Buyer', $ns);

	// Datos de la solicitud
	$request = array('Credential' =>$credential
					,'Crypt' =>  $Crypt
					,'MerchantTransactionId' => $MerchantTransactionId
					,'UniqueMessageId' => $UniqueMessageId
					,'Provider' => $Provider
					,'Message' => $Message
					,'Subject' => $Subject
					,'Items' => $Items
					,'Buyer' => $BuyerObject
					,'Hash' => $Hash);	
	
	// Llamamos al Metodo DoPaymentWithReference de la API de DineroMail
	$result = $client->DoPaymentWithReference($request);
	
	echo "MerchantTransactionId: " . $result->DoPaymentWithReferenceResult->MerchantTransactionId . "<br/>";
	echo "Status: " . $result->DoPaymentWithReferenceResult->TransactionId . "<br/>";
	echo "Message: " . $result->DoPaymentWithReferenceResult->Message . "<br/>";
	echo "Status: " . $result->DoPaymentWithReferenceResult->Status . "<br/>";
	echo "TransactionId: " . $result->DoPaymentWithReferenceResult->TransactionId . "<br/>";
	echo "BarcodeDigits: " . $result->DoPaymentWithReferenceResult->BarcodeDigits . "<br/>";
	echo "BarcodeImageUrl: " . $result->DoPaymentWithReferenceResult->BarcodeImageUrl . "<br/>";
	echo "VoucherUrl: " . $result->DoPaymentWithReferenceResult->VoucherUrl . "<br/>";
	
}
catch (SoapFault $sf)
{
	echo "faultstring:". $sf->faultstring;
}
?>





