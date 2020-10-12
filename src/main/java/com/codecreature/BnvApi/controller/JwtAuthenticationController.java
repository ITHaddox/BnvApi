package com.codecreature.BnvApi.controller;


import com.codecreature.BnvApi.models.BnvUser;
import com.codecreature.BnvApi.models.JwtRequest;
import com.codecreature.BnvApi.models.JwtResponse;
import com.codecreature.BnvApi.repository.UserJpaRepository;
import com.codecreature.BnvApi.services.JwtUserDetailsService;
import com.codecreature.BnvApi.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class JwtAuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private JwtUserDetailsService jwtInMemoryUserDetailsService;
    

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        logger.warn("JwtAuthenticationController has been reached");
        logger.warn("jwtRequest username: " + jwtRequest.getUsername() + "     password: " + jwtRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        }
        catch (DisabledException e){
            throw new Exception("BnvUser disabled", e);
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


//        final UserDetails userDetails = jwtInMemoryUserDetailsService
//                .loadUserByUsername(jwtRequest.getUsername());

//        final String token = jwtTokenUtil.generateToken(userDetails);


        final BnvUser bnvUser = userJpaRepository.loginUser(jwtRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(bnvUser);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
