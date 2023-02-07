package org.example.sample.domain.array;

import org.example.sample.domain.*;

import java.util.*;

public class ProductionNetworkArray implements ProductionNetwork<Component[]> {
    @Override
    public Profile getProfile(Component[] components) {
        final StringBuilder path = new StringBuilder();
        Component source = components[0];

        path.append(source.getName());

        var coordinates = new HashMap<String, Coordinate>();
        coordinates.put(source.getName(), new Coordinate(0, source.getTemperature()));


        for (int index = 1; index < components.length; index++) {
            Component component = components[index];

            path.append("/");

            path.append(component.getName());
            double previousDistance = coordinates.get(components[index-1].getName()).getDistance();
            double currentDistance = previousDistance + components[index-1].getDistance();

            coordinates.put(component.getName(), new Coordinate(currentDistance, component.getTemperature()));
        }

        return new Profile(path.toString(), coordinates);
    }

    @Override
    public Set<Profile> getAllProfiles(Set<Component[]> componentsStructure) {
        Set<Profile> profiles = new HashSet<>();

        for (Component[] components : componentsStructure) {
            profiles.add(getProfile(components));
        }

        return profiles;
    }
}
