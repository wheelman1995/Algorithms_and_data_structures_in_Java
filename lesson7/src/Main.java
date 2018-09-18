public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('h');
        graph.addVertex('i');
        graph.addVertex('j');
    
        graph.addEdge('a', 'b');
        graph.addEdge('a', 'c');
        graph.addEdge('b', 'd');
        graph.addEdge('b', 'e');
        graph.addEdge('d', 'a');
        graph.addEdge('c', 'f');
        graph.addEdge('f', 'g');
        graph.addEdge('d', 'h');
        graph.addEdge('g', 'i');
        graph.addEdge('g', 'j');
        graph.addEdge('h', 'j');
        
        graph.widthTraverseSearch('j');
    }
}
