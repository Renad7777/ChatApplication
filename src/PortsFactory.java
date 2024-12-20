/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mossa
 */
public class PortsFactory {
    public static final int port1=1;
        public static final int port2=2;
public static Ports creatPorts(int id){
    switch (id) {
        case port1:return new Port1();
        case port2:return new Port2();
            
         
    }


        return null;



};

}
