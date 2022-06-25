package components.table;

import javax.swing.table.DefaultTableModel;


public class ModelTable extends DefaultTableModel{
	
	String[] titles;
	Object[][] data;
	

	public ModelTable(Object[][] datos, String[] titulos) {
		super();
		this.titles=titulos;
		this.data=datos;
		setDataVector(datos, titulos);
	}
	
	public ModelTable() {
		// TODO Auto-generated constructor stub
	}

}
