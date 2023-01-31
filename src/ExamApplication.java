public class ExamApplication {
    public static void main(String args[]) {
        Exam EiP = new Exam("EinführungInDieProgrammierung",  2022);
        EiP.AddQuestion("Implementieren sie das UML-Diagramm in Java.", 12);
        EiP.AddQuestion("Ist folgender Algorithmus determiniert, deterministisch oder beides?", 2);
        EiP.orderQuestionByPoints();
    }
}
