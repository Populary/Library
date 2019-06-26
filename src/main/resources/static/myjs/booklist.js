$(document).ready(function() {
	toastr.options = {  
	        closeButton: false,  
	        debug: false,  
	        progressBar: true,  
	        positionClass: "toast-top-center",  
	        onclick: null,  
	        showDuration: "300",  
	        hideDuration: "1000",  
	        timeOut: "2000",  
	        extendedTimeOut: "1000",  
	        showEasing: "swing",  
	        hideEasing: "linear",  
	        showMethod: "fadeIn",  
	        hideMethod: "fadeOut"  
	    };
	
	var table =$('#example').DataTable({
		"pagingType" : "full_numbers",
		"dom" : '<"top"lp<"clear">>rt<"bottom"i<"clear">>',
		"searching" : true,
		"order": [[ 5, "desc" ]],
		"serverSide":true,
		"lengthMenu": [[10, 25, 50], [10, 25, 50]],
		"ajax":{
			type : "GET",
			url : "/content/books",
			data:""
			},
		//"data" : tt1,
		columns : [ {
			sTitle : "ID",
			data : "id"
		}, {
			sTitle : "书籍编码",
			data : "bookNo"
		}, {
			sTitle : "书名",
			data : "name"
		}, {
			sTitle : "类型",
			data : "type"
		}, {
			sTitle : "作者",
			data : "author"
		}, {
			sTitle : "入馆日期",
			data : "inTime"
		}, {
			sTitle : "数量",
			data : "number"
		}, {
			sTitle : "状态",
			data : "status"
		},]
	});

	//单行选中
	$('#example tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});


	//多行选中
	//    $('#example tbody').on( 'click', 'tr', function () {
	//        $(this).toggleClass('selected');
	//    } );

//	$('#button').click(function() {
//		//alert(table.rows('.selected').data().length + ' row(s) selected');
//		
//        table.columns().every(function () {//遍历列
//            switch (this.index()) {
//               case 1:
//                    this.search($('#bookno').val());
//                    break;
//               case 2:
//                    this.search($('#bookname').val());
//                    break;
//               case 3:
//                   this.search($('#booktype').val());
//                   break;
//               case 7:
//                   this.search($('#bookstatus').val());
//                   break;
//            }
//        });
//	    table.columns().search().draw();
//	});
	
	//查询按钮
	$('#query').click(function() {	
        table.columns().every(function () {//遍历列
            switch (this.index()) {
               case 1:
                    this.search($('#bookno').val());
                    break;
               case 2:
                    this.search($('#bookname').val());
                    break;
               case 3:
                   this.search($('#booktype').val());
                   break;
               case 7:
                   this.search($('#bookstatus').val());
                   break;
            }
        });
	    table.columns().search().draw();
	});
	
	//重置按钮
	$('#reset').click(function() {	
		$('#bookno').val("");
		$('#bookname').val("");
		$('#booktype').val("");
		$('#bookstatus').val("");
	});
	
	//新增按钮
	$('#add').click(function() {	
		$('#addModal').modal('toggle');
		$('#add_bookno').val("");
		$('#add_bookname').val("");
		$('#add_bookauthor').val("");
	});
	
	$('#addconfirm').click(function() {	
//		table.row.add( {
//	        "id":       "Tiger Nixon",
//	        "bookNo":   "System Architect",
//	        "name":     "$3,120",
//	        "inTime": "2011/04/25",
//	        "author":     "Edinburgh",
//	        "number":     "Edinburgh",
//	        "type":     "Edinburgh",
//	        "status":       "5421"
//		}).draw();	
		
		$.ajax({          
	       	 url:"/content/book/add", 
	        // dataType:"String",  
	         type:"post", 
	         async:"true",
	         data:{add_bookno:$('#add_bookno').val(),add_bookname:$('#add_bookname').val(),add_booktype:$('#add_booktype').val(),add_bookauthor:$('#add_bookauthor').val()},
	         success:function(data){
	        	 if(data=="0")
		        	 {toastr.success("新增成功!");
		        	 $('#addModal').modal('toggle');
		        	 $('#reset').click();
		        	 table.columns([1]).search($('#add_bookno').val()).draw();}
	        	 else if(data=="99")
	        		 toastr.error($('#add_bookno').val()+"书籍编码已存在!"); 
		         else
		        	 {toastr.error("新增失败!");
		        	 $('#addModal').modal('toggle');}
	        	 },      
	         error:function (data) {
	        	 toastr.error("新增失败!"); 
	        	 $('#addModal').modal('toggle');
	         }
	    });
		

	});
	
	
	//修改按钮
	$('#update').click(function() {	
		if(table.rows('.selected').data().length<1)
			toastr.error('请选择要修改的行！');
		else
		{
	    $('#updateModal').modal('toggle');
		$('#update_bookid').val(table.rows('.selected').data()[0].id);
		$('#update_bookno').val(table.rows('.selected').data()[0].bookNo);
		$('#update_booktype').val(table.rows('.selected').data()[0].type);
           var bookname=table.rows('.selected').data()[0].name;
		       bookname=bookname.replace(/《/g,"");
		       bookname=bookname.replace(/》/g,"");
		$('#update_bookname').val(bookname);
		$('#update_bookauthor').val(table.rows('.selected').data()[0].author);	
		}
	});
	
	
	$('#updateconfirm').click(function() {	
//		$('#add_bookno').val();
//		$('#add_bookname').val();
//		$('#add_booktype').val();
//		$('#add_bookauthor').val();
		
		$.ajax({          
	       	 url:"/content/book/update", 
	        // dataType:"String",  
	         type:"post", 
	         async:"true",
	         data:{add_bookid:$('#update_bookid').val(),add_bookno:$('#update_bookno').val(),add_bookname:$('#update_bookname').val(),add_booktype:$('#update_booktype').val(),add_bookauthor:$('#update_bookauthor').val()},
	         success:function(data){
	        	 if(data=="0")
	        	 toastr.success("修改成功!"); 
	        	 else
	        	 toastr.error("修改失败!");  
	         },      
	         error:function (data) {
	        	 toastr.error("修改失败!");  
	         }
	    });
		$('#updateModal').modal('toggle');
		$('#reset').click();
		table.columns([1]).search($('#update_bookno').val()).draw();
	});
});