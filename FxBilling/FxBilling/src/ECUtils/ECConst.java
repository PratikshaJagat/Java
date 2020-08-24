package ECUtils;
public class ECConst {
	public static String DB_NAME ="fx_billing";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{
		"create table app_users (id INT NOT NULL AUTO_INCREMENT, user_name varchar(45), phone_no varchar(20), email varchar(100), pass varchar(100),  PRIMARY KEY (id))",	
		"create table products (id INT NOT NULL AUTO_INCREMENT, name varchar(45), description  text,  category varchar(20), price double, cgst double, sgst double,  PRIMARY KEY (id))",	
		"create table sale (id INT NOT NULL AUTO_INCREMENT, pid int, quantity double,  total double, bid int, sale_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,  PRIMARY KEY (id))",	
		"insert into app_users (user_name, phone_no, email, pass) values ('admin', '9898989898', 'admin@gmail.com', 'admin')",	
	};
}
