
public class GraphEdge {

//	I need an origin and a destination
//	I need an int type variable
//	and I need a string label
	private GraphNode start;
	private GraphNode end;
	private int type;
	private String label;
	
	public GraphEdge(GraphNode u, GraphNode v, int type, String label) {
//		I should probably initialize everything
		this.start = u;
		this.end = v;
		this.type = type;
		this.label = label;
	}
	
//	I should probably fill in the bodies of those setters and getters
	public GraphNode firstEndpoint() {
		return start;
	}
	
	public GraphNode secondEndpoint() {
		return end;
	}
	
	public int getType() {
		return type;
	}
	
	public void setype(int type) {
		this.type = type;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
}
