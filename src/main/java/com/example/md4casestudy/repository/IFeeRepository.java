package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFeeRepository extends JpaRepository<Fee, Long> {
    @Query(value = "CALL GetNextFeeAndStatus(:studentId)", nativeQuery = true)
    List<Object[]> findNextFeeAndStatus(@Param("studentId") Long studentId);

}
