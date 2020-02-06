package pro.cvitae.gredminemanager.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pro.cvitae.gredminemanager.web.common.GRMGenericController;
import pro.cvitae.gredminemanager.web.common.ViewNames;

@Controller
public class MainController extends GRMGenericController {

	/**
	 * Main page
	 * 
	 * @return
	 */
	@GetMapping(ViewNames.INDEX_URL)
	public String main() {
		return ViewNames.INDEX_VIEW;
	}
}
