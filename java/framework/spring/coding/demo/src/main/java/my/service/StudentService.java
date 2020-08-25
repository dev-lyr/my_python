package my.service;

import my.domain.StudentDO;
import org.springframework.stereotype.Service;

/**
 * Created by yueran.lyr on 2016/11/23.
 */
public interface StudentService {
	public int insert(StudentDO studentDO);
	public void testTransaction();
}
