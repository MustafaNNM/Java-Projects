/*
 * calc2.java
 * 
 * Public License Agreement: You CANNOT use this program for ANYTHING! 
 * This program is a work-in-progress. The only reason I'm giving it 
 * away (with source) is because I'm a nice guy. You cannot sell it, 
 * and may only look at the code; ANY other use should be consulted 
 * with Particle directly (particle at NO SPAM the particle dot com)! You cannot distribute 
 * it either (in ANY form), you can however redirect people to the site 
 * where you got it (which is probably Particle's site).
 * 
 * This Agreement is VERY restrictive, and should be respected. This 
 * program is part of Prof.Phreak, which is a commercial product (or will 
 * be one), thus, this agreement means business. The source of the program 
 * (which you can compile under Java) is only here to illustrate some innovative 
 * thinking taken in constructing Prof.Phreak (kind of like an advertisement).
 * 
 * Now, after scarring you a bit, I just wanted to mention that I'm totally 
 * not responsible for ANYTHING BAD that the program does. However, I take 
 * full responsibility for whatever stuff you like about the program. 
 * (i.e.: If it's bad, don't blame me, if it's good, thank me.)
 *
 * Copyright(c) 1998-1999, Particle
 */

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.math.*;

/**
 * a word calculator class
 * 
 * @version 2.0b
 */
public class calc2 extends Applet{
        
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
         * text area for expression
         */
        private TextArea expression = null;
        
        /**
         * text area for the answer
         */
        private TextArea answer = null;
        
        /**
         * clear button
         */
        private Button clear = null;
        
        /**
         * enter button
         */
        private Button enter = null;
        
        /**
         * static arrays of word prepresentation of numbers
         */
        private static String[] numericalWords = {"zero","one","two","three","four",
                                                                           "five","six","seven","eight","nine",
                                                                           "ten","eleven","twelve","thirteen",
                                                                           "fourteen","fifteen","sixteen",
                                                                           "seventeen","eighteen","nineteen",
                                                                           "twenty","thirty","forty","fifty",
                                                                           "sixty","seventy","eighty","ninety",
                                                                           "hundred","thousand","million",
                                                                           "billion","trillion","quadrillion",
                                                                                "quintillion","sextillion","septillion",
                                                                                "octillion","nonillion","decillion",
                                                                                "undecillion","duodecillion","tredecillion",
                                                                                "quattuordecillion","quindecillion",
                                                                                "sexdecillion","septendecillion",
                                                                                "octodecillion","novemdecillion",
                                                                                "vigintillion","negative"};
                /* and centillion = 10^303 */
        
        /**
         * numerical representation of words above.
         */
        private static BigInteger[] numericalNumbers = null;
        static{
                numericalNumbers = new BigInteger[numericalWords.length];
                int i,j;
                for(i=0;i<20;i++)
                        numericalNumbers[i] = BigInteger.valueOf(i);
                
                for(j=i;j<=100;j+=10,i++)
                        numericalNumbers[i] = BigInteger.valueOf(j);
                
                for(BigInteger bigint = BigInteger.valueOf(1000);
                        i<numericalNumbers.length-1;
                        bigint = bigint.multiply(BigInteger.valueOf(1000)),i++){
                        numericalNumbers[i] = bigint;
                }
                numericalNumbers[i] = BigInteger.valueOf(-1);                                                                                                                            
        }
        
        /**
         * finds the number in the array or -1 if not there.
         * 
         * @param n The BigInteger to search for
         * @return the location inside numericalWords array
         */
        private static int findNumber(BigInteger n){
                for(int i=0;i<numericalNumbers.length;i++)
                        if(n.equals(numericalNumbers[i]))
                                return i;
                return -1;      
        }
                
        /**
         * returns the location of a string in numericalWords or -1 if
         * not found.
         * 
         * @param s The string representation of a number element
         * @return the location inside numericalNumbers array
         */
        private static int findString(String s){
                for(int i=0;i<numericalWords.length;i++)
                        if(s.equals(numericalWords[i]))
                                return i;
                return -1;                      
        }

        /**
         * inserts number elements onto a vector. Numbers upto 
         * one thousand.
         * 
         * @param n The number to "write"
         * @param v the Vector where to insert the numbers
         */
        public static void _writeNumber2Word(int n,Vector v){
                int result = n % 100;
                n /= 100;
                if(n != 0){             
                        _writeNumber2Word(n,v);
                        v.addElement(numericalWords[findNumber(BigInteger.valueOf(100))]);
                }
                if(result <= 20 && result != 0)
                        v.addElement(numericalWords[findNumber(BigInteger.valueOf(result))]);
                else if(result == 0){
                        /* don't write the zero */
                }else{
                        int mod = result % 10;
                        if((result - mod) != 0)
                                v.addElement(numericalWords[findNumber(BigInteger.valueOf(result - mod))]);
                        if(mod != 0)
                                v.addElement(numericalWords[findNumber(BigInteger.valueOf(mod))]);
                }
        }
        
        /**
         * writes a BigInteger number to an array (puts number elements
         * onto the vector, in String form)
         * NOTE: initial divider should be 1000!
         * 
         * @param n The big integer to write
         * @param divider The divider to use (initial value must be 1000)
         * @param v A Vector where to write the words
         * @return boolean value representing whether anything was written
         */
        public static boolean writeNumber2Word(BigInteger n,BigInteger divider,Vector v){                                       
                if(n.compareTo(BigInteger.valueOf(0)) < 0){
                        v.addElement(numericalWords[findNumber(BigInteger.valueOf(-1))]);
                        n = n.negate();
                }
                int result = (n.mod(BigInteger.valueOf(1000))).intValue();
                n = n.divide(BigInteger.valueOf(1000));
                if(!n.equals(BigInteger.valueOf(0))){
                        if(writeNumber2Word(n,divider.multiply(BigInteger.valueOf(1000)),v)){
                                int index = findNumber(divider);
                                if(index >= 0)
                                        v.addElement(numericalWords[index]);
                        }
                }
                if(result != 0 || (n.equals(BigInteger.valueOf(0)) && divider.equals(BigInteger.valueOf(1000)))){
                        _writeNumber2Word(result,v);
                        return true;
                }
                return false;
        }
        
        /**
         * evaluate a postfix expression... the resulting value is 
         * the first one in the vector.
         * 
         * @param v the expression to solve
         * @return if not null, then a string with error explanation
         */
        private String solvePostFixExpression(Vector v){
                Vector stack = new Vector();
                Enumeration enum = v.elements();                
                while(enum.hasMoreElements()){
                        Object o = enum.nextElement();
                        if(o instanceof BigInteger){
                                BigInteger integer = (BigInteger)o;
                                stack.addElement(integer);
                        }else if(o instanceof String){
                                String string = (String)o;
                                if(stack.isEmpty())
                                        return new String("Empty Stack: Postfix Error");
                                BigInteger a = (BigInteger)(stack.lastElement());
                                stack.removeElementAt(stack.size()-1);
                                if(stack.isEmpty())
                                        return new String("Empty Stack: Postfix Error");
                                BigInteger b = (BigInteger)(stack.lastElement());
                                stack.removeElementAt(stack.size()-1);
                                if(string.equals("+"))
                                        stack.addElement(b.add(a));
                                else if(string.equals("-"))
                                        stack.addElement(b.subtract(a));
                                else if(string.equals("*"))
                                        stack.addElement(b.multiply(a));
                                else if(string.equals("/"))
                                        stack.addElement(b.divide(a));
                                else
                                        return new String("Undefined operation: "+string);
                        }else{
                                return new String("Internal Error in Postfix Expression");
                        }
                }
                if(stack.isEmpty())
                        return new String("Stack Underflow");
                BigInteger ans = (BigInteger)stack.lastElement();
                stack.removeElementAt(stack.size()-1);
                if(!stack.isEmpty())
                        return new String("No Answer on Stack");
                v.removeAllElements();
                v.addElement(ans);
                return null;
        }
        
        /**
         * convert an infix expression to post fix
         * 
         * @param v Vector representing expression which to convert to post-fix
         * @return if not null, then string explaining the error
         */
        private String infixToPostfix(Vector v){
                Vector in = new Vector();
                Enumeration v_enum = v.elements();
                while(v_enum.hasMoreElements())
                        in.addElement(v_enum.nextElement());
                v.removeAllElements();
                Vector stack = new Vector();
                Enumeration enum = in.elements();
                while(enum.hasMoreElements()){
                        Object o = enum.nextElement();
                        if(o instanceof BigInteger){
                                v.addElement(o);                                
                        }else if(o instanceof String){
                                String s = (String)o;                           
                                
                                if(s.equals("+") || s.equals("-") || 
                                   s.equals("*") || s.equals("/")){
                                        if(stack.isEmpty())
                                                stack.addElement(s);
                                        else{
                                                String sp = (String)stack.lastElement();
                                                stack.removeElementAt(stack.size()-1);
                                                if(sp.equals("(") || sp.equals(")")){
                                                        stack.addElement(sp);
                                                        stack.addElement(s);
                                                }else{
                                                        if((sp.equals("+") || sp.equals("-")) &&
                                                           (s.equals("*") || s.equals("/"))){
                                                                stack.addElement(sp);
                                                                stack.addElement(s);
                                                        }else{
                                                                stack.addElement(s);
                                                                v.addElement(sp);
                                                        }
                                                }
                                        }
                                }else if(s.equals("(") || s.equals(")")){
                                        if(s.equals("("))
                                                stack.addElement(s);
                                        else if(s.equals(")")){
                                                while(!stack.isEmpty()){
                                                        String sp = (String)stack.lastElement();
                                                        stack.removeElementAt(stack.size()-1);
                                                        if(!sp.equals("("))
                                                                v.addElement(sp);
                                                        else    break;
                                                }
                                        }       
                                }else
                                        return new String("Expression Error");  
                        }
                }
                while(!stack.isEmpty()){
                        v.addElement(stack.lastElement());
                        stack.removeElementAt(stack.size()-1);
                }
                return null;
        }
        
        /**
         * check the parenthesis within the expression
         * 
         * @param v Expression to check for correct parenthesis
         * @return if not null, then string explaining the error
         */
        private String checkParenthesis(Vector v){
                Vector stack = new Vector();
                Enumeration enum = v.elements();
                while(enum.hasMoreElements()){
                        Object o = enum.nextElement();
                        if(o instanceof String){
                                String s = (String)o;
                                if(s.equals("(") || s.equals(")"))
                                        if(s.equals("("))
                                                stack.addElement(s);
                                        else if(stack.isEmpty())
                                                return new String("Expression Error, parenthesis problem.");
                                        else
                                                stack.removeElementAt(stack.size()-1);
                        }
                }
                if(!stack.isEmpty())
                        return new String("Expression Error, check parenthesis.");
                return null;
        }

        /**
         * compute the number
         * 
         * @param arr Number array
         * @param n the size
         * @param bound the bound to use
         * @return the BigInteger array
         */
        private BigInteger[] computeNumber(BigInteger[] arr,int n,BigInteger bound){            
                BigInteger tmp;
                BigInteger number = BigInteger.valueOf(0);
                for(n--;n >= 0;)
                        if(!((tmp=arr[n]).mod(BigInteger.valueOf(100))).equals(BigInteger.valueOf(0)) 
                           || arr[n].equals(BigInteger.valueOf(0)))
                                number = number.add(arr[n--]);
                        else if(bound.compareTo(arr[n]) >= 0){
                                BigInteger[] res = computeNumber(arr,n,tmp);
                                number = number.add(tmp.multiply(res[0]));
                                n = res[1].intValue();
                        }
                        else    break;
                BigInteger[] tarr = new BigInteger[2];
                tarr[0] = number.equals(BigInteger.valueOf(0)) ? BigInteger.valueOf(1):number;
                tarr[1] = BigInteger.valueOf(n);                
                return tarr;
        }
        
        /**
         * computer number
         * 
         * @param arr bigInteger array
         * @return a big integer representing the array
         */
        private BigInteger computeNumber(BigInteger[] arr){     
                int i;
                BigInteger tmp;
                BigInteger number = BigInteger.valueOf(0);
                for(i=arr.length-1;i >= 0;)
                        if(!((tmp=arr[i]).mod(BigInteger.valueOf(100))).equals(BigInteger.valueOf(0)) 
                           || tmp.equals(BigInteger.valueOf(0)))
                                number = number.add(arr[i--]);
                        else{
                                BigInteger[] res = computeNumber(arr,i,tmp);
                                number = number.add(tmp.multiply(res[0]));
                                i = res[1].intValue();
                        }
                return number;
        }
        
        /**
         * given a number in word form, returns the java.lang.Integer
         * object representing that number.
         * 
         * @param number A number in string form
         * @return a BigInteger representing the input number
         */
        private BigInteger convertNumber(String number){                
                Vector n_vec = new Vector();
                StringTokenizer st = new StringTokenizer(number);
                BigInteger sign = BigInteger.valueOf(1);        /* positive */
                while(st.hasMoreElements()){
                        String numb = (String)st.nextElement();
                        if(numb.equals("negative"))
                                sign = BigInteger.valueOf(-1);
                        else{
                                int loc = findString(numb);
                                if(loc != -1)
                                        n_vec.addElement(numericalNumbers[loc]);
                        }
                }
                BigInteger[] array = new BigInteger[n_vec.size()];
                n_vec.copyInto(array);
                return computeNumber(array).multiply(sign);
        }
        
        /**
         * returns whether this number is numerical or not
         * 
         * @param n A string to test...
         * @return a boolean value of whether the parameter is a number
         */
        private boolean isnumerical(String n){
                if(findString(n) == -1)
                        return false;
                return true;
        }
        
        /**
         * returns expression in numerical form (as a Vector of
         * numbers, operators, etc...)
         * 
         * @param expr Expression (in string form) to convert to a vector
         * @return a Vector representing the expression
         */
        private Vector convertExpression(String expr){
                StringTokenizer st = new StringTokenizer(expr);
                String currentNumber = null;
                Vector numberVector = new Vector();
                while(st.hasMoreElements()){
                        String elements = (String)st.nextElement();
                        if(elements.equals("open")){
                                if(currentNumber != null){
                                        numberVector.addElement(convertNumber(currentNumber));
                                        currentNumber = null;
                                }
                                numberVector.addElement("(");
                        }else if(elements.equals("close")){
                                if(currentNumber != null){
                                        numberVector.addElement(convertNumber(currentNumber));
                                        currentNumber = null;
                                }
                                numberVector.addElement(")");                   
                        }else if(elements.equals("plus")){
                                if(currentNumber != null){
                                        numberVector.addElement(convertNumber(currentNumber));
                                        currentNumber = null;
                                }
                                numberVector.addElement("+");                                   
                        }else if(elements.equals("minus")){
                                if(currentNumber != null){
                                        numberVector.addElement(convertNumber(currentNumber));
                                        currentNumber = null;
                                }
                                numberVector.addElement("-");                                   
                        }else if(elements.equals("times")){
                                if(currentNumber != null){
                                        numberVector.addElement(convertNumber(currentNumber));
                                        currentNumber = null;
                                }
                                numberVector.addElement("*");                                   
                        }else if(elements.equals("divide")){
                                if(currentNumber != null){
                                        numberVector.addElement(convertNumber(currentNumber));
                                        currentNumber = null;
                                }
                                numberVector.addElement("/");                                   
                        }else if(isnumerical(elements)){
                                if(currentNumber == null)
                                        currentNumber = new String();
                                currentNumber += elements + " ";
                        }
                }
                if(currentNumber != null){
                        numberVector.addElement(convertNumber(currentNumber));
                        currentNumber = null;
                }
                return numberVector;
        }
        
        /**
         * given an expression (in word form), this function
         * returns the answer (in word form)
         * 
         * @param expr expression to process
         * @return string representing the result
         */
        private String processExpression(String expr){
                
                Vector exp_numeric = convertExpression(expr);           
                String result = new String();
                Enumeration enum = null;
                
                String err = checkParenthesis(exp_numeric);
                if(err != null)
                        return err;             
                
                err = infixToPostfix(exp_numeric);
                if(err != null)
                        return err;
                
                                
                err = solvePostFixExpression(exp_numeric);
                if(err != null)
                        return err;
                
                BigInteger tmp = (BigInteger)exp_numeric.elementAt(0);
                exp_numeric.removeAllElements();
                writeNumber2Word(tmp,BigInteger.valueOf(1000),exp_numeric);
                
                enum = exp_numeric.elements();
                while(enum.hasMoreElements()){
                        Object o = enum.nextElement();
                        if(o instanceof BigInteger){
                                BigInteger integer = (BigInteger)o;
                                result += integer.toString() + " ";
                        }else if(o instanceof String){
                                String string = (String)o;
                                result += string + " ";
                        }
                }
                return result;
        }
        
        /**
         * create UI, setup buttons, etc.
         */
        public void init(){
                
                expression = new TextArea();
                expression.setFont(new Font("Courier",Font.PLAIN,12));
                answer = new TextArea();
                answer.setFont(new Font("Courier",Font.PLAIN,12));
                clear = new Button("Clear");
                enter = new Button("Enter");
                
                setLayout(new BorderLayout());
                Panel ex = new Panel();
                ex.setLayout(new BorderLayout());
                ex.add("North",new Label("Expression"));                
                ex.add("South",expression);
        
                Panel an = new Panel();
                an.setLayout(new BorderLayout());
                an.add("North",new Label("Answer"));
                an.add("South",answer);
                
                Panel top = new Panel();
                top.setLayout(new BorderLayout());
                top.add("North",ex);
                top.add("South",an);
                
                Panel buttons = new Panel();
                buttons.add(clear);
                buttons.add(enter);
                add("South",buttons);
                add("North",top);
        }
        
        /**
         * handle button presses
         * 
         * @param evt The event
         * @param what The object
         * @return whether the event was handled
         */
        public boolean action(Event evt, Object what){
                if(evt.target instanceof Button){
                        Button button = (Button)evt.target;
                        if(button.getLabel().equals(clear.getLabel())){
                                answer.setText("");
                                expression.setText(""); 
                                return true;
                        }else if(button.getLabel().equals(enter.getLabel())){
                                answer.setText(processExpression(
                                        expression.getText().toLowerCase()));
                                return true;
                        }
                }
                return false;
  }
}

