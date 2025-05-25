package com.neoteric.student.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {
        List<Emp>empList= new ArrayList<>();

        Emp a = new Emp();
        a.name= "it";
        empList.add(a);

        Emp b= new Emp();
        b.name="it";
        empList.add(b);



        List<Dept>deptList= new ArrayList<>();
        Dept c = new Dept();
        c.empList= empList;
        deptList.add(c);
        Dept d = new Dept();
        d.empList= empList;
        deptList.add(d);


      long total=  deptList.stream()
              .flatMap(dept -> dept.empList.stream())
              .count();
        System.out.println(total);

    }
}
