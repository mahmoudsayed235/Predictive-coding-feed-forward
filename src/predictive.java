
import java.lang.Math;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * predictive.java
 *
 * Created on Dec 2, 2010, 3:31:44 AM
 */
/**
 *
 * @author midoyass
 */
public class predictive extends javax.swing.JFrame {

    /** Creates new form predictive */
    public predictive() {
        initComponents();
    }
    public static int width;
    public static int height;

    public static int[][] readImage(String filePath) {
        File file = new File(filePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        int[][] pixels = new int[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = (rgb >> 0) & 0xff;

                pixels[y][x] = r;
            }
        }

        return pixels;
    }

    public static void writeImage(int[][] pixels, int height, int width, String outputFilePath) {
        File fileout = new File(outputFilePath);
        BufferedImage image2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image2.setRGB(x, y, (pixels[y][x] << 16) | (pixels[y][x] << 8) | (pixels[y][x]));
            }
        }
        try {
            ImageIO.write(image2, "jpg", fileout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getMax(ArrayList<Integer> im) {
        int max = 0;
        for (int i = 0; i < im.size(); i++) {

            if (im.get(i) > max) {
                max = im.get(i);
            }

        }
        return max;
    }

    public static int getMin(ArrayList<Integer> im) {
        int min = im.get(0);
        for (int i = 0; i < im.size(); i++) {

            if (im.get(i) < min) {
                min = im.get(i);
            }

        }
        return min;
    }

    public static ArrayList<Integer> arrList(int copy[][]) {
        ArrayList<Integer> newArr = new ArrayList();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newArr.add(copy[i][j]);
            }
        }
        return newArr;
    }

    public static int[][] newPic(ArrayList<Integer> codePic) {
        int[][] dumy = new int[height][width];
        int i = 0;
        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                dumy[j][k] = codePic.get(i);
                i++;
            }
        }
        return dumy;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new javax.swing.JPanel();
        Compress = new javax.swing.JButton();
        levelArea = new javax.swing.JTextField();
        Decompress = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Decompress_Done = new javax.swing.JLabel();
        Compress_done = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pic.setBackground(new java.awt.Color(0, 0, 0));

        Compress.setText("Compress");
        Compress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompressActionPerformed(evt);
            }
        });

        levelArea.setText("0");
        levelArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelAreaActionPerformed(evt);
            }
        });

        Decompress.setText("Decompress");
        Decompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecompressActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Blackadder ITC", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Predictive");

        Decompress_Done.setFont(new java.awt.Font("Blackadder ITC", 0, 36)); // NOI18N
        Decompress_Done.setForeground(new java.awt.Color(255, 51, 51));

        Compress_done.setFont(new java.awt.Font("Blackadder ITC", 0, 36)); // NOI18N
        Compress_done.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addGroup(picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(picLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(levelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, picLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Decompress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(Compress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addGap(94, 94, 94)
                        .addGroup(picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Compress_done, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Decompress_Done, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(picLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(levelArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Compress)
                    .addComponent(Compress_done, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(exit)
                .addGap(30, 30, 30)
                .addGroup(picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Decompress)
                    .addComponent(Decompress_Done, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompressActionPerformed
        this.Compress_done.setText("");
        PrintWriter output, codePic;
        try {
            output = new PrintWriter("Q-1.txt");
            String string;
            codePic = new PrintWriter("code.txt");
            string = this.levelArea.getText();
            int level = Integer.parseInt(string);
            level = (int) Math.pow(2, level);
            float range;
            float minimum;
            float maximum;
            float step;
            ArrayList<Float> rng = new ArrayList();
            ArrayList<Integer> Q = new ArrayList();
            ArrayList<Float> Q1 = new ArrayList();
            ArrayList<Integer> diff = new ArrayList();
            ArrayList<Integer> px = new ArrayList();
            ArrayList<Integer> code = new ArrayList();
            int img[][] = readImage("1.jpg");
            output.println(img[0][0]);
            writeImage(img, height, width, "black.jpg");
            px = predictive.arrList(img);
            diff.add(0);
            for (int i = 1; i < px.size(); i++) {
                diff.add(px.get(i) - px.get(i - 1));
            }
            minimum = predictive.getMin(diff);
            maximum = predictive.getMax(diff);
            range = maximum - minimum;
            step = range / level;
            float dummy = 0;
            dummy = step + minimum;
            rng.add(dummy);
            while ((dummy + step) <= maximum) {
                dummy = dummy + step;

                rng.add(dummy);
            }
            if (rng.get(rng.size() - 1) != maximum) {
                rng.set(rng.size() - 1, maximum);
            }                                            //handala 3shan at2aked en 2a5er range ykon b = el max
            float firstQ1 = minimum + step;
            Q1.add(minimum + firstQ1 / 2);
            output.println(minimum + firstQ1 / 2);
            for (int i = 1; i < rng.size(); i++) {
                Q1.add((rng.get(i - 1) + rng.get(i)) / 2);
                output.println((rng.get(i - 1) + rng.get(i)) / 2); // 3shan asave in file
            }
            for (int i = 0; i < rng.size(); i++) {
                code.add(i);
            }
            Q.add(0);
            for (int i = 1; i < diff.size(); i++) {
                for (int j = 0; j < rng.size(); j++) {
                    if (diff.get(i) <= rng.get(j)) {
                        Q.add(code.get(j));
                        break;
                    }
                }
            }
            img = predictive.newPic(Q);
            for (int i = 0; i < Q.size(); i++) {
                codePic.println(Q.get(i));
            }
            writeImage(img, height, width, "compress.jpg");
            output.close();
            codePic.close();
            this.Compress_done.setText("Done !!");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
}//GEN-LAST:event_CompressActionPerformed

    private void levelAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelAreaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_levelAreaActionPerformed

    private void DecompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecompressActionPerformed
        this.Decompress_Done.setText("");
        int img[][] = readImage("compress.jpg");
        this.Decompress_Done.setText("");
        File file = new File("Q-1.txt");
        File f = new File("code.txt");
        Scanner codeOfImage, QMinusOne;
        try {
            QMinusOne = new Scanner(file);
            codeOfImage = new Scanner(f);
            ArrayList<Float> Q1 = new ArrayList();
            ArrayList<Float> codeImage = new ArrayList();
            ArrayList<Integer> Samples = new ArrayList();
            int first = QMinusOne.nextInt();
            Q1.add((float) 0);
            while (QMinusOne.hasNext()) {

                Q1.add(QMinusOne.nextFloat());
            }
            while (codeOfImage.hasNext()) {

                codeImage.add(codeOfImage.nextFloat());
            }
            Samples.add(first);
            float Qminus1;
            double newnum;
            int dumy;
            int dumy1;
            int dumy2;
            for (int i = 0; i < codeImage.size(); i++) {
                Qminus1 = codeImage.get(i);
                dumy = (int) Qminus1;
                newnum = Q1.get(dumy + 1);
                dumy2 = (int) newnum;
                dumy1 = Samples.get(Samples.size() - 1);
                if(dumy1 + dumy2>255)
                {
                    Samples.add(255);
                }
                else if(dumy1 + dumy2<0)
                {
                    Samples.add(0);
                }
                else
                Samples.add(dumy1 + dumy2);

            }

            img = predictive.newPic(Samples);
            writeImage(img, height, width, "Decompress.jpg");
            codeOfImage.close();
            QMinusOne.close();
            this.Decompress_Done.setText("Done !!");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_DecompressActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new predictive().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Compress;
    private javax.swing.JLabel Compress_done;
    private javax.swing.JButton Decompress;
    private javax.swing.JLabel Decompress_Done;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField levelArea;
    private javax.swing.JPanel pic;
    // End of variables declaration//GEN-END:variables
}
