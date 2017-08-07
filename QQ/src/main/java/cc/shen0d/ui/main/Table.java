package cc.shen0d.ui.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import cc.shen0d.ui.main.pojo.CloumnObj;

/**
 * table 标签封装
 * 
 * @author sihan
 *
 */
public class Table extends BodyTagSupport {
	/**
	 * 基础属性
	 */
	private String name;
	private String id;
	private String toolbarName;
	private String url;
	private String method;
	private String striped;
	private String cache;
	private String pagination;
	private String sortable;
	private String queryParams;
	private String sidePagination;
	private String pageNumber;
	private String pageSize;
	private String pageList;
	private String search;
	private String strictSearch;
	private String showColumns;
	private String showRefresh;
	private String minimumCountColumns;
	private String clickToSelect;
	private String height;
	private String uniqueId;
	private String showToggle;
	private String cardView;
	private String detailView;

	private List<CloumnObj> columns;

	@Override
	public int doStartTag() throws JspException {
		columns = new ArrayList<CloumnObj>();
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.getPreviousOut();
		StringBuffer sb = new StringBuffer();
		sb.append("<table id=\"" + this.getId() + "\"></table>");
		sb.append("\r\n").append("<script type='text/javascript'>");
		sb.append("\r\n").append("$(function(){");
		sb.append("\r\n").append("tools.normal().createBootstrapTable('#" + this.getId() + "','"
				+ this.getUrl() + "',");
		sb.append("\r\n").append("{");
		if (columns.size() == 0) {
			throw new RuntimeException("请填入子列");
		}
		if (StringUtils.isNotBlank(this.getToolbarName())) {
			sb.append("\r\n").append("toolbarName:'" + this.getToolbarName() + "',");
		}
		if (StringUtils.isNotBlank(this.getMethod())) {
			sb.append("\r\n").append("method:'" + this.getMethod() + "',");
		}
		if (StringUtils.isNotBlank(this.getStriped())) {
			sb.append("\r\n").append("striped:'" + this.getStriped() + "',");
		}
		if (StringUtils.isNotBlank(this.getCache())) {
			sb.append("\r\n").append("cache:'" + this.getCache());
		}
		if (StringUtils.isNotBlank(this.getPagination())) {
			sb.append("\r\n").append("pagination:'" + this.getPagination() + "',");
		}
		if (StringUtils.isNotBlank(this.getSortable())) {
			sb.append("\r\n").append("sortable:'" + this.getSortable() + "',");
		}
		if (StringUtils.isNotBlank(this.getQueryParams())) {
			sb.append("\r\n").append("queryParams:" + this.getQueryParams() + ",");
		}
		if (StringUtils.isNotBlank(this.getSidePagination())) {
			sb.append("\r\n").append("sidePagination:'" + this.getSidePagination() + "',");
		}
		if (StringUtils.isNotBlank(this.getPageNumber())) {
			sb.append("\r\n").append("pageNumber:'" + this.getPageNumber() + "',");
		}
		if (StringUtils.isNotBlank(this.getPageSize())) {
			sb.append("\r\n").append("pageSize:'" + this.getPageSize() + "',");
		}
		if (StringUtils.isNotBlank(this.getPageList())) {
			sb.append("\r\n").append("pageList:'" + this.getPageList() + "',");
		}
		if (StringUtils.isNotBlank(this.getSearch())) {
			sb.append("\r\n").append("search:'" + this.getSearch() + "',");
		}
		if (StringUtils.isNotBlank(this.getStrictSearch())) {
			sb.append("\r\n").append("strictSearch:'" + this.getStrictSearch() + "',");
		}
		if (StringUtils.isNotBlank(this.getShowColumns())) {
			sb.append("\r\n").append("showColumns:'" + this.getShowColumns() + "',");
		}
		if (StringUtils.isNotBlank(this.getShowRefresh())) {
			sb.append("\r\n").append("showRefresh:'" + this.getShowRefresh() + "',");
		}
		if (StringUtils.isNotBlank(this.getMinimumCountColumns())) {
			sb.append("\r\n")
					.append("minimumCountColumns:'" + this.getMinimumCountColumns() + "',");
		}
		if (StringUtils.isNotBlank(this.getClickToSelect())) {
			sb.append("\r\n").append("clickToSelect:'" + this.getClickToSelect() + "',");
		}
		if (StringUtils.isNotBlank(this.getHeight())) {
			sb.append("\r\n").append("height:'" + this.getHeight() + "',");
		}
		if (StringUtils.isNotBlank(this.getUniqueId())) {
			sb.append("\r\n").append("uniqueId:'" + this.getUniqueId() + "',");
		}
		if (StringUtils.isNotBlank(this.getShowToggle())) {
			sb.append("\r\n").append("showToggle:'" + this.getShowToggle() + "',");
		}
		if (StringUtils.isNotBlank(this.getCardView())) {
			sb.append("\r\n").append("cardView:'" + this.getCardView() + "',");
		}
		if (StringUtils.isNotBlank(this.getDetailView())) {
			sb.append("\r\n").append("detailView:'" + this.getDetailView() + "',");
		}
		sb.append("\r\n").append("columns:" + this.getColumnString());
		sb.append("\r\n").append("}");
		sb.append("\r\n").append(")");
		sb.append("\r\n").append("})");
		sb.append("\r\n").append("</script>");
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * 回传两个参数 eval_page 继续执行后面jsp
		 * 页面 skip_page 不执行后面的jsp页面
		 */
		return BodyTagSupport.EVAL_PAGE;
	}

	/**
	 * 获取子类变成
	 */
	public String getColumnString() {
		List<Object> columnList = new ArrayList<Object>();
		for (CloumnObj tableColumn : columns) {
			System.out.println(tableColumn.getTitle());
			Map<String, Object> map = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(tableColumn.getCheckbox())
					&& tableColumn.getCheckbox().equalsIgnoreCase("Y")) {
				map.put("checkbox", true);
			} else {
				map.put("field", tableColumn.getId());
				map.put("title", tableColumn.getTitle());
				if (StringUtils.isNotBlank(tableColumn.getWidth())) {
					map.put("width", tableColumn.getWidth());
				}
				if (StringUtils.isNotBlank(tableColumn.getType())
						&& tableColumn.getType().equalsIgnoreCase("operate")) {
					map.put("events", tableColumn.getOperateEvents());
					map.put("formatter", tableColumn.getOperateFormatter());
				}
			}
			Object json = JSON.toJSON(map);
			columnList.add(json);
		}
		return Arrays.toString(columnList.toArray());
	}

	/**
	 * get和set方法
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException("表单id不能为空");
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToolbarName() {
		return toolbarName;
	}

	public void setToolbarName(String toolbarName) {
		this.toolbarName = toolbarName;
	}

	public String getUrl() {
		if (StringUtils.isBlank(url)) {
			throw new RuntimeException("url地址为空");
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStriped() {
		return striped;
	}

	public void setStriped(String striped) {
		this.striped = striped;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

	public String getSortable() {
		return sortable;
	}

	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	public String getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}

	public String getSidePagination() {
		return sidePagination;
	}

	public void setSidePagination(String sidePagination) {
		this.sidePagination = sidePagination;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageList() {
		return pageList;
	}

	public void setPageList(String pageList) {
		this.pageList = pageList;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getStrictSearch() {
		return strictSearch;
	}

	public void setStrictSearch(String strictSearch) {
		this.strictSearch = strictSearch;
	}

	public String getShowColumns() {
		return showColumns;
	}

	public void setShowColumns(String showColumns) {
		this.showColumns = showColumns;
	}

	public String getShowRefresh() {
		return showRefresh;
	}

	public void setShowRefresh(String showRefresh) {
		this.showRefresh = showRefresh;
	}

	public String getMinimumCountColumns() {
		return minimumCountColumns;
	}

	public void setMinimumCountColumns(String minimumCountColumns) {
		this.minimumCountColumns = minimumCountColumns;
	}

	public String getClickToSelect() {
		return clickToSelect;
	}

	public void setClickToSelect(String clickToSelect) {
		this.clickToSelect = clickToSelect;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getShowToggle() {
		return showToggle;
	}

	public void setShowToggle(String showToggle) {
		this.showToggle = showToggle;
	}

	public String getCardView() {
		return cardView;
	}

	public void setCardView(String cardView) {
		this.cardView = cardView;
	}

	public String getDetailView() {
		return detailView;
	}

	public void setDetailView(String detailView) {
		this.detailView = detailView;
	}

	public void addColumn(CloumnObj column) {
		columns.add(column);
	}

	public static void main(String[] args) {
		// StringBuffer sb = new StringBuffer();
		// Table table = new Table();
		// Class<? extends Table> class1 = table.getClass();
		// Field[] fields = class1.getDeclaredFields();
		// for (Field field : fields) {
		// String name2 = field.getName();
		// sb.append("\r\n")
		// .append("if(StringUtils.isNotBlank(this.get"
		// + name2.substring(0, 1).toUpperCase() + name2.substring(1)
		// + "())){sb.append(\"\\r\\n\").append(\"" + name2 + ":\" + this.get"
		// + name2.substring(0, 1).toUpperCase() + name2.substring(1) +
		// "());}");
		//
		// }
		// System.out.println(sb.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", true);
		map.put("b", "123");
		map.put("c", 123);
		map.put("d", 123L);
		map.put("e", 'a');
		Object json = JSON.toJSON(map);
		System.out.println(json);
	}
}
