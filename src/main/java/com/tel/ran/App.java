package com.tel.ran;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tel.ran.annotations.InjectionService;
import com.tel.ran.annotations.InjectionServiceType;
import com.tel.ran.core.Operations;
import com.tel.ran.pojo.Car;
import org.apache.commons.io.FileUtils;
import org.reflections.Reflections;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {

    private static final InjectionServiceType type =
            InjectionServiceType.JSON;

    static List<Car> cars = new ArrayList<>();

    private static final String PATH = "C:\\Dev\\json-xml-parser\\input";

    public static void main(String[] args) throws Exception {
        defineFormat();
        while (true) {
            File directory = new File(PATH);
            File[] files = directory.listFiles();
            if (files.length == 0) {
//                return;
            }

            for (File file : files) {
                List<String> strings = FileUtils.readLines(file, "UTF-8");
                StringBuilder builder = new StringBuilder();
                strings.forEach(builder::append);
                String fileContent = builder.toString();

                ObjectMapper objectMapper = new ObjectMapper();
                Car car = objectMapper.readValue(fileContent, Car.class);
                cars.add(car);

                file.delete();
                System.out.println(cars.toString());
                Thread.sleep(1000);
            }


        }

    }


    private static void defineFormat() throws Exception {
        Reflections reflections = new Reflections("com.tel.ran.core");

        Set<Class<?>> typesAnnotatedWith = reflections
                .getTypesAnnotatedWith(InjectionService.class);
        for (Class<?> clazz : typesAnnotatedWith) {
            if (clazz.getAnnotation(InjectionService.class).type() == type) {
                Operations operations = (Operations) clazz.newInstance();
                Car car = new Car(
                        "Toyota",
                        "Corolla",
                        2006,
                        200000);
                operations.print(car);
            }
        }
    }
}
