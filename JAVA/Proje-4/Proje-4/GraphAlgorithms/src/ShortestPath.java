import java.util.*;


public class ShortestPath {
	
	public static VertexDist[] DijkstraAlgorithm(Vertx[] V, int[][] E, int s)
	{
		
		VertexDist[] d = new VertexDist[V.length];
        VertexDist[] pred = new VertexDist[V.length];
        Vector<Vertx> S = new Vector<Vertx>();

        for(int v = 0; v < V.length; v++)     
            d[v] = new VertexDist(Integer.MAX_VALUE, v);
 

        d[s].value = 0;

        PriorityQueue<VertexDist> Q = new PriorityQueue<VertexDist>();
        
        Q.add(d[s]);

        while (!Q.isEmpty())
        {
            VertexDist u = (VertexDist) Q.poll();
          
            S.add(V[u.index]);

            for (int v = 0; v < V.length; v++) 
            {
                 if(!existInS(S, v) && E[u.index][v] > 0){
	            	 if(d[v].value > d[u.index].value + E[u.index][v])
	                 {
	                    d[v].value = d[u.index].value + E[u.index][v];
	                    pred[v] = u;
	                    Q.add(d[v]);
	                 }
                 }
            }
        }
        return d;
 	}
        
      
   
  	static boolean existInS(Vector<Vertx> s, int v) {
		 for (int i = 0; i < s.size(); i++)
			{
				
				if((s.get(i)).getIndex() == v)
				{
					return true; 
				}
			}
			// TODO Auto-generated method stub
			return false;
	}
 	
 	
 	static int[][] floydWarshallAlgorithmV_2(int[][] E)
    {
        int[][] dist = new int[E[0].length] [E[0].length];

        for (int i = 0; i < E[0].length; i++)
        {
            for (int j = 0; j < E[1].length; j++)
            {
                if (E[i][j] == 0)
                	dist[i][j] = 10000;
                else
                	dist[i][j] = E[i][j];
            }
        }

        for (int k = 0; k < 1;k++)//E[0].length; k++)
        {
            for (int i = 0; i < E[0].length; i++)
            {
                for (int j = 0; j < E[0].length; j++)
                {
                    if (i != j)
                    	dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        return dist;
    }
 	
 	 private static int min(int p,int p_2)
     {
	        if(p < p_2) return p;
         return p_2;
     }


 	
	
}


	


