package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class User_interface {
    public User_interface(Database d) {
        input(d);
    }

    private void input(Database d) {
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee detail");
        System.out.println("3. View Employee details");
        System.out.println("4. Delete Employee ");
        System.out.println("5. Exit");

        Scanner sc=new Scanner(System.in);
        int x=0;
        try{
            x=sc.nextInt();
            sc.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("invalid input");
            input(d);
        }

        if (x==1) {
            System.out.println("Enter employee name");
            String name=sc.nextLine();


            System.out.println("Enter the email address");
            String email=sc.nextLine();
            boolean flag1=false;
            boolean flag2=false;
            for (int i=0;i<email.length();i++) {
                if (email.charAt(i)=='@') {
                    flag1=true;
                } else if (email.charAt(i)=='.') {
                    flag2=true;
                }

            }


            if (!flag1 || !flag2) {
                System.out.println("invalid email addresss");
                input(d);
            }

            System.out.println("enter the phone number");
            String phone_number=sc.nextLine();
            boolean flag11=false;
            boolean flag22=true;
            if (phone_number.length()==10) {
                flag11=true;
            }


            for (int i = 0; i < phone_number.length(); i++) {
                if (!Character.isDigit(phone_number.charAt(i))) {
                    flag22=false;
                    break;
                }
            }

            System.out.println("Enter the age ");

            int age=0;
            try{
                age=sc.nextInt();
                sc.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("invalid age");
                input(d);
            }

            System.out.println("Enter the post");

            String post=sc.nextLine();

            System.out.println("Enter the password with length greater than 6");

            String password=sc.nextLine();
            if (password.length()<=6) {
                input(d);
            }

            Employee e=new Employee(name,email,phone_number,age,post,password);
            d.add_employee(e);
            input(d);
        } else if (x==2) {
            System.out.println("Enter the name");
            String name=sc.nextLine();
            if (!d.check(name)) {
                System.out.println("No user of this name exists");
                input(d);
            }
            System.out.println("Enter the password");
            String password=sc.nextLine();
            if (!d.authentication(name,password)) {
                System.out.println("Wrong password authentication failed");
                input(d);
            }


            Employee change=d.get_employee(name);


            System.out.println("1. Update name");
            System.out.println("2. Update email");
            System.out.println("3. Update Phone_numer");
            System.out.println("4. Update age");
            System.out.println("5. Update Post");
            System.out.println("6. Update Password");
            int y=0;
            try{
                y=sc.nextInt();
                sc.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("invalid input");
                input(d);
            }

            if (y==1) {
                System.out.println("Enter the new name");
                String new_name=sc.nextLine();
                d.remove_employee(change.getName());
                change.setName(new_name);
                d.add_employee(change);

                System.out.println("name successfully changed");
            } else if (y==2) {
                System.out.println("Enter the new email address");
                String email=sc.nextLine();
                change.setEmail(email);
            } else if (y==3) {
                System.out.println("Enter the new Phone number");
                String Phone_number=sc.nextLine();
                change.setPhone_number(Phone_number);
            } else if (y==4) {
                System.out.println("Enter the age");
                int age=0;
                try{
                    age=sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("invalid age");
                    input(d);
                }
                change.setAge(age);
            } else if (y==5) {
                System.out.println("Enter the new post");
                String post=sc.nextLine();
                change.setPost(post);
            } else if (y==6) {
                System.out.println("Enter the new password");
                String password1=sc.nextLine();
                change.setPassword(password1);
            } else {
                System.out.println("invalid input");
                input(d);
            }
            input(d);
        } else if (x==3) {
            System.out.println("Enter the name");
            String name=sc.nextLine();
            if (!d.check(name)) {
                System.out.println("No user of this name exists");
                input(d);
            }
            System.out.println("Enter the password");
            String password=sc.nextLine();
            if (!d.authentication(name,password)) {
                System.out.println("Wrong password authentication failed");
                input(d);
            }


            Employee change=d.get_employee(name);

            System.out.println("1. View Name");
            System.out.println("2. View Email");
            System.out.println("3. View Phone_number");
            System.out.println("4. View Age");
            System.out.println("5. View Post");

            int y=0;
            try{
                y=sc.nextInt();
                sc.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("invalid input");
                input(d);
            }

            if (y==1) {
                System.out.println(change.getName());
            } else if (y==2) {
                System.out.println(change.getEmail());
            } else if (y==3) {
                System.out.println(change.getPhone_number());
            } else if (y==4) {
                System.out.println(change.getAge());
            } else if (y==5) {
                System.out.println(change.getPost());
            } else {
                System.out.println("invalid input");
                input(d);
            }
            input(d);
        } else if (x==4) {
            System.out.println("Enter the name");
            String name=sc.nextLine();
            if (!d.check(name)) {
                System.out.println("No user of this name exists");
                input(d);
            }
            System.out.println("Enter the password");
            String password=sc.nextLine();
            if (!d.authentication(name,password)) {
                System.out.println("Wrong password authentication failed");
                input(d);
            }
            d.remove_employee(name);
            input(d);
        } else if (x==5){
            try{
                Database.serialize();
            } catch (Exception e) {
                System.out.println("Error in writing to the file");
                System.exit(1);
            }

            System.exit(0);
        } else {
            System.out.println("invalid input");
            input(d);
        }
    }
}
