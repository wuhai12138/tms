package com.jygj.summ.view.response;

/**
 * <p>@ClassName: fileView   </p>
 * <p>@Description:  </p>
 * <p>@Date: 2016/12/1 19:07 </p>
 * <p>@Author: tan | mail:haiting_tan@163.com </p>
 * <p>@Version: 1.0 - 2016/12/1</p>
 */
public class fileView {
	private String src;

	public fileView(String src) {
		this.src = src;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}
