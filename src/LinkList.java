class Node1 {
    int data;
    Node1 next;

    public Node1(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkList {
    Node1 head;
    public void addFirst(int data){
        Node1 newNode = new Node1(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void addLast(int data){
        Node1 newNode = new Node1(data);
        Node1 currentNode = head;
        if(head == null){
            head = newNode;
        }
        else{
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    public void print(){
        Node1 currentNode = head;
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            while(currentNode != null){
                System.out.printf("   Data : " + currentNode.data);
                currentNode = currentNode.next;
            }
            System.out.println("   Data : " + "Null");
        }
    }

    public Node1 search(int data){
        Node1 found = null;
        Node1 currentNode = head;

        if(head == null){
            System.out.println("List is empty");
        }
        else{
            while(currentNode != null){
                if(currentNode.data == data){
                    found = currentNode;
                    break;
                }
                currentNode  = currentNode.next;
            }
        }
        return found;
    }

    public void insert(int data, int dataToBeAdded){
        Node1 currentNode = head;
        Node1 newNode = new Node1(dataToBeAdded);
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            while(currentNode != null){
                if(currentNode.data == data){
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    return;
                }
                currentNode  = currentNode.next;
            }
        }
    }

    public void deleteAtFirst(){
        if(head == null){
            System.out.println("List is empty");
        }
        else if(head.next == null){
            head.next = null;
        }
        else{
            head = head.next;
        }
    }

    public void deleteAtLast(){
        Node1 currentNode = head;

        while(currentNode.next != null){
            if(currentNode.next.next == null){
                currentNode.next = null;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public void deleteAtLocation(int data){
        Node1 prev = head;
        Node1 current = head.next;

        while(current.next != null){
            if(current.data == data){
                prev.next = current.next;
            }
            current = current.next;
            prev = prev.next;
        }
    }
    public LinkList duplicate() {
        LinkList dup = new LinkList();
        Node1 curr = head;

        while (curr.next != null) {
            dup.addLast(curr.data);
            curr = curr.next;
        }

        dup.addLast(curr.data);

        return dup;
    }

    public LinkList concat(LinkList list1, LinkList list2){
        LinkList concatedList;
        concatedList = list1.duplicate();
        Node1 curr = list2.head;

        while(curr.next != null){
            concatedList.addLast(curr.data);
            curr = curr.next;
        }
        concatedList.addLast(curr.data);
        return concatedList;
    }

    public LinkList replace(LinkList list, int index, int replacement){
        Node1 listHead = list.head;
        Node1 current = list.head;
        int count = 0;

        while (current != null){
            if(count == index){
                current.data = replacement;
            }
            count++;
            current = current.next;
        }
        return list;
    }

    public Node1 secondLastNode(LinkList list){
        Node1 prev = list.head;
        Node1 curr = prev.next;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public int sizeOfCircularLinkedList(LinkList list){
        int size = 0;
        Node1 curr = head;
        Node1 curr2 = head;
        while(curr.next != null){ // code to traverse till last node
            size++;
            curr = curr.next;
        }
        curr.next = head; // code to change into circular linked list
        size++;
        while (curr2.next != head){ // code to print circular linked list
            System.out.printf("   Data : " + curr2.data);
            curr2 = curr2.next;
        }
        System.out.printf("   Data : " + curr2.data);
        System.out.println("   Data : " + "Null");
        return size;
    }

    public LinkList rotate(LinkList list, int index, int size){
        LinkList rotatedList = new LinkList();
        Node1 prev = list.head;
        Node1 curr = prev.next;
        Node1 c = list.head;
        int count = 0;
        while(prev.next != null){
            if(count == index){
                break;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }

        for(int i = 0; i < 5; i++){
            rotatedList.addLast(prev.data);
            prev = prev.next;
            if(i == count) break;
        }
        for (int i = 0; i < 5-count-1; i++) {
            rotatedList.addLast(c.data);
            c = c.next;
        }
        return rotatedList;
    }

    public static void main(String[] args) {
        LinkList l = new LinkList();
        LinkList copiedList;
        LinkList concatedList;
        LinkList replaced;
        Node1 secondLastNode;
        int size;
        LinkList rotatedLinkedList;

        l.addFirst(10);
        l.addFirst(20);
        l.addLast(30);
        l.addFirst(5);
        l.addLast(34);

        System.out.println("Original list: ");
        l.print();
        System.out.println();

        System.out.println("Copied list: ");
        copiedList = l.duplicate();
        copiedList.print();
        System.out.println();

        System.out.println("Concatenated list: ");
        concatedList = l.concat(l, copiedList);
        concatedList.print();
        System.out.println();

        System.out.println("Original list: ");
        l.print();
        System.out.println("Replaced list: ");
        replaced = l.replace(l, 3, 100);
        replaced.print();
        System.out.println();

        System.out.println("Second last Node: ");
        secondLastNode = l.secondLastNode(l);
        System.out.println(secondLastNode.data);
        System.out.println();

        System.out.println("Size of circular linked list: ");
        System.out.println("List changed into circular list: ");
        size = l.sizeOfCircularLinkedList(l);
        System.out.printf("Size: " + size);
        System.out.println();
        System.out.println();

        size = concatedList.sizeOfCircularLinkedList(copiedList);
        System.out.println();
        System.out.println("Original list: ");
        copiedList.print();
        System.out.println("Rotated Linked List at index 2: ");
        rotatedLinkedList = copiedList.rotate(copiedList, 2, size);
        rotatedLinkedList.print();
    }
}

