package allchapters;


interface EdMethodReferenceInterface
{
    String process(String input);
}
 
public class EdMethodReference
{
    public static String toUpperStatic(String input)
    {
        return input.toUpperCase();
    }
 
    public String toUpperInstance(String input)
    {
        return input.toUpperCase();
    }
 
    public String toUpperFromThis(String input)
    {
    	EdMethodReferenceInterface sam = this::toUpperInstance;
        return sam.process(input);
    }
 
    public static void main(String... args)
    {
    	EdMethodReferenceInterface sam = EdMethodReference::toUpperStatic;
        System.out.println("\n\n\tstatic method reference = "+sam.process("static_input"));
         
        EdMethodReference methodReference = new EdMethodReference();
        sam = methodReference::toUpperInstance;
        System.out.println("\n\n\tinstance method reference = "+sam.process("instance_input"));
        EdMethodReferenceInterface xx = c -> c;
        System.out.println(xx.process("WW"));
        
        System.out.println("\n\n\t\"this\" method reference = "+methodReference.toUpperFromThis("this_input"));
        System.out.println("");
    }
}