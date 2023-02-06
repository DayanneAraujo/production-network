package org.example.sample.domain.linkedlist;

import org.example.sample.domain.Coordinate;
import org.example.sample.domain.Profile;
import org.example.sample.infrastructure.LinkedListRepo;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductionNetworkSampleTest {

    @Test
    public void testSingleNode() {
        final String componentName = "Sink";
        var sink = new LinkedListComponent(componentName, null, 0, 100);
        var productionNetwork = new ProductionNetworkSampleLL();

        Profile profile = productionNetwork.getProfile(sink);

        assertEquals(1, profile.getCoordinates().size());
        assertEquals(0, profile.getCoordinates().get(componentName).getDistance());
        assertEquals(100, profile.getCoordinates().get(componentName).getTemperature());
        assertEquals(componentName, profile.getPath());
    }

    @Test
    public void testSinglePathOnProductionNetwork() {
        String expectedPath = "Source-1/Valve-1/Compressor-1/Gathering-Center-1/Sink";

        var sampleComponentsRepo = new LinkedListRepo();
        Optional<LinkedListComponent> source = sampleComponentsRepo.fetchSource("Source-1");

        var productionNetwork = new ProductionNetworkSampleLL();

        if (source.isEmpty()) {
            fail();
        }

        Profile profile = productionNetwork.getProfile(source.get());
        var coordinatesResult = profile.getCoordinates();
        Map<String, Coordinate> coordinatesExpected = getExpectedCoordinatesMap();

        assertEquals(expectedPath, profile.getPath());
        assertEquals(5, coordinatesResult.size());

        for (String componentName : coordinatesExpected.keySet()) {
            assertEquals(coordinatesExpected.get(componentName), coordinatesResult.get(componentName));
        }
    }

    @Test
    public void testSmokeProductionFindsAllPaths() {
        ProductionNetworkSampleLL productionNetwork = new ProductionNetworkSampleLL();
        Set<Profile> profilesResult = productionNetwork.getAllProfiles(new LinkedListRepo().fetchSources());
        Set<String> expectedPaths = getExpectedPaths();

        assertEquals(3, profilesResult.size());

        for (Profile profile : profilesResult) {
            assertTrue(expectedPaths.contains(profile.getPath()));
        }
    }

    private static Set<String> getExpectedPaths() {
        return Set.of(
                "Source-1/Valve-1/Compressor-1/Gathering-Center-1/Sink",
                "Source-2/Valve-2/Valve-3/Compressor-2/Gathering-Center-1/Sink",
                "Source-3/Valve-4/Compressor-3/Gathering-Center-1/Sink"
        );
    }

    private static Map<String, Coordinate> getExpectedCoordinatesMap() {
        return Map.of(
                "Source-1", new Coordinate(0, 100.0),
                "Valve-1", new Coordinate(100.0, 130.0),
                "Compressor-1", new Coordinate(400.0, 95.0),
                "Gathering-Center-1", new Coordinate(800.0, 100.0),
                "Sink", new Coordinate(1000.0, 65.0));
    }

}