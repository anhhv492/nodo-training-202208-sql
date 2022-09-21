package io;

import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

public class DecodingExample {
    public static void main(String[] args) {
        try {
            byte[] bytes=new byte[]{120,105,110,32,99,104,-61,-96,111};
            System.out.println(new String(bytes,"utf8"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
