public class Teste
{   
    public static void Main(string[] args)
    {
        Stack<int> stack = new Stack<int>();
        int y = 0;
        stack.Push(42);              
        stack.Push(43);
        stack.Push(4);
        foreach (int x in stack)
        {
            Console.WriteLine(x);
        }
    }
}