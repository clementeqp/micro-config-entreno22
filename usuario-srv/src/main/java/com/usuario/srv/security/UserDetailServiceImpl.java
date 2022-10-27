package com.usuario.srv.security;

import com.usuario.srv.entity.UserDB;
import com.usuario.srv.repository.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDBRepository userDBRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDB user = userDBRepository
                .findOneByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("El usuario con email "  + email + " no existe."));
        return new UserDetailsImpl(user);
    }
}
