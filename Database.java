package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class Database {
    private static HashMap<String,Employee> arr;
    private static Database database;



    public static void serialize()  throws IOException{
        ObjectOutputStream out=null;
        File file=new File("C:\\Users\\leech\\IdeaProjects\\week1_task\\src\\main\\java\\org\\example\\contact_information");
        if (arr!=null) {
            try{
                out=new ObjectOutputStream(new FileOutputStream(file));
                for (String s:arr.keySet()) {
                    out.writeObject(arr.get(s));
                }
            } catch (IOException e) {
                System.out.println("Exception occured in serialization");
                System.exit(1);
            }finally {
                if (out!=null) {
                    out.close();
                }
            }

        }
    }

    private static void deserialize() throws IOException {
        ObjectInputStream in=null;
        File file=new File("contact_information.txt");
        if (file.length()==0) {
            return;
        }
        try{
            in=new ObjectInputStream(new FileInputStream(file));
            while(true) {
                try{
                    Employee e1=(Employee) in.readObject();
                    arr.put(e1.getName(),e1);
                } catch(Exception e) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Exception occured in deserialization");
            System.exit(1);
        } finally {
            if (in!=null) {
                in.close();
            }
        }
    }
    private Database() throws IOException {
        arr=new HashMap<>();
        deserialize();
    }

    public static Database get_instance() throws IOException {
        if (database==null) {
            database=new Database();
        }
        return database;
    }

    public void add_employee(Employee e) {
        //Employee e=new Employee(name,email,phone_number,age,post,password);
        arr.put(e.getName(),e);
    }

    public boolean check(String name) {
        return arr.containsKey(name);
    }

    public boolean authentication(String name,String password) {
        if (arr.get(name).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public Employee get_employee(String name) {
        return arr.get(name);
    }

    public void remove_employee(String name) {
        arr.remove(name);
    }






    


}
