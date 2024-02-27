// Define a class named "Node" to represent individual elements of a linked list
class Node {
    int data;       // Store the data of the node
    Node next;      // Reference to the next node in the linked list

    // Constructor to initialize a node with given data
    public Node(int data) {
        this.data = data;
        this.next = null;  // Initialize the "next" reference to null
    }
}

// Define the main class for the linked list example
public class LinkedListExample {
    // Method to append a new node with given data to the end of the linked list
    public static Node append(Node head, int data) {
        Node newNode = new Node(data);  // Create a new node with the provided data
        if (head == null) {
            return newNode;  // If the list is empty, the new node becomes the head
        }
        Node current = head;  // Start traversing from the head of the list
        while (current.next != null) {
            current = current.next;  // Traverse until the last node is reached
        }
        current.next = newNode;  // Attach the new node to the "next" reference of the last node
        return head;  // Return the head of the updated linked list
    }

    // The main method where the program execution begins
    public static void main(String[] args) {
        // Create three nodes with data values 5, 10, and 15
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(15);

        // Link the nodes together: 5 -> 10 -> 15
        node1.next = node2;
        node2.next = node3;

        // Append a new node with data value 20 to the end of the linked list
        Node newNode = append(node1, 20);

        Node current = newNode;  // Start traversing from the head of the updated list
        while (current != null) {
            System.out.println(current.data);  // Print the data of the current node
            current = current.next;  // Move to the next node in the list
        }
    }
}
