import java.util.PriorityQueue;
import java.util.ArrayList;
public class test{


    public static class Pair{
        int chunkNo;
        Character[] data;
        public Pair(int chunk,Character[] data){
            this.chunkNo = chunk;
            this.data = data;
        }
    }
    //gobal queue which stores all chunk and data in the form of Pair ,and will return them on basis of the chunk no(smaller chunk will be returned first)
    static PriorityQueue<Pair> queue;
    //used to record whether chunk=1 is entered or not
    static int startingChunk;
    public static void main(String[] args) {
        
        queue = new PriorityQueue<>((a,b)->Integer.compare(a.chunkNo, b.chunkNo));
        startingChunk = 0;

        //Here the receive and read functions can be called to register or return chunk and its data.

    }

    

    public static void receive(int chunk,Character[] data){
        Pair np = new Pair(chunk,data);
        queue.add(np);

    }
    public static ArrayList<Character>  read(){
        ArrayList<Character> answer = new ArrayList<>();
        if(queue.size()==0){
            return answer;
        }
        if(startingChunk==0){
            if(queue.peek().chunkNo!=1){
                return answer;
            }
            startingChunk=1;
            //this signifies that the first chunk(1) has been used and now new entry of any other chunk will be considered the first chunk.If its value is 0 and first chunk is not present,empty list will be returned
        }
        
        while(queue.size()!=0){
            Pair rp = queue.remove();
            Character[] arr = rp.data;
            for(Character e: arr){
                answer.add(e);
            }
        }


        return answer;
    }
}