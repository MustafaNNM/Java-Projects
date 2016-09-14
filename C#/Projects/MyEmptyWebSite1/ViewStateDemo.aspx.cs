using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class ViewStateDemo : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void kground_Click(object sender, EventArgs e)
    {
        TextBox1.BackColor = System.Drawing.Color.Orange;
    }
    protected void Font_Click(object sender, EventArgs e)
    {
        TextBox1.ForeColor = System.Drawing.Color.Green;
    }
}