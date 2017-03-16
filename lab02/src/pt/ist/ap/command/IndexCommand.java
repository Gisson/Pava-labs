package pt.ist.ap.command;

import java.lang.reflect.Array;
import java.lang.RuntimeException;

public class IndexCommand extends AbstractCommand{
  private Integer _position;
  private Array _arr;

  public IndexCommand(Integer pos, Object o){
    _position=pos;
    if( o instanceof Array){
      _arr=(Array)o;
    }else{
      throw new RuntimeException();
    }
  }

  @Override
  public void execute(){
    _returnVal=Array.get(_arr,_position);
  }

}
