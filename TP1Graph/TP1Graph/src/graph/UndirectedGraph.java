package graph;

import java.util.Iterator;
import java.util.List;

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

	@Override
	public Iterator<Node> creerBFSIterator(Node n) {
		return graph.creerBFSIterator(n);
	}

	@Override
	public Iterator<Node> creerDFSIterator(Node n) {
		return graph.creerDFSIterator(n);
	}

}
