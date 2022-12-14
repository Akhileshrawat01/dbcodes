import java.util.Iterator;
import java.util.Scanner;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDB_Programs {

	public static void main(String[] args)  {
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Connection Established");
		
		MongoDatabase database = mongoClient.getDatabase("Assignment4");
		System.out.println("Connected to Database Successfully");
		System.out.println("Database Name : " + database.getName());
		
		MongoCollection<Document> collection = database.getCollection("Employee");
		System.out.println("Collection Created / Fetched");
				
		int choice = 0;

		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("---------------Menu--------------------------");
			System.out.println("1. Add a document to collection ");
			System.out.println("2. Show All documents   ");
			System.out.println("3. Delete document from a collection ");
			System.out.println("4. Exit");
			System.out.println("---------------------------------------------");
			System.out.println();
			
			System.out.print("Enter a choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
    			case 1:

				
	    			System.out.println("Adding a document");
    
	    			System.out.println("Enter Id ");
		    		int index = sc.nextInt();
				
			    	sc.nextLine();
				
				    System.out.print("Enter name : ");
				    String name = sc.nextLine();
				
				    System.out.print("Enter salary  (in US Dollar ) : ");
				    int salary = sc.nextInt();
				
				    System.out.print("Enter department name : ");
			    	String department = sc.next();
				
				    Document document = new Document();
				    document.append("_id", index);
				    document.append("Name", name);
				    document.append("Salary", salary);
				    document.append("department", department);
				    collection.insertOne(document);
				
				
				    break;
			
                case 2:
				
				    System.out.println("------------  Displaying documents  ----------------");
				    FindIterable<Document> iterateDocuments = collection.find();
				    System.out.println("Listing all Mongo Documents ");
				    
				    Iterator<Document> cursor = iterateDocuments.iterator();
				    while(cursor.hasNext()) 
					    System.out.println(cursor.next());
				
				    
				
				    break;
			    case 3:
    
				    System.out.print("Enter the doucment's id to delete the document : ");
				    int idToDelete = sc.nextInt();
				
				    collection.deleteOne(Filters.eq("_id", idToDelete));
				    System.out.println("Document Deleted Successfully ");
				    break;
			
                case 4:
				    System.out.println(" Bye ");
				    choice = -1;
				    break;
                    
			    default:
				    System.out.println("Please enter correct choice !!! ");
			}
		}
		while(choice != -1);
	
		sc.close();
		mongoClient.close();

	}
}
