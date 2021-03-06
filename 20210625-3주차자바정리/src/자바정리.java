import java.io.FileReader;

/*
 * 1. 자바 실행
 *    원시소스
 *    ======  javac     .class      java (실행)  => 인터프리터
 *    (프로그래머 코딩)
 *    .java => 컴퓨터가 알 수 있는 언어가 아니라 프로그래머만 알 수 있는 언어
 *    => 배포 (일반 사용자) : .java(x) / .class(o)
 *    => 컴파일 : C, C#, C++, 파이썬, 자바(jdk)
 *    => 인터프리터 : 자바 (한줄씩 번역) => HTML
 *    ********* 컴파일 VS 인터프리터 (면접 : 30%)
 *    => 호환성 (모든 운영체제 적용), 특화된 언어 (웹, 모바일 => 코틀린 (JVM))
 *    							기계(하드웨어 : C/C++)
 *    							AI (데이터 수집, 분석, 통계) => 파이썬
 *    
 *    문법
 *     1) 자바언어 => 무조건 클래스안에서 작업
 *        형식
 *        		package 자바파일이 있는 위치 => 폴더(.)
 *        		java.util.Scanner => java폴더 (util폴더 => Scanner)
 *        		****** 한번만 사용이 가능
 *        		다른 클래스를 읽어 온다
 *       		import 패키지명.클래스명, 패키지명.* => 여러개 사용이 가능
 *       		public class ClassName
 *       		{
 *       			========  변수영역  ========
 *       				*** 클래스 전체에서 사용이 가능 (전역변수) => 다른 클래스에서도 사용이 가능
 *       					=> 다른 클래스에서 접근이 가능 => but. 허용을 해야 접근이 가능
 *       					=> 데이터 보호 (캡슐화) => 시큐어 코딩 (파밍)
 *       				멤버변수 (프로그램에 사용하는 데이터를 저장하는 공간
 *       				======
 *       			 	  = 클래스 개체마다 개별적으로 사용 (인스턴스 변수)
 *       				  = 클래스 전체 사용변수 (공유 변수) : static
 *      	
 *       			========  메소드영역 ========
 *       				*** 사용자 요청에 대한 처리 (사용자가 동작 예시 : 메뉴클릭, 버튼 클릭, 선택...)
 *       					 => 키보드, 마우스 사용 
 *       				*** 영화 목록, 영화 찾기, 영화 추천, 영화 예매, 결재 (클래스와 연결되어있다)
 *       				*** 지역변수 (메소드 안에서만 사용하는 변수) (ex. for(int i=0) -> for문에서만 사용
 *       			========  생성자영역 ========
 *       				*** 멤버변수 초기화
 *       				class Temp
 *       				{
 *       					int a=10; // 10 >> 명시적 초기화 (눈에 보이게)
 *       					int b; // 0
 *       					String id; => id를 파일에서 읽기, cookie에서 읽기
 *       								  ============================= 구현
 *       								  클래스 영역 => 구현(X) / 무조건 선언만 가능
 *       				    생성자()를 이용해서 구현 후 초기화
 *       				} *** 만약에 없는 경우에는 컴파일러가 자동으로 생성
 *       			=================
 *       		}
 *    			==========> 재사용 (IS-A(상속),  HAS-A(포함)***)
 *    							  ==========
 *    							  수정해서 사용 (오버라이딩) => 여러개 형태로 기능 => 다형성
 *    							  새로운 기능 추가 (오버로딩) => 여러개 형태로 기능 => 다형성
 *    			==========> 데이터 보호, 재사용, 수정+추가(다형성) ==> 230 page
 *    						==============================> 객체지향 프로그램의 3대 요소(유지보수 용이)
 *    
 * 2. 자바 => 기본 데이터형
 * 			 ========== 1byte, 2byte, 4byte, 8byte ==> 필요한 데이터를 한번에 묶어서 저장
 *    사원 정보
 *    이름, 사번, 부서, 직위, 입사일, 급여, 성과급
 *    >> 3명
 *    >> 메모리 하나에 1.이름-1.사번-1.부서-2.이름-2.사번-2.부서 처럼 3명을 한꺼번에 저장하면 안좋음
 *    >> <이름-사번-부서>처럼 변수들을 모아서 한꺼번에 처리 -> 클래스
 *    
 * 3. 연산자
 *      증감연산자 (++,--) : 한개 증가, 한개 감소 => 반복문에서 주로 사용
 *      부정연산자 : true/false사용이 가능 => 조건문에서 주로 사용
 *      형변환 연산자 : (데이터형) => 작은 데이터형 (강제 형변환)
 *      					      큰 데이터형 (자동 형변환) => 연산자 
 *      ========== 클래스 형변환 (상속 , 포함)
 *      => 크기
 *         byte < short, char < int < long <float < double
 *         ==================
 *         연산처리가 되면 => int 결과값
 *      산술연산자 : +,-,*,/,% (나누기 : 0으로 나눌 수 없다 / % :남는 값이 왼쪽부호
 *      비교연산자 : 조건, 반복문의 조건 =>  true/false
 *                ==, !=, <, >, <=, >= (숫자만 비교 가능)
 *                문자열은 비교 할 수 없다 (euals(boolean),compare(int))
 *      논리연산자 : 조건 (범위,기간 => &&(포함), ||(불포함))
 *      대입연산자 : =, +=(누적, 증가를 한개 이상)
 *      // 최적화 부분 참고하기
 *      
 * 4. 제어문
 * 		== 조건문
 * 		== 
 * 	  - for-each = 출력 전용
 * 	  - int[] >> for(int i )
 * 5. 배열
 * 	  - 보통 3개 이상
 *    - 관련된 데이터를 낱개가 아닌 모아서 처리
 * 6. 메소드
 * 
 * 
 * 1page에 대한 영화 목록을 보내달라
 * =====      ========
 * 매개변수     결과값(리턴형) ======> 한글로 표현 => 배열
 * 
 * 영화제목을 보내고 상세보기 요청
 * ======        ======
 * 매개변수        결과값(리턴)  =>클래스
 * 
 * = 처리방법
 *	  메소드 자체에서 처리 =========> void (데이터베이스 => 추가, 수정, 삭제)
 *    결과값을 주고 다른 클래스에서 처리 => 리턴형 (데이터베이스 목록 읽기, 상세보기...)
 * 
 * ====================================================
 * 7. 클래스    **현재위치
 * 8. 예외처리
 * 9. 라이브러리
 *    = 문자열 관련 (String, StringBuffer, StringBuilder)
 *    = 컬렉션 (ArrayList, Vector, Map)
 *    = object, IO, Date, Calendar, Wrapper
 * ====================================================
 * 10. 오라클 연결
 * 11. 웹연결 => 웹사이트
 */
import java.io.*;
public class 자바정리 {

	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("C:\\javaDev\\news.txt");
		int i=0;
		String data="";
//		String Buffer sb=new StringBuffer();
		while((i=fr.read())!=-1) //-1 종료 (파일 끝 => EOF)
		{
			data+=String.valueOf((char)i);
//			sb.append(String.valueOf((char)i)); // 최적화 -> 읽는 속도가 빠름
		}
		fr.close();
		System.out.println(data);
//		System.out.println(sb.toString);
	}

}
