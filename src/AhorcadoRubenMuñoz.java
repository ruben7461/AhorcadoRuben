/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ruben
 */
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;



        
public class AhorcadoRubenMuñoz extends javax.swing.JFrame {

    
    //creamos un array donde almacenaremos todas las palabras pero lo declaramos
    // en el metodo PalabrasRan
    String [] Lista;
    
    //String que contiene la palabra oculta
    String PalabraOculta;
    int numeroFallos = 0;
    
    /**
     * Creates new form AhorcadoRubenMuñoz
     */
    public AhorcadoRubenMuñoz() {
        initComponents();
        
        //inicializamos el metodo que pone la palabra al azar
        eligePalabraParaAdivinar();
        
        //llamamos al metodo ImagenFallos para que dibuje la imagen
        ImagenFallos(0);
        
        //chequea el String que este en la ventana,y devuelve guiones bajos
        ponGuiones();
        
        
    }

    
     private void eligePalabraParaAdivinar(){
        
        

//declaramos ya el array que hemos creado en el constructor y le damos
//las palabras que queremos 
 Lista = new String[] {"HOLA","ADIOS","DELFIN","CABALLO","COCODRILO","OCA","SALMON","TRUCHA","PERRO","GATO"};

 
 
 //creamos un nuevo Random para que elija mas adelante una palabra al azar
 //dentro del array que hemos creado
        Random aleatorio = new Random();
        
        
        //declaramos que la posicion Elegida sea igual una palabra aleatoria
        //y devuelva cuantas letras contiene esa palabra
        int posicionElegida = aleatorio.nextInt(Lista.length);
        //guardo en la palabraoculta la que haya salido al azar
        PalabraOculta = Lista[posicionElegida];
    }
     
     
     
     
     
     
     
    //Creamos un metodo para comprobar si la letra que hemos pulsado,
    //en alguna celda del string,si está,dibujamos esa letra en el 
    //
    private void ChequeaLetra(String letra){
        
        //en este caso,cada letra que detecte,las convierte en mayusculas
        letra = letra.toUpperCase();
        
        
        //creamos una clase StreamBuilder para por modificar un String 
        //creando uno nuevo en local 
      StringBuilder PalabraConGuiones = new StringBuilder(Ventana.getText());
        
        if(PalabraOculta.contains(letra)){
            for (int  i= 0; i < PalabraOculta.length(); i++){
                if(PalabraOculta.charAt(i) == letra.charAt(0)){
                 PalabraConGuiones.setCharAt(2*i,letra.charAt(0));
                 
                }
                
                Ventana.setText(PalabraConGuiones.toString());
            }
        }
        
        //si no es igual,incrementa el numero de fallos y dibuja la imagen 
        //correspondiente al numero de fallos
        else{
            numeroFallos++;
            ImagenFallos(numeroFallos);
        }
        if (!Ventana.getText().contains("_")){
             ImagenFallos(-1);
             
        }
    }
    
    
    
    
    
    //creamos un metodo para dibujar las imagenes
    private void ImagenFallos( int numeroFallos){
        
        
       
        //cuando se inicialize sea el caso 0 
        URL nombreImagen = null;
        
        //declaramos dos constantes donde nos va a decir que tamaño tiene 
        //la ventana para que la imagen se ajuste a ella
        int ancho = VentanaAhorcado.getWidth();
        int alto = VentanaAhorcado.getHeight();
        
        
        //decñaramos los posibles casos y dependiendo del numero de fallos,
        //dibuja una imagen u otra
         switch(numeroFallos){
    case 0: nombreImagen = getClass().getResource("/Imagenes/ahorcado_0.png");break;
    case 1: nombreImagen = getClass().getResource("/Imagenes/ahorcado_1.png");break;
    case 2: nombreImagen = getClass().getResource("/Imagenes/ahorcado_2.png");break;
    case 3: nombreImagen = getClass().getResource("/Imagenes/ahorcado_3.png");break;
    case 4: nombreImagen = getClass().getResource("/Imagenes/ahorcado_4.png");break;
    case 5: nombreImagen = getClass().getResource("/Imagenes/ahorcado_5.png");break;
    case -1: nombreImagen = getClass().getResource("/Imagenes/acertasteTodo.png");break;
    //para que no de fallo si no existe ningun caso con los numeros declarados,
    //ejecuto una sentencia default que saltara cuando esto pase
    default: nombreImagen = getClass().getResource("/Imagenes/ahorcado_fin.png");break;
        
         }
         
         
         
        //Para pintar la imagen deseada,necesitamos llamar a ImageIcon 
        //y llame a nombreImagen
        //y reescalamos al tammaño deseado y que le pasamos 
        ImageIcon ImagenDefult = new ImageIcon(new ImageIcon(nombreImagen).getImage().getScaledInstance(ancho, alto,Image.SCALE_DEFAULT));
        
        
        //dejamos la imagen por defecto
        VentanaAhorcado.setIcon(ImagenDefult);
        
    }
    
    
    
    
    //chequea el boton para que verifique que letra ha pulsado,inhbilitarlo
    private void chequeaBoton(JButton boton){
        
        //declaramos que al producirse el evento,el boton lo deshabilite
        boton.setEnabled(false);
        
        //llamamos al metodo y le pasamos la letra que hemos pulsado
        ChequeaLetra(boton.getText());
        //
    }
    
    
    
    //metodo que pone guiones respecto a las palabras que tengas que adivinar
     private void ponGuiones(){
        
        //crea un nuevo string con tantos guines bajos y espacios en blanco
        //como letras tenga que adivinar
      String PalabraConGuiones = "";
      
      
      
      //comprueba el string en cada uno de los espacios y comprueba si
      //ocupado y le mete un guion bajo y un espacio
      for (int i=0; i<PalabraOculta.length(); i++){
        PalabraConGuiones = PalabraConGuiones + "_ ";
      
        }
      
      //muestra palabra con guiones
      Ventana.setText((PalabraConGuiones));
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ventana = new javax.swing.JLabel();
        A = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        E = new javax.swing.JButton();
        F = new javax.swing.JButton();
        I = new javax.swing.JButton();
        J = new javax.swing.JButton();
        K = new javax.swing.JButton();
        L = new javax.swing.JButton();
        M = new javax.swing.JButton();
        N = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        R = new javax.swing.JButton();
        S = new javax.swing.JButton();
        T = new javax.swing.JButton();
        U = new javax.swing.JButton();
        V = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        O = new javax.swing.JButton();
        P = new javax.swing.JButton();
        W = new javax.swing.JButton();
        X = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        VentanaAhorcado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Ventana.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        Ventana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ventana.setText("_ _ _ _ _");

        A.setText("A");
        A.setAlignmentX(50.0F);
        A.setAlignmentY(50.0F);
        A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AMousePressed(evt);
            }
        });

        B.setText("B");
        B.setAlignmentX(50.0F);
        B.setAlignmentY(50.0F);
        B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BMousePressed(evt);
            }
        });

        C.setText("C");
        C.setAlignmentX(50.0F);
        C.setAlignmentY(50.0F);
        C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CMousePressed(evt);
            }
        });

        D.setText("D");
        D.setAlignmentX(50.0F);
        D.setAlignmentY(50.0F);
        D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DMousePressed(evt);
            }
        });

        E.setText("E");
        E.setAlignmentX(50.0F);
        E.setAlignmentY(50.0F);
        E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EMousePressed(evt);
            }
        });

        F.setText("F");
        F.setAlignmentX(50.0F);
        F.setAlignmentY(50.0F);
        F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FMousePressed(evt);
            }
        });

        I.setText("I");
        I.setAlignmentX(50.0F);
        I.setAlignmentY(50.0F);
        I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IMousePressed(evt);
            }
        });

        J.setText("J");
        J.setAlignmentX(50.0F);
        J.setAlignmentY(50.0F);
        J.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JMousePressed(evt);
            }
        });

        K.setText("K");
        K.setAlignmentX(50.0F);
        K.setAlignmentY(50.0F);
        K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KMousePressed(evt);
            }
        });

        L.setText("L");
        L.setAlignmentX(50.0F);
        L.setAlignmentY(50.0F);
        L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LMousePressed(evt);
            }
        });

        M.setText("M");
        M.setAlignmentX(50.0F);
        M.setAlignmentY(50.0F);
        M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MMousePressed(evt);
            }
        });

        N.setText("N");
        N.setAlignmentX(50.0F);
        N.setAlignmentY(50.0F);
        N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NMousePressed(evt);
            }
        });

        Q.setText("Q");
        Q.setAlignmentX(50.0F);
        Q.setAlignmentY(50.0F);
        Q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                QMousePressed(evt);
            }
        });

        R.setText("R");
        R.setAlignmentX(50.0F);
        R.setAlignmentY(50.0F);
        R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RMousePressed(evt);
            }
        });

        S.setText("S");
        S.setAlignmentX(50.0F);
        S.setAlignmentY(50.0F);
        S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SMousePressed(evt);
            }
        });

        T.setText("T");
        T.setAlignmentX(50.0F);
        T.setAlignmentY(50.0F);
        T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TMousePressed(evt);
            }
        });

        U.setText("U");
        U.setAlignmentX(50.0F);
        U.setAlignmentY(50.0F);
        U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UMousePressed(evt);
            }
        });

        V.setText("V");
        V.setAlignmentX(50.0F);
        V.setAlignmentY(50.0F);
        V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                VMousePressed(evt);
            }
        });

        G.setText("G");
        G.setAlignmentX(50.0F);
        G.setAlignmentY(50.0F);
        G.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GMousePressed(evt);
            }
        });
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });

        H.setText("H");
        H.setAlignmentX(50.0F);
        H.setAlignmentY(50.0F);
        H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HMousePressed(evt);
            }
        });

        O.setText("O");
        O.setAlignmentX(50.0F);
        O.setAlignmentY(50.0F);
        O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OMousePressed(evt);
            }
        });
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });

        P.setText("P");
        P.setAlignmentX(50.0F);
        P.setAlignmentY(50.0F);
        P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PMousePressed(evt);
            }
        });

        W.setText("W");
        W.setAlignmentX(50.0F);
        W.setAlignmentY(50.0F);
        W.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                WMousePressed(evt);
            }
        });

        X.setText("X");
        X.setAlignmentX(50.0F);
        X.setAlignmentY(50.0F);
        X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                XMousePressed(evt);
            }
        });

        Z.setText("Z");
        Z.setAlignmentX(50.0F);
        Z.setAlignmentY(50.0F);
        Z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ZMousePressed(evt);
            }
        });

        Y.setText("Y");
        Y.setAlignmentX(50.0F);
        Y.setAlignmentY(50.0F);
        Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                YMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(VentanaAhorcado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(J, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Ventana, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ventana, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(VentanaAhorcado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(224, 224, 224))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AMousePressed
       
        //con esto,casteamos el evt y lo convertimos directamente
        //el objeto general a un Jbutton
        chequeaBoton ( (JButton) evt.getSource());
        
    
    }//GEN-LAST:event_AMousePressed

    private void BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_BMousePressed

    private void CMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_CMousePressed

    private void DMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_DMousePressed

    private void EMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_EMousePressed

    private void FMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_FMousePressed

    private void IMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_IMousePressed

    private void JMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_JMousePressed

    private void KMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_KMousePressed

    private void LMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_LMousePressed

    private void MMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_MMousePressed

    private void NMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_NMousePressed

    private void QMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_QMousePressed

    private void RMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_RMousePressed

    private void SMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_SMousePressed

    private void TMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_TMousePressed

    private void UMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_UMousePressed

    private void VMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_VMousePressed

    private void GMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_GMousePressed

    private void HMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_HMousePressed

    private void OMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_OMousePressed

    private void PMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_PMousePressed

    private void WMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_WMousePressed

    private void XMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_XMousePressed

    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_GActionPerformed

    private void ZMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_ZMousePressed

    private void YMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YMousePressed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_YMousePressed

    private void OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OActionPerformed
        chequeaBoton ( (JButton) evt.getSource());
    }//GEN-LAST:event_OActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AhorcadoRubenMuñoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AhorcadoRubenMuñoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AhorcadoRubenMuñoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AhorcadoRubenMuñoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AhorcadoRubenMuñoz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A;
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JButton F;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JButton T;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JLabel Ventana;
    private javax.swing.JLabel VentanaAhorcado;
    private javax.swing.JButton W;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    // End of variables declaration//GEN-END:variables
}
