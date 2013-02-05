import java.util.*;

// A0072292H
// Chong Yun Long


class Labor {
	private int V; // number of vertices in the graph (number of junctions in Singapore map)
	private Vector < Vector < IntegerPair > > AdjList; // the weighted graph (the Singapore map), the length of each edge (road) is stored here too, as the weight of edge

	// if needed, declare a private data structure here that
	// is accessible to all methods in this class
	// --------------------------------------------
	private PriorityQueue<IntegerPair> q ; 
	private Vector<Integer> weights ; 


	// --------------------------------------------

	public Labor() {
		// Write necessary codes during construction;
		//
		// write your answer here



	}

	int Query() {


		// You have to report the shortest path from Steven and Grace's home (vertex 0)
		// to reach their chosen hospital (vertex 1)
		//
		// write your answer here

		q = new PriorityQueue<IntegerPair>() ;
		weights = new Vector<Integer>() ;
		weights.setSize(V) ;
		Collections.fill(weights, Integer.MAX_VALUE) ; // initially all infinite

		q.offer(new IntegerPair(0,0)) ;
		weights.set(0, 0) ;


		return dijkstra();
	}

	// You can add extra function if needed
	// --------------------------------------------
	int dijkstra()
	{
		IntegerPair current;
		while (!q.isEmpty()) {

			current = q.poll() ;
			if (weights.get(current.first())==current.second())
				for (IntegerPair next : AdjList.get(current.first())) {
					if (weights.get(next.first()) > current.second() + next.second()) {
						weights.set( next.first(), current.second() + next.second())  ;
						q.offer(new IntegerPair(next.first(), weights.get(next.first()) ) ) ;
					}
				}
		}
		return weights.get(1) ;
	}


	// --------------------------------------------

	void run() {
		// do not alter this method
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt(); // there will be several test cases
		while (TC-- > 0) {
			V = sc.nextInt();

			// clear the graph and read in a new graph as Adjacency List
			AdjList = new Vector < Vector < IntegerPair > >();
			for (int i = 0; i < V; i++) {
				AdjList.add(new Vector<IntegerPair>());

				int k = sc.nextInt();
				while (k-- > 0) {
					int j = sc.nextInt(), w = sc.nextInt();
					AdjList.get(i).add(new IntegerPair(j, w)); // edge (road) weight (length of road) is stored here
				}
			}

			System.out.println(Query());
		}
	}

	public static void main(String[] args) {
		// do not alter this method
		Labor ps5 = new Labor();
		ps5.run();
	}
}
