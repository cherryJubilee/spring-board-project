package my.test.spring.user.service;

import my.test.spring.user.vo.UserVO;

public interface UserService {
	
	boolean registerUser(UserVO userVO);   //회원가입
	boolean loginUser(UserVO userVO);      // 로그인
	boolean updateUser(UserVO uservo);     //회원정보 수정
}
