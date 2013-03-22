using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Text;
using Dineromail;

namespace ASP.NET
{
    public partial class FormDoPaymentWithReference : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public string DoPaymentWithReference()
        {
            string APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ";
            string APIUserName = "TESTDMAPIPRO001";
            bool Crypt = false;
            string MerchantTransactionId = "1";
            string UniqueMessageId = "18";
            string Hash = "";
            string Subject = "Subject Test";
            string Message = "Message Test";
            string Provider = "pagofacil";

            DMCrypt Crypto = new DMCrypt();
            ws.dineromail.api.DMAPI ClientApi = new ASP.NET.ws.dineromail.api.DMAPI();
            ws.dineromail.api.Item oItem = new ASP.NET.ws.dineromail.api.Item();
            //Creamos una instancia del objeto APICredential
            ws.dineromail.api.APICredential Credential = new ws.dineromail.api.APICredential();

            oItem.Amount = "25.52";
            oItem.Code = "A001";
            oItem.Currency = "USD";
            oItem.Description = "Producto A001";
            oItem.Name = "LCD Monitor";
            oItem.Quantity = "2";

            ws.dineromail.api.Item[] oItems = { oItem };

            ws.dineromail.api.Buyer oBuyer = new ws.dineromail.api.Buyer();
            oBuyer.Address = "Charcas 2034";
            oBuyer.City = "Buenos Aires";
            oBuyer.Country = "Argentina";
            oBuyer.Email = "mailtest@mailtest.com";
            oBuyer.LastName = "Lopez";
            oBuyer.Name = "Carlos Ruben";
            oBuyer.Phone = "45556565";

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            Credential.APIUserName = APIUserName;
            Credential.APIPassword = APIPassword;            

            //preparamos la cadena de texto a utilizar en el hash
            string sConcatItem = oItem.Amount + oItem.Code + oItem.Currency + oItem.Description + oItem.Name + oItem.Quantity;

            string sConcatBuyer = oBuyer.Name + oBuyer.LastName + oBuyer.Email + oBuyer.Address + oBuyer.Phone + oBuyer.Country + oBuyer.City;

            Hash = MerchantTransactionId + UniqueID + sConcatItem + sConcatBuyer + Provider + Subject + Message + Credential.APIPassword.ToString();

            //si se desea enviar encriptado
            if (Crypt)
            {
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
                Provider = Crypto.Encrypt(Provider);
                Subject = Crypto.Encrypt(Subject);
                Message = Crypto.Encrypt(Message);

                foreach (ws.dineromail.api.Item Item in oItems)
                {
                    oItem.Amount = Crypto.Encrypt(oItem.Amount);
                    oItem.Code = Crypto.Encrypt(oItem.Code);
                    oItem.Currency = Crypto.Encrypt(oItem.Currency);
                    oItem.Description = Crypto.Encrypt(oItem.Description);
                    oItem.Name = Crypto.Encrypt(oItem.Name);
                    oItem.Quantity = Crypto.Encrypt(oItem.Quantity);

                }
                oBuyer.Name = Crypto.Encrypt(oBuyer.Name);
                oBuyer.LastName = Crypto.Encrypt(oBuyer.LastName);
                oBuyer.Email = Crypto.Encrypt(oBuyer.Email);
                oBuyer.Address = Crypto.Encrypt(oBuyer.Address);
                oBuyer.Phone = Crypto.Encrypt(oBuyer.Phone);
                oBuyer.Country = Crypto.Encrypt(oBuyer.Country);
                oBuyer.City = Crypto.Encrypt(oBuyer.City);
            }

            Hash = Crypto.GetHashMD5(Hash);
            
            //consultamos el servicio web
            ws.dineromail.api.ResultDoPaymentWithReference PaymentWithReferenceResult = ClientApi.DoPaymentWithReference(Credential, Crypt, MerchantTransactionId, oItems, oBuyer, Provider, Subject, Message, UniqueMessageId, Hash);

            //mostramos la respuesta de la operación en pantalla.
            string sResult = "Status: " + PaymentWithReferenceResult.Status.ToString() + "<br>";
            sResult = sResult + "Message: " + PaymentWithReferenceResult.Message.ToString() + "<br>";
            sResult = sResult + "MerchantTransactionId: " + PaymentWithReferenceResult.MerchantTransactionId.ToString() + "<br>";
            sResult = sResult + "UniqueMessageId: " + PaymentWithReferenceResult.UniqueMessageId.ToString() + "<br>";
            if (PaymentWithReferenceResult.Status.ToString() == "COMPLETED")
            {
                sResult = sResult + "TransactionId: " + PaymentWithReferenceResult.TransactionId.ToString() + "<br>";
                sResult = sResult + "BarcodeDigits: " + PaymentWithReferenceResult.BarcodeDigits + "<br>";
                sResult = sResult + "UrlImage: " + PaymentWithReferenceResult.BarcodeImageUrl.ToString() + "<br>";
                sResult = sResult + "Voucher: " + PaymentWithReferenceResult.VoucherUrl.ToString();
            }

            return sResult;            
        }

        protected void btnDoPaymentWithReference_Click(object sender, EventArgs e)
        {
            Response.Write(DoPaymentWithReference());
        }


    }
}