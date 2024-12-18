package com.ams.train;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Step03ReadAndWriteFile {

    public void copyFileWithBuffer() throws IOException {
        byte[] bytearr = new byte[1024 * 1024];

        var fis = new FileInputStream("testfile.txt");
        var fos = new FileOutputStream("testfile_out.txt");

        // В одном из примеров
        // File fileOut = new File(fileOutName);
        // FileChannel wChannel = new FileOutputStream(fileOut, true).getChannel();
        /**
         * FileChannel — это класс в языке программирования Java, который предоставляет канальный подход для выполнения
         * операций ввода-вывода с файлом.
         * Он является частью пакета Java NIO и был представлен в Java 1.4 в качестве альтернативы
         * традиционному API ввода-вывода для выполнения операций с файлами.
         *
         * FileChannel предоставляет методы для:
         * — чтения и записи данных из файла;
         * — отображения файла в памяти;
         * — блокировки части файла;
         * — передачи данных между каналами.
         *
         * Канальный подход, предоставляемый FileChannel, является более эффективным и гибким, чем традиционный API ввода-вывода,
         * так как он позволяет выполнять асинхронные операции ввода-вывода и лучше контролировать управление буферами.
         */

        while (true) {
            int size = fis.read(bytearr);       // побайтовое чтение из потока в массив байт
            fos.write(bytearr, 0, size);

            if (size < bytearr.length) break;
        }

        fis.close();
        fos.close();
    }

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
        System.out.println("--- read from file FileInputStream and print it in format : <code><char>; ");
        String s = "";
        fl2 = new FileInputStream("testfile.txt");
        while ((i = fl2.read()) != -1){
            s = s + i;
            s = s + (char)i + ";";
        }
        System.out.println(s); // не сможет вывести эти символы в терминал, но в дебаге видно как искомая строка формируется верно
        fl2.close();


        System.out.println("");
        System.out.println("--- read from file BufferedInputStream ---");

        var fl3 = new BufferedInputStream(new FileInputStream("testfile.txt"));

        while ((i = fl3.read()) != -1){
            System.out.print((char)i);
        }
        fl3.close();

        //как же в итоге прочитать файл с русскими буквами
        System.out.println("");
        System.out.println("--- read from file russians and english letters ---");

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


        System.out.println("");
        System.out.println("--- read from file with nio.File ---");
        try {
            var uri = ClassLoader.getSystemResource("testfile.txt").toURI();    // файл в ресурсах

            byte[] bytesFile = Files.readAllBytes(Paths.get(uri));

            System.out.println("Строка из файла : " + new String(bytesFile));

        } catch (URISyntaxException e) {
            System.out.println("Ошибка! Не нашел такой файл");
            throw new RuntimeException(e);
        }


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

