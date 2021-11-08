package P06MilitaryElite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Privates:" + System.lineSeparator()
                + this.privates.stream()
                .sorted(Comparator.comparingInt(Soldier::getId).reversed())
                .map(p->p.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
