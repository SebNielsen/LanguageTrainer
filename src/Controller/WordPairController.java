/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.WordPairControlInterface;
import WordPair.*;
import java.util.ArrayList;
import java.util.HashMap;
import LoadAndSave.LoadAndSaveWordPair;
import java.util.Collections;


/**
 *
 * @author sebastiannielsen
 */
public class WordPairController implements WordPairControlInterface {
    private WordPairMapAndList wordpairs;
    private HashMap WordPairMapQuestionKey;
    private ArrayList<WordPair> wordPairList;
    private ArrayList<WordPair> wordPairListPriority1;
    private ArrayList<WordPair> wordPairListPriority2;
    private ArrayList<WordPair> wordPairListPriority3;
    private ArrayList<WordPair> wordPairListPriority4;
    private ArrayList<WordPair> wordPairListPriority5;

    public WordPairController() {
        wordpairs = new WordPairMapAndList();
        wordPairList = wordpairs.getWordPairList();
        WordPairMapQuestionKey = wordpairs.getWordPairMapQuestionKey();
        wordPairListPriority1 = new ArrayList<>();
        wordPairListPriority2 = new ArrayList<>();
        wordPairListPriority3 = new ArrayList<>();
        wordPairListPriority4 = new ArrayList<>();
        wordPairListPriority5 = new ArrayList<>();

    }

    private void fillWordPairLists() {
        for (WordPair wordpair : wordPairList) {
            if (wordpair.getPriority() == 1) {
                wordPairListPriority1.add(wordpair);
            } else if (wordpair.getPriority() == 2) {
                wordPairListPriority2.add(wordpair);
            } else if (wordpair.getPriority() == 3) {
                wordPairListPriority3.add(wordpair);
            } else if (wordpair.getPriority() == 4) {
                wordPairListPriority4.add(wordpair);
            } else if (wordpair.getPriority() == 5) {
                wordPairListPriority5.add(wordpair);
            }
        }
    }

    @Override
    public void add(String question, String answer) {
        WordPair wP = new WordPair(question, answer, 1);
        wordPairList.add(wP);
        WordPairMapQuestionKey.put(wP.getQuestion(), wP);
    }

    @Override
    public int size() {
        return wordPairList.size();
    }

    @Override
    public String getRandomQuestion() {
        wordPairList = wordpairs.getWordPairList();
        fillWordPairLists();
        int randomQuestion = (int) ((Math.random() * 15 + 1));
        WordPair randomWordPair;
        if (randomQuestion > 0 && randomQuestion < 6 && wordPairListPriority1.size() >= 1) {
            randomWordPair = (WordPair) wordPairListPriority1.get(0);
            Collections.shuffle(wordPairListPriority1);

        } else if (randomQuestion > 5 && randomQuestion < 10 && wordPairListPriority2.size() >= 1) {
            randomWordPair = (WordPair) wordPairListPriority2.get(0);
            Collections.shuffle(wordPairListPriority2);

        } else if (randomQuestion > 9 && randomQuestion < 13 && wordPairListPriority3.size() >= 1) {
            randomWordPair = (WordPair) wordPairListPriority3.get(0);
            Collections.shuffle(wordPairListPriority3);

        } else if (randomQuestion > 12 && randomQuestion < 15 && wordPairListPriority4.size() >= 1) {
            randomWordPair = (WordPair) wordPairListPriority4.get(0);
            Collections.shuffle(wordPairListPriority4);

        } else if (randomQuestion == 15 && wordPairListPriority5.size() >= 1) {
            randomWordPair = (WordPair) wordPairListPriority5.get(0);
            Collections.shuffle(wordPairListPriority5);

        } else {
            randomWordPair = (WordPair) wordPairList.get(randomQuestion);
        }

        return randomWordPair.getQuestion();
    }

    @Override
    public boolean checkGuess(String question, String quess) {
        WordPair activeQuestion = (WordPair) WordPairMapQuestionKey.get(question);

        if ((activeQuestion.getQuestion().equals(question)) && activeQuestion.getAnswer().equals(quess.toLowerCase())) {
            if(activeQuestion.getPriority() < 5){
            activeQuestion.setPriority(activeQuestion.getPriority() + 1);
            LoadAndSaveWordPair.saveWordPair(wordPairList, "wordPair.txt");
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String lookup(String question) {
        WordPair activeQuestion = (WordPair) WordPairMapQuestionKey.get(question);

        return activeQuestion.getAnswer();
    }

    @Override
    public boolean load(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(String filename) {
        if (LoadAndSaveWordPair.saveWordPair(wordPairList, filename) == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        wordPairList.removeAll(wordPairList);
        WordPairMapQuestionKey.clear();
    }

}
