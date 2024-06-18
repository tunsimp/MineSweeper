
import java.util.Stack;

public class CareTaker {
    private Stack<Memeto> moveStack;
    public CareTaker(){
        moveStack=new Stack<>();
    }
    public void saveState(Memeto memeto){
        moveStack.push(memeto);
    }
    public Memeto restoreState(){
        if(moveStack.isEmpty()){
            return null;
        }else {
            return moveStack.pop();}
    }
}
