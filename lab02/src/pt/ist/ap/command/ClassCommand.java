package pt.ist.ap.command;



public class ClassCommand extends StringCommand{

  public ClassCommand(String arg){super(arg);}
  @Override
  public void execute(){
    try{
      _returnVal = Class.forName(getArg());
      System.out.println("FOUND YOU LITTLE BITCH: "+((Class)_returnVal).getCanonicalName());
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }

}
