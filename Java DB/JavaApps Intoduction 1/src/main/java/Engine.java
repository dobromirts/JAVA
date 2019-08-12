import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {
    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            //this.getVillainsNames();
            //this.getMinionsNames();
            //this.addMinion();
            //this.changeTownNameCasing();
            //this.printAllMinionsNames();
            //this.increaseMinionAge();
            this.increaseAgeStoredProcedure();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    Problem 02 Get Villains’ Names
     */
    private void getVillainsNames() throws SQLException {
        String querry = "SELECT v.name,count(v2.minion_id) as `count` from villains v join minions_villains v2 on v.id = v2.villain_id group by v.name having `count`>15 order by `count` desc;";
        PreparedStatement preparedStatement = connection.prepareStatement(querry);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %s%n", resultSet.getString("name"), resultSet.getString("count"));
        }
    }


    /*
    Problem 03 Get Minion Names
     */
    private void getMinionsNames() throws SQLException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int villainId = Integer.parseInt(bf.readLine());

        String villainQuery = "select name from villains where id = ?";
        PreparedStatement villainStatemnt = connection.prepareStatement(villainQuery);
        villainStatemnt.setInt(1, villainId);

        ResultSet villainsResultSet = villainStatemnt.executeQuery();
        if (!villainsResultSet.first()) {
            System.out.printf("No villain with ID %s exists in the database.", villainId);
        } else {
            System.out.printf("Villain: %s%n", villainsResultSet.getString("name"));

            String minionsQuery = "select m.name,m.age from villains v join minions_villains mv on v.id = mv.villain_id join minions m on mv.minion_id = m.id where v.id=?;";
            PreparedStatement minionStatnet = connection.prepareStatement(minionsQuery);

            minionStatnet.setInt(1, villainId);
            ResultSet minionsResultSet = minionStatnet.executeQuery();

            int count = 1;

            while (minionsResultSet.next()) {

                System.out.printf("%d. %s %s%n", count++,
                        minionsResultSet.getString("name"),
                        minionsResultSet.getString("age"));

            }
        }
    }

    /*
    Problem 04 Add Minion
     */
    private void addMinion() throws IOException, SQLException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] minionInput = bf.readLine().split("\\s+");
        String minionName = minionInput[1];
        int minionAge = Integer.parseInt(minionInput[2]);
        String minionTown = minionInput[3];

        String villainName = bf.readLine().split("\\s+")[1];

        String townQuery = "select name from towns where name =?";
        PreparedStatement townStatement = connection.prepareStatement(townQuery);
        townStatement.setString(1, minionTown);
        ResultSet townResult = townStatement.executeQuery();

        if (!townResult.first()) {
            String insertTownQuery = "insert into towns(name,country) values (?,'Bulgaria');";
            PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
            insertTownStatement.setString(1, minionTown);
            insertTownStatement.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }

        String villainQuery = "select name from villains where name =?;";
        PreparedStatement villainStatement = connection.prepareStatement(villainQuery);
        villainStatement.setString(1, villainName);
        ResultSet villainResult = villainStatement.executeQuery();

        if (!villainResult.first()) {
            String insertVillainQuery = "insert into villains(name,evilness_factor) values (?,'evil');";
            PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainQuery);
            insertVillainStatement.setString(1, villainName);
            insertVillainStatement.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        String minionQuery = "insert into minions(name,age,town_id) values (?,?,(select t.id as `town_name` from  towns t where t.name=?));";
        PreparedStatement insertMinionStatement = connection.prepareStatement(minionQuery);
        insertMinionStatement.setString(1, minionName);
        insertMinionStatement.setInt(2, minionAge);
        insertMinionStatement.setString(3, minionTown);

        insertMinionStatement.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s", minionName, villainName);
    }


    /*
    Problem 05 Change Town Names Casing
     */
    private void changeTownNameCasing() throws SQLException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String countryName = bf.readLine();

        String townsQuery = "select name from towns where country=?";
        PreparedStatement towsnStatment = connection.prepareStatement(townsQuery);
        towsnStatment.setString(1, countryName);
        ResultSet townResultSet = towsnStatment.executeQuery();

        int namesChanged = 0;
        List<String> townNames = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (townResultSet.next()) {
            String updateQuery = "UPDATE towns set name=? where name=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, townResultSet.getString("name").toUpperCase());
            preparedStatement.setString(2, townResultSet.getString("name"));

            preparedStatement.executeUpdate();

            townNames.add(townResultSet.getString("name").toUpperCase());
            namesChanged++;

        }
        for (int i = 0; i < townNames.size() - 1; i++) {
            sb.append(townNames.get(i)).append(", ");
        }
        sb.append(townNames.get(townNames.size() - 1));

        if (townNames.isEmpty()) {
            System.out.println("No town names were affected.");
        } else {
            sb.append("]");
            System.out.printf("%d town names were affected.%n", namesChanged);
            System.out.println(sb.toString());
        }
    }


    /*
    Problem 07 Print All Minion Names
     */

    private void printAllMinionsNames() throws SQLException {
        String query = "Select name from minions";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<String> names = new ArrayList<>();

        while (rs.next()) {
            names.add(rs.getString("name"));
        }

        for (int i = 0; i < names.size() / 2; i++) {
            System.out.println(names.get(i));
            System.out.println(names.get(names.size() - i - 1));
        }
    }

    /*
    Problem 08 Increase Minion Age
     */
    private void increaseMinionAge() throws IOException, SQLException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] ids = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String query = "select name,age from minions where id=?";

        for (int id : ids) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            String minionName = "";
            int modifiedAge = 0;

            while (resultSet.next()) {

                minionName = resultSet.getString("name").toLowerCase();
                modifiedAge = resultSet.getInt("age") + 1;
            }

            String updateQuery = "UPDATE minions set name=?,age=? where id=?";
            //UPDATE towns set name=? where name=?;
            PreparedStatement updateStatment = connection.prepareStatement(updateQuery);
            updateStatment.setString(1, minionName);
            updateStatment.setInt(2, modifiedAge);
            updateStatment.setInt(3, id);

            updateStatment.executeUpdate();
        }

        String outPutQuery = "select name,age from minions";
        PreparedStatement ps = connection.prepareStatement(outPutQuery);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.printf("%s %s%n", rs.getString("name"), rs.getString("age"));
        }
    }


    /*
    Problem 09 Increase Age Stored Procedure
     */

    private void increaseAgeStoredProcedure() throws IOException, SQLException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int id=Integer.parseInt(bf.readLine());

        String query="{call usp_get_older(?)}";
        CallableStatement callableStatement=connection.prepareCall(query);
        callableStatement.setInt(1,id);
        ResultSet resultSet=callableStatement.executeQuery();

        String outPutQuery="Select name,age from minions where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(outPutQuery);
        preparedStatement.setInt(1,id);
        ResultSet output=preparedStatement.executeQuery();

        while (output.next()){
            System.out.printf("%s %s%n",output.getString("name"),output.getString("age"));
        }

    }

}

