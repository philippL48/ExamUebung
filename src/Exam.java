import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        @Override
        public String toString() {
            return "Question{" +
                    "text='" + text + '\'' +
                    ", points=" + points +
                    '}';
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

    public List<Question> getQuestions() {
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
        Collections.sort(questions, new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o1.getText().length() - o2.getText().length();
            }
        });
    }

    public void orderQuestionByPoints() {
        Collections.sort(questions, (q1, q2) -> q1.getPoints() - q2.getPoints()); //??
    }

    @Override
    public String toString() {
        return "Exam{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", questions=" + questions +
                '}';
    }
}
