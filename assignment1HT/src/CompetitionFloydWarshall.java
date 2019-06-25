
import java.io.BufferedReader;
import java.io.FileReader;
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
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */


public class CompetitionFloydWarshall {

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */

   public static final double INFINITY = Integer.MAX_VALUE / 2;   // to prevent overflow if you do INFINITY + INFINITY

    int sA;
    int sB;
    int sC;
    private int N;	 //Intersections
    private int S;    //Streets
    int slowestPerson; //Use this speed to get longest time 
    String filename;
    boolean correctProperties = true;
    double networkGrid[][];    // 2D Array Data Structure 
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
        this.filename = filename;
        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
        this.createCityNetwork();
    }

    private void createCityNetwork(){
    	slowestPerson = Math.min(sA, sB);
    	slowestPerson = Math.min(slowestPerson, sC);
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename)); //Using Buffer this time 
            N = Integer.parseInt(br.readLine());
            S = Integer.parseInt(br.readLine());
            if(N == 0 || S == 0 ) correctProperties = false;
            if(filename == null){
            	correctProperties = false;
                slowestPerson = -1;
            }
            else{
                networkGrid = new double[N][S];
                for (int i = 0; i < N; i++){
                    for (int j = 0; j < N; j++){
                    	networkGrid[i][j] = INFINITY;
                    }
                }
                String currentLine = br.readLine();
                while((currentLine != null)){
                    String[] lSplit = currentLine.trim().split(" ");
                    networkGrid[Integer.parseInt(lSplit[0])][Integer.parseInt(lSplit[1])] = Double.parseDouble(lSplit[2]);
                    currentLine = br.readLine();
                }
                br.close();
            }
        }catch (Exception e){
            correctProperties = false;
            slowestPerson = -1;
        }
    }

    private double getMax(){
        double maxDistance = -1;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(networkGrid[i][j] > maxDistance && i != j){
                    maxDistance = networkGrid[i][j];
                }
            }
        }
        return maxDistance;
    }
    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
        int finalTime = 0; 
    	if((50 > sA || 50  > sB || 50 > sC || 100 <sA || 100 < sB || 100 <sC))  return -1;
        if(!correctProperties) return -1;
        for (int k = 0; k < N; k++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(networkGrid[i][k] + networkGrid[k][j] < networkGrid[i][j]){
                    	networkGrid[i][j] = networkGrid[i][k] + networkGrid[k][j];
                    }
                }
            }
        }
        double maxDistance = getMax();
        if(maxDistance == INFINITY){
            return -1;
        }
        maxDistance = (maxDistance * 1000);  
        finalTime =(int) Math.ceil(maxDistance / slowestPerson);
        return finalTime;
    }
}