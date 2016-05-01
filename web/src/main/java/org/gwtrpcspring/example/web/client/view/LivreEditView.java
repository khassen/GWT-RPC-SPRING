package org.gwtrpcspring.example.web.client.view;


import com.google.gwt.user.client.ui.Widget;
import com.gwtrpcspring.client.core.model.Livre;

public interface LivreEditView {
	public interface Presenter extends
			org.gwtrpcspring.example.web.client.presenter.Presenter {
		void onLivreChange();

		void onLivreChanceCancel();
	}

	void setPresenter(LivreEditView.Presenter presenter);

	void setLivre(Livre livre);

	Livre getLivre();

	Widget asWidget();
}
