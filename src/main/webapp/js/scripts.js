$(document)
		.ajaxComplete(
				function(event, jqXHR, ajaxSettings) {
					var statusCode = jqXHR.status;
					var statusText = jqXHR.statusText;

					if (statusText == "timeout") {
						// Ocultamos el dialogo del ajaxStatus
						if (typeof statusDialog !== "undefined"
								&& statusDialog !== null) {
							statusDialog.hide();
						}
						// mostramos el dialogo de ajaxTimeout
						ajaxTimeOutDialog.show();
					} else if (statusCode == 999) {
						// la sesion esta caducada, mostramos el dialogo
						// de sesion caducada con el codigo de error 999.
						$(
								PrimeFaces
										.escapeClientId('borakErrorHandlerForm:sessionTimeOutCodigoError'))
								.text('(E999)');
						sessionTimeOutDialog.show();
					} else if (statusCode == 998) {
						// el usuario no tiene autorizacion, mostramos el
						// dialogo
						// de sesion caducada con el codigo de error 998.
						$(
								PrimeFaces
										.escapeClientId('borakErrorHandlerForm:sessionTimeOutCodigoError'))
								.text('(E998)');
						sessionTimeOutDialog.show();
					}
				});