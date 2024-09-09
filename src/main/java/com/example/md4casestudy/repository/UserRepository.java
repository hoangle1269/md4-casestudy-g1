package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.TeacherStudentCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("SELECT new com.example.md4casestudy.model.dto.TeacherStudentCountDTO(u.id, u.fullName, c.className, COUNT(s.studentId)) FROM User u LEFT JOIN Class c ON u.id = c.lecturer.id LEFT JOIN Student s ON c.classId = s.className.classId WHERE u.role = 'lecturer' GROUP BY u.id, u.fullName, c.className")
    List<TeacherStudentCountDTO> findTeacherStudentCounts();


}
