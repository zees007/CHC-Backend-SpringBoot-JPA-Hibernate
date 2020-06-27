package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.RoleRequest;
import com.chc.tanda.concepthubclassessbackend.dto.RoleResponse;

public interface RoleService {

    RoleResponse saveRole(RoleRequest roleRequest);
}
