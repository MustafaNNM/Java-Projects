public class ProductCatalog
{
private HashMap<ItemID, ProductSpecification> specifications = new HashMap()<ItemID, ProductSpecification>;
public ProductCatalog()
{
// sample data
ItemID id1 = new ItemID( 100 );
ItemID id2 = new ItemID( 200 );
Money price = new Money( 3 );
ProductSpecification spec;
spec = new ProductSpecification( id1, price, "product 1" );
specifications.put( id1, spec );
spec = new ProductSpecification( id2, price, "product 2" );
specifications.put( id2, spec );
}
public ProductSpecification getProductSpecification(ItemID id) {
	// TODO Auto-generated method stub
	return specifications.get( id );
}