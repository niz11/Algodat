import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

/**
 * A data structure to store a graph consisting of a set of unlabeled nodes and
 * a set of directed, weighted edges connecting the nodes.
 * 
 * The interface provides methods to add nodes and edges. Both methods can be
 * called at all time and the data structure should not assume a limitation on
 * the number of nodes or edges.
 * 
 * 
 * Furthermore, there are methods to access a single edge or to check whether
 * two nodes are connected as well as methods to access all nodes connected with
 * a specific node and thus all outgoing edges.
 * 
 * @author Joerg Schneider, modified by AlgoDat-Tutoren
 */
public class DiGraph implements Graph {

	public HashMap<Integer, Node> nodes;

	// needed for testing, where the execution of methods should not stop
	private boolean showSteps = true;

	public DiGraph() {
		nodes = new HashMap<Integer, Node>();
	}

	/**
	 * Adds an edge to the graph.
	 * 
	 * The edge is specified by a start node and a target node. If there is
	 * already an edge between these two nodes the behavior of the method is
	 * unspecified. The edge is labeled with a positive weight value.
	 * 
	 * @param startNode
	 *            the start node
	 * @param targetNode
	 *            the target node
	 * @param weight
	 *            a positive, non-zero value assigned to this edge
	 */
	@Override
	public void addEdge(Node startnode, Node endnode, double weight) {
		if (startnode != null && endnode != null) {
			
			// only add edges between nodes which are already part of this graph 
			if(nodes.values().contains(startnode) && nodes.values().contains(endnode)){
				startnode.addEdge(endnode, weight);
			}

		}
	}


	@Override
	public void addEdge(int startnode, int endnode, double weight) {
		addEdge(nodes.get(startnode), nodes.get(endnode), weight);
	}


	/**
	 * Adds a node to the graph.
	 * 
	 * As the nodes are unlabeled this method has no parameter. An identifier is
	 * returned which can be used to access this specific node when calling the
	 * other operations.
	 * 
	 * @return the added Node.
	 */
	@Override
	public Node addNode() {
		Node newOne = null;
		int newId = nodes.size();
		newOne = new Node(newId);
		nodes.put(newId, newOne);
		return newOne;
	}


	/**
	 * Returns the weight of the directed edge between the given nodes.
	 * 
	 * @param startNode
	 *            the the start node as provided by addNode()
	 * @param targetNode
	 *            the target node as provided by
	 *            addNode()
	 * @return WEIGHT_NO_EDGE, if there is no directed edge between the start
	 *         node and the target node or the positive, non-zero weight stored
	 *         by addEdge().
	 */
	@Override
	public double getWeight(Node startnode, Node endnode) {
		if (startnode != null && endnode != null) {
			if(nodes.values().contains(startnode) && nodes.values().contains(endnode)){
				return startnode.getWeight(endnode);
			}
		}
		return Graph.WEIGHT_NO_EDGE;
	}

	@Override
	public double getWeight(int startnode, int endnode) {
		return getWeight(nodes.get(startnode), nodes.get(endnode));
	}

	/**
	 * Returns all nodes of the graph.
	 * 
	 * @return list containing all valid node identifiers.
	 */
	@Override
	public List<Node> getNodes() {
		return new ArrayList<Node>(nodes.values());
	}
	
	public List<Edge> getEdges() {
		List<Edge> edges = new LinkedList<Edge>();
		
		for (Node node : nodes.values()) {
			List<Edge> incidentEdges = node.getIncidentEdges();
			edges.addAll(incidentEdges);
		}
		return edges;
	}

	/**
	 * For a node returns all nodes the outgoing edges of the node directly lead to.
	 * 
	 * @return list containing all directly connected nodes.
	 */
	@Override
	public List<Node> getAdjacentNodes(Node startnode) {
		List<Node> nodes = null;
		if (startnode != null && this.nodes.values().contains(startnode)) {
			return startnode.getAdjacentNodes();
		}
		nodes = new LinkedList<Node>();
	    return nodes;
	}

	@Override
	public List<Node> getAdjacentNodes(int startnode) {
		return getAdjacentNodes(nodes.get(startnode));
	}

	/**
	 * Determines if the given nodes are directly connected, that is whether
	 * there is some directed edge that links startNode to targetNode.
	 * For all existing nodes: isConnected(n1, n2) <=> getAdjacentNodes(n1).contains(n2)
	 * 
	 * @param startNode
	 *            the start node as provided by addNode()
	 * @param targetNode
	 *            the target node as provided by
	 *            addNode()
	 * @return true iff there is a directed edge between the given start node
	 *         and target node.
	 */
	@Override
	public boolean isConnected(Node startnode, Node endnode) {
		if (startnode != null && endnode != null) {
			if(nodes.values().contains(startnode) && nodes.values().contains(endnode)){
				return startnode.hasEdgeTo(endnode);
			}
		}
		return false;
	}

	
	@Override
	public boolean isConnected(int startNodeID, int endNodeID) {
		return isConnected(nodes.get(startNodeID), nodes.get(endNodeID));
	}

	/**
	 * resets all colors in visual representation of the graph to white
	 */
	@Override
	public void clearMarks() {
		for (Node nextNode : nodes.values()) {
			nextNode.status = Node.WHITE;
			for (Edge nextEdge : nextNode.getIncidentEdges()) {
				nextEdge.status = Edge.WHITE;
			}
		}
	}

	/**
	 * help function for reset the state of all nodes to white
	 */
	private void resetState() {
		for (Node n : nodes.values()) {
			n.status = Node.WHITE;
		}
	}
	
	
	/**
	 * travels randomly in the graph.
	 * used to demonstrate visualization class
	 * @param index of startnode
	 */
	@Override
	public void showGraph(Node startNode){
		
		resetState();
		if(startNode == null || !nodes.values().contains(startNode)){
			System.out.println("Error! this node does not exist!");
			return;
		}
		startNode.status = Node.GRAY;
		
		this.stopExecutionUntilSignal();
		startNode.status = Node.BLACK;
		
		List<Edge> edges = startNode.getIncidentEdges();
		Random ran = new Random();
		
		while(edges.size() != 0){
			List<Node> nodes = new ArrayList<Node>();
			//filter black neighbor node
			//white and gray neighbor nodes will add to nodes-list
			for(Edge e: edges){
				if(e.endnode.status != Node.BLACK){
					e.endnode.status = Node.GRAY;
					nodes.add(e.endnode);
				}
			}
			this.stopExecutionUntilSignal();
			if(nodes.size() == 0) return;
			
			startNode= nodes.get(ran.nextInt(nodes.size()));
			edges = startNode.getIncidentEdges();
			startNode.status = Node.BLACK;
		}
	}
	
	public void showGraph(int nodeID) {
		showGraph(nodes.get(nodeID));
	}
	
	
	/**
	 * Traverses the Graph using breadth-first search
	 * @param startNode the node to start the search with
	 * @return a list containing the reachable nodes, ordered as visited during the search
	 */
	@Override
	public List<Node> breadthFirstSearch(Node startNode){
		LinkedList<Node> nodeList = null;
		resetState();
		if (nodes.containsValue(startNode)){
		//Getiing the list with all the edges going out from my Node
		List<Node> WhiteNode =getAdjacentNodes(startNode);
		// Make sure the firt node has a least one indektion
		// My Queue -
		//System.out.println(WhiteNode);
		Queue<Node> myQueue = new LinkedList<Node>();
		if(WhiteNode.isEmpty()) return nodeList;
		// Adds the first Node to the Answer
		nodeList = new LinkedList<Node>();
		nodeList.add(startNode);
		// A loop that saves all the white seccessors in a Queue , change their color to gray and add them to the final answer
		int i=0;
		while (i< WhiteNode.size()){
			Node a = (WhiteNode.get(i));
			a.status = a.GRAY;
			myQueue.add(a);	
			nodeList.add(a);
			i++;
		}
		// First node is now turning Black = Done with him
		startNode.status = startNode.BLACK;
		// Now the While loop that will run untill the End of the Breadth-first Search
		while (!myQueue.isEmpty()){
			Node b = myQueue.poll();
			List<Node> WhiteNode2 = getAdjacentNodes(b);
			int k=0;
			while (k < WhiteNode2.size()){
				Node a = (WhiteNode2.get(k));
				if(WhiteNode2.get(k).status==0){
				a.status = a.GRAY;
				myQueue.add(a);	
				nodeList.add(a);
				k++;}
				else
					k++;
			}
			b.status = b.BLACK;
		}
		return nodeList;
		}else{
			return nodeList;
		}
	}
	
	@Override
	public List<Node> breadthFirstSearch(int nodeID) {
		return breadthFirstSearch(nodes.get(nodeID));
	}
	
	
	/**
	 * Traverses the Graph using depth-first search
	 * @param startNode the node to start the search with
	 * @return a list containing the reachable nodes, ordered as visited during the search
	 */
	@Override
	public List<Node> depthFirstSearch(Node startNode){
		LinkedList<Node> nodeList = null;
		resetState();
		if (nodes.containsValue(startNode)){
			//Getiing the list with all the edges going out from my Node
			LinkedList<Node> WhiteNode = startNode.getWhiteSuccessors();
			Stack<Node> myStack = new Stack();

									// Make sure the firt node has a least one indektion
			if(WhiteNode.isEmpty()) return nodeList;
				// Push my first node to the Stack
			myStack.push(startNode);
				//Add first Node to the Result
			nodeList = new LinkedList<Node>();
			nodeList.addFirst(startNode);
				//And change him to Gray
			startNode.status = 1;

			Node nextNode =WhiteNode.pollFirst();	
			nodeList.add(nextNode);
			myStack.push(nextNode);
			nextNode.status= 1;
					// A loop that sould go all over the Graph , and when it finished the Search is also finished
			while (!myStack.isEmpty()){
				LinkedList<Node> nextWhiteNode = nextNode.getWhiteSuccessors();
				if (!nextWhiteNode.isEmpty()){
					nextNode =nextWhiteNode.pollFirst();
					nextNode.status = 1;
					myStack.push(nextNode);
					nodeList.add(nextNode);
				}
				else{
					myStack.pop();
					if (!myStack.isEmpty())
						nextNode = myStack.firstElement();
				}



}	

return nodeList;}
else
return nodeList;
}
	
	@Override
	public List<Node> depthFirstSearch(int nodeID) {
		return depthFirstSearch(nodes.get(nodeID));
	}
	

	// checks whether the given node has a white neighbor or not
	private boolean hasWhiteNeighbor(Node node) {

		for (Node neighbour : node.getAdjacentNodes()) {
			if (neighbour.status == Node.WHITE) {
				return true;
			}
		}
		return false;
	}

	// checks whether the given node has a gray neighbor or not
	private boolean hasGrayNeighbor(Node node) {

		for (Node neighbour : node.getAdjacentNodes()) {

			if (neighbour.status == Node.GRAY) {
				return true;
			}
		}

		return false;
	}

	// Disjkstra algorithm
	// ----------------------------------------------------------------------------------------------------

	// entry point for our test cases. don't change this function.
	@Override
	public void populateDijkstraFrom(int startNodeID) {
		populateDijkstraFrom(nodes.get(startNodeID));
	}

	@Override
	public void populateDijkstraFrom(Node startNode) {

		this.resetState();
		 startNode.distance=0.0;
		 PriorityQueue<Node> distanceQueue = new PriorityQueue<Node>();
		 if (nodes.containsValue(startNode)){
			 List<Node> WhiteNode = getAdjacentNodes(startNode);	// Get all the white Neighbors from startknote
			// System.out.println(WhiteNode);
			 int i=0;
			 while (i < WhiteNode.size()){
				 Node a = (WhiteNode.get(i));
				 if (a==null) break;
				 double distance = startNode.getWeight(a);
				 a.distance = distance;
				 a.predecessor = startNode;
				 distanceQueue.add(a);
				 i++;
				 //System.out.println(a.distance);
			 }
			 startNode.status = 2;
			 while (distanceQueue !=null){
				 Node b =distanceQueue.poll();
				 if (b==null) break;
				 List<Node> WhiteNodeb = getAdjacentNodes(b);
				 int k =0;
				 while (k < WhiteNodeb.size()){
					 Node checkNewDistance = WhiteNodeb.get(k);
					 if ((checkNewDistance == null)|| (b==null)) break;
					 if (checkNewDistance.distance==null){
						 checkNewDistance.distance = b.distance + getWeight(b,checkNewDistance);
						 distanceQueue.add(checkNewDistance); 
						 checkNewDistance.predecessor = b;
						 //System.out.println(checkNewDistance.distance);
					 }
					 else
					 	if (((b.distance + b.getWeight(checkNewDistance)) < (checkNewDistance.distance)) && (checkNewDistance.status != 2) ){
						 checkNewDistance.distance = b.distance + getWeight(b,checkNewDistance);
						 distanceQueue.add(checkNewDistance);
						 checkNewDistance.predecessor = b;
						// System.out.println(checkNewDistance.distance);
					 }
					 k++;
					 b.status = 2;
				 }
			 }
			 
			 
		 }
		 startNode.distance=0.0;
		 
		 
		 
		// clean up
		this.clearMarks();

	}


	@Override
	public List<Node> getShortestPathDijkstra(int startNodeID, int targetNodeID) {
		return getShortestPathDijkstra(nodes.get(startNodeID), nodes.get(targetNodeID));
	}

	/**
	 * Calculates a List of Node indices that describe the shortet path from
	 * start node to target node. The Dijkstra-Algorithmn is used for
	 * calculation.
	 * 
	 * @param targetNodeIndex
	 *            the index of the target node, as returned by addNode()
	 * @return the list of nodes, or null if no path exists
	 */
	@Override
	public List<Node> getShortestPathDijkstra(Node startNode, Node targetNode) {
		// TODO: Your implementation here
		// NOTE: you have to run populateDijkstraFrom first before you can read
		// out the shortest path
		populateDijkstraFrom(startNode);
		LinkedList<Node> l = new LinkedList<Node>();
		LinkedList<Node> l2 = new LinkedList<Node>();
		 if (nodes.containsValue(startNode) && nodes.containsValue(targetNode)){
			 Node a = targetNode;
			 while (a != startNode){
				 l2.add(a);
				 Node b =a.predecessor;
				 a = b;
			 }
			 l2.addLast(a);
			 for(int i = l2.size() -1 ; i > -1 ; i--){
				 l.add(l2.get(i));
			 }
		 }
	
		
		stopExecutionUntilSignal();

		
		return l;
	}



	// Bellman-Ford algorithm
	// ----------------------------------------------------------------------------------------------------

	// entry point for our test cases. Do not change this function.
	@Override
	public void populateBellmanFordFrom(int startNodeID) {
		populateBellmanFordFrom(nodes.get(startNodeID));
	}

	public void populateBellmanFordFrom(Node startNode) {

		this.resetState();
		startNode.distance = 0.0;
		List<Edge> edges = new LinkedList<Edge>();
		 List<Node> WhiteNode = getAdjacentNodes(startNode);	// First step - Value the firsts Nodes
			// System.out.println(WhiteNode);
		 int j=0;
			 while (j < WhiteNode.size()){
				 Node a = (WhiteNode.get(j));
				 if (a==null) break;
				 if (a != startNode){
				 double distance = startNode.getWeight(a);
				 a.distance = distance;
				 a.predecessor = startNode;
				 j++;
			 }}
			 
			 List<Node> alltheNode = breadthFirstSearch(startNode);
			 for (int x =0; x<alltheNode.size() ; x++){
				 boolean somethingHasChanged = false; // If nothing changed meening the Algorithmus ist over , and there is no reason to keep checking
			 for (int i=0; i<alltheNode.size() ; i++){ // n-1 * v Runtimes
				 edges = alltheNode.get(i).getIncidentEdges();
				 for (int k=0; k < edges.size(); k++){
					 if (alltheNode.get(i).distance ==null)
						 k++;
					 else
					 if ((edges.get(k).endnode.distance == null)){
						 edges.get(k).endnode.distance = alltheNode.get(i).distance + edges.get(k).weight ;
						 edges.get(k).endnode.predecessor = alltheNode.get(i);
						 somethingHasChanged = true;
					 }
					 else if ((edges.get(k).endnode.distance > alltheNode.get(i).distance + edges.get(k).weight) && (edges.get(k).endnode !=alltheNode.get(i) ) ) {
						 edges.get(k).endnode.distance = alltheNode.get(i).distance + edges.get(k).weight ;
						 edges.get(k).endnode.predecessor = alltheNode.get(i);	 
						 somethingHasChanged = true;
					 }
						 
					 
					 
				 }
			 }
			 if (somethingHasChanged == false) break;
			 }
			 // Checking a negatic circle
			 for (int i=0; i<alltheNode.size() ; i++){ // n-1 Runtimes
				 edges = alltheNode.get(i).getIncidentEdges();
				 for (int k=0; k < edges.size(); k++){
					 if ((edges.get(k).endnode.distance > alltheNode.get(i).distance + edges.get(k).weight) && (edges.get(k).endnode != alltheNode.get(i) ) ) {
						 System.out.println("There is a Negativ cicle in the Graph");
					 }
						 
					 
					 
				 }
			 }
			 startNode.distance = 0.0;
		
		
	//	for(int i=0 ; i < alltheNode.size() ; i++)
		//	System.out.println(alltheNode.get(i).distance + " the Node -" + (alltheNode.get(i).id) );
		this.clearMarks();

	}

	@Override
	public List<Node> getShortestPathBellmanFord(int startNodeID, int targetNodeID) {
		return getShortestPathBellmanFord(nodes.get(startNodeID), nodes.get(targetNodeID));
	}

	/**
	 * Calculates a List of Node indices that describe the shortet path from
	 * start node to target node. The Bellman-Ford-Algorithmn is used for
	 * calculation.
	 * 
	 * @param targetNodeIndex
	 *            the index of the target node, as returned by addNode()
	 * @return the list of nodes, or null if no path exists
	 */
	@Override
	public List<Node> getShortestPathBellmanFord(Node startNode, Node targetNode) {
		// TODO: Your implementation here
		// NOTE: you have to run populateBellmanFordFrom first before you can read
		// out the shortest path
		populateBellmanFordFrom(startNode);
		LinkedList<Node> l = new LinkedList<Node>();
		LinkedList<Node> l2 = new LinkedList<Node>();
		 if (nodes.containsValue(startNode) && nodes.containsValue(targetNode)){
			 Node a = targetNode;
			 while (a != startNode){
				 l2.add(a);
				 Node b =a.predecessor;
				 a = b;
			 }
			 l2.addLast(a);
			 for(int i = l2.size() -1 ; i > -1 ; i--){
				 l.add(l2.get(i));
			 }
		 }
	
		
		stopExecutionUntilSignal();

		
		return l;
	}


	// ---- Methods to visualize the operations of a graph algorithm -----

	/**
	 * Returns an index, representing the color of the given node.
	 * 0:black, 1:blue, 2:red, 3:green, 4:orange, 5:gray
	 * You may want to paint nodes that don't exist in gray.
	 * 
	 * @param nodeNumber the node for which the color
	 * 		is requested, as returned by addNode()
	 * 
	 * @return an index between 0 and 5, representing the color of the given node
	 */
	@Override
	public int getColorOfNode(Node node) {
		if (null == node) {
			return 5;
		} else {
			return node.status;
		}
	}
	
	@Override
	public int getColorOfNode(int nodeID){
		return getColorOfNode(nodes.get(nodeID));
	}

	/**
	 * Returns an index, representing the color of the given edge.
	 * 0:black, 1:blue, 2:red, 3:green, 4:orange, 5:gray
	 * You may want to paint edges that don't exist in gray.
	 * 
	 * @param sourceNodeNumber the index of the node where the edge starts
	 * 	, as returned by addNode()
	 * @param targetNodeNumber the index of the node where the edge ends
	 * 	, as returned by addNode()
	 * 
	 * @return an index between 0 and 5, representing the color of the given edge
	 */
	@Override
	public int getColorOfEdge(Node startNode, Node targetNode) {
		if (null == startNode || null == targetNode) {
			return 5;
		}
		LinkedList<Edge> incidentEdges = nodes.get(startNode.id)
				.getIncidentEdges();
		// search edge
		Edge searchedEdge = null;
		for (Edge nextEdge : incidentEdges) {
			if (nextEdge.endnode.id == targetNode.id) {
				searchedEdge = nextEdge;
			}
		}
		if (null == searchedEdge) {
			return 5;
		} else {
			return searchedEdge.status;
		}
	}

	// ---- Methods to stop and resume the execution of a graph algorithm -----

	// synchronization variable used to stop and resume processing
	private boolean isStopped = false;

	/**
	 * Tests if the current execution of a graph-algorithm was stopped
	 * @return true if the processing is stopped, false otherwise. 
	 */
	@Override
	synchronized public boolean isStopped() {
		return this.isStopped;
	}

	/**
	 * Stops or resumes the current executed graph algorithm
	 * @param status true to stop, false to resume execution
	 */
	@Override
	synchronized public void setStopped(boolean status) {
		this.isStopped = status;
	}

	/**
	 * Stops the execution of an algorithm until the visualization signals that
	 * he can be resumed. This feature can be used to visualize the steps of the
	 * algorithms.
	 */
	private void stopExecutionUntilSignal() {
		if (showSteps) {
			System.out.print(".");
			this.setStopped(true);
			while (this.isStopped()) {
				this.sleep(100);
			}
		}
	}

	/**
	 * Stops the execution for a given time
	 * 
	 * @param milliseconds
	 *            time the execution will stop in milliseconds
	 */
	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// the VM doesn't want us to sleep anymore,
			// so get back to work
		}
	}

	/**
	 * Sets the showSteps flag.
	 * @param show the flag
	 */
	@Override
	public void setShowSteps(boolean show) {
		this.showSteps = show;
	}
}

