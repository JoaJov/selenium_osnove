package p_3_10_2023;


import org.testng.annotations.*;

public class Uvod {
    @BeforeClass
    public void setup(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void beforMethod(){
        System.out.println("Before method");
    }

   @Test
    public void googleTitleTest (){
       System.out.println("Google test");
   }
       @AfterMethod
    public void afterMethod(){
           System.out.println("After method");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
}
