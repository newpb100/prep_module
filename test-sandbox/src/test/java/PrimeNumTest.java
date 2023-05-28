import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PrimeNumTest {
    @Test
    void baseMethodInt(){
        int n = Integer.MAX_VALUE;
        //int n = 17;
        System.out.println(PrimeNum.isPrimeNum(n));
    }

    @Test
    void fastMethodInt(){
        int n = Integer.MAX_VALUE;
        //int n = 17;
        System.out.println(PrimeNum.isPrimeNumFast(n));
    }

    @Disabled("baseMethodLong: too long run, do not run")
    @Test
    void baseMethodLong(){
        long n = Integer.MAX_VALUE;
        System.out.println(PrimeNum.isPrimeNum(n));
    }
}
