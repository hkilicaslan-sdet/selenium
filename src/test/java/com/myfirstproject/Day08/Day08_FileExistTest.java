package com.myfirstproject.Day08;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest {
    @Test
    public void doesExistTest(){
//        Class: FileExistTest
//        Method: isExist
//        Pick a file on your desktop ( there is projects on desktop)

//        And verify if that file exist on your computer or not
        String pathFile="C:\\Users\\nm.kljöm\\Downloads\\logo.jpeg";
    boolean doesExist= Files.exists(Paths.get(pathFile));
        Assert.assertTrue(doesExist);

    }
    @Test
    public void isExist(){
        String homeDirectory=System.getProperty("user.home");
        System.out.println("Home Directory : "+homeDirectory);

//        String userDirectory=System.getProperty("user.dir");
//        System.out.println("User Directory : "+userDirectory);

        String filePath=homeDirectory+"\\Downloads\\logo.jpeg";
        boolean isExist= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);
    }
}
