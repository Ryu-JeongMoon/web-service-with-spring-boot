package org.example.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 활성화?!
// @EntityListeners(AuditingEntityListener.class) 로 지정된 클래스가 있으면
// 얘가 자동 감지해서 시간 넣어줌. 쩌네 ㅋ
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}
