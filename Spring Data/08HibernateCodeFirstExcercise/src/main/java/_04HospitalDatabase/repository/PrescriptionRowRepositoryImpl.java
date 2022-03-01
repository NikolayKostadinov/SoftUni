package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.PrescriptionRow;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.PrescriptionRowModel;

import javax.persistence.EntityManager;
import java.util.List;

public class PrescriptionRowRepositoryImpl extends BaseRepository implements Repository<PrescriptionRow, PrescriptionRowModel, Integer>{
    //todo: implement this
    public PrescriptionRowRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<PrescriptionRowModel> all() {
        return null;
    }

    @Override
    public PrescriptionRow persist(PrescriptionRowModel entity) throws ValidationException {
        return null;
    }
}
