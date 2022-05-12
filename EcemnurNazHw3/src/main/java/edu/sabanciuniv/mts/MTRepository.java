package edu.sabanciuniv.mts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MTRepository extends JpaRepository<Transfer, Integer> {

}
