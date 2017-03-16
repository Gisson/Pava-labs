package pt.ist.ap.command;

import java.util.Hashtable;
import pt.ist.ap.exceptions.*;

public class SetCommand extends StringCommand{

  Hashtable _table;
  Object _c;

  public SetCommand(String name,Object c,Hashtable table){super(name);_table=table;_c=c;}
  @Override
  public void execute(){
    _table.put(getArg(),_c);
    System.out.println("I put it in!");
  }

  @Override
  public Object getReturn(){
    throw new NoReturnExpectedException();
  }
}
