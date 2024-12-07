import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class pemdasWrap {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SlideShowFrame());
    }
}

class SlideShowFrame extends JFrame {
    private int currentSlide = 0;
    private String userName = "";
    private final String[] messages = {
        "Selamat datang di Pemdas Wrap!! ><",
        "Rekap Huru Hara Praktikum Pemrograman Dasar TI-B",
        "Halo %s! Gunakan tombol Next dan Previous untuk navigasi yaa~",
        "Penasaran kahhh",
        "Ayo mulaai!!!",
        "Tau gak sii, selama 4 bulan efektif ini kita udah ngelakuin 13x pertemuan!",
        "Mungkin ada beberapa waktu dimana kamu sempet berhalangan untuk hadir, tapi kami tetep salut koo sama kamu yang tiap seninnya hadir di jam 7 pagi buta TT *respect",
        "Selama 12x pertemuan itu, kamu berhasil membantu Tante Damai serta sanak saudaranya di 5 Tugas Hackerank!",
        "Kamu juga berhasil namatin total 2x Live Coding,",
        "1x Final Assignment,",
        "1x UTP",
        "dan 1x UAP yang baru aja kalian hadapi OMO!!",
        "Kelazz bgttt %s!!!",
        "Wkwkwkw, sebenernya disini kami mau ngucapin...",
        "Selamat, karena udah selesai nglewatin praktikum pertama di FILKOM~",
        "Mungkin ada banyak kendala kaya problem instalasi vscode, scanner error, atau subtest hackerank yang ngeselin",
        "Atau mungkin UAP yang aga bikin tercengang :D",
        "Seperti yang sempet kami mention di pertemuan-pertemuan lalu, kami minta maaf kalau misal kemarin atau nanti ada yang dikurangin nilainya (kalau misal) ada beberapa kriteria yang dilanggar TT,",
        "Tapi dimaksudkan adanya pengecekan dari kita adalah supaya... kalian mengerti bahwa di dunia perkuliahan ini masih ada orang yang menghargai kejujuran dan ketepatan kalian waktu mengumpulkan suatu tugas/ujian",
        "Karena mungkin ke depannya, kalian bakal bertemu dengan pengajar(dosen) atau asprak yang berbagai macam karakternya",
        "Jadii, buat yang kemarin udah jujur dan tepat waktu, kami ucapin makasihh bangettt dan pertahankann~",
        "Dan buat kemarin yang masih ada salahnya sedikit, its okay koo.. no hate beneran-",
        "Karena kami sebagai asprak pun juga manfaatin GPT di beberapa situasinya TT",
        "Overall boleh banget koo pakai GPT, tapi di situasi-situ tertentu yaa... misal bikin wrap ini wkwkwk (zuzur gpt jg ko guys)",
        "Pokonya apa yang kamu ambil dari GPT, usahakan bisa kalian tanggung jawabkan untuk teori dan asal usulnya~",
        "Keseluruhan, makasih banyak yaa %s karena udah mengikuti Praktikum Pemrograman Dasar ini hingga akhir",
        "Tetap semangat! Karena perjalanan kalian setelah ini masih panjang dan masih banyak keseruan yang menanti~",
        "Mungkin di satu semester kemarin kamu sempet ada ngerasa salah pilih langkah, salah atau telat ambil keputusan, atau mungkin ngerasa kurang di bidang tertentu",
        "Tapi it's okayy ko %s! Yang kamu rasain itu wajar...",
        "Kamu bisa sampai di titik ini, nyelesain UAP hingga membaca utas wrap ini pun juga salah satu bentuk pencapaian",
        "You did your best, %s!",
        "Jadi jangan nyerah yaa, habis UAP istirahat dan explore diri lebih lanjut!",
        "Akhir kata, sukses selalu %s!",
        "Note: Kata Kak Rizqi ditunggu di RAION, tapi nanti kalian diem-diem daftar BCC aja yhh~",
        "Next...",
        "<html><style>" +
        "body { font-family: Arial; font-size: 18px; color: #3C3C3C; text-align: center; }" +
        ".title { margin-bottom: 20px; font-weight: bold; }" + 
        ".content { margin-top: 10px; line-height: 1.8; }" +   
        "</style>" +
        "<body>" +
        "<div class='title'>%s's Pemdas Wrap</div>" +
        "<div class='content'>14x Pertemuan</div>" +
        "<div class='content'>2x Live Coding</div>" +
        "<div class='content'>1x Final Assignment</div>" +
        "<div class='content'>1x UTP</div>" +
        "<div class='content'>1x UAP</div>" +
        "</body></html>",
        "Pemrograman Dasar Teknologi Informasi B - done"
    };

    private final JTextPane messagePane;

    public SlideShowFrame() {
        setTitle("Pemdas Wrap");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama dengan GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(245, 245, 245));

        // JTextPane untuk pesan
        messagePane = new JTextPane();
        messagePane.setEditable(false);
        messagePane.setFont(new Font("Arial", Font.PLAIN, 18));
        messagePane.setForeground(new Color(60, 60, 60));
        messagePane.setBackground(new Color(245, 245, 245));
        messagePane.setMargin(new Insets(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(messagePane);
        scrollPane.setBorder(null);

        // Pengaturan GridBagConstraints untuk posisi tengah agak ke bawah
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane, gbc);

        // Panel navigasi
        JPanel navigationPanel = new JPanel();
        navigationPanel.setBackground(new Color(245, 245, 245));

        JButton prevButton = new JButton("Previous");
        prevButton.setEnabled(false); // Tombol Previous dinonaktifkan di slide pertama
        JButton nextButton = new JButton("Next");

        prevButton.addActionListener(e -> {
            if (currentSlide > 0) {
                currentSlide--;
                updateMessage();
            }
            nextButton.setEnabled(currentSlide < messages.length - 1);
            prevButton.setEnabled(currentSlide > 0);
        });

        nextButton.addActionListener(e -> {
            if (currentSlide < messages.length - 1) {
                currentSlide++;
                updateMessage();
            }
            nextButton.setEnabled(currentSlide < messages.length - 1);
            prevButton.setEnabled(currentSlide > 0);
        });

        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);

        gbc.gridy = 1;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(navigationPanel, gbc);

        add(mainPanel);

        // Meminta input nama dari pengguna
        userName = JOptionPane.showInputDialog(this, "Masukkan nama Anda:", "Input Nama", JOptionPane.PLAIN_MESSAGE);
        if (userName == null || userName.trim().isEmpty()) {
            userName = "Pengguna"; // Nama default jika tidak diisi
        }

        updateMessage();
        setVisible(true);
    }

    private void updateMessage() {
        if (currentSlide < messages.length) {
            String text = String.format(messages[currentSlide], userName, userName, userName);

            if (text.startsWith("<html>")) {
                messagePane.setContentType("text/html");
            } else {
                messagePane.setContentType("text/plain");
            }

            messagePane.setText(text);

            StyledDocument doc = messagePane.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
        }
    }
}
