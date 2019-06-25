import java.io.FileInputStream;
import java.util.*;

/**
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *  Each contestant walks at a given estimated speed.
 *  The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 * This class implements the competition using Dijkstra's algorithm
 */

class CompetitionDijkstra {
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,sB,sC: speeds for 3 contestants
     */
	   int sA;
	   int sB; 
	   int sC;
	   int slowestPerson; //Use this speed to get longest time 
	   private TreeMap<Integer, Node> network; //Data Structure for the network of the city
	   String filename;
	   
    CompetitionDijkstra(String filename, int sA, int sB, int sC) {
        this.filename = filename;
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
        this.createCityNetwork();
    }

    private void createCityNetwork() {

    	slowestPerson = Math.min(sA, sB);
    	slowestPerson = Math.min(slowestPerson, sC);
        if (filename == null) slowestPerson = -1;
        network = new TreeMap<>(); // Data Structure

        //File handling using Scanner, using input from file to create Data Structure 
        try {
            Scanner scanner = new Scanner(new FileInputStream(filename));
            int N = scanner.nextInt();
            int S = scanner.nextInt();
            for (int i = 0; i < S; i++) { //looping through file 
                if (scanner.hasNext()) {
                    int from = scanner.nextInt();
                    int to = scanner.nextInt();
                    double streetsDistance = scanner.nextDouble() * 1000;
                    Node toNode, fromNode;
                    if (network.get(from) == null) {
                    	toNode = new Node(from);
                        network.put(from, toNode);
                    } else toNode = network.get(from);
                    if (network.get(to) == null) {
                    	fromNode = new Node(to);
                        network.put(to, fromNode);
                    } else fromNode = network.get(to);
                    	toNode.addAdjacent(fromNode, streetsDistance);
                } else {
                    break;
                }
            }
        } catch (Exception error) {
        	slowestPerson = -1;
        }
    }
    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition() {
    	int finalTime = 0; 
        if(50 > sA || 50  > sB || 50 > sC || 100 <sA || 100 < sB || 100 <sC) return -1;    
        if (slowestPerson <= 0 || network.size() == 0  ) return -1;
        double maxDist = -1;
        for (Node node : network.values()) {
            double distance = getShorestDistance(node.intersectionNumber);
            if (distance == Double.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, distance);
        }
        finalTime = (int) Math.ceil(maxDist / slowestPerson);
        return finalTime;
    }
    private double getShorestDistance(int start) {

        LinkedList<Node> intersections = new LinkedList<>();
        for (Node intersection : network.values()) {
            if (intersection.intersectionNumber == start) intersection.distance = 0;
            else intersection.distance = Double.MAX_VALUE;
            intersections.add(intersection);
        }

        for (int i = 0; i < network.values().size(); i++) {
            for (Node intersection : intersections) {
                for (Street street : intersection.route) {
                    double newDistance = intersection.distance + street.distance;
                    if (newDistance < street.to.distance) {
                        street.to.distance = newDistance;
                    }
                }
            }
        }
        double maxDistance = Double.MIN_VALUE;
        for (Node intersection : network.values()) {
            if (intersection.distance == Double.MAX_VALUE) return intersection.distance;
            else if (intersection.distance > maxDistance)
            	maxDistance = intersection.distance;
        }
        return maxDistance;
    }
    private class Street {
        Node to;
        double distance;

        Street(Node to, double distance) {
            this.to = to;
            this.distance = distance;
        }
    }
    private class Node {
        int intersectionNumber;
        double distance = Double.MAX_VALUE; //tentative cost
        ArrayList<Street> route = new ArrayList<>();

        Node(int id) {
            this.intersectionNumber = id;
        }

        void addAdjacent(Node intersection, double distance) {
            route.add(new Street(intersection, distance));
        }
    }


}