package org.linden;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@ApplicationScoped
@Named
public class FlashcardService {

    @Inject
    EntityManager em;

    public Flashcard find(Long id) {
        return em.find(Flashcard.class, id);
    }

    public List<Flashcard> findAll() {
        TypedQuery<Flashcard> typedQuery = em.createQuery("SELECT flashcard FROM Flashcard flashcard ORDER BY flashcard.word DESC", Flashcard.class);
        return typedQuery.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> typedQuery = em.createQuery("SELECT count(*) FROM Flashcard flashcard", Long.class);
        return typedQuery.getSingleResult();
    }

    @Transactional(REQUIRED)
    public Flashcard create(Flashcard flashcard) {
        flashcard.setAddedDate(LocalDate.now());
        em.persist(flashcard);
        return flashcard;
    }

    @Transactional(REQUIRED)
    public void delete(Long id) {
        em.remove(em.getReference(Flashcard.class, id));
    }



}

