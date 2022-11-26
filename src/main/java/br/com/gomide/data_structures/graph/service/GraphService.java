package br.com.gomide.data_structures.graph.service;

import java.util.Collections;
import java.util.List;


import br.com.gomide.data_structures.graph.model.DirectedGraph;
import br.com.gomide.data_structures.graph.model.Graph;
import br.com.gomide.data_structures.graph.model.NonDirectedGraph;

public class GraphService implements IGraphService {

	@Override
	public void addNodes(List<String> labels, Graph graph) {
		labels.forEach(label -> addNode(label, graph));
	}

	@Override
	public void addNode(String label, Graph graph) {
		graph.addVertice(label);
	}

	@Override
	public void connectNode(String firstLabel, String secondLabel, Graph graph) {
		graph.addEdge(firstLabel, secondLabel);
	}

	@Override
	public int countLoops(Graph graph) {
		return (int) graph.getEdges()
				.stream()
				.filter(edge -> edge.getStartpoint().equals(edge.getEndpoint()))
				.count();
	}

	@Override
	public int countMultipleLink(Graph graph) {
		return (int) graph.getEdges()
				.stream()
				.distinct()
				.filter(edge -> Collections.frequency(graph.getEdges(), edge) > 1)
				.count();
	}

	@Override
	public int nodeDegree(String label, Graph graph) {
		return (int) graph.getEdges()
				.stream()
				.filter(edge -> edge.getStartpoint().getLabel().equals(label) || edge.getEndpoint().getLabel().equals(label))
				.count();
	}

	@Override
	public boolean isConnected(Graph graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete(Graph graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String showPath(String origin, String destination, DirectedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showPath(String origin, String destination, NonDirectedGraph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(Graph graph) {
		return graph.toString();
	}


}
