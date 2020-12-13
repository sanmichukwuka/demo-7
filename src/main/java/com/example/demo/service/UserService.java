package com.example.demo.service;

//import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private RoleRepository roleRepository;
    
//    @Autowired
//    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//    	this.userRepository = userRepository;
//    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//    
    public User findByUsername(String userName) {
		
        // fill this portion in
   	return userRepository.findByUserName(userName);
    	
    }

    public void saveNew(User user) {
        // fill this portion in //
    	userRepository.save(user);
    }

    public void saveExisting(User user) {
        // fill this portion in
    	user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        userRepository.save(user);
    	 
    }

    public User getLoggedInUser() {
		
        // fill this portion in
    	String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
    	return findByUsername(loggedInUserName);
    }

    public void updateCart(Map<Product, Integer> cart) {
		  // fill this portion in
    	
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	  // fill this portion in
    	User user = findByUsername(username);
    	UserBuilder builder = null;
    	
    	if (user != null) {
    		builder = org.springframework.security.core.userdetails.User.withUsername(username);
    		builder.password(new BCryptPasswordEncoder().encode(user.getPassWord()));
//    		builder.roles(roles);
    	} else {
    	      throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}







