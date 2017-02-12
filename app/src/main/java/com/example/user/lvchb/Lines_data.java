package com.example.user.lvchb;

/**
 * Created by User on 15.01.2017.
 */

public class Lines_data {
   /* время
    * имя
    * цена
    * флаг*/
    String time;
    String name;
    int sum;
    boolean flag;

    Lines_data(String _time,String _name,int _sum, boolean _flag){
        time=_time;
        name=_name;
        sum=_sum;
        flag=_flag;

    }

}
