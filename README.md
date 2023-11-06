# Palindrome-Game

##Description
Java project that prompts the user to enter palindromes in a gamified way. The program utilizes Java’s Scanner class and scores them on their ability to identify palindromes, whether that be a word, number, or phrase. The code employs a combination of linked-list-based stack and queue data structures; along with a variety of conditional statements.

##Features
- User Interaction: Using Java's Scanner class allows users to enter their potential palindromes and choose when they'd like to play or stop playing.

- Scoring Mechanism: Players are granted a score on how many correctly identified palindromes they enter within 5 attempts, with scores accumulating over multiple attempts. Additionally, the program in the background keeps track of the user's highest score throughout the session.

- Efficient Palindrome Verification: The game determines if any given input is a palindrome using a combination of linked-list based stack and queue data structures. The program implements pushing characters onto the stack and likewise inserting onto the queue. The game then compares these characters by popping and dequeuing them off the stack and queue respectively.

- Feedback System: Based on the player's high score, the game provides conditional feedback based on how they performed.

- Robust Error Handling: The program manages incorrect inputs or empty sequences.
