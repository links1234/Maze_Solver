import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph implements GraphADT {
	
//	Create an adjacency list or an adjacency matrix, a list is probably easier
	
	private ArrayList<ArrayList<GraphEdge>> edges; 
	private ArrayList<GraphNode> nodes;

	public Graph(int n) {
//		initialize your representation with empty adjacency lists
		edges = new ArrayList<>(n);
		nodes = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			edges.add(new ArrayList<>()); 
			GraphNode node = new GraphNode(i);
			nodes.add(node);
			
		}
	}
	
	@Override
	public void insertEdge(GraphNode nodeu, GraphNode nodev, int type, String label) throws GraphException {
//		create and insert the edge
//		REMEMBER, an edge is accessible from both endpoints, so make sure you add it as an edge for both end nodes		
		int nodeU = nodes.indexOf(nodeu);
		int nodeV = nodes.indexOf(nodev);

		if (nodeU == -1 || nodeV == -1) {
			throw new GraphException("One or both nodes do not exist in the graph.");
		}	
		GraphEdge newEdge = new GraphEdge(nodeu, nodev, type, label);

		edges.get(nodeU).add(newEdge);
		edges.get(nodeV).add(newEdge);
	}

	@Override
	public GraphNode getNode(int name) throws GraphException {
//		Return the node with the appropriate name
		// GraphNode tmp = new GraphNode(name);
		if ((nodes.get(name).getName() != name) && (name < 0 || name >= nodes.size())) {
			throw new GraphException("No node with this name exists");
		}	
		return nodes.get(name);

	}

	@Override
	public Iterator<GraphEdge> incidentEdges(GraphNode u) throws GraphException {
//		Select from your adjacency list the appropriate Node and return an iterator over the collection.
//		Usually a call to .iterator() should work, unless you do something really exotic
		if (!nodes.contains(u)){
			throw new GraphException("This node does not exist in the graph");
		}

		ArrayList<GraphEdge> indEdges = edges.get(nodes.indexOf(u));

		if (indEdges.isEmpty()) {
			return null; 
		}
		return indEdges.iterator(); 
		
	}

	@Override
	public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException {
//		check if those nodes exist, then check if they have edges, then who has the least number of edges.
//		find the appropriate edge and return it, if no such edge exists remember to return null 
//		there are faster ways too ;)
	if ((!nodes.contains(u)) || (!nodes.contains(v))){
		throw new GraphException("These node do not exist in the graph");
	}

	for (GraphEdge edge : edges.get(nodes.indexOf(u))) {
        if ((edge.firstEndpoint().equals(u) && edge.secondEndpoint().equals(v)) || (edge.firstEndpoint().equals(v) && edge.secondEndpoint().equals(u))) {
            return edge;
        }
    }

	return null;
	}

	@Override
	public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException {
//		maybe you could use a previously written method to solve this one quickly...
		if (getEdge(u, v) == null){
			return false;
		} else {
			return true;
		}
	}

}
