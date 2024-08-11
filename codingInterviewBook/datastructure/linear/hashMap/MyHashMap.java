package datastructure.linear.hashMap;

public class MyHashMap {

    public static class MapNode {
        int key;
        int value;
        MapNode next;

        public MapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    MapNode[] nodes;

    public MyHashMap() {
        this.size = 100000;
        this.nodes = new MapNode[size];
    }

    public void put(int key, int value) {
        MapNode newMapNode = new MapNode(key, value);
        // hashing
        int hashKey = hashing(key);
        // 최초에 아무것도 없을 때
        if (nodes[hashKey] == null) {
            nodes[hashKey] = newMapNode;
            return;
        }
        // 이미 값이 있는 경우에는 연결리스트로
        MapNode node = nodes[hashKey];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            if (node.next == null) {
                node.next = newMapNode;
                break;
            }
            node = node.next;
        }
    }

    public int get(int key) {
        int hashKey = hashing(key);
        if (nodes[key] == null) {
            return -1;
        }
        MapNode node = nodes[hashKey];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = hashing(key);
        if (nodes[hashKey] == null) {
            return;
        }
        MapNode node = nodes[hashKey];
        if (node.key == key) {
            if (node.next == null) {
                nodes[hashKey] = null;
            } else {
                nodes[hashKey] = node.next;
                return;
            }
        }
        MapNode prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    private int hashing(int key) {
        return key % nodes.length;
    }
}
