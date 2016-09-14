//roolver img
function mmenuSwap(imgx,place) {
var imgName = "rol_"+place;
img1 = new Image();
  if (document.images) {
    document.images[imgName].src = "imgItems/"+imgx;
  }
}

function changePanel(pPrm){
var imgNews = "newsImg";
var imgAnnounce = "announceImg";
if(pPrm=='1')
    {
    document.images[imgNews].src = "imgItems/middle_01.jpg";
    document.images[imgAnnounce].src = "imgItems/middle_02.jpg";
    document.getElementById('announcePanel').style.display='none'; 
    document.getElementById('newsPanel').style.display='block';
    }
    
if(pPrm=='2')
    {
    document.images[imgAnnounce].src = "imgItems/middle2_02.jpg";
    document.images[imgNews].src = "imgItems/middle2_01.jpg";
    document.getElementById('announcePanel').style.display='block';
    document.getElementById('newsPanel').style.display='none';
    
    
    }
}

function Pprint(){
document.getElementById("dprint").style.display='none';
window.print();
}

function enotice()
{
    if(document.getElementById("cmbReason").value=='')
        {alert("Lütfen arıza sebebini seçiniz."); return false;}
}


function calculateTotal(inputItem) {
var chktt = 0;
var ckk = 2;
var arrChk = document.getElementsByTagName('input');
	var count = 0;
with (inputItem.form) {
	for(var c = 0; c < arrChk.length ; c++)
	{
		if (arrChk[c].getAttribute('type')=='checkbox') 
		count = arrChk[c].checked?(count+1): count; 
	}

if (inputItem.checked == false) {
calculatedTotal.value = eval(calculatedTotal.value) - eval(inputItem.value);
} else {
calculatedTotal.value = eval(calculatedTotal.value) + eval(inputItem.value);
}
if (calculatedTotal.value > 0) {
document.getElementById("divtotals").innerHTML = "<b>" + count + "</b> Adet Fatura Karşılığı Toplam <b>" + formatCurrency(calculatedTotal.value) + "</b> TL. borcunuz bulunmaktadır.";
}
else
    {document.getElementById("divtotals").innerHTML = 'Lütfen ödeme yapmak istediğiniz faturalarınızı seçiniz.';}
}
}

function formatCurrency(num) {
num = num.toString().replace(/\$|\,/g,'');
if(isNaN(num))
num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();
if(cents<10)
cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3)) + ',' + num.substring(num.length-(4*i+3));
return (((sign)?'':'-') + '' + num + '.' + cents);
}
//
function whcM() {
    var cd = 2350;
    
    var d = new Date();
    var h = d.getHours();
    var m = d.getMinutes();
    var hm = h.toString() + m.toString();
    var rd = cd - parseInt(hm)
    if (rd <= 5)
    { return rd; }
    else
    { rd = 5; }
    return rd;
}

var mins
var secs;

function cd() {
    if (!document.getElementById("timesUp")) {
        return;
    }

    mins = whcM() * m("1");
    secs = 0 + s(":01");
    redo();
}

function m(obj) {
    for (var i = 0; i < obj.length; i++) {
        if (obj.substring(i, i + 1) == ":")
            break;
    }
    return (obj.substring(0, i));
}

function s(obj) {
    for (var i = 0; i < obj.length; i++) {
        if (obj.substring(i, i + 1) == ":")
            break;
    }
    return (obj.substring(i + 1, obj.length));
}

function dis(mins, secs) {
    var disp;
    if (mins <= 9) {
        disp = " 0";
    } else {
        disp = " ";
    }
    disp += mins + ":";
    if (secs <= 9) {
        disp += "0" + secs;
    } else {
        disp += secs;
    }
    return (disp);
}

function redo() {
    secs--;
    if (secs == -1) {
        secs = 59;
        mins--;
    }

    document.getElementById("timesUp").innerHTML = dis(mins, secs);
    if ((mins == 0) && (secs == 0)) {
        document.getElementById("timesUpText").innerHTML = '&nbsp;&nbsp;İşlem süresi aşıldı. Yeni işlem için <a href="pay.aspx">tıklayınız.</a> ';
        XTmr23();
        return;
    } else {
        cd = setTimeout("redo()", 1000);
    }
}


function userinf(objName)
{
var bFrm = document.getElementById;
if(bFrm("eposta").value=="" && bFrm("gsm").value=="" && bFrm("tel").value=="" )
	{alert("Lütfen aşağıdaki iletişim seçeneklerinden \n en az birini doldurunuz."); return false;}
	
if(bFrm("eposta").value!="")
		{
		if(bFrm("eposta").value.indexOf("@")==-1 || bFrm("eposta").value.indexOf(".")==-1)
			{alert("Lütfen geçerli e-posta adresi giriniz."); return false;}
		}
} 

function MM_swapImgRestore() { 
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { 
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { 
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() {
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function MM_openBrWindow(theURL,winName,features) {
  window.open(theURL,winName,features);
}

function paySend() {
    var chk = false;
    for (i = 0; i < document.form1.elements.length; i++) 
   {
       if (document.form1.elements[i].type == "checkbox") 
       {
           if (document.form1.elements[i].checked)
           {
               chk = true;
           }
       }
   }
   if (!chk)
   { alert("Lütfen ödemek istediğiniz dönemi işaretleyiniz."); return false; }

   if (document.form1.TextBox1.value.length != 6) {
       alert("Lütfen kredi kartının ilk altı(6) hanesini giriniz"); return false;
   }

   if (document.form1.hgCek.value != "1") {
       alert("Kart bilginiz doğrulanamıyor."); return false;
   }
   
}

function Cheking(prm) {
    //document.form1.cek.value = prm;
    alert('ahoo' + prm);
}