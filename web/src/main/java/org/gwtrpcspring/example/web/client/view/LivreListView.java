package org.gwtrpcspring.example.web.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.gwtrpcspring.client.core.model.Livre;

public interface LivreListView {
	
	public interface Presenter extends org.gwtrpcspring.example.web.client.presenter.Presenter{
		void onDeleteButtonClicked();
		void onModifyButtonClicked(); 
	}
	
	void setData(List<Livre> livres);
	Widget asWidget();
	void setPresenter(LivreListView.Presenter presenter);
	Livre getSelectedLivre();
	

}
