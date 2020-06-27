package com.chc.tanda.concepthubclassessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


public class FileResponse {

    private Integer id;
    private String name;
    private String type;
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/").path("/" + id + "/").path(name).toUriString();

    }

    public void setPath(String path) {
        this.path = path;
    }


}
