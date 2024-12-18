package com.khaikin.airline.test;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airplane.AirplaneService;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportService;
import com.khaikin.airline.auth.AuthenticationService;
import com.khaikin.airline.auth.RegisterRequest;
import com.khaikin.airline.booking.Booking;
import com.khaikin.airline.booking.BookingService;
import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.flight.FlightService;
import com.khaikin.airline.flight.FlightStatus;
import com.khaikin.airline.passenger.Passenger;
import com.khaikin.airline.passenger.PassengerService;
import com.khaikin.airline.passenger.PassengerTitle;
import com.khaikin.airline.passenger.PassengerType;
import com.khaikin.airline.post.Post;
import com.khaikin.airline.post.PostService;
import com.khaikin.airline.user.Role;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final AirportService airportService;
    private final FlightService flightService;
    private final AirplaneService airplaneService;
    private final BookingService bookingService;
    private final PassengerService passengerService;
    private final AuthenticationService authenticationService;
    private final PostService postService;

    @Override
    public void run(String... args)
            throws Exception {

        // airport
        List<Airport> airports = new ArrayList<>();

        airports.add(new Airport("Noi Bai International Airport", "HAN", "Viet Nam", "Ha Noi, Viet Nam"));
        airports.add(new Airport("Changi Airport", "SIN", "Southeast Asia", "Singapore, Singapore"));
        airports.add(new Airport("Tokyo Haneda Airport", "HND", "Asia", "Tokyo, Japan"));
        airports.add(new Airport("Incheon International Airport", "ICN", "Asia", "Seoul, South Korea"));
        airports.add(new Airport("Heathrow Airport", "LHR", "Europe", "London, United Kingdom"));
        airports.add(new Airport("Charles de Gaulle Airport", "CDG", "Europe", "Paris, France"));
        airports.add(new Airport("Frankfurt Airport", "FRA", "Europe", "Frankfurt, Germany"));
        airports.add(new Airport("John F. Kennedy International Airport", "JFK", "North America",
                                 "New York, USA"));
        airports.add(new Airport("Los Angeles International Airport", "LAX", "North America", "Los Angeles, USA"));
        airports.add(new Airport("Sydney Kingsford Smith Airport", "SYD", "Oceania", "Sydney, Australia"));
        airports.add(new Airport("Kuala Lumpur International Airport", "KUL", "Southeast Asia",
                                 "Kuala Lumpur, Malaysia"));
        airports.add(new Airport("Tan Son Nhat International Airport", "SGN", "Southeast Asia",
                                 "Ho Chi Minh City, Viet Nam"));
        airports.add(new Airport("Da Nang International Airport", "DAD", "Southeast Asia", "Da Nang, Viet Nam"));
        airports.add(new Airport("Cam Ranh International Airport", "CXR", "Southeast Asia",
                                 "Khanh Hoa, Viet Nam"));
        airports.add(new Airport("Phu Quoc International Airport", "PQC", "Southeast Asia",
                                 "Phu Quoc, Viet Nam"));
        airports.add(new Airport("Cat Bi International Airport", "HPH", "Southeast Asia", "Hai Phong, Viet Nam"));

        airports.add(new Airport("Suvarnabhumi Airport", "BKK", "Southeast Asia", "Bangkok, Thailand"));

        for (Airport airport : airports) {
            airportService.createAirport(airport);
        }

        // airplane
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new Airplane("AP001", "Boeing 737", "Boeing", 200, 50));
        airplanes.add(new Airplane("AP002", "Airbus A320", "Airbus", 160, 40));
        airplanes.add(new Airplane("AP003", "Boeing 787", "Boeing", 280, 80));
        airplanes.add(new Airplane("AP004", "Airbus A350", "Airbus", 300, 100));
        airplanes.add(new Airplane("AP005", "Boeing 777", "Boeing", 400, 150));

        airplanes.add(new Airplane("AP006", "Airbus A330", "Airbus", 180, 30));
        airplanes.add(new Airplane("AP007", "Boeing 747", "Boeing", 200, 80));
        airplanes.add(new Airplane("AP008", "Airbus A340", "Airbus", 400, 200));
        airplanes.add(new Airplane("AP009", "Boeing 767", "Boeing", 300, 150));
        airplanes.add(new Airplane("AP010", "Airbus A380", "Airbus", 180, 25));

        for (Airplane airplane : airplanes) {
            airplaneService.createAirplane(airplane);
        }

        // flight
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(LocalDateTime.of(2024, 10, 4, 6, 0), "VN123", LocalDateTime.of(2024, 10, 4, 8, 0),
                               FlightStatus.ARRIVED, 3000L, 6000L, airplanes.get(0), airports.get(0), airports.get(1)));
        flights.add(new Flight(LocalDateTime.of(2024, 11, 7, 16, 0), "VN124", LocalDateTime.of(2024, 11, 7, 18, 0),
                               FlightStatus.ARRIVED, 2500L, 5500L, airplanes.get(9), airports.get(8),
                               airports.get(16)));
        flights.add(new Flight(LocalDateTime.of(2024, 11, 8, 6, 0), "VN125", LocalDateTime.of(2024, 11, 8, 8, 0),
                               FlightStatus.ARRIVED, 2200L, 5000L, airplanes.get(8), airports.get(15),
                               airports.get(16)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 20, 20, 0), "VN456", LocalDateTime.of(2024, 12, 20, 22, 0),
                               FlightStatus.IN_AIR, 2800L, 5900L, airplanes.get(1), airports.get(0), airports.get(5)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 21, 14, 0), "VN789", LocalDateTime.of(2024, 12, 21, 16, 0),
                               FlightStatus.SCHEDULED, 2300L, 5400L, airplanes.get(2), airports.get(1),
                               airports.get(0)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 21, 15, 0), "VN101", LocalDateTime.of(2024, 12, 21, 20, 0),
                               FlightStatus.SCHEDULED, 2100L, 5200L, airplanes.get(0), airports.get(5),
                               airports.get(10)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 22, 22, 0), "VN102", LocalDateTime.of(2024, 12, 23, 1, 0),
                               FlightStatus.CANCELLED, 3000L, 6400L, airplanes.get(3), airports.get(7),
                               airports.get(0)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 22, 1, 0), "VN103", LocalDateTime.of(2024, 12, 22, 3, 0),
                               FlightStatus.SCHEDULED, 2500L, 5700L, airplanes.get(4), airports.get(0),
                               airports.get(2)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 23, 5, 0), "VN104", LocalDateTime.of(2024, 12, 23, 7, 0),
                               FlightStatus.SCHEDULED, 2900L, 6200L, airplanes.get(0), airports.get(1),
                               airports.get(0)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 23, 9, 0), "VN105", LocalDateTime.of(2024, 12, 23, 11, 0),
                               FlightStatus.SCHEDULED, 2600L, 6000L, airplanes.get(5), airports.get(0),
                               airports.get(1)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 13, 0), "VN106", LocalDateTime.of(2024, 12, 24, 15, 0),
                               FlightStatus.SCHEDULED, 2800L, 6500L, airplanes.get(2), airports.get(6),
                               airports.get(9)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 17, 0), "VN107", LocalDateTime.of(2024, 12, 24, 19, 0),
                               FlightStatus.SCHEDULED, 2200L, 5300L, airplanes.get(3), airports.get(8),
                               airports.get(5)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 17, 0), "VN108", LocalDateTime.of(2024, 12, 24, 19, 0),
                               FlightStatus.SCHEDULED, 2400L, 5600L, airplanes.get(4), airports.get(8),
                               airports.get(5)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 17, 0), "VN109", LocalDateTime.of(2024, 12, 24, 19, 0),
                               FlightStatus.SCHEDULED, 2100L, 5100L, airplanes.get(3), airports.get(5),
                               airports.get(8)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 25, 17, 0), "VN110", LocalDateTime.of(2024, 12, 25, 19, 0),
                               FlightStatus.SCHEDULED, 2700L, 6300L, airplanes.get(3), airports.get(5),
                               airports.get(8)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 26, 9, 0), "VN111", LocalDateTime.of(2024, 12, 25, 12, 0),
                               FlightStatus.SCHEDULED, 2200L, 5400L, airplanes.get(5), airports.get(1),
                               airports.get(0)));

        for (Flight flight : flights) {
            flightService.createFlight(flight);
        }


        // booking
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("khaihd@gmail.com", "0981234561", flights.get(0), "Economy", 20000L));
        bookings.add(new Booking("user1@gmail.com", "0982345672", flights.get(0), "Business", 40000L));
        bookings.add(new Booking("user2@gmail.com", "0983456783", flights.get(0), "Economy", 8000L));
        bookings.add(new Booking("user3@gmail.com", "0984567894", flights.get(1), "Economy", 1000L));
        bookings.add(new Booking("user4@gmail.com", "0985678905", flights.get(1), "Economy", 20000L));
        bookings.add(new Booking("user5@gmail.com", "0986789016", flights.get(2), "Business", 40000L));
        bookings.add(new Booking("user6@gmail.com", "0987890127", flights.get(3), "Business", 50000L));
        bookings.add(new Booking("user7@gmail.com", "0988901238", flights.get(3), "Business", 60000L));
        bookings.add(new Booking("user8@gmail.com", "0989012349", flights.get(3), "Business", 80000L));
        bookings.add(new Booking("user9@gmail.com", "0980123450", flights.get(3), "Economy", 10000L));
        bookings.add(new Booking("user10@gmail.com", "0981234560", flights.get(4), "Economy", 5000L));
        bookings.add(new Booking("user11@gmail.com", "0982345671", flights.get(5), "Economy", 2000L));
        bookings.add(new Booking("user12@gmail.com", "0983456782", flights.get(6), "Economy", 1000L));
        bookings.add(new Booking("user13@gmail.com", "0984567893", flights.get(6), "Economy", 7000L));
        bookings.add(new Booking("user14@gmail.com", "0985678904", flights.get(7), "Business", 12000L));
        bookings.add(new Booking("user15@gmail.com", "0986789015", flights.get(8), "Business", 10000L));

//        List<Passenger> passengers1 = new ArrayList<>();
//        passengers1.add(new Passenger(PassengerTitle.MR, "Khai", "Hoang", PassengerType.ADULT, "2004-09-08"));
//        passengers1.add(new Passenger(PassengerTitle.MS, "Chi", "Tran", PassengerType.INFANT, "2024-02-16"));
//        passengers1.add(new Passenger(PassengerTitle.PROFESSOR, "Anh", "Hoang", PassengerType.ADULT, "2000-01-01"));
//        passengers1.add(new Passenger(PassengerTitle.DOCTOR, "Dung", "Dinh", PassengerType.CHILD, "2008-08-08"));
//        bookings.add(new Booking("super_user0@gmail.com", "0915157200", flights.get(0),
//                                 Arrays.asList(passengers1.get(0), passengers1.get(1))));
//        bookings.add(new Booking("super_user1@gmail.com", "0915157201", flights.get(0),
//                                 Arrays.asList(passengers1.get(2), passengers1.get(3))));
//
//        bookings.add(new Booking("super_user0@gmail.com", "0915157200", flights.get(1),
//                                 Arrays.asList(passengers1.get(0), passengers1.get(2))));

        for (Booking booking : bookings) {
            bookingService.createBooking(booking);
        }

        // passenger
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(
                new Passenger(PassengerTitle.MR, "John", "Doe", PassengerType.ADULT, "1990-01-01", bookings.get(0)));
        passengers.add(
                new Passenger(PassengerTitle.MRS, "Jane", "Smith", PassengerType.ADULT, "1985-05-15", bookings.get(0)));
        passengers.add(new Passenger(PassengerTitle.MS, "Emily", "Johnson", PassengerType.ADULT, "1992-09-21",
                                     bookings.get(1)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Michael", "Brown", PassengerType.ADULT, "1978-11-30",
                                     bookings.get(1)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Sarah", "Davis", PassengerType.ADULT, "1965-07-22",
                                     bookings.get(1)));

        passengers.add(new Passenger(PassengerTitle.BOY, "James", "Wilson", PassengerType.CHILD, "2010-03-10",
                                     bookings.get(2)));
        passengers.add(new Passenger(PassengerTitle.MS, "Olivia", "Martinez", PassengerType.CHILD, "2012-04-18",
                                     bookings.get(3)));

        passengers.add(new Passenger(PassengerTitle.GIRL, "Sophia", "Garcia", PassengerType.INFANT, "2021-06-05",
                                     bookings.get(3)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "David", "Anderson", PassengerType.ADULT, "1980-02-14",
                                     bookings.get(3)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Emma", "Thomas", PassengerType.ADULT, "1973-08-29",
                                     bookings.get(4)));

        passengers.add(
                new Passenger(PassengerTitle.MR, "Chris", "Lee", PassengerType.ADULT, "1991-03-03", bookings.get(4)));
        passengers.add(new Passenger(PassengerTitle.MRS, "Anna", "Walker", PassengerType.ADULT, "1987-07-12",
                                     bookings.get(5)));
        passengers.add(new Passenger(PassengerTitle.MS, "Grace", "Harris", PassengerType.ADULT, "1995-08-19",
                                     bookings.get(6)));

        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Lucas", "White", PassengerType.ADULT, "1979-12-25",
                                     bookings.get(7)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Liam", "King", PassengerType.ADULT, "1968-11-11",
                                     bookings.get(8)));

        passengers.add(
                new Passenger(PassengerTitle.GIRL, "Henry", "Baker", PassengerType.CHILD, "2011-02-22",
                              bookings.get(6)));
        passengers.add(new Passenger(PassengerTitle.BOY, "Charlotte", "Wright", PassengerType.CHILD, "2013-05-05",
                                     bookings.get(8)));
        passengers.add(
                new Passenger(PassengerTitle.MRS, "Mia", "Green", PassengerType.INFANT, "2020-09-15", bookings.get(6)));

        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Daniel", "Young", PassengerType.ADULT, "1981-04-04",
                                     bookings.get(9)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Isabella", "Allen", PassengerType.ADULT, "1974-10-10",
                                     bookings.get(10)));
        passengers.add(new Passenger(PassengerTitle.MR, "Jackson", "Scott", PassengerType.ADULT, "1989-05-25",
                                     bookings.get(11)));

        passengers.add(
                new Passenger(PassengerTitle.MRS, "Ava", "Hill", PassengerType.ADULT, "1986-06-14", bookings.get(8)));
        passengers.add(new Passenger(PassengerTitle.MS, "Evelyn", "Adams", PassengerType.ADULT, "1993-09-09",
                                     bookings.get(12)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Matthew", "Morris", PassengerType.ADULT, "1976-03-18",
                                     bookings.get(12)));

        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Harper", "Mitchell", PassengerType.ADULT, "1967-02-05",
                                     bookings.get(13)));
        passengers.add(new Passenger(PassengerTitle.BOY, "Landon", "Roberts", PassengerType.CHILD, "2011-06-30",
                                     bookings.get(14)));
        passengers.add(
                new Passenger(PassengerTitle.GIRL, "Ella", "Parker", PassengerType.CHILD, "2013-07-20",
                              bookings.get(9)));

        passengers.add(new Passenger(PassengerTitle.BOY, "Abigail", "Evans", PassengerType.INFANT, "2022-01-01",
                                     bookings.get(14)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Aiden", "Turner", PassengerType.ADULT, "1977-04-15",
                                     bookings.get(15)));

        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Amelia", "Phillips", PassengerType.ADULT, "1972-12-31",
                                     bookings.get(15)));

        for (Passenger passenger : passengers) {
            passengerService.createPassenger(passenger);
        }

        // user
        List<RegisterRequest> registerRequests = new ArrayList<>();
        registerRequests.add(new RegisterRequest("Khai", "Hoang", "khaihd@gmail.com", "abc123", Role.ADMIN));
        registerRequests.add(new RegisterRequest("Anh", "Hoang", "hanguyen@gmail.com", "hangmen1", Role.ADMIN));
        registerRequests.add(new RegisterRequest("Linh", "Nguyen", "linhnguyen@gmail.com", "password1", Role.USER));
        registerRequests.add(new RegisterRequest("Minh", "Pham", "minhpham@gmail.com", "password2", Role.USER));
        registerRequests.add(new RegisterRequest("Hoa", "Tran", "hoatran@gmail.com", "password3", Role.USER));
        registerRequests.add(new RegisterRequest("Tien", "Le", "tienle@gmail.com", "password4", Role.USER));

        for (RegisterRequest request : registerRequests) {
            authenticationService.register(request);
        }


        // post

        String filePath =
                "src/main/java/com/khaikin/airline/test/gintoki.jpg";
        String filePath1 =
                "src/main/java/com/khaikin/airline/test/gintoki_01.jpg";
        String filePath2 =
                "src/main/java/com/khaikin/airline/test/gintoki_02.jpg";

        byte[] imageData = Files.readAllBytes(Paths.get(filePath));
        byte[] imageData1 = Files.readAllBytes(Paths.get(filePath1));
        byte[] imageData2 = Files.readAllBytes(Paths.get(filePath2));

        List<Post> posts = List.of(new Post[]{
                new Post("news", "Tin tức hôm nay",
                         "Hôm nay có rất nhiều tin tức quan trọng trong ngành công nghệ.",
                         "news1.jpg", "image/jpeg", imageData),

                new Post("news", "Cập nhật mới nhất về sản phẩm",
                         "Chúng tôi vừa ra mắt một dòng sản phẩm mới, hãy cùng tìm hiểu.",
                         "news2.jpg", "image/jpeg", imageData1),

                new Post("discount", "Khuyến mãi cuối năm",
                         "Giảm giá lên đến 50% cho tất cả các sản phẩm trong tháng 12.",
                         "discount1.jpg", "image/jpeg", imageData2),

                new Post("discount", "Flash Sale hôm nay",
                         "Mua 1 tặng 1 trong ngày hôm nay cho các sản phẩm chọn lọc.",
                         "discount2.jpg", "image/jpeg", imageData1),

                new Post("news", "Thị trường chứng khoán 2024",
                         "Tình hình chứng khoán hiện tại có những dấu hiệu tích cực trong những ngày qua.",
                         "news3.jpg", "image/jpeg", imageData2),

                new Post("news", "Sự kiện thể thao sắp tới",
                         "Một sự kiện thể thao lớn sẽ diễn ra vào cuối tuần này, đừng bỏ lỡ.",
                         "news4.jpg", "image/jpeg", imageData),

                new Post("event", "Tổ chức sự kiện sắp tới",
                         "Đừng quên tham gia sự kiện lớn vào cuối tháng này với nhiều hoạt động hấp dẫn.",
                         "event1.jpg", "image/jpeg", imageData2),

                new Post("event", "Chương trình hội thảo chuyên đề",
                         "Chúng tôi sẽ tổ chức một hội thảo chuyên đề vào cuối tuần này. Đăng ký ngay.",
                         "event2.jpg", "image/jpeg", imageData1)
        });
        for (Post post : posts) {
            postService.createPost(post);
        }
    }
}
