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
package pro.cvitae.gredminemanager.redmine.client;

/**
 * @author betler
 *
 */
public class GRMClient {

	public enum AuthenticationTypes {
		USER_PASS, API_KEY;
	}

	public interface RedmineLocation {
		/**
		 * Sets the url where Redmine is.
		 *
		 * @param url
		 * @return
		 */
		AuthenticationType withUrl(final String url);
	}

	public interface AuthenticationType {

		Client withUserPass(final String user, final String pass);

		Client withApiKey(final String key);
	}

	public interface Client {

		/**
		 * Builds the client
		 *
		 * @return
		 */
		GRMClient build();
	}

	public static final class GRMClientBuilder implements RedmineLocation, AuthenticationType, Client {

		private String url;
		private AuthenticationTypes authType;
		private String user;
		private String pass;
		private String key;

		@Override
		public AuthenticationType withUrl(final String url) {
			this.url = url;
			return this;
		}

		@Override
		public Client withUserPass(final String user, final String pass) {
			this.authType = AuthenticationTypes.USER_PASS;
			this.user = user;
			this.pass = pass;
			return this;
		}

		@Override
		public Client withApiKey(final String key) {
			this.authType = AuthenticationTypes.USER_PASS;
			this.key = key;
			return this;
		}

		@Override
		public GRMClient build() {
			return new GRMClient(this);
		}

	}

	private final GRMClientBuilder builder;

	public GRMClient(final GRMClientBuilder builder) {
		this.builder = builder;
	}

	/**
	 * Starts building a new client
	 *
	 * @return
	 */
	public static RedmineLocation newClient() {
		return new GRMClientBuilder();
	}

	/**
	 * Tries to connect to Redmine. If authentication is user/pass based, it tries
	 * to fetch the api key
	 *
	 * @return
	 */
	public UserInfo connect() {
		throw new UnsupportedOperationException("Not yet");
		// return new UserInfo("jur");
	}

	public static void main(final String[] args) {
		GRMClient.newClient().withUrl("URL").withApiKey("token").build();
		GRMClient.newClient().withUrl("URL").withUserPass("user", "pass").build();
	}
}
