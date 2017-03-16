package pt.ist.ap;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import pt.ist.ap.annotations.*;


public class RunTests{

  public static HashMap<String,Method> lemonparty=new HashMap<String,Method>();

  public static void main(String[] argv) throws Exception{
    int passed=0,failed=0;
    for(Method m : Class.forName("pt.ist.ap.tests."+argv[0]).getDeclaredMethods()){
      if(m.isAnnotationPresent(Setup.class)){
        lemonparty.put(((Setup)(m.getAnnotation(Setup.class))).value(),m);
        System.out.println("I put it in "+ m.getName());
        //System.out.println("I put it in "+((Setup)(m.getAnnotation(Setup.class))).value());
      }
      else{
        System.out.println("I put no it in "+ m.getName());
      }
    }


  }

}
