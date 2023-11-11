package view;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生实体类
 * @author shuijianshiqing
 *
 */

public class Student {

	// 学号
	private String sId;
	// 姓名
	private String sName;
	// 性别
	private String sSex;
	// 学院
	private String sCollege;
	// 专业
	private String sMajor;
	// 出生日期
	private String sBirthday;
	// 省份
	private String sProvince;
	// 电话
	private String sPhone;
	// 邮箱
	private String sEmail;



	public Student() {
		super();
	}

	public Student(String sId, String sName, String sSex, String sCollege, String sMajor, String sBirthday,
				   String sProvince, String sPhone, String sEmail) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sSex = sSex;
		this.sCollege = sCollege;
		this.sMajor = sMajor;
		this.sBirthday = sBirthday;
		this.sProvince = sProvince;
		this.sPhone = sPhone;
		this.sEmail = sEmail;
	}

	public static List<Student> students=new ArrayList<Student>();

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public String getsCollege() {
		return sCollege;
	}

	public void setsCollege(String sCollege) {
		this.sCollege = sCollege;
	}

	public String getsMajor() {
		return sMajor;
	}

	public void setsMajor(String sMajor) {
		this.sMajor = sMajor;
	}

	public String getsBirthday() {
		return sBirthday;
	}

	public void setsBirthday(String sBirthday) {
		this.sBirthday = sBirthday;
	}

	public String getsProvince() {
		return sProvince;
	}

	public void setsProvince(String sProvince) {
		this.sProvince = sProvince;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sSex=" + sSex + ", sCollege=" + sCollege + ", sMajor="
				+ sMajor + ", sBirthday=" + sBirthday + ", sProvince=" + sProvince + ", sPhone=" + sPhone + ", sEmail="
				+ sEmail + "]";
	}



}

