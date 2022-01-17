
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;





@ManagedBean(name="studentsObj")
@SessionScoped
public class StudentMarks {
    
    private String name;
    private String rollNo;
    private int    mark1;
    private int    mark2;
    private int    mark3;
    
    
    public StudentMarks() {}
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }
    
    
    
    
    
    
    
    
    
    
    public List<StudentMarks> seeAll() {
        List<StudentMarks> rsList = new ArrayList<StudentMarks>();
    
        try{  
            
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","");  
       
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT * FROM `student_marks`");  
            
            while(rs.next()) {
                StudentMarks stdm = new StudentMarks();
                
                stdm.setName(rs.getString(1));
                stdm.setRollNo(rs.getString(2));
                stdm.setMark1(rs.getInt(3));
                stdm.setMark2(rs.getInt(4));
                stdm.setMark3(rs.getInt(5));
                
                
                rsList.add(stdm);
            }  



            con.close();  
        }catch(Exception e){ System.out.println(e);}  
        
        
        
        
        return rsList;
    }
    
    
    
    
    
    
    public String add() {
        try{  
            
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","");  

            
            
            Statement stmt = con.createStatement();  
            int rslt = stmt.executeUpdate("INSERT INTO "+ "student_marks" +" VALUES ('"+ name +"', '"+ rollNo +"', "+ mark1 +", "+ mark2 +", "+ mark3 +");");
            
            if (rslt == 1) {
                System.out.println("Inserted Successfully");
                return "successInsert";
            }
            else {
                System.out.println("Insertion Failed");
            }
            
            
    //        ResultSet rs=stmt.executeQuery("select * from emp");  
    //        while(rs.next())  
    //        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 



            con.close();  
        }catch(Exception e){ System.out.println(e);}  
        
        
        return "failInsert";
    }
    
    
    
    
    
   
}
