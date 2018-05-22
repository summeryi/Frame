package cn.nineox.xframework.core.common.utils;

import android.content.Context;
import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * 时间格式化转换<BR>
 * 转换时间相关
 *
 * @author 黄广府
 * @version [WalkTour Client V100R001C03, 2012-6-18]
 */
public class DateUtil {

    /**
     * 通话时间
     */
    public static SimpleDateFormat VOIP_TALKING_TIME = new SimpleDateFormat(
            "mm:ss");

    /**
     * 年-月-日格式
     */
    public static SimpleDateFormat Y_M_D = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 年-月-日格式
     */
    public static SimpleDateFormat Y_M_D_H_M_2 = new SimpleDateFormat("yyyy/MM/d HH:mm");

    /**
     * 时：分：秒 格式
     */
    public static SimpleDateFormat H_M_S = new SimpleDateFormat("HH:mm:ss");

    /**
     * 年-月-日 时:分 格式
     */
    public static SimpleDateFormat Y_M_D_H_M = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");

    /**
     * 月-日 时:分格式
     */
    public static SimpleDateFormat M_D_H_M = new SimpleDateFormat("MM-dd HH:mm");

    /**
     * 时:分格式
     */
    public static SimpleDateFormat H_M = new SimpleDateFormat("HH:mm");

    /**
     * 一秒
     */
    private static final long SECOND = 1000;

    /**
     * 一分钟
     */
    private static final long ONE_MINUTE = 60 * SECOND;

    /**
     * 一小时
     */
    private static final long ONE_HOUR = 60 * ONE_MINUTE;


    public static String millisToString(long time){
        return Y_M_D_H_M.format(new Date(time));
    }


    public static String millisToYMDString(long time){
        return Y_M_D.format(new Date(time));
    }

    public static String millisToYMDHMString(long time){
        return Y_M_D_H_M_2.format(new Date(time));
    }



    /**
     * @param timeStr 时间字符串
     * @return String 格式化时间
     * @Title: timeFormate
     * @Description: 返回  年-月-日  时:分:秒
     */
    public static String dateTimeFormate(String timeStr) {
        String time = "";
        if (!TextUtils.isEmpty(timeStr)) {
            time =
                    //              timeStr.substring(0, 4) + "-" +
                    timeStr.substring(4, 6) + "-" + timeStr.substring(6, 8) + " "
                            + timeStr.substring(8, 10) + ":"
                            + timeStr.substring(10, 12);
            //                  + ":" + timeStr.substring(12);
            return time;
        } else {
            return "";
        }
    }


    /**
     * 返回   时：分<BR>
     * [功能详细描述]
     *
     * @param timeStr 时间字符串
     * @return String 格式化时间
     */
    public static String timeFormate(String timeStr) {
        String time = "";
        if (!TextUtils.isEmpty(timeStr)) {
            time = timeStr.substring(8, 10) + ":" + timeStr.substring(10, 12);
            return time;
        } else {
            return "";
        }
    }

    /**
     * @param timeStr
     * @return String
     * @Title: DateFormate
     * @Description: 返回  年-月-日
     */
    public static String dateFormate(String timeStr) {
        String time = "";
        if (!TextUtils.isEmpty(timeStr)) {
            time = timeStr.substring(0, 4) + "-" + timeStr.substring(4, 6)
                    + "-" + timeStr.substring(6, 8);
            return time;
        } else {
            return "";
        }
    }

    /**
     * @param @return
     * @return String
     * @Title: getDateTime
     * @Description: 根据当前时间去的yyyyMMddHHmmss格式的字符串
     */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyy-MM-dd HH:mm");
        String timeStr = sdf.format(new Date());
        return timeStr;
    }

    /**
     * @param time
     * @return String
     * @Title: getClockDateTime
     * @Description: 取得定时发送时间yyMMddHHmmt格式的字符串
     */
    public static String getClockDateTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("",
                Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyMMddHHmm");
        String timeStr = sdf.format(new Date(time)) + "000";
        return timeStr;
    }

    /**
     * 将2011-08-17 17:15 这样的时间格式转换成数据的时间格式
     *
     * @param date 日期
     * @param time 时间
     * @return yyyymmddhhmm格式的时间
     */
    public static String getDataBaseDate(String date, String time) {
        try {
            String[] dateStr = date.split("-");
            String monthStr = dateStr[1];
            String[] timeStr = time.split(":");
            String monthTemp = "";
            //计算第几个月份
            monthTemp = getMonth(monthStr);
            StringBuffer sb = new StringBuffer();
            sb.append(dateStr[0])
                    .append(monthTemp)
                    .append(dateStr[2])
                    .append(timeStr[0])
                    .append(timeStr[1]);
            String dateTemp = sb.toString();
            return dateTemp;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getMonth(String month) {
        if ("Jan".equals(month) || "01".equals(month) || "1".equals(month)) {
            return "01";
        } else if ("Feb".equals(month) || "02".equals(month)
                || "2".equals(month)) {
            return "02";
        } else if ("Mar".equals(month) || "03".equals(month)
                || "3".equals(month)) {
            return "03";
        } else if ("Apr".equals(month) || "04".equals(month)
                || "4".equals(month)) {
            return "04";
        } else if ("May".equals(month) || "05".equals(month)
                || "5".equals(month)) {
            return "05";
        } else if ("Jun".equals(month) || "06".equals(month)
                || "6".equals(month)) {
            return "06";
        } else if ("Jul".equals(month) || "07".equals(month)
                || "7".equals(month)) {
            return "07";
        } else if ("Aug".equals(month) || "08".equals(month)
                || "8".equals(month)) {
            return "08";
        } else if ("Sept".equals(month) || "09".equals(month)
                || "9".equals(month)) {
            return "09";
        } else if ("Oct".equals(month) || "10".equals(month)) {
            return "10";
        } else if ("Nov".equals(month) || "11".equals(month)) {
            return "11";
        } else if ("Dec".equals(month) || "12".equals(month)) {
            return "12";
        } else {
            return "01";
        }
    }

    /**
     * 返回本地数据库的消息日期与服务器消息的日期大小，
     * 如果本地数据库日期小，返回true，否则返回false
     *
     * @return
     */
    public static boolean maxDate(String DBDate, String ServerDate,
                                  String DBTime, String ServerTime) {
        //分隔年月日，放入数组中
        String[] DBArry = DBDate.split("-");
        String[] DBTimeArry = DBTime.split(":");
        String[] ServerArry = ServerDate.split("-");
        String[] ServerTimerArry = ServerTime.split(":");
        if (Integer.parseInt(DBArry[0]) < Integer.parseInt(ServerArry[0])) {
            //本地的消息年份小于服务器的年份,服务器的消息为最近的消息
            return true;
        } else if (Integer.parseInt(DBArry[0]) == Integer.parseInt(ServerArry[0])) {
            //两者的年份相同
            if (Integer.parseInt(DBArry[1]) < Integer.parseInt(ServerArry[1])) {
                //数据库的消息月份小于服务器的月份
                return true;
            } else if (Integer.parseInt(DBArry[1]) == Integer.parseInt(ServerArry[1])) {
                //两者的月份相同
                if (Integer.parseInt(DBArry[2]) < Integer.parseInt(ServerArry[2])) {
                    //本地日期月份小
                    return true;
                } else if (Integer.parseInt(DBArry[2]) == Integer.parseInt(ServerArry[2])) {
                    //两者的日期相同
                    if (Integer.parseInt(DBTimeArry[0]) < Integer.parseInt(ServerTimerArry[0])) {
                        return true;
                    } else if (Integer.parseInt(DBTimeArry[0]) == Integer.parseInt(ServerTimerArry[0])) {
                        //时间相同
                        if (Integer.parseInt(DBTimeArry[1]) < Integer.parseInt(ServerTimerArry[1])) {
                            return true;
                        } else if (Integer.parseInt(DBTimeArry[1]) == Integer.parseInt(ServerTimerArry[1])) {
                            //分钟相同
                            if (Integer.parseInt(DBTimeArry[2]) < Integer.parseInt(ServerTimerArry[2])) {
                                return true;
                            } else if (Integer.parseInt(DBTimeArry[2]) == Integer.parseInt(ServerTimerArry[2])) {
                                return false;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }

                    } else {
                        //数据库时间大于服务器时间
                        return false;
                    }
                }

            }
        }
        //本地数据库的年份大
        return false;
    }

    /**
     * 最后联系时间
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd HH:mm");
        return fmt.format(date);
    }

    /**
     * 最后联系时间
     *
     * @param time
     * @return
     */
    public static String formatDate(long time) {
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd HH:mm");
        return fmt.format(new Date(time));
    }

    /**
     * 把yyyy-MM-dd格式的时间转换成毫秒
     * 朱远昕增加 2011-11-08
     *
     * @param date 时间
     * @return 相应的毫秒
     */
    public static long formatToMillisecond(String date) {
        if (date == null || "".equals(date)) {
            return -30609820800000L;//即1000-01-01年
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -30609820800000L;
    }

    /**
     * 把毫秒格式的时间转换成yyyy-MM-dd格式
     * 朱远昕增加 2011-11-08
     *
     * @param millisecond 毫秒
     * @return 相应的yyyy-MM-dd格式时间
     */
    public static String formatToStandard(long millisecond) {
        if (millisecond == -30609820800000L) {
            return "";
        }
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(millisecond);
        return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-"
                + ca.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 把yyyy-MM-dd格式的时间转化成Calendar时间
     *
     * @param date yyyy-MM-dd 格式时间
     * @return 相应的Calendar
     */
    public static Calendar formatToCalendar(String date) {
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(formatToMillisecond(date));
        return ca;
    }


    /**
     * 获得本星期 第一天的时间<BR>
     * [功能详细描述]
     *
     * @return Date 时间
     */
    public static Date getFristWeekDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设周一为本周第一天
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//获取本周最后一天
        calendar.set(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                0,
                0,
                0);
        calendar.set(Calendar.MILLISECOND, 000);
        Date date = calendar.getTime();
        //System.out.println("周六"+date.getTime());
        return date;
    }

    /**
     * 获取具体时间  上午/下午  + 定点
     *
     * @param context  Context
     * @param lastDate Date
     * @return 具体时间
     */
    public static String getFormatClearTimeByDate(Context context, Date lastDate) {
        long before = lastDate.getTime();
        Calendar c = Calendar.getInstance();
        Date nowDate = c.getTime();
        long now = nowDate.getTime();
        long diff = now - before;

        //取出是下午还是上午
        SimpleDateFormat df = new SimpleDateFormat("a", Locale.getDefault());
        String amOrPm = df.format(lastDate);

        //然后取出具体时间
        SimpleDateFormat dff = new SimpleDateFormat("HH:mm",
                Locale.getDefault());
        String time = dff.format(lastDate);
        return amOrPm + "  " + time;

    }

    /**
     * 设置通话时长格式
     *
     * @param diffTime long
     * @param hh       时
     * @param mm       分
     * @param ss       秒
     * @return 通话时长格式
     */
    public static String getDiffTime(long diffTime, String hh, String mm,
                                     String ss) {
        //小时常数
        long hourMarker = 60 * 60;

        // 分钟常数
        long minuteMarker = 60;

        //秒常数
        long secondMarker = 1;

        DecimalFormat decfmt = new DecimalFormat();
        //小时
        long hour = diffTime / hourMarker;
        //分钟
        long minute = (diffTime - hour * hourMarker) / minuteMarker;
        //秒
        long second = (diffTime - hour * hourMarker - minute * minuteMarker)
                / secondMarker;

        if (hour == 0 && minute == 0) {
            return decfmt.format(second) + " " + ss;
        }
        if (hour == 0 && minute != 0) {
            return decfmt.format(minute) + " " + mm + decfmt.format(second)
                    + " " + ss;
        } else {
            return decfmt.format(hour) + " " + hh + decfmt.format(minute) + " "
                    + mm + decfmt.format(second) + " " + ss;
        }
    }

    public static String getHistoryFormatTimeByDate(Date lastDate) {
        Calendar c = Calendar.getInstance();
        //当前年份
        int nowYear = c.get(Calendar.YEAR);
        //将Date转化为Calendar
        Calendar cal = new GregorianCalendar();
        cal.setTime(lastDate);
        //聊天的时间
        int chatYear = cal.get(Calendar.YEAR);
        //Calendar 转为 Date:
        Date nowDate = c.getTime();
        //年份相等则不显示
        if (nowYear == chatYear) {
            String lastTimeDate = Y_M_D.format(lastDate);
            //判断是否同一天
            if (Y_M_D.format(nowDate).equals(lastTimeDate)) {
                return "今天" + H_M.format(lastDate);
            } else {
                return M_D_H_M.format(lastDate);
            }
        } else {
            //2012-05-07 17:35
            return Y_M_D_H_M.format(lastDate);
        }
    }

    public static String secToHHmmss(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = /*"00:" +*/ unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                /*if (hour > 99)
                    return "99:59:59";*/
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }


    public static String date2String(long date, String formatString) {
        if (date < 0) {
            return "";
        }
        Date d = new Date(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        return simpleDateFormat.format(date);
    }

    public static String date2String(long date, SimpleDateFormat formatString) {
        if (date < 0) {
            return "";
        }
        Date d = new Date(date);
        return formatString.format(date);
    }

    public static Date getDate(String time, SimpleDateFormat format) {
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long getLong(String time, SimpleDateFormat formatString) {
        return getDate(time, formatString).getTime();
    }
}
