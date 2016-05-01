package org.gwtrpcspring.example.web.client.presenter;

import org.gwtrpcspring.example.web.client.view.LivreListView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Widget;

public class LivreListPresenter implements LivreListView.Presenter {

	// Manager responsible for adding handlers to event sources and firing those
	// handlers on passed in events. Primitive ancestor of EventBus,
	// and used at the core of {com.google.gwt.user.client.ui.Widget}.

	private HandlerManager eventBus;
	private LivreListView view;

	public LivreListPresenter(HandlerManager eventBus, LivreListView view) {

		this.eventBus = eventBus;
		this.view = view;
		// on accroche la vue a son presenter
		this.view.setPresenter(this);
	}

	@Override
	public Widget go() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDeleteButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onModifyButtonClicked() {
		// TODO Auto-generated method stub

	}

}
