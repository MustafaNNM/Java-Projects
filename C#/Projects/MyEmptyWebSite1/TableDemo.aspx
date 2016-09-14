<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TableDemo.aspx.cs" Inherits="TableDemo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .style1
        {
            width: 100%;
        }
        .style2
        {
            width: 200px;
        }
        .style3
        {
            list-style-type: square;
        }
    </style>
</head>
<body>
<form id="form1" runat="server">
    <div>
    
        <table class="style1">
            <tr>
                <td class="style2">
                    My Favorite Musicians</td>
                <td>
                    <ul>
                        <li>Madonna</li>
                        <li>U2</li>
                        <li>Marcus Miller</li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td class="style2">
                    My Favorite Actors</td>
                <td>
                    <ol>
                        <li>Jeremy Irons</li>
                        <li>Kevin Spacey</li>
                        <li>Tom Hardy</li>
                    </ol>
                </td>
            </tr>
            <tr>
                <td class="style2">
                    My Favorite Movies</td>
                <td>
                    <ul class="style3">
                        <li>Snatch</li>
                        <li>A Good Year</li>
                        <li>Bronson</li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td class="style2">
                    Link</td>
                <td>
                    Go to the <a href="Default.aspx">Homepage</a></td>
            </tr>
            <tr>
                <td class="style2">
                    Link to IMDB</td>
                <td>
                    <a href="http://www.imdb.com">IMDB</a></td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
