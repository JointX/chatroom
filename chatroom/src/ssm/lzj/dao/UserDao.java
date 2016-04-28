package ssm.lzj.dao;

import java.util.List;
public interface UserDao
{
	public abstract boolean add(Object obj);
	public abstract boolean update(Object obj);
	public abstract boolean delete(Object obj);
	public abstract List<Object> query();
	
}
