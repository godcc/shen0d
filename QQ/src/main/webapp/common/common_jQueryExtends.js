//jquery增加插件
(function($) {
	$.extend({
		// 弹出提示框
		/**
		 * content:String 提示主体内容 option :object 可选配置
		 * 
		 */
		msg : function(content, option) {
			var options = {};
			$.extend(options, option)
			layer.msg(content, options)
		},
		// 弹出询问框
		/**
		 * content:String 提示内容 option:Object 可选自定义参数 bt1function :function
		 * 代表按钮一的方法
		 */
		confirm : function(content, options, bt1function) {
			var obj={};
			var defaults = {
				btn : [ "确定", "取消" ],
				icon : 3,
				title : '提示'
			}
			$.extend(obj,defaults, options);
			if ($.isFunction(bt1function)) {
				layer.confirm(content, obj, bt1function)
			} else {
				throw new Error("参数不为方法");
			}
		},
		// 吸附弹窗
		/**
		 * content :stirng 主体内容 follow: jquery对象也就是一个元素的对象 option:可选参数
		 */
		tips : function(content, follow, options) {
			var onj={};
			var defaults = {
				type : 4,
			};
			$.extend(obj,defaults, options);
			layer.tips(content, follow, obj)
		},
		//ajax方法抽取
		/**
		 * url:地址,
		 * type:ajax提交内容
		 * option:可选参数
		 */
		ajaxTypeJson:function(url,type,options){
			var obj={};
			var defaults ={
					url:url,
					type:type,
					contentType:'application/json',
					async:true,
					dataType:"JSON",
					data:{},
					error:function(){},
					success:function(data){console.log("原始success方法没有覆盖"+data)},
			};
			$.extend(obj,defaults,options);
			$.ajax(obj);
		}
	}),
	$.fn.extend({
		//验证表单
		validateForm:function(){
			var _this=this;
			var $from=$(_this[0]);
			console.log($from)
			if($from[0].tagName=="FORM"){
				var validate=_this.data("bootstrapValidator");
				validate.validate();
				return validate.isValid();
			}else{
				throw new Error("请使用form表单调用此方法")
			}
		}
	})

})(jQuery);