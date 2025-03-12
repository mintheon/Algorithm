//시간복잡도: O(1)
//공간복잡도: n

class MyHashMap {

    int[] hashTables;

    public MyHashMap() {
        hashTables = new int[10_000_000];
        Arrays.fill(hashTables, -1);
    }
    
    public void put(int key, int value) {
        hashTables[key] = value;
    }
    
    public int get(int key) {
        return hashTables[key];
    }
    
    public void remove(int key) {
        hashTables[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */