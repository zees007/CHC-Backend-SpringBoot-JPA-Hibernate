package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.Testimonial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestimonialRepository extends CustomCRUDRepository<Testimonial, Integer> {

    @Query(value = "select * from TESTIMONIAL " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    Testimonial findAllValid(@Param("id") Integer id);

    @Query(value = "select * from TESTIMONIAL " + "where retired=0 "+
            "ORDER by id desc ", nativeQuery = true)
    List<Testimonial> findByValidSortedCreated();
}
