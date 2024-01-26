package com.amr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amr.entity.Details;

@Repository
public interface DataRepository extends JpaRepository <Details, Long> {

}
