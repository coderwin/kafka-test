package com.example.kafkatest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

@SpringBootApplication
@EnableKafka
public class KafkaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTestApplication.class, args);
	}

	/**
	 * spring boot application 이 실행되고 나서 특정 작업을 바로 실행할 수 있도록 적용하는 기능
	 * @return
	 */
	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate) {

		// 실행할 내용을 정의
		// 실행되면서 바로 카프카에  mytest3 토픽에 메시지를 전송
		// kafka Producer는 kafkaTempalte을 이용해서 생성
		return (args) -> {
			// Producer 만들기
			kafkaTemplate.send("mytest3awerwasdf", "spring for kafaka");
		};

	}

	/**
	 * Spring boot application 이 실행되고 나서 특정 작업을 바로 실행할 수 있도록 적용하는 기능
	 */
	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate,
									KafkaMessageListenerContainer<String, String> container
									) {

		return (args) -> {
			container.start();
			Thread.sleep(10000);// 10초 정지

			System.out.println("============ pause(잠시멈춤) ================");
			container.pause();

			System.out.println("============ resume(다시실행) ============");
			container.resume();

			System.out.println("============ stop(중지) ============");
			container.stop();
		};

	}



}
