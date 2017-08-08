<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="common/common.jsp"%>
<head>
<title>聊天室</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${ctx }/common/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/common/css/jquery.mobile.flatui.css" />
</head>
<body>
	<div data-role="page">
		<div >
			<div data-role="content" class="container" style="height: 350px; overflow: scroll;" role="main"  id="msgDiv">
				<ul class="content-reply-box mg10">
					<li class="odd"><a class="user" href="#"><img
							class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span
							class="user-name">奔波儿灞</span></a>
						<div class="reply-content-box">
							<span class="reply-time">03-08 15：00</span>
							<div class="reply-content pr">
								<span class="arrow">&nbsp;</span> 为什么小鑫的名字里有三个金呢？
							</div>
						</div></li>
					<li class="even"><a class="user" href="#"><img
							class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span
							class="user-name">灞波儿奔</span></a>
						<div class="reply-content-box">
							<span class="reply-time">03-08 15：10</span>
							<div class="reply-content pr">
								<span class="arrow">&nbsp;</span>
								他命里缺金，所以取名叫鑫，有些人命里缺水，就取名叫淼，还有些人命里缺木就叫森。
							</div>
						</div></li>
					<li class="odd"><a class="user" href="#"><img
							class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span
							class="user-name">奔波儿灞</span></a>
						<div class="reply-content-box">
							<span class="reply-time">03-08 15：20</span>
							<div class="reply-content pr">
								<span class="arrow">&nbsp;</span> 那郭晶晶命里缺什么？
							</div>
						</div></li>
					<li class="even"><a class="user" href="#"><img
							class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span
							class="user-name">灞波儿奔</span></a>
						<div class="reply-content-box">
							<span class="reply-time">03-08 15：30</span>
							<div class="reply-content pr">
								<span class="arrow">&nbsp;</span> 此处省略一百字...
							</div>
						</div></li>
				</ul>
			</div>
		</div>
		<div>
			<textarea rows="12" cols="5" style="width: 100%" id="msg"></textarea>
			<button type="button" onclick="sendMsg()" style="float: right;">提交消息</button>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			/* 
			 ** 不同页面切换转场效果
			 ** $.mobile.changePage ('/test.html', 'slide/pop/fade/slideup/slidedown/flip/none', false, false);
			 */
			$('.list-group-item,.menu a').click(function() {
				$.mobile.changePage($(this).attr('href'), {
					transition : 'flip', //转场效果
					reverse : true
				//默认为false,设置为true时将导致一个反方向的转场
				});
			});
		});
	</script>
</body>
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script>
	var ws = null;
	$(function() {
		// 		ws = new WebSocket('ws://127.0.0.1/${ctx}websocket');
		console.log(top.location)
		ws = new WebSocket("ws://" + top.location.host + "/${ctx}websocket");
		ws.onopen = function() {
			console.log('Info: connection opened.');
		};

		ws.onmessage = function(event) {
			console.log('Received: ' + event.data);
			var ul = $("#msgDiv").find("ul");
			ul.append("<li>" + event.data + "</li>")
			$('#msgDiv').scrollTop($('#msgDiv')[0].scrollHeight);
		};

		ws.onclose = function(event) {
			alert("傻逼你被别人登陆/这么好玩你居然想退出")
			console.log(event);
		};
	})

	function sendMsg() {
		if (ws != null) {
			var message = $("#msg").val()
			ws.send(message);
		} else {
			alert('connection not established, please connect.');
		}
	}
</script>
</html>