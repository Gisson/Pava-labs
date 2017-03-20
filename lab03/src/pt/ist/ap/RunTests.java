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
      }
    }

    for(Method m : Class.forName("pt.ist.ap.tests."+argv[0]).getDeclaredMethods()){

    	if(m.isAnnotationPresent(Test.class)){
    		String[] testArgs = ((Test)(m.getAnnotation(Test.class))).value();
    		if(!testArgs[0].equals("")){
    			for(String s : testArgs ){
    				try { 
    					Method m1 = lemonparty.get(s);
    					m1.setAccessible(true);
    					m1.invoke(null);
    					m1.setAccessible(false);
    				} catch (Throwable ex) {
    					System.out.printf("Test %s failed: %s %n", m, ex.getCause());
    				}
    			}
    		}
    		
    		
        	try {
        		m.setAccessible(true);
        		m.invoke(null);
        		m.setAccessible(false);
        		passed++;
                System.out.printf("Test %s OK! %n", m);
        	} catch (Throwable ex) {
        		System.out.printf("Test %s failed: %s %n", m, ex.getCause());
        		failed++;
        	}
        }
    }
    
    System.out.printf("Passed: %d, Failed %d %n", passed, failed);

  }
}
