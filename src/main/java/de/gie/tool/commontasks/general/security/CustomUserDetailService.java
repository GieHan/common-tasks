package de.gie.tool.commontasks.general.security;


import de.gie.tool.commontasks.general.security.model.UserCredential;
import de.gie.tool.commontasks.general.security.model.UserCredentialRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserCredentialRepository userCredentialRepository;

    public CustomUserDetailService(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredential userCredential = userCredentialRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user with this username."));

        return new User(userCredential.getUserName(), userCredential.getPassword(), Collections.emptyList());
    }
}
