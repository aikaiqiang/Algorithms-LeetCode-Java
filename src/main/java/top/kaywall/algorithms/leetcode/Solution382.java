package top.kaywall.algorithms.leetcode;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @desc
 * @author Kaiqiang Ai
 * @addTime 2022/01/16 09:22:57
 */
public class Solution382 {

    ListNode head;

    List<Integer> list;

    SecureRandom random;

//    public Solution382(ListNode head){
//        list = new ArrayList<>();
//        while (head != null){
//            list.add(head.val);
//            head = head.next;
//        }
//        random = new SecureRandom();
//    }

    public Solution382(ListNode head){
        this.head = head;
        random = new SecureRandom();
    }

//    public int getRandom(){
//        return list.get(random.nextInt(list.size()));
//    }

    public int getRandom(){
        int i = 1;
        int ans = 0;
        for(ListNode node = head; node != null; node = node.next){
            if(random.nextInt(i) == 0){
                ans = node.val;
            }
            i++;
        }
        return ans;
    }



    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Solution382 solution = new Solution382(listNode);
        System.out.println("随机获取：" + solution.getRandom());

    }

}


class ListNode{

    int val;
    ListNode next;
    ListNode(){}

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }



}



