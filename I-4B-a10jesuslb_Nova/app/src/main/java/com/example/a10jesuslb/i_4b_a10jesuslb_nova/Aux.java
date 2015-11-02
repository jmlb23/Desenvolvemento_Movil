package com.example.a10jesuslb.i_4b_a10jesuslb_nova;



import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Aux {

    //Devolve un array de boolean en funcion dun array de strings
    public static boolean[] calculaBool(String... array) {
        boolean[] b = new boolean[array.length];
        boolean valor =true;
        int index =0;
        for (boolean s : b) {

            b[index] = false;
            index++;
        }
        return b;
    }

    public static ArrayList<String> valores = new ArrayList<>();

    //agrega os valores o arraylist
    public static void addValores(String... val){
        for(String s : val){
            valores.add(s);
        }
    }

    public static String[] castArray(Object... arr){
        String[] a = new String[arr.length];
        int v=0;
        for(Object o : arr){
            a[v] = (String)o;
            v++;
        }
        return a;
    }
}
