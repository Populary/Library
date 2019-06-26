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
		//"order": [[ 5, "desc" ]],
		"serverSide":true,
		"lengthMenu": [[10, 25, 50], [10, 25, 50]],
		"ajax":{
			type : "GET",
			url : "/content/borrowers",
			data:""
			},
		//"data" : tt1,
		columns : [ {
			sTitle : "ID",
			data : "id"
		}, {
			sTitle : "工号",
			data : "workNo"
		}, {
			sTitle : "姓名",
			data : "name"
		}, {
			sTitle : "部门",
			data : "dep"
		}, {
			sTitle : "手机号码",
			data : "tele"
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
               case 2:
                    this.search($('#workname').val());
                    break;
               case 1:
                    this.search($('#workno').val());
                    break;
               case 3:
                   this.search($('#dep').val());
                   break;
               case 5:
                   this.search($('#status').val());
                   break;
            }
        });
	    table.columns().search().draw();
	});
	
	//重置按钮
	$('#reset').click(function() {	
		$('#workname').val("");
		$('#workno').val("");
		$('#dep').val("");
		$('#status').val("");
	});
	
	//新增按钮
	$('#add').click(function() {	
		$('#addModal').modal('toggle');
		$('#add_workno').val("");
		$('#add_name').val("");
		$('#add_tele').val("");
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
	       	 url:"/content/borrower/add", 
	        // dataType:"String",  
	         type:"post", 
	         async:"true",
	         data:{add_name:$('#add_name').val(),add_workno:$('#add_workno').val(),add_tele:$('#add_tele').val(),add_dep:$('#add_dep').val()},
	         success:function(data){
	        	 if(data=="0")
		        	 {toastr.success("新增成功!");
		        	 $('#addModal').modal('toggle');
		        	 $('#reset').click();
		        	 table.columns([1]).search($('#add_workno').val()).draw();}
	        	 else if(data=="99")
	        		 toastr.error($('#add_workno').val()+"工号已存在!"); 
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
	    $('#update_id').val(table.rows('.selected').data()[0].id);
		$('#update_workno').val(table.rows('.selected').data()[0].workNo);
		$('#update_name').val(table.rows('.selected').data()[0].name);
		$('#update_dep').val(table.rows('.selected').data()[0].dep);
		$('#update_tele').val(table.rows('.selected').data()[0].tele);	
		}
	});
	
	
	$('#updateconfirm').click(function() {	
//		$('#add_bookno').val();
//		$('#add_bookname').val();
//		$('#add_booktype').val();
//		$('#add_bookauthor').val();
		
		$.ajax({          
	       	 url:"/content/borrower/update", 
	        // dataType:"String",  
	         type:"post", 
	         async:"true",
	         data:{update_name:$('#update_name').val(),update_id:$('#update_id').val(),update_tele:$('#update_tele').val(),update_dep:$('#update_dep').val()},
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
		table.columns([1]).search($('#update_workno').val()).draw();
	});
});