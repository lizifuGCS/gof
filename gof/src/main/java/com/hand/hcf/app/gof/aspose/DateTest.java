package com.hand.hcf.app.gof.aspose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author zifu.li@hand-china.com
 * @Date 2020/2/15 12:55
 * @Version 1.0
 */
public class DateTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person{
        private String name;
        private String birthday;
    }

    public static void main(String[] args) {
        Person personA =new Person("A","2019-01-10 12:10:30");
        Person personB =new Person("B","2019-01-10 12:15:30");
        Person personC =new Person("C","2019-01-19 12:15:30");
        List<Person> people =new ArrayList<>();
        people.add(personC);
        people.add(personB);
        people.add(personA);
        System.out.println(people);
        List<Person> objTestList = new LinkedList<>();
        people.stream().sorted((h1, h2) -> {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                Date lastUpdatedDateByh1 = format.parse(h1.getBirthday());
                Date lastUpdatedDateByh2 = format.parse(h2.getBirthday());
                if (lastUpdatedDateByh1.getTime() > lastUpdatedDateByh2.getTime()) {
                    return 1;
                } else if (lastUpdatedDateByh1.getTime() < lastUpdatedDateByh2.getTime()) {
                    return -1;
                } else {
                    return 0;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0;
        }).collect(Collectors.toList()).forEach(x->{
            Person b = new Person();
            BeanUtils.copyProperties(x,b);
            objTestList.add(b);
        });
        System.out.println(objTestList);
    }
}
