package com.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;

@Service
public class QuizServiceImpl {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuestionClient questionClient;
	
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	public Quiz get(Long id) {
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not found"));
		quiz.setQuestions(questionClient.getQuestionByQuiz(quiz.getId()));
		return quiz;
	}

	public List<Quiz> getAll() {
		List<Quiz> quizList = quizRepository.findAll();
		List<Quiz> newQuizList  = quizList.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionByQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
	}
}
