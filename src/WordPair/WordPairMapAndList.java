/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WordPair;

import java.util.ArrayList;
import LoadAndSave.LoadAndSaveWordPair;
import java.util.HashMap;

/**
 *
 * @author sebastiannielsen
 */
public class WordPairMapAndList {
    private HashMap wordPairsQuestionKey;
    private ArrayList<WordPair> wordPairList;
    private WordPair wP;
    private int index = 0;
    
    public WordPairMapAndList(){
        wordPairList = new ArrayList<>(); 
        wordPairsQuestionKey = new HashMap();
        wordPairList = LoadAndSaveWordPair.loadWordPair("wordPair.txt");
        
        for(WordPair wordpairs: wordPairList){
            wP = wordPairList.get(index);
            wordPairsQuestionKey.put(wP.getQuestion(),wP);
            index++;
        }
        
    }

    public HashMap getWordPairMapQuestionKey() {
        return wordPairsQuestionKey;
    }

    public ArrayList<WordPair> getWordPairList() {
        return wordPairList;
    }
    
    

     
    
}
