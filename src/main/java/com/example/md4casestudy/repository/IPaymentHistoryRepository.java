package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.DTO.PaymentDTO;
import com.example.md4casestudy.model.Payment;
import com.example.md4casestudy.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IPaymentHistoryRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT new com.example.md4casestudy.model.DTO.PaymentDTO(f.feeId, f.amount, f.status, f.dueDate,p.paymentId,p.paymentDate, p.paymentAmount) FROM Fee f LEFT JOIN Payment p ON f.feeId = p.paymentId WHERE f.student.studentId = :studentId ORDER BY f.dueDate ASC")
    List<PaymentDTO> findPaymentHistoryByStudentId(@Param("studentId") Long studentId);

}
