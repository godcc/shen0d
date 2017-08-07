//封装部分方法
$package("tools.normal");
tools.normal = function() {
	var _this;
	_this = {
		/**
		 * 重置表单方法 follow :String 表单对象id
		 */
		reset : function(follow) {
			var inputs = $(follow).find("input");
			$.each(inputs, function(i, n) {
				var _this = $(this);
				if (_this.attr("name") != "_token"&&_this.attr("reset")==undefined) {
					_this.val("");
				}
			})
		},
		/**
		 * 表单填充 follow 表单对象id obj 需要填的对象
		 */
		formFill : function(follow, obj) {
			var _form = $(follow);
			$.each(obj, function(i, n) {
				_form.find("#" + i).val(n)
			})
		},
		/**
		 * 远程加载模态框并填充数据到form表单中 modalId:模态框id url:远程加载地址 follow:form表单的id
		 * obj:值对象 _function:远程加载完成立即执行方法
		 * 
		 */
		remoteModalFillForm : function(modalId, url, follow, obj, _function) {
			$(modalId).modal({
				remote : url
			}).on('loaded.bs.modal', function(e) {
				if (!$.isEmptyObject(obj)) {
					_this.formFill(follow, obj);
				}
				if (_function != undefined) {
					if ($.isFunction(_function)) {
						_function();
					} else {
						throw new Error("请传入回调方法")
					}
				}
			});
		},
		/**
		 * 远程加载模态框 modalId:模态框id url:远程加载url地址 _function:回调方法
		 * 
		 */
		remoteModal : function(modalId, url, _function) {
			$(modalId).modal({
				remote : url
			}).on('loaded.bs.modal', function(e) {
				if (_function != undefined) {
					if ($.isFunction(_function)) {
						_function();
					} else {
						throw new Error("请传入回调方法")
					}
				}
			});
		},
		/**
		 * 创建bootstrap的table
		 */
		createBootstrapTable : function(follow, url, options) {
			var obj = {
				url : url, // 请求后台的URL（*）
				method : 'get', // 请求方式（*）
				dataType:'JSON',
//				toolbar : '#toolbar', // 工具按钮用哪个容器
				striped : true, // 是否显示行间隔色
				cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination : true, // 是否显示分页（*）
				sortable : false, // 是否启用排序
				sortOrder : "asc", // 排序方式
//				queryParams : params,// 传递参数（*）
				sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
				pageNumber : 1, // 初始化加载第一页，默认第一页
				pageSize : 10, // 每页的记录行数（*）
				pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
				search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch : true,
				showColumns : true, // 是否显示所有的列
				showRefresh : true, // 是否显示刷新按钮
				minimumCountColumns : 2, // 最少允许的列数
				clickToSelect : true, // 是否启用点击选中行
				height : 580, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId : "ID", // 每一行的唯一标识，一般为主键列
				showToggle : true, // 是否显示详细视图和列表视图的切换按钮
				cardView : false, // 是否显示详细视图
				detailView : false, // 是否显示父子表
			}
			$.extend(obj,options);
			console.log(obj)
			$(follow).bootstrapTable(obj);

		}

	}
	return _this;
}
