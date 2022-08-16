package lambda;

public class Student {
    private int id,age;
    private String name;
    public Student(){
    }
    public Student(String name, int age){
        this.id= (int) (Math.random()*1000);
        this.age = age;
        this.name = name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return id+":"+name+":"+age;
    }
}
