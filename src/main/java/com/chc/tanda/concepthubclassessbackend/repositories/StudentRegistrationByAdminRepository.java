package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.ContactUs;
import com.chc.tanda.concepthubclassessbackend.model.Role;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistrationByAdmin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRegistrationByAdminRepository extends CustomCRUDRepository<StudentRegistrationByAdmin, String>, JpaSpecificationExecutor<StudentRegistrationByAdmin> {

    @Query(value = "select * from REGISTRATIONS_BY_ADMIN " +
            "where serial_id=:serial " +
            "and retired=0 "
            , nativeQuery = true)
    StudentRegistrationByAdmin findAllValid(@Param("serial") String serial);

    @Query(value = "select * from REGISTRATIONS_BY_ADMIN " + "where retired=0 "+
            "ORDER by serial_id desc ", nativeQuery = true)
    List<StudentRegistrationByAdmin> findByValidSortedCreated();

    @Query(value = "select * from REGISTRATIONS_BY_ADMIN " +
            "where serial_id=:serial " +
            "and retired=0 "
            , nativeQuery = true)
    StudentRegistrationByAdmin findOneBySerial(@Param("serial") String serial);
}
