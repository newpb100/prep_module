package com.ams.train;

import java.awt.*;
import java.util.Random;

public class Step29StringFormatAndColor {

    public static void main(String[] args) {

        Random randGen = new Random();

        Color c = new Color(randGen.nextFloat(), randGen.nextFloat(), randGen.nextFloat());

        System.out.println(c.getRGB());
        //-8660617
        System.out.println(String.format("#%06x", c.getRed()));
        // #00007b
        System.out.println(String.format("#%06x", c.getGreen()));
        // #0000d9
        System.out.println(String.format("#%06x", c.getBlue()));
        // #000077

        //
        System.out.println();
        System.out.println(String.format("#%06x", c.getRGB()));
        // #ff23536f
        System.out.println(String.format("#%06x", c.getRGB() & 0x00FFFFFF));
        // #23536f
    }
}
