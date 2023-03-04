package com.job.future.jobservice.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class DateTimeUtils {

  public static LocalDateTime convertToUTC(LocalDateTime localDateTime, String timeZone) {
    ZoneId zoneId = ZoneId.of(timeZone);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
    ZonedDateTime utcDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
    return utcDateTime.toLocalDateTime();
  }

  public static LocalDateTime convertToLocalDateTime(String dateTimeString, String format) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return LocalDateTime.parse(dateTimeString, formatter);
  }
}
