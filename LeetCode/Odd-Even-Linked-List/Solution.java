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
12    public ListNode oddEvenList(ListNode head) {
13        if(head==null || head.next==null) return head;
14        ListNode evenHead=null, evenTail=null;
15        ListNode oddHead=null, oddTail=null;
16
17        ListNode curr=head;
18        int i=1;
19
20        while(curr!=null){
21            if(i%2==0){
22                if(evenHead==null){
23                evenHead=curr;
24                evenTail=curr;
25                }
26                else{
27                    evenTail.next=curr;
28                    evenTail=evenTail.next;
29                }
30            }
31            else{
32                if(oddHead==null){
33                    oddHead=curr;
34                    oddTail=curr;
35                }
36                else{
37                    oddTail.next=curr;
38                    oddTail=oddTail.next;
39                }
40            }
41            curr=curr.next;
42            i++;
43        }
44       oddTail.next=evenHead;
45       evenTail.next=null;
46       return oddHead;
47    }
48}