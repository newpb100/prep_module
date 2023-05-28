public class PrimeNum {
    public static boolean isPrimeNum(int n) {

        int i = 2;
        while (i >= 2 && n % i != 0){
            i++;
        }
        return i == n;
    }

    public static boolean isPrimeNum(long n) {

        int i = 2;
        while (i >= 2 && n % i != 0){
            i++;
        }
        return i == n;
    }

    public static boolean isPrimeNumFast(long n) {

        int i = 2;
        int m = (int) Math.sqrt(n);
        System.out.println("m = " + m);

        while (i < m && n % i != 0){
            i++;
        }
        return i == m;
    }
    /*
      Например для 10 множителями являются 5 и 2.
      5 больше корня из 10, но его парный множитель 2 - меньше.
      Соответственно, если мы перебрали все числа до корня и не нашли делителя, то дальше перебирать бесполезно,
      т.к. всё равно не получится правильной пары делителей.

     еще точнее- ровно одно меньше, а второе больше квадратного корня.

     ещё есть вариант, когда оба равны корню.
    * */
}
