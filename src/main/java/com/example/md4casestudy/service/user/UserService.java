package com.example.md4casestudy.service.user;

import com.example.md4casestudy.model.User;
import com.example.md4casestudy.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService {


    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Override
    public Iterable<User> findAll() {
        return iAppUserRepository.findAll();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
