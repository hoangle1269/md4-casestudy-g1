package com.example.md4casestudy.service.appUser;

import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.UserPrinciple;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private UserRepository appUserRepo;
    @Autowired
    private EmailService emailService;

    @Override
    public Iterable<User> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return appUserRepo.findById(id);
    }

    @Override
    public void save(User appUser) {
        appUserRepo.save(appUser);
        String email = appUser.getEmail();
        String username = appUser.getFullName();
        String password = appUser.getPassword();
        String subject = "Your account has been created";
        String text = String.format("Hello %s,\n\nYour account has been created successfully.\nAccount: %s\nPassword: %s\n\nBest regards", username, email, password);

        emailService.sendEmail(email, subject, text);
    }

    @Override
    public void remove(Long id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> userOptional = appUserRepo.findByEmail(userEmail);
        User user = userOptional.get();
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + userEmail);
        }
        return UserPrinciple.build(user);
    }
}