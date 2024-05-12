public class StackDriver {

    public static void main(String[] args) {


        StackUsingArray stack = new StackUsingArray(5);


        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.print();

        System.out.println("Poping: "+stack.pop()+","+stack.pop()+","+stack.pop()+","+stack.pop()+","+stack.pop());




    }




}
