package com.dao.basedao;

import java.util.List;
import java.util.Map;


  
    /**        
     * Title: BaseDaoInterface.java    
     * Description: 基本的数据访问层对象的接口
     * @author 龚梁钧       
     * @created 2016年12月19日 上午10:14:39    
     */      
    
public interface BaseDaoInterface<T> {

	
	  
	    /**     
	     * @discription 根据ID获取某一数据库对象
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:14:51     
	     * @param id
	     * @return     
	     */
	T get(int id);

	
	  
	    /**     
	     * @discription 查询所以对象
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:15:06     
	     * @return     
	     */
	List<T> queryAll();

	
	  
	    /**     
	     * @discription 查询对象的数量
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:15:21     
	     * @return     
	     */
	long count();

	
	  
	    /**     
	     * @discription 根据ID删除某一数据记录
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:15:36     
	     * @param id
	     * @return     
	     */
	boolean remove(int id);

	
	  
	    /**     
	     * @discription 把数据对象保存到数据库
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:15:51     
	     * @param obj
	     * @return     
	     */
	boolean add(T obj);

	
	  
	    /**     
	     * @discription 更新数据库中的对象 以主键为条件
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:16:09     
	     * @param obj
	     * @return     
	     */
	boolean update(T obj);

	
	  
	    /**     
	     * @discription 通过对象查询
	     * @author 龚梁钧       
	     * @created 2016年12月19日 上午10:16:39     
	     * @param instance
	     * @return     
	     */
	List<T> queryByExample(T instance);
}
