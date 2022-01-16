package com.swwan.research.valid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author swwan
 * @date 2022/1/16 - 11:01
 */
@Data
@AllArgsConstructor
public class TestTimeResponse {

    public Date date;

    public LocalDateTime dateTime;

    public LocalDate localDate;

    public LocalTime localTime;

    public String name;
}
