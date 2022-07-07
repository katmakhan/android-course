# android-free-course
Try the Online complier for java to test these codes, Remember to add the import functions also.

```console  
https://www.programiz.com/java-programming/online-compiler/
```


## Sample Code to Try 

```console
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        String date_str=getfulldate();
        System.out.println(date_str);
    }
    
    public static String getfulldate()
    {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy");
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTimeString = sdf.format(d);
        return currentDateTimeString;
    }
}
```