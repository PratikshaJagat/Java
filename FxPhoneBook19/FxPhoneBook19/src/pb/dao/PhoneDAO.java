package pb.dao;

import ECUtils.BaseDAO;
import java.sql.*;
import java.util.LinkedList;

import pb.bean.Phone;

public class PhoneDAO extends BaseDAO{
	public static LinkedList<Phone> search(String sc, String si){
		LinkedList<Phone> res = new LinkedList<>();
		Connection con = null;
		try {
			con = getCon();
			String sql = "select * from phone_book where " +sc+ " like ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, "%" + si + "%");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Phone p1 = new Phone();
				p1.setId(rs.getString("id"));
				p1.setUserName(rs.getString("user_name"));
				p1.setPhoneNo(rs.getString("phone_no"));
				res.add(p1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeCon(con);
		}
		return res;
	}
        
        public static Phone searchById(String id){
		Phone res = null;
		Connection con = null;
		try {
			con = getCon();
			String sql = "select * from phone_book where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Phone p1 = new Phone();
				p1.setId(rs.getString("id"));
				p1.setUserName(rs.getString("user_name"));
				p1.setPhoneNo(rs.getString("phone_no"));
				res = p1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeCon(con);
		}
		return res;
	}
        
        public static Phone searchByPhoneNo(String pn){
		Phone res = null;
		Connection con = null;
		try {
			con = getCon();
			String sql = "select * from phone_book where phone_no = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, pn);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Phone p1 = new Phone();
				p1.setId(rs.getString("id"));
				p1.setUserName(rs.getString("user_name"));
				p1.setPhoneNo(rs.getString("phone_no"));
				res = p1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeCon(con);
		}
		return res;
	}


	
	public static void insert(Phone p1){
		Connection con = null;
		try {
			con = getCon();
			String sql = "insert into phone_book(user_name, phone_no) values (?, ?) ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getUserName());
			st.setString(i++, p1.getPhoneNo());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeCon(con);
		}
	}
	
	
	public static void update(Phone p1){
		Connection con = null;
		try {
			con = getCon();
			String sql = "update phone_book set user_name = ?, phone_no =?  where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, p1.getUserName());
			st.setString(i++, p1.getPhoneNo());
			st.setString(i++, p1.getId());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeCon(con);
		}
	}

	public static void delete(String id){
		Connection con = null;
		try {
			con = getCon();
			String sql = "delete from phone_book where id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			int i = 1;
			st.setString(i++, id);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeCon(con);
		}
	}


}
