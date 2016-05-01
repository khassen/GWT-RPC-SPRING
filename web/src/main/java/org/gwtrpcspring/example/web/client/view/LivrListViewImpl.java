package org.gwtrpcspring.example.web.client.view;

import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwtrpcspring.client.core.model.Livre;

public class LivrListViewImpl extends Composite implements LivreListView {

	private static LivrListViewImplUiBinder uiBinder = GWT
			.create(LivrListViewImplUiBinder.class);

	interface LivrListViewImplUiBinder extends
			UiBinder<Widget, LivrListViewImpl> {
	}

	@UiField(provided = true)
	SimplePager pager;
	@UiField(provided = true)
	CellTable<Livre> cellTable;
	@UiField
	Button modifyButton;

	private Presenter presenter;

	public Presenter getPresenter() {
		return presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public LivrListViewImpl() {
		buidCellTable();

		buildSimplePager();

		initWidget(uiBinder.createAndBindUi(this));
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void buildSimplePager() {
		// create a pager to control the table

		SimplePager.Resources pagerResources = GWT
				.create(SimplePager.Resources.class);

		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0,
				true);
		pager.setDisplay(cellTable);

	}

	private void buidCellTable() {
		// definir une celltable
		cellTable = new CellTable<Livre>();
		// permet de selectionner un seul item
		SingleSelectionModel<Livre> selectionModel = new SingleSelectionModel<Livre>();
		// recuperer le clé de l'item selectionné
		ProvidesKey<Livre> keyProvider = new ProvidesKey<Livre>() {

			@Override
			public Object getKey(Livre item) {
				// Always do a null check.
				return (item == null) ? null : item.getId();
			}
		};
		// select un item
		cellTable.setSelectionModel(selectionModel);

		// recup id de l'item
		Column<Livre, Number> idColumn = new Column<Livre, Number>(
				new NumberCell()) {

			@Override
			public Number getValue(Livre object) {
				// TODO Auto-generated method stub
				return object.getId();
			}

		};
		// ajout de l'id
		cellTable.addColumn(idColumn, "Id");

		// de la meme facon pour le titre
		Column<Livre, String> titreColumn = new Column<Livre, String>(
				new TextCell()) {
			@Override
			public String getValue(Livre object) {
				return object.getTitre();
			}
		};
		cellTable.addColumn(titreColumn, "titre");
		// pagination:20
		cellTable.setPageSize(20);
	}

	@UiHandler("deleteButton")
	public void onDeleteButtonEvent(ClickEvent ce) {
		presenter.onDeleteButtonClicked();
	}
	
	@UiHandler("modifyButton")
	void onModifyButtonClick(ClickEvent event) {
		presenter.onModifyButtonClicked();
	}

	@Override
	public void setData(List<Livre> livres) {
		// TODO Auto-generated method stub

	}

	@Override
	public Livre getSelectedLivre() {
		// TODO Auto-generated method stub
		return null;
	}

}
