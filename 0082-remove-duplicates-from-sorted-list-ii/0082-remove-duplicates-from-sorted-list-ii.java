class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // sentinel -> what we as dummy node
        // insetead of pointer here we use dynamic allocation

        ListNode dm = new ListNode(0 , head);
       
       // the node before which we want to connect
        ListNode pre = dm; 

        while(head != null){
            int va = head.val;
            if(head.next != null && head.next.val == va){
                while(head.next != null && head.val == va){
                    head = head.next;
                }
                if(head.val == va ){
                  pre.next = null;

                }
                else{
                pre.next = head;
               }
            }
            else{
            pre= pre.next;
            head = head.next;
            }                                              
            
        }
         return dm.next;
    }
   
}