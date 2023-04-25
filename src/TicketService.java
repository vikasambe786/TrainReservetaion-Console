import java.util.LinkedList;
import java.util.List;

public class TicketService {
	
	private static List<Ticket> allTickets=new LinkedList<Ticket>();

	public static void addNewTicket(int trainNumber, List<Passenger> listPassenger) {
		
		int pnr=allTickets.size()+1;
		Train bookedTrain=TrainService.searchTrain(trainNumber);
		allTickets.add(new Ticket(pnr, bookedTrain, listPassenger));
		System.out.println("Ticket Booked Successfully");
		
	}
	
	public static void showTicketDetails(int pnr) {
		
		Ticket tempTicket=null;
		for(Ticket t:allTickets) {
			if(t.getPnr()==pnr) {
				tempTicket=t;
				break;
			}
		}
		Train tempTrain=tempTicket.getBookedTrain();
		List<Passenger> passengerList=tempTicket.getPassengerList();
		int totalFare=tempTrain.getFare() * passengerList.size();
		System.out.println("***** Your Booking Details *****");
		System.out.println("PNR -> : "+tempTicket.getPnr()+ "Tr. NO. : "+tempTrain.getTrainNumber());
		System.out.println("From : "+tempTrain.getFromStation()+" To : "+tempTrain.getToStation());
		System.out.println("Fare : "+tempTrain.getFare()+ " Departure :"+tempTrain.getDoj() + " Toal Fare : "+totalFare);
		
		System.out.println("***** Passenger Details *****");
		
		for(Passenger p:passengerList) {
			System.out.println("Name : "+p.getPassengerName()+ " Age : "+p.getAge());
		}
		System.out.println("***** ***** ***** ***** ***** *****");
	}

}
