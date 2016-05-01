package org.gwtrpcspring.example.client;




import org.gwtrpcspring.example.client.event.LivreDeleteEvent;
import org.gwtrpcspring.example.client.event.LivreEditEvent;
import org.gwtrpcspring.example.client.event.LivreListEvent;
import org.gwtrpcspring.example.web.client.presenter.LivreEditPresenter;
import org.gwtrpcspring.example.web.client.presenter.LivreListPresenter;
import org.gwtrpcspring.example.web.client.presenter.Presenter;
import org.gwtrpcspring.example.web.client.util.AbstractStep;
import org.gwtrpcspring.example.web.client.util.HistoryManager;
import org.gwtrpcspring.example.web.client.view.LivrListViewImpl;
import org.gwtrpcspring.example.web.client.view.LivreEditViewImpl;

import orp.gwtrpspring.example.web.client.panel.DesktopManager;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.gwtrpcspring.client.core.model.Livre;

public class AppController {
	private HandlerManager eventBus;
	private HasWidgets container;

	public AppController(HandlerManager eventBus) {
		bind();
		this.eventBus = eventBus;
	}

	private void bind() {

		// manager l'historique du navigateur, ca permet de le forcer à faire un
		// forward ou un back
		History.addValueChangeHandler((ValueChangeHandler<String>) this);

		// 1
		eventBus.addHandler(LivreEditEvent.TYPE, new LivreEditEvent.Handler() {

			@Override
			public void onSelectionChange(LivreEditEvent event) {
				doLivreEdit(event.getLivre());
			}

		});

		// 2
		eventBus.addHandler(LivreListEvent.TYPE, new LivreListEvent.Handler() {

			@Override
			public void onSelectionChange(LivreListEvent event) {
				doLivreList();

			}
		});

		// 3
		eventBus.addHandler(LivreDeleteEvent.TYPE,
				new LivreDeleteEvent.Handler() {

					@Override
					public void onSelectionChange(LivreDeleteEvent event) {
						deleteLivre(event.getLivre());

					}
				});
	}

	protected void deleteLivre(Livre l) {
		System.out.println("Un livre a ete supprime le : " + l);

	}

	private void doLivreList() {
		HistoryManager.get().doStep(new AbstractStep() {
			@Override
			public void execute() {
				Presenter presenter = new LivreListPresenter(eventBus,
						new LivrListViewImpl());
				DesktopManager.getInstance().setMainContent(presenter.go());
			}
		});

	}

	private void doLivreEdit(final Livre livre) {
		HistoryManager.get().doStep(new AbstractStep() {
			@Override
			public void execute() {
				Presenter presenter = new LivreEditPresenter(eventBus, new LivreEditViewImpl(), livre);
				DesktopManager.getInstance().setMainContent(presenter.go());
			}
		});

	}
}
