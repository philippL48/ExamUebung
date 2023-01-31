import java.io.*;
import java.io.IOException;
import java.io.Reader;
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

    public void save() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("configTest.txt")); //
            writer.write(name);
            writer.newLine();
            writer.write(Integer.toString(year));
            writer.newLine();
            writer.write(Integer.toString(questions.size() ));
            writer.newLine();
            for (int i = 0; i < questions.size(); i++ ) {
                writer.write(questions.get(i).text);
                writer.newLine();
                writer.write(Integer.toString(questions.get(i).points));
                writer.newLine();
            }



        } catch (IOException e) {
            System.err.println("Beim Erstellen der Datei ist ein Fehler aufgetreten.");
        } finally {
            if (writer != null) {
                try { writer.close(); } catch (Exception e) {e.printStackTrace();}
            }
        }
    }

    public boolean load() {
        questions.removeAll(questions);
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader("config.txt"));
            name = bufferedReader.readLine();
            bufferedReader.readLine();
            String questionString;
            String pointString;
            while (( questionString = bufferedReader.readLine()) != null) {
                    //questionString = bufferedReader.readLine();
                    pointString = bufferedReader.readLine();
                    questions.add( new Question( questionString, Integer.parseInt(pointString) ) );
            }

        } catch (FileNotFoundException e) {
            System.err.println("Datei konnte nicht gefunden werden.");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.err.println("Datei konnte nicht gelesen werden.");
            e.printStackTrace();
            return false;
        }


        return true;
    }

    public boolean load() {
        /*Reader reader = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        }

        try {
            BufferedReader rd = new BufferedReader(new FileReader("C://config.txt"));
            name = rd.readLine();
            year = Integer.parseInt(rd.readLine());
            //int points = Integer.parseInt(rd.readLine());

            String line = rd.readLine();
            while (line != null) {

            }



        } catch (IOException e) {
            System.err.println("Datei konnte nicht gelesen werden.");
            e.printStackTrace();
        }

        }

    }



    public void save() {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C://config.txt")));
        }
    }
}
