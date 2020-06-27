package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "GALLARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gallary extends DataModelEntity {

    @Column(name = "EVENT_TITLE")
    private String eventTitle;
    @OneToMany(fetch = FetchType.EAGER)
    private List<File> image;
}
