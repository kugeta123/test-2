/* front.java - a lexical analyzer system for simple
 arithmetic expressions */
//package tool;
 
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


import java.util.*;

/* main driver */
public class front {
    /* Global declarations */
    /* Variables */
    /* Character classes */
    /*define LETTER 0
    define DIGIT 1
    define UNKNOWN 99*/

    /* Token codes */
    /*define INT_LIT 10
    define IDENT 11
    define ASSIGN_OP 20
    define ADD_OP 21
    define SUB_OP 22
    define MULT_OP 23
    define DIV_OP 24
    define LEFT_PAREN 25
    define RIGHT_PAREN 26*/

    public static int charClass;
    public static char lexeme[] = new char[100];
    public static char nextChar;
    public static int lexLen;
    public static int token;
    public static int nextToken;
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';
    private static final char ADD_OP     = '+';
    private static final char SUB_OP    = '-';
    private static final char MULT_OP     = '*';
    private static final char DIV_OP    = '/';
    //private static final char LEFT_BRACKET   = '[';
    //private static final char RIGHT_BRACKET  = ']';

    //FILE *in_fp;

    /* Function declarations */
    //public int lookup(char ch);
    //public void addChar();
    //public void getChar();
   // public void getNonBlank();
    //public int lex();

    public static void main (String[] args) {
 /* Open the input data file and process its contents */
     File f=new File("front.in", "r"); //Creation of File Descriptor for input file
     if (f.length() == 0) {
         System.out.println("ERROR - cannot open front.in"); }
        else {
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;             
        while((c = br.read()) != -1)         //Read char by Char
        {
            char character = (char) c;          //converting integer to char
            System.out.println(character);        //Display the Character
        }
            
        }
     
     ///File newFile = new File("front.in", "r");
     //if (newFile.length() == 0) {
      //   System.out.println("ERROR - cannot open front.in"); }
        //else {
     //getChar();
     
     //do {
   //lex();
     //} while (nextToken != EOF);
 

    }


    /* lookup - a function to look up operators and
    parentheses and return the token */
    public int lookup(char ch) {
        switch (ch) {
     case '(':
         addChar();
         nextToken = LEFT_PAREN;
  break;
     case ')':
  addChar();
  nextToken = RIGHT_PAREN;
  break;
     case '+':
  addChar();
  nextToken = ADD_OP;
  break;
     case '-':
  addChar();
  nextToken = SUB_OP;
  break;
     case '*':
  addChar();
  nextToken = MULT_OP;
  break;
     case '/':
  addChar();
  nextToken = DIV_OP;
  break;
     default:
  addChar();
  nextToken = EOF;
  case StreamTokenizer.TT_EOF:
                  System.out.println("End of File encountered.");
                  eof = true;
                  break;
  break;
 }
 return nextToken;
    }



    /* addChar - a function to add nextChar to lexeme */
    public void addChar() {
 if (lexLen <= 98) {
     lexeme[lexLen++] = nextChar;
     lexeme[lexLen] = '\0';
 } else {
     printf("Error - lexeme is too long \n");
        }
    }



    /* getChar - a function to get the next character of
    input and determine its character class */
    public void getChar() {
 if ((nextChar = getc(in_fp)) != EOF) {
            if (isalpha(nextChar)) {
         charClass = LETTER;
     } else if (isdigit(nextChar)) {
  charClass = DIGIT;
            } else {
  charClass = UNKNOWN;
            }
 } else {
      charClass = EOF;
  }
    }




    /* getNonBlank - a function to call getChar until it
    returns a non-whitespace character */
    public void getNonBlank() {
        while (isspace(nextChar))
 getChar();
    }


    /* lex - a simple lexical analyzer for arithmetic
    expressions */
    public int lex() {
        lexLen = 0;
 getNonBlank();
 switch (charClass) {
     /* Identifiers */
     case LETTER:
         addChar();
  getChar();
  while (charClass == LETTER || charClass == DIGIT) {
      addChar();
      getChar();
  }
         nextToken = IDENT;
  break;
  /* Integer literals */
  case DIGIT:
      addChar();
      getChar();
      while (charClass == DIGIT) {
          addChar();
   getChar();
      }
      nextToken = INT_LIT;
      break;
   /* Parentheses and operators */
   case UNKNOWN:
       lookup(nextChar);
       getChar();
       break;
   /* EOF */
   case EOF:
              nextToken = EOF;
       lexeme[0] = 'E';
       lexeme[1] = 'O';
       lexeme[2] = 'F';
       lexeme[3] = '\0';
       break;
     } /* End of switch */
 printf("Next token is: %d, Next lexeme is %s\n",
 nextToken, lexeme);
 return nextToken;
    }
}
 /* End of function lex */