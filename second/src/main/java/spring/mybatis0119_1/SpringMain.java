//package spring.mybatis0119_1;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class SpringMain {
//
//	public static void main(String[] args) throws IOException {
//		
//		ApplicationContext factory =
//				new ClassPathXmlApplicationContext("spring/mybatis0117_1/spring-mybatis.xml");
//		
//		
////		String names[] = factory.getBeanDefinitionNames();
////		System.out.println("====================================");
////		for(String n : names) {
////			System.out.println(n);
////		}
////		System.out.println("====================================");
//		
//		
//
//		
////		"service" bean인것을 읽어와
//		MemberService service = (MemberService)factory.getBean("service");
//
//		
//		//////////////////////////////////////////////////////////////
//		// test1 - 리스트 조회
//		List<MemberDTO> test1list = service.memberlist();
//		for(MemberDTO m : test1list){
//			System.out.println(m.getId() + ":" + m.getPw() + ":" + m.getName());
//		}
//		System.out.println();
//		
////		//////////////////////////////////////////////////////////////
////		// test2 - 회원수 카운트
////		System.out.println("전체 회원수 = " + service.membercount());
////		System.out.println();
//		
////		/////////////////////////////////////////////////////////////
////		// test3 - 한 사람만 조회
////		MemberDTO m = service.onemember("id");
////		if(m != null) {
////			System.out.println(m.getId() + ":" + m.getPw() + ":" + m.getName());
////		}
////		System.out.println();
//		
////		/////////////////////////////////////////////////////////////
////		// test4 - 페이징처리 리스트 조회
////		int limit1[] = {0, 3};
////		List<MemberDTO> test4list = service.paginglist(limit1);
////		for(MemberDTO me : test4list) {
////			System.out.println(me.getId()+":"+me.getPw()+":"+me.getName());
////		}
//		
////		/////////////////////////////////////////////////////////////
////		// test5 insert
////		MemberDTO insertdto = new MemberDTO();
////		insertdto.setId("mybatis");
////		insertdto.setPw("mybatis");
////		insertdto.setName("박대한");
////		insertdto.setPhone("010234234");
////		insertdto.setEmail("a@b.com");
////		insertdto.setAddress("용산시 용산구");
////		service.insertmember(insertdto);
//		
////		/////////////////////////////////////////////////////////////////
////		// test6 update
////		// id=mybatis, name="박한국", phone=01087654321 이메일=mybatis@b.com 수정
////		MemberDTO updatedto = new MemberDTO();
////		updatedto.setId("mybatis");
////		//updatedto.setPw("mybatis");
////		updatedto.setName("박한국");
////		updatedto.setPhone("01087654321");
////		updatedto.setEmail("mybatis@b.com");
////		//updatedto.setAddress("용산시 용산구");
////		service.updatemember(updatedto);
//		
////		//확인
////		int[] limit2 = {0, 3};
////		List<MemberDTO> test6list = service.paginglist(limit2);
////		for(MemberDTO me : test6list) {
////			System.out.println(me.getId()+":"+me.getPw()+":"+me.getName()+":"+me.getEmail()+":"+me.getPhone());
////		}
//		
//		
////		/////////////////////////////////////////////////////////////////
////		// test7 delete 알아서 해보기
////		int row = service.deletemember("mybatis");
//		
//		
////		/////////////////////////////////////////////////////////////////
////		// test8 - map
////		HashMap<String, String> map = new HashMap();
////		map.put("colname", "name");
////		map.put("colvalue", "%길동%");
////		// select * from member where ${colname} like #{colvalue}
////		List<MemberDTO> searchlist = service.searchmember(map);
////		for(MemberDTO me : searchlist) {
////			System.out.println(me.getId() + ":" + me.getPw() + ":" +me.getName() + ":" + me.getEmail() + ":" + me.getPhone() + ":" + me.getIndate());
////		}
//		
////		/////////////////////////////////////////////////////////////////
////		// test9
////		ArrayList<String> addresslist = new ArrayList();
////		addresslist.add("서울시 용산구");
////		addresslist.add("제주시 용산구");
////		addresslist.add("서울시 중구");
////		
////		List<MemberDTO> resultlist = service.addresssearch(addresslist);
////		
////		for(MemberDTO me : resultlist) {
////			System.out.println(me.getId() + ":" + me.getPw() + ":" +me.getName() + ":" + me.getEmail() + ":" + me.getPhone() + ":" + me.getAddress());
////			
////		}
//		
//		
////		///////////////////////////////////////////////////////////////////
////		//test10 - 조합 - 동적조건절
////		MemberDTO dto = new MemberDTO();
////		dto.setName("박한국");
////		//dto.setEmail("mybatis@b.com");
////		List<MemberDTO> test10resultlist=service.combination(dto);
////		for(MemberDTO me : test10resultlist) {
////			System.out.println
////			(me.getId()+":"+me.getPw()+":"+me.getName()+":"+me.getEmail()
////			+":"+me.getPhone()+":"+me.getAddress());
////		}
//		
//		
////		///////////////////////////////////////////////////////////////////
////		//test11 - join시 resultMap
////		List<HashMap<String, String>> boardlist = service.memberboard("maria");
////		for(HashMap map : boardlist) {
////			Set<String> keys = map.keySet();
////			for(String s:keys) {
////				System.out.println(s + " : " + map.get(s));
////			}
////		}
//		
//		
//		//////////////////////////////////////////////////////////////////
//		/*1. id 회원이 작성 글이 있는지 검사
//		 * 2. 글이 있으면 사용자 탈퇴전에 글도 삭제하시겠습니까? y/n
//		 * 3-1. 사용자 탈퇴처리
//		 * 3-2. 사용자 탈퇴취소
//		 * */
//		// 과제
////		Scanner sc = new Scanner(System.in);
////		int checkDel = 0;
////		
//////		String targetId = "test";
////		String targetId = sc.next();
////		sc.nextLine();
////		//targetId 있는지 확인
////		MemberDTO problemM = service.onemember(targetId);
////		if(problemM != null) {
////			//problemM 이 쓴글이 있는지 확인
////			List<HashMap<String, String>> targetBoard = service.memberboard(problemM.getId());
////			
////			if(targetBoard != null) { //쓴 글이 있으면
////				System.out.println("글이 있으면 사용자 탈퇴전에 글도 삭제하시겠습니까? y/n");
////				String a = sc.next();
////				if(a.equals("y")) {
////					checkDel = service.deletemember(problemM.getId());
////				}
////				else {
////					System.out.println("사용자 탈퇴 취소");
////				}
////			}
////			else {
////				//삭제
////				checkDel = service.deletemember(problemM.getId());
////			}
////		}
////		else {
////			System.out.println(targetId + "라는 id가 존재하지 않습니다.");
////		}
////			
////		if(checkDel != 0) {
////			System.out.println(targetId + " 삭제");
////		}
//		
//		
//		
//		//옛날것
////		// 4. sql-mapping.xml id=memberlist resultType="mybatis.MemberDTO" 정의 sql 호출
////		List<MemberDTO> memberlist = session.selectList("member.memberlist");
////		
////		// 5. 조회
////		for(MemberDTO m : memberlist) {
////			System.out.println(m.getId() + ":" + m.getPw() + ":" + m.getName());
////		}
//
//	}
//
//}
