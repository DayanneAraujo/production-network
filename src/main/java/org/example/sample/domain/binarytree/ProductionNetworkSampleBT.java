package org.example.sample.domain.binarytree;

import org.example.sample.domain.Coordinate;
import org.example.sample.domain.Profile;
import org.example.sample.domain.ProductionNetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ProductionNetworkSampleBT implements ProductionNetwork<BinaryTreeComponent> {
    public Profile getProfile(BinaryTreeComponent source) {
        Queue<BinaryTreeComponent> queue = new LinkedList<>();
        queue.add(source);

        var coordinates = new HashMap<String, Coordinate>();
        double distance = 0;

        StringBuilder path = new StringBuilder();

        while (!queue.isEmpty()) {
            if (!path.isEmpty()) {
                path.append("/");
            }

            BinaryTreeComponent current = queue.poll();
            if (current == null) {
                throw new AssertionError();
            }

            path.append(current.getName());
            coordinates.put(current.getName(), new Coordinate(distance, current.getTemperature()));
            distance += current.getDistance();

            if (current.getPointerLeft().isPresent()) {
                queue.add(current.getPointerLeft().get());
            }

            if (current.getPointerRight().isPresent()) {
                queue.add(current.getPointerRight().get());
            }
        }

        return new Profile(path.toString(), coordinates);
    }

    public Set<Profile> getAllProfiles(Set<BinaryTreeComponent> source) {
        return null;
    }
}
