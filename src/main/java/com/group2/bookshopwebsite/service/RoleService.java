package com.group2.bookshopwebsite.service;

import com.group2.bookshopwebsite.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles();
    void deleteRole(Long roleId);
}
