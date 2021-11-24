package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    private String name;
    @JsonProperty("car_number")
    private String carNumber;
    @JsonProperty("TYPE")
    private String Type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
