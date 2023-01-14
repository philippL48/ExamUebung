import java.util.ArrayList;
import java.util.Collections;

//import java.util.Collections;
public class Exam {
    private String name;
    private int year;
    private ArrayList<Question> questions;

    private class Question {
        private String text;
        private int points;

        public Question(String text, int points) {
            this.text = text;
            this.points = points;
        }

        public String getText() {
            return text;
        }
        public int getPoints() {
            return points;
        }
    }

    public Exam(String name, int year) {
        this.name = name;
        this.year = year;
        this.questions = new ArrayList<Question>();
    }

    public void AddQuestion (String text, int points) {
        questions.add(new Question(text, points));
    }

    public ArrayList getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public int getSumOfPoints() {
        int sum = 0;
        for (int i = 0; i < questions.size(); i++ ) {
            sum += questions.get(i).points;
        }
        return sum;
    }

    public void orderQuestionsByLength() {
        Collections.sort(questions);
    }

    public void orderQuestionByPoints() {

    }

}
