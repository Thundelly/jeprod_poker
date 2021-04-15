package main.java.com.jeprod;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.WriteAbortedException;
import java.nio.channels.FileLock;
import java.util.*;
import java.util.concurrent.ExecutionException;

class DataHandler {
    private Firestore db;

    // Constructor
    DataHandler() throws IOException {
        InputStream serviceAccount = new FileInputStream("/Users/eric/OneDrive/College/PCC/CS_03B/project/Poker2/src/main/java/com/jeprod/jeprod-poker-firebase-adminsdk-awsy6-00f03a2433.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();

        // Check if there are multiple initiation of the Firebase Application
        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        if(firebaseApps!=null && !firebaseApps.isEmpty()){
            for(FirebaseApp app : firebaseApps){
                if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
                    firebaseApp = app;
            }
        }
        else
            firebaseApp = FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    // Writes each card information into the database
    void writer(String player, Card card, int numOfCards, Float money, Float bet, Integer value) throws ExecutionException, InterruptedException {

        // Creates new collection
        DocumentReference docRef = db.collection(player).document("card" + Integer.toString(numOfCards));

        Map<String, Object> data = new HashMap<>();
        data.put("suit", card.getSuit());
        data.put("value", card.getValue());

        // Creates new collection
        DocumentReference docRef_1 = db.collection(player).document("money");

        Map<String, Object> data_1 = new HashMap<>();
        data_1.put("money", money);
        data_1.put("bet", bet);

        // Creates new collection
        DocumentReference docRec_2 = db.collection(player).document("handValue");

        Map<String, Object> data_2 = new HashMap<>();
        data_2.put("value", value);

        // Push the data into the database
        ApiFuture<WriteResult> result = docRef.set(data);
        ApiFuture<WriteResult> result_1 = docRef_1.set(data_1);
        ApiFuture<WriteResult> result_2 = docRec_2.set(data_2);

        // Check for update confirmation
        System.out.println("Card Update time : " + result.get().getUpdateTime());
        System.out.println("Money Update time : " + result_1.get().getUpdateTime());
        System.out.println("Value Update time : " + result_2.get().getUpdateTime());

    }

    // Reads from database
    // DEBUGGING purposes
    void reader(String player) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = db.collection(player).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        int iteration = 0;

        for (QueryDocumentSnapshot document : documents) {
            iteration++; // For naming purposes ONLY

            if (iteration < 6) {
                System.out.println("Player:" + player);
                System.out.println("Card " + iteration);
                System.out.println("Suit: " + document.getString("suit"));
                System.out.println("Value: " + document.getLong("value"));
                System.out.println("\n");
            }
        }
    }

    // Get the hand information -- Used by the fxml controller
    Vector<Card> getHand(String player) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = db.collection(player).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        // Another vector
        Vector<Card> _hand = new Vector<>(52);
        Card card;

        for (QueryDocumentSnapshot document : documents) {
            if (!document.getId().equals("money") && !document.getId().equals("handValue")) {
//                System.out.println(document.getString("suit"));
//                System.out.println(document.getLong("value").intValue());
                card = new Card(document.getString("suit"), document.getLong("value").intValue());
                _hand.add(card);
            }
        }
        return _hand;
    }

    // Get player ID
    // This can be moved into the server side coding
    String getPlayerId() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = db.collection("playerid").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        boolean p1taken = false;

        for (QueryDocumentSnapshot document : documents) {
            p1taken = document.getBoolean("taken");
        }

        if (p1taken) {
            System.out.println("p2");
            return "p2";
        }

        DocumentReference docRef = db.collection("playerid").document("p1");
        Map<String, Object> data = new HashMap<>();
        data.put("taken", true);

        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Player ID UPDATED:: Update time : " + result.get().getUpdateTime());


        return "p1";
    }

    // Reset the playerID
    void resetPlayerId() throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("playerid").document("p1");
        Map<String, Object> data = new HashMap<>();
        data.put("taken", false);

        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Player ID UPDATED:: Update time : " + result.get().getUpdateTime());

    }

    // This allows the deck to take data from database
    Vector<Card> getDeckCard() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = db.collection("deck").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        Vector<Card> _deck = new Vector<>(52);
        Card card;

        for (QueryDocumentSnapshot document : documents) {
            if (!document.getId().equals("money")
                    && !document.getId().equals("handValue")) {

                System.out.println(document.getString("suit"));
                System.out.println(document.getDouble("value").intValue());

                card = new Card(document.getString("suit"), (document.getDouble("value")).intValue());
                _deck.add(card);
            }
        }

        return _deck;
    }

    // Get values of the hand from the database
    int[] getHandValues() throws ExecutionException, InterruptedException {
        int[] handValues = new int[2];

        ApiFuture<QuerySnapshot> query = db.collection("p1").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            if (document.getId().equals("handValue")) {
                handValues[0] = document.getDouble("value").intValue();
            }
        }

        ApiFuture<QuerySnapshot> query_1 = db.collection("p2").get();
        QuerySnapshot querySnapshot_1 = query_1.get();
        List<QueryDocumentSnapshot> documents_1 = querySnapshot_1.getDocuments();

        for (QueryDocumentSnapshot document_1 : documents_1) {
            if (document_1.getId().equals("handValue")) {
                handValues[1] = document_1.getDouble("value").intValue();
            }
        }

        return handValues;
    }
}


