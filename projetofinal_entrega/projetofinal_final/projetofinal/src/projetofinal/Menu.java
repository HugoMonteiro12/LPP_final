package projetofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel productTypeLabel;
    private final JComboBox<String> productTypeComboBox;
    private final JLabel saborLabel;
    private final JTextField saborField;
    private final JLabel tipoLabel;
    private final JTextField tipoField;
    private final JLabel nomeLabel;
    private final JTextField nomeField;
    private final JLabel precoLabel;
    private final JTextField precoField;
    private final JLabel quantLabel;
    private final JTextField quantField;
    private final JLabel pesoLabel;
    private final JTextField pesoField;
    private final JLabel tipoRegistoLabel;
    private final JComboBox<String> tipoRegistoComboBox;
    private final JLabel tipoRegistoGeladoLabel;
    private final JComboBox<String> tipoRegistoGeladoComboBox;
    private final JLabel fornecedorLabel;
    private final JTextField fornecedorField;
    private final JButton addButton;
    private final JButton saveButton;
    private final JButton importButton;
    private final JTextArea dataTextArea;
    private final List<String[]> dados;

    public Menu() {
        dados = new ArrayList<>();

        frame = new JFrame("Product Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        productTypeLabel = new JLabel("Tipo de produto:");
        productTypeComboBox = new JComboBox<>(new String[]{"", "Gelado", "Fruta"});
        productTypeComboBox.addActionListener(this);

        saborLabel = new JLabel("Sabor:");
        saborField = new JTextField(10);

        tipoLabel = new JLabel("Tipo:");
        tipoField = new JTextField(10);

        nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(10);

        precoLabel = new JLabel("Preço:");
        precoField = new JTextField(10);

        quantLabel = new JLabel("Quantidade:");
        quantField = new JTextField(10);

        pesoLabel = new JLabel("Peso:");
        pesoField = new JTextField(10);

        tipoRegistoLabel = new JLabel("Tipo Registo:");
        tipoRegistoComboBox = new JComboBox<>(new String[]{"", "Peso", "Saco"});

        tipoRegistoGeladoLabel = new JLabel("Tipo Registo:");
        tipoRegistoGeladoComboBox = new JComboBox<>(new String[]{"", "Caixa", "Unidade"});

        fornecedorLabel = new JLabel("Fornecedor:");
        fornecedorField = new JTextField(10);

        addButton = new JButton("Adicionar");
        addButton.addActionListener(this);

        saveButton = new JButton("Guardar");
        saveButton.addActionListener(this);

        importButton = new JButton("Importar");
        importButton.addActionListener(this);

        dataTextArea = new JTextArea(10, 30);
        dataTextArea.setEditable(false);

        // First column
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(productTypeLabel, gbc);

        gbc.gridy = 1;
        panel.add(saborLabel, gbc);

        gbc.gridy = 3;
        panel.add(nomeLabel, gbc);

        gbc.gridy = 4;
        panel.add(precoLabel, gbc);

        gbc.gridy = 5;
        panel.add(quantLabel, gbc);

        gbc.gridy = 6;
        panel.add(pesoLabel, gbc);

        gbc.gridy = 7;
        panel.add(tipoRegistoLabel, gbc);

        gbc.gridy = 7;
        panel.add(tipoRegistoGeladoLabel, gbc);

        gbc.gridy = 8;
        panel.add(fornecedorLabel, gbc);

        // Second column
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(productTypeComboBox, gbc);

        gbc.gridy = 1;
        panel.add(saborField, gbc);

        gbc.gridy = 3;
        panel.add(nomeField, gbc);

        gbc.gridy = 4;
        panel.add(precoField, gbc);

        gbc.gridy = 5;
        panel.add(quantField, gbc);

        gbc.gridy = 6;
        panel.add(pesoField, gbc);

        gbc.gridy = 7;
        panel.add(tipoRegistoComboBox, gbc);

        gbc.gridy = 7;
        panel.add(tipoRegistoGeladoComboBox, gbc);

        gbc.gridy = 8;
        panel.add(fornecedorField, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(addButton, gbc);

        gbc.gridx = 1;
        panel.add(saveButton, gbc);

        gbc.gridx = 2;
        panel.add(importButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JScrollPane(dataTextArea), gbc);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productTypeComboBox) {
            String productType = (String) productTypeComboBox.getSelectedItem();
            if (productType.equals("Fruta")) {
                saborLabel.setVisible(false);
                saborField.setVisible(false);
                pesoLabel.setVisible(true);
                pesoField.setVisible(true);
                tipoRegistoLabel.setVisible(true);
                tipoRegistoComboBox.setVisible(true);
                tipoRegistoGeladoComboBox.setVisible(false);
                tipoRegistoGeladoLabel.setVisible(false);
            } else {
                saborLabel.setVisible(true);
                saborField.setVisible(true);
                pesoLabel.setVisible(false);
                pesoField.setVisible(false);
                tipoRegistoLabel.setVisible(false);
                tipoRegistoComboBox.setVisible(false);
                tipoRegistoGeladoComboBox.setVisible(true);
                tipoRegistoGeladoLabel.setVisible(true);
            }

            panel.revalidate();
            panel.repaint();
        } else if (e.getSource() == addButton) {
            String inserir = (String) productTypeComboBox.getSelectedItem();
            switch (inserir) {
                case "Gelado":
                    String saborGelado = saborField.getText();
                    String tipoGelado = tipoRegistoGeladoComboBox.getSelectedItem().toString();
                    String nomeGelado = nomeField.getText();
                    float precoGelado = Float.parseFloat(precoField.getText());
                    int quantGelado = Integer.parseInt(quantField.getText());
                    String fornecedorGelado = fornecedorField.getText();
                    Gelado geladoInserir = new Gelado(saborGelado, tipoGelado, nomeGelado, precoGelado, quantGelado, fornecedorGelado);
                    String[] geladoData = {inserir, geladoInserir.getSabor(), geladoInserir.getTipo(), geladoInserir.getNome(), String.valueOf(geladoInserir.getPreco()), String.valueOf(geladoInserir.getQuant()), geladoInserir.getFornecedor()};
                    dados.add(geladoData);
                    break;
                case "Fruta":
                    int pesoFruta = Integer.parseInt(pesoField.getText());
                    int tipoFruta = tipoRegistoComboBox.getSelectedIndex();
                    String nomeFruta = nomeField.getText();
                    float precoFruta = Float.parseFloat(precoField.getText());
                    int quantFruta = Integer.parseInt(quantField.getText());
                    String fornecedorFruta = fornecedorField.getText();
                    Fruta frutaInserir = new Fruta(pesoFruta, tipoFruta, nomeFruta, precoFruta, quantFruta, fornecedorFruta);
                    String[] frutaData = {inserir, String.valueOf(frutaInserir.getPeso()), String.valueOf(frutaInserir.getTipo_registo()), String.valueOf(frutaInserir.getPreco()), String.valueOf(frutaInserir.getQuant()), frutaInserir.getFornecedor()};
                    dados.add(frutaData);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro no programa: tipo de produto inválido.");
                    break;
            }

            updateDataTextArea();

        } else if (e.getSource() == saveButton) {
            try (FileWriter writer = new FileWriter("C:\\Users\\hugon\\Downloads\\projetofinal_entrega\\projetofinal_final\\projetofinal\\dados.csv")) {
                for (String[] data : dados) {
                    writer.write(String.join(";", data) + "\n");
                }
                JOptionPane.showMessageDialog(null, "Dados guardados.");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro a guardar os dados.");
            }
        } else if (e.getSource() == importButton) {
            try {
                List<String[]> importedData = importDataFromFile("C:\\Users\\hugon\\Downloads\\projetofinal_entrega\\projetofinal_final\\projetofinal\\dados.csv");
                if (importedData != null) {
                    dados.addAll(importedData);
                    updateDataTextArea();
                    JOptionPane.showMessageDialog(null, "Dados importados com sucesso.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro a importar os dados.");
            }
        }
    }

    private List<String[]> importDataFromFile(String filePath) throws IOException {
        List<String[]> importedData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                importedData.add(data);
            }
        }
        return importedData;
    }

    private void updateDataTextArea() {
        StringBuilder sb = new StringBuilder();
        for (String[] data : dados) {
            String formattedData = String.format("Produto: %s\nSabor: %s\nTipo: %s\nNome: %s\nPreço: %.2f\nQuantidade: %d\nFornecedor: %s\n",
                    data[0], data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]), data[6]);

            sb.append(formattedData).append("\n");
        }
        dataTextArea.setText(sb.toString());
    }
}
