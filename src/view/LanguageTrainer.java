/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import Interfaces.WordPairControlInterface;

/**
 *
 * @author sebastiannielsen
 */
public class LanguageTrainer extends javax.swing.JPanel {
    
    private WordPairControlInterface controller;
    private int panel = 0;
    /**
     * Creates new form LanguageTrainer
     */
    public LanguageTrainer(WordPairControlInterface controller) {
        this.controller = controller;
        initComponents();
        jButtonSave.setVisible(false);
        jLabelHeader.setVisible(false);
        jButtonBack.setVisible(false);
        askQuestion();
    }
    
    private void askQuestion(){
        jTextFieldQuestion.setText(controller.getRandomQuestion());
        
    }
    
    private void clearFields(){
        jTextFieldAnswer.setText("");
        jLabelMessage.setText("");
    }
    
    private void checkGuess(){
        if (controller.checkGuess(jTextFieldQuestion.getText(), jTextFieldAnswer.getText()) == true) {
            jLabelMessage.setText("Correct");
        } else {
            jLabelMessage.setText("Incorrect");
        }
    }
    
    private void lookUp(){
        String answer = controller.lookup(jTextFieldQuestion.getText());
        jTextFieldAnswer.setText(answer);
    }
    
    private void changeLayout(){
        
        switch (panel) {
            case 0:
                
                jLabelHeader.setVisible(false);
                jButtonGuess.setVisible(true);
                jButtonNext.setVisible(true);
                jButtonLookUp.setVisible(true);
                jButtonSave.setVisible(false);
                jButtonBack.setVisible(false);
                askQuestion();
                jTextFieldQuestion.setEditable(false);
                jTextFieldAnswer.setText("");
                jLabelMessage.setText("");
                break;
            case 1:

                jLabelHeader.setVisible(true);
                jButtonGuess.setVisible(false);
                jButtonNext.setVisible(false);
                jButtonLookUp.setVisible(false);
                jButtonSave.setVisible(true);
                jButtonBack.setVisible(true);
                jTextFieldQuestion.setText("");
                jTextFieldQuestion.setEditable(true);
                jTextFieldAnswer.setText("");
                jLabelMessage.setText("");
                break;
        }
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldQuestion = new javax.swing.JTextField();
        jTextFieldAnswer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jButtonGuess = new javax.swing.JButton();
        jButtonLookUp = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jLabelHeader = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(348, 250));
        setMinimumSize(new java.awt.Dimension(348, 250));
        setPreferredSize(new java.awt.Dimension(348, 250));

        jTextFieldQuestion.setEditable(false);

        jLabel2.setText("Question");

        jLabel3.setText("Answer");

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonGuess.setText("Guess");
        jButtonGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuessActionPerformed(evt);
            }
        });

        jButtonLookUp.setText("Look Up");
        jButtonLookUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLookUpActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Add new");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabelHeader.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelHeader.setText("Add new WordPair");

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jTextFieldQuestion)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addGap(4, 4, 4)
                                .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonGuess, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jButtonNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLookUp, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLookUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        askQuestion();
        clearFields();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuessActionPerformed
        checkGuess();
    }//GEN-LAST:event_jButtonGuessActionPerformed
        
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        panel = 1;
        changeLayout();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonLookUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLookUpActionPerformed
        lookUp();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLookUpActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        controller.add(jTextFieldQuestion.getText(), jTextFieldAnswer.getText());
        if(controller.save("wordPair.txt") == true){
            jLabelMessage.setText("Saved");
        } else{
            jLabelMessage.setText("NotSaved");
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
       panel = 0;
       changeLayout();
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonGuess;
    private javax.swing.JButton jButtonLookUp;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JTextField jTextFieldAnswer;
    private javax.swing.JTextField jTextFieldQuestion;
    // End of variables declaration//GEN-END:variables
}
