package com.tom.yang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

@Slf4j
@ExtendWith(MockitoExtension.class)
class TestSwitchPattern {

    @Test
    void test_switch() {
        List<String> dayList = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "NA");
        String day = dayList.get(new Random().nextInt(8));
        String weekDay = switch (day) {
            case "Monday" -> "星期一";
            case "Tuesday" -> "星期二";
            case "Wednesday" -> "星期三";
            case "Thursday" -> "星期四";
            case "Friday" -> "星期五";
            case "Saturday" -> "星期六";
            case "Sunday" -> "星期日";
            default -> "未知";
        };
        log.info("Day: {}, WeekDay: {}", day, weekDay);

        log.info(formatPattern(100));
        log.info(formatPattern("test"));
        log.info(formatPattern(2.2d));
        log.info(formatPattern(3L));
        log.info(formatPattern(null));
        log.info(formatPattern(4.5f));
    }

    private String formatPattern(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            case Double d -> "Double: " + d;
            case Long l -> "Long: " + l;
            case null -> "empty value";
            default -> "Unknown";
        };

    }
}
