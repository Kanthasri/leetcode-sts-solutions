1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode sortList(ListNode head) {
13        if(head==null ||head.next == null) return head;
14       ListNode slow = head;
15       ListNode fast = head;
16       while(fast.next!=null && fast.next.next!=null){
17        slow = slow.next;
18        fast = fast.next.next;
19       }
20       ListNode head2 = slow.next;
21       slow.next = null;
22       head = sortList(head);
23       head2 = sortList(head2);
24       return mergeTwoLists(head,head2);
25
26    }
27    public ListNode mergeTwoLists(ListNode head,ListNode head2){
28        ListNode i = head;
29        ListNode j = head2;
30        ListNode dummy = new ListNode(-1);
31        ListNode k = dummy;
32
33        while(i!=null && j!=null){
34            if(i.val<=j.val){
35                k.next = i;
36                i = i.next;
37            }
38            else {
39                k.next = j;
40                j = j.next;
41            }
42            k = k.next;
43        }
44        if(i==null) k.next =j;
45        else k.next = i;
46        return dummy.next;
47    }
48}