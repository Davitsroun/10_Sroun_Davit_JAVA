class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void display() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> student = new Pair<>("Alice", 20);
        student.display();
        Pair<Integer, Double> product = new Pair<>(101, 99.99);
        product.display();
    }
}
