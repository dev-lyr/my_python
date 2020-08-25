package my.service.impl;

import my.dao.StudentDAO;
import my.domain.StudentDO;
import my.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by yueran.lyr on 2016/11/23.
 */
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private DataSourceTransactionManager txManager;
	public int insert(StudentDO studentDO) {
		return studentDAO.insert(studentDO);
	}

	@Transactional
	public void testTransaction() {
//		TransactionDefinition td = new DefaultTransactionDefinition();
//		TransactionStatus status = txManager.getTransaction(td);
		StudentDO studentDO1 = new StudentDO();
		studentDO1.setName("lyr-1");
		studentDO1.setAge(22);
		studentDO1.setTeacherName("qi");
		insert(studentDO1);
		throw new RuntimeException("test transaction");
//		txManager.rollback(status);
	}

}
