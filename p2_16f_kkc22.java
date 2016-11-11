/*
Kevin Chan
kkc22
*/
package project2;

import java.util.ArrayList;
import java.util.Scanner;

public class p2_16f_kkc22 {
    
    public static void main(String[] args) {
        p2_16f_kkc22 p2 = new p2_16f_kkc22();
        Scanner scanner = new Scanner(System.in);
        String answer;
        String input;
        boolean valid = true;
        int counter = 1;
        
        /*
        Asks the user if s/he wants to enter a string
        The user then enters "y" for "yes", or "no" for "no"
        If the user enters "n", then the program terminates
        If the user enters "y", then the user is prompted to enter a string over Σ
        
        The user chooses to input a string & the program then reads in the string
        After reading the string, the program prints it
        The program processes the string in the PDA
        
        After completing the processing of the string,
        The program indicates if the string is accepted or rejected
        The program returns to step 1
        */
        while(valid){
            System.out.print("Do you want to enter a string? Enter 'y' for yes or 'n' for no: ");
            answer=(scanner.next());
            
            switch(answer){
                case "y":
                    System.out.print("Enter string: ");
                    input=(scanner.next());
                    System.out.println("");
                    System.out.println("Your string #" + counter + " is: " + input);    //Gives Test Case Number
                    p2.reset();             //calls reset function
                    p2.usePDA(input);       //calls usePDA function
                    counter++;
                    break;
                case "n":
                    System.out.println("End program");
                    System.exit(0);
                default:
                    System.out.println("Invalid answer");   //if 'y' or 'n' is not an answer
                    break;
            }
        }
    }   
    
    //States in the PDA
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private int currentState;
    
    //Cases for the states in the PDA
    static private int cases(int x, char y){
        switch(x){
            case q1: switch(y){ //reads in $
                case '$': return q2;
                default: return q1;
            }
            case q2: switch(y){ //reads in V(C), V(N), left paren
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'w': case 'x': case 'y': case 'z': case '_': case 'A':
                case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
                case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O':
                case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': 
                case 'W': case 'X': case 'Y': case 'Z': 
                return q5;
                case '0': case '1': case '2': case '3': case '4': 
                case '5': case '6': case '7': case '8': case '9':
                return q3;
                case '(': return q4; 
                default: return q1;
            }
            case q3: switch(y){ //reads in V(N), operands, right paren, $
                case '0': case '1': case '2': case '3': case '4': 
                case '5': case '6': case '7': case '8': case '9':
                return q3;
                case '+': case '-': case '*': case '/': return q6;
                case ')': return q7;
                case '$': return q8;
                default: return q1;
            }
            case q4: switch(y){ //reads in V(C), V(N), left paren
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'w': case 'x': case 'y': case 'z': case '_': case 'A':
                case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
                case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O':
                case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': 
                case 'W': case 'X': case 'Y': case 'Z': 
                return q5;
                case '0': case '1': case '2': case '3': case '4': 
                case '5': case '6': case '7': case '8': case '9':
                return q3;
                case '(': return q4;
                default: return q1;
            }
            case q5: switch(y){ //reads in V(C), V(N), operands, right paren, $
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'w': case 'x': case 'y': case 'z': case '_': case 'A':
                case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
                case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O':
                case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': 
                case 'W': case 'X': case 'Y': case 'Z': case '0': case '1': case '2': 
                case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                return q5;
                case '+': case '-': case '*': case '/': return q6;
                case ')': return q7;
                case '$': return q8;
                default: return q1;
            }
            case q6: switch(y){ //reads in V(C), V(N), left paren
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': 
                case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': 
                case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': 
                case 'v': case 'w': case 'x': case 'y': case 'z': case '_': case 'A':
                case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
                case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O':
                case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': 
                case 'W': case 'X': case 'Y': case 'Z': 
                return q5;
                case '0': case '1': case '2': case '3': case '4': 
                case '5': case '6': case '7': case '8': case '9':
                return q3;
                case '(': return q4;
                default: return q1;
            }
            case q7: switch(y){ //reads in right paren, operands, $
                case ')': return q7;
                case '+': case '-': case '*': case '/': return q6;
                case '$': return q8;
                default: return q1;
            }
            case q8: switch(y){ //end state
                default: return q1;
            }
            default: return q1;
        }
    }
    
    public void reset(){
        currentState = q1;
    }

    //uses PDA
    public void usePDA(String in){
        boolean checkState = false;
        ArrayList<String> popStack = new ArrayList<>();     //array of popped variables in stack
        ArrayList<String> pushStack = new ArrayList<>();    //array of pushed varaibles in stack
        
        //reads each character of the string
        for(int i=0; i<in.length(); i++){
            char ch = in.charAt(i);
            currentState = cases(currentState,ch);      //determines what state the character is in 
            
            //Prints the current char, current state, popped symbol, pushed symbol
            if(ch == '$' && currentState == q2){
                System.out.println("Char: " + ch + " in state: " + currentState 
                    + " popped symbol: ε" + " pushed symbol: $" );
                pushStack.add("$");
            } else if(ch == '('){
                System.out.println("Char: " + ch + " in state: " + currentState 
                    + " popped symbol: ε" + " pushed symbol: T" );
                pushStack.add("T");
            } else if(ch == ')'){
                System.out.println("Char: " + ch + " in state: " + currentState 
                    + " popped symbol: T" + " pushed symbol: ε" );
                popStack.add("T");
            } else if(ch == '$' && currentState == q8){
                System.out.println("Char: " + ch + " in state: " + currentState 
                    + " popped symbol: $" + " pushed symbol: ε" );
                popStack.add("$");
            } else{
                System.out.println("Char: " + ch + " in state: " + currentState 
                    + " popped symbol: ε" + " pushed symbol: ε" );
            }
            
            //If case fails and becomes default (q1 = 1), set checkState to true
            //Will be used to fail a string & print if symbol crashes the program
            if(currentState == 1){
                checkState = true;
                System.out.println("Crash at character #" + i + ": " + ch);
                break;
            }
            //When checkState = true, fails the string & doesn't accept it
            //When checkState = false, passes the string & accepts it
        }
        
        /*
        Set checkState to false only if: 
        -popStack contains all variables of pushStack
        -pushStack contains all varaibles of popStack
        -if pushStack size & popStack size are equal
        
        Otherwise, it is true
        */
        boolean failure = !(popStack.containsAll(pushStack) && pushStack.containsAll(popStack)
                && pushStack.size() == popStack.size());
        
        //Prints if the string is to be accepted or rejected
        if(checkState){
            System.out.println("String is not accepted: Does not follow specifications");
        } else if(failure){
            System.out.println("String is not accepted: Stack is not empty");
            
        } else if(currentState == 8 && checkState == false){
            System.out.println("String is accepted");
        } else if(currentState != 8){
            System.out.println("String is not accepted: Does not reach accept state");
        } else if(currentState == 8 && checkState){
            System.out.println("String is not accepted: Does not follow specifications");
        }
        System.out.println(""); //Extra line of space to keep everything organized
    }
        
}
