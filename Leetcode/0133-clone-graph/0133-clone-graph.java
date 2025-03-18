/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Node, Node> cloneMap = new HashMap<>();

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(node);

        Node newRoot = new Node(node.val);
        cloneMap.put(node, newRoot);

        while(!deque.isEmpty()) {
            Node cur = deque.poll();

            for(Node neighbor : cur.neighbors) {
                if(!cloneMap.containsKey(neighbor)) {
                    Node newNeighbor = new Node(neighbor.val);
                    cloneMap.put(neighbor, newNeighbor);
                    deque.offer(neighbor);
                }

                cloneMap.get(cur).neighbors.add(cloneMap.get(neighbor));
            }
        }

        return newRoot;
    }
}