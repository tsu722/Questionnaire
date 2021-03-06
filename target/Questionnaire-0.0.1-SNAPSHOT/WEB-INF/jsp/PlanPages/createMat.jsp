<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" /> -->
<link rel="stylesheet" href="../plugins/layUI2/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="../css/global.css" media="all">
<link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/table.css" />
<title>创建物资点</title>
</head>

<body>

  <fieldset class="layui-elem-field">
	<legend>新增物资点</legend>
	<form class="layui-form layui-form-pane" action="">
		  <br />
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">物资点名称</label>
		    <div class="layui-input-inline">
		      <input type="text" name="matName" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required|title">
		    </div>
		  </div>
		  			  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">阻燃服</label>
		    <div class="layui-input-inline">
		      <input type="text" name="ffSuit" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="matQt">
		    </div>
		  </div>
		  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">GPS</label>
		    <div class="layui-input-inline">
		      <input type="text" name="gpsDevice" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="matQt">
		    </div>
		  </div>
		  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">运兵车</label>
		    <div class="layui-input-inline">
		      <input type="text" name="transCar" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="matQt">
		    </div>
		  </div>
		  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">发电机</label>
		    <div class="layui-input-inline">
		      <input type="text" name="dynamotor" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="matQt">
		    </div>
		  </div>
		  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">水管</label>
		    <div class="layui-input-inline">
		      <input type="text" name="waterPipe" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="matQt">
		    </div>
		  </div>
		  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">路径编号</label>
		    <div class="layui-input-inline">
		      <select name="rtID" lay-search="" lay-verify="required">
		          <option value="">选择该物资点关联路径</option>
		          <option value="1">1</option>
		          <option value="2">2</option>
		          <option value="3">3</option>
		          <option value="4">4</option>
		          <option value="5">5</option>
		          <option value="4">4</option>
		          <option value="5">5</option>
		          <option value="6">6</option>
		          <option value="7">8</option>
		          <option value="9">9</option>
		          <option value="10">10</option>
		          <option value="11">11</option>
		          <option value="12">12</option>
		          <option value="13">13</option>
		          <option value="14">14</option>
		          <option value="15">15</option>
		          <option value="16">16</option>
		          <option value="17">17</option>
		          <option value="18">18</option>
		          <option value="19">19</option>
		          <option value="20">20</option>
		          <option value="21">21</option>
		          <option value="22">22</option>
		          <option value="23">23</option>
		          <option value="24">24</option>
		          <option value="30">30</option>
		          <option value="31">31</option>
		          <option value="32">32</option>
		          <option value="33">33</option>
		          <option value="34">34</option>
		          <option value="35">35</option>
		          <option value="36">36</option>
		          <option value="37">37</option>
		        </select>
		    </div>
		  </div>
		  
		  <div style="margin-left:1cm;" class="layui-form-item">
		    <label class="layui-form-label">物资点位置</label>
		    <div class="layui-input-inline">
		      <input type="text" name="positionX" placeholder="横轴坐标" autocomplete="off" class="layui-input" lay-verify="required|location">
		    </div>
		    <div class="layui-input-inline">
		      <input type="text" name="positionY" placeholder="纵轴坐标" autocomplete="off" class="layui-input" lay-verify="required|location">
		    </div>
		    <div class="layui-input-inline">
		        <select name="locType" lay-search="">
		          <option value="1">GPS坐标</option>
		          <option value="2">像素坐标</option>
		        </select>
		    </div>	    
		  </div>
		  
		  <button style="margin-left:5cm;" class="layui-btn" lay-submit="" lay-filter="demo1">确认提交</button>
    	  <button type="reset" class="layui-btn layui-btn-primary">重置</button> 
    	  <br />
	</form>
	</fieldset>

	<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="../js/page.js"></script> 
	<script type="text/javascript" src="../plugins/layUI2/layui/layui.js"></script>
	<script>
	
	layui.use(['form', 'layedit', 'laydate'], function(){			//必须监听表单，否则某些样式出不来
		  var form = layui.form;
		
		  //自定义验证规则
	 	  form.verify({
	 	    title: [/[\u4e00-\u9fa5]{2,30}$/, '物资点名称需2个以上中文字符']
	 	    ,matQt: function(value){
	 	        if((value.length > 0) && (!/^[1-9]\d*$/.test(value))){
	 	            return '物资数量需为正整数';
	 	          }
	 	        }
	 	  	,location: [/^(([0-9]+[\.]?[0-9]+)|[1-9])$/, '请输入正数坐标']
	 	  });
	
	  //提交整个表单
	  form.on('submit(demo1)', function(data){
	    
		var req = null;
				
		//整合所有数据拼成Material对象
		if(data.field.locType == "2"){
			req = {"matName":data.field.matName, "ffSuit":data.field.ffSuit, 
		    		"gpsDevice":data.field.gpsDevice, "transCar":data.field.transCar, 
		    		"dynamotor":data.field.dynamotor, "waterPipe":data.field.waterPipe, "rtID":data.field.rtID, 
		    		"position":{"pointX":data.field.positionX, "pointY":data.field.positionY, "zmLev":1, "rtID": data.field.rtID, "ptType":2}}
		}
		if(data.field.locType == "1"){
			req = {"matName":data.field.matName, "ffSuit":data.field.ffSuit, 
		    		"gpsDevice":data.field.gpsDevice, "transCar":data.field.transCar,
		    		"gpsLat":data.field.positionX, "gpsLon":data.field.positionY,
		    		"dynamotor":data.field.dynamotor, "waterPipe":data.field.waterPipe, "rtID":data.field.rtID, 
		    		"position":{"zmLev":1, "rtID": data.field.rtID, "ptType":2}}
		}
	        		
		$.ajax( {
		     async : false, //这里不开异步，以防点数据赋值混乱
		     cache : false, //是否使用缓存
		     type : 'post', //请求方式,post
		     dataType : "json", //数据传输格式
		     url : "submitNewMat", //请求链接
		     contentType:"application/json",
		     data:JSON.stringify(req),
		     error : function() {
		       alert('网络故障！');
		     },
		     success : function(data) {
		       	 if(data.msg == 1){		       		
		       		layer.alert("新建物资点成功");
		       	 }				    	 				       
		     }
		});
	    
	    var index = parent.layer.getFrameIndex(window.name);
 	    parent.layer.close(index);
 	    parent.refreshMats();
	    	    
	    return false;
	  });
	});					
	</script>   
</body>
</html>