package com.example.md4casestudy.service.classes;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.repository.IClassRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    private IClassRepos iClassRepos;


    @Override
    public Iterable<Classes> findAll() {
        return iClassRepos.findAll();
    }

    @Override
    public void save(Classes classes) {
        iClassRepos.save(classes);
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return iClassRepos.findById(id);
    }

    @Override
    public void remove(Long id) {
        iClassRepos.deleteById(id);
    }
}
