

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertx[] V = new Vertx[6];
		V[0] = new Vertx("a", 0);
		V[1] = new Vertx("b", 1);
		V[2] = new Vertx("c", 2);
		V[3] = new Vertx("d", 3);
		V[4] = new Vertx("e", 4);
		V[5] = new Vertx("f", 5);
		
		int [][] E = {{0,15,0,20,0,0},
					  {15,0,10,0,5,0},
					  {0,10,0,0,0,25},
					  {20,0,0,0,10,0},
					  {0,5,0,10,0,15},
					  {0,0,25,0,15,0}};
		
		Graph g = new Graph(V,E);
		
		VertexDist[] distances = ShortestPath.DijkstraAlgorithm(g.getVertices(), g.getEdges(), 0);
		
		for(int i = 1; i < distances.length; i++)
		{
			System.out.println(V[i].getName() +"   "+ distances[i].value);
			
		}
		
		int[][] alldist = ShortestPath.floydWarshallAlgorithmV_2(g.getEdges());
		
		System.out.println("stortest distance between a and f = " + alldist[0][5]);
	}

}
