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
package pro.cvitae.gredminemanager.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pro.cvitae.gredminemanager.redmine.client.GRMClient;
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

		final GRMClient client = GRMClient.newClient().withUrl("JUR").withApiKey("jur").build();
		client.BORRAME();
		// client.connect();

		return ViewNames.INDEX_VIEW;
	}
}
