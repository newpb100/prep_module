package com.ams.train;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Step03File {

    public static void doStep03File() throws IOException {
        /*
        var fl = new FileOutputStream("testfile.txt", true);
        String str = "som e tesx немного по-русски \r\n";
        System.out.println("---write to file---");
        fl.write(str.getBytes(StandardCharsets.UTF_8));
        fl.close();
         */

        System.out.println("---read from file FileInputStream---");
        var fl2 = new FileInputStream("testfile.txt");
        int i=0;
        while ((i = fl2.read()) != -1){
            System.out.print((char)i);
        }
        fl2.close();
        //som e tesx Ð½ÐµÐ¼Ð½Ð¾Ð³Ð¾ Ð¿Ð

        //попробуем вывести теперь каждый символ и его в формате <code><char>";"
        System.out.println("");
        System.out.println("---read from file FileInputStream and print it in format : <code><char>; ");
        String s = "";
        fl2 = new FileInputStream("testfile.txt");
        while ((i = fl2.read()) != -1){
            s = s + i;
            s = s + (char)i + ";";
        }
        System.out.println(s); // не сможет вывести эти символы в терминал, но в дебаге видно как искомая строка формируется верно
        fl2.close();


        System.out.println("");
        System.out.println("---read from file BufferedInputStream---");
        var fl3 = new BufferedInputStream(new FileInputStream("testfile.txt"));
        while ((i = fl3.read()) != -1){
            System.out.print((char)i);
        }
        fl3.close();

        //как же в итоге прочитать файл с русскими буквами
        System.out.println("");
        System.out.println("---read from file russians and english letters---");
        fl2 = new FileInputStream("testfile.txt");
        //переделываем файл-стрим в просто инпут-стрим
        InputStreamReader isr = new InputStreamReader(fl2);
        var br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine ()) != null){
            System.out.println(line);
        }
        fl2.close();
        isr.close();
        br.close();


        // calc speed
        System.out.println("");

        var dt = new Date();
        fl2 = new FileInputStream("pom.xml");
        s="";
        while ((i = fl2.read()) != -1){
            s = s + (char)i;
        }
        var dt1 = new Date();
        System.out.println("total time for FileInputStream (ms): " + (dt1.getTime() - dt.getTime()));

        dt = new Date();
        fl3 = new BufferedInputStream(new FileInputStream("pom.xml"), 200);
        s = "";
        while ((i = fl3.read()) != -1){
            s = s + (char)i;
        }
        fl3.close();
        dt1 = new Date();
        System.out.println("total time for BufferedInputStream (ms) : " + (dt1.getTime() - dt.getTime()));


    }
}
