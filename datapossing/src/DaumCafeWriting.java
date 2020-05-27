import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaumCafeWriting {

	public static void main(String[] args) {

		try {
            //브라우저 실행
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//다음 로그인 페이지 접속
			driver.get("https://logins.daum.net/accounts/signinform.do?url=https%3A%2F%2Fwww.daum.net%2F");
			//아이디 입력란을 찾기
			WebElement id = driver.findElement(By.xpath("//*[@id=\"id\"]"));
			id.sendKeys("you7616");
		    // 비번입력란
			WebElement pw = driver.findElement(By.xpath("//*[@id=\"inputPwd\"]"));
			pw.sendKeys("dbsguswjd132");
			//로그인버튼찾기
			WebElement login = driver.findElement(By.xpath("//*[@id=\"loginBtn\"]"));
			login.click();
		     Thread.sleep(3000);
			//카페로이동
			driver.get("http://cafe.daum.net/irivertown/_memo");
			//프레임으로 이동
			driver.switchTo().frame("down");
			//글을 입력
			//4초마다 입력했음 3번을
			for(int i=0; i<3; i++) {
			Thread.sleep(4000);
			WebElement memo = driver.findElement(By.xpath("//*[@id=\"memoForm\"]/div/table/tbody/tr[1]/td[1]/div/textarea"));
			memo.sendKeys("안녕하세요");
			//등록하기 버튼
			WebElement click = driver.findElement(By.xpath("//*[@id=\"memoForm\"]/div/table/tbody/tr[1]/td[2]/a[1]/span[2]"));
			click.click();
			}
		}catch(Exception e) {
			System.out.println("다음 카페 글 쓰기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		
			
		}
	}

}
