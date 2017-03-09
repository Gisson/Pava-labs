package pt.ist.ap.command;

import java.lang.reflect.Array;

public class IndexCommand implements AbstractCommand{
  private int _position;


  public IndexCommand(int pos){
    _position=pos;
  }

  @Override
  public void execute(){
    if(!(lastCommand.getClass() instanceof Array)){
      System.out.println("I no clean!");
      return;
    }
  }
}
