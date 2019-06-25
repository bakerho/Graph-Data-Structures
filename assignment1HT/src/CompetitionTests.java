import org.junit.Test;

import static org.junit.Assert.assertEquals;


/*public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
        CompetitionDijkstra networkCityD = new CompetitionDijkstra("tinyEWD.txt", 50, 80, 60);
        assertEquals("constructor failed with valid input", networkCityD.slowestPerson, 50);
    }

    @Test
    public void testDijkstra() {
        CompetitionDijkstra networkCityD = new CompetitionDijkstra("tinyEWD.txt", 50,80,60);
        assertEquals("Test competition with TINYEWD", 38, networkCityD.timeRequiredforCompetition());

        CompetitionDijkstra networkCityD1 = new CompetitionDijkstra("TINYsdfgdfgEWD.txt", 50, 80, 60);
        assertEquals("Test competition with invalid filename", -1, networkCityD1.timeRequiredforCompetition());

        CompetitionDijkstra networkCityD2 = new CompetitionDijkstra("tinyEWD.txt", -1, 80, 60);
        assertEquals("Test competition with negative speed", -1, networkCityD2.timeRequiredforCompetition());

        CompetitionDijkstra networkCityD3 = new CompetitionDijkstra(null, 50, 80, 60);
        assertEquals("Test competition with null filename", -1, networkCityD3.timeRequiredforCompetition());

        CompetitionDijkstra networkCityD4 = new CompetitionDijkstra("tinyEWD-2.txt", 50, 80, 60);
        assertEquals("Test competition with node that doesn't have path", -1, networkCityD4.timeRequiredforCompetition());

        CompetitionDijkstra networkCityD5 = new CompetitionDijkstra("input-J.txt", 98, 70, 84);
        assertEquals("Test competition with speeds fine?", -1, networkCityD5.timeRequiredforCompetition());

        CompetitionDijkstra networkCityD6 = new CompetitionDijkstra("tinyEWD.txt", 5, 80, 60);
        assertEquals("Test competition with less than 50 speed", -1, networkCityD6.timeRequiredforCompetition());
    }



    @Test
    public void testFWConstructor() {
        CompetitionFloydWarshall networkCityF = new CompetitionFloydWarshall("input-I.txt", 60,70,84);
        assertEquals("constructor failed with valid input", networkCityF.slowestPerson, 60);
    }

    @Test
    public void testFloyWar() {
        CompetitionFloydWarshall networkCityF = new CompetitionFloydWarshall("tinyEWD.txt", 50,80,60);
        assertEquals("Test competition with TINYEWD", 38, networkCityF.timeRequiredforCompetition());

        CompetitionFloydWarshall networkCityF1 = new CompetitionFloydWarshall("TINYsdfgdfgEWD.txt", 50, 80, 60);
        assertEquals("Test competition with invalid filename", -1, networkCityF1.timeRequiredforCompetition());

        CompetitionFloydWarshall networkCityF2 = new CompetitionFloydWarshall("tinyEWD.txt", -1, 80, 60);
        assertEquals("Test competition with negative speed", -1, networkCityF2.timeRequiredforCompetition());

        CompetitionFloydWarshall networkCityF3 = new CompetitionFloydWarshall(null, 50, 80, 60);
        assertEquals("Test competition with null filename", -1, networkCityF3.timeRequiredforCompetition());

        CompetitionFloydWarshall networkCityF4 = new CompetitionFloydWarshall("tinyEWD-2.txt", 50, 80, 60);
        assertEquals("Test competition with node that doesn't have path", -1, networkCityF4.timeRequiredforCompetition());

        CompetitionFloydWarshall networkCityF5 = new CompetitionFloydWarshall("input-J.txt", 98, 70, 84);
        assertEquals("Smile", -1, networkCityF5.timeRequiredforCompetition());

        CompetitionFloydWarshall networkCityF6 = new CompetitionFloydWarshall("tinyEWD.txt", 5, 80, 60);
        assertEquals("Test competition with less than 50 speed", -1, networkCityF6.timeRequiredforCompetition());
    } */
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

           // finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\testIn.txt", 75, 56, 87).timeRequiredforCompetition();
           //assertEquals("Custom input with no path returns -1", finalTime, -1);

        }
        @Test 
        //Test for CompetitionFloydWarshall
        public void testCompetitionFloydWarshall() {
            
        	int finalTime = new CompetitionDijkstra("C:\\Users\\holly\\Documents\\1000EWD.txt", 50, 50, 50).timeRequiredforCompetition();
            assertEquals("Testing Floyd Warshall with slowest speed's and 1000 input ", finalTime, 28);
        	
            finalTime = new CompetitionFloydWarshall(null, 56, 78, 57).timeRequiredforCompetition();
            assertEquals("No file results in -1", finalTime, -1);
            
            //finalTime = new CompetitionFloydWarshall("C:\\Users\\holly\\Documents\\tinyEWD.txt", 50,80,60).timeRequiredforCompetition();
            //assertEquals("Testing Floyd Warshall with random speed's and 1000 input", finalTime,25);

            finalTime = new CompetitionFloydWarshall("C:\\Users\\holly\\Documents\\tinyEWD.txt", 60, 75, 81).timeRequiredforCompetition();
            assertEquals("Testing Floyd Warshall with smaller input and random speeds", finalTime, 31);

          //  finalTime = new CompetitionFloydWarshall("C:\\Users\\holly\\Documents\\testingFile.txt", 75, 56, 87).timeRequiredforCompetition();
          //  assertEquals("Custom input with no path returns -1", finalTime, -1);


        }


    }

