package com.hawaso.javacampus.models.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AspNetUsers")
public class AspNetUser {

    @Id
    @Column(name = "Id", length = 64, nullable = false)
    private String id;

    @Column(name = "UserName", length = 256)
    private String userName;

    @Column(name = "NormalizedUserName", length = 256, unique = true)
    private String normalizedUserName;

    @Column(name = "Email", length = 256)
    private String email;

    @Column(name = "NormalizedEmail", length = 256)
    private String normalizedEmail;

    @Column(name = "EmailConfirmed", nullable = false)
    private boolean emailConfirmed;

    @Column(name = "PasswordHash", length = 512)
    private String passwordHash;

    @Column(name = "SecurityStamp", length = 256)
    private String securityStamp;

    @Column(name = "ConcurrencyStamp", length = 256)
    private String concurrencyStamp;

    @Column(name = "PhoneNumber", length = 50)
    private String phoneNumber;

    @Column(name = "PhoneNumberConfirmed", nullable = false)
    private boolean phoneNumberConfirmed;

    @Column(name = "TwoFactorEnabled", nullable = false)
    private boolean twoFactorEnabled;

    @Column(name = "LockoutEnd", length = 128)
    private String lockoutEnd;

    @Column(name = "LockoutEnabled", nullable = false)
    private boolean lockoutEnabled;

    @Column(name = "AccessFailedCount", nullable = false)
    private int accessFailedCount;

    @Column(name = "DisplayName", length = 256)
    private String displayName;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getNormalizedUserName() { return normalizedUserName; }
    public void setNormalizedUserName(String normalizedUserName) { this.normalizedUserName = normalizedUserName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNormalizedEmail() { return normalizedEmail; }
    public void setNormalizedEmail(String normalizedEmail) { this.normalizedEmail = normalizedEmail; }
    public boolean isEmailConfirmed() { return emailConfirmed; }
    public void setEmailConfirmed(boolean emailConfirmed) { this.emailConfirmed = emailConfirmed; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getSecurityStamp() { return securityStamp; }
    public void setSecurityStamp(String securityStamp) { this.securityStamp = securityStamp; }
    public String getConcurrencyStamp() { return concurrencyStamp; }
    public void setConcurrencyStamp(String concurrencyStamp) { this.concurrencyStamp = concurrencyStamp; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public boolean isPhoneNumberConfirmed() { return phoneNumberConfirmed; }
    public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) { this.phoneNumberConfirmed = phoneNumberConfirmed; }
    public boolean isTwoFactorEnabled() { return twoFactorEnabled; }
    public void setTwoFactorEnabled(boolean twoFactorEnabled) { this.twoFactorEnabled = twoFactorEnabled; }
    public String getLockoutEnd() { return lockoutEnd; }
    public void setLockoutEnd(String lockoutEnd) { this.lockoutEnd = lockoutEnd; }
    public boolean isLockoutEnabled() { return lockoutEnabled; }
    public void setLockoutEnabled(boolean lockoutEnabled) { this.lockoutEnabled = lockoutEnabled; }
    public int getAccessFailedCount() { return accessFailedCount; }
    public void setAccessFailedCount(int accessFailedCount) { this.accessFailedCount = accessFailedCount; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
}
