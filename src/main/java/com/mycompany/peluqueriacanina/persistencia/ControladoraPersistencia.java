
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioController = new DuenioJpaController();
    
    MascotaJpaController mascotaController = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
       //CREAR EN BD EL DUEÑO
       duenioController.create(duenio);
       
       //CREAR EN BD LA MASCOTA
       mascotaController.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotaController.findMascotaEntities();

    }

    public void borrarMascota(int num_cliente) {
        try {
            mascotaController.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
        return mascotaController.findMascota(num_cliente);

    }

    public void modificarMascota(Mascota mascota) {
        try {
            mascotaController.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Duenio traerDuenio(int id_dueño) {
        return duenioController.findDuenio(id_dueño);

    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioController.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    
}
