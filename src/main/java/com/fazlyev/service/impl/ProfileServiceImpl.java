package com.fazlyev.service.impl;

import com.fazlyev.model.Profile;
import com.fazlyev.repository.ProfileRepository;
import com.fazlyev.service.ProfileService;
import org.springframework.stereotype.Service;


@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }
}