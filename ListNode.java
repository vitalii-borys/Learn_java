public class ListNode {  
    int val;  
    ListNode next;  
    public ListNode(int val) {  
        this.val = val;  
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(10);
        ListNode l3 = new ListNode(40);
        l1.next = l2;
        l2.next = l3;
        ListNode current = l1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}  