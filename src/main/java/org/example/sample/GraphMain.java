package org.example.sample;

import org.example.sample.domain.graph.ProductionNetworkGraph;
import org.example.sample.domain.graph.Vertex;

import java.util.List;

public class GraphMain {
    public static void main(String[] args) {
        ProductionNetworkGraph graph = new ProductionNetworkGraph();

        var source1 = new Vertex("Source-1", 100);
        var valve1 = new Vertex("Valve-1", 130);
        var compressor1 = new Vertex("Compressor-1", 95);
        var gathering = new Vertex("Gathering-Center-1", 100);
        var sink = new Vertex("Sink", 65);

        graph.addVertex(source1);
        graph.addVertex(valve1);
        graph.addVertex(compressor1);
        graph.addVertex(gathering);
        graph.addVertex(sink);

        graph.addEdge(source1, valve1, 100.0);
        graph.addEdge(valve1, compressor1, 300.0);
        graph.addEdge(compressor1, gathering,400.0);
        graph.addEdge(gathering, sink, 200.0);

        var source2 = new Vertex("Source-2", 110);
        var valve2 = new Vertex("Valve-2", 125);
        var valve3 = new Vertex("Valve-3", 115);
        var compressor2 = new Vertex("Compressor-2", 85);

        graph.addVertex(source2);
        graph.addVertex(valve2);
        graph.addVertex(valve3);
        graph.addVertex(compressor2);

        graph.addEdge(source2, valve2, 50.0);
        graph.addEdge(valve2, valve3, 50.0);
        graph.addEdge(valve3, compressor2, 100.0);
        graph.addEdge(compressor2, gathering, 100.0);

        var source3 = new Vertex("Source-3", 120);
        var valve4 = new Vertex("Valve-4", 105);
        var compressor3 = new Vertex("Compressor-3", 75);

        graph.addVertex(source3);
        graph.addVertex(valve4);
        graph.addVertex(compressor3);

        graph.addEdge(source3, valve4, 50.0);
        graph.addEdge(valve4, compressor3, 150.0);
        graph.addEdge(compressor3, gathering, 250.0);

        var source4 = new Vertex("Source-4", 100);
        var valve5 = new Vertex("Valve-5", 90);
        var gathering2 = new Vertex("Gathering-2", 80);
        var sink2 = new Vertex("Sink-2", 70);

        graph.addVertex(source4);
        graph.addVertex(valve5);
        graph.addVertex(gathering2);
        graph.addVertex(sink2);

        graph.addEdge(source4, valve5, 100.0);
        graph.addEdge(valve5, gathering2, 100.0);
        graph.addEdge(gathering2, sink2, 100.0);

        graph.addEdge(compressor3, gathering2, 100.0);

        var profiles = graph.getAllProfiles(
                List.of(source1, source2, source3, source4),
                List.of(sink, sink2));

        System.out.println(profiles);
        System.out.println(profiles.size());
    }
}
