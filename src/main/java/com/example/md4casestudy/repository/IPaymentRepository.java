package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

    @Query(nativeQuery = true, value = "select * from payments p where p.student_studentid = :studentId")
    Iterable<Payment> findByStudentId(@Param("studentId") Long studentId);
}