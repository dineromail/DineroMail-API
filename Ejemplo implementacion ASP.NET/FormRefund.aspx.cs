using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Text;
using Dineromail;
using ASP.NET.ws.dineromail.api;

namespace ASP.NET
{
    public partial class FormRefund : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnRefund_Click(object sender, EventArgs e)
        {
            Response.Write(Refund());
        }

        /// <summary>
        /// 	Refund: Realizar Reembolsos
        /// </summary>
        /// <param name="$APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        /// <param name="$APIUserName">Usuario para la identificacion en la API de DineroMail</param>
        /// <param name="$Crypt">Indica si se envian los datos encriptados</param>
        /// <param name="$MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        /// <param name="$UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
        /// <param name="$RefundedMerchantTransactionId">Identificador transacción correspondiente a la reembolso</param>
        /// <param name="$Hash">Cadena a encriptar</param>
        /// <returns>
        /// 	Estado de la Operación
        /// </returns>
        public string Refund()
        {

            String APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ";
            String APIUserName = "TESTDMAPIPRO001";
            bool Crypt = false;
            String MerchantTransactionId = "14324234";
            String UniqueMessageId = "7398234234997";
            String Currency = "ARG";
            String Amount = "10.40";
            String Subject = "Subject";
            String Message = "Message";
            String Hash = "";

            DMCrypt Crypto = new DMCrypt();

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            APICredential Credential = new APICredential();
            Credential.APIUserName = APIUserName;
            Credential.APIPassword = APIPassword;

            // El >> Hash << es el cálculo MD5 de los valores 
            // de los siguientes parámetros en orden especificado.
            Hash = MerchantTransactionId + UniqueMessageId + Currency + Amount + Subject + Message + APIPassword;
            Hash = Crypto.GetHashMD5(Hash);
            
            //si se desea enviar encriptado
            if (Crypt)
            {
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
                Currency = Crypto.Encrypt(Currency);
                Amount = Crypto.Encrypt(Amount);
                Subject = Crypto.Encrypt(Subject);
                Message = Crypto.Encrypt(Message);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);                
            } 
            
            DMAPI ClientApi = new DMAPI();

            // Consultamos el servicio web
            // Llamamos al Metodo GetBalance de la API de DineroMail
            ResultRefund RefundResult = ClientApi.Refund(Credential,
                                                         Crypt,
                                                         MerchantTransactionId,
                                                         Currency,
                                                         Amount,
                                                         Subject,
                                                         Message,
                                                         UniqueMessageId,
                                                         Hash);

            //mostramos la respuesta de la operación en pantalla.
            String sResult = "Status: " + RefundResult.Status.ToString() + "<br>";
            sResult += "Message: " + RefundResult.Message.ToString() + "<br>";
            sResult += "MerchantTransactionId: " + RefundResult.MerchantTransactionId.ToString() + "<br>";
            sResult += "TransactionId: " + RefundResult.TransactionId.ToString() + "<br>";
            
            return sResult;
        }

    }
}
