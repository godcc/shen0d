package cc.shen0d.ui.main;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.beanutils.BeanUtils;

import cc.shen0d.ui.main.pojo.CloumnObj;

/**
 * 列数据
 * 
 * @author sihan
 *
 */
public class TableColumn extends BodyTagSupport {
	private String id;
	private String title;
	private String operateFormatter;
	private String operateEvents;
	private String width;
	private String checkbox;
	private String type;

	@Override
	public int doEndTag() throws JspException {
		CloumnObj cloumnObj = new CloumnObj();
		try {
			BeanUtils.copyProperties(cloumnObj, this);
			Table parent = (Table) this.getParent();
			parent.addColumn(cloumnObj);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 回传两个参数 eval_page 继续执行后面jsp
		 * 页面 skip_page 不执行后面的jsp页面
		 */
		return BodyTagSupport.EVAL_PAGE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOperateFormatter() {
		return operateFormatter;
	}

	public void setOperateFormatter(String operateFormatter) {
		this.operateFormatter = operateFormatter;
	}

	public String getOperateEvents() {
		return operateEvents;
	}

	public void setOperateEvents(String operateEvents) {
		this.operateEvents = operateEvents;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
