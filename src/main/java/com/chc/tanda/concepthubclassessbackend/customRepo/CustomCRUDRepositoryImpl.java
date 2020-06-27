package com.chc.tanda.concepthubclassessbackend.customRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

public class CustomCRUDRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomCRUDRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomCRUDRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void refresh(T t) {
        entityManager.refresh(t);
    }

    @Override
    @Transactional
    public void refresh(Collection<T> s) {
        for (T t: s) {
            entityManager.refresh(t);
        }
    }
}
