package com.chc.tanda.concepthubclassessbackend.customRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

@NoRepositoryBean
public interface CustomCRUDRepository<T, ID> extends JpaRepository<T, ID> {

    void refresh(T t);
    void refresh(Collection<T> s);
}
