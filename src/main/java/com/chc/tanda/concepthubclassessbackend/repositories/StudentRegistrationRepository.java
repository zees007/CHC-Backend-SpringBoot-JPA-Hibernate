package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRegistrationRepository extends CustomCRUDRepository<StudentRegistration, Integer> {

    @Query(value = "select * from STUDENT_REGISTRATION_DB " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    StudentRegistration findAllValid(@Param("id") Integer id);

    @Query(value = "select * from STUDENT_REGISTRATION_DB " + "where retired=0 "+
            "ORDER by id desc ", nativeQuery = true)
    List<StudentRegistration> findByValidSortedCreated();

    @Query(value = "select * from STUDENT_REGISTRATION_DB " +
            "where username=:username " +
            "and password=:password " +
            "and retired=0 "
            , nativeQuery = true)
    StudentRegistration findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from STUDENT_REGISTRATION_DB " +
            "where username=:username " +
            "and retired=0 "
            , nativeQuery = true)
    StudentRegistration findByUsername(String username);
}
