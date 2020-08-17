package com.db.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/*
    Mongo Client To Connect to Database
 */
public class MongoDBDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("vinsys");
        MongoCollection<Document> myapp =    db.getCollection("myapp");
        FindIterable<Document> rows = myapp.find();
        for (Document row : rows) {
            System.out.println(row);
            System.out.println(row.get("abc"));
        }
    }
}
