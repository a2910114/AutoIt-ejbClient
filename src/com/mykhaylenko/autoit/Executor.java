package com.mykhaylenko.autoit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class Executor {

    private final static Logger logger = Logger.getLogger(Executor.class);
    
    public static void main(String[] args){
//        Autoit auto = new Autoit();
//        auto.openInventory();
        
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("tree");
        list.add("four");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String obj = iterator.next();
            if ("two".equals(obj)){
                iterator.remove();
            }
            System.out.println(obj);
        }
    }
}
