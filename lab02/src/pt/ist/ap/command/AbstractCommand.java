package pt.ist.ap.command;


public abstract class AbstractCommand{
  protected Object _returnVal;

  public abstract void execute();
  public  Object getReturn(){return _returnVal;}
}
