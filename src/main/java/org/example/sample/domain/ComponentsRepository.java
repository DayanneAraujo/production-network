package org.example.sample.domain;

import org.example.sample.domain.Component;

import java.util.Optional;
import java.util.Set;

public interface ComponentsRepository<T> {
    Set<T> fetchSources();
    Optional<T> fetchSource(final String sourceName);
}

