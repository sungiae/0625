import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 맛집 출력 => 망고플레이트
/*
 * 객체 지향 프로그램
 * 70년도 (sw)			70년도(hw)
 *   c언어 (벨연구소)		  => 집적회로 (조립 한개의 기계 : 재사용)
 *   
 * 80년도
 * 		| 스트덥 (집적회로: 보관 => 재사용)
 */
class Category{
	int no; // 카테코리 번호
	String title; // 제목
	String subject; // 부제목
	// 서로 다른 데이터형 모아서 관리 (사용자 정의 데이터형) ==> '관련'이 있는 것들을 모아야한다
	/*
	 * 1. 기본 데이터형
	 * 2. 자바에서 제공하지 않는 데이터 제작 (class)
	 * 3. 메소드 추가 ==> 한개 부품을 제작
	 * 				   =============
	 * 				   객체 지향 3대 요소
	 * 				   1) 재사용
	 * 					 = 필요시 수정해서 사용 (상속:is-a)
	 * 					 = 있는 그대로 (포함:has-a)
	 * 				   2) 데이터의 중요성 => 데이터 보호 (캡슐화)
	 * 				   3) 수정, 추가가 가능하게 만들어 진다 (다형성)
	 * 				   4) 이미 완성된 제품을 사용 => 신뢰성이 높다
	 * 				   =================================== 유지보수
	 * 				   클래스의 종류, 클래스 접근 범위... (공개, 해당 클래스에서 사용, 같은 폴더에서 접근
	 * 												상속시 접근)
	 * 				   => 추상클래스
	 * 				   => 인터페이스
	 * 				   => 내부클래스 (익명의 클래스, 멤버클래스, 지역클래스)
	 * 				   => 종단클래스
	 * 	    		   ==========================================
	 * 				   클래스 여러개를 만들어서 관리 ==> 관련된 클래스 분류 ==> 패키지
	 * 				   ==================================================
	 * 				   사용자가 오류 : 프로그램이 유지 => 오류방지 (예외처리) => 6,7,8장
	 */
}
class FoodHouse{
	
}
public class 자바메소드4 {
	// 클래스 제작 => 기본데이터형과 동일 (형변환, 배열)
	/*
	 * <div class="info_inner_wrap">
                      <span class="title">비빔밥 맛집 베스트 25곳</span>
                      <p class="desc">"밥은 비벼야 제맛이지!"</p>
	 */
	static Category[] getCategory() throws Exception{
		Category[] cate=new Category[9];
		Document doc=Jsoup.connect("https://www.mangoplate.com/").get();// 파싱 - HTML에서 필요한 데이터를 읽어오는 것
//		Elements title=doc.select("span title");
//		Elements subject=doc.select("p.desc");
		return cate;
//		System.out.println(title);
//		System.out.println(subject);
	}
	public static void main(String[] args) throws Exception {
		getCategory();
	}

}
