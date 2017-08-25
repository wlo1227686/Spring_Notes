package jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private EmployeeDAO employeeDAO;
	private DepartmentDAO departmentDAO;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeeDAO = ctx.getBean(EmployeeDAO.class);
		departmentDAO = ctx.getBean(DepartmentDAO.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}

	// 使用具名參數時,可以使用update(String sql, SqlParameterSource paramSource)方法進行更新操作
	// 1.使用SQL語句的參數名和類別的屬性一致
	// 2.使用SqlParameterSource的BeanPropertySqlParameterSource方法來帶入一個bean參數
	// VALUES(:lastName,:email,:Dept_ID) 的名稱必須對應Employee Bean所宣告的參數
	@Test
	public void testNamedParameterJdbcTemplate_Use_javabean() {
		String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:lastName,:email,:Dept_ID)";
		Employee employee = new Employee();
		employee.setLastName("XYZ");
		employee.setEmail("xyz@8787.com");
		employee.setDept_ID(3);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);

	}

	// 可以為參數取一個名字,(適用於參數多者,但是編寫起來很麻煩)
	// 1.好處: 有多個參數，則不用在去對應位置順序，直接對應參數名，便於維護
	// 2.缺點: 較為麻煩。
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "INSERT INTO employees(last_name,email,dept_id)VALUES(:ln,:eml,:dep)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ln", "FF");
		paramMap.put("eml", "FF@87.com");
		paramMap.put("dep", "2");
		namedParameterJdbcTemplate.update(sql, paramMap);
	}

	@Test
	public void testDepartmentDAO() {
		System.out.println(departmentDAO.get(1));
	}

	@Test
	public void testEmployeeDAO() {
		System.out.println(employeeDAO.get(1));
	}

	// 獲取單個列的值,或做統計查詢
	// 使用 queryForObject(String sql, Class<Long> requiredType)方法

	@Test
	public void testQueryForObject_count() {
		String sql = "SELECT count(id) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}

	// 查到實體類的集合
	// 使用的並不是queryForList方法
	@Test
	public void testQueryForList() {
		String sql = "SELECT id,last_name,email FROM employees WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 5);
		System.out.println(employees);
	}

	// 從資料庫中取得一條記錄,實際得到對應的一個對象
	// 注意!不是使用queryForObject(String sql, Class<T> requiredType, Object args)方法
	// 而是使用 queryForObject(String sql, RowMapper<T> rowMapper, Object args)方法
	// 1.其中的RowMapper<T>指定如何去接收查詢結果,最常使用的建構子為BeanPropertyRowMapper
	// 2.SQL的語法必須使用資料表的欄位名稱,例如:last_name lastName
	// 3.不支持集聯屬性,JdbcTemplate只是個JDBC的小工具,而不是個ORM的框架
	@Test
	public void testQueryForObject() {
		String sql = "SELECT id,last_name lastName,email,dept_id FROM employees WHERE id=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}

	// 執行批量更新:批量的INSERT,UPDATE,DELETE
	// batchArgs:的參數為Object的List類型
	@Test
	public void testBatchUpdate() {
		String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] { "AA", "AA@87.com", 1 });
		batchArgs.add(new Object[] { "BB", "BB@87.com", 3 });
		batchArgs.add(new Object[] { "CC", "CC@87.com", 2 });
		batchArgs.add(new Object[] { "DD", "DD@87.com", 2 });
		batchArgs.add(new Object[] { "EE", "EE@87.com", 1 });

		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	// 執行INSERT,UPDATE,DELETE
	// Spring Spring-tx-x.x.x.jar :只要有做db交易則需要該檔案
	@Test
	public void testUpdate() {
		String sql = "UPDATE employees SET last_name=? WHERE id=?";
		jdbcTemplate.update(sql, "jack", 5);
	}

	// 檢查是否連上資料庫取的連線
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
