import java.util.Stack;

public class DecimalToBinaryConverter {
    
    // Stack implementation
    static class MyStack {
        private Stack<Integer> stack;

        public MyStack() {
            stack = new Stack<>();
        }

        // Push element onto the stack
        public void push(int data) {
            stack.push(data);
        }

        // Pop element from the stack
        public int pop() {
            return stack.pop();
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return stack.isEmpty();
        }

        // Get the top element of the stack without removing it
        public int peek() {
            return stack.peek();
        }
    }
    
    // Method to convert decimal to binary using a stack
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) return "0"; // Edge case: 0

        MyStack stack = new MyStack();

        // Convert decimal to binary using repeated division by 2
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // Build binary string from the stack
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test the decimalToBinary method with various decimal numbers
        int[] testNumbers = {0, 1, 5, 10, 16, 32, 100, 500, 1000};
        
        for (int num : testNumbers) {
            System.out.println("If Decimal: " + num + " then Binary: " + decimalToBinary(num));
        }
    }
}
