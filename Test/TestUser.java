import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * �����û�������һ��������
 * @author dell
 *
 */
class TestUser {

	@Test
	void test() {
		
		try {
			//1�����mybatis���������ļ�������������
			InputStream is=Resources.getResourceAsStream("mybatis.xml");
			//2��ͨ��������������SqlSessionFactory����
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
			//3��ͨ��SqlSessionFactory����������Sqlsession����
			SqlSession sqlsession=fac.openSession();
			//4������SqlSession����ķ�����ִ�в���
			int count=sqlsession.selectOne("dao.UserMapper.getCount");
			System.out.println("��õ���������"+count);
			//5���ر�sqlsession����
			sqlsession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
