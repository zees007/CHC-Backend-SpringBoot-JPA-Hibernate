package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.RoleRequest;
import com.chc.tanda.concepthubclassessbackend.dto.RoleResponse;
import com.chc.tanda.concepthubclassessbackend.model.Role;
import com.chc.tanda.concepthubclassessbackend.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public RoleResponse saveRole(RoleRequest roleRequest) {
        if (roleRequest.getRoleName() == null) {
            throw new RuntimeException("Parameter id not found in request");
        }
        Role savedRole = null;
        if (roleRequest.getId() != null) {
            Role oldRole= roleRepository.findFirstValidById(roleRequest.getId());
            if (oldRole != null) {
                oldRole.setId(roleRequest.getId());
                oldRole.setRoleName(roleRequest.getRoleName());
                savedRole = roleRepository.save(oldRole);
            } else {
                throw new RuntimeException("Cannot find role with identifier: " + roleRequest.getId());
            }

        } else {
            Role roleModel = modelMapper.map(roleRequest, Role.class);
            savedRole = roleRepository.save(roleModel);

        }
        RoleResponse roleResponse = modelMapper.map(savedRole, RoleResponse.class);
        return roleResponse;
    }
}
