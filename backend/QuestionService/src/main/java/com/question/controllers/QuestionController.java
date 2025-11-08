package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionServiceImpl impl;

	@PostMapping
	public Question add(@RequestBody Question question) {
		return impl.add(question);
	}

	@GetMapping
	public List<Question> getAll() {
		return impl.getAll();
	}
	
	@GetMapping("/{questionId}")
	public Question get(@PathVariable Long questionId) {
		return impl.get(questionId);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionByQuizId(@PathVariable Long quizId) {
		return impl.getQuestionByQuizId(quizId);
	}
}
