package pt.ist.ap.command;

import java.util.Hashtable;

public class GetCommand extends StringCommand{

  private Hashtable _table;
  private Class _c;

  public GetCommand(String name,Hashtable table){super(name);_table=table;}
  @Override
  public void execute(){
    _c = (Class)_table.get(getArg());
    System.out.println("I put it out! "+_c.getCanonicalName());
  }

  public Class getFound(){
    return _c;
  }
}
