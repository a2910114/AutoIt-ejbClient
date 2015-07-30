package com.mykhaylenko.autoit;

 class A{
     
     private int a = 1;
     
     static {
         System.out.println("Static a");
     }
     
     {
         System.out.println("Non Static a" + a);
     }
     
     public A() {
         System.out.println("Constructor a");
     }
}

 class B extends A{
     
     private int b = 2;
     
     static {
         System.out.println("Static B");
     }
     
     {
         System.out.println("Non Static B " + b);
     }
     
     public B() {
         System.out.println("Constructor B");
     }
}
 
public class InitializeOrder {
    public static void main(String[] args){
        B b = new B();
    }
}
