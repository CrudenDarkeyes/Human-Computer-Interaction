package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.Controller;
import model.Model;
import model.ModelListener;

public class CalculatorView implements ModelListener
{

	private Text expression;
	public String append = "HelloWorld";
	private final Shell shell;
	/*
	 * 
	 */
	private final Model model;
	public CalculatorView(final Display d, final Model model, final Controller controller)
	{
		shell = new Shell( d );
		this.model = model;
		
		shell.setSize( 300, 300 );
		shell.setText( "SWT Calculator" );
		
		init( d, controller );
		
		shell.open();
		
		model.addListener( this );
	}
	
	private void init(final Display display, final Controller controller)
	{
		expression = new Text( shell, SWT.BORDER );
		expression.setLayoutData( new GridData(SWT.FILL, SWT.TOP, false, true, 5, 1 ) );
		expression.setFont( new Font( display, "Courier", 20, SWT.DEFAULT ) );
		
		
		final GridData buttonLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true );
		
		Button backspace = new Button( shell, SWT.PUSH );
		backspace.setText( "<-X" );
		backspace.setLayoutData( new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1) );
		backspace.addSelectionListener( controller.getSelectionListener( 'X' ) );
		backspace.setToolTipText("delete last character");
		
		Button clear = new Button( shell, SWT.PUSH );
		clear.setText( "C" );
		clear.setLayoutData( new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1) );
		clear.addSelectionListener( controller.getSelectionListener( 'C' ) );
		clear.setToolTipText("clear display");
		
		Button times = new Button( shell, SWT.PUSH );
		times.setText( "*" );
		times.setLayoutData( buttonLayoutData );
		times.addSelectionListener( controller.getSelectionListener( '*' ) );
		
		Button percent = new Button( shell, SWT.PUSH );
		percent.setText( "." );
		percent.setLayoutData( buttonLayoutData );
		percent.addSelectionListener( controller.getSelectionListener( '.' ) );		
		
		Button seven = new Button( shell, SWT.PUSH );
		seven.setText( "7" );
		seven.setLayoutData( buttonLayoutData );
		seven.addSelectionListener( controller.getSelectionListener( '7' ) );	
	
		Button eight = new Button( shell, SWT.PUSH );
		eight.setText( "8" );
		eight.setLayoutData( buttonLayoutData );
		eight.addSelectionListener( controller.getSelectionListener( '8' ) );
		
		Button nine = new Button( shell, SWT.PUSH );
		nine.setText( "9" );
		nine.setLayoutData( buttonLayoutData );
		nine.addSelectionListener( controller.getSelectionListener( '9' ) );
		
		Button divided = new Button( shell, SWT.PUSH );
		divided.setText( "/" );
		divided.setLayoutData( buttonLayoutData );
		divided.addSelectionListener( controller.getSelectionListener( '/' ) );
		

		Button	closeP = new Button( shell, SWT.PUSH );
		closeP.setText( ")" );
		closeP.setLayoutData( buttonLayoutData );
		closeP.setToolTipText("does not work yet");

		
		Button four = new Button( shell, SWT.PUSH );
		four.setText( "4" );
		four.setLayoutData( buttonLayoutData );
		four.addSelectionListener( controller.getSelectionListener( '4' ) );
		
		Button five = new Button( shell, SWT.PUSH );
		five.setText( "5" );
		five.setLayoutData( buttonLayoutData );
		five.addSelectionListener( controller.getSelectionListener( '5' ) );
		
		Button six = new Button( shell, SWT.PUSH );
		six.setText( "6" );
		six.setLayoutData( buttonLayoutData );
		six.addSelectionListener( controller.getSelectionListener( '6' ) );	
		
		Button add = new Button( shell, SWT.PUSH );
		add.setText( "+" );
		add.setLayoutData( buttonLayoutData );
		add.addSelectionListener( controller.getSelectionListener( '+' ) );	

		
		Button openP = new Button( shell, SWT.PUSH );
		openP.setText( "(" );
		openP.setLayoutData( buttonLayoutData );
		openP.setToolTipText("does not work yet");

		
		Button one = new Button( shell, SWT.PUSH );
		one.setText( "1" );
		one.setLayoutData( buttonLayoutData );
		one.addSelectionListener( controller.getSelectionListener( '1' ) );	
		
		Button two = new Button( shell, SWT.PUSH );
		two.setText( "2" );
		two.setLayoutData( buttonLayoutData );
		two.addSelectionListener( controller.getSelectionListener( '2' ) );	
		
		Button three = new Button( shell, SWT.PUSH );
		three.setText( "3" );
		three.setLayoutData( buttonLayoutData );
		three.addSelectionListener( controller.getSelectionListener( '3' ) );
		
		Button minus = new Button( shell, SWT.PUSH );
		minus.setText( "-" );
		minus.setLayoutData( buttonLayoutData );
		minus.addSelectionListener( controller.getSelectionListener( '-' ) );
		
		Button dot = new Button( shell, SWT.PUSH );
		dot.setText( "." );
		dot.setLayoutData( buttonLayoutData );
		dot.addSelectionListener( controller.getSelectionListener( '.' ) );
		
		Button zero = new Button( shell, SWT.PUSH );
		zero.setText( "0" );
		zero.setLayoutData( new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1) );
		zero.addSelectionListener( controller.getSelectionListener( '0' ) );
		
		Button evaluate = new Button( shell, SWT.PUSH );
		evaluate.setText( "=" );
		evaluate.setLayoutData( buttonLayoutData );
		evaluate.addSelectionListener( controller.getEvaluateSelectionListener() );
		
		
		shell.setLayout( new GridLayout( 5, true ) );
	}

	@Override
	public void expressionUpdated()
	{
		expression.setText(model.expression);
	}
	public boolean isDisposed()
	{
		return shell.isDisposed();
	}
}
