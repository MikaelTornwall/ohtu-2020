package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics statistics;      
    
    @Before
    public void setUp() {
        statistics = new Statistics(readerStub);
    }       
    
    @Test
    public void correctPlayerIsReturnedWhenPlayerExists() {
        Player player = statistics.search("Kurri");        
        assertEquals("Kurri", player.getName());
    }
    
    @Test
    public void nullIsReturnedWhenPlayerDoesNotExist() {
        Player player = statistics.search("Selanne");
        assertEquals(null, player);
    }
    
    @Test
    public void teamThatDoesNotExistIsReturnsEmptyList() {
        List<Player> team = statistics.team("ANA");
        assertTrue(team.isEmpty());
    }
    
    @Test
    public void teamWithCorrectNumberOfPlayersIsReturned() {
        List<Player> team = statistics.team("EDM");
        assertEquals(3, team.size());
    }
    
    @Test
    public void teamContainsCorrectPlayer() {
        List<Player> team = statistics.team("PIT");
        assertEquals("Lemieux", team.get(0).getName());
    }
    
    @Test
    public void topScorersReturnsEmptyListWithNegativeValue() {
        List<Player> scorers = statistics.topScorers(-1);
        assertEquals(0, scorers.size());
    }
    
    @Test
    public void topScorersReturnsListOfCorrectSize() {
        List<Player> scorers = statistics.topScorers(2);
        assertEquals(3, scorers.size());
    }  
}
