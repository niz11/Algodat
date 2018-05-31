import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Arne
 * 
 */
public class ResidualGraph extends DiGraph {

	// -- constructor --
	public ResidualGraph() {
	}
	
	/**
	 * Finds an augmenting path from start to end in the graph A path is
	 * augmenting if all it's edges have residual capacity > 0 (You can choose
	 * from several algorithms to find a path)
	 * 
	 * @param startNodeId
	 *            the id of the start node from where we should start the search
	 * @param endNodeId
	 *            the id of the end node which we want to reach
	 * 
	 * @return the path from start to end or an empty list if there is none
	 */
	public LinkedList<Node> findAugmentingPath(int startNodeId, int endNodeId) {
			//if ((!nodes.containsValue(startNodeId))|| (!nodes.containsValue(endNodeId)))
				//throw new Exception();
			LinkedList<Node> Answer = new LinkedList<Node>();
			LinkedList<Node> BackToEndAnswer = new LinkedList<Node>();
			LinkedList<Node> finalAnswer = new LinkedList<Node>();
			Node startNode = nodes.get(startNodeId);
			Node endNode = nodes.get(endNodeId);
			LinkedList <Edge> checkWeight= startNode.getOutgoingEdges();
			int index2 = 0;
			if (checkWeight != null)
			for (int m= 0 ;m< checkWeight.size(); m++){
				if (checkWeight.get(m).weight == 0){
				index2 = index2 +1;	
				}
			}
			if (index2==checkWeight.size()) return finalAnswer;
			Answer = breadthFirstSearch(startNode);
			if (!Answer.contains(endNode)) return finalAnswer;
			int index =0;
			for (int i= 0 ; i < Answer.size() ; i++)
				if (Answer.get(i)== endNode){
					index=i;
					break;}
			Node placeHolder = Answer.get(index);
			while (placeHolder != startNode){
				BackToEndAnswer.add(placeHolder);
				placeHolder = placeHolder.predecessor;
			}
			BackToEndAnswer.add(placeHolder);
			for (int k= BackToEndAnswer.size()-1 ; k>-1 ; k-- )
				finalAnswer.add(BackToEndAnswer.get(k));
			return finalAnswer;
		}

	/**
	 * Finds the minimal residual capacity over the given path
	 * 
	 * @return the minimal capacity
	 */
	public double findMinCapacity(LinkedList<Node> path) {
			double min = -1;
			for(int i=0; i<path.size()-1; i++){
				Node a = path.get(i+1);
				Edge check = path.get(i).getEdgeTo(a);
				if (min==-1)
					min = check.weight;
				else
					if (check.weight < min)
						min = check.weight;		
			}
			if (min == -1) return 0;	
			return min;
		}

	/**
	 * Update capacity on given path, to be executed on residual graph
	 */
	public void updateResidualCapacity(double minCapacity, LinkedList<Node> path) {
			for(int i=0; i<path.size()-1; i++){
				Node startNode = path.get(i);
				Node EndNode = path.get(i+1);
				Edge UpdatedGoingEdge = path.get(i).getEdgeTo(EndNode);
				Edge UpdatedBackEdge = path.get(i+1).getEdgeTo(startNode);
				UpdatedGoingEdge.weight =UpdatedGoingEdge.weight-minCapacity;
				UpdatedBackEdge.weight =UpdatedBackEdge.weight +minCapacity;
			}

	}
	/**
	 * Traverses the Graph using breadth-first search
	 * @param startNode the node to start the search with
	 * @return a list containing the reachable nodes, ordered as visited during the search
*/
	@Override
	public LinkedList<Node> breadthFirstSearch(Node startNode ){
		LinkedList<Node> nodeList = null;
		resetState();
		if (nodes.containsValue(startNode)){
		//Getiing the list with all the edges going out from my Node
		ArrayList<Node> WhiteNode =(ArrayList<Node>) getAdjacentNodes(startNode);
		// Make sure the firt node has a least one indektion
		// My Queue -
		//System.out.println(WhiteNode);
		Queue<Node> myQueue = new LinkedList<Node>();
		if(WhiteNode.isEmpty()) return nodeList;
		// Adds the first Node to the Answer
		nodeList = new LinkedList<Node>();
		nodeList.add(startNode);
		startNode.predecessor = startNode;
		// A loop that saves all the white seccessors in a Queue , change their color to gray and add them to the final answer
		int i=0;
		while (i< WhiteNode.size()){
			if (startNode.getEdgeTo((WhiteNode.get(i))).weight > 0.0){
			Node a = (WhiteNode.get(i));
			a.status = 1;
			myQueue.add(a);	
			nodeList.add(a);
			a.predecessor = startNode;
			i++;
		}
			else
				i++;}
		// First node is now turning Black = Done with him
		startNode.status = 2;
		// Now the While loop that will run untill the End of the Breadth-first Search
		while (!myQueue.isEmpty()){
			Node b = myQueue.poll();
			ArrayList<Node> WhiteNode2 = (ArrayList<Node>) getAdjacentNodes(b);
			int k=0;
			while (k < WhiteNode2.size()){
				Node a = (WhiteNode2.get(k));
				if((WhiteNode2.get(k).status==0)&& (b.getEdgeTo(a).weight > 0.0)){
				a.status = 1;
				myQueue.add(a);	
				nodeList.add(a);
				a.predecessor = b;
				k++;}
				else
					k++;
			}
			b.status = 2;
		}
		
		return nodeList;
		}
		
		
		else{
			return nodeList;
		}
	}


}

