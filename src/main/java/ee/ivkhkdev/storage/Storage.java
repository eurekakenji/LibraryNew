package ee.ivkhkdev.storage;


import ee.ivkhkdev.interfaces.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage<T> implements Repository<T> {

    private String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void save(T entity){
        List<T> entities = this.load();
        if(entities == null) entities = new ArrayList<>();
        entities.add(entity);
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Input Error");
        }
    }

    public void saveAll(List<T> entities){
        if(entities == null) entities = new ArrayList<>();
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Input Error");
        }
    }


    @Override
    public List<T> load(){
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No such file exists");
        } catch (IOException e) {
            System.out.println("Output Error");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found ");
        }
        return new ArrayList<>();
    }
}
