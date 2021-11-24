package com.example.chapter0701client.service;

import com.example.chapter0701client.dto.Req;
import com.example.chapter0701client.dto.UserRequest;
import com.example.chapter0701client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    //http://localhost/api/server/hello
    //response
    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();

    }

    public UserResponse post() {
        // http://localhost:9090/api/sever/user/{UserId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user1/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "post name 1")
                .toUri();

        System.out.println(uri);

        // http body(post 기 때문에 body 있어야함) -> object(object 만 보내면 ) -> object mapper (json 으로 바꿔줌)
        //  -> json -> rest template -> http body json

        UserRequest req = new UserRequest();
        req.setName("post name 2");
        req.setAge(30);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }


    //현업에서 사용할 때
    public UserRequest exchange() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user2/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "path-parameter userName")
                .toUri();

        System.out.println(uri);

        // http body(post 기 때문에 body 있어야함) -> object(object 만 보내면 ) -> object mapper (json 으로 바꿔줌)
        //  -> json -> rest template -> http body json


        UserRequest req = new UserRequest();
        req.setName("request body name");
        req.setAge(30);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "asdfg")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserRequest> responseEntity = restTemplate.exchange(requestEntity, UserRequest.class);
        return responseEntity.getBody();
    }

    public Req<UserResponse> genericExchange() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user3/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "path-parameter user name generic exchange")
                .toUri();

        System.out.println(uri);


        UserRequest userRequest = new UserRequest();
        userRequest.setName("request body name generic exchange");
        userRequest.setAge(30);

        Req<UserRequest> req = new Req<>();
        req.setResBody(userRequest);
        req.setHeader(new Req.Header());


        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "wtf")
                .header("custom-header", "tlqkf wtf")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {});

        System.out.println(userRequest);
        System.out.println(response.getBody());

        return response.getBody();
    }

}
