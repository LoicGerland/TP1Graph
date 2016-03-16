package graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Parcours en largeur
 * 
 * @author GERLAND - LETOURNEUR
 */
public class IterateurLargeur implements Iterator<Node> {
	
	/**
	 * Liste de noeuds
	 */
	private ArrayList<Node> listeNoeud;
	/**
	 * Liste de noeuds marqués
	 */
	private ArrayList<Node> listeMarque;
	/**
	 * Graph
	 */
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
		
		//Parcours de tous les noeuds 
		//pour en trouver un non marqué
		Node temp = null;
		for(Node noeud : listeNoeud) {
			if(!listeMarque.contains(noeud)) {
				temp = noeud;
				break;
			}
		}
		
		//Parcours des voisins pour les ajouter à la liste
		ArrayList<Node> voisins = (ArrayList<Node>) graph.getAdjNodes(temp);
		for(Node voisin : voisins) {
			if(!listeNoeud.contains(voisin))
				listeNoeud.add(voisin);
		}
		
		listeMarque.add(temp);
		
		return temp;
	}
}
