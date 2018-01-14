public class SalesLineItem
{
private int quantity;
private ProductSpecification specification;
public SalesLineItem (ProductSpecification spec, int quantity )
{
this.specification = spec;
this.quantity = quantity;
}
public Money getSubtotal()
{
return specification.getPrice().times( quantity );
}
}