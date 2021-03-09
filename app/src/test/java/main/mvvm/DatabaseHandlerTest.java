package main.mvvm;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class DatabaseHandlerTest {

    @Test
    public void checkForConnection() {
        String URI = "mongodb+srv://root:VerySafePassword1234@cluster0.pwpxt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);

        ConnectionString connectionString = new ConnectionString(URI);

        try(MongoClient mongoClient = MongoClients.create(connectionString)) {
            assertEquals("MVVM", mongoClient.getDatabase("MVVM").getName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}