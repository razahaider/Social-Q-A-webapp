package com.upgrad.quora.api.controller;


import com.upgrad.quora.service.exception.AuthorizationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class QuestionController {
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/question/create",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionResponse> createQuestion(
            @RequestHeader("authorization") final String authorizationToken, QuestionRequest questionRequest)
            throws AuthorizationFailedException {

        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setContent(questionRequest.getContent());
        questionEntity = questionService.createQuestion(questionEntity, authorizationToken);


        questionResponse.setId(questionEntity.getUuid().toString());
        questionResponse.setStatus("QUESTION CREATED");

        return new ResponseEntity<QuestionResponse>(questionResponse, HttpStatus.CREATED);

    }
}
