package ssdd;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;


public class MainGUI {

	protected Shell shlSelfserviceDrinkDispenser;
	Display display;
	Text accNoField;
	Text textOutput;
	Label lblDynamicBalance;
	
	Button[] drinksPlusButtons = new Button[10];
	Button[] drinksMinusButtons = new Button[10];
	Label[] drinksSelectedLabels = new Label[10];
	Button[] moneyButtons = new Button[8];
	private Controller controller;
	private Label lblInsertedMoneyVal;
	private Label lblTotalDueVal;
	private List<Item> allDrinks;
	private List<Money> allMoney;
	private Button btnInsertCard;

	
	
	public MainGUI(Controller controller){
		this.controller = controller;
		this.controller.mainGUI = this;
		allDrinks = this.controller.getDrinkStock();
		allMoney = this.controller.getMoneyStock();
		this.open();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlSelfserviceDrinkDispenser.pack();			
		shlSelfserviceDrinkDispenser.open();
		shlSelfserviceDrinkDispenser.layout();
		while (!shlSelfserviceDrinkDispenser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSelfserviceDrinkDispenser = new Shell();
		shlSelfserviceDrinkDispenser.setMinimumSize(new Point(1200, 750));
		shlSelfserviceDrinkDispenser.setSize(1200, 754);
		shlSelfserviceDrinkDispenser.setText("Self-Service Drink Dispenser");
		
		Label lblAnnounce = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAnnounce.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.NORMAL));
		lblAnnounce.setBounds(10, 10, 175, 25);
		lblAnnounce.setText("Select your drinks:");
		
		Image coke = new Image(display, "pics/coke.jpg");
		coke = new Image(display, coke.getImageData().scaledTo(140, 140));		
		Label drink1Stock = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink1Stock.setImage(coke);
		drink1Stock.setBounds(10, 62, 140, 140);
		
		Image sprite = new Image(display, "pics/sprite.jpg");
		sprite = new Image(display, sprite.getImageData().scaledTo(140, 140));		
		Label drink2Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink2Label.setImage(sprite);
		drink2Label.setBounds(160, 62, 140, 140);
		
		Image beer = new Image(display, "pics/beer.jpg");
		beer = new Image(display, beer.getImageData().scaledTo(140, 140));		
		Label drink3Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink3Label.setImage(beer);
		drink3Label.setBounds(310, 62, 140, 140);
		
		Image lightbeer = new Image(display, "pics/light beer.jpg");
		lightbeer = new Image(display, lightbeer.getImageData().scaledTo(140, 140));		
		Label drink4Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink4Label.setImage(lightbeer);
		drink4Label.setBounds(460, 62, 140, 140);
		
		Image funbeer = new Image(display, "pics/fun beer.jpg");
		funbeer = new Image(display, funbeer.getImageData().scaledTo(140, 140));		
		Label drink5Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink5Label.setImage(funbeer);
		drink5Label.setBounds(610, 62, 140, 140);
		
		Image mineralwater = new Image(display, "pics/mineral water.jpg");
		mineralwater = new Image(display, mineralwater.getImageData().scaledTo(140, 140));		
		Label drink6Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink6Label.setImage(mineralwater);
		drink6Label.setBounds(10, 297, 140, 140);
		
		Image applejuice = new Image(display, "pics/apple juice.jpg");
		applejuice = new Image(display, applejuice.getImageData().scaledTo(140, 140));		
		Label drink7Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink7Label.setImage(applejuice);
		drink7Label.setBounds(160, 297, 140, 140);
		
		Image orangejuice = new Image(display, "pics/orange juice.jpg");
		orangejuice = new Image(display, orangejuice.getImageData().scaledTo(140, 140));		
		Label drink8Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink8Label.setImage(orangejuice);
		drink8Label.setBounds(310, 297, 140, 140);
		
		Image tomatojuice = new Image(display, "pics/tomato juice.jpg");
		tomatojuice = new Image(display, tomatojuice.getImageData().scaledTo(140, 140));		
		Label drink9Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink9Label.setImage(tomatojuice);
		drink9Label.setBounds(460, 297, 140, 140);
		
		Image wine = new Image(display, "pics/wine.jpg");
		wine = new Image(display, wine.getImageData().scaledTo(140, 140));		
		Label drink10Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink10Label.setImage(wine);
		drink10Label.setBounds(610, 297, 140, 140);
		
		Label lblStock1 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock1.setBounds(10, 41, 42, 15);
		lblStock1.setText("Stock:");
		
		Label drink1StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink1StockLbl.setAlignment(SWT.RIGHT);
		drink1StockLbl.setBounds(71, 41, 42, 15);
		drink1StockLbl.setText("0");
		
		Label lblStock2 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock2.setText("Stock:");
		lblStock2.setBounds(160, 41, 42, 15);
		
		Label drink2StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2StockLbl.setText("0");
		drink2StockLbl.setAlignment(SWT.RIGHT);
		drink2StockLbl.setBounds(208, 41, 55, 15);
		
		Label lblStock3 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock3.setText("Stock:");
		lblStock3.setBounds(312, 41, 42, 15);
		
		Label drink3StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink3StockLbl.setText("0");
		drink3StockLbl.setAlignment(SWT.RIGHT);
		drink3StockLbl.setBounds(360, 41, 55, 15);
		
		Label drink4StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink4StockLbl.setText("0");
		drink4StockLbl.setAlignment(SWT.RIGHT);
		drink4StockLbl.setBounds(514, 41, 55, 15);
		
		Label drink5StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink5StockLbl.setText("0");
		drink5StockLbl.setAlignment(SWT.RIGHT);
		drink5StockLbl.setBounds(656, 41, 55, 15);
		
		Label drink6StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink6StockLbl.setText("0");
		drink6StockLbl.setAlignment(SWT.RIGHT);
		drink6StockLbl.setBounds(58, 276, 55, 15);
		
		Label drink7StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink7StockLbl.setText("0");
		drink7StockLbl.setAlignment(SWT.RIGHT);
		drink7StockLbl.setBounds(208, 276, 55, 15);
		
		Label drink8StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink8StockLbl.setText("0");
		drink8StockLbl.setAlignment(SWT.RIGHT);
		drink8StockLbl.setBounds(360, 276, 55, 15);
		
		Label drink9StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink9StockLbl.setText("0");
		drink9StockLbl.setAlignment(SWT.RIGHT);
		drink9StockLbl.setBounds(514, 276, 55, 15);
		
		Label drink10StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink10StockLbl.setText("0");
		drink10StockLbl.setAlignment(SWT.RIGHT);
		drink10StockLbl.setBounds(656, 276, 55, 15);
		
		Label lblStock6 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock6.setText("Stock:");
		lblStock6.setBounds(10, 276, 42, 15);
		
		Label lblStock7 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock7.setText("Stock:");
		lblStock7.setBounds(160, 276, 42, 15);
		
		Label lblStock8 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock8.setText("Stock:");
		lblStock8.setBounds(312, 276, 42, 15);
		
		Label lblStock9 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock9.setText("Stock:");
		lblStock9.setBounds(458, 276, 42, 15);
		
		Label lblStock10 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock10.setText("Stock:");
		lblStock10.setBounds(610, 276, 42, 15);
		
		Label lblStock5 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock5.setText("Stock:");
		lblStock5.setBounds(610, 41, 42, 15);
		
		Label lblStock4 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock4.setText("Stock:");
		lblStock4.setBounds(458, 41, 42, 15);
		
		Button drink1PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink1PlusBtn.setBounds(10, 217, 25, 25);
		drink1PlusBtn.setText("+1");
		drink1PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(0);	
			}
		});
		
		Button drink1MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink1MinusBtn.setBounds(37, 217, 25, 25);
		drink1MinusBtn.setText("-1");
		drink1MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(0);
			}
		});
		
		Label drink1SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink1SelectedLbl.setAlignment(SWT.RIGHT);
		drink1SelectedLbl.setBounds(71, 222, 42, 15);
		drink1SelectedLbl.setText("0");
		
		Label drink2SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2SelectedLbl.setText("0");
		drink2SelectedLbl.setAlignment(SWT.RIGHT);
		drink2SelectedLbl.setBounds(221, 222, 42, 15);
		
		Button drink2PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2PlusBtn.setText("+1");
		drink2PlusBtn.setBounds(160, 217, 25, 25);
		drink2PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(1);				
			}
		});
		
		Button drink2MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2MinusBtn.setText("-1");
		drink2MinusBtn.setBounds(187, 217, 25, 25);
		drink2MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(1);
			}
		});
		
		Button drink3PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink3PlusBtn.setText("+1");
		drink3PlusBtn.setBounds(310, 217, 25, 25);
		drink3PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(2);
			}
		});
		
		Button drink3MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink3MinusBtn.setText("-1");
		drink3MinusBtn.setBounds(337, 217, 25, 25);
		drink3MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(2);
			}
		});
		
		Label drink3SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink3SelectedLbl.setText("0");
		drink3SelectedLbl.setAlignment(SWT.RIGHT);
		drink3SelectedLbl.setBounds(373, 222, 42, 15);
		
		Button drink4PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink4PlusBtn.setText("+1");
		drink4PlusBtn.setBounds(460, 217, 25, 25);
		drink4PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(3);	
			}
		});
		
		Button drink4MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink4MinusBtn.setText("-1");
		drink4MinusBtn.setBounds(487, 217, 25, 25);
		drink4MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(3);
			}
		});
		
		Label drink4SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink4SelectedLbl.setText("0");
		drink4SelectedLbl.setAlignment(SWT.RIGHT);
		drink4SelectedLbl.setBounds(527, 222, 42, 15);
		
		Button drink5PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink5PlusBtn.setText("+1");
		drink5PlusBtn.setBounds(610, 217, 25, 25);
		drink5PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(4);
			}
		});
		
		Button drink5MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink5MinusBtn.setText("-1");
		drink5MinusBtn.setBounds(637, 217, 25, 25);
		drink5MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(4);
			}
		});
		
		Label drink5SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink5SelectedLbl.setText("0");
		drink5SelectedLbl.setAlignment(SWT.RIGHT);
		drink5SelectedLbl.setBounds(669, 222, 42, 15);
		
		Button drink6PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink6PlusBtn.setText("+1");
		drink6PlusBtn.setBounds(10, 453, 25, 25);
		drink6PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(5);
			}
		});
		
		Button drink6MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink6MinusBtn.setText("-1");
		drink6MinusBtn.setBounds(37, 453, 25, 25);
		drink6MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(5);
			}
		});
		
		Label drink6SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink6SelectedLbl.setText("0");
		drink6SelectedLbl.setAlignment(SWT.RIGHT);
		drink6SelectedLbl.setBounds(71, 458, 42, 15);
		
		Button drink7PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink7PlusBtn.setText("+1");
		drink7PlusBtn.setBounds(157, 453, 25, 25);
		drink7PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(6);	
			}
		});
		
		Button drink7MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink7MinusBtn.setText("-1");
		drink7MinusBtn.setBounds(187, 453, 25, 25);
		drink7MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(6);
			}
		});
		
		Label drink7SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink7SelectedLbl.setText("0");
		drink7SelectedLbl.setAlignment(SWT.RIGHT);
		drink7SelectedLbl.setBounds(221, 458, 42, 15);
		
		Button drink8PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink8PlusBtn.setText("+1");
		drink8PlusBtn.setBounds(310, 453, 25, 25);
		drink8PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(7);	
			}
		});
		
		Button drink8MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink8MinusBtn.setText("-1");
		drink8MinusBtn.setBounds(337, 453, 25, 25);
		drink8MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(7);
			}
		});
		
		Label drink8SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink8SelectedLbl.setText("0");
		drink8SelectedLbl.setAlignment(SWT.RIGHT);
		drink8SelectedLbl.setBounds(373, 458, 42, 15);
		
		Button drink9PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink9PlusBtn.setText("+1");
		drink9PlusBtn.setBounds(460, 453, 25, 25);
		drink9PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(8);
			}
		});
		
		Button drink9MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink9MinusBtn.setText("-1");
		drink9MinusBtn.setBounds(487, 453, 25, 25);
		drink9MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(8);
			}
		});
		
		Label drink9SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink9SelectedLbl.setText("0");
		drink9SelectedLbl.setAlignment(SWT.RIGHT);
		drink9SelectedLbl.setBounds(527, 458, 42, 15);
		
		Button drink10PlusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink10PlusBtn.setText("+1");
		drink10PlusBtn.setBounds(610, 453, 25, 25);
		drink10PlusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressAddDrink(9);	
			}
		});
		
		Button drink10MinusBtn = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink10MinusBtn.setText("-1");
		drink10MinusBtn.setBounds(637, 453, 25, 25);
		drink10MinusBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressRemoveDrink(9);
			}
		});
		
		Label drink10SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink10SelectedLbl.setText("0");
		drink10SelectedLbl.setAlignment(SWT.RIGHT);
		drink10SelectedLbl.setBounds(669, 458, 42, 15);	

		Label lblPayByMoney = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPayByMoney.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPayByMoney.setBounds(74, 498, 86, 15);
		lblPayByMoney.setText("Pay By Money");
		
		Button btnMoney1 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney1.setBounds(37, 519, 75, 25);
		btnMoney1.setText("10c");
		btnMoney1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(0);
			}
		});
		
		Button btnMoney2 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney2.setBounds(37, 550, 75, 25);
		btnMoney2.setText("20c");
		btnMoney2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(1);
			}
		});
		
		Button btnMoney3 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney3.setBounds(37, 581, 75, 25);
		btnMoney3.setText("50c");
		btnMoney3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(2);
			}
		});
		
		Button btnMoney4 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney4.setBounds(37, 612, 75, 25);
		btnMoney4.setText("1 Euro");
		btnMoney4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(3);
			}
		});
		
		Button btnMoney5 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney5.setBounds(118, 519, 75, 25);
		btnMoney5.setText("2 Euro");
		btnMoney5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(4);
			}
		});
		
		Button btnMoney6 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney6.setBounds(118, 550, 75, 25);
		btnMoney6.setText("5 Euro");
		btnMoney6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(5);
			}
		});
		
		Button btnMoney7 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney7.setBounds(118, 581, 75, 25);
		btnMoney7.setText("10 Euro");
		btnMoney7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(6);
			}
		});
		
		Button btnMoney8 = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnMoney8.setBounds(118, 612, 75, 25);
		btnMoney8.setText("20 Euro");
		btnMoney8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(7);
			}
		});
		
		Button btnCancel = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnCancel.setBounds(81, 643, 75, 25);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressCancelButton();
			}
		});
		
		Label lblTotalDueText = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblTotalDueText.setBounds(221, 550, 86, 15);
		lblTotalDueText.setText("Total Due :");
		
		Label lblInsertedMoney = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblInsertedMoney.setBounds(221, 576, 90, 15);
		lblInsertedMoney.setText("Inserted Money :");
		
		lblTotalDueVal = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblTotalDueVal.setAlignment(SWT.RIGHT);
		lblTotalDueVal.setBounds(326, 550, 65, 15);
		lblTotalDueVal.setText("10.00 Euro");
		
		lblInsertedMoneyVal = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblInsertedMoneyVal.setAlignment(SWT.RIGHT);
		lblInsertedMoneyVal.setBounds(326, 576, 65, 15);
		lblInsertedMoneyVal.setText("0.00 Euro");
		
		Label lblPayByCard = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPayByCard.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPayByCard.setBounds(597, 498, 65, 15);
		lblPayByCard.setText("Pay By Card");
		
		Label lblAccountNo = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAccountNo.setBounds(494, 541, 75, 15);
		lblAccountNo.setText("Account No.:");
		
		accNoField = new Text(shlSelfserviceDrinkDispenser, SWT.BORDER);
		accNoField.setBounds(578, 538, 110, 21);
		accNoField.addListener(SWT.KeyDown, new Listener(){

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				btnInsertCard.setEnabled(false);
			}
			
			
		});
		
		Button magicButton = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		magicButton.setBounds(694, 536, 55, 25);
		magicButton.setText("Magic");
		magicButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				pressMagicButton();
			}
		});
		
		Label lblCardBalance = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblCardBalance.setBounds(494, 576, 86, 15);
		lblCardBalance.setText("Card Balance:");
		
		lblDynamicBalance = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblDynamicBalance.setAlignment(SWT.RIGHT);
		lblDynamicBalance.setBounds(578, 576, 172, 15);
		lblDynamicBalance.setText("Click \"Magic\" to find out!");
		
		btnInsertCard = new Button(shlSelfserviceDrinkDispenser, SWT.NONE);
		btnInsertCard.setBounds(597, 612, 75, 25);
		btnInsertCard.setText("Insert Card");
		btnInsertCard.setEnabled(false);
		btnInsertCard.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				pressInsertCardButton();
			}
		});
		
		textOutput = new Text(shlSelfserviceDrinkDispenser, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		textOutput.setBackground(SWTResourceManager.getColor(255, 255, 255));
		textOutput.setBounds(790, 60, 357, 624);
		
		Label lblOutput = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblOutput.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.BOLD));
		lblOutput.setBounds(790, 10, 95, 25);
		lblOutput.setText("Output:");		
		
		drinksPlusButtons[0] = drink1PlusBtn; drinksPlusButtons[1] = drink2PlusBtn; drinksPlusButtons[2] = drink3PlusBtn; drinksPlusButtons[3] = drink4PlusBtn;
		drinksPlusButtons[4] = drink5PlusBtn; drinksPlusButtons[5] = drink6PlusBtn; drinksPlusButtons[6] = drink7PlusBtn; drinksPlusButtons[7] = drink8PlusBtn;
		drinksPlusButtons[8] = drink9PlusBtn; drinksPlusButtons[9] = drink10PlusBtn;
		
		drinksMinusButtons[0] = drink1MinusBtn; drinksMinusButtons[1] = drink2MinusBtn; drinksMinusButtons[2] = drink3MinusBtn; drinksMinusButtons[3] = drink4MinusBtn;
		drinksMinusButtons[4] = drink5MinusBtn; drinksMinusButtons[5] = drink6MinusBtn; drinksMinusButtons[6] = drink7MinusBtn; drinksMinusButtons[7] = drink8MinusBtn;
		drinksMinusButtons[8] = drink9MinusBtn; drinksMinusButtons[9] = drink10MinusBtn;
		
		drinksSelectedLabels[0] = drink1SelectedLbl; drinksSelectedLabels[1] = drink2SelectedLbl; drinksSelectedLabels[2] = drink3SelectedLbl; drinksSelectedLabels[3] = drink4SelectedLbl;
		drinksSelectedLabels[4] = drink5SelectedLbl; drinksSelectedLabels[5] = drink6SelectedLbl; drinksSelectedLabels[6] = drink7SelectedLbl; drinksSelectedLabels[7] = drink8SelectedLbl;
		drinksSelectedLabels[8] = drink9SelectedLbl; drinksSelectedLabels[9] = drink10SelectedLbl;
		
		moneyButtons[0] = btnMoney1; moneyButtons[1] = btnMoney2; moneyButtons[2] = btnMoney3; moneyButtons[3] = btnMoney4;
		moneyButtons[4] = btnMoney5; moneyButtons[5] = btnMoney6; moneyButtons[6] = btnMoney7; moneyButtons[7] = btnMoney8;
		
	}
	
	public void pressAddDrink(int drinkIndex)
	{
		controller.addDrink(drinkIndex);
	}
	public void pressRemoveDrink(int drinkIndex)
	{
		controller.removeDrink(drinkIndex);
	}
	public void updateSelectedDrink(int drinkIndex, int newQuantity)
	{
		drinksSelectedLabels[drinkIndex].setText(Integer.toString(newQuantity));
	}
	public void updateTotalDue(double newDue)
	{
		NumberFormat formatter = new DecimalFormat("#0.00");     
		lblTotalDueVal.setText(formatter.format(newDue) + " Euro");
	}
	public void updateInsertedMoney(double totalInserted){
		NumberFormat formatter = new DecimalFormat("#0.00");     
		lblInsertedMoneyVal.setText(formatter.format(totalInserted) + " Euro");
	}
	public void pressMoneyButton(int moneyIndex)
	{
		controller.insertMoney(moneyIndex);
	}
	public void pressMagicButton(){
		if(accNoField.getText().isEmpty() || accNoField.getText().length() < 4){
			MessageBox messageBox = new MessageBox(shlSelfserviceDrinkDispenser, SWT.ICON_WARNING);
	        
	        messageBox.setText("Warning");
	        messageBox.setMessage("Account number must be at least 4 digits!");
	        messageBox.open();
		}
		else{
			long accNo;
			try{
				accNo = Long.parseLong(accNoField.getText());
			}
			catch(Exception e){
				MessageBox messageBox = new MessageBox(shlSelfserviceDrinkDispenser, SWT.ICON_WARNING);
		        
		        messageBox.setText("Warning");
		        messageBox.setMessage("Numbers Only!");
		        messageBox.open();
		        return;
			}
			double balance = controller.doMagic(accNo);
			NumberFormat formatter = new DecimalFormat("#0.00");     
			lblDynamicBalance.setText(formatter.format(balance) + " Euro");
			btnInsertCard.setEnabled(true);
			
		}
	}
	public void showFinishedOutput(String output)
	{
		
	}
	public void setAccountBalance(double balance)
	{
		
	}
	public void pressInsertCardButton()
	{		 
		controller.insertCard(Long.parseLong(accNoField.getText()));
	}
	public void pressCancelButton()
	{
		controller.cancelOrder();
	}

	public void outputText(String output) {
		this.textOutput.setText(output);
	}
}
