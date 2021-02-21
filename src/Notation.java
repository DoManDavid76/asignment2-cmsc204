import java.lang.Object;
/**
 * @author David Do
 */

public class Notation {

	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		
		NotationQueue<Character> queue = new NotationQueue<>(infix.length());
		NotationStack<Character> stack = new NotationStack<>(infix.length());
		char[] content = infix.toCharArray();
		
		try {
			for(int i = 0; i < content.length;i++) {
				char current = content[i];
				if(Character.isDigit(current)) {
					queue.enqueue(current);
					continue;
				}
				if(current == '(') {
					stack.push(current);
				}
				if(current == '*' || current == '/' || current == '+' || current == '-') {
					if(!queue.isEmpty()) {
						char top = stack.top();
						if (top == '*' || top == '/' || current == '-' && top == '-' || 
								current == '-' && top == '+' || current == '+' && top == '-' || current == '+' && top == '+') {
							System.out.println("Pri testing 3");
							queue.enqueue(stack.pop());
					}
				}
				stack.push(current);
				continue;
			}
			if(current == ')') {
				while(stack.top() != '(') {
					queue.enqueue(stack.pop());
					if(stack.top() == null) {
						throw new InvalidNotationFormatException();
					}
				}
				stack.pop();
			}
				
		} 
		
	} catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) {
		throw new InvalidNotationFormatException();
	}
		return queue.toString();
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		
		NotationStack<Double> stack = new NotationStack<>(postfixExpr.length());
		char[] content = postfixExpr.toCharArray();
		
		try {
				for(char current: content) {
					if(Character.isDigit(current)) {
						stack.push(Double.parseDouble(Character.toString(current)));
					}
					if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					System.out.println("print test eval 2");
					
					double two = stack.pop();
					double one = stack.pop();
					if(current == '*'){
						System.out.println(two + "<==  2 ==>" + one);
						stack.push(two * one);
					}
					if(current == '/'){
						stack.push(one / two);
					}
					if(current == '+'){
						stack.push(one + two);
					}
					if(current == '-'){
						stack.push(one - two);
					}							
						
				}
				}
				
			}catch (StackOverflowException | StackUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
				if(stack.size() > 1)
					throw new InvalidNotationFormatException();
				
				return Double.parseDouble(stack.toString());
		} 


	

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
	
		NotationStack<String> stack = new NotationStack<>(postfix.length());
		
		try {
			for(int i = 0; i < postfix.length(); i++) {
				char current = postfix.charAt(i);
				if(Character.isDigit(current)) {
					System.out.println("test 1");
					stack.push(Character.toString(current));
				}
				
				if(current == '/' || current == '*' || current == '+' || current == '-') {
					System.out.println("test 2 ");
					if(stack.size() <2) {
						throw new InvalidNotationFormatException();
					}
					System.out.println("test three");
					String one = stack.pop();
					String two = stack.pop();
					String s = "(" + two + current + one + ")";
					stack.print(s + " testing stack string");
					
					stack.push(s);					
				}
			}
		}
			catch (StackUnderflowException | StackOverflowException e) {
				throw new InvalidNotationFormatException();
			}
			if (stack.size() > 1) {
				throw new InvalidNotationFormatException();
			}
			return stack.toString();
		}
	}
