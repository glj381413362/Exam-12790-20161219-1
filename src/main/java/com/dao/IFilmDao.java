package com.dao;

import java.util.List;

import com.bean.Film;
import com.dao.basedao.BaseDaoInterface;


public interface IFilmDao extends BaseDaoInterface<Film> {
	  
	    /**     
	     * @discription 分页查询
	     * @author 龚梁钧       
	     * @created 2016年12月19日 下午12:01:23     
	     * @param currentPage
	     * @return     
	     */
	public List<Film> queryByUsePage(int currentPage);
	  
	    /**     
	     * @discription 查询Film的总页数
	     * @author 龚梁钧       
	     * @created 2016年12月19日 下午12:12:40     
	     * @return     
	     */
	public int getPages();
}
