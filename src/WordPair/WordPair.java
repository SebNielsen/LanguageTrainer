/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WordPair;

/**
 *
 * @author sebastiannielsen
 */
public class WordPair {
    private String question, answer;
    int priority;
   
    
    public WordPair(String question, String answer, int priority){
        this.question = question;
        this.answer = answer;
        this.priority = priority;
        
    
}
    public String toString(){
        return "" + question + "," + answer + "," + priority;
    }
    
    ////////////////set and getmethods//////////////////////////////
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

   
    
}
