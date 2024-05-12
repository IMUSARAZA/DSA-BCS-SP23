public class LL {

    Node head;
    class Node {

        String data;
        Node next;


        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addAtFirst(String data) {

        Node Node1 = new Node(data);
        Node1.next = head;
        head = Node1;

    }

    public void addAtLast(String data){

        Node newNode = new Node(data);

        Node current =head;

        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current.next != null) {
                current=current.next;
            }
            current.next= newNode;
            newNode.next=null;

        }

    }

    public void print() {

        Node current= head;

        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {

                System.out.printf("  Data-> " + current.data);

                current=current.next;

            }

        }

    }

    public void delete(String data){

        Node current=head;

        if(head==null){
            System.out.println("List is empty");
        }
        else{
            while (current.data != data){

                current=current.next;
            }
            current.data=null;
            current=current.next;
        }
    }





    public static void main(String[] args) {
        LL list = new LL();
        list.addAtFirst("A");
        list.addAtLast("B");
        list.addAtLast("C");
        list.addAtLast("D");
        list.delete("B");
        list.print();
    }

}



