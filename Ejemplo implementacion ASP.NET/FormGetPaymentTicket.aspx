<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="FormGetPaymentTicket.aspx.cs" Inherits="ASP.NET.FormGetPaymentTicket" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Button ID="btnGetPaymentTicket" runat="server" Text="GetPaymentTicket" 
            onclick="btnGetPaymentTicket_Click" />
    </div>
    </form>
    <p>
        <a href="Default.aspx">Default.aspx</a></p>
</body>
</html>
