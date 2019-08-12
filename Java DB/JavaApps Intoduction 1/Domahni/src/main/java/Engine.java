import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private Connection connection;
    private BufferedReader br;

    public Engine(Connection connection) {
        this.connection = connection;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        try {
            //this.getVillainsNames(); //=> Problem 02
            //this.getMinionNames(); //=> Problem 03
            //this.addMinion(); //=> Problem 04
            this.changeTownNamesCasing(); //=> Problem 05
            //this.removeVillain(); //=> Problem 06     ?????????????????????
            //this.printAllMinionNames(); //=> Problem 07
            //this.increaseMinionsAge(); //=> Problem 08
            //this.increaseAgeStoredProcedure(); //=> Problem 09


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //=================Problem 09=======================================
    private void increaseAgeStoredProcedure() throws SQLException, IOException {
        int minionId = Integer.parseInt(br.readLine());

        String updateMinionAgequery = "CALL usp_get_older(?);";

        PreparedStatement psGetOlder = connection.prepareStatement(updateMinionAgequery);

        psGetOlder.setInt(1, minionId);
        psGetOlder.executeUpdate();

        String selectMinionById = "SELECT name, age FROM minions WHERE id = ?;";
        PreparedStatement psSelectMinionById = connection.prepareStatement(selectMinionById);
        psSelectMinionById.setInt(1, minionId);

        ResultSet rsSelectMinionById = psSelectMinionById.executeQuery();
        rsSelectMinionById.next();

        System.out.println(rsSelectMinionById.getString(1)
                + " " + rsSelectMinionById.getInt(2));

    }

    //=================Problem 08=======================================
    private void increaseMinionsAge() throws IOException, SQLException {
        List<Integer> ids = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String updateMinionsQuery = "UPDATE minions set age = age+1 WHERE id = ?;";

        PreparedStatement psMinions = connection.prepareStatement(updateMinionsQuery);

        for (int i = 0; i < ids.size(); i++) {
            psMinions.setInt(1, ids.get(i));
            psMinions.executeUpdate();
        }

        String selectMinionQuery = "SELECT name, age FROM minions";
        PreparedStatement psSelectMInions = connection.prepareStatement(selectMinionQuery);
        ResultSet rsSelectMInions = psSelectMInions.executeQuery();
        while (rsSelectMInions.next()) {
            System.out.println(rsSelectMInions.getString(1).toLowerCase() + " " + rsSelectMInions.getInt(2));
        }
    }

    //=================Problem 07=======================================
    private void printAllMinionNames() throws SQLException {
        String minionNameQuery = "SELECT name FROM minions;";

        PreparedStatement psMminionName = connection.prepareStatement(minionNameQuery);

        ResultSet rsMinionName = psMminionName.executeQuery();

        List<String> minions = new ArrayList<>();

        while (rsMinionName.next()) {
            String minionName = rsMinionName.getString("name");
            minions.add(minionName);
        }

        List<String> orderedMinions = new ArrayList<>();

        for (int i = 0; i < minions.size() / 2; i++) {
            orderedMinions.add(minions.get(i));
            orderedMinions.add(minions.get(minions.size() - 1 - i));
        }
        orderedMinions.forEach(System.out::println);
    }

    //=================Problem 05=======================================
    private void changeTownNamesCasing() throws IOException, SQLException {
        String country = br.readLine();

        String countOfTownsQuery = "SELECT country, COUNT(name) FROM towns WHERE country = ? GROUP BY country;";

        PreparedStatement psCountry = connection.prepareStatement(countOfTownsQuery);

        psCountry.setString(1, country);

        ResultSet rsCountry = psCountry.executeQuery();

        if (isPresent(rsCountry)) {
            int countOfTowns = rsCountry.getInt(2);
            System.out.printf("3 town names were affected.\n", countOfTowns);

            String townsQuery = "SELECT name FROM towns WHERE country = ?;";

            PreparedStatement psTowns = connection.prepareStatement(townsQuery);

            psTowns.setString(1, country);

            ResultSet rsTowns = psTowns.executeQuery();

            List<String> towns = new ArrayList<String>();

            while (rsTowns.next()) {
                String town = rsTowns.getString(1);
                towns.add(town.toUpperCase());
            }
            System.out.println("[" + String.join(", ", towns) + "]");

        } else {
            System.out.println("No town names were affected.");
        }
    }

    private boolean isPresent(ResultSet rsCountry) throws SQLException {
        if (rsCountry.next()) {
            return true;
        }
        return false;
    }

    //=================Problem 04=======================================
    private void addMinion() throws SQLException, IOException {
        String[] inputMinion = br.readLine().split(" ");
        String[] inputVillian = br.readLine().split(" ");

        String minionName = inputMinion[1];
        int minionAge = Integer.parseInt(inputMinion[2]);
        String townName = inputMinion[3];

        String villianName = inputVillian[1];

        int minionId = getId("minions", minionName);
        int villianId = getId("villains", villianName);
        int townId = getId("towns", townName);

        if (townId == 0) {
            String insertTown = "INSERT INTO towns (name, country) VALUES (?, \"Cocolandia\");";

            PreparedStatement psInsertTown = connection.prepareStatement(insertTown);

            psInsertTown.setString(1, townName);
            psInsertTown.executeUpdate();

            System.out.printf("Town %s was added to the database.\n", townName);
        }

        if (villianId == 0) {
            String insertVillianQuery = "INSERT INTO villains (name, evilness_factor) VALUES (?, \"evil\");";

            PreparedStatement psInsertVillian = connection.prepareStatement(insertVillianQuery);

            psInsertVillian.setString(1, villianName);
            psInsertVillian.executeUpdate();

            System.out.printf("Villain %s was added to the database.\n", villianName);
        }

        String insertMinionQuwry = "INSERT INTO minions (name, age, town_id) SELECT ? AS `name` , ? AS `age` , ? AS `town_id`;";

        PreparedStatement psInsertMinion = connection.prepareStatement(insertMinionQuwry);

        psInsertMinion.setString(1, minionName);
        psInsertMinion.setInt(2, minionAge);
        psInsertMinion.setInt(3, getId("towns", townName));

        psInsertMinion.executeUpdate();

        //?????????????????ID_MINION_VILLIAN?????????????
        System.out.printf("Successfully added %s to be minion of %s.", minionName, villianName);
    }

    private int getId(String base, String name) throws SQLException {
        String getIdQuery = String.format("SELECT id FROM %s WHERE name = ", base) + "'" + name + "'";

        PreparedStatement psGetId = connection.prepareStatement(getIdQuery);

        ResultSet rsGetId = psGetId.executeQuery();

        if (rsGetId.next()) {
            return rsGetId.getInt(1);
        }
        return 0;
    }

    //=================Problem 03=======================================
    private void getMinionNames() throws SQLException, IOException {
        //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int villianId = Integer.parseInt(br.readLine());
        String query2 = "SELECT m.name, m.age\n" +
                "FROM minions_db.minions AS m\n" +
                "JOIN minions_db.minions_villains AS mv\n" +
                "ON m.id = mv.minion_id\n" +
                "WHERE mv.villain_id = ?\n" +
                "GROUP BY m.id;\n";

        String query1 = "SELECT v.name\n" +
                "FROM minions_db.villains AS v\n" +
                "         JOIN minions_db.minions_villains AS mv\n" +
                "              ON v.id = mv.villain_id\n" +
                "WHERE mv.villain_id = ?\n" +
                "GROUP BY v.name;";

        PreparedStatement psVillianName = connection.prepareStatement(query1);
        PreparedStatement psMinionsNameAge = connection.prepareStatement(query2);

        psVillianName.setInt(1, villianId);
        psMinionsNameAge.setInt(1, villianId);

        ResultSet rsVillianName = psVillianName.executeQuery();
        ResultSet rsMinionsNameAge = psMinionsNameAge.executeQuery();


        if (rsMinionsNameAge.isBeforeFirst()) {
            while (rsVillianName.next()) {
                System.out.printf("Villain: %s\n", rsVillianName.getString("name"));
            }
            int count = 1;
            while (rsMinionsNameAge.next()) {
                System.out.printf("%d. %s %d%n", count++, rsMinionsNameAge.getString("name"), rsMinionsNameAge.getInt("age"));
            }
        } else {
            System.out.printf("No villain with ID %d exists in the database.", villianId);
        }
    }

    //=================Problem 02=======================================
    private void getVillainsNames() throws SQLException {
        String query = "SELECT v.name ,COUNT(mv.minion_id) AS 'v_count'\n" +
                "FROM minions_villains AS mv\n" +
                "JOIN villains v on mv.villain_id = v.id\n" +
                "GROUP BY mv.villain_id\n" +
                "HAVING v_count >?\n" +
                "ORDER BY v_count DESC;";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, 15);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.printf("%s %d%n",
                    rs.getString("v.name"),
                    rs.getInt("v_count"));
        }
    }
}
