package graph.Question1;

import java.util.ArrayList;
import java.util.List;

import graph.Arc;
import graph.IDirectedGraph;
import graph.Node;

public class Graph implements IDirectedGraph {

	protected List<Node> noeuds;
	protected List<Arc> arcs;
	
	public Graph() {
		this.noeuds = new ArrayList<Node>();
		this.arcs = new ArrayList<Arc>();
	}
	
	@Override
	public void addNode(Node _node) {
		this.noeuds.add(_node);
	}

	@Override
	public List<Node> getAllNodes() {
		return noeuds;
	}

	@Override
	public int getNbNodes() {
		return this.noeuds.size();
	}

	@Override
	public List<Node> getAdjNodes(Node _n) {
		List<Node> adjacents = new ArrayList<Node>();
		
		for(Arc arc: this.arcs){
			if(arc.getSource() == _n){
				adjacents.add(arc.getDestination());
			}
		}
		
		return adjacents;
	}

	@Override
	public boolean hasArc(Node _n1, Node _n2) {
		if(this.getAdjNodes(_n1).contains(_n2))
			return true;
		return false;
	}

	@Override
	public void addArc(Arc _edge) {
		this.arcs.add(_edge);
	}

	@Override
	public List<Arc> getArc(Node _n) {
		List<Arc> arcs = new ArrayList<Arc>();
		
		for(Arc arc : this.arcs){
			if(arc.getSource() == _n){
				arcs.add(arc);
			}
		}
		
		return arcs;
	}
	
	public List<Node> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(List<Node> noeuds) {
		this.noeuds = noeuds;
	}

	public List<Arc> getArcs() {
		return arcs;
	}

	public void setArcs(List<Arc> arcs) {
		this.arcs = arcs;
	}

}
