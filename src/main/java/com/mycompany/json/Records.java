package com.mycompany.json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoseSilva
 */
public class Records {
    List<Person> records=new ArrayList();
    public void Display(){
        for(Person person:records){
            System.out.println(person.getName() 
            + " " + person.getCity() + " "+ person.getCountry());
        }
    }
}
