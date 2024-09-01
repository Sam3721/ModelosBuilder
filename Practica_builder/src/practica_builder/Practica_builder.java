
package practica_builder;

/**
 *
 * @author jorge malaver
 */
import Abstraccion.*;
import Productos .*;
import Concrete_builder.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


    
    public class Practica_builder extends JFrame {
    private JComboBox<String> comboBox;
    private JButton btnMostrar;
    
    public Practica_builder() {
        setTitle("Patrón Builder");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        comboBox = new JComboBox<>(new String[]{"Camion 1", "Camion 2"});
        comboBox.setBounds(50, 30, 200, 25);
        add(comboBox);
        
        btnMostrar = new JButton("Ver partes");
        btnMostrar.setBounds(100, 70, 100, 25);
        add(btnMostrar);
        
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              construir_camion obj= new construir_camion();
              CamionBuilder obj1= new Camion_uno();
              CamionBuilder obj2=new Camion_dos();
              
              String seleccion= (String) comboBox.getSelectedItem();
              
              if ("Camion 1".equals(seleccion)) {
                  obj.setcamionBuilder(obj1);
                    obj.fabrica_camion();
                    camion nueva=obj.getcamion();
                    JOptionPane.showMessageDialog(null,nueva.toString());
              } else if ("Camion 2".equals(seleccion)) {
                  obj.setcamionBuilder(obj2);
              obj.fabrica_camion();
              camion nuevo=obj.getcamion();
              JOptionPane.showMessageDialog(null, nuevo.toString());
              }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Practica_builder().setVisible(true);
            }
        });
    }
}

            
        