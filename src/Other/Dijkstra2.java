package Other;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;


public class Dijkstra2 {

	private static final Graph.Edge[] GRAPH = {
		
		new Graph.Edge("a", "b", 7),
		new Graph.Edge("a", "c", 9),
		new Graph.Edge("a", "f", 14),
		new Graph.Edge("b", "c", 3),
		new Graph.Edge("b", "f", 1),
		new Graph.Edge("b", "d", 19),
		new Graph.Edge("c", "d", 3),
		new Graph.Edge("f", "b", 4),
		new Graph.Edge("d", "e", 3),
		//new Graph.Edge("e", "f", 10),
	};
	private static final String START = "a";
	private static final String END = "e";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(GRAPH);
		g.dijkstra(START);
		g.printPath(END);
	}

}

class Graph {
	private final Map<String, Vertex> graph;
			
	public static class Edge{
		public final String v1, v2;
		public final int dist;
		
		public Edge(String v1, String v2, int dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}
	}
	
	public static class Vertex implements Comparable<Vertex>
	{
		public final String name;
		public int dist = Integer.MAX_VALUE;
		public Vertex previous = null;
		public final Map<Vertex, Integer> neighbours = new HashMap<>();
		
		public Vertex(String name)
		{
			this.name = name;
		}
		public void printPath()
		{
			if (this == this.previous) {
				System.out.printf("%s", this.name);
			}
			else if (this.previous == null) {
				System.out.printf("%s (unreached)", this.name);
			}
			else {
				this.previous.printPath();
				System.out.printf(" -> %s(%d)", this.name, this.dist);
			}
		}
		
		@Override
		public int compareTo(Vertex other) {
			if (dist == other.dist) return name.compareTo(other.name);
			
			return Integer.compare(dist,  other.dist);
		}
		
		@Override
		public boolean equals(Object obj) {
			if ( this == obj) return true;
			if ( obj == null || getClass() != obj.getClass())	return false;
			if ( !super.equals(obj))	return false;
			
			Vertex vertex = (Vertex)obj;
			
			if (dist !=  vertex.dist) return false;
			if (name != null ? !name.equals(vertex.name) : vertex.name != null) return false;
			if (previous != null ? !previous.equals(vertex.previous) : vertex.previous != null ) return false;
			if (neighbours != null ? !neighbours.equals(vertex.neighbours) : vertex.neighbours != null) return false;
			
			return true;
		}
		
		@Override
		public int hashCode() {
			int result = super.hashCode();
			result = 31 * result + (name != null ? name.hashCode() : 0);
			result = 31 * result + dist;
			result = 31 * result + (previous != null ? previous.hashCode() : 0);
			result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
			return result;
		}
		
		@Override
		public String toString() {
			return "(" + name + ", " + dist + ")";
		}
	}
	
	public Graph(Edge[] edges) {
		graph = new HashMap<>(edges.length);
		
		for(Edge e : edges) {
			if (!graph.containsKey(e.v1)) {
				graph.put(e.v1, new Vertex(e.v1));
			}
			
			if (!graph.containsKey(e.v2)) {
				graph.put(e.v2, new Vertex(e.v2));
			}
		}
		
		for(Edge e : edges) {
			graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
		}
	}
	
	public void dijkstra(String startName) {
		if (!graph.containsKey(startName)) {
			return;
		}
		
		final Vertex source = graph.get(startName);
		NavigableSet<Vertex> q = new TreeSet<>();
		
		for (Vertex v : graph.values()) {
			v.previous = v == source ? source : null;
			v.dist = v == source ? 0 : Integer.MAX_VALUE;
			q.add(v);
		}
		
		dijkstra(q);
	}
	
	public void dijkstra(NavigableSet<Vertex> q) {
		Vertex u, v;
		
		while(!q.isEmpty()) {
			u = q.pollFirst();
			if (u.dist == Integer.MAX_VALUE) {
				break;
			}
			
			for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
				v = a.getKey();
				
				final int alternateDist = u.dist + a.getValue();
				if (alternateDist < v.dist) {
					q.remove(v);
					v.dist = alternateDist;
					v.previous = u;
					q.add(v);
				}
			}
		}
	}

	
	public void printPath(String endName) {
		if (!graph.containsKey(endName)) {
			return;
		}
		
		graph.get(endName).printPath();
		System.out.println();
	}
	
}


