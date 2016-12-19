/**
 * 
 * @author glj
 * @module canvasScoket
 * @namespace painter.controler
 */
(function($, global){
    "use strict";
    var score = 0;//分数
    
    /**
     * 
     * @class canvasSocket
     * @static 
     */
    var Inits = {
//    	    tipNum:0,
    		
     	  /**
            * 初始化
            * @method init 
            */
           init:function(){
//        	   var tempCanvasOptions=new Array();
        	   var $document = $(document);
                this.bindEvent();
           },
           /**
            * 绑定事件
            */
           bindEvent:function(){
        	 /*  $('#myModal').modal('hide');
        	   $('#myModal').on('hide.bs.modal',
        			    function() {
        			        alert('嘿，我听说您喜欢模态框...');
        			    });*/
        	   $("#update").on({//绑定更新事件
        		   click:function(){
        			   console.log($("#update").val());
        			   var all_tr = $("table tr");
        		        all_tr.click(function(){
        		            var text = $(this).children().eq(0).text();
//        		            console.log(text);
        		        });
        		   }
        	   });
        	
           }
    };
    
    $(document).ready(function(){
    	Inits.init();

    });
}(jQuery, window));
