package spring.mybatis0119_1;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;


	@Override
	public List<MemberDTO> memberlist() {
		// dao 메소드 1개 - sql 1개 실행 단위
		// 서비스 기능 메소드 1개 - 여러개 실행 단위
		
		return dao.memberlist();
		
	}
	@Override
	public int membercount() {
		return dao.membercount();
	}
	
	@Override
	public MemberDTO onemember(String id) {
		return dao.onemember(id);
	}

	

	@Override
	public List<MemberDTO> paginglist(int[] limit) {
		return dao.paginglist(limit);
		
	}

	@Override
	public int insertmember(MemberDTO dto) {
		MemberDTO resultdto = dao.onemember(dto.getId());
		if(resultdto == null) {
			return dao.insertmember(dto);
		}
		return 0;
	}
	
	@Override
	public int updatemember(MemberDTO dto) {
		return dao.updatemember(dto);
	}

	@Override
	public int deletemember(String id) {
		return dao.deletemember(id);
	}

	@Override
	public List<MemberDTO> searchmember(HashMap map) {
		return dao.searchmember(map);
	}

	@Override
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist) {
		return dao.addresssearch(addresslist);
	}

	@Override
	public List<MemberDTO> combination(MemberDTO dto) {
		return dao.combination(dto);
	}

	@Override
	public List<HashMap<String, String>> memberboard(String writer) {
		return dao.memberboard(writer);
	}
	
	@Override
	public int updatemember2(MemberDTO dto) {
		return dao.updatemember2(dto);
	}


	
	
}
