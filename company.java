abstract class Employee {
    String name;
    int id;
    float salary;
    abstract void calculate_bonus();
    abstract void display_info();

  
    Employee(String n, int i, float s) {
        name = n;
        id = i;
        salary = s;
    }
}
class Manager extends Employee {
    int team_size=120;
    Manager(String name, int id, float salary) {
        super(name,id,salary);
    }
   void calculate_bonus()
  {
   float bonus;
   bonus=(salary)*(50.0f/100);
   salary=salary+bonus;
   System.out.println("New salary after bonus: "+salary);
   } 
    void display_info()
  { 
   System.out.println("Name: "+name);
   System.out.println("ID: "+id);
   System.out.println("Salary: "+salary);
   
  }
  void readteam(){
   System.out.println("your current team size is: "+team_size);
   }
 
 }
 
 class Senior_Manager extends Manager{
   int stock_options=6;
   Senior_Manager(String name, int id, float salary){
    super(name,id,salary);
    }
    void display_info()
  {
   System.out.println("Name: "+name);
   System.out.println("ID: "+id);
   System.out.println("Salary: "+salary);
  }  
   void stocks(){
    System.out.println("Number of stocks available: "+stock_options); 
  }
  }



class Developer extends Employee {
    int pgm_lang=4;
    Developer(String name, int id, float salary) {
        super(name,id,salary);
    }
    void calculate_bonus()
  {
   float bonus;
   bonus=(salary)*(75.0f/100);
   salary=salary+bonus;
   System.out.println("New salary after bonus: "+salary);
   } 
    void display_info()
  {
   System.out.println("Name: "+name);
   System.out.println("ID: "+id);
   System.out.println("Salary: "+salary);
  }  
    void lang(){
    System.out.println("---PROGRAMMING LANGUAGES---");
    System.out.println("Amount: "+pgm_lang);
    System.out.println("Java: 2 year exp");
    System.out.println("C: 1 year exp");
    System.out.println("Python: 2 year exp");
    System.out.println("Arduino: 2 year exp");
    }
    
    void assign_task(){
     System.out.println("New employees: Assigned to do the excel sheet");
     }
    
    void assign_task(int a){
    System.out.println("Assigned to do "+a+" number of projects within a week");
    }
    
    void assign_task(String z)
    {
     System.out.println("The mentor of the intern is: "+z);
     }
}


class JuniorDeveloper extends Developer{
  String mentor="Ram";
   JuniorDeveloper(String name, int id, float salary){
    super(name,id,salary);
    }
    void display_info()
  {
   System.out.println("Name: "+name);
   System.out.println("ID: "+id);
   System.out.println("Salary: "+salary);
  }  
   void teach(){
    System.out.println("Mentor: "+mentor); 
  }
  }



  
  
class Intern extends Employee {
    int duration=1;
    Intern(String name, int age, float salary) {
        super(name,age,salary);
    }
   void calculate_bonus()
  {
   float bonus;
   bonus=(salary)*(90.0f/100);
   salary=salary+bonus;
   System.out.println("New salary after bonus: "+salary);
   } 
    void display_info()
  {
   System.out.println("Name: "+name);
   System.out.println("ID: "+id);
   System.out.println("Salary: "+salary);
  }
  void dur(){
   System.out.println("Duration of intership: "+duration+ " year");
  }
  }
      

public class company {
    public static void main(String[] args) {
        Manager m = new Manager("Raz", 21, 40000);
        Developer d= new Developer("Tiger", 24, 25000);
        Intern n= new Intern("Zimba", 19, 15000);
        Senior_Manager s= new Senior_Manager("Ramesh", 38, 41000);
        JuniorDeveloper j= new JuniorDeveloper("Razhal", 24, 20000);
        System.out.println("Manager");
        m.display_info();
        m.calculate_bonus();
        m.readteam();
        System.out.println(); 
        System.out.println("Developer");
        d.display_info();
        d.calculate_bonus();
        d.lang();
        d.assign_task(4);
        d.assign_task("Ram");
        d.assign_task();
        System.out.println(); 
        System.out.println("Intern");
        n.display_info();
        n.calculate_bonus();
        n.dur();
        System.out.println(); 
        System.out.println("Senior Manager");
        s.display_info();
        s.stocks();
        System.out.println(); 
        System.out.println("Junior Developer");
        j.display_info();
        j.teach();
        
    }
}




