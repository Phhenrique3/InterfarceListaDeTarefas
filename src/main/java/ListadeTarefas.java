import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListadeTarefas extends JFrame {

    private JLabel ListadeTarefas;
    private JPanel painel = new JPanel();
    private JButton jButtonAdicionarTarefas1 = new JButton("1. Adicionar uma tarefa ");
    private JButton jButtonRemoverTarefas2 = new JButton("2. Remover uma tarefa");
    private JButton jButtonListarTarefas3 = new JButton("3. Listar tarefas");
    private JButton jButtonSair4 = new JButton("4 Sair ");


    public ListadeTarefas() {
        ArrayList<String> tarefas = new ArrayList<String>();

        this.setTitle(" LISTA DE TAREFAS ");
        this.setSize(300, 226);

        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(jButtonAdicionarTarefas1);
        jButtonAdicionarTarefas1.setForeground(Color.BLUE);

        painel.add(jButtonRemoverTarefas2);
        jButtonRemoverTarefas2.setForeground(Color.BLUE);

        painel.add(jButtonListarTarefas3);
        jButtonListarTarefas3.setForeground(Color.blue);

        painel.add(jButtonSair4);
        jButtonSair4.setForeground(Color.RED);



        jButtonAdicionarTarefas1.addActionListener(new ActionListener() {
            JTextField ListadeTarefas = new JTextField(10);

            @Override
            public void actionPerformed(ActionEvent e) {
                String tarefa = JOptionPane.showInputDialog(" Porgentileza adicionar um tarefa ");
                adicionarTarefa(tarefas, tarefa);

            }


        });
        jButtonRemoverTarefas2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int indice = Integer.parseInt(JOptionPane.showInputDialog(" Por gentileza selecionar um indice para remover "));

                removerTarefa(tarefas, indice);

            }
        });
        jButtonListarTarefas3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTarefas(tarefas);
            }
        });

        jButtonSair4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, " DESEJA FINALIZAR ? ");
                System.exit(0);


            }
        });

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir Janela
    }



    private void listarTarefas(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, " A LISTA DE TAREFA ESTAR VAZIA ! ");
        } else {
            StringBuilder lista = new StringBuilder();
            for (int i = 0; i < tarefas.size(); i++) {
                lista.append(i).append(".").append(tarefas.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    private void adicionarTarefa(ArrayList<String> tarefas, String tarefa) {
        tarefas.add(tarefa);
    }

    private void removerTarefa(ArrayList<String> tarefas, int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
        } else {
            JOptionPane.showMessageDialog(null, " INDICE INVALIDO  ");
        }

    }

    public static void main(String[] args) {
        new ListadeTarefas();
    }
}