package br.com.gomide.data_structures.graph.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gomide.data_structures.graph.model.DirectedGraph;
import br.com.gomide.data_structures.graph.model.Graph;
import br.com.gomide.data_structures.graph.model.NonDirectedGraph;
import br.com.gomide.data_structures.graph.model.Vertice;

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
		return (int) graph.getEdges().stream().filter(edge -> edge.getStartpoint().equals(edge.getEndpoint())).count();
	}

	@Override
	public int countMultipleLink(Graph graph) {
		return (int) graph.getEdges().stream().distinct()
				.filter(edge -> Collections.frequency(graph.getEdges(), edge) > 1).count();
	}

	@Override
	public int nodeDegree(String label, Graph graph) {
		return (int) graph.getEdges().stream().filter(
				edge -> edge.getStartpoint().getLabel().equals(label) || edge.getEndpoint().getLabel().equals(label))
				.count();
	}

	@Override
	public boolean isConnected(Graph graph) {
		return false;
	}

	@Override
	public boolean isComplete(Graph graph) {
		boolean state = true;
		for (Vertice element : graph.getVertice()) {
			int soma = (int) graph.getEdges().stream()
					.filter(edge -> edge.getEndpoint().getLabel().equals(element.getLabel())
							|| edge.getStartpoint().getLabel().equals(element.getLabel()))
					.count();
			state = (state == false ? false : (soma != (graph.getVertice().size() - 1) ? false : true));
		}

		return state;
	}

	@Override
	public String showPath(String origin, String destination, DirectedGraph graph) {
		List<String> list = new ArrayList<>();
		String way = "";

		for (Vertice element : graph.getVertice()) {
			List<String> inside = new ArrayList<>();
			graph.getEdges().stream().filter(edge -> edge.getStartpoint().getLabel().equals(element.getLabel()))
					.forEach(point -> {
						inside.add(point.toString().substring(2, 3));
					});
			Collections.sort(inside);
			for (String value : inside) {
				list.add(element.getLabel());
				list.add(value);
			}
		}

		for (String value : list)
			way += " " + value;

		if ((way.contains(destination) && way.contains(origin)) == true)
			way = "INVALID PATH";
		else
			way = "Start ->" + way + " -> End";

		return way;
	}

	@Override
	public String showPath(String origin, String destination, NonDirectedGraph graph) {
		List<String> list = new ArrayList<>();
		String way = "";

		for (Vertice element : graph.getVertice()) {
			List<String> inside = new ArrayList<>();
			graph.getEdges().stream().filter(edge -> edge.getStartpoint().getLabel().equals(element.getLabel()))
					.forEach(point -> {
						inside.add(point.toString().substring(2, 3));
					});
			Collections.sort(inside);
			for (String value : inside) {
				list.add(element.getLabel());
				list.add(value);
			}
		}

		for (String value : list)
			way += " " + value;

		if ((way.contains(destination) && way.contains(origin)) == false)
			way = "INVALID PATH";
		else
			way = "Start ->" + way + " -> End";

		return way;
	}

	@Override
	public String toString(Graph graph) {
		return graph.toString();
	}

}
