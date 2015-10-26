package com.example.a10jesuslb.i_4b_a10jesuslb_nova;

/**
 * Created by a10jesuslb on 10/26/15.
 */
public class Aux {

    public static boolean[] calculaBool(String... array) {
        boolean[] b = new boolean[array.length];
        for (boolean s : b) {

            s = Boolean.parseBoolean(""+((int)(Math.random()*10)));

        }
        return b;
    }


}
