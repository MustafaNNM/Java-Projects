package balonpatlatma;
import java.util.*;
public class Sepet {
    private Stack yigit;
    private Queue kuyruk;
    private int no;
    public Sepet(int sepetno){
        no=sepetno;
        if(no%2==1)
        
          yigit =StackDoldur();
        
        else
            kuyruk=QueueDoldur();
    }
    

    public Stack StackDoldur(){
        Stack s=new Stack();
        for(int i=0; i<5; i++)
            s.push(randomRenk());
        return s;
    
        }
     public Queue QueueDoldur(){
        Queue q=new LinkedList();
        for(int i=0; i<5; i++)
            q.add(randomRenk());
        return q;

        }

    public String randomRenk(){
        String[] renkler={"Mavi","Sari","Yesil","Kirmizi","Siyah"};
        return renkler[(int)(Math.random()*5)];
    }

    public void yazdir(){

        if(no%2 ==0){
        Iterator itr=kuyruk.iterator();
        while(itr.hasNext())
        {
        String iteratorValue=(String)itr.next();
        System.out.println("Queue Next Value:"+iteratorValue);
        }
        }
        else{
            while(!yigit.empty())
                System.out.println(yigit.pop());
            if(yigit.empty()) System.out.println("empty");
        }

    }

    


}
