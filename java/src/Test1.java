public class Test1 {  
  
   public static void method1(Object object)  
    {  
        System.out.println("Object");  
    }  
      
    public static void method1(String string)  
    {  
        System.out.println("String");  
    }  
      
      
    public static void main(String[] args) {  
          
        method1(null);  
    }  
}  