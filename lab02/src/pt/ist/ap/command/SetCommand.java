package pt.ist.ap.command;

import java.util.Hashtable;

public class SetCommand extends StringCommand{

  Hashtable _table;
  Class _c;

  public SetCommand(String name,Class c,Hashtable table){super(name);_table=table;_c=c;}
  @Override
  public void execute(){
    _table.put(getArg(),_c);
    System.out.println("I put it in!");
    //System.out.println(_table);
  }
}
