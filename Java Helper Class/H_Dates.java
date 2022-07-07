package com.btechtraders.btechtraders.Helpers;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class H_Dates {
    /////////////////////////////////////////////////////////////////////////////////////////////////// Getting date and time
    public static String getfulldate_chartink()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("MMM-dd-yyyy");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String getfulldate()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String getfulldatesorder()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String getdateonly()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }


    public static String getmonth()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("MMMM");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String getmonthsmall()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("MMM");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String getyear()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String getmonthyear()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("MMMM yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;

        //[hh:mm]
    }

    public static String gettimeonly()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
        //[hh:mm]
    }

    public static String gettimeonly_ampm()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("h:mm a");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }

    public static String gettimeonlyampm()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss a");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
        //[hh:mm]
    }

    public static long gettimeinmill()
    {
        long timeInMilliseconds=00;
        try{
            Date time1 = new SimpleDateFormat("M/d/yy h:mm:ss.SSS a Z").parse(getutcdatetime());
            timeInMilliseconds = time1.getTime();
        }catch (ParseException e)
        {

        }
        return timeInMilliseconds;
    }

    public static String getutcdate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy h:mm a Z");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
        Date d = new Date();
        sdf.setTimeZone(istTimeZone);
        String strtime = sdf.format(d);

        return strtime;
    }

    public static String getutcdatetime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy h:mm:ss.SSS a Z");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
        Date d = new Date();
        sdf.setTimeZone(istTimeZone);
        String strtime = sdf.format(d);

        return strtime;
    }

    public static String getutcdate_time()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm a Z");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
        Date d = new Date();
        sdf.setTimeZone(istTimeZone);
        String strtime = sdf.format(d);
        return strtime;
    }

    public static String getmonth(int month)
    {
        String monthName="";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, month);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM");
            //simpleDateFormat.setCalendar(calendar);
            monthName = simpleDateFormat.format(calendar.getTime());
        } catch (Exception e) {
            if (e != null)
                e.printStackTrace();
        }

        return monthName;
    }

    public static boolean checkifmarketopen(String getutctime) {
        Boolean marketopen=false;

        try {
            Date time1 = new SimpleDateFormat("M/d/yy h:mm a Z").parse(getutctime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);


            Date time2 = new SimpleDateFormat("M/d/yy h:mm a Z").parse(getutctime);
            time2.setHours(9);
            time2.setMinutes(15);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);


            Date time3 = new SimpleDateFormat("M/d/yy h:mm a Z").parse(getutctime);
            time3.setHours(15);
            time3.setMinutes(30);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(time3);
            calendar3.add(Calendar.DATE, 1);

            if(calendar1.getTimeInMillis()>calendar2.getTimeInMillis()&&calendar1.getTimeInMillis()<calendar3.getTimeInMillis())
            {
                marketopen=true;
            }

            //If
            Calendar calendar = Calendar.getInstance();
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                marketopen=false;
            }

        }
        catch (ParseException e)
        {

        }

        //In Production make sure you change this to false
        return marketopen;
        //return true;///////////////////////////////////////////////////////////////////////// For Testing, Change back in production
    }

    public static boolean checkifits15mints_before(String checktime) {
        Boolean inside_15minutes=true;

        try {
            Date time1 = new SimpleDateFormat("h:mm a").parse(checktime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);

            Date timebefore15 = new SimpleDateFormat("h:mm a").parse(gettimeonly_ampm());
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(timebefore15);
            calendar2.add(Calendar.MINUTE, -15);


            if(calendar1.getTimeInMillis()<calendar2.getTimeInMillis())
            {
                inside_15minutes=false;
            }

        }
        catch (ParseException e)
        {

        }

        return inside_15minutes;
    }

    public static String findprevday(String date_str, int delta) {
        String prevday="";
        try {
            Date time1 = new SimpleDateFormat("MMM-dd-yyyy").parse(date_str);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, -delta);
            prevday=new SimpleDateFormat("MMM-dd-yyyy").format(calendar1.getTime());

        }
        catch (ParseException e)
        {

        }

        return prevday;
    }

    public static String findnext5mints(String date_str, int delta) {
        String prevday="";
        try {
            Date time1 = new SimpleDateFormat("h:mm a").parse(date_str);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.MINUTE, delta);
            prevday=new SimpleDateFormat("h:mm a").format(calendar1.getTime());

        }
        catch (ParseException e)
        {

        }

        return prevday;
    }

    public static boolean checkifweekend(String getutctime) {
        Boolean weekend=false; //In Production make sure you change this to false

        try {
            Date time1 = new SimpleDateFormat("HH:mm:ss").parse(getutctime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);


            Date time2 = new SimpleDateFormat("HH:mm:ss").parse("9:15:00");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);


            Date time3 = new SimpleDateFormat("HH:mm:ss").parse("15:30:00");
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(time3);
            calendar3.add(Calendar.DATE, 1);

            //If
            Calendar calendar = Calendar.getInstance();
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                weekend=true;
            }

        }
        catch (ParseException e)
        {

        }

        return weekend;
        //return true;///////////////////////////////////////////////////////////////////////// For Testing, Change back in production
    }

    public static String getydaydateandtime_prev()
    {
        Calendar systemdate=Calendar.getInstance();
        systemdate.add(Calendar.DATE, -1);
        String sdate=new SimpleDateFormat("dd MMMM yyyy").format(systemdate.getTime());
        return sdate;
    }

    public static String get_date_of_expiry(int delta)
    {
        Calendar systemdate=Calendar.getInstance();
        systemdate.add(Calendar.DATE, delta);
        String sdate=new SimpleDateFormat("dd MMMM yyyy").format(systemdate.getTime());
        return sdate;
    }


    public static String getydaydateandtime_home()
    {
        Calendar systemdate=Calendar.getInstance();
        String sdate=new SimpleDateFormat("dd/MM/yyyy").format(systemdate.getTime());
        return sdate;
    }

    public static Boolean getdifference(String  lastupdated,int minutes) {
        Boolean reset=false;

        try {
            //Current time
            Date time1 = new SimpleDateFormat("dd/MM/yyyy HH:mm a Z").parse(getutcdate_time());
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);


            //Last updated time
            Date time2 = new SimpleDateFormat("dd/MM/yyyy HH:mm a Z").parse(lastupdated);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);

            //Last updated time plus the time difference
            calendar2.add(Calendar.MINUTE, minutes);

            //Compare if current date calender 1 > lastupdated + extra minutes, then reset
            if(calendar1.getTimeInMillis()>calendar2.getTimeInMillis())
            {
                reset=true;
            }

        }
        catch (ParseException e) {
        }
        return reset;
    }

    public static Boolean checkexpiryatmonthend(String  expiry) {
        Boolean monthend=false;

        try {
            //Covert string into date
            Date time1 = new SimpleDateFormat("dd-MMM-yyyy").parse(expiry);

            //Compare if date is greater than 20, then month end
            if(time1.getDate()>20)
            {
                monthend=true;
            }

        }
        catch (ParseException e) {
        }
        return monthend;
    }

    public static String getDatefromill(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static Boolean checkIfExpired(String expiry_date_str) {

        String currentdate_str=getfulldate_chartink();
        Boolean expired=true;
        try {
            //Get the current date
            Date expiry_date = new SimpleDateFormat("MMM-dd-yyyy").parse(expiry_date_str);
            Date current_date = new SimpleDateFormat("MMM-dd-yyyy").parse(currentdate_str);

            if(expiry_date.compareTo(current_date)>=0)
            {
                expired=false;
            }
        }
        catch (ParseException e)
        {

        }

        return expired;
    }

    public static String getTimefrom_Timeinmill(String timeinmill) {

        DateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy hh:mm a");

        long milliSeconds= Long.parseLong(timeinmill);
        System.out.println(milliSeconds);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        System.out.println();

        return formatter.format(calendar.getTime());
    }

    public static Date getDateFromString(String date_str,String format) {
        Date date_obj=null;
        Log.d("date_result",date_str);
        Log.d("date_result",format);

        try {
            //Get the date in dateformat
            date_obj = new SimpleDateFormat(format).parse(date_str);
            Log.d("date_result",date_obj.toString());
        }
        catch (ParseException e)
        {

        }
        return date_obj;
    }

    public static String getStringfromDate(Date date_obj,String format) {
        //Get the date in string
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        String date_str = sdf.format(date_obj);

        return date_str;
    }

    public static Long getTimeinMill_FromDate(Date date_obj) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_obj);
        Long timeinmill=calendar.getTimeInMillis();

        return timeinmill;
    }

    public static Date addDate_ToDate(Date date_obj,int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_obj);
        calendar.add(Calendar.DATE, delta);

        return calendar.getTime();
    }

    public static Date addHours_ToDate(Date date_obj,int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_obj);
        calendar.add(Calendar.HOUR, delta);

        return calendar.getTime();
    }

    public static Date addMinute_ToDate(Date date_obj,int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_obj);
        calendar.add(Calendar.MINUTE, delta);

        return calendar.getTime();
    }

}

