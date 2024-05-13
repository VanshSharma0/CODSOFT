import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Quiz {

    static final int TIME_PER_QUESTION = 10; 

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

       System.out.println("\n");
        Question[] questions = {
                new Question("Who won the FIDE Candidates Chess Tournaments 2024?", "A. Gukesh D", "B. Hikaru Nakamura", "C. Alireza Firouzja", "D. Levy Rozman", "A"),
                new Question("Which team won the Indian premier league (IPL) in 2023?", "A. Mumbai Indians", "B. Chennai Super Kings", "C. Gujarat Titans","D. Kolkata Knight Riders", "B"),
                new Question("Who created 'Facebook'?", "A. Mark Zuckerberg", "B. Charles Dickens", "C. Matt Stonie", "D. Rey Mysterio", "A"),
        };

        for (Question question : questions) {
            System.out.println("\n");
            score += askQuestion(scanner, question);
        }

        System.out.println("===========");
        System.out.println("Final Score: " + score + "/" + questions.length);
        System.out.println("===========");
        scanner.close();
    }

    private static int askQuestion(Scanner scanner, Question question) throws InterruptedException {
        System.out.println(question.getText());
        System.out.println(question.getOptionA());
        System.out.println(question.getOptionB());
        System.out.println(question.getOptionC());
        System.out.println(question.getOptionD());
    
        AnswerThread answerThread = new AnswerThread();
        answerThread.start();
    
        System.out.print("Enter your answer (A-D): ");
        String answer = scanner.nextLine().toUpperCase();
    
        answerThread.interrupt();
    
        if (answer.equals(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
            return 0;
        }
    }
    
}

class Question {
    private final String text;
    private final String optionA;
    private final String optionB;
    private final String optionC;
    private final String optionD;
    private final String correctAnswer;

    public Question(String text, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class AnswerThread extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(Quiz.TIME_PER_QUESTION);
            System.out.println("Time's Up!");
            return;
        } catch (InterruptedException e) {
        }
    }
}

