package com.souha.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souha.parfums.entities.Parfum;

public interface ParfumRepository extends JpaRepository<Parfum,Long> {

}
