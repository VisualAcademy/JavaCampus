package com.hawaso.javacampus.models.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "AspNetUserRoles")
@IdClass(AspNetUserRoleId.class)
public class AspNetUserRole {

    @Id
    @Column(name = "UserId", length = 64, nullable = false)
    private String userId;

    @Id
    @Column(name = "RoleId", length = 64, nullable = false)
    private String roleId;

    public AspNetUserRole() {
    }

    public AspNetUserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getRoleId() { return roleId; }
    public void setRoleId(String roleId) { this.roleId = roleId; }
}
