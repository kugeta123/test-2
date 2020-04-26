import java.util.*;
import java.io.File; 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class front {

    public static char charClass;
    public static char lexeme[] = new char[100];
    public static char nextChar;
    public static int lexLen;
    public static int token;
    public static int nextToken;
    private static final char pleft = '(';
    private static final char pright = ')';
    private static final char add = '+';
    private static final char sub = '-';
    private static final char multi = '*';
    private static final char div = '/';


    public static void main (String[] args) {
        File f=new File("front.in", "r"); 

        if (f.length() == 0) {
            System.out.println("ERROR - cannot open front.in"); }
            else {
	        getChar();
	        do {
	 	    lex();
	        } while (!f.hasNext());
	    }
        }
     
        public int lookup(char ch) {
            switch (ch) {
                case '(':
                    addChar();
                    nextToken = pleft;
                    break;
                case ')':
                    addChar();
                    nextToken = pright;
                    break;
                case '+':
                    addChar();
                    nextToken = add;
                    break;
                case '-':
                    addChar();
                    nextToken = sub;
                    break;
                case '*':
                    addChar();
                    nextToken = multi;
                    break;
                case '/':
                    addChar();
                    nextToken = div;
                    break;
                default:
                    addChar();
                    break;
                }
            return nextToken;
        }
    
        public void addChar() {
             if (lexLen <= 98) {
                 lexeme[lexLen++] = nextChar;
                 lexeme[lexLen] = '\0';
             } else {
                 System.out.println("Error - lexeme is too long \n");
             }
        }

        public void getChar() {
            nextChar = getc(in_fp);
            if (!Objects.isNull(nextChar)) {
                if (Character.isAlphabetic(nextChar)) {
                    charClass = 'L';
                } else if (Character.isDigit(nextChar)) {
                    charClass = 'D';
                } else {
                    charClass = 'U';
                }
            } else {
                charClass = 'E';
            }
        }

        public void getNonBlank() {
             while (Character.isWhitespace(nextChar))
                 getChar();
        }

        public int lex() {
            lexLen = 0;
            getNonBlank();
            switch (charClass) {

                case 'L':
                    addChar();
                    getChar();
                    while (Character.isLetter(charClass) || Character.isDigit(charClass)) {
                        addChar();
                        getChar();
                    } 
                    nextToken = IDENT;
                    break;
  
                case 'D':
                    addChar();
                    getChar();
                    while (Character.isDigit(charClass)) {
                        addChar();
                        getChar();
                    }
                    nextToken = INT_LIT;
                    break;

                case 'U':
                    lookup(nextChar);
                    getChar();
                    break;
                return nextToken;
            }
        }
    
}/
