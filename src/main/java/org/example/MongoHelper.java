package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.dto.Player;
import org.example.dto.Scoreboard;

public class MongoHelper {
    static String dbURI = "mongodb+srv://vishwas:vishwas@cluster0.8ggdmzh.mongodb.net/?retryWrites=true&w=majority";
    static MongoClient mongoClient = MongoClients.create(dbURI);
    static Boolean saveScoreboard(Scoreboard scoreboard) {

        MongoDatabase db = mongoClient.getDatabase("cluster0");
        MongoCollection<Document> collection = db.getCollection("games");
        Gson g = new Gson();

        collection.insertOne(Document.parse(g.toJson(scoreboard)));

        return true;
    }
}
