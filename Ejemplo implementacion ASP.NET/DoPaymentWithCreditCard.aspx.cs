using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Dineromail;
using ASP.NET.ws.dineromail.api;
using System.Text;

namespace ASP.NET
{
    public partial class DoPaymentWithCreditCard : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        #region Metodos Privados

        // <summary>
        //      DoPaymentWithReference: "Realizar pago" de Botón o Carrito de compras, con códigos de barra.
        // </summary>
        // <param name="apiPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        // <param name="apiUserName">Usuario para la identificacion en la API de DineroMail</param>
        // <param name="crypt">Indica si se envian los datos encriptados</param>
        // <param name="merchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        // <param name="uniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>

        // <param name="provider">Identifica el proveedor con el cual se desea realizar el pago</param>
        // <param name="subject">Concepto o asunto del comprador hacia el vendedor</param>
        // <param name="message">Mensaje del comprador hacia el vendedor</param>

        // <param name="currency">Identificador de la moneda para el ítem</param>
        // <param name="amount">Importe del ítem</param>
        // <param name="code">Identificador generado por el comercio</param>
        // <param name="description">Descripción del ítem</param>
        // <param name="itemName">Nombre o titulo del ítem</param>
        // <param name="quantity">Cantidad de ítems a pagar</param>

        // <param name="address">Dirección del comprador</param>
        // <param name="city">Ciudad o provincia del comprador</param>
        // <param name="country">País del comprador</param>
        // <param name="email">Email del comprador</param>
        // <param name="name">Nombre del comprador</param>
        // <param name="lastName">Apellido del comprador</param>
        // <param name="phone">Teléfono del comprador</param>

        // <param name="ccAddress">Dirección del comprador</param>
        // <param name="ccAddressComplement">Dirección del comprador</param>
        // <param name="ccAddressNumber">Dirección del comprador</param>
        // <param name="ccCity">Ciudad o provincia del comprador</param>
        // <param name="ccCountry">País del comprador</param>
        // <param name="ccNeighborhood">Email del comprador</param>
        // <param name="ccState">Nombre del comprador</param>
        // <param name="ccZipCode">Apellido del comprador</param>
        // <param name="ccBankId">Teléfono del comprador</param>

        // <param name="ccCreditCardNumber">Dirección del comprador</param>
        // <param name="ccDocumentNumber">Dirección del comprador</param>
        // <param name="ccExpirationDate">Dirección del comprador</param>
        // <param name="ccHolder">Ciudad o provincia del comprador</param>
        // <param name="ccInstallment">País del comprador</param>
        // <param name="ccSecurityCode">Email del comprador</param>

        // <param name="hash">Cadena a encriptar</param>
        // <returns>
        //      BarcodeDigits, BarcodeImageUrl, VoucherUrl
        // </returns>
        private string _DoPaymentWithCreditCard()
        { 
            String apiPassword                   = "TEST-TEST-TEST-TEST-TEST";
            String apiUserName                   = "TEST";
            Boolean crypt                        = true;
            String merchantTransactionId         = "1";
            String uniqueMessageId               = "1";

            String provider                      = "AR_MASTER";
            String subject                       = "Subject";
            String message                       = "Message";
             
            String currency                      = "BRL";
            String amount                        = "10.40";
            String code                          = "A001";
            String description                   = "Product A001";
            String itemName                      = "LCD Monitor";
            String quantity                      = "1";

            String address                       = "123";
            String city                          = "Brasilia";
            String country                       = "Brasilia";
            String email                         = "mailtest@mailtest.com";
            String name                          = "Carlos";
            String lastName                      = "Lopez";
            String phone                         = "12341234";

            String ccAddress                     = "Street";
            String ccAddressComplement           = "";
            String ccAddressNumber               = "123" ;
            String ccCity                        = "";
            String ccCountry                     = "";
            String ccNeighborhood                = "";
            String ccState                       = "";
            String ccZipCode                     = "";
            Int32 ccBankId                     = 0;

            String ccCreditCardNumber            = "5114920090135851";
            String ccDocumentNumber              = "27000000";
            String ccExpirationDate              = "11/14";
            String ccHolder                      = "test";
            String ccInstallment                 = "1";
            String ccSecurityCode                = "111";

            String hash                          = "";

            ResultDoPaymentWithCreditCard result = new ResultDoPaymentWithCreditCard();
            DMCrypt Crypto                       = new DMCrypt();
            DMAPI ClientApi                      = new DMAPI();

            try {

                // Creamos una instancia del objeto APICredential
                // La Credential es la tarjeta de acceso a la API de DineroMail
                APICredential Credential = new APICredential();
                Credential.APIUserName = apiPassword;
                Credential.APIPassword = apiPassword;
                
                // El Hash es el cálculo MD5 de los valores 
                // de los siguientes parámetros en orden especificado.
                String items = amount + code + currency + description + itemName + quantity;
                String buyer = name + lastName + email + address + phone + country + city;
                String creditCard = ccInstallment + ccCreditCardNumber + ccHolder + ccExpirationDate + 
                                    ccSecurityCode + ccDocumentNumber + ccAddress + ccAddressNumber + 
						            ccAddressComplement + ccZipCode + ccNeighborhood + ccCity + 
						            ccState + ccCountry;
                
                hash = merchantTransactionId + uniqueMessageId + items + buyer + creditCard + 
			            provider + subject + message + apiPassword;
            			
                hash = Crypto.GetHashMD5( hash );

                if (crypt){
                    
                    // Los datos de la API viajarán con una encriptación del tipo TripleDES
		            Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                    merchantTransactionId   = Crypto.Encrypt( merchantTransactionId );
                    uniqueMessageId         = Crypto.Encrypt( uniqueMessageId );
                    currency                = Crypto.Encrypt( currency );
                    amount                  = Crypto.Encrypt( amount );
                    provider                = Crypto.Encrypt( provider );
                    subject                 = Crypto.Encrypt( subject );
                    message                 = Crypto.Encrypt( message );        
                    currency                = Crypto.Encrypt( currency );        
                    amount                  = Crypto.Encrypt( amount );
                    code                    = Crypto.Encrypt( code );
                    itemName                = Crypto.Encrypt( itemName );
                    quantity                = Crypto.Encrypt( quantity );
                    address                 = Crypto.Encrypt( address );
                    city                    = Crypto.Encrypt( city );
                    country                 = Crypto.Encrypt( country );
                    email                   = Crypto.Encrypt( email );
                    name                    = Crypto.Encrypt( name );
                    lastName                = Crypto.Encrypt( lastName );
                    phone                   = Crypto.Encrypt( phone );

                }

                Item oItem = new Item();
                oItem.Amount        = amount;
                oItem.Code          = code;
                oItem.Currency      = currency;
                oItem.Description   = description;
                oItem.Name          = itemName;
                oItem.Quantity      = quantity;

                Item[] oItemList = { oItem };
                           
                Buyer oBuyer = new Buyer();
                oBuyer.Address     = address;
                oBuyer.City        = city;
                oBuyer.Country     = country;
                oBuyer.Email       = email;
                oBuyer.LastName    = lastName;
                oBuyer.Name        = name;
                oBuyer.Phone       = phone;
                      
                CreditCard oCard = new CreditCard();
                oCard.Installment        = ccInstallment;
                oCard.CreditCardNumber   = ccCreditCardNumber;
                oCard.DocumentNumber     = ccDocumentNumber;
                oCard.Holder             = ccHolder;
                oCard.ExpirationDate     = ccExpirationDate;
                oCard.SecurityCode       = ccSecurityCode;
                oCard.Address            = ccAddress;
                oCard.AddressNumber      = ccAddressNumber;
                oCard.AddressComplement  = ccAddressComplement;
                oCard.ZipCode            = ccZipCode;
                oCard.Neighborhood       = ccNeighborhood;
                oCard.City               = ccCity;
                oCard.State              = ccState;
                oCard.Country            = ccCountry;
                oCard.BankId             = ccBankId;

                // La Credential es la tarjeta de acceso a la API de DineroMail
                APICredential credential = new APICredential();
                credential.APIUserName = apiUserName;
                credential.APIPassword = apiPassword;

                // Llamamos al Metodo doPaymentWithCreditCard de la API de DineroMail
                result = ClientApi.DoPaymentWithCreditCard(   credential
                                                            , crypt
                                                            , merchantTransactionId
                                                            , oItemList
                                                            , oBuyer
                                                            , provider
                                                            , oCard
                                                            , subject
                                                            , message
                                                            , uniqueMessageId
                                                            , hash );
                
                // Mostramos en pantalla el resultado de la operación. 
                string sResult =  "MerchantTransactionId: " + result.MerchantTransactionId + "<br/>";
                sResult += "TransactionId: " + result.TransactionId + "<br/>";
                sResult += "Status: " + result.Status.ToString() + "<br/>";
                sResult += "Message: " + result.Message + "<br/>";
                sResult += "UniqueMessageId: " + result.UniqueMessageId + "<br/>";
                sResult += "VoucherUrl: " + result.VoucherUrl + "<br/>";

                return sResult;

            } catch (Exception ex) {
                return ex.Message;
            }

        }

        #endregion

        #region Eventos

        protected void DoPaymentWithCreditCard_Click(object sender, EventArgs e)
        {
            Response.Write( _DoPaymentWithCreditCard() );
        }

        #endregion

    }
}
