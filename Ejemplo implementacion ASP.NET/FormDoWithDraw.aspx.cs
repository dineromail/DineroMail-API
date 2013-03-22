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
    public partial class FormDoWithDraw : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnDoWithDraw_Click(object sender, EventArgs e)
        {
            Response.Write(DoWithDraw());
        }

        /// <summary>
        ///     DoWithDraw: Realizar "Retiro de fondos" de la cuenta de DineroMail
        /// </summary>
        /// <param name="APIPassword">Valor de seguridad para utilización de la API de DineroMail</param>
        /// <param name="APIUserName">Usuario para la identificacion en la API de DineroMail</param>
        /// <param name="Crypt">Indica si se envian los datos encriptados</param>
        /// <param name="MerchantTransactionId">Identificador transacción, corresponde al identificador de transacción del Comerciente.</param>
        /// <param name="UniqueMessageId">Identificador único de mensaje, no puede repetirse en futuras conexiones. (Autonumérico)</param>
        /// <param name="Currency">Moneda del importe a retirar</param>
        /// <param name="Amount">Importe a retirar</param>
        /// <param name="Method">Identificador del método a utilizar para el retiro defondos</param>
        /// <param name="AddressDetail">
        ///     => Street: Calle donde recibirá el cheque
        ///     => Number: Altura de la calle donde recibirá el cheque
        ///     => Floor: Piso en caso de vivir en edificio.
        ///     => Appartment: Departamento.
        ///     => Zip: Código postal.
        ///     => City: Identificador de Ciudad
        ///     => State: Identificador de Estado o provincia
        /// </param>
        /// <param name="BankAccountDetail">
        ///     => Bank: Identificador del banco
        ///     => BankNumber: Número de la cuenta bancaria
        ///     => Branch: Solamente necesario en Brasil. Por defecto enviar 0 cero.
        ///     => DocumentNumber: Número de documento del titular
        ///     => DocumentType: Tipo de documento del titular
        ///     => LastName: Apellido del titular de la cuenta bancaria
        ///     => Name: Nombre del titular de la cuenta bancaria
        ///     => Type: Identifica el tipo de cuenta bancaria
        ///  </param>
        /// <param name="Hash">Cadena a encriptar</param>
        /// <returns>
        ///     Estado de la operación
        /// </returns>
        public string DoWithDraw()
        {
            //Consulta del balance en la cuenta del usuario.
            string APIPassword = "TEST-TEST-TEST-TEST-TEST";
            string APIUserName = "TEST";
            bool Crypt = true; 
            string MerchantTransactionId = "1";
            string UniqueMessageId = "1";
            string Currency = "BRL"; 
            string Amount = "20,52";
            string sMethod = "BANK";
            string Hash = "";

            // Detalla la dirección de entrega
            ws.dineromail.api.AddressDetail oAddress = new ws.dineromail.api.AddressDetail() 
            {
                Street = "CALLE1",
                Number = "123",
                Floor = "1",
                State = "BRASILIA",
                City = "CIUDAD",
                Appartment = "A",
                Zip = "123"                
            };

            // Detalla la cuenta bancaria
            ws.dineromail.api.BankAccountDetail oBankDetail = new ws.dineromail.api.BankAccountDetail()
            { 
                Bank = "BANCO",
                BankNumber = "12341234",
                Branch = "1",
                DocumentNumber = "29000000",
                DocumentType = "1",
                LastName = "APELLIDO",
                Name = "NOMBRE",
                Type = "CA"
            };            

            DMCrypt Crypto = new DMCrypt();
            ws.dineromail.api.DMAPI Client = new ws.dineromail.api.DMAPI();

            // Creamos una instancia del objeto APICredential
            // La Credential es la tarjeta de acceso a la API de DineroMail
            ws.dineromail.api.APICredential Credential = new ws.dineromail.api.APICredential();
            Credential.APIPassword = APIPassword;
            Credential.APIUserName = APIUserName;

            // El >> Hash << es el cálculo MD5 de los valores 
            // de los siguientes parámetros en orden especificado.
            string sFullAddressDetail = oAddress.Street + oAddress.Number + oAddress.Floor + oAddress.Appartment + oAddress.Zip + oAddress.City + oAddress.State;
            string sFullBankAccountDetail = oBankDetail.Bank + oBankDetail.BankNumber + oBankDetail.Type + oBankDetail.Name + oBankDetail.LastName + oBankDetail.DocumentType + oBankDetail.DocumentNumber + oBankDetail.Branch;
            Hash = MerchantTransactionId + UniqueMessageId + sMethod + Currency + Amount + sFullAddressDetail + sFullBankAccountDetail + Credential.APIPassword.ToString();
            Hash = Crypto.GetHashMD5(Hash);            
            
            //si se desea enviar encriptado
            if (Crypt)
            {
                // Los datos de la API viajarán con una encriptación del tipo TripleDES
                Crypto.Key = Encoding.ASCII.GetBytes(Credential.APIPassword);
                MerchantTransactionId = Crypto.Encrypt(MerchantTransactionId);
                UniqueMessageId = Crypto.Encrypt(UniqueMessageId);
                Currency = Crypto.Encrypt(Currency);
                Amount = Crypto.Encrypt(Amount);
                sMethod = Crypto.Encrypt(sMethod);

                oAddress.Number = Crypto.Encrypt(oAddress.Number);
                oAddress.State = Crypto.Encrypt(oAddress.State);
                oAddress.Street = Crypto.Encrypt(oAddress.Street);
                oAddress.Zip = Crypto.Encrypt(oAddress.Zip);
                oAddress.Floor = Crypto.Encrypt(oAddress.Floor);
                oAddress.City = Crypto.Encrypt(oAddress.City);
                oAddress.Appartment = Crypto.Encrypt(oAddress.Appartment);

                oBankDetail.Bank = Crypto.Encrypt(oBankDetail.Bank);
                oBankDetail.BankNumber = Crypto.Encrypt(oBankDetail.BankNumber);
                oBankDetail.Branch = Crypto.Encrypt(oBankDetail.Branch);
                oBankDetail.DocumentNumber = Crypto.Encrypt(oBankDetail.DocumentNumber);
                oBankDetail.DocumentType = Crypto.Encrypt(oBankDetail.DocumentType);
                oBankDetail.LastName = Crypto.Encrypt(oBankDetail.LastName);
                oBankDetail.Name = Crypto.Encrypt(oBankDetail.Name);
                oBankDetail.Type = Crypto.Encrypt(oBankDetail.Type);
            }
            
            // Consultamos el servicio web
            // Llamamos al Metodo DoWithDraw de la API de DineroMail
            ws.dineromail.api.ResultDoWithDraw WithDrawResult = Client.DoWithDraw(  Credential
                                                                                  , Crypt
                                                                                  , MerchantTransactionId
                                                                                  , sMethod
                                                                                  , Currency
                                                                                  , Amount
                                                                                  , oAddress
                                                                                  , oBankDetail
                                                                                  , UniqueMessageId
                                                                                  , Hash );

            // mostramos la respuesta de la operación en pantalla.
            string sResult = "Status: " + WithDrawResult.Status.ToString() + "<br>";
            sResult = sResult + "Message: " + WithDrawResult.Message.ToString() + "<br>";
            sResult = sResult + "MerchantTransactionId: " + WithDrawResult.MerchantTransactionId.ToString() + "<br>";
            sResult = sResult + "UniqueMessageId: " + WithDrawResult.UniqueMessageId.ToString() + "<br>";

            if (WithDrawResult.Status.ToString() == "PENDING")
            {
                sResult = sResult + "TransactionId: " + WithDrawResult.TransactionId.ToString() + "<br>";
            }

            return sResult;
        }
    }
}
