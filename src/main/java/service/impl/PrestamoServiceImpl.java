package service.impl;


import Model.Prestamo;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import service.PrestamoService;

import java.util.ArrayList;
import java.util.Date;

public class PrestamoServiceImpl implements PrestamoService {
    ArrayList<Prestamo> prestamos = new ArrayList<>();
    int total=0;
    int precio=1000;

    @Override
    public boolean enviarCodigoPersona(String fechaInicial, String fechaFinal, String nombre, String perfil, String id) {
        System.out.println("entro al prestamo");
        prestamos.add(new Prestamo(fechaInicial, fechaFinal, nombre, perfil, id));
        return true;
    }


    @Override
    public boolean cantidadPrestamosRealizadoMonitor() {

        for (int i = 1; i < prestamos.size(); i++) {
            if (prestamos.get(i) != null && prestamos.get(i).getPerfil().equals("Monitor")) {
                System.out.println(prestamos.size()-1);
                break;
            }

        }
        return true;
    }

    @Override
    public boolean estudianteConMaPrestamos() {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i) != null && prestamos.get(i).getPerfil().equals("Estudiante") && prestamos.get(i).getNombre().equals(prestamos.get(i).getNombre())) {
                System.out.println(prestamos.size());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACION");
                alert.setContentText("Estudiante con mas prestamos es: " + prestamos.get(i).getNombre()+"id: "+prestamos.get(i).getId());
                alert.showAndWait();
                alert.getAlertType();
                break;
            }
        }
        return true;
    }

    public void calcular(String fechaFinal){
        for (int i = 0; i < prestamos.size(); i++) {
            System.out.println("siu");
            if (prestamos.get(i) != null) {
                System.out.println(prestamos.get(i).getNombre());
                total=precio*Integer.parseInt(fechaFinal);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMACION");
                alert.setContentText("Total del prestamo: "+String.valueOf(total));
                alert.showAndWait();
                alert.getAlertType();
                break;

            }
        }
    }




}
