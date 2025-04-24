package com.quizApplication.quizapp.Service;

import com.quizApplication.quizapp.Modal.Question;
import com.quizApplication.quizapp.Modal.QuestionWrapper;
import com.quizApplication.quizapp.Modal.Quiz;
import com.quizApplication.quizapp.Modal.Response;
import com.quizApplication.quizapp.dao.QuestionDao;
import com.quizApplication.quizapp.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizDao quizDao;
    private final QuestionDao questionDao;

    @Autowired
    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        Pageable pageable = PageRequest.of(0, numQ);
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, pageable);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForTheUser = new ArrayList<>();

        for(Question q : questionsFromDb) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(), q.getOption2(), q.getOption3(),q.getOption4());
            questionsForTheUser.add(qw);
        }
        return new ResponseEntity<>(questionsForTheUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateCorrectResponse(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int rightAns = 0;
        int i = 0;
        for(Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                rightAns++;
            i++;
        }

        return new ResponseEntity<>(rightAns, HttpStatus.OK);
    }
}
