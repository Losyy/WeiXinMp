package cn.com.losy.didi.pojo;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "dd_order")
public class Order {
	@DatabaseField(id = true)
	private String uuid;
	@DatabaseField(canBeNull = false)
	private String passengerId;
	@DatabaseField(canBeNull = false)
	private String type;
	@DatabaseField(canBeNull = false)
	private String from;
	@DatabaseField(canBeNull = false)
	private double fromLongitude;
	@DatabaseField(canBeNull = false)
	private double fromLatitude;
	@DatabaseField(canBeNull = false)
	private String to;
	@DatabaseField(canBeNull = false)
	private int additionFee;
	@DatabaseField(canBeNull = false)
	private Timestamp createTime;
	
	@DatabaseField(canBeNull = true)
	private String driverId;
	@DatabaseField(canBeNull = true)
	private int cost;
	@DatabaseField(canBeNull = true)
	private Timestamp toGoTime;
	@DatabaseField(canBeNull = true)
	private Timestamp confirmTime;
	@DatabaseField(canBeNull = true)
	private Timestamp startTime;
	@DatabaseField(canBeNull = true)
	private Timestamp endTime;
	
	@Override
	public String toString() {
		return "Order [uuid=" + uuid + ", passengerId=" + passengerId
				+ ", type=" + type + ", from=" + from + ", fromLongitude="
				+ fromLongitude + ", fromLatitude=" + fromLatitude + ", to="
				+ to + ", additionFee=" + additionFee + ", createTime="
				+ createTime + ", driverId=" + driverId + ", cost=" + cost
				+ ", toGoTime=" + toGoTime + ", confirmTime=" + confirmTime
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	public Order() {
		super();
	}
	public Order(String uuid, String passengerId, String type, String from,
			double fromLongitude, double fromLatitude, String to,
			int additionFee, Timestamp createTime, String driverId, int cost,
			Timestamp toGoTime, Timestamp confirmTime, Timestamp startTime,
			Timestamp endTime) {
		super();
		this.uuid = uuid;
		this.passengerId = passengerId;
		this.type = type;
		this.from = from;
		this.fromLongitude = fromLongitude;
		this.fromLatitude = fromLatitude;
		this.to = to;
		this.additionFee = additionFee;
		this.createTime = createTime;
		this.driverId = driverId;
		this.cost = cost;
		this.toGoTime = toGoTime;
		this.confirmTime = confirmTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public double getFromLongitude() {
		return fromLongitude;
	}
	public void setFromLongitude(double fromLongitude) {
		this.fromLongitude = fromLongitude;
	}
	public double getFromLatitude() {
		return fromLatitude;
	}
	public void setFromLatitude(double fromLatitude) {
		this.fromLatitude = fromLatitude;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getAdditionFee() {
		return additionFee;
	}
	public void setAdditionFee(int additionFee) {
		this.additionFee = additionFee;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Timestamp getToGoTime() {
		return toGoTime;
	}
	public void setToGoTime(Timestamp toGoTime) {
		this.toGoTime = toGoTime;
	}
	public Timestamp getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
}
