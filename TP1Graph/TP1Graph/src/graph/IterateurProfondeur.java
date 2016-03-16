package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Parcours en profondeur
 * 
 * @author GERLAND - LETOURNEUR
 */
public class IterateurProfondeur implements Iterator<Node> {
	
	/**
	 * Pile de noeuds en profondeur
	 */
	private LinkedList<Node> pileNoeud;
	/**
	 * Liste de noeuds marqués
	 */
	private ArrayList<Node> listeMarque;
	/**
	 * Graph
	 */
	private Graph graph;
	
	public IterateurProfondeur(Node premier, Graph graph) {
		
		this.graph = graph;
		pileNoeud = new LinkedList<Node>();
		listeMarque = new ArrayList<Node>();
		pileNoeud.add(premier);
	}

	@Override
	public boolean hasNext() {
		return this.pileNoeud.size()>0;
	}

	@Override
	public Node next() {
		
		//Variable qui permet de savoir si à partir d'un sommet,
		//on peut afficher un sommet adjacent. 
		//Sinon on doit afficher ce sommet
		boolean voisinExploitable = false;
		//Récupère le premier élement de la pile
		Node courant = pileNoeud.getFirst();
		//Temps que le noeud courant a des adjacents (récursif)
		while(graph.getAdjNodes(courant).size() > 0) {
			voisinExploitable = false;
			//Parcours de adjacent du sommet courant
			for(Node temp : graph.getAdjNodes(courant)) {
				//Si il y a en un qui n'est pas marqué, on remplace courant
				if(!listeMarque.contains(temp) && !pileNoeud.contains(temp)) {
					pileNoeud.addFirst(temp);
					courant = temp;
					voisinExploitable = true;
					break;
				}
			}
			//Si les sommet adjacent étaient déjà tous marqués,
			//on sort du while pour afficher le premier sommet de la pile
			if(!voisinExploitable ) {
				break;
			}
		}
		
		listeMarque.add(courant);
		pileNoeud.removeFirst();
		
		return courant;
	}
}
