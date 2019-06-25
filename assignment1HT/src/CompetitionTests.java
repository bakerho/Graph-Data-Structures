import org.junit.Test;

import static org.junit.Assert.assertEquals;
   
    public class CompetitionTests {
        @Test
        public void testCompetitionDijkstra() {
            
            int finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\1000EWD.txt", 50, 50, 50).timeRequiredforCompetition();
            assertEquals("Testing Dijkstra with slowest speed's and 1000 input ", finalTime, 28);

            finalTime = new CompetitionDijkstra(null, 56, 78, 57).timeRequiredforCompetition();
            assertEquals("No file results in -1", finalTime, -1);
            
            finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\1000EWD.txt", 75, 56, 87).timeRequiredforCompetition();
            assertEquals("Testing Dijkstra with random speed's and 1000 input", finalTime, 25);
            
            finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\tinyEWD.txt",60, 75, 81).timeRequiredforCompetition();
            assertEquals("Testing Dijkstra with smaller input and random speeds", finalTime, 31);

            finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\testIn.txt", 75, 56, 87).timeRequiredforCompetition();
            assertEquals("Custom input with no path returns -1", finalTime, -1);

        }
        @Test 
        //Test for CompetitionFloydWarshall
        public void testCompetitionFloydWarshall() {
            
        	int finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\1000EWD.txt", 50, 50, 50).timeRequiredforCompetition();
            assertEquals("Testing Floyd Warshall with slowest speed's and 1000 input ", finalTime, 28);
        	
            finalTime = new CompetitionFloydWarshall(null, 56, 78, 57).timeRequiredforCompetition();
            assertEquals("No file results in -1", finalTime, -1);
            
            finalTime = new CompetitionFloydWarshall("C:\\Users\\holly\\Documents\\tinyEWD.txt", 50,80,60).timeRequiredforCompetition();
            assertEquals("Testing Floyd Warshall with random speed's and 1000 input", finalTime,25);

            finalTime = new CompetitionFloydWarshall("C:\\Users\\holly\\Documents\\tinyEWD.txt", 60, 75, 81).timeRequiredforCompetition();
            assertEquals("Testing Floyd Warshall with smaller input and random speeds", finalTime, 31);

            finalTime = new CompetitionFloydWarshall("C:\\Users\\holly\\Documents\\testingFile.txt", 75, 56, 87).timeRequiredforCompetition();
            assertEquals("Custom input with no path returns -1", finalTime, -1);
        }
    }

