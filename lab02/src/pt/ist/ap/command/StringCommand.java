package pt.ist.ap.command;




public abstract class StringCommand implements AbstractCommand{
  private String _arg;

  public StringCommand(String arg){ _arg=arg;}
  @Override
  public abstract void execute();
  protected String getArg(){return _arg;}
}
