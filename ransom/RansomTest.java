import org.testng.Assert;
import org.testng.annotations.Test;

public class RansomTest {

    @Test
    public void testCanRansom() throws Exception {
        boolean yayRansom = Ransom.canRansom("dying wool is what you will be doing", "you will be dying");
        System.out.println("You " + (yayRansom ? "can" : "can't") + " write a ransom letter");
        boolean failRansom = Ransom.canRansom("can you believe Justin Beiber's new shirt?", "give me all your money");
        System.out.println("You " + (failRansom ? "can" : "can't") + " write a ransom letter");

        Assert.assertTrue(yayRansom);
        Assert.assertFalse(failRansom);
    }
}