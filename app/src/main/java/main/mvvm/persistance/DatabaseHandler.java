package main.mvvm.persistance;

import android.annotation.SuppressLint;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;

import org.bson.Document;

import java.util.logging.*;

import main.mvvm.Env;

public class DatabaseHandler {
    @SuppressLint("AuthLeak")
    private final String URI = String.format("mongodb+srv://root:%s@cluster0.pwpxt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority", new Env().PASSWORD);

    public void qwe() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);

        ConnectionString connectionString = new ConnectionString(this.URI);

        try(MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoCollection<Document> header = mongoClient.getDatabase("MVVM").getCollection("header");
            Document document = new Document("header", "Welcome");
            header.insertOne(document);
        }
    }
}
