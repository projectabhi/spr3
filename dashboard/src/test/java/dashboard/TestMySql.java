package dashboard;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestMySql {

	public static void main(String[] args) throws Exception{
		System.out.println("Checking MariaDB ...");
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("file:/home/borokali/git/spr3/dashboard/src/test/java/dashboard/mysql_db.xml");
		JdbcTemplate jt=(JdbcTemplate)ctx.getBean("jdbcTemplate");
		long start=System.currentTimeMillis();
		for(int i=0;i<100;i++)
			System.out.println(jt.queryForInt("select 13 from dual"));
		System.out.println("Time for 100 selects ms:"+(System.currentTimeMillis()-start));
		
		System.out.println("=====================");
		
		String username="borokali";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date mydate=sdf.parse("06/02/2018");
		Date today=new Date(mydate.getTime());
		StringBuilder str=new StringBuilder();
		str.append("INSERT INTO dashboard_login (user_name,login_date,logout_date) VALUES (");
		str.append("?,?,?)");
		long start2=System.currentTimeMillis();
		for(int i=0;i<100;i++)
			jt.update(str.toString(),new Object[]{username,today,today});
		System.out.println("Time for 100 inserts ms:"+(System.currentTimeMillis()-start2));
		
		System.out.println("=====================");
		long start3=System.currentTimeMillis();
		jt.update("DELETE FROM dashboard_login");
		System.out.println("Time for 100 deletes ms:"+(System.currentTimeMillis()-start3));
		
	}

}
