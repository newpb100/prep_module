import org.junit.Ignore;
import org.junit.Test;

public class PrimeNumTest {
    @Test
    public void baseMethodInt(){
        int n = Integer.MAX_VALUE;
        //int n = 17;
        System.out.println(PrimeNum.isPrimeNum(n));
    }

    @Test
    public void fastMethodInt(){
        int n = Integer.MAX_VALUE;
        //int n = 17;
        System.out.println(PrimeNum.isPrimeNumFast(n));
    }

    @Ignore("baseMethodLong: too long run, do not run")
    @Test
    public void baseMethodLong(){
        long n = Integer.MAX_VALUE;
        System.out.println(PrimeNum.isPrimeNum(n));
    }
}
