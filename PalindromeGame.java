import java.util.Scanner;

public class PalindromeGame {

    public static int highScore = 0;

    
    public static void main(String[] args) {
        /**
        * the main method is running the actual palindrome game. it asks the user to enter a string, and calls methods to check if it's a palindrome. 
        * the user can play the game as many times as they want and the highScore variable keeps track of their highscore over the course of the session.
        * the program ends when the user chooses to quit by typing anything but "go" after their game. 
        */
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            /*
             * this loop is running the game. it calls the palindromeChecker method and keeps track of the user's highscore.
             */
            int currentScore = palindromeChecker(sc);

            if (currentScore >= highScore) {
                /*
                 * checker for if the user's current score is higher than their highscore. if it is, the highscore is updated.
                 */
                highScore = currentScore;
            }
            
            System.out.println("Your current score is: " + currentScore);
            System.out.println("Your highscore is: " + highScore + "!! ");
            if(highScore == 5){
                /*
                 * if the user gets a perfect score, the user gets a cookie.
                 */
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
         * this method is the actual palindrome game. it asks the user to enter a string, number, or phrase, and calls methods to check if it's a palindrome.
         */
        int score = 0;
        int attempts = 5;

        System.out.println("Welcome to the super fun Palindrome Game!");
        System.out.println("You have " + attempts + " attempts to come up with a palindrome.");
        System.out.println("For each correct palindrome you come up with, you'll score exactly one point.");
        System.out.println("------------------------------");

        for (int i = 0; i < attempts; i++) {
            /*
             * this loop is running the game. it first asks the user to enter a string, number, or phrase, and then calls methods to check if what the user inputted is a palindrome.
             */
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
         * this method checks if the string is a palindrome using a stack and queue to compare the characters in the string.
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
            /*
             * this loop pushes/inserts the characters in the string onto the stack and queue, but only if they are letters or digits.
             */
            char ch = str.charAt(i);
            ch = Character.toLowerCase(ch);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch);
                queue.insert(ch);
            }
        }
    
        while (!stack.isEmpty()) {
            /*
             * this loop is doing the actual "comparing", it pops/removes the characters from the stack and queue and compares them to see if they are equal or not.
             */
            char stackChar = stack.pop();
            char queueChar = queue.remove();
            if (stackChar != queueChar) {
                return false;
            }
        }
        /*
         * if the characters are equal, the method returns true, otherwise it returns false.
         */
        return true;
    }

    static class Node {
        /*
         * this is the node class for the linked list stack and queue.
         */

        char data;
        Node next;
        
        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LLStack {
        /*
         * this is the linked list stack class. it has methods to push and pop characters onto the stack, and to check if the stack is empty.
         */
        private Node top;

        public LLStack() {
            /*
             * constructor
             */
            this.top = null;
        }

        public void push(char data) {
            /*
             * pushes character onto the stack
             */
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public char pop() {
            /*
             * pops/removes character from the stack
             */
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            char data = top.data;
            top = top.next;
            return data;
        }

        public boolean isEmpty() {
            /*
             *  checks the stack to see if it's empty
             */
            return top == null;
        }
    }

    static class LLQueue {
        /*
         * queue class. it has methods to insert and remove characters from the queue.
         */
        private Node front, rear;

        public LLQueue() {
            /*
             * constructor
             */
            this.front = this.rear = null;
        }

        public void insert(char data) {
            /*
             * inserts character into the queue
             */
            Node newNode = new Node(data);

            if (this.rear == null) {
                /*
                 * if the queue is empty, both the front and rear are the new node
                 */
                this.front = this.rear = newNode;
                return;
            }

            this.rear.next = newNode;
            this.rear = newNode;
        }

        public char remove() {
            /*
             * removes character from the queue
             */
            char data = front.data;
            front = front.next;
            
            if (front == null) {
                /*
                 * if the queue is empty, the rear is then also null
                 */
                rear = null;
            }
            /*
             * returns the character that was removed
             */
            return data;
        }
    }
}
