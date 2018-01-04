package com.tel.ran.core.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tel.ran.annotations.InjectionService;
import com.tel.ran.annotations.InjectionServiceType;
import com.tel.ran.core.Operations;
import com.tel.ran.pojo.Car;


@InjectionService(type = InjectionServiceType.XML)
public class XmlOperationImpl implements Operations {

    public void print(Car car) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        String xml = xmlMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(car);
        System.out.println(xml);
    }
}
