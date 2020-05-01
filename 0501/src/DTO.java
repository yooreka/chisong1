import java.io.Serializable;

//선수이름(문자열), 팀이름(문자열), 선수평점(실수)를 저장하는 클래스
public class DTO  implements Serializable{
 private String name;
 private String teamname;
 private double grade;
public DTO() {
	super();
	// TODO Auto-generated constructor stub
}
public DTO(String name, String teamname, double grade) {
	super();
	this.name = name;
	this.teamname = teamname;
	this.grade = grade;
}
@Override
public String toString() {
	return "DTO [name=" + name + ", teamname=" + teamname + ", grade=" + grade + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTeamname() {
	return teamname;
}
public void setTeamname(String teamname) {
	this.teamname = teamname;
}
public double getGrade() {
	return grade;
}
public void setGrade(double grade) {
	this.grade = grade;
}
	
}
