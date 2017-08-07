(function($) {
	/**
	 * 自定义ajax
	 */
	$.customAjax = function(options) {
		var defaults = {
			url : "",
			type : "post",
			async : true,
			dataParams : new Object(),
			// ajax请求返回的类型
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : function() {

			},
			error : function() {
			},
		}
		var opts = $.extend({}, defaults, options);
		var data = $.extend({}, opts.dataParams);

		$.ajax({
			type : opts.type,
			url : opts.url,
			contentType:opts.contentType,
			async : opts.async,
			data : JSON.stringify(opts.dataParams),
			dataType : opts.dataType,
			success : function(retData) {
				opts.success(retData);
			},
			error : function() {
				opts.error();
			}
		});
	}
	
	$.serializeObj = function(option) {
		var serializeObj = new Object();
		var serializeArray = $(option).serializeArray();
		console.log(serializeArray);
		$.each(serializeArray, function(i, n) {
			if (serializeObj[this.name]) {
				if ($.isArray(serializeObj[this.name])) {
					serializeObj[this.name].push(this.value);
				} else {
					serializeObj[this.name] = [ serializeObj[this.name], this.value ];
				}
			} else {
				serializeObj[this.name] = this.value;
			}
		});
		return serializeObj;
	}
})($);