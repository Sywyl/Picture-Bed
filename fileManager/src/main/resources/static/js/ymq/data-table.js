layui.use('table', function() {
	var table = layui.table;
   
	table.render({
		elem: '#demo',
		data: [{
			"id": "1",
			"name": "pengleikeji.jpg",
			"url": "http://www.ymq.io/images/pengleikeji.jpg",
			"width": 259,
			"height": 259,
			"describe": "这是我的微信公众号",
			"createTime": "2017-09-09 11:00:00"
		}, {
			"id": "2",
			"name": "pengleikeji.jpg",
			"url": "http://www.ymq.io/images/pengleikeji.jpg",
			"width": 259,
			"height": 259,
			"describe": "这是我的微信公众号",
			"createTime": "2017-09-09 12:00:00"
		}, {
			"id": "3",
			"name": "pengleikeji.jpg",
			"url": "http://www.ymq.io/images/pengleikeji.jpg",
			"width": 259,
			"height": 259,
			"describe": "这是我的微信公众号",
			"createTime": "2017-09-09 13:00:00"
		}],
		width: 1140,
		cols: [
			[
			{checkbox:true,LAY_CHECKED:false},
			{field:'id',title:'序号',width:65,sort:true},
			{field:'name',title:'名称',width:200,sort:true},
			{field:'describe',title:'描述',width:280,sort:true},
			{field:'createTime',title:'上传日期',width:160,sort:true},
			{field:'right',title:'操作',width:380,toolbar:'#barTool'}
			]
		],
		skin: 'row' //表格风格
		,
		even: true,
		page: true //是否显示分页
		,
		limits: [5, 7, 10, 20],
		limit: 10 //每页默认显示的数量
	});
	
	//监听工具条
	table.on('tool(ymqFilter)', function(obj) {
		var data = obj.data;
		
		if (obj.event === 'd_btn_url_link') {
			//捕获页
			layer.open({
			  type: 1,
			  area: ['900px', '193px'], //宽高
			  shade: false,
			  title: false, //不显示标题
			  content: 
			   '<hr class="layui-bg-green">'
				+' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >HTML</button>&lt;img src="'+obj.data.url+'" alt="'+obj.data.name+'" title="'+obj.data.name+'" /&gt; </p><hr class="layui-bg-green">'
				+' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >Markdown</button>!['+obj.data.name+']('+obj.data.url+')</p><hr class="layui-bg-green">'
				+' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >Markdown with Link</button> [!['+obj.data.name+']('+obj.data.url+')]('+obj.data.url+')</p><hr class="layui-bg-green">'
				+' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >URL</button> '+obj.data.url+'</p><hr class="layui-bg-green">'
			});
		} else if (obj.event === 'd_btn_download') {
		
			layer.msg('开发中'+url, {time: 1000,});
			
		} else if (obj.event === 'd_btn_preview') {
			
			var height = $(window).height()-200;
			var width = $(window).width()-200;

			if(obj.data.height < height ){
				height = obj.data.height;
			}
			if(obj.data.width < width ){
				width = obj.data.height;
			}
			layer.open({
				type: 1,
				area: [width+"px", height+"px"], //自定义文本域宽高
				title: false,
				closeBtn: 0,
				skin: 'layui-layer-nobg', //没有背景色
				shadeClose: true,
				content: '<img src="'+obj.data.url+'" >'
			});
			

		} else if (obj.event === 'd_btn_delete') {
				layer.confirm('真的删除: ' + obj.data.name + ' 吗?', function(index) {
				
				//后台功能开发中
				
				obj.del();
				layer.close(index);
				layer.msg('删除成功', {time: 1000, });
				
			});
		} else if (obj.event === 'd_btn_edit') {
			layer.open({
				 type: 1,
				 closeBtn: 0,
				 area: ['400px', '215px'],//宽高
				 content: 
				'<form class="layui-form" style="padding-top: 10px ;margin: 0 8px; "  action="">' 
					
					+'<div class="layui-form-item"  >' 
						+'<input type="text" name="username" value="'+obj.data.name+'" lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">' 
					+'</div>' 
					
					+'<div class="layui-form-item"  >' 
						+'<input type="text" name="describe" value="'+obj.data.describe+'"  lay-verify="required" placeholder="请输入描述" autocomplete="off" class="layui-input">' 
					+'</div>' 
					
				+'</form>'
				, btn: ['保存', '取消']
				,yes: function(index, layero){
				
					//后台功能开发中
					
					obj.update({
					  name: '修改后的名称'
					  ,describe: '这是新的描述'
					});

					layer.msg('保存成功', {time: 1000,});
					
					layer.close(index);
				 }
				 ,btn2: function(index, layero){
					layer.close(index);
				 }
				  

			});
		}
		
	});

				
});