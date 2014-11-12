/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LoadAndSave;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import WordPair.*;

/**
 *
 * @author sebastiannielsen
 */
public class LoadAndSaveWordPair {

    
   
    public static ArrayList<WordPair> load(String filename)
    {
        Scanner file_scanner = null;
        ArrayList<WordPair> wordPairArray = new ArrayList<>();

        try {
            file_scanner = new Scanner(new File("wordPair.txt"));  //Connection to the file using the Scanner object
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file to load from! Returning null.");
            ex.printStackTrace();
            return null;  //If something goes wrong the method returns null
        }

        while (file_scanner.hasNextLine()) {  //File found. Reading one line. 
            String question = file_scanner.next();
            String answer = file_scanner.next();
            int priority = file_scanner.nextInt();
            WordPair wP = new WordPair(question, answer, priority);
            wordPairArray.add(wP);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return wordPairArray;    //returning the arraylist
    }
    public static ArrayList<WordPair> loadWordPair(String filename)
    {
        Scanner file_scanner = null;
        ArrayList<WordPair> wordPairArray = new ArrayList<>();

        try {
            file_scanner = new Scanner(new File(filename));  //Connection to the file using the Scanner object
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file to load from! Returning null.");
            ex.printStackTrace();
            return null;  //If something goes wrong the method returns null
        }
        
        while (file_scanner.hasNext()) {  //File found. Reading one line. 
            String linje = file_scanner.next();
            Scanner sc = new Scanner(linje).useDelimiter(",");
            String question = sc.next();
            String answer = sc.next();
            int priority = sc.nextInt();
            WordPair wP = new WordPair(question, answer, priority);
            wordPairArray.add(wP);  //Reading in a single line and saving in the ArrayList
        }

        file_scanner.close();  //Closing the file
        return wordPairArray;    //returning the arraylist
    }

    /**
     * This method saves an ArrayList of strings to disk.
     * Each string object in this array will be one line in the text file. 
     * The text file is overwritten, what ever was in there is lost. 
     *
     * @param personArray ArrayList<String> Each String object in this array will be 
     * saved as one line in the text file. 
     * @params filename String the name of the file (that is located in the project folder).
     * @return true if everything went well. False if an exception was raised.
     */
       
    public static boolean saveWordPair(ArrayList<WordPair> wordPairArray, String filename)
    {
        if( wordPairArray == null ) { return false;  }  //Checking parameter for null.
        FileWriter output;  //Creating reference for filewriter.
        PrintWriter pw;
        
        try {
                output = new FileWriter(new File("wordPair.txt"));  //Opening connection to file.
                
                for (WordPair wordPairLine : wordPairArray) {   //running through the ArrayList.                    
                    output.write(wordPairLine.toString() + " ");//Each String object is written as a line in file.
            }

            output.close();  //Closing the file
        } catch (Exception ex) {  //If something goes wrong everything is send to system out.
            System.out.println("Could not save to file!");
            System.out.println(ex.toString());
            ex.printStackTrace();
            return false;  //If something goes wrong false is returned!
        }

        return true;
    }

}
    

