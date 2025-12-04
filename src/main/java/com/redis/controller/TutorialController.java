package com.redis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.redis.model.Tutorial;
import com.redis.service.TutorialService;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @PostMapping
    public ResponseEntity<Integer> addTutorial(@RequestBody Tutorial tutorial) {
        Integer id = tutorialService.addTutorial(tutorial);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        return ResponseEntity.ok(tutorialService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tutorial>> getTutorialsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(tutorialService.findByTitleContaining(title));
    }
    
    @GetMapping("/")
    public ResponseEntity<Tutorial> getById(@RequestParam Integer id)
    {
    	return ResponseEntity.ok(tutorialService.findById(id).get());
    }
}
