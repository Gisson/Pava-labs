package pt.ist.ap.command;

import java.util.Hashtable;

public class GetCommand extends StringCommand{

  private Hashtable _table;

  public GetCommand(String name,Hashtable table){super(name);_table=table;}
  @Override
  public void execute(){
    _returnVal=_table.get(getArg());
  }


}
