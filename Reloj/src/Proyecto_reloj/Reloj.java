/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_reloj;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Edison
 */
public class Reloj extends javax.swing.JFrame implements Runnable {

    private String hora, minutos, segundos, estadoTiempo;
    private Calendar calendar;
    private Thread hilo;
    
    public Reloj(){
       initComponents();
       hilo = new Thread(this);
       hilo.start();
       setLocationRelativeTo(null);
       setTitle("Reloj");
       setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblReloj.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while(thread == hilo){
        calcular();
        lblReloj.setText(hora+":"+minutos+":"+segundos+" "+estadoTiempo);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            
        }
        }
    }
    
   private void calcular(){
       Calendar calendario = new GregorianCalendar();
       Date fechaHoraActual = new Date();
       calendario.setTime(fechaHoraActual);
       estadoTiempo = calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";
       int h;
       if(estadoTiempo.equals("PM")){
           h = calendario.get(Calendar.HOUR_OF_DAY)-12;
           hora = h>9?""+h:"0"+h;
       }else{
           hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
       }
       minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
       segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
   }
  

}
