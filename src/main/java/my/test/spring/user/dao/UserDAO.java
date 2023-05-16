package my.test.spring.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.test.spring.user.vo.UserVO;

@Repository
public class UserDAO {
	
	Logger log = LogManager.getLogger("case3");
	
	// 의존성 주입
	@Autowired
    private SqlSession sqlSession;  
	
	// 회원가입 
	public void insertUser(UserVO userVO) throws Exception {
		sqlSession.insert("myUser.insertUser", userVO);
	}
	
	// 로그인
    public UserVO selectUser(UserVO userVO) {
        return sqlSession.selectOne("myUser.selectUser", userVO);
    }
    
    // 회원정보 수정
    public void updateUser(UserVO userVO) throws Exception {
    	
    	log.debug("dao {}", userVO);
    	int success = sqlSession.update("myUser.updateUser", userVO);
    	log.debug("dao 성공 여부 {}", success);
    }
    

}
