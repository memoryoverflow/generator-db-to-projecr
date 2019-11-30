package cn.lyj.generator.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <br>
 *
 * @author 永健
 * @since 2019/2/23 16:35
 */
public class DateTimeUtils extends DateUtils
{
    //获取当前时间的LocalDateTime对象
    //LocalDateTime.now();

    //根据年月日构建LocalDateTime
    //LocalDateTime.of();

    //比较日期先后
    //LocalDateTime.now().isBefore(),
    //LocalDateTime.now().isAfter(),


    public static final String PATTERM = "yyyy-MM-dd";
    public static final String PATTERM2 = "yyyy-MM-dd HH:mm";
    public static final String PATTERM3 = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date转换为LocalDateTime
     *
     * @param date
     *
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date)
    {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param time
     *
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time)
    {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获取指定日期的毫秒
     *
     * @param time
     *
     * @return
     */
    public static Long getMilliByTime(LocalDateTime time)
    {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     *
     * @param time
     *
     * @return
     */
    public static Long getSecondsByTime(LocalDateTime time)
    {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式
     *
     * @param time
     * @param pattern
     *
     * @return
     */
    public static String formatTime(LocalDateTime time, String pattern)
    {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 获取当前时间的指定格式
     *
     * @param pattern
     *
     * @return
     */
    public static String formatNow(String pattern)
    {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取当前时间的指定格式
     *
     * @return
     */
    public static String formatNow()
    {
        return formatTime(LocalDateTime.now(), PATTERM2);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     *
     * @param time
     * @param number
     * @param field
     *
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field)
    {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     *
     * @param time
     * @param number
     * @param field
     *
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field)
    {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field
     *         单位(年月日时分秒)
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field)
    {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS)
        {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS)
        {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }


    /**
     * 获取一天的开始时间，2017,7,22 00:00
     *
     * @param time
     *
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime time)
    {
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    /**
     * 获取一天的结束时间，2017,7,22 23:59:59.999999999
     *
     * @param time
     *
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime time)
    {
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    /**
     * <br>
     * 获取多少天前或者后的日期
     * 负数 多少天前
     */
    public static Date getDateDayAgoOrAfter(Integer day)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    /**
     * <br>
     * 获取多少小时前或者后的日期
     */
    public static Date getDateHoursAgoOrAfter(Integer hours)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }


    public static String format(Date date)
    {
        String format = DateFormatUtils.format(date, PATTERM3);
        return format;
    }

    public static String format(Date date,String patterm)
    {
        String format = DateFormatUtils.format(date, patterm);
        return format;
    }

    /**
     * <br>
     * 得到本月的第一天
     */
    public static Date getMonthFirstDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat firstDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return calendar.getTime();
    }

    /**
     * <br>
     * 得到本月的最后一天
     */
    public static Date getMonthLastDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat lastDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return calendar.getTime();
    }

    public static Calendar setDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public static void main(String[] args)
    {
        StringBuffer title = new StringBuffer();
        // 发货地址
        String orginPlace = "金箔仓";
        // 收货地址
        String destination = "天河";
        Calendar calendar = DateTimeUtils.setDate(new Date());
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        title.append(month + "月").append(day + "日").append(hour + "时").append(",").append(orginPlace).append(" -> ").append(destination);
        System.out.println(title.toString());
    }

    public static Date utcTogst(String time) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        //注意是空格+UTC
        return format.parse(time.replace("Z", " UTC"));

    }

}
