package com.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizServiceImpl impl;

	@PostMapping
	public Quiz add(@RequestBody Quiz quiz) {
		return impl.add(quiz);
	}

	@GetMapping
	public List<Quiz> getAll() {
		return impl.getAll();
	}
	
	@GetMapping("/{id}")
	public Quiz get(@PathVariable Long id) {
		return impl.get(id);
	}
}
