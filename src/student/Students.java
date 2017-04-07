package student;
//学生类
public class Students {
	//1.公有的类
	//2.提供公有的不带参数的默认的构造方法
	//3.属性私有
	//4.属性setter/getter封装

	private Integer sid;
	private Integer ver;
	private String sname;
	private String gender;
	private String address;
	
	public Students(){
		
	}

	public Students(Integer sid, String sname, String gender, String address) {
		//super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
//		this.birthday = birthday;
		this.address = address;
	}



	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

//	public Date getBirthday() {
//		return birthday;
//	}
//
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getVer() {
		return ver;
	}

	public void setVer(Integer ver) {
		this.ver = ver;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", address=" + address + "]";
	}
}
