import java.util.Scanner;


class PasswordChecker
{
     String strength(String pw)
    {
        int count = 0;

        if(pw.length() >= 8)
        {

            count++;
        }

        if(pw.matches(".*[A-Z].*"))
        {
            count++;
        }

        if(pw.matches(".*[0-9].*"))
        {
            count++;
        }

       if(pw.matches(".*[^a-zA-Z0-9].*"))
        {
            count++;
        }

       System.out.println("count : " + count);
        if(count <= 1)
            return "Weak";
        else if(count <= 3)
            return "Medium";
        else
            return "Strong";
    }

    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        System.out.print("enter password : ");

        String pw= sc.next();

            System.out.println("\nPassword: " + pw);

            PasswordChecker p=new PasswordChecker();

            String result = p.strength(pw);

            System.out.println("Strength: " + result);

            

    }
}