var dataList = null, ifDataOnceLoaded = false,cropDataTable; 
$(document).ready(function(){
	buildDataTable();
 /*$.getJSON($("#contextPath").val()+"/cropData", function(json){
	 //buildDataTable(json.data);
	//fillUpDashboardDate(json.data)
});  */

});
function buildDataTable(){
	$.blockUI({ message: '<h1><img src="'+$("#contextPath").val()+'/images/busy.gif" />  </h1>' });
	cropDataTable = $('#cropDataTable').DataTable( {
		"dom": "lfrtiBp",
         "ajax": {
            "url": $("#contextPath").val()+"/cropData",
            "dataSrc": function(data){
            	var return_data = new Array();
            	$.unblockUI();
            	dataList = data.data;
            	$.each(data.data,function(key,value){
            		return_data.push({
            			'stateName':value.stateName,
            			'districtName':value.districtName,
            			'cropYear':value.cropYear,
            			'season':value.season,
            			'crop':value.crop,
            			'area':value.area,
            			'production':value.production,
            		})
            		//if (!$("#state option[value='" + value.stateName + "']").length){
            			//$('#state').append('<option value='+value.stateName+' >'+value.stateName+'</option>');
            		//}
            	});
            	$("#upperDiv").css("display","block");
            	fillFilterOption(); 
            	return return_data;
            } 
        }, 
        columns: [
                  {data:'stateName'},
		           {data:'districtName'},
		           {data:'cropYear'},
		           {data:'season'},
		           {data: 'crop'},
		           {data: 'area'},
		           {data: 'production'}
		           ],
        "pageLength": 10,
        "lengthChange": true,
	      "lengthMenu": [[10, 100, -1], [10, 100, "All"]],
	      "searching": true,
	      "ordering": false,
	      "info": true 
	     
    } );
	
	
}

function fillFilterOption(){
	if(dataList.length > 0){
$('#metricsDiv').css('display','block');
	var stateNames = [],districtNames = [], crops =[], seasons =[], years = [];
	var totalProduction = 0, totalArea = 0,maxProduction = dataList[0].production,maxArea = dataList[0].area;
	var avgArea, avgProduction;
	for(var x = 0; x < dataList.length ; x++){
		totalProduction += dataList[x].production;
		totalArea += dataList[x].area;
		if(maxProduction < dataList[x].production){
			maxProduction = dataList[x].production;
		}
		if(maxArea < dataList[x].area){
			maxArea = dataList[x].area;
		}
		if(!ifDataOnceLoaded){
		
		if(stateNames.indexOf(dataList[x].stateName) < 0){
			stateNames.push(dataList[x].stateName);
		}
		if(districtNames.indexOf(dataList[x].districtName) < 0){
			districtNames.push(dataList[x].districtName);
		}
		if(crops.indexOf(dataList[x].crop) < 0){
			crops.push(dataList[x].crop);
		}
		if(seasons.indexOf(dataList[x].season) < 0){
			seasons.push(dataList[x].season);
		}
		if(years.indexOf(dataList[x].cropYear) < 0){
			years.push(dataList[x].cropYear);
		}
		}
		
	}
	ifDataOnceLoaded = true;
	$.each(stateNames, function (index, value) {
		if(stateNames[index] != null){
		var labelValue = stateNames[index].replace(/\s/g, '%20');
		}
		$('#state').append('<option value='+ labelValue+' >'+value+'</option>');
	});
	$.each(districtNames, function (index, value) {
		if(districtNames[index] != null){
			var labelValue = districtNames[index].replace(/\s/g, '%20');
			}
		$('#district').append('<option value='+labelValue+' >'+value+'</option>');
	});
	$.each(seasons, function (index, value) {
		if(seasons[index] != null){
			var labelValue = seasons[index].replace(/\s/g, '%20');
			}
		$('#season').append('<option value='+labelValue+' >'+value+'</option>');
	});
	$.each(years, function (index, value) {
		$('#year').append('<option value='+value+' >'+value+'</option>');
		$('#start_year').append('<option value='+value+' >'+value+'</option>');
		$('#end_year').append('<option value='+value+' >'+value+'</option>');
	});
	$.each(crops, function (index, value) {
		if(crops[index] != null){
			var labelValue = crops[index].replace(/\s/g, '%20');
			}
		$('#crop').append('<option value='+labelValue+' >'+value+'</option>');
	});
	 
	avgArea = Number(totalArea/(dataList.length));
	avgProduction = Number(totalProduction/(dataList.length));
	
	$("#maxArea").html(maxArea);
	$("#avgArea").html(avgArea);
	$("#avgProduction").html(avgProduction);
	$("#maxProduction").html(maxProduction);
	}else{
		$('#metricsDiv').css('display','none');
	}
}

function checkValueOfCheckBox(){ 
	if($('input[name=optradio]:checked').val() == "production"){
		$("#productionDiv").css("display","block");
		$("#areaDiv").css("display","none");
	}else if($('input[name=optradio]:checked').val() == "area"){
		$("#productionDiv").css("display","none");
		$("#areaDiv").css("display","block");
	}else if($('input[name=optradio]:checked').val() == "both"){
		$("#productionDiv").css("display","block");
		$("#areaDiv").css("display","block");
	}
}

function filterResults(){
	var flag = 0;
	$('#noGrouping').prop('checked',false);
	var url = $("#contextPath").val()+"/cropData?";
	if($('#state').val() != "" && flag == 0){
		url += "state="+$('#state').val()+"&";
	}
	if($('#district').val() != "" && flag == 0){
		url += "district="+$('#district').val()+"&";
	}
	if($('#crop').val() != "" && flag == 0){
		url += "crop="+$('#crop').val()+"&";
	}
	if($('#season').val() != "" && flag == 0){
		url += "season="+$('#season').val()+"&";
	}
	if($('#year').val() != "" && flag == 0){
		url += "crop_year="+$('#year').val()+"&";
	}
	if($('#start_year').val() != "" && flag == 0){
		url += "crop_year="+$('#start_year').val()+"&";
	}
	if($('#end_year').val() != "" && flag == 0){
		url += "crop_year="+$('#end_year').val()+"&";
	}
	if($('#area_min').val() != "" && flag == 0){
		url += "area_min="+$('#area_min').val()+"&";
	}
	if($('#area_max').val() != "" && flag == 0){
		url += "area_max="+$('#area_max').val()+"&";
	}
	if($('#production_min').val() != "" && flag == 0){
		url += "production_min="+$('#production_min').val()+"&";
	}
	if($('#production_max').val() != "" && flag == 0){
		url += "production_max="+$('#production_max').val()+"&";
	}
	$.blockUI({ message: '<h1><img src="'+$("#contextPath").val()+'/images/busy.gif" />  </h1>' });
	cropDataTable.ajax.url(url).load();
}

function checkGrouping(){
	if($('#noGrouping').attr('checked')){
		$('#state').val('');
		$('#crop').val('');
		$('#season').val('');
		$('#year').val('');
		$('#start_year').val('');
		$('#end_year').val('');
		$('#district').val('');
		$('#production_min').val('');
		$('#production_max').val('');
		$('#area_min').val('');
		$('#area_max').val('');
	}
}

function checkYear(){
	if(!($('#start_year').val() == '' && $('#end_year').val() == '') ){
		$('#year').val('');
	}
}