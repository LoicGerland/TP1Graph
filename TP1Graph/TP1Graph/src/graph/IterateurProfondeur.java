package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class IterateurProfondeur implements Iterator<Node> {
	
	private ArrayList<Node> listeNoeud;
	private ArrayList<Node> listeMarque;
	private Graph graph;
	
	public IterateurProfondeur(Node premier, Graph graph) {
		
		this.graph = graph;
		listeNoeud = new ArrayList<Node>();
		listeMarque = new ArrayList<Node>();
		listeNoeud.add(premier);
	}

	@Override
	public boolean hasNext() {
		return this.listeNoeud.size()>0;
	}

	@Override
	public Node next() {
		
		boolean voisinExploitable = false;
		Node courant = listeNoeud.get(listeNoeud.size()-1);
		
		while(graph.getAdjNodes(courant).size() > 0) {
			voisinExploitable = false;
			for(Node temp : graph.getAdjNodes(courant)) {
				
				if(!listeMarque.contains(temp) && !listeNoeud.contains(temp)) {
					listeNoeud.add(temp);
					courant = temp;
					voisinExploitable = true;
					break;
				}
			}
			if(!voisinExploitable ) {
				break;
			}
		}
		
		listeMarque.add(courant);
		listeNoeud.remove(listeNoeud.size()-1);
		
		return courant;
	}
}
