package com.chc.tanda.concepthubclassessbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GallaryResponse {

    private Integer id;
    private String eventTitle;
    private List<FileResponse> image;
}
