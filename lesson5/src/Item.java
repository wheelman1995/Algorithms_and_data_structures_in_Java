public class Item {
    
    String name;
    int value;
    float weight;
    float volume;
    
    public Item(String name, int value, float weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }
    
    public Item(String name, int value, float weight, float volume) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.volume = volume;
    }
    
}
