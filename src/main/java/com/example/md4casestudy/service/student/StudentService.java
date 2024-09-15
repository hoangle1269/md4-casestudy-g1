package com.example.md4casestudy.service.student;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.dto.StudentIdDTO;
import com.example.md4casestudy.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllByClassName(String className) {
        return iStudentRepository.findAllByClasses_ClassName(className);
    }

    @Override
    public List<Student> findByClassId(Long classId) {
        return iStudentRepository.findByClasses_ClassId(classId);
    }



    @Override
    public List<Student> findStudentsByClassIdAndStatus(Long classId, STUDENT_STATUS status) {
        return iStudentRepository.findByClasses_ClassIdAndStatus(classId, status);
    }

    public void flush() {

    }

    public List<StudentIdDTO> listStudent(Long classId) {
        return iStudentRepository.listStudent(classId);
    }

    public <S extends Student> long count(Example<S> example) {
        return 0;
    }

    public <S extends Student> boolean exists(Example<S> example) {
        return false;
    }

//    @Autowired
//    private StudentRepository studentRepository;
//
//    public void updateStatus(Long studentId, STUDENT_STATUS newStatus) {
//        Student student = studentRepository.findById(studentId)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//        student.setStatus(newStatus);
//        studentRepository.save(student);
//    }
//
//    public List<Student> getAllStudentsByClass(Long classId) {
//        return studentRepository.findAllByClasses_ClassId(classId);
//    }
//
//    public Optional<Student> findById(Long studentId) {
//        return studentRepository.findById(studentId);
//    }
//
//    public List<Student> getAllStudents() {
//        return (List<Student>) studentRepository.findAll();
//    }
//
//    public List<StudentScoreDTO> getAllStudentScores() {
//        return studentRepository.findAllStudentScores();
//    }


}