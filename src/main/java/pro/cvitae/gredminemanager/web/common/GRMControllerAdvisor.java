/**
 * Copyright [2020] [https://github.com/betler]
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
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
	 * 
	 * @param nhfe
	 * @param usuario
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404(final NoHandlerFoundException nhfe, final HttpServletRequest request,
			final HttpServletResponse response) {
		return "redirect:/?error=404";
	}
}
