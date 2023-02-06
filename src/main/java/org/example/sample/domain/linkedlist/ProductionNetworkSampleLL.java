package org.example.sample.domain.linkedlist;

import org.example.sample.domain.Coordinate;
import org.example.sample.domain.ProductionNetwork;
import org.example.sample.domain.Profile;

import java.util.*;

public class ProductionNetworkSampleLL implements ProductionNetwork<LinkedListComponent> {
    @Override
    public Set<Profile> getAllProfiles(final Set<LinkedListComponent> sources) {
        var profiles = new HashSet<Profile>();

        for(LinkedListComponent source : sources) {
            profiles.add(getProfile(source));
        }

        return profiles;
    }

    @Override
    public Profile getProfile(final LinkedListComponent source) {
        StringBuilder path = new StringBuilder();
        path.append(source.getName());

        var coordinates = new HashMap<String, Coordinate>();
        coordinates.put(source.getName(), new Coordinate(0, source.getTemperature()));

        LinkedListComponent component = source;

        while (component.getNext().isPresent()) {
            LinkedListComponent next = component.getNext().get();
            appendString(path, next.getName());

            double currentDistance = coordinates.get(component.getName()).getDistance();
            double nextDistance = currentDistance + component.getDistance();

            coordinates.put(next.getName(), new Coordinate(nextDistance, next.getTemperature()));

            component = next;
        }

        return new Profile(path.toString(), coordinates);
    }

    private static void appendString(StringBuilder path, String componentName) {
        path.append("/");
        path.append(componentName);
    }
}
