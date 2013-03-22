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
    public partial class FormGetOperations : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGetOperations_Click(object sender, EventArgs e)
        {
            Response.Write(GetOperations());
        }

        /// <summary>
        ///     GetOperations: Obtener lista operaciones de DineroMail por parte de los vendedores
        /// </summary>
        /// <param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        /// <param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
        /// <param name="Crypt">Indica si se envian los datos encriptados</param>
        /// <param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        /// <param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
        /// <param name="StartDate">Fecha inicial, en un rango de fecha</param>
        /// <param name="EndDate">Fecha final, en un rango de fecha</param>
        /// <param name="OperationId">Identificador de la operación en DineroMail</param>
        /// <param name="Hash">Cadena a encriptar</param>
        /// <returns>
        ///     Lista de Operaciones
        /// </returns>
        public string GetOperations()
        {
            String APIPassword = "QAZXSWEDTGBYHNUJPLMOKNIJ";
            String APIUserName = "TESTDMAPIPRO001";
            bool Crypt = false;
            String MerchantTransactionId = "1";
            String UniqueMessageId = "30";
            String OperationId = "";
            String StartDate = "2012-09-01";
            String EndDate = "2012-10-01";
            String Hash = "";

            DMCrypt Crypto = new DMCrypt();

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            ws.dineromail.api.APICredential Credential = new ws.dineromail.api.APICredential();
            Credential.APIPassword = APIPassword;
            Credential.APIUserName = APIUserName;

            // El >> Hash << es el cálculo MD5 de los valores 
            // de los siguientes parámetros en orden especificado.
            Hash = MerchantTransactionId + UniqueMessageId + OperationId + StartDate + EndDate + Credential.APIPassword;
            Hash = Crypto.GetHashMD5(Hash);
            
            //si se desea enviar encriptado
            if (Crypt)
            {
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
                OperationId = Crypto.Encrypt(OperationId);
                StartDate = Crypto.Encrypt(StartDate);
                EndDate = Crypto.Encrypt(EndDate);
            }

            ws.dineromail.api.DMAPI Client = new ws.dineromail.api.DMAPI();

            // Consultamos el servicio web
            // Llamamos al Metodo GetOperations de la API de DineroMail
            ws.dineromail.api.ResultGetOperations OperationsResult = Client.GetOperations(Credential
                                                                                          , Crypt
                                                                                          , MerchantTransactionId
                                                                                          , OperationId
                                                                                          , StartDate
                                                                                          , EndDate
                                                                                          , UniqueMessageId
                                                                                          , Hash );

            //mostramos la respuesta de la operación en pantalla.
            string sResult = "Status: " + OperationsResult.Status.ToString() + "<br>";
            sResult = sResult + "Message: " + OperationsResult.Message.ToString() + "<br>";
            sResult = sResult + "MerchantTransactionId: " + OperationsResult.MerchantTransactionId.ToString() + "<br>";
            sResult = sResult + "UniqueMessageId: " + OperationsResult.UniqueMessageId.ToString() + "<br>";

            if (OperationsResult.Status.ToString() == "OK")
            {
                sResult = sResult + "MerchantTransactionId: " + OperationsResult.MerchantTransactionId.ToString() + "<br>";

                foreach (ws.dineromail.api.OperationDetail Operation in OperationsResult.Operations)
                {
                    sResult = sResult + "<h2>Operation</h2><br>";
                    sResult = sResult + "Id: " + Operation.Id.ToString() + "<br>";
                    sResult = sResult + "Amount: " + Operation.Amount.ToString() + "<br>";
                    sResult = sResult + "Date: " + Operation.Date.ToString() + "<br>";
                    sResult = sResult + "NetAmount: " + Operation.NetAmount.ToString() + "<br>";
                    sResult = sResult + "PaymentMethod: " + Operation.PaymentMethod.ToString() + "<br>";
                    sResult = sResult + "Shares: " + Operation.Shares.ToString() + "<br>";
                    sResult = sResult + "State: " + Operation.State.ToString() + "<br>";
                    sResult = sResult + "<h3>Buyer</h3><br>";
                    sResult = sResult + "Address: " + Operation.Buyer.Address.ToString() + "<br>";
                    sResult = sResult + "Comments: " + Operation.Buyer.Comments.ToString() + "<br>";
                    sResult = sResult + "DocumentNumber: " + Operation.Buyer.DocumentNumber.ToString() + "<br>";
                    sResult = sResult + "DocumentType: " + Operation.Buyer.DocumentType.ToString() + "<br>";
                    sResult = sResult + "Email: " + Operation.Buyer.Email.ToString() + "<br>";
                    sResult = sResult + "LastName: " + Operation.Buyer.LastName.ToString() + "<br>";
                    sResult = sResult + "Name: " + Operation.Buyer.Name.ToString() + "<br>";
                    sResult = sResult + "Phone: " + Operation.Buyer.Phone.ToString() + "<br>";
                    sResult = sResult + "<h3>Seller</h3><br>";
                    sResult = sResult + "LastName: " + Operation.Seller.LastName.ToString() + "<br>";
                    sResult = sResult + "Name: " + Operation.Seller.Name.ToString() + "<br>";
                    sResult = sResult + "Phone: " + Operation.Seller.Phone.ToString() + "<br>";
                    sResult = sResult + "Email: " + Operation.Seller.Email.ToString() + "<br>";
                    sResult = sResult + "DocumentType: " + Operation.Seller.DocumentType.ToString() + "<br>";
                    sResult = sResult + "DocumentNumber: " + Operation.Seller.DocumentNumber.ToString() + "<br>";
                }

            }

            return sResult;
        }

    }
}
