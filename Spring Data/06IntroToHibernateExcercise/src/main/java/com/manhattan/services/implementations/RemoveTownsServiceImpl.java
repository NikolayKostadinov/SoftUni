package com.manhattan.services.implementations;

import com.manhattan.common.Utilities;
import com.manhattan.entities.Address;
import com.manhattan.entities.Town;
import com.manhattan.services.interfaces.Service;

import javax.persistence.EntityManager;

import java.io.IOException;
import java.util.List;

import static com.manhattan.common.Utilities.printResultMessage;
import static com.manhattan.common.Utilities.readStringFromConsole;

public class RemoveTownsServiceImpl extends BaseServiceImpl {

    public RemoveTownsServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        try {
            String townName = readStringFromConsole("Enter town name: ");
            Town town = getTownByName(townName);
            this.entityManager.getTransaction().begin();
            int deletedAddresses = deleteAddressesByTownId(town.getId());
            this.entityManager.remove(town);
            this.entityManager.getTransaction().commit();

            printResultMessage(String.format("%d address in %s deleted", deletedAddresses, townName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int deleteAddressesByTownId(int townId) {
        List<Address> addresses = this.entityManager.createQuery(
                        "SELECT a FROM Address a " +
                                "WHERE a.town.id = :townId ", Address.class)
                .setParameter("townId", townId)
                .getResultList();
        int addressesCount = addresses.size();
            addresses.forEach(entityManager::remove);
        return addressesCount;
    }

    private Town getTownByName(String townName) {
        return this.entityManager.createQuery(
                        "SELECT t " +
                                "FROM Town t " +
                                "WHERE t.name = :townName ", Town.class)
                .setParameter("townName", townName)
                .getResultStream().findFirst().orElse(null);
    }
}
