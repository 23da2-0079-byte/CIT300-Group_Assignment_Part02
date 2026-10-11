import java.util.*;

public class Graph<T> {
// Adjacency list representation
private Map<T, List<T>> adjacencyList = new HashMap<>();

// Adds a vertex to the graph
public void addVertex(T vertex) {
adjacencyList.putIfAbsent(vertex, new ArrayList<>());
}

// Adds an undirected edge between source and destination
public void addEdge(T source, T destination) {
addVertex(source);
addVertex(destination);
adjacencyList.get(source).add(destination);
adjacencyList.get(destination).add(source); // Remove this line if the graph is directed
}

// Breadth-First Search (BFS) Traversal
public List<T> bfs(T startVertex) {
List<T> traversalResult = new ArrayList<>();
if (!adjacencyList.containsKey(startVertex)) {
return traversalResult;
}

Set<T> visited = new HashSet<>();
Queue<T> queue = new LinkedList<>();

visited.add(startVertex);
queue.add(startVertex);

while (!queue.isEmpty()) {
T current = queue.poll();
traversalResult.add(current);

for (T neighbor : adjacencyList.get(current)) {
if (!visited.contains(neighbor)) {
visited.add(neighbor);
queue.add(neighbor);
}
}
}

return traversalResult;
}

// Depth-First Search (DFS) Traversal (Iterative)
public List<T> dfs(T startVertex) {
List<T> traversalResult = new ArrayList<>();
if (!adjacencyList.containsKey(startVertex)) {
return traversalResult;
}

Set<T> visited = new HashSet<>();
Stack<T> stack = new Stack<>();

stack.push(startVertex);

while (!stack.isEmpty()) {
T current = stack.pop();

if (!visited.contains(current)) {
visited.add(current);
traversalResult.add(current);

// Push neighbors in reverse order to visit them left-to-right if desired
List<T> neighbors = adjacencyList.get(current);
for (int i = neighbors.size() - 1; i >= 0; i--) {
T neighbor = neighbors.get(i);
if (!visited.contains(neighbor)) {
stack.push(neighbor);
}
}
}
}

return traversalResult;
}
}

