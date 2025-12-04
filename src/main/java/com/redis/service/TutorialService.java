package com.redis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.redis.model.Tutorial;
import com.redis.repository.TutorialRepository;

@Service
@EnableCaching
public class TutorialService {
	@Autowired
	private TutorialRepository tutorialRepository;
	
	@CacheEvict(value="tutorials",allEntries=true)
	public Integer addTutorial(Tutorial tutorial) {
		return tutorialRepository.save(tutorial).getId();
		
	}
	 @Cacheable("tutorials")
	  public List<Tutorial> findAll() {
	    doLongRunningTask();

	    return tutorialRepository.findAll();
	  }
	 @Cacheable("tutorials")
	  public List<Tutorial> findByTitleContaining(String title) {
	    doLongRunningTask();

	    return tutorialRepository.findByTitleContaining(title);
	  }
	 @Cacheable("tutorial")
	  public Optional<Tutorial> findById(int id) {
	    doLongRunningTask();

	    return tutorialRepository.findById(id);
	  }

	 private void doLongRunningTask() {
		    try {
		      Thread.sleep(3000);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		  }
}
