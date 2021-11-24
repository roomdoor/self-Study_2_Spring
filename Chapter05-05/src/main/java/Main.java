import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();

        user.setName("이시화");
        user.setAge(30);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");


        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        user.setCars(carList);


        System.out.println(user);


        //jon 으로 출력
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);


        //json 노드별로 출력
        JsonNode jsonNode = objectMapper.readTree(json);

        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        // 이렇게 출력하면 안나옴 cars 는 josn 의 새로운 배열 노드 이므로
        //String _list = jsonNode.get("cars").asText();
        //System.out.println(_list);


        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars);

        //노드 안에 값 바꾸기
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "화시이");
        objectNode.put("age", 13);

        System.out.println(objectNode.toPrettyString());
    }
}
