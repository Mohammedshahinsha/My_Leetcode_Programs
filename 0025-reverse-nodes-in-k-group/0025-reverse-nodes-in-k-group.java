class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null || head == null)
            return head;
        //int size = head.size();
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
         while (current != null) 
        {
            count++;
            current = current.next;
        }
        current = head;
        int j = count/k;
        ListNode tail = current;
        ListNode connection = prev;
        while(j > 0)
        {
            for(int i = 1; i <= k; i++)
            {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            if(connection != null)
            {
             connection.next = prev;
            }else{
                head = prev;
            }
            tail.next = current;
            j--;
            connection = tail;
            tail = current;
        }
        return head;
    }
}