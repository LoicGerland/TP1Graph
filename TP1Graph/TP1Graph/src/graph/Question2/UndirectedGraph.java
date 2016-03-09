package graph.Question2;

import java.util.List;

import graph.Arc;
import graph.IUndirectedGraph;
import graph.Node;
import graph.Question1.Graph;

public class UndirectedGraph implements IUndirectedGraph {

	Graph graph;
	
	public UndirectedGraph() {
		graph = new Graph();
	}
	
	@Override
	public void addNode(Node _node) {
		graph.addNode(_node);
	}

	@Override
	public List<Node> getAllNodes() {
		return graph.getAllNodes();
	}

	@Override
	public int getNbNodes() {
		return graph.getNbNodes();
	}
	
	@Override
	public List<Node> getAdjNodes(Node _n) {

		return graph.getAdjNodes(_n);
	}

	@Override
	public void addEdge(Node _node1, Node _node2) {

		this.graph.getArcs().add(new Arc(_node1, _node2, null));
		this.graph.getArcs().add(new Arc(_node2, _node1, null));
	}

	@Override
	public boolean hasEdge(Node _node1, Node _node2) {
		
		return graph.hasArc(_node1, _node2);
	}

}
