import java.util.*;

public class Questions {

     Map<String,Integer> questions = new LinkedHashMap<String,Integer>();
    Random rand = new Random();
    ArrayList<String> Qlist;
    ArrayList<Integer> Qans;

     int currentQuestion;
     FirstGUI gui;

      void init(){
        questions.put("Сколько будет 2^11?",2048);
        questions.put("Сколько океанов на Земле?",4);
        questions.put("Какова высота Эвереста (м)?",8848);
        questions.put("Сколько дней в году?",365);

        gui = new FirstGUI();

          Qlist = new ArrayList<String>(questions.keySet());
          Qans = new ArrayList<Integer>(questions.values());

          gui.setQuestion(Qlist.get(currentQuestion));
        gui.init(this);



    }

    void showAnswer(int ans){
         if(ans == Qans.get(currentQuestion)) gui.setAnswer(true, Qans.get(currentQuestion));
         else gui.setAnswer(false, Qans.get(currentQuestion));
    }

    void nextQuestion(){
         currentQuestion = rand.nextInt(questions.size());
        gui.setQuestion(Qlist.get(currentQuestion));
    }

}
