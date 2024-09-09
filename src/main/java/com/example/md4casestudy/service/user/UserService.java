package com.example.md4casestudy.service.user;

import com.example.md4casestudy.model.AppUser;
import com.example.md4casestudy.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService {


    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Override
    public Iterable<AppUser> findAll() {
        return iAppUserRepository.findAll();
    }

    @Override
    public void save(AppUser appUser) {

    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
