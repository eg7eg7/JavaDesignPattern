import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.application.Application;

public class Calculator extends Application implements CalcFinals {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		CalculatorPane pane = new CalculatorPane();
		Scene scene = new Scene(pane);
		stage.setTitle(CALC_TITLE);
		stage.setWidth(300);
		stage.setHeight(300);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();

	}

	public class CalculatorPane extends BorderPane {
		TextField textField = new TextField();
		boolean lastEquals = false;

		public CalculatorPane() {
			textField.setPrefSize(this.widthProperty().get(), 50);
			textField.setFont(new Font("times new roman", 25));
			textField.setText("");
			numButton num1 = new numButton("1", this);
			numButton num2 = new numButton("2", this);
			numButton num3 = new numButton("3", this);
			numButton num4 = new numButton("4", this);
			numButton num5 = new numButton("5", this);
			numButton num6 = new numButton("6", this);
			numButton num7 = new numButton("7", this);
			numButton num8 = new numButton("8", this);
			numButton num9 = new numButton("9", this);
			numButton num0 = new numButton("0", this);
			plusBtn plusb = new plusBtn(this);
			minusBtn minusb = new minusBtn(this);
			multBtn multb = new multBtn(this);
			divBtn divb = new divBtn(this);
			RgtCrlBtn rightb = new RgtCrlBtn(this);
			lftCrlBtn leftb = new lftCrlBtn(this);
			equalsButton equalsb = new equalsButton(this);
			delButton cb = new delButton(this);
			plusb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			minusb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			multb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			divb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			rightb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			leftb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			equalsb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			cb.setOnAction(e -> ((OperationButton) e.getSource()).execute());
			num1.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num2.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num3.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num4.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num5.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num6.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num7.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num8.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num9.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			num0.setOnAction(e -> ((NumeratorButton) e.getSource()).execute());
			GridPane nums = new GridPane();
			GridPane ops = new GridPane();
			nums.vgapProperty().set(5);
			nums.hgapProperty().set(5);
			ops.vgapProperty().set(5);
			ops.hgapProperty().set(5);
			nums.add(num1, 0, 0);
			nums.add(num2, 1, 0);
			nums.add(num3, 2, 0);
			nums.add(num4, 0, 1);
			nums.add(num5, 1, 1);
			nums.add(num6, 2, 1);
			nums.add(num7, 0, 2);
			nums.add(num8, 1, 2);
			nums.add(num9, 2, 2);
			nums.add(num0, 0, 3);
			nums.add(rightb, 2, 3);
			nums.add(leftb, 1, 3);
			ops.add(plusb, 0, 0);
			ops.add(minusb, 1, 0);
			ops.add(multb, 0, 1);
			ops.add(divb, 1, 1);
			ops.add(equalsb, 0, 2);
			ops.add(cb, 1, 2);
			this.setTop(textField);
			this.setCenter(nums);
			this.setRight(ops);

		}

		public boolean isLastEquals() {
			return lastEquals;
		}

		public void setLastEquals(boolean lastEquals) {
			this.lastEquals = lastEquals;
		}

		public TextField getTextField() {
			return textField;
		}

		public void setTextField(TextField field) {
			this.textField = field;
		}
	}

	public class numButton extends Button implements NumeratorButton {
		private CalculatorPane p;
		private String title;

		public numButton(String title, CalculatorPane pane) {
			super(title);
			this.title = title;
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			if (p.isLastEquals()) {
				p.getTextField().setText("");
				p.setLastEquals(false);
				p.requestFocus();
			}
			p.getTextField().appendText(title);

		}

	}

	public class plusBtn extends Button implements OperationButton {
		CalculatorPane p;

		public plusBtn(CalculatorPane pane) {
			super(PLUS_BUTTON);
			p = pane;
			this.setPrefSize(50, 50);
			
		}

		@Override
		public void execute() {
			p.getTextField().appendText(PLUS_BUTTON);
		}

	}

	public class minusBtn extends Button implements OperationButton {
		CalculatorPane p;

		public minusBtn(CalculatorPane pane) {
			super(MINUS_BUTTON);
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.getTextField().appendText(MINUS_BUTTON);

		}

	}

	public class multBtn extends Button implements OperationButton {
		CalculatorPane p;

		public multBtn(CalculatorPane pane) {
			super(MULT_BUTTON);
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.getTextField().appendText(MULT_BUTTON);

		}

	}

	public class divBtn extends Button implements OperationButton {
		CalculatorPane p;

		public divBtn(CalculatorPane pane) {
			super(DIV_BUTTON);
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.getTextField().appendText(DIV_BUTTON);

		}

	}

	public class lftCrlBtn extends Button implements OperationButton {
		CalculatorPane p;

		public lftCrlBtn(CalculatorPane pane) {
			super(LEFT_CURL);
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.getTextField().appendText(LEFT_CURL);

		}

	}

	public class RgtCrlBtn extends Button implements OperationButton {
		CalculatorPane p;

		public RgtCrlBtn(CalculatorPane pane) {
			super(RIGHT_CURL);
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.getTextField().appendText(RIGHT_CURL);

		}

	}

	public class delButton extends Button implements OperationButton {
		CalculatorPane p;

		public delButton(CalculatorPane pane) {
			super("C");
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.getTextField().setText((String.copyValueOf(p.getTextField().getText().toCharArray(), 0,
					p.getTextField().getText().toCharArray().length - 1)));
		}

	}

	public class equalsButton extends Button implements OperationButton {
		CalculatorPane p;

		public equalsButton(CalculatorPane pane) {
			super(EQUALS);
			p = pane;
			this.setPrefSize(50, 50);
		}

		@Override
		public void execute() {
			p.setLastEquals(true);
			char[] t = p.getTextField().getText().toCharArray();
			float result;
			result = calculate(t, 0, t.length);
			p.getTextField().setText(Float.toString(result));
		}

		private float calculate(char[] textArr, int index, int lastIndex) {
			float num = 0;

			if (textArr[index] == '(') {
				for (int i = index; i < lastIndex; i++) {
					if (textArr[i] == ')') {
						num = calculate(textArr, index + 1, i);
						if (i + 1 < lastIndex && isOperation(textArr[i]) == 1)
							return doOperation(num, textArr[i], calculate(textArr, i + 1, lastIndex));
						else
							return num;
					}
				}

			}

			char curr = '0';
			while ((curr >= '0' && curr <= '9') && index <= lastIndex) {
				num = num * 10 + (curr - '0');
				if (lastIndex == index)
					break;
				curr = textArr[index];
				index++;
			}

			if (isOperation(curr) == 1 && index < lastIndex)
				return doOperation(num, curr, calculate(textArr, index, lastIndex));
			else if (isOperation(curr) == 1)
				return doOperation(num, curr, 0);

			return num;

		}

		private float doOperation(float num, char curr, float calculate) {
			if (curr == PLUS_BUTTON.toCharArray()[0])
				return num + calculate;
			else if (curr == MINUS_BUTTON.toCharArray()[0])
				return num - calculate;
			else if (curr == MULT_BUTTON.toCharArray()[0])
				return num * calculate;
			else if (curr == DIV_BUTTON.toCharArray()[0])
				return num / calculate;
			return num;
		}

		public int isOperation(char c) {
			if (c >= '0' && c <= '9')
				return 0;
			else
				return 1;
		}
	}

}
