//시간복잡도: O(1)
//공간복잡도: n

class Node {
    int key, val;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    Node[] nodes;

    public MyHashMap() {
        this.nodes = new Node[1_000_000];
    }

    public int hash(int key) {
        return key % nodes.length;
    }
    
    public void put(int key, int value) {
        int hash = hash(key);

        if(nodes[hash] == null) {
            nodes[hash] = new Node(key, value);
            return;
        }

        Node node = nodes[hash];
        while(node != null) {
            if(node.key == key) {
                node.val = value;
                return;
            }

            if(node.next == null) {
                break;
            }

            node = node.next;
        }

        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int hash = hash(key);

        if(nodes[hash] == null) {
            return -1;
        }

        Node node = nodes[hash];
        while(node != null) {

            if(node.key == key) {
                return node.val;
            }

            node = node.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hash = hash(key);

        if(nodes[hash] == null) {
            return;
        }

        Node node = nodes[hash];
        if(node.key == key) {
            nodes[hash] = node.next;
            return;
        }

        while(node.next != null) {
            if(node.next.key == key) {
                node.next = node.next.next;
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */