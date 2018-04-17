$(function() {
	// solving active
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
	$('#a_'+menu).addClass('active');
	break;
	}

//	code for jQuery dataTable
	var $table = $('#productListTable');

	if($table.length) {

		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl =window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}

		$table.DataTable({
			lengthMenu : [ [ 1, 3, 5, -1 ], [ '1 Records', '3 Records', '5 Records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [		
				{
					data: 'code',
					mRender: function(data, type, view){
						return '<img src="'+window.contextRoot+'/resources/images/' + data +'.jpg" class="dataTableImg"/>';
					}
						
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data,type,row){
						return '&#8377; ' + data;
					}
						
				},
				{
					data: 'quantity'
				},
				
				{
					data: 'id',
					mRender: function(data, type, row){
						var str = '';
						str += '<a href="'+window.contextRoot+'/show/'+data+'/products" class="btn btn-primary">View</a> &#160;';
						str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/products" class="btn btn-success">Cart</a>';
						
						return str;
					}
				}
				]
		}); }


});