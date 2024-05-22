package dh.backend.test;

import dh.backend.dao.impl.OdontologoDaoH2;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoEnMemoriaTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    @DisplayName("Testear que un odontologo esta guardado")

    void testOdontologoGuardado(){
        Odontologo odontologo = new Odontologo("234567", "Juan", "Perez");
        Odontologo odontologoMemoria = odontologoService.guardarOdontologo(odontologo);

        assertNotNull(odontologoMemoria);
    }

    @Test
    @DisplayName("Testear listar los odontologo")
    void testLista() {
        Odontologo odontologo = new Odontologo("234567", "Juan", "Perez");
        odontologoService.guardarOdontologo(odontologo);
        List<Odontologo> odontologos = odontologoService.listarTodos();

        assertTrue(odontologos.size()!=0);
    }

}
