package org.gwtrpcspring.example.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;

public class LivreListEvent extends GwtEvent<LivreListEvent.Handler> {

	public static interface Handler extends EventHandler {
		/**
		 * Called when a {@link SelectionChangeEvent} is fired.
		 *
		 * @param event
		 *            the {@link SelectionChangeEvent} that was fired 1
		 */
		void onSelectionChange(LivreListEvent event);

	}

	/**
	 * 2 Handler type.
	 */
	public static Type<LivreListEvent.Handler> TYPE = new Type<LivreListEvent.Handler>();

	/**
	 * Fires a selection change event on all registered handlers in the handler
	 * manager. If no such handlers exist, this method will do nothing.
	 *
	 * @param source
	 *            the source of the handlers
	 */
	public static void fire(SelectionModel<?> source) {
		if (TYPE != null) {
			LivreListEvent event = new LivreListEvent();
			source.fireEvent(event);
		}
	}

	/**
	 * 3Gets the type associated with this event.
	 *
	 * @return returns the handler type
	 */
	public static Type<LivreListEvent.Handler> getType() {
		if (TYPE == null) {
			TYPE = new Type<LivreListEvent.Handler>();
		}
		return TYPE;
	}

	/**
	 * 4 Creates a selection change event.
	 */
	public LivreListEvent() {
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void dispatch(Handler handler) {
		// TODO Auto-generated method stub

	}

}
