package org.example.sample.domain.graph;

import org.example.sample.domain.Coordinate;
import org.example.sample.domain.Profile;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductionNetworkGraphTest {
    Vertex source1 = new Vertex("Source-1", 100);
    Vertex valve1 = new Vertex("Valve-1", 130);
    Vertex compressor1 = new Vertex("Compressor-1", 95);
    Vertex gathering = new Vertex("Gathering-Center-1", 100);
    Vertex sink = new Vertex("Sink", 65);
    Vertex source2 = new Vertex("Source-2", 110);
    Vertex valve2 = new Vertex("Valve-2", 125);
    Vertex valve3 = new Vertex("Valve-3", 115);
    Vertex compressor2 = new Vertex("Compressor-2", 85);
    Vertex source3 = new Vertex("Source-3", 120);
    Vertex valve4 = new Vertex("Valve-4", 105);
    Vertex compressor3 = new Vertex("Compressor-3", 75);

    Vertex source4 = new Vertex("Source-4", 100);
    Vertex valve5 = new Vertex("Valve-5", 90);
    Vertex gathering2 = new Vertex("Gathering-2", 80);
    Vertex sink2 = new Vertex("Sink-2", 70);
    @Test
    public void testSingleNode() {
        final String componentName = "Sink";
        var productionNetwork = new ProductionNetworkGraph();
        productionNetwork.addVertex(sink);

        var profiles = productionNetwork.getAllProfiles(List.of(sink), List.of(sink));
        var profile = profiles.get(0);

        assertEquals(1, profiles.size());
        assertEquals(componentName, profile.getPath());
        assertEquals(new Coordinate(0, 65), profile.getCoordinates().get(componentName));
    }

    @Test
    public void testSinglePathOnProductionNetwork() {
        ProductionNetworkGraph graph = this.getGraphWithSinglePath();
        String expectedPath = "Source-1/Valve-1/Compressor-1/Gathering-Center-1/Sink";

        var coordinatesMap = new HashMap<>();
        coordinatesMap.put("Source-1", new Coordinate(0, 100));
        coordinatesMap.put("Valve-1", new Coordinate(100, 130));
        coordinatesMap.put("Compressor-1", new Coordinate(400, 95));
        coordinatesMap.put("Gathering-Center-1", new Coordinate(800, 100));
        coordinatesMap.put("Sink", new Coordinate(1000, 65));

        var profiles = graph.getAllProfiles(List.of(source1), List.of(sink));
        var profile = profiles.get(0);

        assertEquals(1, profiles.size());
        assertEquals(expectedPath, profile.getPath());
        assertEquals(coordinatesMap.get("Source-1"), profile.getCoordinates().get("Source-1"));
        assertEquals(coordinatesMap.get("Valve-1"), profile.getCoordinates().get("Valve-1"));
        assertEquals(coordinatesMap.get("Compressor-1"), profile.getCoordinates().get("Compressor-1"));
        assertEquals(coordinatesMap.get("Gathering-Center-1"), profile.getCoordinates().get("Gathering-Center-1"));
        assertEquals(coordinatesMap.get("Sink"), profile.getCoordinates().get("Sink"));
    }

    @Test
    public void testGraphWithMultiplePaths() {
        ProductionNetworkGraph graph = this.getGraphWithMultiplePaths();
        List<Profile> expectedProfiles = this.getExpectedProfiles();

        var profiles = graph.getAllProfiles(
                List.of(source1, source2, source3, source4),
                List.of(sink, sink2));

        assertEquals(5, profiles.size());
        assertEquals(expectedProfiles, profiles);
    }

    private List<Profile> getExpectedProfiles() {
        var coordinatesMap1 = new HashMap<String, Coordinate>();
        var coordinatesMap2 = new HashMap<String, Coordinate>();
        var coordinatesMap3 = new HashMap<String, Coordinate>();
        var coordinatesMap4 = new HashMap<String, Coordinate>();
        var coordinatesMap5 = new HashMap<String, Coordinate>();

        coordinatesMap1.put("Source-1", new Coordinate(0, 100));
        coordinatesMap1.put("Valve-1", new Coordinate(100, 130));
        coordinatesMap1.put("Compressor-1", new Coordinate(400, 95));
        coordinatesMap1.put("Gathering-Center-1", new Coordinate(800, 100));
        coordinatesMap1.put("Sink", new Coordinate(1000, 65));

        coordinatesMap2.put("Source-2", new Coordinate(0, 110));
        coordinatesMap2.put("Valve-2", new Coordinate(50, 125));
        coordinatesMap2.put("Valve-3", new Coordinate(100, 115));
        coordinatesMap2.put("Compressor-2", new Coordinate(200, 85));
        coordinatesMap2.put("Gathering-Center-1", new Coordinate(300, 100));
        coordinatesMap2.put("Sink", new Coordinate(500, 65));

        coordinatesMap3.put("Source-3", new Coordinate(0, 120));
        coordinatesMap3.put("Valve-4", new Coordinate(50, 105));
        coordinatesMap3.put("Compressor-3", new Coordinate(200, 75));
        coordinatesMap3.put("Gathering-Center-1", new Coordinate(450, 100));
        coordinatesMap3.put("Sink", new Coordinate(650, 65));

        coordinatesMap4.put("Source-3", new Coordinate(0, 120));
        coordinatesMap4.put("Valve-4", new Coordinate(50, 105));
        coordinatesMap4.put("Compressor-3", new Coordinate(200, 75));
        coordinatesMap4.put("Gathering-2", new Coordinate(300, 80));
        coordinatesMap4.put("Sink-2", new Coordinate(400, 70));

        coordinatesMap5.put("Source-4", new Coordinate(0, 100));
        coordinatesMap5.put("Valve-5", new Coordinate(100, 90));
        coordinatesMap5.put("Gathering-2", new Coordinate(200, 80));
        coordinatesMap5.put("Sink-2", new Coordinate(300, 70));

        var profile1 = new Profile("Source-1/Valve-1/Compressor-1/Gathering-Center-1/Sink", coordinatesMap1);
        var profile2 = new Profile("Source-2/Valve-2/Valve-3/Compressor-2/Gathering-Center-1/Sink", coordinatesMap2);
        var profile3 = new Profile("Source-3/Valve-4/Compressor-3/Gathering-Center-1/Sink", coordinatesMap3);
        var profile4 = new Profile("Source-3/Valve-4/Compressor-3/Gathering-2/Sink-2", coordinatesMap4);
        var profile5 = new Profile("Source-4/Valve-5/Gathering-2/Sink-2", coordinatesMap5);

        return List.of(profile1, profile2, profile3, profile4, profile5);
    }

    private ProductionNetworkGraph getGraphWithSinglePath() {
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

        return graph;
    }

    private ProductionNetworkGraph getGraphWithMultiplePaths() {
        var graph = new ProductionNetworkGraph();

        graph.addVertex(source1);
        graph.addVertex(valve1);
        graph.addVertex(compressor1);
        graph.addVertex(gathering);
        graph.addVertex(sink);

        graph.addEdge(source1, valve1, 100.0);
        graph.addEdge(valve1, compressor1, 300.0);
        graph.addEdge(compressor1, gathering,400.0);
        graph.addEdge(gathering, sink, 200.0);

        graph.addVertex(source2);
        graph.addVertex(valve2);
        graph.addVertex(valve3);
        graph.addVertex(compressor2);

        graph.addEdge(source2, valve2, 50.0);
        graph.addEdge(valve2, valve3, 50.0);
        graph.addEdge(valve3, compressor2, 100.0);
        graph.addEdge(compressor2, gathering, 100.0);

        graph.addVertex(source3);
        graph.addVertex(valve4);
        graph.addVertex(compressor3);

        graph.addEdge(source3, valve4, 50.0);
        graph.addEdge(valve4, compressor3, 150.0);
        graph.addEdge(compressor3, gathering, 250.0);

        graph.addVertex(source4);
        graph.addVertex(valve5);
        graph.addVertex(gathering2);
        graph.addVertex(sink2);

        graph.addEdge(source4, valve5, 100.0);
        graph.addEdge(valve5, gathering2, 100.0);
        graph.addEdge(gathering2, sink2, 100.0);

        graph.addEdge(compressor3, gathering2, 100.0);

        return graph;
    }
}