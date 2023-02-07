package org.example.sample.domain;

import org.example.sample.domain.Profile;

import java.util.Set;

public interface ProductionNetwork<T> {
    Profile getProfile(final T componentsStructure);
    Set<Profile> getAllProfiles(final Set<T> componentsStructure);
}
