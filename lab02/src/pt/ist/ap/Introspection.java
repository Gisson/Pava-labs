package pt.ist.ap;

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.IOException;
import pt.ist.ap.command.*;
import java.util.Hashtable;


public class Introspection{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    OutputStreamWriter osw = new OutputStreamWriter(System.out);
    try{
      osw.write("Command>",0,"Command>".length());
      osw.flush();

      String command = s.next();
      Object lastResult=null;
      Hashtable classes=new Hashtable<String,Object>();
      while(true){
        switch(command){
          case "Class":
            ClassCommand classy = new ClassCommand(s.next());
            classy.execute();
            lastResult=classy.getFound();
            break;
          case "Set":
            if(lastResult==null){
              help();
              break;
            }
            (new SetCommand(s.next(),lastResult,classes)).execute();
            break;
          case "Get":
            GetCommand classy2 = new GetCommand(s.next(),classes);
            classy2.execute();
            lastResult=classy2.getFound();
            break;
          case "Index":


            break;
          case "Help":
            System.out.println(help());
            break;
          case "Exit":
            System.exit(0);
          default:
            System.out.println("Command not found!");
            System.out.println(help());
            break;
        }
        osw.write("Command>",0,"Command>".length());
        osw.flush();
        command=s.next();
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public static String help(){
    return "Class <name> : obtain instance of Class<name>\nSet <name> : save object from last result with name <name>\nGet <name> : select object previously saved with <name>\nIndex <int> : select object within an array. The array should have been obtained as the result of the previous command.";
  }



}
