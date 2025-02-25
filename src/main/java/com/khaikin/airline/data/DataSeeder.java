package com.khaikin.airline.data;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airplane.AirplaneService;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportService;
import com.khaikin.airline.auth.AuthenticationService;
import com.khaikin.airline.auth.RegisterRequest;
import com.khaikin.airline.booking.Booking;
import com.khaikin.airline.booking.BookingService;
import com.khaikin.airline.booking.BookingStatus;
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

import java.time.LocalDate;
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

//        Boolean flag = true;
//        if (flag) return;

        // airport
        List<Airport> airports = new ArrayList<>();

        airports.add(new Airport("Noi Bai International", "HAN", "Asia", "Ha Noi, Viet Nam",
                                 "Hanoi is the capital of Vietnam, known for its centuries-old architecture, vibrant culture, and beautiful lakes.",
                                 "https://vietnamdiscovery.com/wp-content/uploads/2019/09/Hanoi-Vietnam.jpg"));
        airports.add(new Airport("Tan Son Nhat International", "SGN", "Asia", "Ho Chi Minh City, Viet Nam",
                                 "Ho Chi Minh City (formerly Saigon) is the largest city in Vietnam, famous for its bustling streets, rich history, and dynamic energy.",
                                 "https://lp-cms-production.imgix.net/2021-01/shutterstockRF_718619590.jpg"));
        airports.add(new Airport("Da Nang International", "DAD", "Asia", "Da Nang, Viet Nam",
                                 "Da Nang is a coastal city in central Vietnam, known for its beautiful beaches, stunning mountain views, and historical landmarks.",
                                 "https://vcdn1-dulich.vnecdn.net/2022/06/03/cauvang-1654247842-9403-1654247849.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=Swd6JjpStebEzT6WARcoOA"));
        airports.add(new Airport("Cam Ranh International", "CXR", "Asia", "Nha Trang, Viet Nam",
                                 "Nha Trang is a popular coastal resort city, known for its stunning beaches, vibrant nightlife, and rich cultural heritage.",
                                 "https://www.getvisavietnam.com/wp-content/uploads/2024/01/Nha-Trang-Khanh-Hoa-Vietnam.jpg"));
        airports.add(new Airport("Phu Quoc International", "PQC", "Asia", "Phu Quoc, Viet Nam",
                                 "Phu Quoc is an idyllic island known for its beautiful beaches, clear waters, and tranquil atmosphere, making it a popular tourist destination.",
                                 "https://www.pelago.com/img/destinations/phu-quoc/0725-0622_phuquoc-xlarge.jpg"));
        airports.add(new Airport("Changi", "SIN", "Asia", "Singapore, Singapore",
                                 "Singapore is a global financial hub, known for its cleanliness, futuristic architecture, and rich multicultural heritage.",
                                 "https://www.agoda.com/wp-content/uploads/2024/04/Featured-image-Singapore-at-night.jpg"));
        airports.add(new Airport("Suvarnabhumi", "BKK", "Asia", "Bangkok, Thailand",
                                 "Bangkok is Thailand’s capital, known for its vibrant street life, ornate temples, and bustling markets.",
                                 "https://longphutravel.com/uploads/gallery/bangkok-pattaya-2023/thai-lan-bangkok-pattaya-bay-thang-tu-tpho-chi-minh-longphutourist-00.jpg"));
        airports.add(new Airport("Kuala Lumpur International", "KUL", "Asia", "Kuala Lumpur, Malaysia",
                                 "Kuala Lumpur is the capital city of Malaysia, known for its modern skyline, shopping, and food culture.",
                                 "https://content.r9cdn.net/rimg/dimg/1e/f2/0916f4b2-city-4723-1628829b6c4.jpg?width=1366&height=768&xhint=1334&yhint=1020&crop=true"));
        airports.add(new Airport("Hong Kong International", "HKG", "Asia", "Hong Kong, China",
                                 "Hong Kong is a global financial center, known for its skyline, busy harbor, and as a gateway between East and West.",
                                 "https://www.agoda.com/wp-content/uploads/2024/02/Featured-image-Hong-Kong-skyline-from-Kow-Loon-1244x700.jpg"));
        airports.add(new Airport("Incheon International", "ICN", "Asia", "Seoul, South Korea",
                                 "Seoul is South Korea’s capital, offering a dynamic mix of modern skyscrapers, traditional palaces, and vibrant street markets.",
                                 "https://www.agoda.com/wp-content/uploads/2024/08/Namsan-Tower-during-autumn-in-Seoul-South-Korea.jpg"));
        airports.add(new Airport("Narita", "NRT", "Asia", "Tokyo, Japan",
                                 "Tokyo is one of the most populous cities in the world, known for its blend of traditional culture and modern technology.",
                                 "https://file3.qdnd.vn/data/images/0/2024/01/03/upload_2299/tokyo.jpg?dpi=150&quality=100&w=870"));
        airports.add(new Airport("Beijing Capital International", "PEK", "Asia", "Beijing, China",
                                 "Beijing is China’s capital, rich in historical landmarks, including the Forbidden City and the Great Wall of China.",
                                 "https://content.r9cdn.net/rimg/dimg/62/28/22c46ab3-city-3286-164700d5d0b.jpg?width=1366&height=768&xhint=1506&yhint=1211&crop=true"));
        airports.add(new Airport("Shanghai Pudong International", "PVG", "Asia", "Shanghai, China",
                                 "Shanghai is China’s largest city, known for its futuristic skyline, historic landmarks, and being a global financial hub.",
                                 "https://www.agoda.com/wp-content/uploads/2024/01/Featued-image-Shanghai-city-skyline-1244x700.jpg"));
        airports.add(new Airport("Dubai International", "DXB", "Asia", "Dubai, United Arab Emirates",
                                 "Dubai is a global city, known for its luxury shopping, ultramodern architecture, and thriving tourism industry.",
                                 "https://www.agoda.com/wp-content/uploads/2024/04/Featured-image-Dubai-UAE.jpg"));
        airports.add(new Airport("Abu Dhabi International", "AUH", "Asia", "Abu Dhabi, United Arab Emirates",
                                 "Abu Dhabi is the capital of the UAE, known for its stunning modern architecture, luxury shopping, and beautiful beaches.",
                                 "https://content.r9cdn.net/rimg/dimg/a8/85/bbf8aa0b-city-9457-164d6a9147e.jpg?width=1366&height=768&xhint=2731&yhint=1539&crop=true"));

        airports.add(new Airport("Heathrow", "LHR", "Europe", "London, United Kingdom",
                                 "London is the capital of the United Kingdom, known for its rich history, iconic landmarks, and cultural diversity.",
                                 "https://assets.editorial.aetnd.com/uploads/2019/03/topic-london-gettyimages-760251843-feature.jpg"));
        airports.add(new Airport("Charles de Gaulle", "CDG", "Europe", "Paris, France",
                                 "Paris is the capital of France, known for its romantic ambiance, historic architecture, and world-famous landmarks like the Eiffel Tower.",
                                 "https://cdn.britannica.com/31/255531-050-B7E07090/eiffel-tower-paris-france-champ-de-mars-view.jpg"));
        airports.add(new Airport("Frankfurt", "FRA", "Europe", "Frankfurt, Germany",
                                 "Frankfurt is Germany’s financial capital, known for its modern skyline and being a key international transport hub.",
                                 "https://static.independent.co.uk/2024/06/26/16/iStock-1151497055.jpg"));
        airports.add(new Airport("Munich", "MUC", "Europe", "Munich, Germany",
                                 "Munich is famous for its beer gardens, rich cultural scene, and as the home of the annual Oktoberfest.",
                                 "https://statemag.state.gov/wp-content/uploads/2020/10/1120POM-1.jpg"));
        airports.add(new Airport("Rome Fiumicino", "FCO", "Europe", "Rome, Italy",
                                 "Rome is Italy's capital, filled with ancient history, including the Colosseum, Roman Forum, and the Vatican.",
                                 "https://www.italyperfect.com/g/photos/upload/sml_845543004-1590582528-ip-info-rome.jpg"));
        airports.add(new Airport("Madrid-Barajas", "MAD", "Europe", "Madrid, Spain",
                                 "Madrid is Spain's capital, known for its lively atmosphere, art museums, and beautiful parks.",
                                 "https://www.hotelpuertamerica.com/uploads/9/8/2/4/98249186/adobestock-103181516_1_orig.jpg"));
        airports.add(new Airport("Lisbon Humberto Delgado", "LIS", "Europe", "Lisbon, Portugal",
                                 "Lisbon is the capital of Portugal, known for its historical sites, vibrant nightlife, and beautiful coastal views.",
                                 "https://wanderlustcrew.com/wp-content/uploads/2023/03/Where-to-Stay-in-Lisbon.jpeg"));
        airports.add(new Airport("Zurich", "ZRH", "Europe", "Zurich, Switzerland",
                                 "Zurich is Switzerland’s largest city, known for its stunning lakeside views, charming old town, and global financial center.",
                                 "https://alpexcursion.com/storage/media/Zurich/Zurichs-Old-Town.webp"));

        airports.add(new Airport("Los Angeles International", "LAX", "America", "Los Angeles, United States",
                                 "Los Angeles is the entertainment capital of the world, known for Hollywood, beaches, and year-round sunny weather.",
                                 "https://indec.vn/wp-content/uploads/2024/07/GettyImages-1346202245-scaled.webp"));
        airports.add(new Airport("John F. Kennedy International", "JFK", "America", "New York, United States",
                                 "New York City is known as 'The Big Apple', famous for its iconic skyline, diverse culture, and landmarks such as Times Square and Central Park.",
                                 "https://res.cloudinary.com/shipit-cdn/images/f_auto,q_auto/v1733410609/wordpress/new-york/new-york.jpg?_i=AA"));
        airports.add(new Airport("San Francisco International", "SFO", "America", "San Francisco, United States",
                                 "San Francisco is famous for its iconic Golden Gate Bridge, vibrant arts scene, and historic neighborhoods like Chinatown.",
                                 "https://content.r9cdn.net/rimg/dimg/69/1b/cca1e76b-city-13852-1633ad11236.jpg?width=1366&height=768&xhint=1966&yhint=1018&crop=true"));
        airports.add(new Airport("Toronto Pearson International", "YYZ", "America", "Toronto, Canada",
                                 "Toronto is Canada’s largest city, known for its multicultural atmosphere, beautiful skyline, and world-class attractions.",
                                 "https://cdn.britannica.com/35/100235-050-CE3936EE/view-CN-Tower-Toronto-skyline-observation-deck.jpg"));
        airports.add(new Airport("Mexico City International", "MEX", "America", "Mexico City, Mexico",
                                 "Mexico City is the capital of Mexico, known for its rich cultural heritage, bustling city life, and historic landmarks.",
                                 "https://a.eu.mktgcdn.com/f/100004519/pO-r3qoPr4M6KyIxlwEU9FPSlfp-Xay_MeGP0DIdWfY.jpg"));
        airports.add(new Airport("Los Angeles Long Beach", "LGB", "America", "Long Beach, United States",
                                 "Long Beach is a coastal city in California, known for its waterfront attractions, historical landmarks, and relaxed atmosphere.",
                                 "https://www.visitlongbeach.com/imager/cmsimages/meta-images/48371416/Sunset-DTLB-Skyline-for-Meta-Image_91852798b59be8b28fc00edfe4aec23a.jpg"));
        airports.add(new Airport("Miami International", "MIA", "America", "Miami, United States",
                                 "Miami is a vibrant city known for its beaches, Latin culture, and lively nightlife.",
                                 "https://a.eu.mktgcdn.com/f/100004519/AGs-7NCvKQVFaEBlWyQ7SptVv7O9t-WcxGWdtu0uwM8.jpg"));
        airports.add(new Airport("Vancouver International", "YVR", "America", "Vancouver, Canada",
                                 "Vancouver is a major port city in Canada, known for its beautiful natural scenery and vibrant arts and culture scene.",
                                 "https://transcode-v2.app.engoo.com/image/fetch/f_auto,c_lfill,w_300,dpr_3/https://assets.app.engoo.com/organizations/5d2656f1-9162-461d-88c7-b2505623d8cb/images/4bHZexPUt9GiT4lPoGz5Kg.jpeg"));
        airports.add(new Airport("Los Angeles Ontario International", "ONT", "America", "Ontario, United States",
                                 "Ontario is a city in California, known for its convenient location and access to many attractions in Southern California.",
                                 "https://educationontario.com/app/uploads/2022/04/Toronto-city-and-lake.jpg"));

        airports.add(new Airport("Sydney Kingsford Smith", "SYD", "Oceania", "Sydney, Australia",
                                 "Sydney is Australia’s largest city, known for its iconic Opera House, Harbour Bridge, and vibrant coastal lifestyle.",
                                 "https://cdn.britannica.com/71/188471-050-CF188A6B/Sydney-Opera-House-Port-Jackson.jpg"));
        airports.add(new Airport("Auckland International", "AKL", "Oceania", "Auckland, New Zealand",
                                 "Auckland is New Zealand’s largest city, known for its stunning harbors, beautiful parks, and vibrant cultural life.",
                                 "https://upload.wikimedia.org/wikipedia/commons/c/c9/Auckland_skyline_-_May_2024_%282%29.jpg"));
        airports.add(new Airport("Queenstown", "ZQN", "Oceania", "Queenstown, New Zealand",
                                 "Queenstown is New Zealand’s adventure capital, offering breathtaking landscapes and exciting outdoor activities.",
                                 "https://newzealandwanderer.com/wp-content/uploads/Queenstown-New-Zealand-2.jpg"));
        airports.add(new Airport("Melbourne Tullamarine", "MEL", "Oceania", "Melbourne, Australia",
                                 "Melbourne is known for its arts and culture, sporting events, and thriving culinary scene.",
                                 "https://www.agoda.com/wp-content/uploads/2024/08/melbourne-australia-featured-1244x700.jpg"));
        airports.add(new Airport("Brisbane International", "BNE", "Oceania", "Brisbane, Australia",
                                 "Brisbane is a vibrant city known for its sunny weather, beautiful parks, and thriving outdoor lifestyle.",
                                 "https://fareast.net.au/wp-content/uploads/2024/05/shutterstock_657755617-scaled.jpg"));
        airports.add(new Airport("Christchurch International", "CHC", "Oceania", "Christchurch, New Zealand",
                                 "Christchurch is the largest city on New Zealand’s South Island, known for its beautiful parks and gardens.",
                                 "https://www.lovoirbeauty.com/wp-content/uploads/2023/07/1-5-768x512.png"));
        airports.add(new Airport("Wellington International", "WLG", "Oceania", "Wellington, New Zealand",
                                 "Wellington is New Zealand’s capital, known for its lively arts scene, stunning waterfront, and unique cultural identity.",
                                 "https://www.newzealand.com/assets/Tourism-NZ/Wellington/img-1536237965-7200-15477-p-E946185A-06D2-650F-15B99BC19228455E-2544003__aWxvdmVrZWxseQo_CropResizeWzE5MDAsMTAwMCw3NSwianBnIl0.jpg"));

        airports.add(new Airport("O.R. Tambo International", "JNB", "Africa", "Johannesburg, South Africa",
                                 "Johannesburg is South Africa's largest city, known for its rich history, vibrant culture, and economic importance.",
                                 "https://content.r9cdn.net/rimg/dimg/31/e0/c782a711-city-26961-1644bcd0e85.jpg?crop=true&width=1020&height=498"));
        airports.add(new Airport("Cairo International", "CAI", "Africa", "Cairo, Egypt",
                                 "Cairo is Egypt's capital, famous for its ancient monuments like the Pyramids and the Sphinx, as well as its bustling urban life.",
                                 "https://res.klook.com/image/upload/c_fill,w_750,h_750/q_80/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/t5yf8wmferyhpt5zkalv.jpg"));
        airports.add(new Airport("Cape Town International", "CPT", "Africa", "Cape Town, South Africa",
                                 "Cape Town is one of South Africa's most beautiful cities, known for its stunning beaches, Table Mountain, and rich cultural heritage.",
                                 "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/10/2e/1e/cape-town.jpg?w=1200&h=700&s=1"));
        airports.add(new Airport("Murtala Muhammed International", "LOS", "Africa", "Lagos, Nigeria",
                                 "Lagos is Nigeria's largest city, known for its vibrant music scene, economic hub, and rapidly growing infrastructure.",
                                 "https://149990825.v2.pressablecdn.com/wp-content/uploads/2023/09/Lagos1.jpg"));
        airports.add(new Airport("Jomo Kenyatta International", "NBO", "Africa", "Nairobi, Kenya",
                                 "Nairobi is Kenya's capital, known for its rich wildlife, including Nairobi National Park, and its growing status as a tech hub in Africa.",
                                 "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/38000/38950-Nairobi.jpg"));


        for (Airport airport : airports) {
            airportService.createAirport(airport);
        }

        // airplane
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new Airplane("AP002", "Airbus A320", "Airbus", 150, 12));
        airplanes.add(new Airplane("AP006", "Airbus A330", "Airbus", 200, 15));
        airplanes.add(new Airplane("AP008", "Airbus A340", "Airbus", 250, 20));
        airplanes.add(new Airplane("AP004", "Airbus A350", "Airbus", 300, 50));
        airplanes.add(new Airplane("AP010", "Airbus A380", "Airbus", 400, 65));

        airplanes.add(new Airplane("AP001", "Boeing 737", "Boeing", 150, 20));
        airplanes.add(new Airplane("AP007", "Boeing 747", "Boeing", 500, 80));
        airplanes.add(new Airplane("AP009", "Boeing 767", "Boeing", 170, 25));
        airplanes.add(new Airplane("AP005", "Boeing 777", "Boeing", 280, 30));
        airplanes.add(new Airplane("AP003", "Boeing 787", "Boeing", 350, 40));


        for (Airplane airplane : airplanes) {
            airplaneService.createAirplane(airplane);
        }

        // flight
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(LocalDateTime.of(2024, 10, 4, 6, 0), "F0000", LocalDateTime.of(2024, 10, 4, 8, 0),
                               FlightStatus.ARRIVED, 400, 800, airplanes.get(0), airports.get(0), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2024, 11, 7, 16, 0), "F0001", LocalDateTime.of(2024, 11, 7, 18, 0),
                               FlightStatus.ARRIVED, 500, 1000, airplanes.get(9), airports.get(8), airports.get(16)));

        flights.add(new Flight(LocalDateTime.of(2024, 11, 8, 6, 0), "F0002", LocalDateTime.of(2024, 11, 8, 8, 0),
                               FlightStatus.ARRIVED, 600, 1200, airplanes.get(8), airports.get(15), airports.get(16)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 20, 20, 0), "F0003", LocalDateTime.of(2024, 12, 20, 22, 0),
                               FlightStatus.IN_AIR, 200, 500, airplanes.get(1), airports.get(0), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 21, 14, 0), "F0004", LocalDateTime.of(2024, 12, 21, 16, 0),
                               FlightStatus.SCHEDULED, 300, 600, airplanes.get(2), airports.get(0), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 21, 15, 0), "F0005", LocalDateTime.of(2024, 12, 21, 20, 0),
                               FlightStatus.SCHEDULED, 250, 500, airplanes.get(0), airports.get(0), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 22, 22, 0), "F0006", LocalDateTime.of(2024, 12, 23, 1, 0),
                               FlightStatus.CANCELLED, 200, 500, airplanes.get(3), airports.get(1), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 22, 1, 0), "F0007", LocalDateTime.of(2024, 12, 22, 3, 0),
                               FlightStatus.SCHEDULED, 200, 400, airplanes.get(4), airports.get(0), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 23, 5, 0), "F0008", LocalDateTime.of(2024, 12, 23, 7, 0),
                               FlightStatus.SCHEDULED, 300, 600, airplanes.get(0), airports.get(1), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 23, 9, 0), "F0009", LocalDateTime.of(2024, 12, 23, 11, 0),
                               FlightStatus.SCHEDULED, 400, 800, airplanes.get(5), airports.get(0), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 13, 0), "F0010", LocalDateTime.of(2024, 12, 24, 15, 0),
                               FlightStatus.SCHEDULED, 300, 600, airplanes.get(2), airports.get(6), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 17, 0), "F0011", LocalDateTime.of(2024, 12, 24, 19, 0),
                               FlightStatus.SCHEDULED, 600, 1200, airplanes.get(3), airports.get(8), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 17, 0), "F0012", LocalDateTime.of(2024, 12, 24, 19, 0),
                               FlightStatus.SCHEDULED, 700, 1400, airplanes.get(4), airports.get(8), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 17, 0), "F0013", LocalDateTime.of(2024, 12, 24, 19, 0),
                               FlightStatus.SCHEDULED, 800, 1600, airplanes.get(3), airports.get(5), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 25, 17, 0), "F0014", LocalDateTime.of(2024, 12, 25, 19, 0),
                               FlightStatus.SCHEDULED, 750, 1800, airplanes.get(3), airports.get(5), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 26, 9, 0), "F0015", LocalDateTime.of(2024, 12, 26, 12, 0),
                               FlightStatus.SCHEDULED, 200, 400, airplanes.get(5), airports.get(1), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 2, 7, 0), "F0016", LocalDateTime.of(2025, 1, 2, 9, 0),
                               FlightStatus.SCHEDULED, 500, 1000, airplanes.get(1), airports.get(0), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 3, 10, 0), "F0017", LocalDateTime.of(2025, 1, 3, 12, 0),
                               FlightStatus.SCHEDULED, 600, 1200, airplanes.get(2), airports.get(1), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 4, 15, 0), "F0018", LocalDateTime.of(2025, 1, 4, 17, 0),
                               FlightStatus.SCHEDULED, 700, 1400, airplanes.get(3), airports.get(3), airports.get(4)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 5, 18, 0), "F0019", LocalDateTime.of(2025, 1, 5, 20, 0),
                               FlightStatus.SCHEDULED, 800, 1600, airplanes.get(4), airports.get(5), airports.get(6)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 6, 10, 0), "F0020", LocalDateTime.of(2025, 1, 6, 12, 0),
                               FlightStatus.SCHEDULED, 900, 1800, airplanes.get(5), airports.get(6), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 7, 14, 0), "F0021", LocalDateTime.of(2025, 1, 7, 16, 0),
                               FlightStatus.SCHEDULED, 100, 200, airplanes.get(6), airports.get(7), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 8, 9, 0), "F0022", LocalDateTime.of(2025, 1, 8, 11, 0),
                               FlightStatus.SCHEDULED, 110, 220, airplanes.get(7), airports.get(8), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 9, 16, 0), "F0023", LocalDateTime.of(2025, 1, 9, 18, 0),
                               FlightStatus.SCHEDULED, 120, 240, airplanes.get(8), airports.get(9), airports.get(10)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 10, 17, 0), "F0024", LocalDateTime.of(2025, 1, 10, 19, 0),
                               FlightStatus.SCHEDULED, 130, 260, airplanes.get(9), airports.get(10), airports.get(11)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 11, 11, 0), "F0025", LocalDateTime.of(2025, 1, 11, 13, 0),
                               FlightStatus.SCHEDULED, 140, 280, airplanes.get(0), airports.get(11), airports.get(12)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 12, 8, 0), "F0026", LocalDateTime.of(2025, 1, 12, 10, 0),
                               FlightStatus.SCHEDULED, 150, 300, airplanes.get(1), airports.get(12), airports.get(13)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 13, 12, 0), "F0027", LocalDateTime.of(2025, 1, 13, 14, 0),
                               FlightStatus.SCHEDULED, 160, 320, airplanes.get(2), airports.get(13), airports.get(14)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 14, 17, 0), "F0028", LocalDateTime.of(2025, 1, 14, 19, 0),
                               FlightStatus.SCHEDULED, 170, 340, airplanes.get(3), airports.get(14), airports.get(15)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 15, 7, 0), "F0029", LocalDateTime.of(2025, 1, 15, 9, 0),
                               FlightStatus.SCHEDULED, 180, 360, airplanes.get(4), airports.get(15), airports.get(16)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 16, 10, 0), "F0030", LocalDateTime.of(2025, 1, 16, 12, 0),
                               FlightStatus.SCHEDULED, 190, 380, airplanes.get(5), airports.get(16), airports.get(17)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 17, 15, 0), "F0031", LocalDateTime.of(2025, 1, 17, 17, 0),
                               FlightStatus.SCHEDULED, 200, 400, airplanes.get(6), airports.get(17), airports.get(18)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 18, 9, 0), "F0032", LocalDateTime.of(2025, 1, 18, 11, 0),
                               FlightStatus.SCHEDULED, 210, 420, airplanes.get(7), airports.get(18), airports.get(19)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 19, 18, 0), "F0033", LocalDateTime.of(2025, 1, 19, 20, 0),
                               FlightStatus.SCHEDULED, 220, 440, airplanes.get(8), airports.get(19), airports.get(20)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 20, 13, 0), "F0034", LocalDateTime.of(2025, 1, 20, 15, 0),
                               FlightStatus.SCHEDULED, 230, 460, airplanes.get(9), airports.get(20), airports.get(21)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 21, 6, 0), "F0035", LocalDateTime.of(2025, 1, 21, 8, 0),
                               FlightStatus.SCHEDULED, 240, 480, airplanes.get(0), airports.get(21), airports.get(22)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 22, 8, 0), "F0036", LocalDateTime.of(2025, 1, 22, 10, 0),
                               FlightStatus.SCHEDULED, 250, 500, airplanes.get(1), airports.get(0), airports.get(15)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 23, 9, 0), "F0037", LocalDateTime.of(2025, 1, 23, 11, 0),
                               FlightStatus.SCHEDULED, 260, 520, airplanes.get(2), airports.get(9), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 24, 14, 0), "F0038", LocalDateTime.of(2025, 1, 24, 16, 0),
                               FlightStatus.SCHEDULED, 270, 540, airplanes.get(3), airports.get(7), airports.get(19)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 15, 0), "F0039", LocalDateTime.of(2025, 1, 25, 17, 0),
                               FlightStatus.SCHEDULED, 280, 560, airplanes.get(4), airports.get(18), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 26, 17, 0), "F0040", LocalDateTime.of(2025, 1, 26, 19, 0),
                               FlightStatus.SCHEDULED, 290, 580, airplanes.get(5), airports.get(20), airports.get(13)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 27, 10, 0), "F0041", LocalDateTime.of(2025, 1, 27, 12, 0),
                               FlightStatus.SCHEDULED, 300, 600, airplanes.get(6), airports.get(5), airports.get(10)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 28, 12, 0), "F0042", LocalDateTime.of(2025, 1, 28, 14, 0),
                               FlightStatus.SCHEDULED, 310, 620, airplanes.get(7), airports.get(17), airports.get(16)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 29, 16, 0), "F0043", LocalDateTime.of(2025, 1, 29, 18, 0),
                               FlightStatus.SCHEDULED, 320, 640, airplanes.get(8), airports.get(3), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 30, 17, 0), "F0044", LocalDateTime.of(2025, 1, 30, 19, 0),
                               FlightStatus.SCHEDULED, 330, 660, airplanes.get(9), airports.get(6), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 1, 11, 0), "F0045", LocalDateTime.of(2025, 2, 1, 13, 0),
                               FlightStatus.SCHEDULED, 340, 680, airplanes.get(0), airports.get(0), airports.get(14)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 2, 13, 0), "F0046", LocalDateTime.of(2025, 2, 2, 15, 0),
                               FlightStatus.SCHEDULED, 350, 700, airplanes.get(1), airports.get(1), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 3, 14, 0), "F0047", LocalDateTime.of(2025, 2, 3, 16, 0),
                               FlightStatus.SCHEDULED, 360, 720, airplanes.get(2), airports.get(2), airports.get(4)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 4, 18, 0), "F0048", LocalDateTime.of(2025, 2, 4, 20, 0),
                               FlightStatus.SCHEDULED, 370, 740, airplanes.get(3), airports.get(15), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 5, 9, 0), "F0049", LocalDateTime.of(2025, 2, 5, 11, 0),
                               FlightStatus.SCHEDULED, 380, 760, airplanes.get(4), airports.get(4), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 6, 12, 0), "F0050", LocalDateTime.of(2025, 2, 6, 14, 0),
                               FlightStatus.SCHEDULED, 390, 780, airplanes.get(5), airports.get(9), airports.get(16)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 7, 15, 0), "F0051", LocalDateTime.of(2025, 2, 7, 17, 0),
                               FlightStatus.SCHEDULED, 400, 800, airplanes.get(6), airports.get(10), airports.get(12)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 8, 10, 0), "F0052", LocalDateTime.of(2025, 2, 8, 12, 0),
                               FlightStatus.SCHEDULED, 410, 820, airplanes.get(7), airports.get(13), airports.get(11)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 16, 0), "F0053", LocalDateTime.of(2025, 2, 9, 18, 0),
                               FlightStatus.SCHEDULED, 420, 840, airplanes.get(8), airports.get(11), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 10, 17, 0), "F0054", LocalDateTime.of(2025, 2, 10, 19, 0),
                               FlightStatus.SCHEDULED, 430, 860, airplanes.get(9), airports.get(6), airports.get(17)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 11, 14, 0), "F0055", LocalDateTime.of(2025, 2, 11, 16, 0),
                               FlightStatus.SCHEDULED, 440, 880, airplanes.get(0), airports.get(5), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 12, 9, 0), "F0056", LocalDateTime.of(2025, 2, 12, 11, 0),
                               FlightStatus.SCHEDULED, 450, 900, airplanes.get(1), airports.get(12), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 13, 12, 0), "F0057", LocalDateTime.of(2025, 2, 13, 14, 0),
                               FlightStatus.SCHEDULED, 460, 920, airplanes.get(2), airports.get(16), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 14, 18, 0), "F0058", LocalDateTime.of(2025, 2, 14, 20, 0),
                               FlightStatus.SCHEDULED, 470, 940, airplanes.get(3), airports.get(7), airports.get(18)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 15, 8, 0), "F0059", LocalDateTime.of(2025, 2, 15, 10, 0),
                               FlightStatus.SCHEDULED, 480, 960, airplanes.get(4), airports.get(10), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 16, 11, 0), "F0060", LocalDateTime.of(2025, 2, 16, 13, 0),
                               FlightStatus.SCHEDULED, 490, 980, airplanes.get(5), airports.get(9), airports.get(13)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 7, 0), "F0061", LocalDateTime.of(2025, 2, 9, 9, 0),
                               FlightStatus.SCHEDULED, 250, 500, airplanes.get(1), airports.get(0), airports.get(4)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 8, 0), "F0062", LocalDateTime.of(2025, 2, 9, 10, 0),
                               FlightStatus.SCHEDULED, 260, 520, airplanes.get(2), airports.get(3), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 8, 30), "F0063", LocalDateTime.of(2025, 2, 9, 10, 30),
                               FlightStatus.SCHEDULED, 270, 540, airplanes.get(3), airports.get(6), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 9, 0), "F0064", LocalDateTime.of(2025, 2, 9, 11, 0),
                               FlightStatus.SCHEDULED, 280, 560, airplanes.get(4), airports.get(7), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 10, 0), "F0065", LocalDateTime.of(2025, 2, 9, 12, 0),
                               FlightStatus.SCHEDULED, 290, 580, airplanes.get(5), airports.get(2), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 11, 0), "F0066", LocalDateTime.of(2025, 2, 9, 13, 0),
                               FlightStatus.SCHEDULED, 300, 600, airplanes.get(6), airports.get(4), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 12, 0), "F0067", LocalDateTime.of(2025, 2, 9, 14, 0),
                               FlightStatus.SCHEDULED, 310, 620, airplanes.get(7), airports.get(5), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 13, 0), "F0068", LocalDateTime.of(2025, 2, 9, 15, 0),
                               FlightStatus.SCHEDULED, 320, 640, airplanes.get(8), airports.get(9), airports.get(10)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 14, 0), "F0069", LocalDateTime.of(2025, 2, 9, 16, 0),
                               FlightStatus.SCHEDULED, 330, 660, airplanes.get(9), airports.get(1), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 15, 0), "F0070", LocalDateTime.of(2025, 2, 9, 17, 0),
                               FlightStatus.SCHEDULED, 340, 680, airplanes.get(0), airports.get(7), airports.get(11)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 16, 0), "F0071", LocalDateTime.of(2025, 2, 9, 18, 0),
                               FlightStatus.SCHEDULED, 350, 700, airplanes.get(1), airports.get(6), airports.get(14)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 17, 0), "F0072", LocalDateTime.of(2025, 2, 9, 19, 0),
                               FlightStatus.SCHEDULED, 360, 720, airplanes.get(2), airports.get(13), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 18, 0), "F0073", LocalDateTime.of(2025, 2, 9, 20, 0),
                               FlightStatus.SCHEDULED, 370, 740, airplanes.get(3), airports.get(4), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 19, 0), "F0074", LocalDateTime.of(2025, 2, 9, 21, 0),
                               FlightStatus.SCHEDULED, 380, 760, airplanes.get(4), airports.get(8), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 20, 0), "F0075", LocalDateTime.of(2025, 2, 9, 22, 0),
                               FlightStatus.SCHEDULED, 390, 780, airplanes.get(5), airports.get(0), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 21, 0), "F0076", LocalDateTime.of(2025, 2, 9, 23, 0),
                               FlightStatus.SCHEDULED, 400, 800, airplanes.get(6), airports.get(6), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 22, 0), "F0077", LocalDateTime.of(2025, 2, 9, 23, 0),
                               FlightStatus.SCHEDULED, 410, 820, airplanes.get(7), airports.get(1), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 23, 0), "F0078", LocalDateTime.of(2025, 2, 10, 1, 0),
                               FlightStatus.SCHEDULED, 420, 840, airplanes.get(8), airports.get(14), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2025, 2, 9, 23, 30), "F0079", LocalDateTime.of(2025, 2, 10, 1, 30),
                               FlightStatus.SCHEDULED, 430, 860, airplanes.get(9), airports.get(10), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 6, 0), "F0080", LocalDateTime.of(2025, 1, 25, 8, 0),
                               FlightStatus.SCHEDULED, 250, 500, airplanes.get(0), airports.get(1), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 7, 30), "F0081", LocalDateTime.of(2025, 1, 25, 9, 30),
                               FlightStatus.SCHEDULED, 260, 520, airplanes.get(1), airports.get(2), airports.get(4)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 8, 0), "F0082", LocalDateTime.of(2025, 1, 25, 10, 0),
                               FlightStatus.SCHEDULED, 270, 540, airplanes.get(2), airports.get(4), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 8, 30), "F0083", LocalDateTime.of(2025, 1, 25, 10, 30),
                               FlightStatus.SCHEDULED, 280, 560, airplanes.get(3), airports.get(6), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 9, 0), "F0084", LocalDateTime.of(2025, 1, 25, 11, 0),
                               FlightStatus.SCHEDULED, 290, 580, airplanes.get(4), airports.get(7), airports.get(3)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 9, 30), "F0085", LocalDateTime.of(2025, 1, 25, 11, 30),
                               FlightStatus.SCHEDULED, 300, 600, airplanes.get(5), airports.get(0), airports.get(6)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 10, 0), "F0086", LocalDateTime.of(2025, 1, 25, 12, 0),
                               FlightStatus.SCHEDULED, 310, 620, airplanes.get(6), airports.get(8), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 11, 0), "F0087", LocalDateTime.of(2025, 1, 25, 13, 0),
                               FlightStatus.SCHEDULED, 320, 640, airplanes.get(7), airports.get(5), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 12, 0), "F0088", LocalDateTime.of(2025, 1, 25, 14, 0),
                               FlightStatus.SCHEDULED, 330, 660, airplanes.get(8), airports.get(4), airports.get(6)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 12, 30), "F0089", LocalDateTime.of(2025, 1, 25, 14, 30),
                               FlightStatus.SCHEDULED, 340, 680, airplanes.get(9), airports.get(2), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 13, 0), "F0090", LocalDateTime.of(2025, 1, 25, 15, 0),
                               FlightStatus.SCHEDULED, 350, 700, airplanes.get(0), airports.get(1), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 14, 0), "F0091", LocalDateTime.of(2025, 1, 25, 16, 0),
                               FlightStatus.SCHEDULED, 360, 720, airplanes.get(1), airports.get(3), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 15, 0), "F0092", LocalDateTime.of(2025, 1, 25, 17, 0),
                               FlightStatus.SCHEDULED, 370, 740, airplanes.get(2), airports.get(6), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 16, 0), "F0093", LocalDateTime.of(2025, 1, 25, 18, 0),
                               FlightStatus.SCHEDULED, 380, 760, airplanes.get(3), airports.get(5), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 16, 30), "F0094", LocalDateTime.of(2025, 1, 25, 18, 30),
                               FlightStatus.SCHEDULED, 390, 780, airplanes.get(4), airports.get(8), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 17, 0), "F0095", LocalDateTime.of(2025, 1, 25, 19, 0),
                               FlightStatus.SCHEDULED, 400, 800, airplanes.get(5), airports.get(0), airports.get(1)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 18, 0), "F0096", LocalDateTime.of(2025, 1, 25, 20, 0),
                               FlightStatus.SCHEDULED, 410, 820, airplanes.get(6), airports.get(4), airports.get(8)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 19, 0), "F0097", LocalDateTime.of(2025, 1, 25, 21, 0),
                               FlightStatus.SCHEDULED, 420, 840, airplanes.get(7), airports.get(7), airports.get(5)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 20, 0), "F0098", LocalDateTime.of(2025, 1, 25, 22, 0),
                               FlightStatus.SCHEDULED, 430, 860, airplanes.get(8), airports.get(6), airports.get(9)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 21, 0), "F0099", LocalDateTime.of(2025, 1, 25, 23, 0),
                               FlightStatus.SCHEDULED, 440, 880, airplanes.get(9), airports.get(3), airports.get(2)));

        flights.add(new Flight(LocalDateTime.of(2025, 1, 25, 22, 0), "F0100", LocalDateTime.of(2025, 1, 25, 23, 0),
                               FlightStatus.SCHEDULED, 450, 900, airplanes.get(0), airports.get(2), airports.get(7)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 22, 0), "F0101", LocalDateTime.of(2024, 12, 24, 23, 0),
                               FlightStatus.SCHEDULED, 450, 900, airplanes.get(0), airports.get(0), airports.get(10)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 28, 12, 0), "F0102", LocalDateTime.of(2024, 12, 28, 13, 0),
                               FlightStatus.SCHEDULED, 600, 1200, airplanes.get(1), airports.get(10), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 24, 20, 0), "F0103", LocalDateTime.of(2024, 12, 24, 23, 0),
                               FlightStatus.SCHEDULED, 450, 900, airplanes.get(5), airports.get(0), airports.get(10)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 28, 12, 0), "F0104", LocalDateTime.of(2024, 12, 28, 15, 0),
                               FlightStatus.SCHEDULED, 600, 1200, airplanes.get(8), airports.get(10), airports.get(0)));

        flights.add(new Flight(LocalDateTime.of(2024, 12, 28, 12, 0), "F0105", LocalDateTime.of(2024, 12, 28, 15, 0),
                               FlightStatus.SCHEDULED, 600, 1200, airplanes.get(8), airports.get(10),
                               airports.get(0)));


        for (Flight flight : flights) {
            flightService.createFlight(flight);
        }


        // booking
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("khaihd@gmail.com", "0981234561", flights.get(0), "Economy", 200));
        bookings.add(new Booking("user1@gmail.com", "0982345672", flights.get(0), "Business", 400));
        bookings.add(new Booking("user2@gmail.com", "0983456783", flights.get(0), "Economy", 800));
        bookings.add(new Booking("user3@gmail.com", "0984567894", flights.get(1), "Economy", 300));
        bookings.add(new Booking("user4@gmail.com", "0985678905", flights.get(1), "Economy", 1200));
        bookings.add(new Booking("user5@gmail.com", "0986789016", flights.get(2), "Business", 1800));
        bookings.add(new Booking("user6@gmail.com", "0987890127", flights.get(3), "Business", 2000));
        bookings.add(new Booking("user7@gmail.com", "0988901238", flights.get(3), "Business", 600));
        bookings.add(new Booking("user8@gmail.com", "0989012349", flights.get(3), "Business", 800));
        bookings.add(new Booking("user9@gmail.com", "0980123450", flights.get(3), "Economy", 1000));
        bookings.add(new Booking("user10@gmail.com", "0981234560", flights.get(4), "Economy", 500));
        bookings.add(new Booking("user11@gmail.com", "0982345671", flights.get(5), "Economy", 800));
        bookings.add(new Booking("user12@gmail.com", "0983456782", flights.get(6), "Economy", 1000));
        bookings.add(new Booking("user13@gmail.com", "0984567893", flights.get(6), "Economy", 700));
        bookings.add(new Booking("user14@gmail.com", "0985678904", flights.get(7), "Business", 1200));
        bookings.add(new Booking("user15@gmail.com", "0986789015", flights.get(8), "Business", 1000));

        bookings.add(
                new Booking("john.doe@example.com", "0986789016", "Economy", "Business", 1200, true, flights.get(101),
                            flights.get(102)));
        bookings.add(
                new Booking("alice.smith@example.com", "0986789017", "Business", "First", 3500, true, flights.get(101),
                            flights.get(102)));
        bookings.add(
                new Booking("bob.jones@example.com", "0986789018", "First", "Economy", 5000, true, flights.get(103),
                            flights.get(104)));

        bookings.get(3).setBookingStatus(BookingStatus.COMPLETED);
        bookings.get(5).setBookingStatus(BookingStatus.CANCELLED);
        bookings.get(12).setBookingStatus(BookingStatus.COMPLETED);

        for (Booking booking : bookings) {
            bookingService.createBooking(booking);
        }

        // passenger
        List<Passenger> passengers = new ArrayList<>();

        passengers.add(
                new Passenger(PassengerTitle.MR, "John", "Doe", PassengerType.ADULT, LocalDate.parse("1990-01-01"),
                              bookings.get(16)));
        passengers.add(
                new Passenger(PassengerTitle.MRS, "Jane", "Smith", PassengerType.ADULT, LocalDate.parse("1985-05-15"),
                              bookings.get(17)));
        passengers.add(
                new Passenger(PassengerTitle.MS, "Emily", "Johnson", PassengerType.ADULT, LocalDate.parse("1992-09-21"),
                              bookings.get(18)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Michael", "Brown", PassengerType.ADULT,
                                     LocalDate.parse("1978-11-30"), bookings.get(17)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Sarah", "Davis", PassengerType.ADULT,
                                     LocalDate.parse("1965-07-22"), bookings.get(0)));

        passengers.add(
                new Passenger(PassengerTitle.BOY, "James", "Wilson", PassengerType.CHILD, LocalDate.parse("2010-03-10"),
                              bookings.get(1)));
        passengers.add(new Passenger(PassengerTitle.MS, "Olivia", "Martinez", PassengerType.CHILD,
                                     LocalDate.parse("2012-04-18"), bookings.get(1)));

        passengers.add(new Passenger(PassengerTitle.GIRL, "Sophia", "Garcia", PassengerType.INFANT,
                                     LocalDate.parse("2021-06-05"), bookings.get(2)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "David", "Anderson", PassengerType.ADULT,
                                     LocalDate.parse("1980-02-14"), bookings.get(2)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Emma", "Thomas", PassengerType.ADULT,
                                     LocalDate.parse("1973-08-29"), bookings.get(3)));

        passengers.add(
                new Passenger(PassengerTitle.MR, "Chris", "Lee", PassengerType.ADULT, LocalDate.parse("1991-03-03"),
                              bookings.get(4)));
        passengers.add(
                new Passenger(PassengerTitle.MRS, "Anna", "Walker", PassengerType.ADULT, LocalDate.parse("1987-07-12"),
                              bookings.get(5)));
        passengers.add(
                new Passenger(PassengerTitle.MS, "Grace", "Harris", PassengerType.ADULT, LocalDate.parse("1995-08-19"),
                              bookings.get(6)));

        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Lucas", "White", PassengerType.ADULT,
                                     LocalDate.parse("1979-12-25"), bookings.get(7)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Liam", "King", PassengerType.ADULT,
                                     LocalDate.parse("1968-11-11"), bookings.get(8)));

        passengers.add(
                new Passenger(PassengerTitle.GIRL, "Henry", "Baker", PassengerType.CHILD, LocalDate.parse("2011-02-22"),
                              bookings.get(6)));
        passengers.add(new Passenger(PassengerTitle.BOY, "Charlotte", "Wright", PassengerType.CHILD,
                                     LocalDate.parse("2013-05-05"), bookings.get(8)));
        passengers.add(
                new Passenger(PassengerTitle.MRS, "Mia", "Green", PassengerType.INFANT, LocalDate.parse("2020-09-15"),
                              bookings.get(6)));

        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Daniel", "Young", PassengerType.ADULT,
                                     LocalDate.parse("1981-04-04"), bookings.get(9)));
        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Isabella", "Allen", PassengerType.ADULT,
                                     LocalDate.parse("1974-10-10"), bookings.get(10)));
        passengers.add(
                new Passenger(PassengerTitle.MR, "Jackson", "Scott", PassengerType.ADULT, LocalDate.parse("1989-05-25"),
                              bookings.get(11)));

        passengers.add(
                new Passenger(PassengerTitle.MRS, "Ava", "Hill", PassengerType.ADULT, LocalDate.parse("1986-06-14"),
                              bookings.get(8)));
        passengers.add(
                new Passenger(PassengerTitle.MS, "Evelyn", "Adams", PassengerType.ADULT, LocalDate.parse("1993-09-09"),
                              bookings.get(12)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Matthew", "Morris", PassengerType.ADULT,
                                     LocalDate.parse("1976-03-18"), bookings.get(12)));

        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Harper", "Mitchell", PassengerType.ADULT,
                                     LocalDate.parse("1967-02-05"), bookings.get(13)));
        passengers.add(new Passenger(PassengerTitle.BOY, "Landon", "Roberts", PassengerType.CHILD,
                                     LocalDate.parse("2011-06-30"), bookings.get(14)));
        passengers.add(
                new Passenger(PassengerTitle.GIRL, "Ella", "Parker", PassengerType.CHILD, LocalDate.parse("2013-07-20"),
                              bookings.get(9)));

        passengers.add(new Passenger(PassengerTitle.BOY, "Abigail", "Evans", PassengerType.INFANT,
                                     LocalDate.parse("2022-01-01"), bookings.get(14)));
        passengers.add(new Passenger(PassengerTitle.DOCTOR, "Aiden", "Turner", PassengerType.ADULT,
                                     LocalDate.parse("1977-04-15"), bookings.get(15)));

        passengers.add(new Passenger(PassengerTitle.PROFESSOR, "Amelia", "Phillips", PassengerType.ADULT,
                                     LocalDate.parse("1972-12-31"), bookings.get(15)));

        for (Passenger passenger : passengers) {
            passengerService.createPassenger(passenger);
        }

        // user
        List<RegisterRequest> registerRequests = new ArrayList<>();
        registerRequests.add(new RegisterRequest("admin", "super", "admin@gmail.com", "admin", Role.ADMIN));
        registerRequests.add(new RegisterRequest("Khai", "Hoang", "khaihd@gmail.com", "abc123", Role.ADMIN));
        registerRequests.add(new RegisterRequest("Anh", "Hoang", "hanguyen@gmail.com", "hangmen1", Role.ADMIN));
//        registerRequests.add(new RegisterRequest("Linh", "Nguyen", "linhnguyen@gmail.com", "password1", Role.USER));
//        registerRequests.add(new RegisterRequest("Minh", "Pham", "minhpham@gmail.com", "password2", Role.USER));
//        registerRequests.add(new RegisterRequest("Hoa", "Tran", "hoatran@gmail.com", "password3", Role.USER));
//        registerRequests.add(new RegisterRequest("Tien", "Le", "tienle@gmail.com", "password4", Role.USER));

        for (RegisterRequest request : registerRequests) {
            authenticationService.register(request);
        }


        // post

        String filePath0 =
                "uploads/discount_00.jpg";
        String filePath1 =
                "uploads/discount_01.jpg";
        String filePath2 =
                "uploads/discount_02.jpg";
        String filePath3 =
                "uploads/discount_03.jpg";

        List<Post> posts = List.of(new Post[]{
                new Post("discount", "2024 Special Flight Offers",
                         "Book now to save up to 30% on select flights in 2024! Whether for business or leisure, don't miss these limited-time discounts. Secure the best deals while they last!",
                         "discount1.jpg", "image/jpeg", filePath2),

                new Post("discount", "Flash Sale: 24-Hour Flight Discount",
                         "Hurry! For the next 24 hours, enjoy up to 40% off on select flights. Don’t miss out on amazing savings for your next trip – book your tickets now before time runs out.",
                         "discount2.jpg", "image/jpeg", filePath3),

                new Post("discount", "Exclusive 2024 Airline Discounts",
                         "Take advantage of our exclusive 2024 flight discounts and save up to 25%! Book your next adventure or business trip today with unbeatable prices. Hurry, these deals won't last long!",
                         "discount2.jpg", "image/jpeg", filePath1),

                new Post("discount", "2024 Low-Cost Airline Sale",
                         "Don’t miss our 2024 low-cost airline sale! Save up to 30% on selected domestic and " +
                                 "international flights. Perfect for travelers looking for great deals without compromising on quality. Book now before seats fill up!",
                         "discount3.jpg", "image/jpeg", filePath0),

                new Post("news", "Airline Industry in 2024",
                         "The airline industry is set for a big year in 2024 with innovations in eco-friendly planes, better customer service, and smoother travel experiences. Stay tuned for how these trends will shape air travel this year.",
                         "news1.jpg", "image/jpeg", filePath0),

                new Post("news", "New Routes in 2024",
                         "Exciting new flight routes are opening up in 2024! Airlines are expanding their networks to more destinations, giving you more options for your next trip. Check out these new routes and plan your travels.",
                         "news2.jpg", "image/jpeg", filePath2),

                new Post("news", "Safety Innovations in 2024",
                         "Airlines are introducing cutting-edge safety tech this year, from better in-cabin air filtration to advanced monitoring systems. Learn about these innovations ensuring a safer flying experience for you.",
                         "news3.jpg", "image/jpeg", filePath1),

                new Post("news", "Sustainable Air Travel in 2024",
                         "Airlines are embracing sustainability with fuel-efficient planes and carbon offset programs. Find out how these changes are making air travel greener and how you can help.",
                         "news4.jpg", "image/jpeg", filePath0),

                new Post("news", "Premium Airline Services in 2024",
                         "Business and first-class passengers are enjoying even more luxurious services this year, from priority boarding to fine dining. Upgrade your next flight for a truly premium experience.",
                         "news5.jpg", "image/jpeg", filePath3),

                new Post("news", "AI Transforming Airline Service",
                         "AI is improving the airline experience by streamlining check-ins, offering personalized services, and more. Learn how AI is making air travel smarter and more efficient for you.",
                         "news6.jpg", "image/jpeg", filePath2)
        });
        for (Post post : posts) {
            postService.createPost(post);
        }


    }
}
