public class ListNo {
    int data;
    ListNo next;

    public ListNo(int input) {
        data = input;
        next = null;
    }
    public static ListNo append(ListNo head, int inp) {
        ListNo newNode = new ListNo(inp);
        if (head == null) {
            return newNode;
        }
        ListNo curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        ListNo li1 = new ListNo(5);
        ListNo li2 = new ListNo(10);
        ListNo li3 = new ListNo(15);
        li1.next = li2;
        li2.next = li3;
        ListNo li4 = append(li1, 0);
        /* ListNo curr = li4;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        } */
        System.out.println(li4.next.data);
    }
    
}
