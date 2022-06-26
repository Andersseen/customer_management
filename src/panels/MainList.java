package panels;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import components.table.CellManagement;
import components.table.HeadingManagement;
import components.table.ModelTable;
import components.table.Utilities;
import controller.DashboardController;
import model.dao.CustomerDAO;
import model.vo.CustomerVO;
import view.Dashboard;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;


public class MainList extends JPanel implements MouseListener {
	private DashboardController dashboardCL;
	
	private JScrollPane scrollPaneTabla;
	private JTable table;
	ArrayList<CustomerVO> listaClientes;//lista que simula la información de la BD
	
	TableModel modelo;//modelo definido en la clase ModeloTabla
	private int rowTable;
	private int columnTable;
	
	
	public MainList() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		initComponent();
		construirTabla();
	}
	
	
	private void initComponent() {
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel listLabel = new JLabel("Tabla de clientes");
		listLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(listLabel, BorderLayout.NORTH);
		
		scrollPaneTabla = new JScrollPane();
		add(scrollPaneTabla);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.addMouseListener(this);
		//tablaSeguimiento.addKeyListener(this);
		table.setOpaque(false);
		scrollPaneTabla.setViewportView(table);
		
	}
	
	private void construirTabla() {
		listaClientes = new ArrayList<CustomerVO>();
		dashboardCL = new DashboardController();
		
		listaClientes=dashboardCL.getClients();
			
			ArrayList<String> titleList=new ArrayList<>();
			
			titleList.add("Id");
			titleList.add("Nombre");
			titleList.add("Apellido");
			titleList.add("Sexo");
			titleList.add("Fecha nacimiento");
			titleList.add("Telefono");
			titleList.add("Email");
			titleList.add("Nota");
			titleList.add("Cita");
			titleList.add(" ");
			titleList.add(" ");
					
			//se asignan las columnas al arreglo para enviarse al momento de construir la tabla
			String titulos[] = new String[titleList.size()];
			for (int i = 0; i < titulos.length; i++) {
				titulos[i]=titleList.get(i);
			}
			/*obtenemos los datos de la lista y los guardamos en la matriz
			 * que luego se manda a construir la tabla
			 */
			Object[][] data =obtenerMatrizDatos(titleList);
			construirTabla(titulos,data);
		
	}

	
private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
		
		/*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
		 */
		String information[][] = new String[listaClientes.size()][titulosList.size()];
		
		for (int x = 0; x < information.length; x++) {
			
			information[x][Utilities.ID] = listaClientes.get(x).getId()+ "";
			information[x][Utilities.NAME] = listaClientes.get(x).getName()+ "";
			information[x][Utilities.LASTNAME] = listaClientes.get(x).getLastName()+ "";
			information[x][Utilities.SEX] = listaClientes.get(x).getSex()+ "";
			information[x][Utilities.BIRTHDAY] = listaClientes.get(x).getBirthday()+ "";
			information[x][Utilities.PHONE] = listaClientes.get(x).getPhone()+ "";
			information[x][Utilities.EMAIL] = listaClientes.get(x).getEmail()+ "";
			information[x][Utilities.NOTE] = listaClientes.get(x).getNote()+ "";
			information[x][Utilities.DATE] = listaClientes.get(x).getDate()+ "";
			//se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
			information[x][Utilities.EDIT] = "EDIT";
			information[x][Utilities.DELETE] = "DELETE";
		}
		
		return information;
	}

private void construirTabla(String[] titulos, Object[][] data) {
	modelo = new ModelTable(data, titulos);
	//se asigna el modelo a la tabla
	table.setModel(modelo);
	
	rowTable=table.getRowCount();
	columnTable=table.getColumnCount();
	
	//se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
	table.getColumnModel().getColumn(Utilities.ID).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.NAME).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.LASTNAME).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.SEX).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.BIRTHDAY).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.PHONE).setCellRenderer(new CellManagement("number"));
	table.getColumnModel().getColumn(Utilities.EMAIL).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.NOTE).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.DATE).setCellRenderer(new CellManagement("text"));
	table.getColumnModel().getColumn(Utilities.EDIT).setCellRenderer(new CellManagement("icon"));
	table.getColumnModel().getColumn(Utilities.DELETE).setCellRenderer(new CellManagement("icon"));
	
	
	table.getTableHeader().setReorderingAllowed(false);
	table.setRowHeight(25);//tamaño de las celdas
	table.setGridColor(new java.awt.Color(0, 0, 0)); 
	//Se define el tamaño de largo para cada columna y su contenido
	table.getColumnModel().getColumn(Utilities.ID).setPreferredWidth(50);//id
	table.getColumnModel().getColumn(Utilities.NAME).setPreferredWidth(150);//nombre
	table.getColumnModel().getColumn(Utilities.LASTNAME).setPreferredWidth(150);//direccion
	table.getColumnModel().getColumn(Utilities.SEX).setPreferredWidth(80);//profesion
	table.getColumnModel().getColumn(Utilities.BIRTHDAY).setPreferredWidth(80);//edad
	table.getColumnModel().getColumn(Utilities.PHONE).setPreferredWidth(100);//nota1
	table.getColumnModel().getColumn(Utilities.EMAIL).setPreferredWidth(100);//nota2
	table.getColumnModel().getColumn(Utilities.NOTE).setPreferredWidth(100);//nota3
	table.getColumnModel().getColumn(Utilities.DATE).setPreferredWidth(100);//promedio
	table.getColumnModel().getColumn(Utilities.EDIT).setPreferredWidth(24);//accion perfil
	table.getColumnModel().getColumn(Utilities.DELETE).setPreferredWidth(24);//accion evento
	
	//personaliza el encabezado
	JTableHeader jtableHeader = table.getTableHeader();
    jtableHeader.setDefaultRenderer(new HeadingManagement());
    table.setTableHeader(jtableHeader);
    
    //se asigna la tabla al scrollPane
    scrollPaneTabla.setViewportView(table);

}

	public void refresh() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		initComponent();
		construirTabla();
		
		System.out.println("hey");
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//capturo fila o columna dependiendo de mi necesidad
				int row = table.rowAtPoint(e.getPoint());
				int column = table.columnAtPoint(e.getPoint());
				
				/*uso la columna para valiar si corresponde a la columna de perfil garantizando
				 * que solo se produzca algo si selecciono una fila de esa columna
				 */
				if (column==Utilities.EDIT) {
					
					JOptionPane.showMessageDialog(null, "Esta editando cliente");
					
					Utilities.selectedRow = row;
					
//					String id = table.getValueAt(row, Utilities.ID).toString();
					int id = Integer.valueOf(table.getValueAt(row, Utilities.ID).toString());
					String name = table.getValueAt(row, Utilities.NAME).toString();
					String lastName = table.getValueAt(row, Utilities.LASTNAME).toString();
					String sex = table.getValueAt(row, Utilities.SEX).toString();
					String birthday =  table.getValueAt(row, Utilities.BIRTHDAY).toString();
					String phone = table.getValueAt(row, Utilities.PHONE).toString();
					String email = table.getValueAt(row, Utilities.EMAIL).toString();
					String note = table.getValueAt(row, Utilities.NOTE).toString();
					String date = table.getValueAt(row, Utilities.DATE).toString();
					
					EditClient editPage = new EditClient(id,name,lastName,sex,birthday,phone,email,note,date);
					editPage.setVisible(true);


				}else if (column==Utilities.DELETE){
					JOptionPane.showMessageDialog(null, "Esta eliminando cliente");
					
					int id = Integer.valueOf(table.getValueAt(row, Utilities.ID).toString());
					dashboardCL = new DashboardController();
					dashboardCL.deleteClient(id);
					construirTabla();
				}
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
