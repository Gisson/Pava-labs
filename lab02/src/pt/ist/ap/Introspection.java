package pt.ist.ap;

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Introspection{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    OutputStreamWriter osw = new OutputStreamWriter(System.out);
    try{
      osw.write("Command>",0,"Command>".length());
      osw.flush();

      String command = s.next();
      while(command!="exit"){
        switch(command){
          case "Class":
            System.out.println("Not implemented!");
            break;
          case "Set":
            System.out.println("Not implemented!");
            break;
          case "Get":
            System.out.println("Not implemented!");
            break;
          case "Index":
            System.out.println("Not implemented!");
            break;
          case "Help":
            System.out.println(help());
            break;
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
