package militaryElite.models;

import militaryElite.interfaces.LeutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Set<Private> pruvates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.pruvates =new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private first, Private second) {
                return 0;
            }
        });
    }


    @Override
    public void addPrivate(Private priv) {
        this.pruvates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Privates:").append(System.lineSeparator());

        for (Private aPrivate : pruvates) {
            sb.append(aPrivate.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
