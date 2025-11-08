package com.question.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl {

	@Autowired
	private QuestionRepository questionRepository;

	public Question add(Question quiz) {
		return questionRepository.save(quiz);
	}

	public Question get(Long id) {
		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not found"));
	}

	public List<Question> getAll() {
		return questionRepository.findAll();
	}
	
	public List<Question> getQuestionByQuizId(Long quizId){
		return questionRepository.findByQuizId(quizId);
	}
}
