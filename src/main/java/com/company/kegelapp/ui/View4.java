
package com.company.kegelapp.ui;

import java.time.LocalDate;
import java.util.Set;

import com.company.kegelapp.dal.SpieltagDAO;
import com.company.kegelapp.domain.Spieler;
import com.company.kegelapp.domain.Spieltag;
import com.company.kegelapp.domain.Strafe;
import com.flowingcode.vaadin.addons.ironicons.DeviceIcons;
import com.rapidclipse.framework.server.navigation.NavigationIconDevice;
import com.rapidclipse.framework.server.navigation.NavigationItemProperties;
import com.rapidclipse.framework.server.resources.CaptionUtils;
import com.rapidclipse.framework.server.ui.ItemLabelGeneratorFactory;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;


@NavigationItemProperties(category = "category 2", displayName = "View 4")
@NavigationIconDevice(DeviceIcons.BATTERY_CHARGING_80)

@Route(value = "view4", layout = MainContainer.class)
@HtmlImport("frontend://styles/shared-styles.html")
public class View4 extends VerticalLayout
{

	Set<Spieler> ausgewaehlteSpieler = null;
	Set<Strafe>  ausgewaehlteStrafe  = null;
	Spieltag     spieltag            = null;
	
	public View4()
	{
		super();
		this.initUI();
		this.spieltag = SpieltagDAO.findCurrent(LocalDate.now());
		this.multiSelectListBox2.setItems(this.spieltag.getSpieltagMap().keySet());
		this.multiSelectListBox
			.setItems(
				this.spieltag.getSpieltagMap().get(this.spieltag.getSpieltagMap().keySet().iterator().next()).keySet());
	}
	
	/**
	 * Event handler delegate method for the {@link Button} {@link #button5}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button5_onClick(final ClickEvent<Button> event)
	{
		for(final Spieler spieler : this.ausgewaehlteSpieler)
		{
			for(final Strafe strafe : this.ausgewaehlteStrafe)
			{
				System.out.println("Gehe rein mit Strafe und Spieler " + strafe + "<>" + spieler);
				final Integer anzahlStrafen =
					this.spieltag.getSpieltagMap().get(spieler).get(strafe);

				this.spieltag.getSpieltagMap().get(spieler).put(strafe, anzahlStrafen + 1);
				System.out.println(this.spieltag);
			}
		}
	}

	/**
	 * Event handler delegate method for the {@link MultiSelectListBox} {@link #multiSelectListBox}.
	 *
	 * @see HasValue.ValueChangeListener#valueChanged(HasValue.ValueChangeEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void
		multiSelectListBox_valueChanged(final ComponentValueChangeEvent<MultiSelectListBox<Strafe>, Set<Strafe>> event)
	{
		this.ausgewaehlteStrafe = event.getValue();
	}

	/**
	 * Event handler delegate method for the {@link MultiSelectListBox} {@link #multiSelectListBox2}.
	 *
	 * @see HasValue.ValueChangeListener#valueChanged(HasValue.ValueChangeEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void
		multiSelectListBox2_valueChanged(
			final ComponentValueChangeEvent<MultiSelectListBox<Spieler>, Set<Spieler>> event)
	{
		this.ausgewaehlteSpieler = event.getValue();
	}

	/* WARNING: Do NOT edit!<br>The content of this method is always regenerated by the UI designer. */
	// <generated-code name="initUI">
	private void initUI()
	{
		this.lblContent          = new Label();
		this.horizontalLayout    = new HorizontalLayout();
		this.button              = new Button();
		this.button2             = new Button();
		this.button3             = new Button();
		this.button4             = new Button();
		this.horizontalLayout2   = new HorizontalLayout();
		this.multiSelectListBox2 = new MultiSelectListBox<>();
		this.multiSelectListBox  = new MultiSelectListBox<>();
		this.verticalLayout      = new VerticalLayout();
		this.button5             = new Button();
		this.button6             = new Button();
		this.button7             = new Button();
		this.button8             = new Button();
		
		this.setClassName("my-view my-view4");
		this.getStyle().set("overflow-x", "hidden");
		this.getStyle().set("overflow-y", "auto");
		this.lblContent.setText("KEGELN");
		this.lblContent.getStyle().set("font-size", "2em");
		this.button.setText("Teamspiel");
		this.button2.setText("Spieler Hinzufügen");
		this.button3.setMinHeight("");
		this.button3.setMaxHeight("");
		this.button3.setText("Spiel Ende");
		this.button3.setMaxWidth("");
		this.button4.setText("PLACEHOLDER");
		this.multiSelectListBox2.setRenderer(new TextRenderer<>(
			ItemLabelGeneratorFactory.NonNull(v -> CaptionUtils.resolveCaption(v, "{%name}+ \" \" +{%nachName}"))));
		this.multiSelectListBox.setRenderer(new TextRenderer<>(ItemLabelGeneratorFactory.NonNull(Strafe::getName)));
		this.button5.setText("+ 1");
		this.button6.setText("+5");
		this.button7.setText("-1");
		this.button8.setText("-5");
		
		this.button.setSizeUndefined();
		this.button2.setSizeUndefined();
		this.button3.setSizeUndefined();
		this.button4.setSizeUndefined();
		this.horizontalLayout.add(this.button, this.button2, this.button3, this.button4);
		this.horizontalLayout.setVerticalComponentAlignment(FlexComponent.Alignment.START, this.button);
		this.horizontalLayout.setVerticalComponentAlignment(FlexComponent.Alignment.STRETCH, this.button3);
		this.button5.setSizeUndefined();
		this.button6.setSizeUndefined();
		this.button7.setSizeUndefined();
		this.button8.setSizeUndefined();
		this.verticalLayout.add(this.button5, this.button6, this.button7, this.button8);
		this.multiSelectListBox2.setSizeUndefined();
		this.multiSelectListBox.setSizeUndefined();
		this.verticalLayout.setWidth("100px");
		this.verticalLayout.setHeight("100px");
		this.horizontalLayout2.add(this.multiSelectListBox2, this.multiSelectListBox, this.verticalLayout);
		this.lblContent.setSizeUndefined();
		this.horizontalLayout.setWidth(null);
		this.horizontalLayout.setHeight("100px");
		this.horizontalLayout2.setSizeUndefined();
		this.add(this.lblContent, this.horizontalLayout, this.horizontalLayout2);
		this.setSizeFull();
		
		this.multiSelectListBox2.addValueChangeListener(this::multiSelectListBox2_valueChanged);
		this.multiSelectListBox.addValueChangeListener(this::multiSelectListBox_valueChanged);
		this.button5.addClickListener(this::button5_onClick);
	} // </generated-code>

	// <generated-code name="variables">
	private Button                      button, button2, button3, button4, button5, button6, button7, button8;
	private HorizontalLayout            horizontalLayout, horizontalLayout2;
	private VerticalLayout              verticalLayout;
	private Label                       lblContent;
	private MultiSelectListBox<Spieler> multiSelectListBox2;
	private MultiSelectListBox<Strafe>  multiSelectListBox;
	// </generated-code>

}
