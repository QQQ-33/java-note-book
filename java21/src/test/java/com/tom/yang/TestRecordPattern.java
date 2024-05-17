package com.tom.yang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TestRecordPattern {

    @Test
    void test_record() {
        GPS gps = new GPS(123.111, 66.666);
        System.out.println(gps.latitude());
        System.out.println(gps.longitude());

        // 判断类型时可以直接根据 record 参数判断
        // instanceof 匹配类型的同时也可以赋值
        Object obj = new GPS(111.22, 88.33);
        if(obj instanceof GPS(Double longitude, Double latitude)) {
            System.out.println("GPS: " + longitude + ", " + latitude);
            Assertions.assertEquals(111.22, longitude);
            Assertions.assertEquals(88.33, latitude);
        }
    }
}

// record 对象： 只能读，不能写
record GPS(Double longitude, Double latitude) {}
