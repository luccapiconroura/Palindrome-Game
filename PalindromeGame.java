import java.util.Scanner;

public class PalindromeGame {

    public static int highScore = 0;

    
    public static void main(String[] args) {
        /*
         * does the actual running of the palindrome game. keeps playing until the users quits out of the game. 
         */
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            int currentScore = palindromeChecker(sc);

            if (currentScore >= highScore) {
                highScore = currentScore;
            }
            
            System.out.println("Your current score is: " + currentScore);
            System.out.println("Your highscore is: " + highScore + "!! ");
            if(highScore == 5){
                System.out.println("That's a perfect score!!");
            }
            System.out.println("------------------------------");
            System.out.println("Type 'Go' to play again or anything else to quit!");
            choice = sc.nextLine().trim().toLowerCase();

        } while (choice.equals("go"));

        System.out.println("Sad to see you go :( Your highest score was: " + highScore);
        if(highScore <= 2){
            System.out.println("You definitely could've done better...");
        } else if (highScore <= 4){
            System.out.println("You did okay I guess..");
        } else { System.out.println("Perfect score.. woohoo");}
        sc.close();
    }

    private static int palindromeChecker(Scanner sc) {
        /*
         * this method does the actual checking of the user's input and calls the necessary methods to do so. 
         */
        int score = 0;
        int attempts = 5;

        System.out.println("Welcome to the super fun Palindrome Game!");
        System.out.println("You have " + attempts + " attempts to come up with a palindrome.");
        System.out.println("For each correct palindrome you come up with, you'll score exactly one point.");
        System.out.println("------------------------------");

        for (int i = 0; i < attempts; i++) {
            System.out.println("Enter your word, number, or phrase (Attempt " + (i + 1) + "): ");
            String input = sc.nextLine();

            if (isPal(input)) {
                score += 1;
                System.out.println("Correct! That's definitely a palindrome.");
            } else {
                System.out.println("Sorry, that is unfortunately not a palindrome..");
            }
        }

        System.out.println("------------------------------");
        return score;
    }

    public static boolean isPal(String str){
        /*
         * palindrome checker using stack and queues. 
         */

        int strLength = str.length();
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (strLength == 0 || strLength == 1) {
            return true;
        }
    
        LLStack stack = new LLStack();
        LLQueue queue = new LLQueue();
    
        for (int i = 0; i < strLength; i++) {
            char ch = str.charAt(i);
            ch = Character.toLowerCase(ch);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch);
                queue.insert(ch);
            }
        }
    
        while (!stack.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.remove();
            if (stackChar != queueChar) {
                return false;
            }
        }
        return true;
    }

    static class Node {
        char data;
        Node next;
        
        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LLStack {
        private Node top;

        public LLStack() {
            this.top = null;
        }

        public void push(char data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            char data = top.data;
            top = top.next;
            return data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    static class LLQueue {
        private Node front, rear;

        public LLQueue() {
            this.front = this.rear = null;
        }

        public void insert(char data) {
            Node newNode = new Node(data);

            if (this.rear == null) {
                this.front = this.rear = newNode;
                return;
            }

            this.rear.next = newNode;
            this.rear = newNode;
        }

        public char remove() {
            char data = front.data;
            front = front.next;
            
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }
}
