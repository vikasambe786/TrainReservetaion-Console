import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainService {

	private static List<Train> allTrains = new LinkedList<Train>();
	static {
		allTrains.add(new Train(101, "Doranto Express", "Mumbai", "Pune", 110, 680, LocalDate.now()));
		allTrains.add(new Train(102, "Doranto Express1", "Mumbai1", "Pune1", 25, 580, LocalDate.now()));
		allTrains.add(new Train(103, "Doranto Express2", "Mumbai2", "Pune2", 10, 450, LocalDate.now()));
		allTrains.add(new Train(104, "Doranto Express3", "Mumbai3", "Pune3", 250, 150, LocalDate.now()));
		allTrains.add(new Train(105, "Doranto Express4", "Mumbai", "Pune", 300, 980, LocalDate.now()));
		allTrains.add(new Train(106, "Doranto Express5", "Mumbai5", "Pune5", 140, 770, LocalDate.now()));
	}

	public TrainService() {
	}

	public static Train searchTrain(int trainNumber) {
		Train temp = null;
		for (Train t : allTrains) {
			if (t.getTrainNumber() == trainNumber) {
				temp = t;
				System.out.println("Train No\t Train Name \t From \t To \t Seats Avaialble \t Fare \t");
				System.out.printf("%4d%25s%10s%5s%15d%18d",t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getSeatsAvailable(),t.getFare());
				System.out.println();
				break;
			}

		}
		return temp;
	}
	
	public static void findTrainBetweenStation(String fromStation,String toStation,int seatsAvailable,LocalDate doj)
	{
		List<Train> searchTrainList=new LinkedList<Train>();
		for(Train t: allTrains) {
			if(t.getFromStation().equals(fromStation) && t.getToStation().equals(toStation) && t.getDoj().equals(doj) && t.getSeatsAvailable()>seatsAvailable) {
				
				searchTrainList.add(t);
			}
		}
		
		
		if(searchTrainList.size()==0) {
			System.out.println("No Train Found");
		}
		else
		{
			System.out.println("Train No\t Train Name \t From \t To \t Seats Avaialble \t Fare \t");
			for(Train t: searchTrainList) {
				System.out.printf("%4d%25s%10s%5s%15d%18d",t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getSeatsAvailable(),t.getFare());
				System.out.println();
			}
		}
		
		
	}
	
	public static void bookTickets(int trainNumber,List<Passenger> listPassenger) {
		
		//Subtract all Train Fare for all Passenger all together from Bank account
		
		int numberOfSeats=listPassenger.size();
		Passenger tempPassenger=listPassenger.get(0);
		
		BankAccount account=tempPassenger.getBankAccount();
		
		Train searchTrain = searchTrain(trainNumber);
		
		int fare=searchTrain.getFare();
		int totalFare=fare * numberOfSeats;
		account.withdraw(totalFare);
		
		
		//Subtract all Train Seats  
		searchTrain.setSeatsAvailable(searchTrain.getSeatsAvailable()-numberOfSeats);
		
		//Add Booked Ticket in One Place as a Record
		
		TicketService.addNewTicket(trainNumber,listPassenger);
		
	}

}
