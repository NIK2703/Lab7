import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstGUI extends JFrame {
    private JSlider slider1000;
    private JSlider slider100;
    private JSlider slider10;
    private JSlider slider1;
    private JButton ok;
    private JButton next;
    private JPanel mainPanel;
    private JLabel answer;
    private JLabel question;

    Questions handler;

    int sliderValue[] = new int[4];

    String questionText = "Вопрос";
    String answerText = "Ответ";

    Integer ansVal = 0;

    void init(Questions handler){
        add(mainPanel);
        pack();
        setVisible(true);
        this.handler = handler;


        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.showAnswer(ansVal);
                handler.nextQuestion();
                question.setText(questionText);
            }
        });

        next.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.nextQuestion();
                refresh();
            }
        });

        slider1000.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue[0] = slider1000.getValue();
                refresh();
            }
        });

        slider100.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue[1] = slider100.getValue();
                refresh();
            }
        });

        slider10.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue[2] = slider10.getValue();
                refresh();
            }
        });

        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderValue[3] = slider1.getValue();
                refresh();
            }
        });

        refresh();

    }

    int getAnswer(){
        return ansVal;
    }

    void setQuestion(String newQuestion){
        questionText = newQuestion;
    }

    void setAnswer(boolean ans, int rightAns){
        if(ans){
            answer.setText("Правильно!");
        } else{
            answer.setText("Не правильно! Ответ: "+rightAns);
        }

    };


    void refresh(){
        ansVal = sliderValue[0]*1000 + sliderValue[1]*100 +
                sliderValue[2]*10 + sliderValue[3];

        answerText = ansVal.toString();

        question.setText(questionText);
        answer.setText(answerText);
    }


}
