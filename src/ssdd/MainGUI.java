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
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;


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
	Label[] drinksStockLabels = new Label[10];
			
	private Controller controller;
	private Label lblInsertedMoneyVal;
	private Label lblTotalDueVal;
	private List<Item> allDrinks;
	private List<Money> allMoney;
	Button btnInsertCard;
		
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
		
		allMoney = this.controller.getMoneyStock();
		
		Label lblAnnounce = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAnnounce.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.NORMAL));
		lblAnnounce.setBounds(10, 10, 175, 25);
		lblAnnounce.setText("Select your drinks:");
		
		Image coke = new Image(display, "pics/1.jpg");
		coke = new Image(display, coke.getImageData().scaledTo(140, 140));		
		Label drink1Stock = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink1Stock.setImage(coke);
		drink1Stock.setBounds(10, 62, 140, 140);
		
		Image sprite = new Image(display, "pics/2.jpg");
		sprite = new Image(display, sprite.getImageData().scaledTo(140, 140));		
		Label drink2Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink2Label.setImage(sprite);
		drink2Label.setBounds(160, 62, 140, 140);
		
		Image beer = new Image(display, "pics/3.jpg");
		beer = new Image(display, beer.getImageData().scaledTo(140, 140));		
		Label drink3Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink3Label.setImage(beer);
		drink3Label.setBounds(310, 62, 140, 140);
		
		Image lightbeer = new Image(display, "pics/4.jpg");
		lightbeer = new Image(display, lightbeer.getImageData().scaledTo(140, 140));		
		Label drink4Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink4Label.setImage(lightbeer);
		drink4Label.setBounds(460, 62, 140, 140);
		
		Image funbeer = new Image(display, "pics/5.jpg");
		funbeer = new Image(display, funbeer.getImageData().scaledTo(140, 140));		
		Label drink5Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink5Label.setImage(funbeer);
		drink5Label.setBounds(610, 62, 140, 140);
		
		Image mineralwater = new Image(display, "pics/6.jpg");
		mineralwater = new Image(display, mineralwater.getImageData().scaledTo(140, 140));		
		Label drink6Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink6Label.setImage(mineralwater);
		drink6Label.setBounds(10, 297, 140, 140);
		
		Image applejuice = new Image(display, "pics/7.jpg");
		applejuice = new Image(display, applejuice.getImageData().scaledTo(140, 140));		
		Label drink7Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink7Label.setImage(applejuice);
		drink7Label.setBounds(160, 297, 140, 140);
		
		Image orangejuice = new Image(display, "pics/8.jpg");
		orangejuice = new Image(display, orangejuice.getImageData().scaledTo(140, 140));		
		Label drink8Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink8Label.setImage(orangejuice);
		drink8Label.setBounds(310, 297, 140, 140);
		
		Image tomatojuice = new Image(display, "pics/9.jpg");
		tomatojuice = new Image(display, tomatojuice.getImageData().scaledTo(140, 140));		
		Label drink9Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink9Label.setImage(tomatojuice);
		drink9Label.setBounds(460, 297, 140, 140);
		
		Image wine = new Image(display, "pics/10.jpg");
		wine = new Image(display, wine.getImageData().scaledTo(140, 140));		
		Label drink10Label = new Label(shlSelfserviceDrinkDispenser, SWT.BORDER);
		drink10Label.setImage(wine);
		drink10Label.setBounds(610, 297, 140, 140);		
		
		Label lblPrice1 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice1.setBounds(10, 41, 30, 15);
		lblPrice1.setText("Price:");
		
		Label lblPrice2 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice2.setText("Price:");
		lblPrice2.setBounds(160, 41, 30, 15);

		Label lblPrice3 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice3.setText("Price:");
		lblPrice3.setBounds(310, 41, 30, 15);
		
		Label lblPrice4 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice4.setText("Price:");
		lblPrice4.setBounds(460, 41, 30, 15);
		
		Label lblPrice5 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice5.setText("Price:");
		lblPrice5.setBounds(610, 41, 30, 15);
		
		Label lblPrice6 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice6.setText("Price:");
		lblPrice6.setBounds(10, 276, 30, 15);
		
		Label lblPrice7 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice7.setText("Price:");
		lblPrice7.setBounds(160, 276, 30, 15);
		
		Label lblPrice8 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice8.setText("Price:");
		lblPrice8.setBounds(310, 276, 30, 15);
		
		Label lblPrice9 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice9.setText("Price:");
		lblPrice9.setBounds(460, 276, 30, 15);
		
		Label lblPrice10 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblPrice10.setText("Price:");
		lblPrice10.setBounds(610, 276, 30, 15);
		
		Label drink1Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink1Price.setAlignment(SWT.RIGHT);
		drink1Price.setText(String.valueOf(controller.getDrinkStock().get(1).getValue()));
		drink1Price.setBounds(42, 41, 35, 15);					
		
		Label drink2Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2Price.setAlignment(SWT.RIGHT);
		drink2Price.setText("0");
		drink2Price.setBounds(192, 41, 35, 15);
		
		Label drink3Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink3Price.setText("0");
		drink3Price.setAlignment(SWT.RIGHT);
		drink3Price.setBounds(342, 41, 35, 15);
		
		Label drink4Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink4Price.setText("0");
		drink4Price.setAlignment(SWT.RIGHT);
		drink4Price.setBounds(492, 41, 35, 15);
		
		Label drink5Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink5Price.setText("0");
		drink5Price.setAlignment(SWT.RIGHT);
		drink5Price.setBounds(642, 41, 35, 15);
		
		Label drink6Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink6Price.setText("0");
		drink6Price.setAlignment(SWT.RIGHT);
		drink6Price.setBounds(42, 276, 35, 15);
		
		Label drink7Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink7Price.setText("0");
		drink7Price.setAlignment(SWT.RIGHT);
		drink7Price.setBounds(192, 276, 35, 15);
		
		Label drink8Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink8Price.setText("0");
		drink8Price.setAlignment(SWT.RIGHT);
		drink8Price.setBounds(342, 276, 35, 15);
		
		Label drink9Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink9Price.setText("0");
		drink9Price.setAlignment(SWT.RIGHT);
		drink9Price.setBounds(492, 276, 35, 15);
		
		Label drink10Price = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink10Price.setText("0");
		drink10Price.setAlignment(SWT.RIGHT);
		drink10Price.setBounds(642, 276, 35, 15);
		
		Label lblAdded1 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded1.setAlignment(SWT.RIGHT);
		lblAdded1.setBounds(81, 222, 42, 15);
		lblAdded1.setText("Added:");
		
		Label lblAdded2 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded2.setAlignment(SWT.RIGHT);
		lblAdded2.setText("Added:");
		lblAdded2.setBounds(230, 222, 42, 15);		
		
		Label lblAdded3 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded3.setAlignment(SWT.RIGHT);
		lblAdded3.setText("Added:");
		lblAdded3.setBounds(380, 222, 42, 15);
		
		Label lblAdded4 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded4.setAlignment(SWT.RIGHT);
		lblAdded4.setText("Added:");
		lblAdded4.setBounds(530, 222, 42, 15);
		
		Label lblAdded5 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded5.setAlignment(SWT.RIGHT);
		lblAdded5.setText("Added:");
		lblAdded5.setBounds(680, 222, 42, 15);		
	
		Label lblAdded8 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded8.setAlignment(SWT.RIGHT);
		lblAdded8.setText("Added:");
		lblAdded8.setBounds(380, 458, 42, 15);
		
		Label lblAdded7 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded7.setAlignment(SWT.RIGHT);
		lblAdded7.setText("Added:");
		lblAdded7.setBounds(230, 458, 42, 15);
		
		Label lblAdded6 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded6.setAlignment(SWT.RIGHT);
		lblAdded6.setText("Added:");
		lblAdded6.setBounds(81, 458, 42, 15);
		
		Label lblAdded9 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded9.setAlignment(SWT.RIGHT);
		lblAdded9.setText("Added:");
		lblAdded9.setBounds(530, 458, 42, 15);
		
		Label lblAdded10 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblAdded10.setAlignment(SWT.RIGHT);
		lblAdded10.setText("Added:");
		lblAdded10.setBounds(682, 458, 42, 15);
				
		Label lblStock1 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock1.setAlignment(SWT.RIGHT);
		lblStock1.setBounds(83, 41, 40, 15);
		lblStock1.setText("Stock:");
		
		Label drink1StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink1StockLbl.setAlignment(SWT.RIGHT);
		drink1StockLbl.setBounds(125, 41, 25, 15);
		drink1StockLbl.setText("0");
		
		Label lblStock2 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock2.setAlignment(SWT.RIGHT);
		lblStock2.setText("Stock:");
		lblStock2.setBounds(232, 41, 40, 15);
		
		Label drink2StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2StockLbl.setText("0");
		drink2StockLbl.setAlignment(SWT.RIGHT);
		drink2StockLbl.setBounds(275, 41, 25, 15);
		
		Label lblStock3 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock3.setAlignment(SWT.RIGHT);
		lblStock3.setText("Stock:");
		lblStock3.setBounds(382, 41, 40, 15);
		
		Label drink3StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink3StockLbl.setText("0");
		drink3StockLbl.setAlignment(SWT.RIGHT);
		drink3StockLbl.setBounds(425, 41, 25, 15);
		
		Label drink4StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink4StockLbl.setText("0");
		drink4StockLbl.setAlignment(SWT.RIGHT);
		drink4StockLbl.setBounds(575, 41, 25, 15);
		
		Label drink5StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink5StockLbl.setText("0");
		drink5StockLbl.setAlignment(SWT.RIGHT);
		drink5StockLbl.setBounds(725, 41, 25, 15);
		
		Label drink6StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink6StockLbl.setText("0");
		drink6StockLbl.setAlignment(SWT.RIGHT);
		drink6StockLbl.setBounds(125, 276, 25, 15);
		
		Label drink7StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink7StockLbl.setText("0");
		drink7StockLbl.setAlignment(SWT.RIGHT);
		drink7StockLbl.setBounds(275, 276, 25, 15);
		
		Label drink8StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink8StockLbl.setText("0");
		drink8StockLbl.setAlignment(SWT.RIGHT);
		drink8StockLbl.setBounds(425, 276, 25, 15);
		
		Label drink9StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink9StockLbl.setText("0");
		drink9StockLbl.setAlignment(SWT.RIGHT);
		drink9StockLbl.setBounds(575, 276, 25, 15);
		
		Label drink10StockLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink10StockLbl.setText("0");
		drink10StockLbl.setAlignment(SWT.RIGHT);
		drink10StockLbl.setBounds(725, 276, 25, 15);
		
		Label lblStock6 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock6.setAlignment(SWT.RIGHT);
		lblStock6.setText("Stock:");
		lblStock6.setBounds(83, 276, 40, 15);
		
		Label lblStock7 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock7.setAlignment(SWT.RIGHT);
		lblStock7.setText("Stock:");
		lblStock7.setBounds(232, 276, 40, 15);
		
		Label lblStock8 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock8.setAlignment(SWT.RIGHT);
		lblStock8.setText("Stock:");
		lblStock8.setBounds(382, 276, 40, 15);
		
		Label lblStock9 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock9.setAlignment(SWT.RIGHT);
		lblStock9.setText("Stock:");
		lblStock9.setBounds(532, 276, 40, 15);
		
		Label lblStock10 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock10.setAlignment(SWT.RIGHT);
		lblStock10.setText("Stock:");
		lblStock10.setBounds(682, 276, 42, 15);
		
		Label lblStock5 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock5.setAlignment(SWT.RIGHT);
		lblStock5.setText("Stock:");
		lblStock5.setBounds(682, 41, 40, 15);
		
		Label lblStock4 = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblStock4.setAlignment(SWT.RIGHT);
		lblStock4.setText("Stock:");
		lblStock4.setBounds(532, 41, 40, 15);
		
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
		drink1SelectedLbl.setBounds(125, 222, 25, 15);
		drink1SelectedLbl.setText("0");
		
		Label drink2SelectedLbl = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		drink2SelectedLbl.setText("0");
		drink2SelectedLbl.setAlignment(SWT.RIGHT);
		drink2SelectedLbl.setBounds(275, 222, 25, 15);
		
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
		drink3SelectedLbl.setBounds(425, 222, 25, 15);
		
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
		drink4SelectedLbl.setBounds(575, 222, 25, 15);
		
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
		drink5SelectedLbl.setBounds(725, 222, 25, 15);
		
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
		drink6SelectedLbl.setBounds(125, 458, 25, 15);
		
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
		drink7SelectedLbl.setBounds(275, 458, 25, 15);
		
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
		drink8SelectedLbl.setBounds(425, 458, 25, 15);
		
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
		drink9SelectedLbl.setBounds(575, 458, 25, 15);
		
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
		drink10SelectedLbl.setBounds(725, 458, 25, 15);	
		
		Group grpPayWithMoney = new Group(shlSelfserviceDrinkDispenser, SWT.NONE);
		grpPayWithMoney.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD | SWT.ITALIC));
		grpPayWithMoney.setText("Pay with Money");
		grpPayWithMoney.setBounds(10, 498, 412, 204);
				
		Button btnMoney1 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney1.setBounds(14, 43, 75, 25);
		btnMoney1.setText(allMoney.get(0).getName());
		btnMoney1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(0);
			}
		});
		
		moneyButtons[0] = btnMoney1; 
		
		Button btnMoney2 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney2.setBounds(14, 74, 75, 25);
		btnMoney2.setText(allMoney.get(1).getName());
		btnMoney2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(1);
			}
		});
		moneyButtons[1] = btnMoney2; 
		
		Button btnMoney3 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney3.setBounds(14, 105, 75, 25);
		btnMoney3.setText(allMoney.get(2).getName());
		btnMoney3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(2);
			}
		});
		moneyButtons[2] = btnMoney3; 
		
		Button btnMoney4 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney4.setBounds(14, 136, 75, 25);
		btnMoney4.setText(allMoney.get(3).getName());
		btnMoney4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(3);
			}
		});
		moneyButtons[3] = btnMoney4;
		
		Button btnMoney5 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney5.setBounds(95, 43, 75, 25);
		btnMoney5.setText(allMoney.get(4).getName());
		btnMoney5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(4);
			}
		});
		moneyButtons[4] = btnMoney5; 
		
		Button btnMoney6 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney6.setBounds(95, 74, 75, 25);
		btnMoney6.setText(allMoney.get(5).getName());
		btnMoney6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(5);
			}
		});
		moneyButtons[5] = btnMoney6; 
		
		Button btnMoney7 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney7.setBounds(95, 105, 75, 25);
		btnMoney7.setText(allMoney.get(6).getName());
		btnMoney7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(6);
			}
		});
		moneyButtons[6] = btnMoney7; 
		
		Button btnMoney8 = new Button(grpPayWithMoney, SWT.NONE);
		btnMoney8.setBounds(95, 136, 75, 25);
		btnMoney8.setText(allMoney.get(7).getName());
		btnMoney8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressMoneyButton(7);
			}
		});
		moneyButtons[7] = btnMoney8;
		
		Button btnCancel = new Button(grpPayWithMoney, SWT.NONE);
		btnCancel.setBounds(53, 169, 75, 25);
		btnCancel.setText("Cancel");
		
		Label lblTotalDueText = new Label(grpPayWithMoney, SWT.NONE);
		lblTotalDueText.setBounds(198, 79, 86, 15);
		lblTotalDueText.setText("Total Due :");
		
		Label lblInsertedMoney = new Label(grpPayWithMoney, SWT.NONE);
		lblInsertedMoney.setBounds(198, 110, 90, 15);
		lblInsertedMoney.setText("Inserted Money :");
		
		lblTotalDueVal = new Label(grpPayWithMoney, SWT.NONE);
		lblTotalDueVal.setBounds(303, 79, 65, 15);
		lblTotalDueVal.setAlignment(SWT.RIGHT);
		lblTotalDueVal.setText("0.00 Euro");
		
		lblInsertedMoneyVal = new Label(grpPayWithMoney, SWT.NONE);
		lblInsertedMoneyVal.setBounds(303, 110, 65, 15);
		lblInsertedMoneyVal.setAlignment(SWT.RIGHT);
		lblInsertedMoneyVal.setText("0.00 Euro");
		
		Group grpPayWithCard = new Group(shlSelfserviceDrinkDispenser, SWT.NONE);
		grpPayWithCard.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD | SWT.ITALIC));
		grpPayWithCard.setText("Pay with Card");
		grpPayWithCard.setBounds(433, 498, 317, 204);
		
		accNoField = new Text(grpPayWithCard, SWT.BORDER);
		accNoField.setBounds(120, 76, 110, 21);
		
		Button magicButton = new Button(grpPayWithCard, SWT.NONE);
		magicButton.setBounds(236, 74, 56, 25);
		magicButton.setText("Magic");
		
		lblDynamicBalance = new Label(grpPayWithCard, SWT.NONE);
		lblDynamicBalance.setBounds(120, 110, 172, 15);
		lblDynamicBalance.setAlignment(SWT.RIGHT);
		lblDynamicBalance.setText("Click \"Magic\" to find out!");
		
		btnInsertCard = new Button(grpPayWithCard, SWT.NONE);
		btnInsertCard.setBounds(137, 169, 75, 25);
		btnInsertCard.setText("Insert Card");
		btnInsertCard.setEnabled(false);
		
		Label lblCardBalance = new Label(grpPayWithCard, SWT.NONE);
		lblCardBalance.setBounds(36, 110, 86, 15);
		lblCardBalance.setText("Card Balance :");
		
		Label lblAccountNo = new Label(grpPayWithCard, SWT.NONE);
		lblAccountNo.setBounds(36, 79, 75, 15);
		lblAccountNo.setText("Account No. :");
		btnInsertCard.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				pressInsertCardButton();
			}
		});
		magicButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				pressMagicButton();
			}
		});
		accNoField.addListener(SWT.KeyDown, new Listener(){

			@Override
			public void handleEvent(Event event) {
				btnInsertCard.setEnabled(false);
			}			
		});
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pressCancelButton();
			}
		});
		
		textOutput = new Text(shlSelfserviceDrinkDispenser, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		textOutput.setBackground(SWTResourceManager.getColor(255, 255, 255));
		textOutput.setBounds(790, 60, 357, 624);
		
		Label lblOutput = new Label(shlSelfserviceDrinkDispenser, SWT.NONE);
		lblOutput.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 14, SWT.BOLD));
		lblOutput.setBounds(790, 10, 95, 25);
		lblOutput.setText("Output:");		
		
		Label[] priceLabels = new Label[10];
		priceLabels[0] = drink1Price; priceLabels[1] = drink2Price; priceLabels[2] = drink3Price; priceLabels[3] = drink4Price;
		priceLabels[4] = drink5Price; priceLabels[5] = drink6Price; priceLabels[6] = drink7Price; priceLabels[7] = drink8Price; 
		priceLabels[8] = drink9Price; priceLabels[9] = drink10Price; 
		
		for (int count = 0; count < 10; count++)
			priceLabels[count].setText(String.valueOf(controller.getDrinkStock().get(count).getValue()));		
		
		drinksStockLabels[0] = drink1StockLbl; drinksStockLabels[1] = drink2StockLbl; drinksStockLabels[2] = drink3StockLbl; drinksStockLabels[3] = drink4StockLbl;
		drinksStockLabels[4] = drink5StockLbl; drinksStockLabels[5] = drink6StockLbl; drinksStockLabels[6] = drink7StockLbl; drinksStockLabels[7] = drink8StockLbl; 
		drinksStockLabels[8] = drink9StockLbl; drinksStockLabels[9] = drink10StockLbl; 
		
		for (int count = 0; count < 10; count++)
			drinksStockLabels[count].setText(String.valueOf(controller.getDrinkStock().get(count).getQuantity()));
		
		drinksPlusButtons[0] = drink1PlusBtn; drinksPlusButtons[1] = drink2PlusBtn; drinksPlusButtons[2] = drink3PlusBtn; drinksPlusButtons[3] = drink4PlusBtn;
		drinksPlusButtons[4] = drink5PlusBtn; drinksPlusButtons[5] = drink6PlusBtn; drinksPlusButtons[6] = drink7PlusBtn; drinksPlusButtons[7] = drink8PlusBtn;
		drinksPlusButtons[8] = drink9PlusBtn; drinksPlusButtons[9] = drink10PlusBtn;
		
		drinksMinusButtons[0] = drink1MinusBtn; drinksMinusButtons[1] = drink2MinusBtn; drinksMinusButtons[2] = drink3MinusBtn; drinksMinusButtons[3] = drink4MinusBtn;
		drinksMinusButtons[4] = drink5MinusBtn; drinksMinusButtons[5] = drink6MinusBtn; drinksMinusButtons[6] = drink7MinusBtn; drinksMinusButtons[7] = drink8MinusBtn;
		drinksMinusButtons[8] = drink9MinusBtn; drinksMinusButtons[9] = drink10MinusBtn;
		
		drinksSelectedLabels[0] = drink1SelectedLbl; drinksSelectedLabels[1] = drink2SelectedLbl; drinksSelectedLabels[2] = drink3SelectedLbl; drinksSelectedLabels[3] = drink4SelectedLbl;
		drinksSelectedLabels[4] = drink5SelectedLbl; drinksSelectedLabels[5] = drink6SelectedLbl; drinksSelectedLabels[6] = drink7SelectedLbl; drinksSelectedLabels[7] = drink8SelectedLbl;
		drinksSelectedLabels[8] = drink9SelectedLbl; drinksSelectedLabels[9] = drink10SelectedLbl;
		
	//	priceLabels[0] = 
		
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

	public void setAccBalanceLabel(double newBalance) {
		lblDynamicBalance.setText(String.valueOf(newBalance) + " Euro");		
	}

	public void updateStockLabels() {
		for (int index = 0; index < 10; index++)
			drinksStockLabels[index].setText(String.valueOf(controller.getDrinkStock().get(index).getQuantity()));		
	}
}
