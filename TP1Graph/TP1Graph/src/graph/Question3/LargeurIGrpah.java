package graph.Question3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import graph.Node;
import graph.StringLabel;
import graph.Question1.Graph;

public class LargeurIGrpah {
	
	public static List<Node> parcoursLargeur(Graph graph) {
		
		List<Node> temp = new ArrayList<Node>();
		Iterator<Node> iterator = temp.iterator();
		
		List<Node> traiter = new ArrayList<Node>();
		
		Node depart = graph.getAllNodes().get(0);
		depart.setLabel(new StringLabel("true"));
		temp.add(depart);
		
		while (iterator.hasNext()) {
			Node currentSommet = (Node) iterator.next();
			for(int i = 0; i < graph.getAdjNodes(currentSommet).size(); i++) {
				if(!(graph.getAdjNodes(currentSommet).get(i).getLabel().toString() == "true")) {
					graph.getAdjNodes(currentSommet).get(i).setLabel(new StringLabel("true"));
					temp.add(graph.getAdjNodes(currentSommet).get(i));
				}
			}
			traiter.add(currentSommet);
			temp.remove(currentSommet);
		}
		return traiter;
	}
}
