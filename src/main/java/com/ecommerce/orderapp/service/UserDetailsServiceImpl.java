package com.ecommerce.orderapp.service;

import com.ecommerce.orderapp.domain.Role;
import com.ecommerce.orderapp.domain.User;
import com.ecommerce.orderapp.payload.UserPayload;
import com.ecommerce.orderapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<String> roleList = new ArrayList<>();
            user.getRoles().stream().forEach(role -> roleList.add(role.getName()));


            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(bCryptPasswordEncoder.encode(user.getPassword()))
                    .disabled(false)
                    .accountExpired(false)
                    .credentialsExpired(false)
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }


    @Override
    @Transactional
    public void addUser(UserPayload userPayload) {
        Optional<Role> optionalRole = roleService.findOne(userPayload.getRole());
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            User user = new User(null, userPayload.getUsername(), userPayload.getPassword(), role, userPayload.getIsActive());
            userRepository.save(user);
        }
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }
}
