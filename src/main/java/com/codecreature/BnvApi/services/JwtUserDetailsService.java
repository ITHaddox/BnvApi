package com.codecreature.BnvApi.services;

import com.codecreature.BnvApi.models.BnvUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("tyler".equals(username)){
            return new User("tyler", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("BnvUser not found with username: " + username);
        }
    }



    public BnvUser loginUser(String username){
        Query query = entityManager.createNamedQuery("find_valid_user");
        query.setParameter("username", username);

        return (BnvUser) query.getSingleResult();

    }
}
