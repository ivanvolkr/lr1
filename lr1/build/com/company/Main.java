package com.company;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import java.util.List;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (args[0].equals("-i")) {
            Interactive mode1 = new Interactive();
	    String answer = null;
           do{
               System.out.println("\n Type the file path. (Use 'exit' to end program)\n");
                answer = in.nextLine();
               
               try { 
                  mode1.InteractiveHash(answer);
                   }
                catch (Exception e) { System.out.println(" ");
                  }     
          } while (!answer.equals("exit"));
        } else {
             try {
            if (args[0].equals("-md5") | args[0].equals("-sha256")) {
                Simple mode2 = new Simple();
                if (args[1].equals("-f")) {
                    if (args.length > 2) {
                        int i = 2; { do {
                            try{
                            mode2.SimpleHash( args[0], args[i]);
                            } catch (Exception e) { System.out.println(" ");
                           }
                           i = i+1;
                       } while (i < args.length); }
                    } else System.out.println ("exception1 ");
                }else System.out.println ("exception2 ");
            }else System.out.println (" exception3");
          }
        catch (Exception e) { System.out.println("exception ");
                  } 
        } 
    }

     
    public String FileRead(String path) {

        String content = null;
        File file = new File(path);

        try {
            content = FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            System.out.println("Exception: " + "WRONG FILE PATH");
           
        }
        return content;
    }
}
