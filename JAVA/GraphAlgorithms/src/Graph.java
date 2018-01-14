
public class Graph {
	
	private Vertx[] vertices;
	private int[][] edges;
	
	public Graph(Vertx[] V, int[][] E)
	{
		vertices = V;
		edges = E;
	}

	public Vertx[] getVertices() {
		return vertices;
	}

	public void setVertices(Vertx[] vertices) {
		this.vertices = vertices;
	}

	public int[][] getEdges() {
		return edges;
	}

	public void setEdges(int[][] edges) {
		this.edges = edges;
	}
	
	
}
