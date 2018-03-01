import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class TeamBuilder_Tests {

    TeamBuilder test_TeamBuilder;
    @Before
    public void setUp() {
        test_TeamBuilder = new TeamBuilder();
    }

    @Test
    public void testCase1() {
        String[] paths = new String[]{"010", "000", "110"};
        int[] expected = new int[]{1, 1};
        int[] actual = test_TeamBuilder.specialLocations(paths);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        String[] paths = new String[]{"0010", "1000", "1100", "1000"};
        int[] expected = new int[]{1, 3};
        int[] actual = test_TeamBuilder.specialLocations(paths);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        String[] paths = new String[]{"01000", "00100", "00010", "00001", "10000"};
        int[] expected = new int[]{5, 5};
        int[] actual = test_TeamBuilder.specialLocations(paths);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        String[] paths = new String[]{"0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};
        int[] expected = new int[]{1, 3};
        int[] actual = test_TeamBuilder.specialLocations(paths);
        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void myTestCase1() { //Case with all 0's
        String[] paths = new String[]{"0000000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};
        int[] expected = new int[]{0, 0};
        int[] actual = test_TeamBuilder.specialLocations(paths);
        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void myTestCase2() { //Case with too many values
        String[] paths = new String[]{"111", "111", "111", "111"};
        int[] expected = null;
        int[] actual = test_TeamBuilder.specialLocations(paths);
        Assert.assertArrayEquals(expected, actual);
    }
}