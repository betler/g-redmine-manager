package pro.cvitae.gredminemanager.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GRMControllerAdvisor {
	
	/**
	 * Lleva a la página de inicio con un mensaje.
	 * @param nhfe
	 * @param usuario
	 * @param request
	 * @param response
	 * @return
	 */
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(final NoHandlerFoundException nhfe, final HttpServletRequest request, final HttpServletResponse response) {
        return "redirect:/?error=404";
    }
}
