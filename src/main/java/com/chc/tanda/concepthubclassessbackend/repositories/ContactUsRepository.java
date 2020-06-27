package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.ContactUs;
import com.chc.tanda.concepthubclassessbackend.model.Gallary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 16, 2020
 */
public interface ContactUsRepository extends CustomCRUDRepository<ContactUs, Integer> {

    @Query(value = "select * from CONTACT_US_MESSAGE " +
            "where id=:id " +
            "and retired=0 "
            , nativeQuery = true)
    ContactUs findAllValid(@Param("id") Integer id);

    @Query(value = "select * from CONTACT_US_MESSAGE " + "where retired=0 "+
            "ORDER by id desc", nativeQuery = true)
    List<ContactUs> findByValidSortedCreated();

    @Query(value = "select * from CONTACT_US_MESSAGE " +
            "where email=:email " +
            "and retired=0 "
            , nativeQuery = true)
    ContactUs findAllValidByEmail(@Param("email") String email);


}
