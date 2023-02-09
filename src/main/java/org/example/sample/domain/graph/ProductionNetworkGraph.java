package org.example.sample.domain.graph;

import org.example.sample.domain.Coordinate;
import org.example.sample.domain.ProductionNetwork;
import org.example.sample.domain.Profile;

import java.util.*;
import java.util.stream.Collectors;

public class ProductionNetworkGraph {
    private final Map<Vertex, HashMap<Vertex, Double>> adjacencyMatrix;

    public ProductionNetworkGraph() {
        this.adjacencyMatrix = new HashMap<>();
    }

    public void addVertex(Vertex component) {
        this.adjacencyMatrix.putIfAbsent(component, new HashMap<>());
    }

    public void addEdge(Vertex origin, Vertex destination, Double distance) {
        this.adjacencyMatrix.putIfAbsent(origin, new HashMap<>());

        this.adjacencyMatrix.get(origin).put(destination, distance);
    }

    public List<Profile> getAllProfiles(List<Vertex> sources, List<Vertex> sinks) {
        List<Profile> result = new ArrayList<>();
        Queue<List<Vertex>> visited = new LinkedList<>();

        for (var source: sources) {
            visited.add(List.of(source));

            while(!visited.isEmpty()) {
                List<Vertex> path = visited.poll();
                Vertex lastPathComponent = path.get(path.size() -1);

                if (sinks.contains(lastPathComponent)) {
                    String stringPath = this.formatPath(path);
                    HashMap<String, Coordinate> coordinates = getCoordinates(path);
                    result.add(new Profile(stringPath, coordinates));
                } else {
                    HashMap<Vertex, Double> neighbors = adjacencyMatrix.get(lastPathComponent);

                    for(Vertex neighbor: neighbors.keySet()) {
                        var list = new ArrayList<>(path);
                        list.add(neighbor);
                        visited.add(list);
                    }
                }
            }
        }
        return result;
    }

    private HashMap<String, Coordinate> getCoordinates(final List<Vertex> path) {
        double distance = 0;

        var result = new HashMap<String, Coordinate>();

        if (path.size() == 0) {
            return result;
        }

        Vertex currentVertex = path.get(0);
        result.put(currentVertex.getName(), new Coordinate(distance, currentVertex.getTemperature()));

        if (path.size() == 1) {
            return result;
        }

        for (int index = 1; index < path.size() ; index++) {
            HashMap<Vertex, Double> edgeDistanceMap = this.adjacencyMatrix.get(currentVertex);
            var destinationVertex = path.get(index);

            distance += edgeDistanceMap.get(destinationVertex);
            result.put(destinationVertex.getName(),
                    new Coordinate(distance, destinationVertex.getTemperature()));

            currentVertex = destinationVertex;
        }

        return result;
    }

    public String formatPath(final List<Vertex> path) {
        return path.stream().map(Vertex::getName).collect(Collectors.joining("/"));
    }
}
