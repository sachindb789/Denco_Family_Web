package com.dencofamily.popeyes.punch.service;

import com.dencofamily.popeyes.punch.model.Users;
import com.dencofamily.popeyes.punch.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(Users users) {
        // Encrypt password before storing it
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.saveUser(users) > 0;
    }

    public Users loginUser(String email, String password) {
        Users users = usersRepository.findByEmail(email);
        if (users != null && passwordEncoder.matches(password, users.getPassword())) {
            return users;
        }
        return null; // Return null if credentials do not match
    }
    // ✅ Fetch user by Email
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


}
