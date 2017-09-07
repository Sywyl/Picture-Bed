layui.use('flow', function() {
	var flow = layui.flow;
	flow.load({
		 elem: '#pinterest' //流加载容器
		,scrollElem: '#pinterest' //滚动条所在元素，一般不用填，此处只是演示需要。
		,isAuto: true
		,isLazyimg: true
		,done: function(page, next) { //执行下一页的回调
			//模拟数据插入
			setTimeout(function() {
				var lis = [];
				for (var i = 0; i < 8; i++) {
					lis.push(
					'<li>'
						+'<img src="img/imgDemo.jpg" > '
						
						+'<div class="layui-btn-group" style="margin-top: -25px" >'
					
							+'<button value="img/imgDemo.jpg" name="美女一张" onclick="p_btn_url_link(this)" class="layui-btn layui-btn-primary layui-btn-mini"><i class="layui-icon">&#xe641;</i>复制外链</button>'
							+'<button value="img/imgDemo.jpg" onclick="p_btn_download(this)"  class="layui-btn layui-btn-primary layui-btn-mini"><i style="color: #01AAED;" class="layui-icon">&#xe601;</i>下载</button>'
							+'<button value="img/imgDemo.jpg" onclick="p_btn_preview(this)" class="layui-btn layui-btn-primary layui-btn-mini"><i style="color: #5FB878;" class="layui-icon">&#xe64a;</i>预览</button>'
						+' </div>'
						
					+'</li>')
				}
				//执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
				//pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
				next(lis.join(''), page < 10); //假设总页数为 10
			}, 500);
		}
	});
});

layui.use('element', function() {
	var $ = layui.jquery,
		element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
});


		
/*
瀑布流:按钮组自定义onclick事件
*/
		
	//瀑布流，复制外链
    function p_btn_url_link(event) {
        var url = event.value;
        var name = event.name;
        layer.open({
            type: 1,
            area: ['900px', '193px'],
            shade: false,
            title: false,
            content: 
				 '<hr class="layui-bg-green">' 
				+ ' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >HTML</button>&lt;img src="' + url + '" alt="' + name + '" title="' + name + '" /&gt; </p><hr class="layui-bg-green">' 
				+ ' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >Markdown</button>![' + name + '](' + url + ')</p><hr class="layui-bg-green">' 
				+ ' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >Markdown with Link</button> [![' + name + '](' + url + ')](' + url + ')</p><hr class="layui-bg-green">' 
				+ ' <p><button style="margin: 0 10px;" class="layui-btn layui-btn-warm layui-btn-mini" >URL</button> ' + url + '</p><hr class="layui-bg-green">'
		});
    }
	
	//瀑布流，下载图片
    function p_btn_download(event) {
        var url = event.value;
        layer.msg('开发中'+url, {time: 1000,});
    }
	
	//瀑布流，预览图片
    function p_btn_preview(event) {
        var url = event.value;

        layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            skin: 'layui-layer-nobg',
            shadeClose: true,
            content: '<img src=' + url + ' >'
        });
    }
	
		