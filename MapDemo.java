package com.java.assignments.assignment11;

import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapDemo {
    public static void main(String args[]){
        Map<Character,Integer> mp=new HashMap<>();
        Scanner sc;
        try{
            sc=new Scanner(new File("input_data.txt"));
            while(sc.hasNext()){
                String lineText=sc.nextLine();
                System.out.println(lineText);
                for(int i=0;i<lineText.length();i++){
                    char c=lineText.charAt(i);
                    if(mp.get(c)==null){
                        mp.put(c,1);
                    }
                    else{
                        mp.put(c,mp.get(c)+1);
                    }
                }
            }
            PrintWriter pw=new PrintWriter("output_data.txt");
            mp.forEach((key,value)->{
                pw.println(key+" "+value);
                System.out.println(key+" "+value);
            });

            sc.close();
            pw.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("File not found");
            System.out.println(ex.getMessage());
        }
    }
}
