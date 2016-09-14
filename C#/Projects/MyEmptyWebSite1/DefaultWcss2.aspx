<%@ Page Language="C#" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<script runat="server">

</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .style1 {
            color: #0066FF;
        }
        </style>
    
    <link href="Styles/Styles.css" rel="stylesheet" type="text/css" />
    
</head>
<body>
    <form id="form1" runat="server">
    <div id="PageWrapper">
        <div id="Header">Header goes here.</div>    
        <div id="MenuWrapper">Menu goes here.</div>
        <div id="MainContent">
            <h1>
                Hi there visitor! Welcome to my Web Site :-)</h1>
        <p class="Introduction">
            I&#39;m glad that you are visiting my web site <a href="http://www.mywebsite.com">
            http://www.mywebsite.com</a></p>
        <p class="Introduction">
            <strong>Feel </strong><span class="style1"><strong>free</strong></span> to have 
            a <a href="TableDemo.aspx">look around</a>.</p>
        </div>
        <div id="Sidebar">Sidebar goes here.</div>
        <div id="Footer">Footer goes here.</div>
    </div>

    </form>
</body>
</html>
