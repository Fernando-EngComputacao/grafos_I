package br.com.gomide.data_structures.graph.model;

public class Edge implements Comparable<Edge>{
	
	private Vertice startpoint;
	private Vertice endpoint;
	private boolean isResolved = false;
	
	public Edge(Vertice startpoint, Vertice endpoint) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
	}
	
	public Vertice getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(Vertice startpoint) {
		this.startpoint = startpoint;
	}
	public Vertice getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(Vertice endpoint) {
		this.endpoint = endpoint;
	}
	public boolean isResolved() {
		return isResolved;
	}
	public void switchResolved() {
		this.isResolved = !this.isResolved;
	}
	
	
    @Override
    public int compareTo(Edge edge) {
    	
    	if ((this.startpoint.compareTo(edge.startpoint) == 0) && (this.endpoint.compareTo(edge.endpoint) == 0))
			return 0;
		else
			return 1;
    }


}
