package com.company.kegelapp.ui.renderer;

import com.company.kegelapp.domain.Spieltag;
import com.rapidclipse.framework.server.data.renderer.RenderedComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class GesamtBetrag extends VerticalLayout implements RenderedComponent<Spieltag>
{

	/**
	 * 
	 */
	public GesamtBetrag()
	{
		super();
		this.initUI();
	}

	@Override
	public void renderComponent(Spieltag value)
	{
		// TODO Auto-generated method stub
		
	}

	/* WARNING: Do NOT edit!<br>The content of this method is always regenerated by the UI designer. */
	// <generated-code name="initUI">
	private void initUI()
	{
		this.setSizeFull();
	} // </generated-code>
	
}
