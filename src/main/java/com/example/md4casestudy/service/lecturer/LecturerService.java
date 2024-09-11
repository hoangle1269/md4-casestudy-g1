package com.example.md4casestudy.service.lecturer;

import com.example.md4casestudy.model.Lecturer;
import com.example.md4casestudy.repository.ILecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LecturerService implements ILecturerService {

    @Autowired
    private ILecturerRepository iLecturerRepository;

    @Override
    public Iterable<Lecturer> findAll() {
        return iLecturerRepository.findAll();
    }

    @Override
    public void save(Lecturer lecturer) {
    iLecturerRepository.save(lecturer);
    }

    @Override
    public Optional<Lecturer> findById(Long lecturerId) {
        return iLecturerRepository.findById(lecturerId);
    }

    @Override
    public void remove(Long id) {

    }
}
