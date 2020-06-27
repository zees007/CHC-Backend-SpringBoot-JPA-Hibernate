package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.RoleRequest;
import com.chc.tanda.concepthubclassessbackend.dto.RoleResponse;
import com.chc.tanda.concepthubclassessbackend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping(value = "/role/save")
    public ResponseEntity saveRole(@RequestBody RoleRequest roleRequest) {

        RoleResponse roleResponse = roleService.saveRole(roleRequest);
        return ResponseEntity.ok(roleResponse);
    }
}
