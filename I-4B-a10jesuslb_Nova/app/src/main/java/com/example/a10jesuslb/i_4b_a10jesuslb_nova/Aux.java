package com.example.a10jesuslb.i_4b_a10jesuslb_nova;



import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Aux {

    public static boolean[] calculaBool(String... array) {
        boolean[] b = new boolean[array.length];
        for (boolean s : b) {

            s = Boolean.parseBoolean(""+((int)(Math.random()*10)));

        }
        return b;
    }

    public static ArrayList<String> valores = new ArrayList<>();

    public static void addValores(String... val){
        for(String s : val){
            valores.add(s);
            Log.i("valores", s);
        }
    }

    public static String[] castArray(Object... arr){
        String[] a = new String[arr.length];
        int v=0;
        for(Object o : arr){
            a[v] = (String)o;
            v++;
        }
        Log.i("valores", Arrays.toString(a));
        return a;
    }
}
