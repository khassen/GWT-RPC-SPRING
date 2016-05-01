package org.gwtrpcspring.example.web.shared.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtrpcspring.client.core.model.Livre;

public interface LivreServiceAsync {

	void delete(Long id, AsyncCallback<Void> callback);

	void find(Long id, AsyncCallback<Livre> callback);

	void findAll(AsyncCallback<List<Livre>> callback);

	void update(Livre Entite, AsyncCallback<Void> callback);

}
