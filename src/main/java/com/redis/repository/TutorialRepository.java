package com.redis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial,Integer>{

	List<Tutorial> findByTitleContaining(String title);

}
