import com.dao.IUserDao;
import com.dao.impl.UserDao;

public class UserDaoTest {
public static void main(String[] args) {
	IUserDao userDao = new UserDao();
	System.out.println(userDao.getCustomerByName("MARY").getCustomer_id());
}
}
