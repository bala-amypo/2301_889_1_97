package com.example.demo.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Studententity;

@Service
public class Studentservice {
    Map<Integer,Studententity> mp= new HashMap<>();

    public Studententity savedata(Studententity st){
        mp.put(st.getId(),st);
        return st;
    }

    public List<Studententity> retdata() {
        return new ArrayList<>(mp.values());
    }

    public Studententity id(int id) {
        return mp.get(id);
    }

     public Studententity updateStudent(int id, Studententity st) {
        return mp.replace(id,st);
     }

    public Studententity deleteStudent(int id) {
        return mp.remove(id);
    }

}