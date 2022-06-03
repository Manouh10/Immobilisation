 
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="spring.web.mvc.project.model.ViewImmo"%>
<%@page import="spring.web.mvc.project.model.Responsable"%>
<%@page import="spring.web.mvc.project.model.Article"%>
<%@page import="spring.web.mvc.project.service.ImmoService"%>
<%@page import="java.util.List"%>
 <%
 ViewImmo immo=(ViewImmo)request.getAttribute("singleImmo");
 %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>Immobilisation</title>
	<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
	<link rel="icon" href="assets/img/icon.ico" type="image/x-icon"/>
	
	<!-- Fonts and icons -->
	<script src="assets/js/plugin/webfont/webfont.min.js"></script>
	<script>
		WebFont.load({
			google: {"families":["Lato:300,400,700,900"]},
			custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['../../assets/css/fonts.min.css']},
			active: function() {
				sessionStorage.fonts = true;
			}
		});
	</script>

	<!-- CSS Files -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/atlantis.min.css">
	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
</head>
<body data-background-color="dark">
	<div class="wrapper">
		 
		 
		  <jsp:include page="menu.jsp" />  
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="page-header">
						<h4 class="page-title">Mise en service : <%out.print(immo.getNom());%> (<%out.print(immo.getNom_artcile());%>)</h4>
					 
						 
					</div>
					<div class="row">
						 

						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
                                                                    <h4>Date d'achat: <%out.print(immo.getDate_achat());%></h4> 
								</div>
								<div class="card-body">
									 
									 	 	  
												 
                                                                                                 <form action="updateDate_service" method="post">
														<div class="row">
															 
															 
															<div style="margin-top:10px" class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Date de mise en service  </label>
																	<input name="date_service" id="addOffice" type="date" class="form-control" placeholder=" ">
																</div>
                                                                                                                            <input type="hidden" name="id" value="<%out.print(immo.getId());%>">
															</div>
                                                                                                                                
                                                                                                                  
                                                                                                                                  <button type="submit"   class="btn btn-primary">Valider</button>
                                                                                                                                 
														</div>
                                                                                                         
												 </form>
                                                                                                                              
													
												 
												<div class="modal-footer no-bd">
													
												</div>
											 

									 
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			 
		</div>
		
	 
		<!-- End Custom template -->
	</div>
	<!--   Core JS Files   -->
	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<!-- jQuery UI -->
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	
	<!-- jQuery Scrollbar -->
	<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Datatables -->
	<script src="assets/js/plugin/datatables/datatables.min.js"></script>
	<!-- Atlantis JS -->
	<script src="assets/js/atlantis.min.js"></script>
	<!-- Atlantis DEMO methods, don't include it in your project! -->
	<script src="assets/js/setting-demo2.js"></script>
	<script >
		$(document).ready(function() {
			$('#basic-datatables').DataTable({
			});

			$('#multi-filter-select').DataTable( {
				"pageLength": 5,
				initComplete: function () {
					this.api().columns().every( function () {
						var column = this;
						var select = $('<select class="form-control"><option value=""></option></select>')
						.appendTo( $(column.footer()).empty() )
						.on( 'change', function () {
							var val = $.fn.dataTable.util.escapeRegex(
								$(this).val()
								);

							column
							.search( val ? '^'+val+'$' : '', true, false )
							.draw();
						} );

						column.data().unique().sort().each( function ( d, j ) {
							select.append( '<option value="'+d+'">'+d+'</option>' )
						} );
					} );
				}
			});

			// Add Row
			$('#add-row').DataTable({
				"pageLength": 5,
			});

			var action = '<td> <div class="form-button-action"> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';

			$('#addRowButton').click(function() {
				$('#add-row').dataTable().fnAddData([
					$("#addName").val(),
					$("#addPosition").val(),
					$("#addOffice").val(),
					action
					]);
				$('#addRowModal').modal('hide');

			});
		});
	</script>
</body>
</html>