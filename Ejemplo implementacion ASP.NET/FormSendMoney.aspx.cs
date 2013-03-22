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
    public partial class FormSendMoney : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
          
        }

        /// <summary>
        ///     SendMoney: Realizar "Envío de dinero".
        /// </summary>
        /// <param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        /// <param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
        /// <param name="Crypt">Indica si se envian los datos encriptados</param>
        /// <param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        /// <param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
        /// <param name="_Currency">Moneda del importe a enviar</param>
        /// <param name="Amount">Importe a enviar</param>
        /// <param name="MailTo">Email del usuario que recibe el dinero</param>
        /// <param name="Subject">Concepto del envío de dinero</param>
        /// <param name="Message">Mensaje al usuario destinatario del dinero</param>
        /// <param name="PayOff">Identifica el origen del envío de dinero</param>
        /// <param name="Hash">Cadena a encriptar</param>
        /// <returns>
        ///     Estado de la operación
        /// </returns>
        public string SendMoney()
        {
            String APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ";
            String APIUserName = "TESTDMAPIPRO001";
            bool Crypt = false;
            String MerchantTransactionId = "1";
            String UniqueMessageId = "11";
            string Currency = "BRL";
            string Amount = "10,00";
            string Mail = "qa02_brasil@gmail.com";
            string Subject = "subject sendmoney";
            string Message = "Message sendmoney";
            string PayOff = "product";
            string Hash = "";

            DMCrypt Crypto = new DMCrypt();

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            ws.dineromail.api.APICredential Credential = new ws.dineromail.api.APICredential();
            Credential.APIPassword = APIPassword;
            Credential.APIUserName = APIUserName;

            // El >> Hash << es el cálculo MD5 de los valores 
	        // de los siguientes parámetros en orden especificado.
	        Hash = MerchantTransactionId + UniqueMessageId + Currency + Amount + Mail + PayOff + Subject + Message + Credential.APIPassword;
            Hash = Crypto.GetHashMD5(Hash);
            
            
            //si se desea enviar encriptado
            if (Crypt)
            {
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
                Currency = Crypto.Encrypt(Currency);
                Amount = Crypto.Encrypt(Amount);
                Mail = Crypto.Encrypt(Mail);
                Subject = Crypto.Encrypt(Subject);
                Message = Crypto.Encrypt(Message);
                PayOff = Crypto.Encrypt(PayOff);
            }
            
            ws.dineromail.api.DMAPI Client = new ws.dineromail.api.DMAPI();

            // Consultamos el servicio web
            // Llamamos al Metodo SendMoney de la API de DineroMail
            ws.dineromail.api.ResultSendMoney SendMoneyResult = Client.SendMoney(Credential
                                                                                 , Crypt
                                                                                 , Currency
                                                                                 , Amount
                                                                                 , Mail
                                                                                 , PayOff
                                                                                 , Subject
                                                                                 , Message
                                                                                 , MerchantTransactionId
                                                                                 , UniqueMessageId
                                                                                 , Hash );

            // Mostramos en pantalla el resultado de la operación. 
            string sResult = "Status: " + SendMoneyResult.Status.ToString() + "<br>";
            sResult = sResult + "Message: " + SendMoneyResult.Message.ToString() + "<br>";
            sResult = sResult + "MerchantTransactionId: " + SendMoneyResult.MerchantTransactionId.ToString() + "<br>";
            sResult = sResult + "UniqueMessageId: " + SendMoneyResult.UniqueMessageId.ToString() + "<br>";
            if (SendMoneyResult.Status.ToString() == "COMPLETED" || SendMoneyResult.Status.ToString() == "PENDING")
            {
                sResult = sResult + "TransactionId: " + SendMoneyResult.TransactionId.ToString() + "<br>";
            }

            return sResult;
        }

        protected void btnSendMoney_Click(object sender, EventArgs e)
        {
            Response.Write(SendMoney());
        }
    }
}
