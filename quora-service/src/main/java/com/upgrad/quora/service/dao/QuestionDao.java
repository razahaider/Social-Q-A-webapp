package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class QuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public QuestionEntity createQuestion(QuestionEntity questionEntity) {
        entityManager.persist(questionEntity);
        return questionEntity;
    }

    /**
     * Fetch all the questions from the DB.
     * @return List of QuestionEntity
     */
    public List<QuestionEntity> getAllQuestions() {
        return entityManager.createNamedQuery("getAllQuestions", QuestionEntity.class).getResultList();
    }

    /**
     * Get the question for the given id.
     *
     * @param questionId id of the required question.
     * @return QuestionEntity if question with given id is found else null.
     */
    public QuestionEntity getQuestionById(final String questionId) {
        try {
            return entityManager.createNamedQuery("getQuestionById", QuestionEntity.class).setParameter("uuid", questionId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * Update the question
     *
     * @param questionEntity question entity to be updated.
     */
    public void updateQuestion(QuestionEntity questionEntity) {
        entityManager.merge(questionEntity);
    }
}
