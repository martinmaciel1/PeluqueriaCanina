
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombre_mascota, String raza, String color, String observaciones, String nombreDuenio, String celularDuenio, String alergico, String atencionEspecial) {
       //CREO EL DUEÑO Y ASIGNO LOS VALORES
       Duenio duenio = new Duenio();
       duenio.setNombre(nombreDuenio);
       duenio.setCelDueño(celularDuenio);
       
       //CREO LA MASCOTA Y ASIGNO LOS VALORES
       Mascota mascota = new Mascota();
       mascota.setNombre(nombre_mascota);
       mascota.setColor(color);
       mascota.setObservaciones(observaciones);
       mascota.setAlergico(alergico);
       mascota.setAtencion_especial(atencionEspecial);
       mascota.setRaza(raza);

       //ACA SE ASIGNA EL DUEÑO A LA MASCOTA ---- 1 A 1
       mascota.setUnDuenio(duenio);
       
        controlPersis.guardar(duenio,mascota);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
            controlPersis.borrarMascota(num_cliente);
        
    }

    public Mascota traerMascota(int num_cliente) {
            return controlPersis.traerMascota(num_cliente);

    }

    public void modificarMascota(Mascota mascota, String nombre_mascota, String raza, String color, String observaciones, String nombreDuenio, String celularDuenio, String alergico, String atencionEspecial) {
            mascota.setNombre(nombre_mascota);
            mascota.setRaza(raza);
            mascota.setColor(color);
            mascota.setObservaciones(observaciones);
            mascota.setAlergico(alergico);
            mascota.setAtencion_especial(atencionEspecial);
            
            controlPersis.modificarMascota(mascota);
            
            Duenio duenio = buscarDuenio(mascota.getUnDuenio().getId_dueño());
            duenio.setCelDueño(celularDuenio);
            duenio.setNombre(nombreDuenio);
            
            modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_dueño) {
        return controlPersis.traerDuenio(id_dueño);
    }

    private void modificarDuenio(Duenio duenio) {
         controlPersis.modificarDuenio(duenio);

    }

  
    
}
