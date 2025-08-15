import java.util.*;

class Question {
    String question;
    List<String> options;
    int correctOption; // 1-based index

    Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prepare questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What are Java loops?",
                Arrays.asList("Control structures to repeat tasks", "A data type", "An exception", "A library"), 1));

        questions.add(new Question("What is enhanced for-loop?",
                Arrays.asList("A loop for iterating collections/arrays", "A faster while loop", "A nested loop", "None of these"), 1));

        questions.add(new Question("How do you handle multiple user inputs?",
                Arrays.asList("Using multiple Scanners", "Using loops and a single Scanner", "By creating multiple main methods", "You cannot"), 2));

        questions.add(new Question("How is switch-case different from if-else?",
                Arrays.asList("Switch is faster & works with fixed values", "If-else works only for strings", "Both are identical", "Switch handles only integers"), 1));

        questions.add(new Question("What are collections in Java?",
                Arrays.asList("Group of objects like List, Set, Map", "Only arrays", "Database tables", "Java files"), 1));

        questions.add(new Question("What is ArrayList?",
                Arrays.asList("Resizable array in Java", "A database", "A file list", "None"), 1));

        questions.add(new Question("How to iterate using iterators?",
                Arrays.asList("Use hasNext() and next()", "Use size() and get()", "Use a for loop only", "You cannot"), 1));

        questions.add(new Question("What is a Map?",
                Arrays.asList("Key-Value data structure", "An image", "A chart", "None"), 1));

        questions.add(new Question("How to sort a list?",
                Arrays.asList("Collections.sort()", "Arrays.sort()", "list.sort()", "All of these"), 4));

        questions.add(new Question("How to shuffle elements?",
                Arrays.asList("Collections.shuffle()", "Arrays.shuffle()", "Random.shuffle()", "None"), 1));

        // Quiz start
        int score = 0;
        System.out.println("===== Welcome to the Java Quiz =====\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.question);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println("   " + (j + 1) + ". " + q.options.get(j));
            }

            int answer = 0;
            while (true) {
                System.out.print("Your answer (1-" + q.options.size() + "): ");
                if (sc.hasNextInt()) {
                    answer = sc.nextInt();
                    if (answer >= 1 && answer <= q.options.size()) break;
                } else {
                    sc.next(); // discard invalid input
                }
                System.out.println("Invalid choice. Try again.");
            }

            if (answer == q.correctOption) {
                score++;
                System.out.println(" Correct!\n");
            } else {
                System.out.println(" Wrong! Correct answer: " + q.correctOption + ". " + q.options.get(q.correctOption - 1) + "\n");
            }
        }

        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());
        if (score >= 8) {
            System.out.println(" Excellent work!");
        } else if (score >= 5) {
            System.out.println(" Good effort, keep practicing!");
        } else {
            System.out.println(" You need more practice.");
        }

        sc.close();
    }
}


