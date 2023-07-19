import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App 
{
    static File                     file; 
    static StringBuilder            message;

    public static Long thisTime () { return System.currentTimeMillis(); }

    public static void getResult(long start, long end, String title) 
    {
        try 
        {
            message               = new StringBuilder();
            System.out.println("제목        : "     + title              );
            System.out.println("start       : "     + start              );
            System.out.println("end         : "     + end                );
            System.out.println("총 걸린 시간 : "     + ( end - start )    );    
            System.out.println();
            
            message.append("제목        : "     + title              +"\n");
            message.append("start       : "     + start              +"\n");
            message.append("end         : "     + end                +"\n");
            message.append("총 걸린 시간 : "     + ( end - start )    +"\n");
            message.append("");

            FileOutputStream            outputStream       = new FileOutputStream(file, true);
            OutputStreamWriter          outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
            outputStreamWriter.write(message.toString());
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            System.out.println(e.getLocalizedMessage());
        }

    }

    public static void main(String[] args) throws Exception 
    {
        StringBuilder               builder                      = new StringBuilder().append(System.getProperty("user.dir"));
                                    // builder.append("\\"+UUID.randomUUID().toString()+".txt");
                                    builder.append("\\"+"result"+".txt");
        
                                    file                        = new File(builder.toString());
                                    


        int[]                       arrA                         = new int[200000];
        ArrayList<Integer>          arrB                         = new ArrayList<>();
        int                         temp                         = 0;

        for( int i = 0; i<200000; i++ )
        {
            arrA[i] = i;
            arrB.add (i);
        }

        // TEST 1 -> array 에서 특정 값 찾아서 바꾸는데 걸리는 시간 
        System.out.println(" ::::: TEST 1 특정 값 찾아서 바꾸는데 걸리는 시간 :::::");
        long                        start                       = System.currentTimeMillis();
        arrA[66665] = 999;       
        long                        end                         = System.currentTimeMillis();
        getResult(start, end, "array에서 특정 값 찾아서 바꾸는데 걸리는 시간 : ARRAY     : "+arrA[66665]);

        start                       = thisTime();
        arrB.add(66665, 999);        
        end                         = thisTime();
        getResult(start, end, "array에서 특정 값 찾아서 바꾸는데 걸리는 시간 : ARRAYLIST : "+arrB.get(66665));

        // 총 걸린 시간 : 0 -> 겁나 빠름 의미가 없네 


        System.out.println(" ::::: TEST 2 반복문 속도 비교 :::::");
        // TEST 2 -> forEach, Stream, for 속도 비교 

            // 1.for 문 : Array
            start = thisTime();
            for( int i = 0; i<200000; i++ ) { temp = arrA[i];}
            end   = thisTime();
            getResult(start, end, "forEach, Stream, for 문 속도 비교 : No1. for  : ARRAY");
            


            // for 문 : ArrayList
            start = thisTime();
            for( int i = 0; i<200000; i++ ) { temp = arrB.get(i); }
            end   = thisTime();
            getResult(start, end, "forEach, Stream, for 문 속도 비교 : No1. for  : ARRAYLIST");

            // 2.forEach
            start = thisTime();
            for( int i : arrA ) { temp = i; }
            end   = thisTime();
            getResult(start, end, "forEach, Stream, for 문 속도 비교 : No2. forEach : ARRAY");

            start = thisTime();
            for( int i : arrB ) { temp = i; }
            end   = thisTime();
            getResult(start, end, "forEach, Stream, for 문 속도 비교 : No2. forEach : ARRAYLIST");

        
    }
}
