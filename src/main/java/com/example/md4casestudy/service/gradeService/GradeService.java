package com.example.md4casestudy.service.gradeService;

import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class GradeService implements IGradeService {
    @Autowired
    GradeRepository gradeRepository;

    @Override
    public Iterable<Grades> findAll() {
        return null;
    }

    @Override
    public Grades findById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Grades grades) {

    }

    @Override
    public void remove(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Grades updateGrades(Grades grade) {
        return gradeRepository.save(grade);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
