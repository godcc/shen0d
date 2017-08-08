<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>websocket测试</title>
</head>
<%@ include file="/common/common.jsp"%>
<body>
	<div style="width: 100%; height: 350px;overflow: scroll;" id="msgDiv">
	<ul>
	</ul>
	</div>
	<textarea rows="12" cols="5" style="width: 100%" id="msg">
</textarea>
	<button type="button" onclick="sendMsg()">提交消息</button>
</body>
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script>
	var ws=null;
	$(function() {
// 		ws = new WebSocket('ws://127.0.0.1/${ctx}websocket');
		console.log(top.location)
		ws =  new WebSocket("ws://"+top.location.host+"/${ctx}websocket");
		ws.onopen = function() {
			console.log('Info: connection opened.');
		};

		ws.onmessage = function(event) {
			console.log('Received: ' + event.data);
			var ul=$("#msgDiv").find("ul");
			ul.append("<li>"+event.data+"</li>")
			$('#msgDiv').scrollTop( $('#msgDiv')[0].scrollHeight );
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