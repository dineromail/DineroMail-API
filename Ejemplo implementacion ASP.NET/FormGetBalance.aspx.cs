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
    public partial class FormGetBalance : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnGetBalance_Click(object sender, EventArgs e)
        {
            Response.Write(GetBalance());
        }

        /// <summary>
        ///     GetBalance: Consulta del balance en la cuenta del usuario.
        /// </summary>
        /// <param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        /// <param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
        /// <param name="Crypt">Indica si se envian los datos encriptados</param>
        /// <param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        /// <param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
        /// <param name="Hash">Cadena a encriptar</param>
        /// <returns>
        ///     GetBalanceResult: (Status, Message, Currency, Amount)
        /// </returns>
        public string GetBalance()
        {           

            String APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ";
            String APIUserName = "TESTDMAPIPRO001";
            bool Crypt = false;
            String MerchantTransactionId = "1";
            String UniqueMessageId = "18";
            String Hash = "";

            DMCrypt Crypto = new DMCrypt();
            ws.dineromail.api.DMAPI ClientApi = new ASP.NET.ws.dineromail.api.DMAPI();

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            ws.dineromail.api.APICredential Credential = new ASP.NET.ws.dineromail.api.APICredential();
            Credential.APIUserName = APIUserName;
            Credential.APIPassword = APIPassword;

            // El >> Hash << es el cálculo MD5 de los valores 
            // de los siguientes parámetros en orden especificado.
            Hash = MerchantTransactionId + UniqueMessageId + Credential.APIPassword;
            Hash = Crypto.GetHashMD5(Hash);

            
            //si se desea enviar encriptado
            if (Crypt)
            {
                // Los datos de la API viajarán con una encriptación del tipo TripleDES
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
            } 
            
            // Consultamos el servicio web
            // Llamamos al Metodo GetBalance de la API de DineroMail
            ws.dineromail.api.ResultGetBalance BalanceResult = ClientApi.GetBalance(Credential
                                                                                    , Crypt
                                                                                    , MerchantTransactionId
                                                                                    , UniqueMessageId
                                                                                    , Hash );

            //mostramos la respuesta de la operación en pantalla.
            String sResult = "Status: " + BalanceResult.Status.ToString() + "<br>";
            sResult += "Message: " + BalanceResult.Message.ToString() + "<br>";
            sResult += "MerchantTransactionId: " + BalanceResult.MerchantTransactionId.ToString() + "<br>";
            sResult += "UniqueMessageId: " + BalanceResult.UniqueMessageId.ToString() + "<br>";
            
            if (BalanceResult.Status.ToString() == "OK")
            {
                sResult = sResult + "TransactionId: " + BalanceResult.TransactionId.ToString() + "<br>";
                sResult = sResult + "Amount: " + BalanceResult.Balance[0].Amount.ToString() + "<br>";
                sResult = sResult + "Currency: " + BalanceResult.Balance[0].Currency.ToString();
            }

            return sResult;
        }

    }
}
