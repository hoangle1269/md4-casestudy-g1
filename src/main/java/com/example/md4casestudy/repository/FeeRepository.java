package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public interface FeeRepository extends JpaRepository<Fee, Long> {

    @Query("SELECT f FROM Fee f WHERE f.dueDate BETWEEN :currentDate AND :threeDaysLater")
    List<Fee> findFeesDueSoon(@Param("currentDate") Date currentDate, @Param("threeDaysLater") Date threeDaysLater);

    @Query(nativeQuery = true, value = "select * from fees f where f.studentid = :studentId")
    Optional<Fee> findByStudentId(Long studentId);

    @Query(nativeQuery = true, value = "select * from fees f where f.studentid = :studentId")
    List<Fee> findByStudent(Long studentId);


}
