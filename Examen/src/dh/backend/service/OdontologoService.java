package dh.backend.service;

import dh.backend.dao.iDao;
import dh.backend.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(iDao<Odontologo> odontologoiDao){
        this.odontologoiDao = odontologoiDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);


    }
    public List<Odontologo> listarTodos(){
        return odontologoiDao.listarTodos();
    }

}
