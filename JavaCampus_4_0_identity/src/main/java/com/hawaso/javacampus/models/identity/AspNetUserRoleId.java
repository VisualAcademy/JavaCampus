package com.hawaso.javacampus.models.identity;

import java.io.Serializable;
import java.util.Objects;

public class AspNetUserRoleId implements Serializable {
    private String userId;
    private String roleId;

    public AspNetUserRoleId() {
    }

    public AspNetUserRoleId(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AspNetUserRoleId that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}
