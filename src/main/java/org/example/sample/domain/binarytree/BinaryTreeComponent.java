package org.example.sample.domain.binarytree;

import org.example.sample.domain.Component;

import java.util.Optional;

public class BinaryTreeComponent extends Component {
    private BinaryTreeComponent pointerLeft;
    private BinaryTreeComponent pointerRight;

    public BinaryTreeComponent(final String name,
                               final double distance,
                               final double temperature,
                               final BinaryTreeComponent pointerLeft,
                               final BinaryTreeComponent pointerRight) {
        super(name, distance, temperature);
        this.pointerLeft = pointerLeft;
        this.pointerRight = pointerRight;
    }

    public Optional<BinaryTreeComponent> getPointerLeft() {
        return Optional.ofNullable(pointerLeft);
    }

    public Optional<BinaryTreeComponent> getPointerRight() {
        return Optional.ofNullable(pointerRight);
    }
}
