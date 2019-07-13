package RLU;

class RLUNode{
    String key;
    Object value;
    RLUNode next;
    RLUNode pre;

    public RLUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
public class RLUCache {
    RLUNode head;
    int size = 0;// 当前大小
    int capacity = 0; // 最大容量

    public RLUCache(int capacity) {
        this.capacity = capacity;
    }

    public Object get(String key) {
        RLUNode cur = head;
        RLUNode pre = head;// 指向要删除节点的前驱
        // 找到对应的节点，并把对应的节点放在链表头部
        // 先考虑特殊情况
        if(head == null)
            return null;
        if(cur.key.equals(key))
            return cur.value;
        // 进行查找
        cur = cur.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 代表没找到了节点
        if (cur == null)
            return null;

        // 进行删除
        pre.next = cur.next;
        // 删除之后插入头结点
        cur.next = head;
        head = cur;
        return cur.value;
    }

    public void put(String key, Object value) {
        // 如果最大容量是 1，那就没办法了，，，，，
        if (capacity == 1) {
            head = new RLUNode(key, value);
        }
        RLUNode cur = head;
        RLUNode pre = head;
        // 先查看链表是否为空
        if (head == null) {
            head = new RLUNode(key, value);
            return;
        }
        // 先查看该节点是否存在
        // 第一个节点比较特殊，先进行判断
        if (head.key.equals(key)) {
            head.value = value;
            return;
        }
        cur = cur.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 代表要插入的节点的 key 已存在，则进行 value 的更新
        // 以及把它放到第一个节点去
        if (cur != null) {
            cur.value = value;
            pre.next = cur.next;
            cur.next = head;
            head = cur;
        } else {
            // 先创建一个节点
            RLUNode tmp = new RLUNode(key, value);
            // 该节点不存在，需要判断插入后会不会溢出
            if (size >= capacity) {
                // 直接把最后一个节点移除
                cur = head;
                while (cur.next != null && cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
                tmp.next = head;
                head = tmp;
            }
        }
    }
}
