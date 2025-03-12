//시간복잡도: O(1)
//공간복잡도: n
class HashTable {
    int key;
    int value;

    public HashTable(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    HashTable[] hashTables;

    public MyHashMap() {
        hashTables = new HashTable[10_000_000];
    }
    
    public void put(int key, int value) {
        hashTables[key] = new HashTable(key, value);
    }
    
    public int get(int key) {
        if(hashTables[key] == null) {
            return -1;
        }

        return hashTables[key].value;
    }
    
    public void remove(int key) {
        hashTables[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */