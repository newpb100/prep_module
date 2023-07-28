package com.ams.train;

public class Step22DrawSinGraph {

    public static int N = 10;

    public static void drawValue(double y){
        int value = (int)(y * N) + N;
        char c ;

        //System.out.print("value = " + value + " ; ");

        for (int i = 0; i < 2 * N; i++) {
            //char c = i == N ? '|' : '.';

            if (i == N){
                c = '|';
            }else{
                c = '.';
            }

            if (i == value)
                c = '*';

            System.out.print(c);
        }
        System.out.println();

    }


    public static void main(String[] args) {
        ///drawValue(2.0);

        for (int i = 0; i < 10 * N; i++){
            double x = i * 1.0 / N;
            double y = Math.sin(x);

            //System.out.print(x + "; "); // меняется от 0 до 9.9
            //System.out.print(y + "; ");   // меняется от 0 до 0.9995736030415051; потом до -0.9999232575641008 потом опять до 0.998941341839772; и т.д.

            drawValue(y);
            //System.out.println();
        }
    }
}
