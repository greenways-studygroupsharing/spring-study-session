package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ThreadEntity;
import com.example.demo.jpainterface.ThreadJpainterface;

@Repository
public class ThreadRepository {
	@Autowired
	ThreadJpainterface jpa;

	public Page<ThreadEntity> getEntity(int pageNum) {
		return jpa.findAll(PageRequest.of(pageNum, 5, new Sort(Direction.ASC, "id")));
	}

	public void insert(ThreadEntity entity) {
		jpa.save(entity);
	}

	public ThreadEntity getOne(Integer id) {
		return jpa.getOne(id);
	}

	public void update(ThreadEntity entity) {
		jpa.save(entity);
	}

	public void delete(Integer id) {
		jpa.deleteById(id);
	}

}
