import java.util.Scanner;

class driver
{
    public static void main(String[] args)
    {
        String log[]={
            "10:20 jaimin how are you?",
            "2:00 hello abc",
            "abcdefgh",
            "5:20 hello world"
        };

        Scanner sc=new Scanner(System.in);
        System.out.print("enter key :");
        String key=sc.next();

        String result = chartfilter.filter(log,key);

        System.out.println(result);


    }
}