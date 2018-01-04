package com.tel.ran.core.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tel.ran.annotations.InjectionService;
import com.tel.ran.annotations.InjectionServiceType;
import com.tel.ran.core.Operations;
import com.tel.ran.pojo.Car;

@InjectionService(type = InjectionServiceType.JSON)
public class JsonOperationImpl implements Operations {

    public void print(Car car) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(car);

        System.out.println(json);
    }
}
