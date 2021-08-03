package org.example.webservice.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}

// Spring Security 에서는 권한 코드 앞에 항상 ROLE_* 이 있어야 한다?!
