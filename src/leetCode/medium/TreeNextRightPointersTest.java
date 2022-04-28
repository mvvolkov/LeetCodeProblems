package leetCode.medium;

import org.junit.Test;

public class TreeNextRightPointersTest {

    @Test
    public void test1() {
        int n = 20;
        Node root = createTree(n);
//        bfs(root, node -> System.out.println("" + node.val));
    }

    @Test
    public void test2() {
        int n = 20;
        Node root = createTree(n);
        setNextPointers(root);
        int a = 1;
    }

    Node createTree(int n) {
        Queue<Node> queue = new Queue<>();
        Node root = null;
        Node currentParent = null;
        boolean left = true;
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            if (root == null) {
                root = node;
            }
            if (left) {
                currentParent = queue.getFirst();
            }

            if (currentParent != null) {
                if (left) {
                    currentParent.left = node;
                } else {
                    currentParent.right = node;
                }
                left = !left;
            }
            queue.add(node);
        }
        return root;
    }

    private static Node getNode(Node root, int n) {
        Node result = root;
        int bitsNumber = 0;
        int i = n;
        while (i > 0) {
            i >>= 1;
            bitsNumber++;
        }
        int mask = 1 << (bitsNumber - 2);
        bitsNumber--;
        while (bitsNumber > 0 && result != null) {
            if ((n & mask) == 0) {
                result = result.left;
            } else {
                result = result.right;
            }
            mask >>= 1;
            bitsNumber--;
        }
        return result;
    }

    void setNextPointers(Node root) {

        Node node = root;
        Node prevNode = root;
        int i = 2;
        while (node != null) {
            node = getNode(root, i++);
            prevNode.next = node;
            prevNode = node;
        }
        Node rightNode = root;
        while (rightNode != null) {
            rightNode.next = null;
            rightNode = rightNode.right;
        }
//        if (true) {
//            return;
//        }
//
//
//        Queue<Node> queue = new Queue<>();
//        queue.add(root);
//        prevNode = null;
//        node = queue.getFirst();
//        while (node != null) {
//            if (prevNode != null) {
//                prevNode.next = node;
//            }
//            prevNode = node;
//            if (node.left != null) {
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//            node = queue.getFirst();
//        }
//        Node rightNode = root;
//        while (rightNode != null) {
//            rightNode.next = null;
//            rightNode = rightNode.right;
//        }
    }

    private static class QueueNode<T> {
        final T value;
        QueueNode<T> next;

        QueueNode(T value) {
            this.value = value;
        }
    }

    private static class Queue<T> {
        QueueNode<T> first;
        QueueNode<T> last;

        void add(T value) {
            QueueNode<T> node = new QueueNode<>(value);
            if (last == null) {
                first = node;
            } else {
                last.next = node;
            }
            last = node;
        }

        boolean isEmpty() {
            return first == null;
        }

        T getFirst() {
            if (first == null) {
                return null;
            }
            QueueNode<T> t = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return t.value;
        }
    }


    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}
