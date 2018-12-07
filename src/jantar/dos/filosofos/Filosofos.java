/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantar.dos.filosofos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Filosofos {
    
    public class Garfos extends Thread{
        private final int garfoEsquerda;
        private final int garfoDireita;
    
        public Garfos(int garfoEsquerda, int garfoDireita){
            this.garfoEsquerda = garfoEsquerda;
            this.garfoDireita = garfoDireita;
        }
    
        @Override
        public void run(){
            while (true){
                try {
                    SorteioDireita();
                    SorteioEsquerda();
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    System.out.println(ex);
                }
            }

        }
    
        public void SorteioDireita(){
            int garfoDireita;
            Random d = new Random();
            garfoDireita = d.nextInt(5);

            System.err.println("O garfo da direita sorteado " + garfoDireita);

        }
    
        public void SorteioEsquerda(){
            int garfoEsquerda;
            Random d = new Random();
            garfoEsquerda = d.nextInt(5);

            System.out.println("O garfo da esquerda sorteado " + garfoEsquerda);

        }
    }
    
    public class Filosofo extends Thread{
        int id;
        Garfos garfo;
        int lugarNaMesa;
        int posicao;

        public Filosofo(int id, Garfos garfo, int lugarNaMesa){
            this.id = id;
            this.garfo = garfo;
            this.lugarNaMesa = lugarNaMesa;
            this.posicao = id%2;

            System.out.println("O Filosofo " + id + " sentou a mesa");
        }

        public void Pensar() throws InterruptedException{
            System.out.println("O Filosofo " + id + " esta pensando" );
            Thread.sleep(1000);
        }

        @Override
        public void run(){
            while(true){
                if(garfo.garfoDireita == 5){
                    System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 1){
                        System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo "+ id+ " esta comendo");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da direita");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("O Filosofo "+ id+ " largou o garfo " + garfo.garfoDireita);
                    }
                } else{
                    try{
                        Pensar();
                    } catch(InterruptedException ex){
                        System.out.println(ex);

                    }
                }

                if(garfo.garfoDireita == 1){
                    System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 2){
                        System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo "+ id+ " esta comendo");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da direita");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("O Filosofo "+ id+ " largou o garfo " + garfo.garfoDireita);
                    }
                } else{
                    try{
                        Pensar();
                    } catch(InterruptedException ex){
                        System.out.println(ex);

                    }
                }

                if(garfo.garfoDireita == 2){
                    System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 3){
                        System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo "+ id+ " esta comendo");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da direita");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("O Filosofo "+ id+ " largou o garfo " + garfo.garfoDireita);
                    }
                } else{
                    try{
                        Pensar();
                    } catch(InterruptedException ex){
                        System.out.println(ex);

                    }
                }

                if(garfo.garfoDireita == 3){
                    System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 4){
                        System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo "+ id+ " esta comendo");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da direita");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("O Filosofo "+ id+ " largou o garfo " + garfo.garfoDireita);
                    }
                } else{
                    try{
                        Pensar();
                    } catch(InterruptedException ex){
                        System.out.println(ex);

                    }
                }

                if(garfo.garfoDireita == 4){
                    System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 5){
                        System.out.println("O Filosofo "+ id+ " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo "+ id+ " esta comendo");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da direita");
                        System.out.println("O Filosofo "+ id+ " largou o garfo da esquerda");
                    } else{
                        System.out.println("O Filosofo "+ id+ " largou o garfo " + garfo.garfoDireita);
                    }
                } else{
                    try{
                        Pensar();
                    } catch(InterruptedException ex){
                        System.out.println(ex);

                    }
                }
            }
        }
    }

    public void test(){
        Garfos parGarfos1 = new Garfos(1, 5);
        Garfos parGarfos2 = new Garfos(2, 1);
        Garfos parGarfos3 = new Garfos(3, 2);
        Garfos parGarfos4 = new Garfos(4, 3);
        Garfos parGarfos5 = new Garfos(5, 4);

        Filosofo filosofo1 = new Filosofo(1, parGarfos1,1);
        Filosofo filosofo2 = new Filosofo(2, parGarfos2,2);
        Filosofo filosofo3 = new Filosofo(3, parGarfos3,3);
        Filosofo filosofo4 = new Filosofo(4, parGarfos4,4);
        Filosofo filosofo5 = new Filosofo(5, parGarfos5,5);

        new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();

    }

}
