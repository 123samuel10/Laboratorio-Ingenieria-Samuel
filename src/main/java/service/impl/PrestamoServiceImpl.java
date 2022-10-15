package service.impl;


import Model.Prestamo;
import javafx.scene.control.Alert;
import service.PrestamoService;

import java.util.ArrayList;

public class PrestamoServiceImpl implements PrestamoService {
    ArrayList<Prestamo>prestamos=new ArrayList<>();

    @Override
    public boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String nombre,String perfil,String id){
        System.out.println("entro al prestamo");
        prestamos.add(new Prestamo(fechaInicial,fechaFinal,nombre,perfil,id));

        for (int i=0;i<prestamos.size();i++){
            System.out.println("siu");
            if (prestamos.get(i)!=null) {
                System.out.println(fechaInicial);
                System.out.println(fechaFinal);
                System.out.println(prestamos.get(i).getNombre());
                System.out.println(id);
            }
        }

        return true;
    }
    @Override
    public boolean cantidadPrestamosRealizadoMonitor(String nombre) {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i)!=null && prestamos.get(i).getNombre().equals(nombre)) {
                System.out.println("la cantidad de prestamos realizado por esas persona es: "+" "+prestamos.size());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACION");
                alert.setContentText("la cantidad de prestamos realizado por esa persona son "+" "+prestamos.size()+" "+"prestamos");
                alert.showAndWait();
                alert.getAlertType();
            }
        }
        return true;
    }

    @Override
    public boolean estudianteConMaPrestamos() {
        for (int i=0;i<prestamos.size();i++){
            if (prestamos.get(i)!=null && prestamos.get(i).getPerfil().equals("Estudiante")&& prestamos.get(i).getNombre().equals(prestamos.get(i).getNombre())){
                System.out.println(prestamos.size());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACION");
                alert.setContentText("Estudiante con mas prestamos es: "+prestamos.get(i).getNombre());
                alert.showAndWait();
                alert.getAlertType();
                break;
            }
        }
        return true;
    }




}
