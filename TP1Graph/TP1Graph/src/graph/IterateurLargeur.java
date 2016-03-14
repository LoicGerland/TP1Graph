package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class IterateurLargeur implements Iterator<Node> {
	
	private ArrayList<Node> listeNoeud;
	private ArrayList<Node> listeMarque;
	private Graph graph;
	
	public IterateurLargeur(Node premier, Graph graph) {
		
		this.graph = graph;
		listeNoeud = new ArrayList<Node>();
		listeMarque = new ArrayList<Node>();
		listeNoeud.add(premier);
	}

	@Override
	public boolean hasNext() {
		return listeNoeud.size()>listeMarque.size();
	}

	@Override
	public Node next() {
		
		Node temp = null;
		for(Node noeud : listeNoeud) {
			if(!listeMarque.contains(noeud)) {
				temp = noeud;
				break;
			}
		}
		
		ArrayList<Node> voisins = (ArrayList<Node>) graph.getAdjNodes(temp);
		
		for(Node voisin : voisins) {
			if(!listeNoeud.contains(voisin))
				listeNoeud.add(voisin);
		}
		
		listeMarque.add(temp);
		
		return temp;
	}
}
