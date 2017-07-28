import com.jygj.summ.utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jygj_7500 on 2017/7/21.
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        Map map = new HashMap();
        String timst = "1488774589000";
        Date date1 = DateUtil.stringForDate(timst);


        String start_time = DateUtil.getMinMonthDate(date1) + " 00:00:00";
        String end_time = DateUtil.getMaxMonthDate(date1) + " 23:59:59";
        System.out.println(start_time);
        System.out.println(end_time);


    }
}
