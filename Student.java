/**
 * 
 */
package sqlmy;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
/**
 * @author Ankita
 *
 */
public class Student {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root", ""); 
         
            Statement st = conn.createStatement();
         
        	Scanner sc = new Scanner(System.in);
        	int ch = 0;        	
        	do{
        		System.out.println("*****Menu******");
            	System.out.println(" 1. Insert.\n 2. Update\n 3. Delete\n 4.Display List of students\n 5. Get data from id.\n 6. Exit");
                
        		System.out.println("Enter your choise :");
        		ch = sc.nextInt();
        		
        		switch(ch){
        			case 1: System.out.println("Enter the student id :");
        					int id = sc.nextInt();
        					
        					System.out.println("Enter the student name: ");
        					String name = sc.next();

        					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
        					
        					System.out.println("Enter the Date of Birth : ");
        					String dob = sc.next();
        					Date dob1 = sdf.parse(dob);
        					java.sql.Date act_dob = new java.sql.Date(dob1.getTime());
        					
        					System.out.println("Enter the Date of joining : ");
        					String doj = sc.next();
        					Date doj1 = sdf.parse(doj);
        					java.sql.Date act_doj = new java.sql.Date(doj1.getTime());
        					
        					String que = "INSERT INTO `student`(`Student_no`, `student_name`, `student_dob`, `student_doj`) VALUES (?,?,?,?)";
        					PreparedStatement prestmt = conn.prepareStatement(que);
        					prestmt.setInt(1, id);
        					prestmt.setString(2, name);
        					prestmt.setDate(3, act_dob);
        					prestmt.setDate(4, act_doj);
        					prestmt.executeUpdate();
        					System.out.println("Data inserted sucessfully");
        					break;
        					
        			case 2: System.out.println("Enter the id of student : ");
         					int id2 = sc.nextInt();
        					
        					System.out.println("Enter the updated name:");
        					String uname = sc.next();
        					
        					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
        					
        					System.out.println("Enter the Date of Birth : ");
        					String dob2 = sc.next();
        					Date dob21 = sdf1.parse(dob2);
        					java.sql.Date act_dob2 = new java.sql.Date(dob21.getTime());
        					
        					System.out.println("Enter the Date of joining : ");
        					String doj2 = sc.next();
        					Date doj21 = sdf1.parse(doj2);
        					java.sql.Date act_doj2 = new java.sql.Date(doj21.getTime());
        					
        					String que2 = "UPDATE `student` SET `Student_no`=?,`student_name`=?,`student_dob`=?,`student_doj`=? WHERE `Student_no` = '"+id2+"'";
        					PreparedStatement prestmt2 = conn.prepareStatement(que2);
        					prestmt2.setInt(1, id2);
        					prestmt2.setString(2, uname);
        					prestmt2.setDate(3, act_dob2);
        					prestmt2.setDate(4, act_doj2);
        					prestmt2.executeUpdate();
        					System.out.println("Data is updated sucessfully");
        					break;
        					
        			case 3:	System.out.println("Enter the name of student : ");
        					String name_del = sc.next();
        					
        					String que3 = "DELETE FROM `student` WHERE `student_name` = '"+name_del+"'";
        					st.executeUpdate(que3);
        					System.out.println("The data is deleted sucessfully");
        					
        					break;
        			case 4: 
        					ResultSet rc = st.executeQuery("SELECT * FROM `student`");
        						System.out.print("ID \tName\tDOB\t\tDOJ\n");
        					while(rc.next()){
        						System.out.print(rc.getInt("Student_no")+"\t");
        						System.out.print(rc.getString("student_name")+"\t");
        						System.out.print(rc.getString("student_dob")+"\t");
        						System.out.println(rc.getString("student_doj"));
        					}
        					break;
        		
        			case 5: System.out.println("Enter the id of student : ");
        					int id1 = sc.nextInt();
        					
        					ResultSet rs = st.executeQuery("SELECT * FROM `student` WHERE `Student_no`='"+id1+"'");
        					rs.next();
        					
        					System.out.print("ID \tName\tDOB\t\tDOJ\n");
        					System.out.print(rs.getInt("Student_no")+"\t");
    						System.out.print(rs.getString("student_name")+"\t");
    						System.out.print(rs.getString("student_dob")+"\t");
    						System.out.println(rs.getString("student_doj"));
        					break;
        			case 6 :System.exit(0);
        					break;
        			default : System.out.println("Enter the correct choise");
        		}
        	}while(ch < 6); 
        }
        catch(Exception e){
        	System.out.println(e);
        }
        }
	
}


