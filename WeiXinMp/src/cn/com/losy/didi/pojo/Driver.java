package cn.com.losy.didi.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="dd_driver")
public class Driver {
	@DatabaseField(id = true)
	private String uuid;
	
	@DatabaseField(canBeNull=false)
	private String phone;
	@DatabaseField(canBeNull=false)
	private String driverLicense;
	@DatabaseField(canBeNull=false)
	private String carNumber;
	@DatabaseField(canBeNull=false)
	private String name;
	@DatabaseField(canBeNull=false)
	private String sex;
	@DatabaseField(canBeNull=false)
	private Date birthday;
	@DatabaseField(canBeNull=false)
	private String address;
	@DatabaseField(canBeNull=false)
	private String company;
	@DatabaseField(canBeNull=false)
	private Timestamp createTime;
	
	
	@Override
	public String toString() {
		return "Driver [uuid=" + uuid + ", phone=" + phone + ", driverLicense="
				+ driverLicense + ", carNumber=" + carNumber + ", name=" + name
				+ ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", company=" + company + ", createTime="
				+ createTime + "]";
	}

	public Driver() {
		super();
	}
	
	public Driver(String uuid, String phone, String driverLicense,
			String carNumber, String name, String sex, Date birthday,
			String address, String company, Timestamp createTime) {
		super();
		this.uuid = uuid;
		this.phone = phone;
		this.driverLicense = driverLicense;
		this.carNumber = carNumber;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.company = company;
		this.createTime = createTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
