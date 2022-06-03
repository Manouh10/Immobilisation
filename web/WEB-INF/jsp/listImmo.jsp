 
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="spring.web.mvc.project.model.ViewImmo"%>
<%@page import="spring.web.mvc.project.model.Responsable"%>
<%@page import="spring.web.mvc.project.model.Article"%>
<%@page import="spring.web.mvc.project.service.ImmoService"%>
<%@page import="java.util.List"%>
<%
List<Article> listArticle=(List<Article>) request.getAttribute("listArticle");
List<Responsable> listResponsable=(List<Responsable>) request.getAttribute("listResponsable");  
List<ViewImmo> listImmo=(List<ViewImmo>)request.getAttribute("listImmobilisation");
 
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
						<h4 class="page-title">LISTE DES IMMOBILISATION</h4>
						 
					</div>
					<div class="row">
						 

						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="d-flex align-items-center">
										<h4 class="card-title"> </h4>
										<button class="btn btn-primary btn-round ml-auto" data-toggle="modal" data-target="#addRowModal">
											<i class="fa fa-plus"></i>
											Ajouter Immobilisation
										</button>
									</div>
								</div>
								<div class="card-body">
									<!-- Modal -->
									<div class="modal fade" id="addRowModal" tabindex="-1" role="dialog" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header no-bd">
													<h5 class="modal-title">
														<span class="fw-mediumbold">
														Ajouter</span> 
														<span class="fw-light">
															Immobilisation
														</span>
													</h5>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
                                                                                                    <form action="insertImmob" method="post">
														<div class="row">
															<div class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Nom</label>
																	<input id="addName" type="text" name="nom" class="form-control" placeholder=" ">
																</div>
															</div>
                                                                                                                        <div class="col-sm-12"> 
                                                                                                                                <select name="article" class="form-control form-control" id="defaultSelect">
                                                                                                                                        <option>Article</option>
                                                                                                                                        <%for(int i=0;i<listArticle.size();i++) { %>%>
                                                                                                                                        <option value="<%out.print(listArticle.get(i).getId());%>" > <%out.print(listArticle.get(i).getNom_artcile());%></option>
                                                                                                                                        <% } %>
                                                                                                                                </select>
                                                                                                                        </div>
															 
															<div style="margin-top:10px" class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Date d'achat</label>
																	<input name="date_achat" id="addOffice" type="date" class="form-control" placeholder=" ">
																</div>
															</div>
                                                                                                                                
                                                                                                                        
                                                                                                                        <div style="margin-top:10px" class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Prix d'aquisition</label>
																	<input id="addOffice" name="prix_aquisation" type="number" class="form-control" placeholder=" ">
																</div>
															</div>
                                                                                                                    
                                                                                                                        <div class="col-sm-12"> 
                                                                                                                            <select name="responsable" class="form-control form-control" id="defaultSelect">
                                                                                                                                        <option>Responsable</option>
                                                                                                                                        <%for(int i=0;i<listResponsable.size();i++){%>
                                                                                                                                        <option value="<%out.print(listResponsable.get(i).getId());%>"><%out.print(listResponsable.get(i).getNom_responsable());%></option>
                                                                                                                                         <% } %>
                                                                                                                                </select>
                                                                                                                        </div>
                                                                                                                             
                                                                                                                    <div style="margin-top:10px" class="col-sm-12">
																<div class="form-group form-group-default">
																	<label>Duree d'amortissement (Annee)</label>
                                                                                                                                        <input name="duree_ammortissement" id="addOffice" type="number" class="form-control" placeholder=" ">
																</div>
														    </div> 
                                                                                                                                  <button type="submit"   class="btn btn-primary">Ajouter</button>
                                                                                                                                  <button type="button" class="btn btn-danger" data-dismiss="modal">Annuler</button>
														</div>
                                                                                                         
													</form>
                                                                                                                              
													
												</div>
												<div class="modal-footer no-bd">
													
												</div>
											</div>
										</div>
									</div>

									<div class="table-responsive">
										<table id="add-row" class="display table table-striped table-hover" >
											<thead>
												<tr>
													<th>Nom</th>
													<th>Article</th>
													<th>Prix d'achat</th>
													<th>Date achat</th>
                                                                                                        <th>Date service</th>
                                                                                                        <th>Responsable</th>
                                                                                                        <th>Duree d'amotissement</th>
                                                                                                         
                                                                                                        
												</tr>
											</thead>
											 
											<tbody>
                                                                                            <%for(int i=0;i<listImmo.size();i++){%>
												<tr>
                                                                                                    <td>
                                                                                                         <%if(ImmoService.nullToString(listImmo.get(i).getDate_service())=="No service"){%>
                                                                                                         <%out.print(listImmo.get(i).getNom());%> 
                                                                                                         <% } else {%> 
                                                                                                            <a style="text-decoration:none" href="listInfo?id=<%out.print(listImmo.get(i).getId());%>"><%out.print(listImmo.get(i).getNom());%></a>
                                                                                                           <% } %>
                                                                                                    </td> 
                                                                                                        <td><%out.print(listImmo.get(i).getNom_artcile());%></td> 
                                                                                                        <td><%out.print(listImmo.get(i).getPrix_aquisation());%> Ar</td> 
                                                                                                        <td><%out.print(ImmoService.showDate(listImmo.get(i).getDate_achat()));%> </td> 
                                                                                                        <td><%out.print(ImmoService.nullToString(listImmo.get(i).getDate_service()));%></td> 
                                                                                                        <td><%out.print(listImmo.get(i).getNom_responsable());%></td> 
                                                                                                        <td><%out.print(listImmo.get(i).getDuree_ammortissement());%> Ans</td> 
                                                                                                        <%if(ImmoService.nullToString(listImmo.get(i).getDate_service())=="No service"){%>
                                                                                                        <td><a style="text-decoration:none" href="updateService?id=<%out.print(listImmo.get(i).getId());%>">Service</a></td> 
                                                                                                        <% } else {%>
                                                                                                          <td><a style="text-decoration:none" href="exportPdf?id=<%out.print(listImmo.get(i).getId());%>">PDF</a></td> 
                                                                                                        <% } %>
												</tr> 
                                                                                            <% } %>
                                                                                           
											</tbody>
										</table>
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