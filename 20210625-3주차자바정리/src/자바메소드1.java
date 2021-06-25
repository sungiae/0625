import java.util.Arrays;

// 1. 영화 데이터 출력 ==> 리턴형 x, 매개변수 x
/*
 * 		메소드를 사용 하는 이유
 * 		= 단락을 나눠서 가독성이 좋게 만든다   =========> 프로그램 구조화
 * 		  ========== 기능별 (입력기능, 처리기능, 출력기능)
 * 								   ======= 세부화
 * 		= 재사용성
 * 		= 반복을 제거하는 방법
 * 		= 다른 클래스에서 필요시마다 사용이 가능하게 만든다
 * 		  =====================================
 * 
 * 		메소드
 * 		====
 * 
 * 		프로그램 만든다
 * 
 * 			1. 요구사항 분석 ==> 2. 데이터베이스 설계  ==> 3. 화면 UI  ==> 4. 구현  ==> 5. 테스트 ==> 6. 배포
 * 			   ==========
 * 			   기능 (메소드)
 * 			   >> 아이템 발표     ==> 데이터 수집  ==>  템플릿 찾기 ===>  JSP 구현  ===> 	발표
 */
public class 자바메소드1 {
	// 중복없는 난수 => 재사용이 좋은 메소드
	static int[] rand(int num) {
		int[] com=new int [num]; // 중복난수 저장 ====> 예매
		int su=0; // 난수값 저장
		// 중복여부 확인
		boolean bCheck=false;
		// 지역변수 => 외부에서는 사용 할 수 없고 {}안에서 사용되는 변수
		for(int i=0; i<num; i++) {
			bCheck=true; // 난수 발생 준비
			while(bCheck) // 난수를 발생 => 중복체크 => 중복 (다시 while을 수행, false면 while 종료=> com 저장)
			{
				su=(int)(Math.random()*31)+1; // 1~31 => 예매가 가능한 날
				bCheck=false; // 중복이 없으면 while문을 벗어난다
				for(int j=0; j<i; j++) {
					if(com[j]==su) {
						bCheck=true; // while을 처음부터 수행 => 다시 발생 (중복된데이터가 존재)
						break;
					}
				}
			}
			com[i]=su; // 중복되지 않은 데이터 저장
		}
		return com;
	}
	public static void main(String[] args) {
		int[] reday = rand(7);
		System.out.println(Arrays.toString(reday));
	}

}
