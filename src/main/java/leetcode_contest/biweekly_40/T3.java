package leetcode_contest.biweekly_40;

public class T3 {

    static class FrontMiddleBackQueue {
        class Node {
            Node next, pre;
            int val;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head = new Node(-1);
        Node tail = new Node(-1);
        int size;

        public FrontMiddleBackQueue() {
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void pushFront(int val) {
            Node nNode = new Node(val);
            nNode.pre = head;
            nNode.next = head.next;
            head.next.pre = nNode;
            head.next = nNode;
            ++size;
        }

        Node findMidlle() {
            Node fast = head;
            Node slow = head;
            while (fast.next != null && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }


        public void pushMiddle(int val) {
            Node midlle = findMidlle();
            Node node = new Node(val);
            if (size % 2 == 0) {
                node.next = midlle.next;
                node.pre = midlle;
                midlle.next.pre = node;
                midlle.next = node;
            } else {
                node.next = midlle;
                node.pre = midlle.pre;
                midlle.pre.next = node;
                midlle.pre = node;
            }
            ++size;
        }

        public void pushBack(int val) {
            Node nNode = new Node(val);
            nNode.pre = tail.pre;
            nNode.next = tail;
            tail.pre.next = nNode;
            tail.pre = nNode;
            ++size;
        }

        public int popFront() {
            if (head.next == tail) return -1;
            int ans = head.next.val;
            Node next = head.next;
            head.next = next.next;
            next.next.pre = head;
            --size;
            return ans;
        }

        public int popMiddle() {
            if (head.next == tail) return -1;
            Node midlle = findMidlle();
            midlle.pre.next = midlle.next;
            midlle.next.pre = midlle.pre;
            --size;
            return midlle.val;
        }

        public int popBack() {
            if (head.next == tail) return -1;
            Node pre = tail.pre;
            int ans = pre.val;
            pre.pre.next = tail;
            tail.pre = pre.pre;
            --size;
            return ans;
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // 返回 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // 返回 3 -> [4, 2]
        System.out.println(q.popMiddle());    // 返回 4 -> [2]
        System.out.println(q.popBack());      // 返回 2 -> []
        System.out.println(q.popFront());     // 返回 -1 -> [] （队列为空）
    }
}
