package dh.backend.test;


import dh.backend.dao.iDao;
import dh.backend.dao.impl.OdontologoDaoH2;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {
    private static Logger LOGGER = Logger.getLogger(OdontologoServiceTest.class);
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/db_prueba;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear guardar un odontologo")
    void testOdontologoGuardado() {
        Odontologo odontologo = new Odontologo("234567", "Juan", "Perez");
        Odontologo odontologoBD = odontologoService.guardarOdontologo(odontologo);

        assertNotNull(odontologoBD);
    }
    @Test
    @DisplayName("Testear listar los odontologo")
    void testLista() {
        Odontologo odontologo = new Odontologo("234567", "Juan", "Perez");
        Odontologo odontologoBD = odontologoService.guardarOdontologo(odontologo);
        List<Odontologo> odontologos = odontologoService.listarTodos();

        assertEquals(1, odontologos.size());
    }

}
