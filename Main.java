import java.util.*;
 
public class Main {
    static boolean balanced(String c){
        Deque<Character> main = new ArrayDeque<Character>();
        for (int n = 0; n < c.length(); n++){
            char a = c.charAt(n);
            if (a == '(' || a == '[' || a == '{'){
                main.push(a);
                continue;
            }
            if (main.isEmpty())
                return false;
            char b;
            switch (a) {
            case ')':
                b = main.pop();
                if (b == '{' || b == '[')
                    return false;
                break;
            case '}':
                b = main.pop();
                if (b == '(' || b == '[')
                    return false;
                break;
 
            case ']':
                b = main.pop();
                if (b == '(' || b == '{')
                    return false;
                break;
            }
        }
        return (main.isEmpty());
    }
    public static void main(String[] args)
    {
        String c = "{{{}}[[]]()[[]]{{{}}}";
        if (balanced(c))
            System.out.println("This is a balanced parantheses.");
        else
            System.out.println("This is not a balanced parantheses.");
    }
}
