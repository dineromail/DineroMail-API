using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Text;
using ASP.NET.ws.dineromail.api;
using Dineromail;

namespace ASP.NET
{
    public partial class FormGetPaymentTicket : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        
        /// <summary>
        /// 		GetPaymentTicket: Permite obtener un cupón de pago de cualquier proveedor de código de barras y lo asigna al comercio.
        /// </summary>
        /// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        /// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
        /// <param name="$Crypt">Indica si se envian los datos encriptados</param>
        /// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        /// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
        /// <param name="$Provider">Identifica el proveedor con el cual se desea realizar el pago</param>
        /// <param name="$Currency">Identificador de la moneda para el importe a enviar</param>
        /// <param name="$Amount">Importe a enviar</param>
        /// <param name="$Hash">Cadena a encriptar</param>
        /// <returns>
        ///		Estado de la operación
        /// </returns>
        public string GetPaymentTicket()
        {
            DMCrypt Crypto = new DMCrypt();
            
            String APIPassword = "TEST-TEST-TEST-TEST-TEST";
            String APIUserName = "TEST";
            bool Crypt = true;
            String MerchantTransactionId = "1";
            String UniqueMessageId = "1";
            String Currency = "USD";
            String Amount = "10.55";
            String Provider = "servipag";
            String Hash = "";

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            APICredential Credential = new APICredential();
            Credential.APIPassword = APIPassword;
            Credential.APIUserName = APIUserName;

            // El >> Hash << es el cálculo MD5 de los valores 
            // de los siguientes parámetros en orden especificado.
            Hash = MerchantTransactionId + UniqueMessageId + Currency + Amount + Provider + Credential.APIPassword;
            Hash = Crypto.GetHashMD5(Hash); 
            
            //si se desea enviar encriptado
            if (Crypt)
            {
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
                Currency = Crypto.Encrypt(Currency);
                Amount = Crypto.Encrypt(Amount);
                Provider = Crypto.Encrypt(Provider);
            }            
            
            // Consultamos el servicio web
            // Llamamos al Metodo GetPaymentTicket de la API de DineroMail
            DMAPI Client = new DMAPI();
            ResultGetPaymentTicket PaymentTicketResult = Client.GetPaymentTicket(  Credential
                                                                                   , Crypt
                                                                                   , Currency
                                                                                   , Amount
                                                                                   , Provider
                                                                                   , MerchantTransactionId
                                                                                   , UniqueMessageId
                                                                                   , Hash );

            //mostramos la respuesta de la operación en pantalla.
            string sResult = "Status: " + PaymentTicketResult.Status.ToString() + "<br>";
            sResult = sResult + "Message: " + PaymentTicketResult.Message.ToString() + "<br>";
            sResult = sResult + "MerchantTransactionId: " + PaymentTicketResult.MerchantTransactionId.ToString() + "<br>";
            sResult = sResult + "UniqueMessageId: " + PaymentTicketResult.UniqueMessageId.ToString() + "<br>";
            if (PaymentTicketResult.Status.ToString() == "COMPLETED")
            {
                sResult = sResult + "MerchantTransactionId: " + PaymentTicketResult.MerchantTransactionId.ToString() + "<br>";
                sResult = sResult + "TransactionId: " + PaymentTicketResult.TransactionId.ToString() + "<br>";
                sResult = sResult + "BarcodeDigits: " + PaymentTicketResult.BarcodeDigits + "<br>";
                sResult = sResult + "UrlImage: " + PaymentTicketResult.BarcodeImageUrl.ToString() + "<br>";
                sResult = sResult + "Voucher: " + PaymentTicketResult.VoucherUrl.ToString();
            }

            return sResult;
        }

        protected void btnGetPaymentTicket_Click(object sender, EventArgs e)
        {
            Response.Write(GetPaymentTicket());
        }
    }
}
