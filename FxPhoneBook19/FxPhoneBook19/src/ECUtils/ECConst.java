package ECUtils;
public class ECConst {
	public static String DB_NAME ="phonedb";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{
		"create table phone_book (id INT NOT NULL AUTO_INCREMENT, user_name varchar(45), phone_no varchar(20), PRIMARY KEY (id))",	
		"insert into phone_book (user_name, phone_no) values ('admin', '9898989898')",	
	};
}
