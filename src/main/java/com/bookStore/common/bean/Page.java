package com.bookStore.common.bean;

import java.util.List;

public class Page<T> {

	// 当前页
	private int pageNo;
	// 每页多少条
	private int pageSize = 3;
	// 总书数
	private int totalBookNumber;
	// 当前页的书籍集合
	private List<T> currentList;

	public Page(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @Description: 总页数
	 *
	 * @date 2017年3月20日,上午8:47:30
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public int getPageNumberCount() {
		return totalBookNumber % pageSize == 0 ? totalBookNumber / pageSize : totalBookNumber / pageSize + 1;
	}

	/**
	 * @Description: 是否是第一页
	 *
	 * @date 2017年3月20日,上午8:49:58
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public boolean isFirst() {
		if (pageNo == 1) {
			return true;
		}
		return false;
	}

	/**
	 * @Description: 是否是最后一页
	 *
	 * @date 2017年3月20日,上午8:50:17
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public boolean isLast() {
		if(pageNo == getPageNumberCount()){
			return true;
		}
		return false;
	}

	/**
	 * @Description:获取上一页页码
	 *
	 * @date 2017年3月20日,上午8:57:27
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public int getPrevPageNo() {
		if (isFirst()) {
			return pageNo;
		}
		return pageNo - 1;
	}

	/**
	 * @Description: 获取下一页页码
	 *
	 * @date 2017年3月20日,上午8:57:43
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public int getNextPageNo() {
		if (isLast()) {
			return pageNo;
		}
		return pageNo + 1;
	}

	public int getPageNo() {
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (pageNo > getPageNumberCount()) {
			pageNo = getPageNumberCount();
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalBookNumber() {
		return totalBookNumber;
	}

	public void setTotalBookNumber(int totalBookNumber) {
		this.totalBookNumber = totalBookNumber;
	}

	public List<T> getCurrentList() {
		return currentList;
	}

	public void setCurrentList(List<T> currentList) {
		this.currentList = currentList;
	}

}
