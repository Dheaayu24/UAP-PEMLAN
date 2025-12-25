package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class CafeQueueApp extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private DefaultTableModel dataModel;
    private DefaultTableModel historyModel;

    // ===== WARNA CREAM THEME =====
    private final Color CREAM = new Color(245, 238, 224);
    private final Color PUTIH = Color.WHITE;
    private final Color ABU = new Color(200, 200, 200);
    private final Color HITAM = Color.DARK_GRAY;

    private static final String FILE_RIWAYAT = "riwayat_transaksi.txt";

    public CafeQueueApp() {setTitle("Sistem Antrian Pesanan Cafe");
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(buildDashboard(), "Dashboard");
        mainPanel.add(buildListData(), "ListData");
        mainPanel.add(buildInputForm(), "InputForm");
        mainPanel.add(buildHistoryPage(), "History");

        add(mainPanel);
        loadRiwayatDariFile();
        cardLayout.show(mainPanel, "Dashboard");
        setVisible(true);
    }

    // ================= Dashboard =================
    private JPanel buildDashboard() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));
        panel.setBackground(CREAM);

        JButton btnList = new JButton("📋 Lihat Daftar Pesanan");
        JButton btnInput = new JButton("📝 Input Pesanan Baru");
        JButton btnHistory = new JButton("📊 Riwayat Transaksi");
        JButton btnExit = new JButton("❌ Keluar");

        JButton[] buttons = {btnList, btnInput, btnHistory, btnExit};
        for (JButton b : buttons) {
            b.setBackground(PUTIH);
            b.setForeground(HITAM);
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createLineBorder(ABU));
        }

        btnList.addActionListener(e -> cardLayout.show(mainPanel, "ListData"));
        btnInput.addActionListener(e -> cardLayout.show(mainPanel, "InputForm"));
        btnHistory.addActionListener(e -> cardLayout.show(mainPanel, "History"));
        btnExit.addActionListener(e -> System.exit(0));

        panel.add(btnList);
        panel.add(btnInput);
        panel.add(btnHistory);
        panel.add(btnExit);
        return panel;
    }

    // ================= List Data =================
    private JPanel buildListData() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CREAM);

        String[] columns = {"No", "Nama", "Menu", "Jumlah", "Status"};
        dataModel = new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };

        JTable table = new JTable(dataModel);
        table.setRowHeight(26);
        table.setBackground(PUTIH);
        table.setForeground(HITAM);
        table.setGridColor(ABU);
        table.getTableHeader().setBackground(PUTIH);
        table.getTableHeader().setForeground(HITAM);

        // ===== BUTTON PANEL =====
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnPanel.setBackground(CREAM);

        JButton btnProses = new JButton("▶ Proses");
        JButton btnSelesai = new JButton("✔ Selesai");
        JButton backBtn = new JButton("⬅ Kembali");

        JButton[] buttons = {btnProses, btnSelesai, backBtn};
        for (JButton b : buttons) {
            b.setBackground(PUTIH);
            b.setForeground(HITAM);
            b.setBorder(BorderFactory.createLineBorder(ABU));
            b.setFocusPainted(false);
        }

        // ===== LOGIKA PROSES =====
        btnProses.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Pilih pesanan dulu!");
                return;
            }

            String status = dataModel.getValueAt(row, 4).toString();
            if (!status.equals("Menunggu")) {
                JOptionPane.showMessageDialog(this, "Hanya pesanan MENUNGGU yang bisa diproses!");
                return;
            }

            dataModel.setValueAt("Diproses", row, 4);
        });

        // ===== LOGIKA SELESAI =====
        btnSelesai.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Pilih pesanan dulu!");
                return;
            }

            String status = dataModel.getValueAt(row, 4).toString();
            if (!status.equals("Diproses")) {
                JOptionPane.showMessageDialog(this, "Pesanan belum diproses!");
                return;
            }

            dataModel.setValueAt("Selesai", row, 4);
        });

        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));

        btnPanel.add(btnProses);
        btnPanel.add(btnSelesai);
        btnPanel.add(backBtn);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    // ================= Input Form =================
    private JPanel buildInputForm() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CREAM);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 10, 150));
        formPanel.setBackground(CREAM);

        JTextField namaField = new JTextField();
        JComboBox<String> statusBox = new JComboBox<>(new String[]{"Menunggu", "Diproses", "Selesai"});

        formPanel.add(new JLabel("Nama Pelanggan"));
        formPanel.add(namaField);
        formPanel.add(new JLabel("Status"));
        formPanel.add(statusBox);

        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        menuPanel.setBorder(BorderFactory.createTitledBorder("Pilih Menu"));
        menuPanel.setBackground(CREAM);

        String[][] menuItems = {
                {"Nasi Goreng", "15000", "Makanan Berat"},
                {"Chicken Steak Crispy + Fries", "22000", "Makanan Berat"},
                {"Spaghetti Bolognese", "20000", "Makanan Berat"},
                {"Rice Bowl Ayam Teriyaki", "17000", "Makanan Berat"},
                {"Nasi Ayam Geprek Keju", "17000", "Makanan Berat"},
                {"Kentang Goreng", "10000", "Snack"},
                {"Onion Rings", "12000", "Snack"},
                {"Banana Nugget Coklat", "12000", "Snack"},
                {"Chicken Wings Crispy", "15000", "Snack"},
                {"Cireng Bumbu Rujak", "9000", "Snack"},
                {"Lychee Tea", "12000", "Minuman"},
                {"Matcha Latte", "15000", "Minuman"},
                {"Thai Tea", "12000", "Minuman"},
                {"Lemon Tea", "10000", "Minuman"},
                {"Chocolate Latte", "14000", "Minuman"},
        };

        DefaultTableModel pesananModel =
                new DefaultTableModel(new String[]{"Menu", "Harga", "Qty", "Sub Total"}, 0);

        JTable pesananTable = new JTable(pesananModel);
        pesananTable.setRowHeight(26);
        pesananTable.setBackground(PUTIH);
        pesananTable.setForeground(HITAM);
        pesananTable.setGridColor(ABU);

        for (String[] item : menuItems) {
            JPanel row = new JPanel(new BorderLayout());
            row.setBackground(CREAM);

            JLabel label = new JLabel(item[2] + " - " + item[0] + " (Rp " + item[1] + ")");
            JButton tambahBtn = new JButton("Tambah");
            tambahBtn.setPreferredSize(new Dimension(100, 32)); // ⬅ BESARIN
            tambahBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            tambahBtn.setBackground(PUTIH);
            tambahBtn.setForeground(HITAM);
            tambahBtn.setBorder(BorderFactory.createLineBorder(ABU));
            tambahBtn.setFocusPainted(false);


            tambahBtn.addActionListener(e -> {
                boolean found = false;
                for (int i = 0; i < pesananModel.getRowCount(); i++) {
                    if (pesananModel.getValueAt(i, 0).equals(item[0])) {
                        int qty = Integer.parseInt(pesananModel.getValueAt(i, 2).toString()) + 1;
                        int harga = Integer.parseInt(item[1]);
                        pesananModel.setValueAt(qty, i, 2);
                        pesananModel.setValueAt(qty * harga, i, 3);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    int harga = Integer.parseInt(item[1]);
                    pesananModel.addRow(new Object[]{item[0], harga, 1, harga});
                }
            });

            row.add(label, BorderLayout.CENTER);
            row.add(tambahBtn, BorderLayout.EAST);
            menuPanel.add(row);
        }

        JLabel totalLabel = new JLabel("0");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JButton simpanBtn = new JButton("✅ Simpan");
        JButton hapusBtn = new JButton("➖ Kurangi / Hapus");
        JButton backBtn = new JButton("⬅ Kembali");

        JButton[] actionBtns = {simpanBtn, hapusBtn, backBtn};
        for (JButton b : actionBtns) {
            b.setBackground(PUTIH);
            b.setForeground(HITAM);
            b.setBorder(BorderFactory.createLineBorder(ABU));
            b.setFocusPainted(false);
        }

        JPanel bottomPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));
        bottomPanel.setBackground(CREAM);

        simpanBtn.addActionListener(e -> {
            if (namaField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama wajib diisi");
                return;
            }
            if (pesananModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Belum ada pesanan");
                return;
            }

            String tanggal = new SimpleDateFormat("dd-MM-yyyy HH:mm")
                    .format(new Date());

            for (int i = 0; i < pesananModel.getRowCount(); i++) {
                dataModel.addRow(new Object[]{
                        dataModel.getRowCount() + 1,
                        namaField.getText(),
                        pesananModel.getValueAt(i, 0),
                        pesananModel.getValueAt(i, 2),
                        statusBox.getSelectedItem()
                });

                Object[] row = {
                        tanggal,
                        namaField.getText(),
                        pesananModel.getValueAt(i, 0),
                        pesananModel.getValueAt(i, 2),
                        pesananModel.getValueAt(i, 3)
                };

                historyModel.addRow(row);
                simpanRiwayatKeFile(row);

            }

            namaField.setText("");
            pesananModel.setRowCount(0);
            totalLabel.setText("0");
            JOptionPane.showMessageDialog(this, "Pesanan berhasil disimpan");
        });

        hapusBtn.addActionListener(e -> {
            int row = pesananTable.getSelectedRow();
            if (row == -1) return;

            int qty = Integer.parseInt(pesananModel.getValueAt(row, 2).toString());
            int harga = Integer.parseInt(pesananModel.getValueAt(row, 1).toString());

            if (qty > 1) {
                qty--;
                pesananModel.setValueAt(qty, row, 2);
                pesananModel.setValueAt(qty * harga, row, 3);
            } else {
                pesananModel.removeRow(row);
            }
        });

        pesananModel.addTableModelListener(e -> {
            int total = 0;
            for (int i = 0; i < pesananModel.getRowCount(); i++) {
                total += Integer.parseInt(pesananModel.getValueAt(i, 3).toString());
            }
            totalLabel.setText(String.valueOf(total));
        });

        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));

        bottomPanel.add(new JLabel("Total (Rp)"));
        bottomPanel.add(totalLabel);
        bottomPanel.add(hapusBtn);
        bottomPanel.add(simpanBtn);
        bottomPanel.add(backBtn);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(menuPanel, BorderLayout.WEST);
        panel.add(new JScrollPane(pesananTable), BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        return panel;
    }

    // ================= History =================
    private JPanel buildHistoryPage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CREAM);

        String[] columns = {"Tanggal", "Nama", "Menu", "Jumlah", "Total"};
        historyModel = new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };

        JTable table = new JTable(historyModel);
        table.setRowHeight(26);
        table.setBackground(PUTIH);
        table.setForeground(HITAM);
        table.setGridColor(ABU);
        table.getTableHeader().setBackground(PUTIH);
        table.getTableHeader().setForeground(HITAM);

        JButton backBtn = new JButton("⬅ Kembali");
        backBtn.setBackground(PUTIH);
        backBtn.setForeground(HITAM);
        backBtn.setBorder(BorderFactory.createLineBorder(ABU));
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Dashboard"));

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(backBtn, BorderLayout.SOUTH);
        return panel;
    }

    private void simpanRiwayatKeFile(Object[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_RIWAYAT, true))) {
            bw.write(
                    data[0] + "|" +
                            data[1] + "|" +
                            data[2] + "|" +
                            data[3] + "|" +
                            data[4]
            );
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan riwayat ke file!");
        }
    }

    private void loadRiwayatDariFile() {
        File file = new File(FILE_RIWAYAT);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 5) {
                    historyModel.addRow(data);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal membaca file riwayat!");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(CafeQueueApp::new);
    }
}
