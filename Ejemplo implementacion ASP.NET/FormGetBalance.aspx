<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="FormGetBalance.aspx.cs" Inherits="ASP.NET.FormGetBalance" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <asp:Button ID="btnGetBalance" runat="server" onclick="btnGetBalance_Click" 
            Text="GetBalance" />
    </div>
    </form>
    <p>
        <a href="Default.aspx">Default.aspx</a></p>
</body>
</html>
