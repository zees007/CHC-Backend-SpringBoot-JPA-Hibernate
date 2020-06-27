package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class DataModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ColumnDefault("0")
    @Column(name = "RETIRED")
    private Boolean retired = false;
    @Column(name = "RETIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retiredDate;

}
