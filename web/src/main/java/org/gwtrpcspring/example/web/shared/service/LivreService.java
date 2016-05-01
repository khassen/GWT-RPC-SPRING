package org.gwtrpcspring.example.web.shared.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwtrpcspring.client.core.model.Livre;

@RemoteServiceRelativePath("LivreService.rpc")
public interface LivreService extends RemoteService, GenericService<Livre, Long> {



	public static class Util {
		private static LivreServiceAsync instance;

		public static LivreServiceAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(LivreService.class);
			}
			return instance;
		}
	}




}
