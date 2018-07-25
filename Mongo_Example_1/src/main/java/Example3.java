import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.bson.Document;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Example3 {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mc = new MongoClient();
		DBCollection col = mc.getDB("db5").getCollection("emp999");

		BasicDBObject object2 = new BasicDBObject("$match", new BasicDBObject("status", "A"));
		System.out.println(object2);

		BasicDBObject object3 = new BasicDBObject("$group", new BasicDBObject("_id", "$cust_id"));
		object3.append("Total", new BasicDBObject("$sum", "$amount"));
		System.out.println(object3);

		/*
		 * BasicDBObject object3 = new BasicDBObject("_id", "$cust_id");
		 * object3.append("Total", new BasicDBObject("$sum", "$amount")); BasicDBObject
		 * object4 = new BasicDBObject(); object4.append("$group", object3);
		 * System.out.println(object4);
		 */

		
		ArrayList<BasicDBObject> al = new ArrayList<BasicDBObject>();
		al.add(object2);
		al.add(object3);
		System.out.println(al);
		@SuppressWarnings("deprecation")
		AggregationOutput output = col.aggregate(al);
		System.out.println(output);

		System.out.println(output);

		for (DBObject obj : output.results()) {
			System.out.println(obj);
		}

	
	}
}
