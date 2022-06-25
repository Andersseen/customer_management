package panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import components.table.CellManagement;
import components.table.HeadingManagement;
import components.table.ModelTable;
import components.table.Utilities;
import model.dao.CustomerDAO;
import model.vo.CustomerVO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class SecondPage extends JPanel implements MouseListener{

	
	private JScrollPane scrollPaneTabla;
	private JTable table;
	ArrayList<CustomerVO> listaClientes;//lista que simula la información de la BD
	
	TableModel modelo;//modelo definido en la clase ModeloTabla
	private int rowTable;
	private int columnTable;
	
	
	public SecondPage() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		initComponent();
		
		construirTabla();
	}
	
	
	private void initComponent() {
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel listLabel = new JLabel("Tabla Clientes");
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
//		listaClientes = new ArrayList<CustomerVO>();
		CustomerDAO xxx = new CustomerDAO();
		
		try {
			listaClientes=xxx.getCustomers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			ArrayList<String> titulosList=new ArrayList<>();
			
			titulosList.add("Id");
			titulosList.add("Nombre");
			titulosList.add("Apellido");
			titulosList.add("Sexo");
			titulosList.add("Fecha nacimiento");
			titulosList.add("Telefono");
			titulosList.add("Email");
			titulosList.add("Nota");
			titulosList.add("Cita");
			titulosList.add(" ");
			titulosList.add(" ");
					
			//se asignan las columnas al arreglo para enviarse al momento de construir la tabla
			String titulos[] = new String[titulosList.size()];
			for (int i = 0; i < titulos.length; i++) {
				titulos[i]=titulosList.get(i);
			}
			/*obtenemos los datos de la lista y los guardamos en la matriz
			 * que luego se manda a construir la tabla
			 */
			Object[][] data =obtenerMatrizDatos(titulosList);
			construirTabla(titulos,data);
		
	}

	
private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
		
		/*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
		 */
		String informacion[][] = new String[listaClientes.size()][titulosList.size()];
		
		for (int x = 0; x < informacion.length; x++) {
			
			informacion[x][Utilities.ID] = listaClientes.get(x).getId()+ "";
			informacion[x][Utilities.NAME] = listaClientes.get(x).getName()+ "";
			informacion[x][Utilities.LASTNAME] = listaClientes.get(x).getLastName()+ "";
			informacion[x][Utilities.SEX] = listaClientes.get(x).getSex()+ "";
			informacion[x][Utilities.BIRTHDAY] = listaClientes.get(x).getBirthday()+ "";
			informacion[x][Utilities.PHONE] = listaClientes.get(x).getPhone()+ "";
			informacion[x][Utilities.EMAIL] = listaClientes.get(x).getEmail()+ "";
			informacion[x][Utilities.NOTE] = listaClientes.get(x).getNote()+ "";
			informacion[x][Utilities.DATE] = listaClientes.get(x).getDate()+ "";
			//se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
			informacion[x][Utilities.EDIT] = "EDIT";
			informacion[x][Utilities.DELETE] = "DELETE";
		}
		
		return informacion;
	}

private void construirTabla(String[] titulos, Object[][] data) {
	modelo = new ModelTable(data, titulos);
	//se asigna el modelo a la tabla
	table.setModel(modelo);
	
	rowTable=table.getRowCount();
	columnTable=table.getColumnCount();
	
	//se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
	table.getColumnModel().getColumn(Utilities.ID).setCellRenderer(new CellManagement("numerico"));
	table.getColumnModel().getColumn(Utilities.NAME).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.LASTNAME).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.SEX).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.BIRTHDAY).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.PHONE).setCellRenderer(new CellManagement("numerico"));
	table.getColumnModel().getColumn(Utilities.EMAIL).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.NOTE).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.DATE).setCellRenderer(new CellManagement("texto"));
	table.getColumnModel().getColumn(Utilities.EDIT).setCellRenderer(new CellManagement("icono"));
	table.getColumnModel().getColumn(Utilities.DELETE).setCellRenderer(new CellManagement("icono"));
	
	
	table.getTableHeader().setReorderingAllowed(false);
	table.setRowHeight(25);//tamaño de las celdas
	table.setGridColor(new java.awt.Color(0, 0, 0)); 
	//Se define el tamaño de largo para cada columna y su contenido
	table.getColumnModel().getColumn(Utilities.ID).setPreferredWidth(50);//id
	table.getColumnModel().getColumn(Utilities.NAME).setPreferredWidth(200);//nombre
	table.getColumnModel().getColumn(Utilities.LASTNAME).setPreferredWidth(200);//direccion
	table.getColumnModel().getColumn(Utilities.SEX).setPreferredWidth(100);//profesion
	table.getColumnModel().getColumn(Utilities.BIRTHDAY).setPreferredWidth(80);//edad
	table.getColumnModel().getColumn(Utilities.PHONE).setPreferredWidth(100);//nota1
	table.getColumnModel().getColumn(Utilities.EMAIL).setPreferredWidth(100);//nota2
	table.getColumnModel().getColumn(Utilities.NOTE).setPreferredWidth(100);//nota3
	table.getColumnModel().getColumn(Utilities.DATE).setPreferredWidth(100);//promedio
	table.getColumnModel().getColumn(Utilities.EDIT).setPreferredWidth(30);//accion perfil
	table.getColumnModel().getColumn(Utilities.DELETE).setPreferredWidth(30);//accion evento
	
	//personaliza el encabezado
	JTableHeader jtableHeader = table.getTableHeader();
    jtableHeader.setDefaultRenderer(new HeadingManagement());
    table.setTableHeader(jtableHeader);
    
    //se asigna la tabla al scrollPane
    scrollPaneTabla.setViewportView(table);


}

	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		//capturo fila o columna dependiendo de mi necesidad
				int fila = table.rowAtPoint(e.getPoint());
				int columna = table.columnAtPoint(e.getPoint());
				
				/*uso la columna para valiar si corresponde a la columna de perfil garantizando
				 * que solo se produzca algo si selecciono una fila de esa columna
				 */
				if (columna==Utilities.EDIT) {
					//sabiendo que corresponde a la columna de perfil, envio la posicion de la fila seleccionada
					JOptionPane.showMessageDialog(null, "EDIT");
				}else if (columna==Utilities.DELETE){//se valida que sea la columna del otro evento
					JOptionPane.showMessageDialog(null, "DELETE");
				}
		
	}
	
	private void validarSeleccionMouse(int fila) {
		Utilities.selectedRow=fila;
		
		
		//teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
		CustomerVO miPersona=new CustomerVO();
//		miPersona.setId(table.getValueAt(fila, Utilities.ID).toString());
		miPersona.setName(table.getValueAt(fila, Utilities.NAME).toString());
		
		String info="INFO PERSONA\n";
		info+="Documento: "+miPersona.getId()+"\n";
		info+="Nombre: "+miPersona.getName()+"\n";
		
		JOptionPane.showMessageDialog(null, info);
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
