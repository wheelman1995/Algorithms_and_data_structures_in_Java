import java.util.*;

public class Graph {
    private class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }

        @Override
        public String toString() {
            return "V:" + label;
        }
    }

    private final int MAX_VERTICES;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;
    private TreeMap<Character, Integer> map;
    private ArrayList<Integer> path;

    public Graph(int size) {
        this.MAX_VERTICES = size;
        vertices = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        map = new TreeMap<>();
        path = new ArrayList<>();
    }

    public void addVertex(char label) {
        map.put(label, size);
        vertices[size++] = new Vertex(label);
    }

    public void addEdge(char label, char label2) {
        int v = map.get(label);
        int v2 = map.get(label2);
        adjMatrix[v][v2] = 1;
        adjMatrix[v2][v] = 1;
    }

    public void showVertex(int vertex) {
        System.out.println(vertices[vertex]);
    }

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertices[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void depthTravers() {
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                vertices[v].wasVisited = true;
                showVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    public void widthTraverseSearch(char label){
        int v = map.get(label);
        
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        queue.insert(0);
        while (!queue.isEmpty()){
            int vCurr = queue.remove();
            if (vCurr == v) {
                path.add(vCurr);
                break;
            }
            int vNext;
            
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                vertices[vNext].wasVisited = true;
                if (vNext == v) {
                    path.add(vNext);
                    
                    map.entrySet().forEach(entry -> {
                        if (entry.getValue() == vCurr) {
                            resetFlags();
                            widthTraverseSearch(entry.getKey());
                        }
                    });
                    return;
                }
                queue.insert(vNext);
                
            }
        }
        resetFlags();
    
        for (int i = path.size() - 1; i >= 0 ; i--) {
            int w = i;
            map.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), path.get(w)))
                    .findFirst()
                    .ifPresent(entry -> System.out.printf("%s ", entry.getKey()));
        }
    }
}
