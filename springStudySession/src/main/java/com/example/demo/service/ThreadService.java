package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ThreadEntity;
import com.example.demo.form.ThreadForm;
import com.example.demo.repository.ThreadRepository;

@Service
public class ThreadService {
	@Autowired
	ThreadRepository repository;

	public Page<ThreadEntity> getEntity(int pageNum) {
		return repository.getEntity(pageNum);
	}

	public void insert(ThreadForm form) {
		ThreadEntity entity = new ThreadEntity();
		BeanUtils.copyProperties(form, entity);
		entity.setId(null);
		repository.insert(entity);
	}

	public ThreadEntity getOne(Integer id) {
		return repository.getOne(id);
	}

	public void update(ThreadForm form) {
		ThreadEntity entity = new ThreadEntity();
		BeanUtils.copyProperties(form, entity);
		repository.update(entity);
	}

	public void delete(Integer id) {
		repository.delete(id);
	}

}
