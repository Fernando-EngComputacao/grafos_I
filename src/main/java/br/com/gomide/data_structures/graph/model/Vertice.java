package br.com.gomide.data_structures.graph.model;


public class Vertice implements Comparable<Vertice>{
	private String label;
	
	public Vertice(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

    @Override
    public int compareTo(Vertice vertice) {
        return (this.label.equalsIgnoreCase(vertice.label) ? 0: 1);
    }
}
