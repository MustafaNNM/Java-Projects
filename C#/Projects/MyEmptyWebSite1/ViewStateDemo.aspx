<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ViewStateDemo.aspx.cs" Inherits="ViewStateDemo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:TextBox ID="TextBox1" runat="server" EnableViewState="False">ViewState</asp:TextBox>
        <asp:Button ID="kground" runat="server" onclick="kground_Click" 
            Text="BackgroundColor" />
        <asp:Button ID="Font" runat="server" onclick="Font_Click" Text="FontColor" />
    
    </div>
    </form>
</body>
</html>
