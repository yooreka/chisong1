import java.util.Date;

public class Player {
         private String name;
         private Date birth;
         private String email;
         private String nickname;
         private int age;
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getBirth() {
			return birth;
		}
		public void setBirth(Date birth) {
			this.birth = birth;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return "Player [name=" + name + ", birth=" + birth + ", email=" + email + ", nickname=" + nickname
					+ ", age=" + age + "]";
		}
}
