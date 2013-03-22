
package https.api_dineromail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DMAPISoap", targetNamespace = "https://api.dineromail.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DMAPISoap {


    /**
     * 
     * @param hash
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @return
     *     returns https.api_dineromail.ResultGetBalance
     */
    @WebMethod(operationName = "GetBalance", action = "https://api.dineromail.com/GetBalance")
    @WebResult(name = "GetBalanceResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "GetBalance", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetBalance")
    @ResponseWrapper(localName = "GetBalanceResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetBalanceResponse")
    public ResultGetBalance getBalance(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param message
     * @param toEmail
     * @param amount
     * @param hash
     * @param subject
     * @param payOff
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @param currency
     * @return
     *     returns https.api_dineromail.ResultSendMoney
     */
    @WebMethod(operationName = "SendMoney", action = "https://api.dineromail.com/SendMoney")
    @WebResult(name = "SendMoneyResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "SendMoney", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.SendMoney")
    @ResponseWrapper(localName = "SendMoneyResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.SendMoneyResponse")
    public ResultSendMoney sendMoney(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "Currency", targetNamespace = "https://api.dineromail.com/")
        String currency,
        @WebParam(name = "Amount", targetNamespace = "https://api.dineromail.com/")
        String amount,
        @WebParam(name = "ToEmail", targetNamespace = "https://api.dineromail.com/")
        String toEmail,
        @WebParam(name = "PayOff", targetNamespace = "https://api.dineromail.com/")
        String payOff,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param message
     * @param hash
     * @param items
     * @param subject
     * @param buyer
     * @param provider
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @return
     *     returns https.api_dineromail.ResultDoPaymentWithReference
     */
    @WebMethod(operationName = "DoPaymentWithReference", action = "https://api.dineromail.com/DoPaymentWithReference")
    @WebResult(name = "DoPaymentWithReferenceResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "DoPaymentWithReference", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithReference")
    @ResponseWrapper(localName = "DoPaymentWithReferenceResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithReferenceResponse")
    public ResultDoPaymentWithReference doPaymentWithReference(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Items", targetNamespace = "https://api.dineromail.com/")
        ArrayOfItem items,
        @WebParam(name = "Buyer", targetNamespace = "https://api.dineromail.com/")
        Buyer buyer,
        @WebParam(name = "Provider", targetNamespace = "https://api.dineromail.com/")
        String provider,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param bankTransferData
     * @param hash
     * @param subject
     * @param provider
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @param message
     * @param merchantUrlRedirect
     * @param items
     * @param buyer
     * @param merchantUrlNotification
     * @return
     *     returns https.api_dineromail.ResultDoPaymentWithBankTransfer
     */
    @WebMethod(operationName = "DoPaymentWithBankTransfer", action = "https://api.dineromail.com/DoPaymentWithBankTransfer")
    @WebResult(name = "DoPaymentWithBankTransferResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "DoPaymentWithBankTransfer", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithBankTransfer")
    @ResponseWrapper(localName = "DoPaymentWithBankTransferResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithBankTransferResponse")
    public ResultDoPaymentWithBankTransfer doPaymentWithBankTransfer(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Items", targetNamespace = "https://api.dineromail.com/")
        ArrayOfItem items,
        @WebParam(name = "Buyer", targetNamespace = "https://api.dineromail.com/")
        Buyer buyer,
        @WebParam(name = "Provider", targetNamespace = "https://api.dineromail.com/")
        String provider,
        @WebParam(name = "BankTransferData", targetNamespace = "https://api.dineromail.com/")
        BankTransferData bankTransferData,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "MerchantUrlRedirect", targetNamespace = "https://api.dineromail.com/")
        String merchantUrlRedirect,
        @WebParam(name = "MerchantUrlNotification", targetNamespace = "https://api.dineromail.com/")
        String merchantUrlNotification,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param message
     * @param bankTransferData
     * @param hash
     * @param items
     * @param subject
     * @param buyer
     * @param provider
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @return
     *     returns https.api_dineromail.ResultDoPaymentWithDirectBankTransfer
     */
    @WebMethod(operationName = "DoPaymentWithDirectBankTransfer", action = "https://api.dineromail.com/DoPaymentWithDirectBankTransfer")
    @WebResult(name = "DoPaymentWithDirectBankTransferResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "DoPaymentWithDirectBankTransfer", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithDirectBankTransfer")
    @ResponseWrapper(localName = "DoPaymentWithDirectBankTransferResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithDirectBankTransferResponse")
    public ResultDoPaymentWithDirectBankTransfer doPaymentWithDirectBankTransfer(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Items", targetNamespace = "https://api.dineromail.com/")
        ArrayOfItem items,
        @WebParam(name = "Buyer", targetNamespace = "https://api.dineromail.com/")
        Buyer buyer,
        @WebParam(name = "Provider", targetNamespace = "https://api.dineromail.com/")
        String provider,
        @WebParam(name = "BankTransferData", targetNamespace = "https://api.dineromail.com/")
        BankTransferData bankTransferData,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param amount
     * @param hash
     * @param provider
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @param currency
     * @return
     *     returns https.api_dineromail.ResultGetPaymentTicket
     */
    @WebMethod(operationName = "GetPaymentTicket", action = "https://api.dineromail.com/GetPaymentTicket")
    @WebResult(name = "GetPaymentTicketResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "GetPaymentTicket", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetPaymentTicket")
    @ResponseWrapper(localName = "GetPaymentTicketResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetPaymentTicketResponse")
    public ResultGetPaymentTicket getPaymentTicket(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "Currency", targetNamespace = "https://api.dineromail.com/")
        String currency,
        @WebParam(name = "Amount", targetNamespace = "https://api.dineromail.com/")
        String amount,
        @WebParam(name = "Provider", targetNamespace = "https://api.dineromail.com/")
        String provider,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param amount
     * @param hash
     * @param bankAccountDetail
     * @param method
     * @param crypt
     * @param uniqueMessageId
     * @param addressDetail
     * @param merchantTransactionId
     * @param credential
     * @param currency
     * @return
     *     returns https.api_dineromail.ResultDoWithDraw
     */
    @WebMethod(operationName = "DoWithDraw", action = "https://api.dineromail.com/DoWithDraw")
    @WebResult(name = "DoWithDrawResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "DoWithDraw", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoWithDraw")
    @ResponseWrapper(localName = "DoWithDrawResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoWithDrawResponse")
    public ResultDoWithDraw doWithDraw(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Method", targetNamespace = "https://api.dineromail.com/")
        String method,
        @WebParam(name = "Currency", targetNamespace = "https://api.dineromail.com/")
        String currency,
        @WebParam(name = "Amount", targetNamespace = "https://api.dineromail.com/")
        String amount,
        @WebParam(name = "AddressDetail", targetNamespace = "https://api.dineromail.com/")
        AddressDetail addressDetail,
        @WebParam(name = "BankAccountDetail", targetNamespace = "https://api.dineromail.com/")
        BankAccountDetail bankAccountDetail,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param startDate
     * @param hash
     * @param endDate
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @param operationId
     * @return
     *     returns https.api_dineromail.ResultGetOperations
     */
    @WebMethod(operationName = "GetOperations", action = "https://api.dineromail.com/GetOperations")
    @WebResult(name = "GetOperationsResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "GetOperations", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetOperations")
    @ResponseWrapper(localName = "GetOperationsResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetOperationsResponse")
    public ResultGetOperations getOperations(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "OperationId", targetNamespace = "https://api.dineromail.com/")
        String operationId,
        @WebParam(name = "StartDate", targetNamespace = "https://api.dineromail.com/")
        String startDate,
        @WebParam(name = "EndDate", targetNamespace = "https://api.dineromail.com/")
        String endDate,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param message
     * @param creditCard
     * @param hash
     * @param items
     * @param subject
     * @param buyer
     * @param provider
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @return
     *     returns https.api_dineromail.ResultDoPaymentWithCreditCard
     */
    @WebMethod(operationName = "DoPaymentWithCreditCard", action = "https://api.dineromail.com/DoPaymentWithCreditCard")
    @WebResult(name = "DoPaymentWithCreditCardResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "DoPaymentWithCreditCard", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithCreditCard")
    @ResponseWrapper(localName = "DoPaymentWithCreditCardResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithCreditCardResponse")
    public ResultDoPaymentWithCreditCard doPaymentWithCreditCard(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Items", targetNamespace = "https://api.dineromail.com/")
        ArrayOfItem items,
        @WebParam(name = "Buyer", targetNamespace = "https://api.dineromail.com/")
        Buyer buyer,
        @WebParam(name = "Provider", targetNamespace = "https://api.dineromail.com/")
        String provider,
        @WebParam(name = "CreditCard", targetNamespace = "https://api.dineromail.com/")
        CreditCard creditCard,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param hash
     * @param subject
     * @param provider
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @param creditCard
     * @param message
     * @param merchantUrlRedirect
     * @param items
     * @param buyer
     * @param merchantUrlNotification
     * @return
     *     returns https.api_dineromail.ResultDoPaymentWithCreditCardThirdParty
     */
    @WebMethod(operationName = "DoPaymentWithCreditCardThirdParty", action = "https://api.dineromail.com/DoPaymentWithCreditCardThirdParty")
    @WebResult(name = "DoPaymentWithCreditCardThirdPartyResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "DoPaymentWithCreditCardThirdParty", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithCreditCardThirdParty")
    @ResponseWrapper(localName = "DoPaymentWithCreditCardThirdPartyResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.DoPaymentWithCreditCardThirdPartyResponse")
    public ResultDoPaymentWithCreditCardThirdParty doPaymentWithCreditCardThirdParty(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Items", targetNamespace = "https://api.dineromail.com/")
        ArrayOfItem items,
        @WebParam(name = "Buyer", targetNamespace = "https://api.dineromail.com/")
        Buyer buyer,
        @WebParam(name = "Provider", targetNamespace = "https://api.dineromail.com/")
        String provider,
        @WebParam(name = "CreditCard", targetNamespace = "https://api.dineromail.com/")
        CreditCard creditCard,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "MerchantUrlRedirect", targetNamespace = "https://api.dineromail.com/")
        String merchantUrlRedirect,
        @WebParam(name = "MerchantUrlNotification", targetNamespace = "https://api.dineromail.com/")
        String merchantUrlNotification,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param message
     * @param amount
     * @param hash
     * @param subject
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @param currency
     * @return
     *     returns https.api_dineromail.ResultRefund
     */
    @WebMethod(operationName = "Refund", action = "https://api.dineromail.com/Refund")
    @WebResult(name = "RefundResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "Refund", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.Refund")
    @ResponseWrapper(localName = "RefundResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.RefundResponse")
    public ResultRefund refund(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "Currency", targetNamespace = "https://api.dineromail.com/")
        String currency,
        @WebParam(name = "Amount", targetNamespace = "https://api.dineromail.com/")
        String amount,
        @WebParam(name = "Subject", targetNamespace = "https://api.dineromail.com/")
        String subject,
        @WebParam(name = "Message", targetNamespace = "https://api.dineromail.com/")
        String message,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param refundedMerchantTransactionId
     * @param hash
     * @param crypt
     * @param uniqueMessageId
     * @param merchantTransactionId
     * @param credential
     * @return
     *     returns https.api_dineromail.ResultGetRefundStatus
     */
    @WebMethod(operationName = "GetRefundStatus", action = "https://api.dineromail.com/GetRefundStatus")
    @WebResult(name = "GetRefundStatusResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "GetRefundStatus", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetRefundStatus")
    @ResponseWrapper(localName = "GetRefundStatusResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.GetRefundStatusResponse")
    public ResultGetRefundStatus getRefundStatus(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential,
        @WebParam(name = "Crypt", targetNamespace = "https://api.dineromail.com/")
        boolean crypt,
        @WebParam(name = "MerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String merchantTransactionId,
        @WebParam(name = "RefundedMerchantTransactionId", targetNamespace = "https://api.dineromail.com/")
        String refundedMerchantTransactionId,
        @WebParam(name = "UniqueMessageId", targetNamespace = "https://api.dineromail.com/")
        String uniqueMessageId,
        @WebParam(name = "Hash", targetNamespace = "https://api.dineromail.com/")
        String hash);

    /**
     * 
     * @param credential
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "UserRefundAccess", action = "https://api.dineromail.com/UserRefundAccess")
    @WebResult(name = "UserRefundAccessResult", targetNamespace = "https://api.dineromail.com/")
    @RequestWrapper(localName = "UserRefundAccess", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.UserRefundAccess")
    @ResponseWrapper(localName = "UserRefundAccessResponse", targetNamespace = "https://api.dineromail.com/", className = "https.api_dineromail.UserRefundAccessResponse")
    public boolean userRefundAccess(
        @WebParam(name = "Credential", targetNamespace = "https://api.dineromail.com/")
        APICredential credential);

}