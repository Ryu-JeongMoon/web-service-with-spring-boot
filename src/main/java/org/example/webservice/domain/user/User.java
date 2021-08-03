package org.example.webservice.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.webservice.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    // Enum Type 사용할 땐 걍 무조건 String 쓴다고 생각.
    // ordinal 쓸 경우, 데이터 추가할 때 뒤에서 추가하지 않으면 이전 데이터랑 겹쳐서 꼬임.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
