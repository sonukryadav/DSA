import java.util.ArrayList;  //ArrayList<Integer> al = new ArrayList<Integer>();
import java.util.HashSet;   // HashSet<integer> stk = new HashSet<Integer>();
import java.util.Stack;    // Stack<integer> stk = new Stack<Integer>();

public class LinkedList2{

    //--------------------------Singly Linked List Methods----------------------//
    Node2 head;
    public static class  Node2 {
        int data;
        Node2 next;

    Node2(int d) {
        this.data = d;
        this.next = null;
    }
}

    // Add a node at the front i.e., new node as head
    public void push2(int new_data){ // Time complexity=> O(1).
        Node2 new_node = new Node2(new_data); // node allocated
    new_node.next = head; // made the node-> new_node as head.
    head = new_node;// Move the head to point to new node
}

    //Add a node after a given node
    public void insertAfter2(Node2 prev_node, int new_data){//Time complexity O(1)
    if (prev_node == null) {
        System.out.println("The given previous node cannot be Null");
        return;
    }
        Node2 new_node = new Node2(new_data);//allocate node and put in the data
    new_node.next = prev_node.next;
    //Make next of the new Node as next of the givenNode
    prev_node.next = new_node;
    // make next of the givenNode as new_node
}

    // Add a node at the end
    public void append2(int new_data){// Time complexity O(n)
    /*
    This method can also be optimized to work on
    O(1) by keeping an extra pointer to the tail
    of the linked list.
    */
        Node2 new_node = new Node2(new_data);
    if (head == null) {
        head = new Node2(new_data);
        return;
    }
    new_node.next = null;
        Node2 last = head;
    while (last.next != null) {
        last = last.next;
    }
    last.next = new_node;
    return;
}

    // delete a node when the key i.e., data of the node is given
    public void deleteNode2(int key){
        Node2 temp = head;
        Node2 prev = null;

    if (temp != null && temp.data == key) {
        head = temp.next;
        return;
    }

    while (temp != null && temp.data != key) {
        prev = temp;
        temp = temp.next;
    }

    if (temp == null) {
        System.out.println("Key not found");
        return;
    }
    prev.next = temp.next;
}
// --> method to print the whole linked-list
// To print the whole node
void printList2(){
        Node2 n = head;
    while (n != null) {
        System.out.print(n.data + " ");
        n = n.next;
    }
    System.out.println();
}

//1.Write a function to delete a Linked List
/*
In Java automatic garbage collection happens, so deleting a linked list is easy.
"Just need to change head to null"
*/
void deleteLinkedlist(){
    head = null;
    System.out.println("Linked list deleted successfully");
}

    //2.Find Length of a Linked List (Iterative and Recursive)
    int numberOfNodesIterative(Node2 head){  // Iterative
        int count = 0;
        Node2 temp = head;
    while (temp != null) {
        temp = temp.next;
        count++;
    }
    return count;
}
    int numberOfNodesRecursive(Node2 head){  // Recursive
    if (head == null)  // Base case, Linked list is empty
        return 0;
    return 1 + numberOfNodesRecursive(head.next);
    //count this node plus rest of the node
}

    //3.Search an element in a Linked List (Iterative and Recursive)
    boolean valuePresentOrNotIterative(Node2 head, int key){ //Iterative
        Node2 temp = head;
    while (temp != null) {
        if (temp.data == key) {
            return true;
        }
        temp = temp.next;
    }
    return false;
}

    boolean valuePresentOrNotRecursive(Node2 head, int key) { //Recursive
    if (head == null) // base case
        return false;

    if (head.data == key)
        return true;

    return valuePresentOrNotRecursive(head.next, key);
}
    //4.Write a function to get Nth node in a Linked List(provide index grt data)
    int indexNodeDataIterative(Node2 head, int index){// Iterative
        Node2 temp = head;
        int count = 0;
    while (temp != null) {
        if (count == index)
            return temp.data;
        count++;
        temp = temp.next;
    }
    assert(false);
    System.out.println("You are out of index");
    return -1;
} // Time complexity O(n).

    int indexNodeDataRecursive(Node2 head, int index){//Recursive
        int count = 0;
    if (head == null) {//Edge case
        System.out.println("You are out of index");
        return -1;
    }
    if (count == index)
        return head.data;
    return indexNodeDataRecursive(head.next, index - 1);
}// Time complexity O(n).

//5.Nth node from the end of a Linked List
void nthNodeFromEndIterative(int index, Node2 head){// Iterative
        int len = 0;
        Node2 temp = head;
    while (temp != null) {
        temp = temp.next;
        len++;
    }
    if (index > len || index <= 0) {
        System.out.println("Index issue");
        return;
    }
    temp = head;
    for (int i = 1; i < len - index + 1; i++)
    temp = temp.next;
    System.out.println(temp.data);

}
    //recursive
    Node2 nthNodeFromEndRecursive(int n, Node2 head, int len, int i){ //recursive
    if (i == (len - n + 1)) {
        return head;
    }
    return nthNodeFromEndRecursive(n, head.next, len, i + 1);
}

//6.Print the middle of a given linked list
void middleOfLinkedList(Node2 head){
        int n = ((numberOfNodesRecursive(head) / 2) + 1);
        int i = 0;
    while (++i != n) {
        head = head.next;
    }
    System.out.println(head.data);
}
//7.Write a function that counts the number of times a given int occurs in a Linked List
void howManyTimeOccurred(Node2 head, int n){
        // int i=0;
        int count = 0;
    while (head != null) {
        if (head.data == n)
            count++;
        head = head.next;
    }
    System.out.println(count);
}

    //8.Detect loop in a linked list
    boolean detectLoop(Node2 head) {
        // create two references at start of LinkedList
        Node2 first = head;
        Node2 second = head;

    while (first != null && first.next != null) {
        // move first reference by 2 nodes
        first = first.next.next;
        // move second reference by 1 node
        second = second.next;
        // if two references meet
        // then there is a loop
        if (first == second) {
            return true;
        }
    }
    return false;
}
    //9.Find length of loop in linked list(if loop is present then
    //it gives the length of the loop, but if loop is not present
    //then it gives result as 0).

   /*
   Floyd’s Cycle detection algorithm :  Floyd’s Cycle detection algorithm
   terminates when fast and slow pointers meet at a common point. It is
   also known that this common point is one of the loop nodes. Store the
   address of this common point in a pointer variable say (ptr). Then
   initialize a counter with 1 and start from the common point and keeps
   on visiting the next node and increasing the counter till the common
   pointer is reached again.
   At that point, the value of the counter will be equal to the length of the loop.
   */

    static int countNodes(Node2 n) {
        int res = 1;
        Node2 temp = n;
    while (temp.next != n) {
        res++;
        temp = temp.next;
    }
    return res;
}

    static int countNodesinLoop(Node2 head){
        Node2 slow = head;
        Node2 fast = head;
    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return countNodes(slow);
        }
    }
    return 0;
}

//10.Function to check if a singly linked list is palindrome
void singlyLinkedListPalindrome(Node2 head){
    Stack < Integer > stack1 = new Stack();
        boolean flag = true;
        Node2 temp1 = head;
        Node2 temp2 = head;
    while (temp1 != null) {
        stack1.push(temp1.data);
        temp1 = temp1.next;
    }
    while (temp2 != null) {
        if (temp2.data != stack1.pop()) {
            System.out.println("Not a palindrome");
            flag = false;
            break;
        }
        temp2 = temp2.next;
    }
    if (flag)
        System.out.println("Singly linkedList is palindrome");
}

//11.Remove duplicates from a sorted linked list
//ITERATIVE APPROACH:-->
// Time Complexity: O(n)
// Space Complexity: O(1)
void removeDuplicateiterariveSorted(Node2 head){
        Node2 curr = head;
    while (curr != null) {
            Node2 temp = curr;
        while (temp != null && temp.data == curr.data) {
            temp = temp.next;
        }
        curr.next = temp;
        curr = curr.next;
    }
}

    //Recursive Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    Node2 removeDuplicatesRecursiveSorted(Node2 head){
        Node2 temp;
    if (head == null) {
        return null;
    }
    if (head.next != null) {
        if (head.data == head.next.data) {
            temp = head.next;
            head.next = head.next.next;
            removeDuplicatesRecursiveSorted(head);
        }
        else {
            removeDuplicatesRecursiveSorted(head.next);
        }
    }
    return head;
}

//12.Remove duplicates from an unsorted linked list
/* Time Complexity: O(N) on average
   (assuming that hash table access time is O(1) on average).
   Auxiliary Space : O(N) */
void removeDuplicateUnsorted(Node2 head) {
    // Hash to store seen values
    HashSet < Integer > hs = new HashSet <> ();

        /* Pick elements one by one */
        Node2 current = head;
        Node2 prev = null;
    while (current != null) {
            int curval = current.data;

        // If current value is seen before
        if (hs.contains(curval)) {
            prev.next = current.next;
        }
        else {
            hs.add(curval);
            prev = current;
        }
        current = current.next;
    }
}

//13.Swap nodes in a linked list without swapping data
// Time complexity : O(N)
// Space Complexity : O(1)
void swapTwoNodeSinglyLinkedList(int n1, int n2) {
        Node2 prevNode1 = null;
        Node2 prevNode2 = null;
        Node2 node1 = head;
        Node2 node2 = head;

    // Checks if list is empty
    if (head == null) {
        return;
    }

    // If n1 and n2 are equal, then
    // list will remain the same
    if (n1 == n2)
        return;

    // Search for node1
    while (node1 != null && node1.data != n1) {
        prevNode1 = node1;
        node1 = node1.next;
    }

    // Search for node2
    while (node2 != null && node2.data != n2) {
        prevNode2 = node2;
        node2 = node2.next;
    }

    if (node1 != null && node2 != null) {

        // If previous node to node1 is not null then,
        // it will point to node2
        if (prevNode1 != null)
            prevNode1.next = node2;
        else
            head = node2;

        // If previous node to node2 is not null then,
        // it will point to node1
        if (prevNode2 != null)
            prevNode2.next = node1;
        else
            head = node1;

            // Swaps the next nodes of node1 and node2
            Node2 temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }
    else {
        System.out.println("Swapping is not possible");
    }
}

//14.Pairwise swap elements of a given linked list
//--> Iterative
// Time complexity : O(N)
// Space Complexity : O(1)
void pairWiseSwapIterative(){
        Node2 temp = head;
    /* Traverse only till there are atleast 2 nodes left */
    while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
        temp.data = temp.next.data;
        temp.next.data = k;
        temp = temp.next.next;
    }
}

//--> Recursive
// Time complexity : O(N)
// Space Complexity : O(1)
void pairWiseSwapRecursive(Node2 head){
    /* There must be at-least two nodes in the list */
    if (head != null && head.next != null) {

        /* Swap the node's data with data of next node */
        swapTwoNodeSinglyLinkedList(head.data, head.next.data);

        /* Call pairWiseSwap() for rest of the list */
        pairWiseSwapRecursive(head.next);
    }
}

//15.Move last element to front of a given Linked List
void moveLastElementtoFirst(){
    if (head == null || head.next == null) {
        return;
    }
        /* Initialize second last and last pointers */
        Node2 secLast = null;
        Node2 last = head;

    /* After this loop secLast contains address of
       second last  node and last contains address of
       last node in Linked List */
    while (last.next != null) {
        secLast = last;
        last = last.next;
    }

    /* Set the next of second last as null */
    secLast.next = null;

    /* Set the next of last as head */
    last.next = head;

    /* Change head to point to last node. */
    head = last;
}

// 16.Intersection of two Linked Lists
// Time complexity : O(n)
ArrayList < Integer > intersectionOfTwoLinkedlist(Node2 tmp1, Node2 tmp2) {
    ArrayList < Integer > al1 = new ArrayList <> ();
    HashSet < Integer > set = new HashSet < Integer > ();

    if (tmp1 == null || tmp2 == null) {
        return null;
    }
    while (tmp1 != null) {
        set.add(tmp1.data);
        tmp1 = tmp1.next;

    }
    while (tmp2 != null) {
        if (set.contains(tmp2.data)) {
            al1.add(tmp2.data);
        }
        tmp2 = tmp2.next;
    }
    return al1;
}

    // 17.Intersection point of two Linked Lists.
    // Time complexity : O( m + n )
    // Auxiliary Space:  O(1)
    Node2 intersectionPointOfTwoLinkedlist(Node2 head1, Node2 head2){
        // Maintaining two pointers ptr1 and ptr2
        // at the head of A and B,
        Node2 ptr1 = head1;
        Node2 ptr2 = head2;

    // If any one of head is null i.e
    // no Intersection Point
    if (ptr1 == null || ptr2 == null) {
        return null;
    }
    // Traverse through the lists until they
    // reach Intersection node
    while (ptr1 != ptr2) {

        ptr1 = ptr1.next;
        ptr2 = ptr2.next;

        // If at any node ptr1 meets ptr2, then it is
        // intersection node.Return intersection node.
        if (ptr1 == ptr2) {

            return ptr1;
        }
        /* Once both of them go through reassigning,
        they will be equidistant from the collision point.*/

        // When ptr1 reaches the end of a list, then
        // reassign it to the head2.
        if (ptr1 == null) {

            ptr1 = head2;
        }
        // When ptr2 reaches the end of a list, then
        // redirect it to the head1.
        if (ptr2 == null) {
            ptr2 = head1;
        }
    }
    return ptr1;
}

// 18.QuickSort on Singly Linked List
//Do it after going through the quicksort

//19.Segregate even and odd nodes in a Linked List
// Time Complexity O(n)
// Auxiliary Space O(1)
void segregateEvenOddNodes(Node2 head){
        Node2 end = head;
        Node2 prev = null;
        Node2 curr = head;

    /* Get pointer to last Node */
    while (end.next != null)
        end = end.next;

        Node2 new_end = end;

    // Consider all odd nodes before getting first even node
    while (curr.data % 2 != 0 && curr != end) {
        new_end.next = curr;
        curr = curr.next;
        new_end.next.next = null;
        new_end = new_end.next;
    }

    // do following steps only if there is an even node
    if (curr.data % 2 == 0) {
        head = curr;

        // now curr points to first even node
        while (curr != end) {
            if (curr.data % 2 == 0) {
                prev = curr;
                curr = curr.next;
            }
            else {
                /* Break the link between prev and curr*/
                prev.next = curr.next;

                /* Make next of curr as null */
                curr.next = null;

                /*Move curr to end */
                new_end.next = curr;

                /*Make curr as new end of list */
                new_end = curr;

                /*Update curr pointer */
                curr = prev.next;
            }
        }
    }

    /* We have to set prev before executing rest of this code */
    else prev = curr;

    if (new_end != end && end.data % 2 != 0) {
        prev.next = end.next;
        end.next = null;
        new_end.next = end;
    }
}

    //20.Reverse a linked list
    // Time Complexity O(n)
    // Auxiliary Space O(1)
    Node2 reverseLinkedList(Node2 head){
        Node2 prev = null;
        Node2 current = head;
        Node2 next = null;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
    return head;
}

//-------------------xxx-----------Singly Linked List Methods---------xxx----------------//




//-------------------------------Circular Linked List Methods---------------------------//
class CLL {
        NodeC head;
        class NodeC {
            int data;
            NodeC next;

}
        // push --> method to add node at the beginning of the CLL
        NodeC pushC(NodeC head, int data){
            NodeC newNode1 = new NodeC();
            NodeC temp = head;
    newNode1.next = head;

    /* If linked list is not null then set the next of last node */
    if (head != null) {
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode1;
    }
    else {
        newNode1.next = newNode1;
    }
    head = newNode1;
    return head;
}

/* Function to print nodes in a
   given Circular linked list */
void printList(NodeC head) {

            NodeC temp = head;
    if (head != null) {
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while (temp != head);
    }
}
    }


//------------xxx---------Circular Linked List Methods ------------xxx---------------//



//-------------------------Doubly Linked List Methods-------------------------------//
class DLL {
        NodeD head; // here data type of head is NodeD and is only
        // possible due to class NodeD declaration

        class NodeD {
            int data;
            NodeD prev;
            NodeD next;

    NodeD(int d) {
        this.data = d;
    }
}

// Adding node to the front of the doubly linkedList
void pushD(int data) {
            /* 1. allocate a node identifier named as--> newNode1
               2. put in the data */
            NodeD newNode1 = new NodeD(data);

    /* 3. Make next of new node(newNode1) as head and previous as NULL */
    newNode1.next = head;
    newNode1.prev = null;

    /* 4. change prev of head node to new node */
    if (head != null) {
        head.prev = newNode1;
    }
    /* 5. move the head to point to the new node */
    head = newNode1;
}


        // Add a node before the given node
        public void insertBeforeD(NodeD givenNode, int data) {
    /*Check if the givenNode is NULL*/
    if (givenNode == null) {
        System.out.println("The given next node can not be NULL");
        return;
    }

            //Allocate node, put in the data
            NodeD newNode1 = new NodeD(data);

    //Making prev of new node as prev of next node
    newNode1.prev = givenNode.prev;

    //Making prev of next node as new node
    givenNode.prev = newNode1;

    //Making next of new node as next node
    newNode1.next = givenNode;

    //Check if new node is added as head
    if (newNode1.prev != null)
        newNode1.prev.next = newNode1;
    else
        head = newNode1;
}

        /* Given a node as prev_node, insert
        a new node after the given node */
        public void insertAfterD(NodeD givenNode, int data) {

    /*1. check if the given prev_node is NULL */
    if (givenNode == null) {
        System.out.println("The given previous node cannot be NULL ");
        return;
    }
            /* 2. allocate node
             * 3. put in the data */
            NodeD newNode1 = new NodeD(data);

    /* 4. Make next of new node as next of prev_node */
    newNode1.next = givenNode.next;

    /* 5. Make the next of prev_node as new_node */
    givenNode.next = newNode1;

    /* 6. Make prev_node as previous of new_node */
    newNode1.prev = givenNode;

    /* 7. Change previous of new_node's next node */
    if (newNode1.next != null)
        newNode1.next.prev = newNode1;

    /*8. Maintaining tail node if we are inserting after the second last node */
    if (newNode1.next == null) {
                NodeD tail = newNode1;
    }
}


// Add a node at the end of the doubly linkedList
void appendD(int data) {
            /* 1. allocate node
             * 2. put in the data */
            NodeD newnode1 = new NodeD(data);

            NodeD last = head; /* used in step 5*/

    /* 3. This new node is going to be the last node, so
     * make next of it as NULL*/
    newnode1.next = null;

    /* 4. If the Linked List is empty, then make the new
     * node as head */
    if (head == null) {
        newnode1.prev = null;
        head = newnode1;
        return;
    }

    /* 5. Else traverse till the last node */
    while (last.next != null)
        last = last.next;

    /* 6. Change the next of last node */
    last.next = newnode1;

    /* 7. Make last node as previous of new node */
    newnode1.prev = last;
}

// This function prints contents of
// linked list starting from the given node
void printlistD(NodeD node) {
            NodeD last = null;
    System.out.println("Traversal in forward Direction");
    while (node != null) {
        System.out.print(node.data + " ");
        last = node;
        node = node.next;
    }
    System.out.println();
    System.out.println("Traversal in reverse direction");
    while (last != null) {
        System.out.print(last.data + " ");
        last = last.prev;
    }
}
    }

    //------------xxx------------Doubly Linked List Methods---------------xxx----------------//


public static void main(String[] args) {

    //---------------------Singly Linked List---------------------//

    System.out.println("---All the output related to the singly linked list topic---");
        LinkedList2 list1 = new LinkedList2();
    list1.head = new Node2(20);
        Node2 node1 = new Node2(51);
    list1.head.next = node1;
        Node2 node2 = new Node2(50);
    node1.next = node2;
    list1.printList2();
    //O/p: 20 51 50

    list1.push2(2);
    list1.push2(12);
    list1.printList2();
    //O/p: 12 2 20 51 50

    list1.append2(100);
    list1.printList2();
    //O/p: 12 2 20 51 50 100

    list1.insertAfter2(node2, 400);// 400 node is added after the node2
    list1.printList2();
    //O/p: 12 2 20 51 50 400 100

    list1.deleteNode2(20);
    list1.printList2();
    //O/p: 12 2 51 50 400 100

    //2.Find Length of a Linked List (Iterative and Recursive)
    System.out.println(list1.numberOfNodesIterative(list1.head));
    //O/p: 6
    System.out.println(list1.numberOfNodesRecursive(list1.head));
    //O/p: 6


    //3.Search an element in a Linked List (Iterative and Recursive)
    System.out.println(list1.valuePresentOrNotIterative(list1.head, 100));
    //O/p: true
    System.out.println(list1.valuePresentOrNotIterative(list1.head, 1000));
    //O/p: false

    System.out.println(list1.valuePresentOrNotRecursive(list1.head, 500));
    //O/p:  false
    System.out.println(list1.valuePresentOrNotRecursive(list1.head, 12));
    //O/p: true

    //4.Write a function to get Nth node in a Linked List(Provide index get data)
    System.out.println(list1.indexNodeDataIterative(list1.head, 5));
    //O/p: 100
    System.out.println(list1.indexNodeDataIterative(list1.head, 52));
    //O/p: You are out of index
    // -1

    System.out.println(list1.indexNodeDataRecursive(list1.head, 5));
    //O/p: 100
    System.out.println(list1.indexNodeDataRecursive(list1.head, 52));
    //O/p: You are out of index
    // -1


    //5.Nth node from the end of a Linked List
    list1.nthNodeFromEndIterative(1, list1.head);
    //O/p: 100
    list1.nthNodeFromEndIterative(0, list1.head);
    //O/p: Index issue

    System.out.println((list1.nthNodeFromEndRecursive(4, list1.head, list1.numberOfNodesRecursive(list1.head), 1)).data);
    //O/p: 51

    //6.Print the middle of a given linked list
    list1.middleOfLinkedList(list1.head);
    //O/p: 50


    //7.Write a function that counts the number of times a given int occurs in a Linked List
    list1.howManyTimeOccurred(list1.head, 500);
    //O/p: 0

    list1.howManyTimeOccurred(list1.head, 400);
        //O/p: 1

        LinkedList2 list2 = new LinkedList2();
    list2.head = new Node2(10);
        Node2 node2a = new Node2(20);
    list2.head.next = node2a;
        Node2 node2b = new Node2(30);
    node2a.next = node2b;
        Node2 node2c = new Node2(40);
    node2b.next = node2c;
    node2c.next = list2.head;
    System.out.println(list2);
    //O/p: linkedListDSA2@7b23ec81
    //list2.printList2();
    //O/p: Since the list2 is forming a circular loop so will run forever


    //8.Detect loop in a linked list
    System.out.println(list1.detectLoop(list1.head));
    //O/p: false
    System.out.println(list2.detectLoop(list2.head));
    // true

    //9.Find length of loop in linked list(if loop is present then
    //it gives the length of the loop, but if loop is not present
    //then it gives result as 0).
    /*
    Floyd’s Cycle detection algorithm :  Floyd’s Cycle detection algorithm
    terminates when fast and slow pointers meet at a common point. It is
    also known that this common point is one of the loop nodes. Store the
    address of this common point in a pointer variable say (ptr). Then
    initialize a counter with 1 and start from the common point and keeps
    on visiting the next node and increasing the counter till the common
    pointer is reached again.
    At that point, the value of the counter will be equal to the length of the loop.
    */
    System.out.println(countNodesinLoop(list1.head));
    // 0
    System.out.println(countNodesinLoop(list2.head));
    // 4

    //10.Function to check if a singly linked list is palindrome
    list1.singlyLinkedListPalindrome(list1.head);
        //O/p: Not a palindrome

        //11.Remove duplicates from a sorted linked list
        LinkedList2 list3 = new LinkedList2();
    list3.head = new Node2(5);
        Node2 sec = new Node2(10);
        Node2 thi = new Node2(15);
        Node2 fou = new Node2(15);
        Node2 fiv = new Node2(20);
        Node2 six = new Node2(20);

    list3.head.next = sec;
    sec.next = thi;
    thi.next = fou;
    fou.next = fiv;
    fiv.next = six;
    list3.printList2();
    //O/p: 5 10 15 15 20 20

    list3.removeDuplicateiterariveSorted(list3.head); //--> Iterative approach
    list3.printList2();
    //O/p: 5 10 15 20

    list3.removeDuplicatesRecursiveSorted(list3.head); //--> Recursive approach
    list3.printList2();
    //O/p: 5 10 15 20

    // 12.Remove duplicates from an unsorted linked list
    list1.append2(50);
    list1.append2(400);
    list1.printList2();
    //O/p: 12 2 51 50 400 100 50 400

    list1.removeDuplicateUnsorted(list1.head);
    list1.printList2();
    //O/p: 12 2 51 50 400 100

    //13.Swap nodes in a linked list without swapping data
    list1.swapTwoNodeSinglyLinkedList(12, 100);
    list1.printList2();
    //O/p: 100 2 51 50 400 12

    //14.Pairwise swap elements of a given linked list
    list1.pairWiseSwapIterative();
    list1.printList2();
    //O/p: 2 100 50 51 12 400

    list1.pairWiseSwapRecursive(list1.head);
    list1.printList2();
    //O/p: 100 2 51 50 400 12

    //15.Move last element to front of a given Linked List
    list1.moveLastElementtoFirst();
    list1.printList2();
        //O/p: 12 100 2 51 50 400


        // 16.Intersection of two Linked Lists
        LinkedList2 list4 = new LinkedList2();
    list4.head = new Node2(0);
        Node2 l4N2 = new Node2(1);
        Node2 l4N3 = new Node2(12);
        Node2 l4N4 = new Node2(100);
        Node2 l4N5 = new Node2(4);
        Node2 l4N6 = new Node2(-23);
        Node2 l4N7 = new Node2(45);
    list4.head.next = l4N2;
    l4N2.next = l4N3;
    l4N3.next = l4N4;
    l4N4.next = l4N5;
    l4N5.next = l4N6;
    l4N6.next = l4N7;
    list4.printList2();
        //O/p: 0 1 12 100 4 -23 45

        LinkedList2 list5 = new LinkedList2();
    list5.append2(0);
    list5.append2(1);
    list5.append2(123);
    list5.append2(100);
    list5.append2(41);
    list5.append2(-23);
    list5.append2(45);
    list5.printList2();
    //O/p: 0 1 123 100 41 -23 45

    System.out.println(list5.intersectionOfTwoLinkedlist(list4.head, list5.head));
        //O/p: [0, 1, 100, -23, 45]

        // 17.Intersection point of two Linked Lists.
        LinkedList2 list6 = new LinkedList2();
        LinkedList2 list7 = new LinkedList2();
    list6.head = new Node2(5);
        Node2 l6N2 = new Node2(10);
        Node2 l6N3 = new Node2(15);
        Node2 l6N4 = new Node2(20);
        Node2 l6N5 = new Node2(25);
    list6.head.next = l6N2;
    l6N2.next = l6N3;
    l6N3.next = l6N4;
    l6N4.next = l6N5;

    list7.head = new Node2(30);
        Node2 l7N2 = new Node2(35);
        Node2 l7N3 = new Node2(40);
        Node2 l7N4 = new Node2(45);
    list7.head.next = l7N2;
    l7N2.next = l7N3;
    l7N3.next = l7N4;

    list6.printList2();
    //O/p: 5 10 15 20 25

    list7.printList2();
    //O/p: 30 35 40 45

    // linking the list6 and list7
    l6N5.next = l7N3;
    System.out.println((list6.intersectionPointOfTwoLinkedlist(list6.head, list7.head)).data);
    //O/p: 40

    // 18.QuickSort on Singly Linked List
    //Do it after going through the quicksort


    //19.Segregate even and odd nodes in a Linked List
    list1.segregateEvenOddNodes(list1.head);
    list1.printList2();
        //O/p: 12 100 2 50 400 51

        Node2 temp = list1.reverseLinkedList(list1.head);
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    //O/p: 51 400 50 2 100 12


    System.out.println();
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    System.out.println("list1 - 51 400 50 2 100 12");
    System.out.println("list2 - Forming a loop--> 10 20 30 40");
    System.out.println("list3 - 5 10 15 20");
    System.out.println("list4 - 0 1 12 100 4 -23 45");
    System.out.println("list5 - 0 1 123 100 41 -23 45");
    System.out.println("list6 - 5 10 15 20 25");
    System.out.println("list7 - 30 35 40 45");
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


    //1.Write a function to delete a Linked List
    list1.deleteLinkedlist();
    //O/p: Linked list deleted successfully

    System.out.println(list1.numberOfNodesRecursive(list1.head));
    //O/p: 0

    //---------xxxxx---------Singly Linked List------xxxxx------------///





    //-----------------------Circular Linked List------------------------///

    System.out.println("---All output related to the Circular linked list---");

    /*
    Circular lists are useful in applications to repeatedly go around
    the list. For example, when multiple applications are running on
    a PC, it is common for the operating system to put the running
    applications on a list and then to cycle through them, giving
    each of them a slice of time to execute, and then making them
    wait while the CPU is given to another application. It is convenient
    for the operating system to use a circular list so that when it reaches
    the end of the list it can cycle around to the front of the list.
     */


    //----------xxxxx----------Circular Linked List-------xxxxx--------------///





    //-------------------------Doubly Linked List-----------------------///

    System.out.println("---All output related to the Doubly linked list---");

        LinkedList2  outerClassObj1 = new LinkedList2();
    LinkedList2.DLL doublyObj1 = outerClassObj1.new DLL();

    // Insert 6. So linked list becomes 6->NULL
    doublyObj1.appendD(6);

    // Insert 7 at the beginning. So
    // linked list becomes 7->6->NULL
    doublyObj1.pushD(7);

    // Insert 1 at the beginning. So
    // linked list becomes 1->7->6->NULL
    doublyObj1.pushD(1);

    // Insert 4 at the end. So linked
    // list becomes 1->7->6->4->NULL
    doublyObj1.appendD(4);

    // Insert 8, after 7. So linked
    // list becomes 1->7->8->6->4->NULL
    doublyObj1.insertAfterD(doublyObj1.head.next, 8);

    // Insert 5, before 8.So linked
    // list becomes 1->7->5->8->6->4
    doublyObj1.insertBeforeD(doublyObj1.head.next.next, 5);

    doublyObj1.printlistD(doublyObj1.head);
    //O/p:
    /*
    Traversal in forward Direction
     1 7 5 8 6 4
    Traversal in reverse direction
     4 6 8 5 7 1
    */


}
}

