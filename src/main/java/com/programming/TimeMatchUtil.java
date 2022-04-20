package com.programming;

import java.security.MessageDigest;
import java.util.Objects;

public class TimeMatchUtil {
    public static void getTimeLImit(long timeLimit,long currTime){
        long start;
        long end;//cava限制，初始化时，无法赋初值
        start=timeLimit>>32;
        end=timeLimit&4294967295L;//cava限制，0x开始的值，运行时是随机值。只能用0xffffffffL的十进制数来代替

        System.out.println("start:"+Long.valueOf(start).toString()+" end:"+Long.valueOf(end).toString());

        if(currTime < end && currTime > start)
        {
            System.out.println("当前时间在范围内");
        }
        else
        {
            System.out.println("当前时间在超出范围");
        }

    }

    static public void main(String[] argv)
    {
        long currTime=System.currentTimeMillis()/1000/60-15777600L;
        System.out.println("currTime is "+Long.valueOf(currTime).toString());
        TimeMatchUtil.getTimeLImit(49508947026152639L,currTime);

    }
}
