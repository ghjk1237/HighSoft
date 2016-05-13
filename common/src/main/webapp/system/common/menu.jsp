<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="bjui-hnav">
    <button type="button" class="btn-default bjui-hnav-more-left" title="导航菜单左移"><i class="fa fa-angle-double-left"></i></button>
    <div id="bjui-hnav-navbar-box">
        <ul id="bjui-hnav-navbar">
            <script type="text/javascript">            
			$.ajax({ 
			    url:'<%=request.getContextPath()%>/menuAction!listByUserId.action',   
			    type:'post',
			    dataType:"json",    
			    data:{},   
			    async : false, //默认为true 异步   
			    error:function(){   
			       alert('error0'); 			        
			    },   
			    success:function(json){ 
			    	var menuHtml = '';
			        var menuJson = eval(json);
			        $.each(menuJson, function(i,val) {
			        	if (i==0) {
			        		menuHtml = menuHtml + '<li class="active"><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-file-word-o"></i>'+val.txt+'</a><div class="items hide" data-noinit="true">';
			        	} else {
			        	    menuHtml = menuHtml + '<li><a href="javascript:;" data-toggle="slidebar"><i class="fa fa-file-word-o"></i>'+val.txt+'</a><div class="items hide" data-noinit="true">';
			        	}
			        	$.ajax({   
						    url:'<%=request.getContextPath()%>/menuAction!listByUserId.action',   
						    type:'post',
						    dataType:"json",    
						    data:{id:val.id},   
						    async : false, //默认为true 异步   
						    error:function(){   
						       alert('error1'); 			        
						    },   
						    success:function(json){
						    	var menuDetailJson = eval(json);
						    	$.each(menuDetailJson, function() {						    	
						            menuHtml = menuHtml + '<ul id="bjui-tree-rsgl'+this.id+'" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true" data-faicon="plane" data-tit="'+this.txt+'">'
						            $.ajax({   
									    url:'<%=request.getContextPath()%>/menuAction!listByUserId.action',   
									    type:'post',
									    dataType:"json",    
									    data:{id:this.id},   
									    async : false, //默认为true 异步   
									    error:function(){   
									       alert('error2'); 			        
									    }, 
									    success:function(json){
									        var menuJson1 = eval(json);
						    				$.each(menuJson1, function() {
						    					menuHtml = menuHtml + '<li data-id="'+this.id+'" data-pid="'+this.parentId+'" data-url="'+this.url+'" data-tabid="doc-file'+this.id+'" data-fresh="true" data-reloadWarn="true">'+this.txt+'</li>';
						    				})
									    }
									})
									menuHtml = menuHtml + '</ul>';
								})
								
						    }
						})
						menuHtml = menuHtml + '</div></li>';						
			    	})
					document.getElementById('bjui-hnav-navbar').innerHTML = menuHtml;
			    }
			    			    
			});
			</script>
        </ul>
    </div>
    <button type="button" class="btn-default bjui-hnav-more-right" title="导航菜单右移"><i class="fa fa-angle-double-right"></i></button>
</div>
