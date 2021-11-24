package com.example.chapter0502;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Chapter0502Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter0502Application.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";


//        ApplicationContextProvider 생성하고 class component 넣고 사용 한 코드    &&  Encoder 에 Component 넣기 전

//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

//        Encoder encoder = new Encoder(base64Encoder);

//        String result = encoder.encode(url);
//        System.out.println(result);
//
//        encoder.setIEncoder(urlEncoder);
//        String urlResult = encoder.encode(url);
//        System.out.println(urlResult);


//        Encoder 에 Component 넣은 후 코드

        Encoder encoder = context.getBean("urlEncode",Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);

    }
}



// 한개의 class 에서 여러개의 Bean 을 등록할 때 사용
@Configuration
class AppConfig {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }

}
