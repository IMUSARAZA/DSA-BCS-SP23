public class StacksLLDriver {

    public static void main(String[] args) {

            LinkedListStack<Integer> stack = new LinkedListStack<>();

            // Push some elements onto the stack
            stack.push(1);
            stack.push(2);
            stack.push(3);

            // Print the top element of the stack
            System.out.println("Top element: " + stack.peek());

            // Pop an element from the stack and print it
            System.out.println("Popped element: " + stack.pop());

            // Print the top element of the stack again
            System.out.println("Top element: " + stack.peek());

            // Check if the stack is empty
            System.out.println("Is the stack empty? " + stack.isEmpty());

            // Print the size of the stack
            System.out.println("Size of the stack: " + stack.size());
        }


    }

