package RLU;
import java.util.HashMap;
import java.util.Map;

public class RLUCache2 {
    Map<String, RLUNode> map = new HashMap<>();
    RLUNode head;
    RLUNode tail;
    // 缓存最大容量，我们假设最大容量大于 1，
    // 当然，小于等于1的话需要多加一些判断另行处理
    int capacity;

    public RLUCache2(int capacity) {
        this.capacity = capacity;
    }

    public void put(String key, Object value) {
        if (head == null) {
            head = new RLUNode(key, value);
            tail = head;
            map.put(key, head);
        }
        RLUNode node = map.get(key);
        if (node != null) {
            // 更新值
            node.value = value;
            // 把他从链表删除并且插入到头结点
            removeAndInsert(node);
        } else {
            RLUNode tmp = new RLUNode(key, value);
            // 如果会溢出
            if (map.size() >= capacity) {
                map.remove(tail);
                tail = tail.pre;
                tail.next = null;
            }
            map.put(key, tmp);
            // 插入
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
        }
    }

    public Object get(String key) {
        RLUNode node = map.get(key);
        if (node != null) {
            // 把这个节点删除并插入到头结点
            removeAndInsert(node);
            return node.value;
        }
        return null;
    }
    private void removeAndInsert(RLUNode node) {
        // 特殊情况先判断，例如该节点是头结点或是尾部节点
        if (node == head) {
            return;
        } else if (node == tail) {
            tail = node.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 插入到头结点
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }

    public void prin() {
        RLUNode cur = head;
        while (cur != null) {
            System.out.printf("%s  ", (String)cur.value);
            cur = cur.next;
        }
        System.out.printf("\n");

    }


    public static void main(String[] args) {
        RLUCache2 cache2 = new RLUCache2(4);
        cache2.put("1", "1");
        cache2.put("2", "2");
        cache2.put("3", "3");
        cache2.put("4", "4");

        cache2.prin();
        System.out.printf((String)cache2.get("1") + "----");
        cache2.prin();
        cache2.put("3", "5");
        cache2.prin();
    }
}
