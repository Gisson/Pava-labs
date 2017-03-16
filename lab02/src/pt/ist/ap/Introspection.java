package pt.ist.ap;

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.IOException;
import pt.ist.ap.command.*;
import java.util.Hashtable;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.reflect.InvocationTargetException;
import pt.ist.ap.exceptions.*;


public class Introspection{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    Object lastResult=null;
    Hashtable classes=new Hashtable<String,Object>();

    System.out.print("Command> ");
    String command;
    String arg;

    while(!(command=s.next()).equals("Exit")){
      Class toRun;
      AbstractCommand commandClass;
      try{
        toRun=Class.forName("pt.ist.ap.command."+command+"Command");
      }catch(ClassNotFoundException e){
        System.err.println("Dude you are retard. Try again.... Now read the help ffs....\n"+help());
        continue;
      }
      arg=s.next();
      try{
        //Class command
        commandClass=((AbstractCommand)(toRun.getDeclaredConstructor(String.class).newInstance(arg)));
        commandClass.execute();
        lastResult=commandClass.getReturn();
      }catch(NoSuchMethodException e){
        try{
          //GET command
          commandClass=((AbstractCommand)(toRun.getDeclaredConstructor(String.class, Hashtable.class).
          newInstance(arg, classes)));
          commandClass.execute();
          lastResult=commandClass.getReturn();
        }catch(NoSuchMethodException e2){
          try{
            //SET command
            commandClass=((AbstractCommand)(toRun.getDeclaredConstructor(String.class, Object.class, Hashtable.class).
            newInstance(arg,lastResult,classes)));
            commandClass.execute();
          }catch(NoReturnExpectedException e3){
            continue;
          }catch(NoSuchMethodException e3){
            try{
              //Index command
              commandClass=((AbstractCommand)(toRun.getDeclaredConstructor(Integer.class).
              newInstance(Integer.parseInt(arg))));
              commandClass.execute();
              lastResult=commandClass.getReturn();
            }catch(Exception e4){
              e4.printStackTrace();
            }
          }catch(Exception e3){
            e3.printStackTrace();
          }
        }catch(Exception e2){
          e2.printStackTrace();
        }

      }catch(Exception e){
        System.err.println("bla");
        continue;
      }
      System.out.print("Command> ");

    }


  }

  public static String help(){
    return "Class <name> : obtain instance of Class<name>\nSet <name> : save object from last result with name <name>\nGet <name> : select object previously saved with <name>\nIndex <int> : select object within an array. The array should have been obtained as the result of the previous command.";
  }



}
