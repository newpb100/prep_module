package com.ams.train;

import com.ams.train.supply.SerializableRabbit;

import java.io.*;

public class Step38SerializableObject {

    public static void main(String[] args) {

        SerializableRabbit serializableRabbit = new SerializableRabbit();
        serializableRabbit.setName("Peter");

        System.out.println("SerializableRabbit.hashCode() : " + serializableRabbit.hashCode());


        File resourcesFolder = new File("src/main/resources");
        resourcesFolder.mkdirs();                                               //creates the directory in case it doesn't exist

        File file = new File(resourcesFolder, "rabbit.ser");

        try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(serializableRabbit);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SerializableRabbit newSerializableRabbit = (SerializableRabbit)ois.readObject();

            System.out.println("newSerializableRabbit.name       : " + newSerializableRabbit.getName());
            System.out.println("newSerializableRabbit.hashCode() : " + newSerializableRabbit.hashCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
