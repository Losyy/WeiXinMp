package cn.com.losy.didi.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author huangximin
 *
 * @param <POJO>  数据库表对应的类的pojo类型
 * @param <ID> 表主键对应的字段的类型
 */
public interface BaseDao <POJO, ID> {
	public int insert(POJO pojo) throws SQLException;
	public int deleteById(ID id) throws SQLException;
	public POJO queryById(ID id) throws SQLException;
	public List<POJO> queryAll() throws SQLException;
	public int update(POJO pojo) throws SQLException;
	
	public int updateRaw(String sql) throws SQLException;
}
