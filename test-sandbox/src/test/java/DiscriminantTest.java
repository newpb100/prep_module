import org.junit.Assert;
import org.junit.Test;


public class DiscriminantTest {


    @Test
    public void checkNoDicisions(){
        Discriminant dsc = new Discriminant(1,1,1);
        Assert.assertEquals(dsc.getNumberOfDicisions(),0);
    }

    @Test
    public void checkOneDicision(){
        Discriminant dsc = new Discriminant(1,2,1);
        Assert.assertEquals(dsc.getNumberOfDicisions(),1);
    }

    @Test
    public void checkTwoDicision(){
        Discriminant dsc = new Discriminant(1,5,6);
        Assert.assertEquals(dsc.getNumberOfDicisions(),2);
    }
}
