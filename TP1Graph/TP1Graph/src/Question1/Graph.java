package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IDirectedGraph {

	List<Node> noeuds;
	List<Arc> arcs;
	
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
				if(!adjacents.contains(_n))
					adjacents.add(_n);
			}
			else if(arc.getDestination() == _n) {
				if(!adjacents.contains(_n))
					adjacents.add(_n);
			}
		}
	}

	@Override
	public boolean hasArc(Node _n1, Node _n2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addArc(Arc _edge) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Arc> getArc(Node _n) {
		// TODO Auto-generated method stub
		return null;
	}

}
