package at.htl.finoview.controller;

import at.htl.finoview.database.Database;
import at.htl.finoview.database.SqlRunner;
import at.htl.finoview.database.SqlScript;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.*;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CategoryJdbcDemoTest {

    private DataSource dataSource = Database.getDataSource();


    @BeforeEach
    void setUp() {
        SqlRunner.runScript(SqlScript.DROP);
        SqlRunner.runScript(SqlScript.CREATE);
    }

    @Test
    void t010_insertCategory() {
        // AAA-pattern
        // arrange (vorbereiten)

        // get a connection
        try (Connection connection = dataSource.getConnection()) {

            String sql = "insert into category (abbr,name) values('AUSZ','Auszahlung')";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            // act (durchführen)
            pstmt.executeUpdate();

        } catch (SQLException e) {
            //e.printStackTrace();
            //System.err.println(e.getMessage());
            fail("table CATEGORY: " + e.getMessage());
        }

        // assert (sicherstellen, prüfen)
        Table table = new Table(dataSource, "CATEGORY");
        output(table).toConsole();
        assertThat(table)
                .row(0)
                .value("ABBR").isEqualTo("AUSZ")
                .value("NAME").isEqualTo("Auszahlung");
    }

    @Test
    void t020_findAllInCategory() {
        // AAA-pattern
        // arrange (vorbereiten)
        insertCategories();

        // get a connection
        try (Connection connection = dataSource.getConnection()) {

            String sql = "select abbr, name from category";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            // act (durchführen)
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " - " +
                                rs.getString(2)
                );
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            //System.err.println(e.getMessage());
            fail("table CATEGORY: " + e.getMessage());
        }

        // assert (sicherstellen, prüfen)
        Table table = new Table(dataSource, "CATEGORY");
        output(table).toConsole();
        assertThat(table)
                .row(0)
                .value("ABBR").isEqualTo("AUSZ")
                .value("NAME").isEqualTo("Auszahlung")
                .row(1)
                .value("ABBR").isEqualTo("EINZ")
                .value("NAME").isEqualTo("Einzahlung")
                .row(2)
                .value("ABBR").isEqualTo("ZINS")
                .value("NAME").isEqualTo("Zinszahlung");
    }


    void insertCategories() {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO category (abbr,name) VALUES (?,?)";


            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, "EINZ");
            pstmt.setString(2, "Einzahlung");

            pstmt.addBatch();

            pstmt.setString(1, "AUSZ");
            pstmt.setString(2, "Auszahlung");

            pstmt.addBatch();

            pstmt.setString(1, "ZINS");
            pstmt.setString(2, "Zinszahlung");

            pstmt.addBatch();

            int[] affectedRecords = pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
