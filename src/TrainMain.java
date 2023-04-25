import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainMain {

	public static void main(String[] args) {
		System.out.println("Now Searching for Trains");
		TrainService.findTrainBetweenStation("Mumbai", "Pune", 5, LocalDate.now());
		
		BankAccount acc=new BankAccount();
		acc.setAccountBalance(10000);
		acc.setAccountNumber(101);
		
		Passenger ps1=new Passenger(001, "Vikas Shukla", 35, acc);
		Passenger ps2=new Passenger(002, "Archana Shukla", 34, acc);
		Passenger ps3=new Passenger(003, "Avika Shukla", 3, acc);
		
		List<Passenger> listPassenger=new LinkedList<Passenger>();
		listPassenger.add(ps1);
		listPassenger.add(ps2);
		listPassenger.add(ps3);
		
		System.out.println("Now Passenger LIst who booked Ticket");
		
		TrainService.bookTickets(101, listPassenger);
		
		System.out.println("Ticket Detais");
		TicketService.showTicketDetails(1);
		
		
		TrainService.findTrainBetweenStation("Mumbai", "Pune", 5, LocalDate.now());

	}

}
