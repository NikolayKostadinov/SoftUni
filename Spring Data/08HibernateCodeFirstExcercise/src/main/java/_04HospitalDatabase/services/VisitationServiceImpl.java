package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.Visitation;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.VisitationModel;

import java.io.IOException;
import java.util.List;

public class VisitationServiceImpl implements Service<Visitation, VisitationModel>{
    //todo: implement this
    @Override
    public Visitation create() throws ValidationException, IOException {
        return null;
    }

    @Override
    public List<VisitationModel> getAll() {
        return null;
    }
}
