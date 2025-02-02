package com.kkj.carrotback.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Common {

    public static String generateUserId(String target) {
        // 날짜 부분 생성
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // 유니크한 넘버 생성
        String uniqueNumber = String.format("%04d", (int) (Math.random() * 10000));
        return target + date + uniqueNumber;
    }

}
