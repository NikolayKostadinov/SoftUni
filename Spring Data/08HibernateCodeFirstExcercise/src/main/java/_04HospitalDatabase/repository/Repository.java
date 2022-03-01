package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Town;
import _04HospitalDatabase.exceptions.ValidationException;

import java.util.List;

public interface Repository<T, TModel, Tid> {
    boolean exists(Tid id);

    List<TModel> all();

    T persist(TModel entity) throws ValidationException;
}