package lecture3;

public class StartOfACycleInLL {

      public static Node firstNode(Node head) {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
                  if (slow == fast) {
                        slow = head;
                        while (slow != fast) {
                              slow = slow.next;
                              fast = fast.next;
                        }
                        return slow;
                  }
            }
            return null;
      }
}
