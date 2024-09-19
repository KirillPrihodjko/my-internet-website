package website.entity.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN,
    MANAGER,
    EMPLOYEE,
    GROUP_LEADER;

    @Override
    public String getAuthority() {
        return name();
    }
}
