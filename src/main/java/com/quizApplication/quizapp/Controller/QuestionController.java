package com.quizApplication.quizapp.Controller;

import com.quizApplication.quizapp.Modal.Question;
import com.quizApplication.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    //this the question service where we write the business logic
    private final QuestionService questionService;

    //this is the dependency injection
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //sending response of all the questions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    //sending response for the specific type/category
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("category") String cat) {
        return questionService.getQuestionByCategory(cat);
    }

    //adding the questions to the database
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

}
