public class ProductSpecification
{
private ItemID id;
private Money price;
private String specification;
public ProductSpecification
( ItemID id, Money price, String specification )
{
this.id = id;
this.price = price;
this.specification = specification;
}
public ItemID getItemID() { return id; }
public Money getPrice() { return price; }
public String getSpecification() { return specification; }
}