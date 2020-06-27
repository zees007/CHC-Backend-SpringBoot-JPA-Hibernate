package com.chc.tanda.concepthubclassessbackend.repositories;

import com.chc.tanda.concepthubclassessbackend.customRepo.CustomCRUDRepository;
import com.chc.tanda.concepthubclassessbackend.model.File;
import com.chc.tanda.concepthubclassessbackend.model.Gallary;
import com.chc.tanda.concepthubclassessbackend.model.LatestUpdate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 12, 2020
 */
public interface LatestUpdateRepository extends CustomCRUDRepository<LatestUpdate, Integer> {

    @Query(value = "select * from LATEST_UPDATE " +
            "where id=:id "
            , nativeQuery = true)
    LatestUpdate findAllValid(@Param("id") Integer id);

    @Query(value = "select * from LATEST_UPDATE where id=:id ",
            nativeQuery = true)
    LatestUpdate findValidById(@Param("id") Integer id);


}
