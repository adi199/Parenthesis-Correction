import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

class node{
    char data;
    node next;
    node(){
        data = 0;
        next = null;
    }
    node(char no){
        data = no;
        next = null;
    }
}

class stack{
    node head;
    stack(){
        head = null;
    }
    stack(char ch){
        head  = new node(ch);
    }
    public void insertNode(char ch){
        if(head==null){
            head = new node(ch);
        }
        else{
            node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new node(ch);
        }
    }
    public void deleteNode(){
        if(head!=null){
            node temp = head;
            node prev = null;
            while(temp.next!=null){
                prev = temp;
                temp = temp.next;
            }
            if(prev!=null){
                prev.next = null;
            }
            else{
                head = null;
            }
        }
    }
    public void deleteNode(char target){
        if(head!=null){
            if(head.next==null){
                head = null;
            }
            else{
                node temp = head;
                node prev = null;
                while(temp!=null){
                    if((temp.data)==(target)){
                        break;
                    }
                    prev = temp;
                    temp = temp.next;
                }
                System.out.println(prev);
                if(prev!=null){
                    //System.out.println("Delete(target) method called : Deleting :- "+temp.data);
                    prev.next = temp.next;
                    //System.out.println("Herer");
                }   
            }
            //System.out.println("After Deletion :- Queue => ");
            //display();
        }
    }
    public int size(){
        int count = 0;
        if(head!=null){
            node temp = head;
            while(temp!=null){
                count += 1;
                temp = temp.next;
            }
        }
        return (count);
    }
    public void display(){
        if(head!=null){    
            node temp = head;
            while(temp.next!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print(temp.data+"\n");
        }
        else{
            System.out.println("Empty Stack");
        }
    }
    public boolean search(char target){
        if(head!=null){
            node temp = head;
            while(temp!=null){
                if(temp.data==target){
                    break;
                }
                temp = temp.next;
            }
            if(temp==null){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public char peek(){
        if(head!=null){
            node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            return temp.data;
        }
        else{
            return 0;
        }
    }
}

class queue{
    node head;
    queue(){
        head = null;
    }
    queue(char ch){
        head  = new node(ch);
    }
    public void insertNode(char ch){
        if(head==null){
            head = new node(ch);
        }
        else{
            node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new node(ch);
        }
    }
    public void deleteNode(){
        if(head!=null){
            head = head.next;
        }
        // System.out.println("deleteNode() method called : After Deletion :- Queue => ");
        // display();
    }
    public void deleteNode(char target){
        if(head!=null){
            if(head.next==null){
                head = null;
            }
            else{
                node temp = head;
                node prev = null;
                while(temp!=null){
                    if((temp.data)==(target)){
                        break;
                    }
                    prev = temp;
                    temp = temp.next;
                }
                if(prev!=null){
                    prev.next = temp.next;
                }
                else{
                    head =temp.next;
                }   
            }
        }
    }
    public int size(){
        int count = 0;
        if(head!=null){
            node temp = head;
            while(temp!=null){
                count += 1;
                temp = temp.next;
            }
        }
        return (count);
    }
    public void display(){
        if(head!=null){
            node temp = head;
            while(temp.next!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print(temp.data+"\n");
        }
        else{
            System.out.println("Queue is empty");
        }
    }
    public char peek(){
        if(head!=null){
            return head.data;
        }
        else{
            return 0;
        }
    }
    public boolean search(char target){
        if(head!=null){
            node temp = head;
            while(temp!=null){
                if(temp.data==target){
                    break;
                }
                temp = temp.next;
            }
            if(temp==null){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
}

public class parenthesisCorrection{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    public static boolean checkMatchingTags(char open,char close){
        // System.out.println(open+" "+close);
        if(((open=='(')&&close==(')'))||((open=='[')&&close==(']'))||((open=='{')&&close==('}'))){
            return true;
        }
        else{
            return false;
        }
    }
    public static int countOpeningTags(String exp){
        int count = 0;
        for(int i=0;i<exp.length();i++){
            if((exp.charAt(i)=='{')||(exp.charAt(i)=='(')||(exp.charAt(i)=='[')){
                count += 1;
            }
        }
        return count;
    }
    public static int countClosingTags(String exp){
        int count = 0;
        for(int i=0;i<exp.length();i++){
            if((exp.charAt(i)=='}')||(exp.charAt(i)==')')||(exp.charAt(i)==']')){
                count += 1;
            }
        }
        return count;
    }
    public static boolean checkParenthesisType(String type,char ch){
        if(type.equals("open")){
            if((ch=='{')||(ch=='(')||(ch=='[')){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if((ch=='}')||(ch==')')||(ch==']')){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static boolean matchParenthesisPair(char charQueue,char ch,String mode){
        if(mode.equals("same")){
            if(((charQueue=='{')&&(ch=='}'))||((charQueue=='(')&&(ch==')'))||((charQueue=='[')&&(ch==']'))){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(mode.equals("close")){   
                if(((charQueue=='}')&&(ch=='{'))||((charQueue==')')&&(ch=='('))||((charQueue==']')&&(ch=='['))){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
    }
    public static String checkParenthesis(String exp){
        int check = 0,count = 0;
        int openingTagCount = countOpeningTags(exp);
        int closingTagCount = countClosingTags(exp);
        stack stk = new stack();
        queue q = new queue();
            if(openingTagCount>=closingTagCount){
                for(int i=0;i<exp.length();i++){
                    if(checkParenthesisType("open", exp.charAt(i))){
                        q.insertNode(exp.charAt(i));
                    }
                    else{
                        if(matchParenthesisPair(q.peek(),exp.charAt(i),"same")){
                            q.deleteNode();
                        }
                        else{
                            stk.insertNode(exp.charAt(i));
                        }
                    }
                }
            }
            else{
                for(int i=0;i<exp.length();i++){
                    if(checkParenthesisType("close", exp.charAt(i))){
                        q.insertNode(exp.charAt(i));
                    }
                    else{
                        if(matchParenthesisPair(q.peek(),exp.charAt(i),"same")){
                            q.deleteNode();
                        }
                        else{
                            stk.insertNode(exp.charAt(i));
                        }
                    }
                }
            }
        if((q.size()==0)&&(stk.size()==0)){
            return "Minimum no of steps required :- "+count;
        }
        else{
            while(((q.size()!=0)||(stk.size()!=0))){
                if(matchParenthesisPair(q.peek(),stk.peek(),"close")){
                    q.deleteNode();
                    stk.deleteNode();
                    count += 2;
                }
                else{
                    if(matchParenthesisPair(q.peek(),stk.peek(),"same")){
                        q.deleteNode();
                        stk.deleteNode();
                        if(matchParenthesisPair(q.peek(),stk.peek(),"same")){
                            q.deleteNode();
                            stk.deleteNode();
                        }
                        count += 2;
                    }
                }
                if(q.size()>1){
                    char ch = q.peek();
                    if(q.search(ch)){
                        count += 1;
                        q.deleteNode();
                        q.deleteNode(ch);
                    }
                }
                if(stk.size()>1){
                    char ch = stk.peek();
                    if(stk.search(ch)){
                        count += 1;
                        stk.deleteNode();
                        stk.deleteNode(ch);
                    }
                }
            }

        }
        // System.out.println("Order :- "+order);
        // System.out.println("Queue :- ");
        // q.display();
        // System.out.println("Stack :- ");
        // stk.display();
        if(check==0){
            return "Minimum no of steps required :- "+count;
        }
        else{
            return "Expression cannot be balanced";
        }
    }
    public static void main(String[] args){
        FastReader scan = new FastReader();
        int test = scan.nextInt();
        String exp;
        while(test!=0){
            exp = scan.nextLine();
            exp = exp.trim();
            System.out.println(checkParenthesis(exp));
            test -= 1;
        }
    }
}