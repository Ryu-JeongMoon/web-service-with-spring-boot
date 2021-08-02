package org.example.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


// JPA Auditing 활성화?!
// @EntityListeners(AuditingEntityListener.class) 로 지정된 클래스가 있으면
// 얘가 자동 감지해서 시간 넣어줌. 쩌네 ㅋ
@EnableJpaAuditing
@SpringBootApplication
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

}
