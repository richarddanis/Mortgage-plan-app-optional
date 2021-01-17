package com.mortgage.optional.repository;

import com.mortgage.optional.model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProspectRepository extends JpaRepository<Prospect, String> {
    List<Prospect> findAllByOrderByCreateDateDesc();
}
