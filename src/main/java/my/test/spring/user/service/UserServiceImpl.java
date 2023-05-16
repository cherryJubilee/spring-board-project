package my.test.spring.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import my.test.spring.user.dao.UserDAO;
import my.test.spring.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	private UserDAO userDAO;
	
	// TransactionManager을 이용해서 Transaction을 처리할 것이다. (주입 받아서)
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	
	//회원가입
	public boolean registerUser(UserVO userVO) {
		
		// transaction 처리 - insert(select 계열이 아니니까)이니까
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		
		boolean result = false;
		
		try {
			userDAO.insertUser(userVO);

			// 위 두개가 정상적으로 처리가 되었으니까 commit처리 하기!
			result = true;
			transactionManager.commit(txStatus);
			
		} catch (Exception e) {
			result = false;
			transactionManager.rollback(txStatus);
		}
	
		
		return result;
	}
	
	
	// 로그인
	public boolean loginUser(UserVO userVO) {
		
		UserVO result = userDAO.selectUser(userVO);


		if (result != null) {
			// 사용자가 입력한 로그인 정보가 db에 존재 함
			return true;
		} else {
			// 사용자가 입력한 로그인 정보가 db에 존재하지 않음
			return false;
		}
	
	}
	
	
	// 회원정보 수정
	public boolean updateUser(UserVO userVO) {
		
		log.debug("service {}", userVO);
		
		TransactionStatus txStatus =
				transactionManager.getTransaction(
						new DefaultTransactionDefinition());
		
		boolean result = false;
		
		try {
			userDAO.updateUser(userVO);
			// 성공시 commit
			result = true;
			transactionManager.commit(txStatus);
			
		} catch (Exception e) {
			result = false;
			transactionManager.rollback(txStatus);
		}
		
		return result;
	}

}

