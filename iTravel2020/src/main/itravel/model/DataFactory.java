package itravel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataFactory {
    private static Data instance;
    private  DataFactory(){}
    public static Data getInstance(){
        if(instance == null) {
            synchronized (Data.class) {
                if(instance == null) {
                    instance = new Data();
                    initUsersData();
                    //initBooksData();
                    // initMembersData();
                }
            }
        }
        return instance;
    }

    private static void initUsersData (){
        instance.getUserList().add(new User("1", "user", "Guta Fida", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "user", "user"));
        instance.getUserList().add(new User("2", "admin", "Guta Fida", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "admin", "admin"));

        instance.getUserList().add(new User("000-11-0319", "user", "Guta Fida", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "gfida@mum.edu", "g"));
        instance.getUserList().add(new User("000-11-0930", "user", "Yohannes Mulualem", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "ymulualem@miu.edu", "y"));
        instance.getUserList().add(new User("000-11-0931", "user", "Eyob Weldeyohannes", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "eweldeyohannes@miu.edu", "e"));
        instance.getUserList().add(new User("000-61-1519", "user", "Abrha Gebreslassie Berhe", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "aberhe@miu.edu", "a"));
        instance.getUserList().add(new User("000-61-1699", "user", "Henok Abraham Haile", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "habraham@miu.edu", "h"));
        instance.getUserList().add(new User("000-61-1775", "user", "Hailian Zhang", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "hzhang@miu.edu", "h"));
        instance.getUserList().add(new User("000-61-1525", "user", "Dang Thu Ha Le", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "dthle@miu.edu", "d"));
        instance.getUserList().add(new User("000-61-1635", "user", "Le Hieu Le", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "lle@mum.edu", "l"));
        instance.getUserList().add(new User("000-61-1775", "user", "Hailian Zhang", "M", "IA", "Fairfield", "1000 N 4th", "52557", 1990, "hzhang@miu.edu", "h"));

    }

    private static void initBooksData (){
        for (int i = 1; i <= 7; i++)
        {
            String strID 	= String.format("%03d", i);
            String strTitle = String.format("Title %03d", i);
            String strAuthor = String.format("Author %03d", i);
            String strSubject = String.format("Subject %03d", i);
            String strIsbn = String.format("ISBN%03d", i);
            instance.getBookList().add(new Book(strID, strTitle, strAuthor, strSubject, strIsbn));
        }
    }

    private static void initMembersData (){
        for (int i = 1; i <= 10; i++)
        {
            String strID 	= String.format("%03d", i);
            String strName = String.format("Name %03d", i);
            String strAddress = String.format("Address %03d", i);
            String strPhone = String.format("Phone %03d", i);
            instance.getMemberList().add(new Member(strID, strName, strAddress, strPhone));
        }
    }




}
