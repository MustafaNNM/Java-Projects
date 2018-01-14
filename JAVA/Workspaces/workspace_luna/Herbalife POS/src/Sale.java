import java.util.Vector;

public class Sale
{
private Vector<SalesLineItem> lineItems =new Vector<SalesLineItem>();
private Date date = new Date();
private boolean isComplete = false;
private Payment payment;
public Money getBalance()
{
return payment.getAmount().minus( getTotal() );
}
public void becomeComplete() { isComplete = true; }
public boolean isComplete() { return isComplete; }
public void makeLineItem
( ProductSpecification spec, int quantity )
{
lineItems.add( new SalesLineItem( spec, quantity ) );
}
public Money getTotal()
{
Money total = new Money();
Money subtotal = null;
for ( SalesLineItem lineItem : lineItems )
{
subtotal = lineItem.getSubtotal();
total.add( subtotal );
}
return total;
}
public void makePayment( Money cashTendered )
{
payment = new Payment( cashTendered );
}
/**
 * @return the date
 */
public Date getDate() {
	return date;
}
/**
 * @param date the date to set
 */
public void setDate(Date date) {
	this.date = date;
}
}
