import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relogio extends JFrame {

    private JLabel labelHora;

    public Relogio() {
        setTitle("Relógio");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelHora = new JLabel();
        labelHora.setFont(new Font("Arial", Font.BOLD, 40));
        labelHora.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelHora);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarHora();
            }
        });

        timer.start();
        setVisible(true);
    }

    private void atualizarHora() {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        String horaAtual = formatador.format(new Date());
        labelHora.setText(horaAtual);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Relogio();
            }
        });
    }
}
