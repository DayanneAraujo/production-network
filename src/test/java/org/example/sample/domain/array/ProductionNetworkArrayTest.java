package org.example.sample.domain.array;

import org.example.sample.domain.Component;
import org.example.sample.domain.Coordinate;
import org.example.sample.domain.Profile;
import org.example.sample.infrastructure.ArrayRepo;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductionNetworkArrayTest {
    @Test
    public void testSingleNode() {
        final String componentName = "Sink";
        Component[] sink = {new Component(componentName, 0, 100)};
        var productionNetwork = new ProductionNetworkArray();

        Profile profile = productionNetwork.getProfile(sink);

        assertEquals(1, profile.getCoordinates().size());
        assertEquals(0, profile.getCoordinates().get(componentName).getDistance());
        assertEquals(100, profile.getCoordinates().get(componentName).getTemperature());
        assertEquals(componentName, profile.getPath());
    }

    @Test
    public void testSinglePathOnProductionNetwork() {
        String expectedPath = "Source-1/Valve-1/Compressor-1/Gathering-Center-1/Sink";

        Component sink = new Component("Sink", 0, 65);
        Component gathering = new Component( "Gathering-Center-1", 200, 100);
        Component compressor1 = new Component("Compressor-1", 400, 95);
        Component valve1 = new Component("Valve-1", 300, 130);
        Component source1 = new Component("Source-1", 100, 100);

        Component[] components = {source1, valve1, compressor1, gathering, sink};

        var repo = new ArrayRepo();
        Set<Component[]> componentsStructure = repo.fetchInputComponents();

        var productionNetwork = new ProductionNetworkArray();
        Profile profile = productionNetwork.getProfile(components);

        var coordinatesResult = profile.getCoordinates();
        Map<String, Coordinate> coordinatesExpected = getExpectedCoordinatesMap();

        assertEquals(expectedPath, profile.getPath());
        assertEquals(5, coordinatesResult.size());

        for (String componentName : coordinatesExpected.keySet()) {
            assertEquals(coordinatesExpected.get(componentName), coordinatesResult.get(componentName));
        }
    }

    @Test
    public void testProductionFindsAllPaths() {
        var productionNetwork = new ProductionNetworkArray();
        Set<Profile> profilesResult = productionNetwork.getAllProfiles(new ArrayRepo().fetchInputComponents());
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