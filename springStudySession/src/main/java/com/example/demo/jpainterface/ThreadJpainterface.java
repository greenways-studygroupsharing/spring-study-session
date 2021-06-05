package com.example.demo.jpainterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ThreadEntity;

public interface ThreadJpainterface extends JpaRepository<ThreadEntity, Integer> {

}
