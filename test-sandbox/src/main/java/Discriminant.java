public class Discriminant {
    private  int a;
    private  int b;
    private  int c;

    public Discriminant(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getDiscriminant(){
        return b*b - 4*a*c;
    }

    public int getNumberOfDicisions(){
        int dsc = this.getDiscriminant();

        if (dsc > 0){
            return 2;
        }else{
            if (dsc == 0){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
