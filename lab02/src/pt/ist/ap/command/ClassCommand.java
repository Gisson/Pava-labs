package pt.ist.ap.command;



public class ClassCommand extends StringCommand{
  private Class _found;

  public ClassCommand(String arg){super(arg);}
  @Override
  public void execute(){
    try{
      _found = Class.forName(getArg());
      System.out.println("FOUND YOU LITTLE BITCH: "+getCanonicalName());
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }

  public Class getFound(){
    return _found;
  }
}
