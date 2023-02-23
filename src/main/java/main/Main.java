package main;

import classes.*;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Wesele", "Stanislaw Wyspianski", "Greg", "Wesele w serii Kolorowa Klasyka to najpiękniejsze kolorowe wydanie tej powieści na rynku! Książka zawiera wspaniałe, barwne ilustracje, jej atutem jest duża, ułatwiająca szybkie czytanie czcionka. Edycja na szlachetnym papierze, bardzo trwała i estetyczna.\n" + "W podkrakowskiej wsi Bronowice w roku 1900 odbyło się wesele Lucjana Rydla z chłopką Jadwigą Mikołajczykówną. Wydarzenie stało się kanwą do jednego z największych polskich dramatów - Wesela Stanisława Wyspiańskiego.\n" + "Na przełomie wieków Polska wciąż nie istniała na mapie Europy. Na weselu bawią się przedstawiciele różnych grup społecznych i nacji. Każda z nich ma inne problemy i inne marzenia, ale pamięć o niepodległej Polsce wciąż jeszcze jest żywa.\n" + "Wielki dramat mówiący o uczuciach Polaków, ich pragnieniach, marzeniach, bohaterach narodowych, ale i upiorach, które nie dają spokoju. Czy Polacy są jeszcze w stanie walczyć o niepodległość, czy pogrążą się w bezładnym chocholim tańcu?\n" + "Piękne wydanie zostało wzbogacone o reprodukcje dzieł z epoki - Teodora Axentowicza, Jacka Malczewskiego, Leona Wyczółkowskiego i samego Wyspiańskiego - oraz o niezwykle ciekawą „Plotkę o Weselu Wyspiańskiego” Tadeusza Boya-Żeleńskiego.", 20, 0);
        Book book2 = new Book("Maly Ksiaze", "Antoine De Saint-Exupery", "Wydawnictwo SBM", "Specjalna edycja klasyki literatury – Mały Książę Antoine’a de Saint- Exupéry – to książka, którą warto mieć w swojej domowej biblioteczce i do której warto wracać.\n" + "Niezwykłe spotkanie w środku pustyni – pilot, który wraz ze swym samolotem spadł z nieba, mały przybysz z nieznanej planety i tajemniczy lis. Oto opowieść o dorastaniu do wiernej miłości, przyjaźni, lojalności i odpowiedzialności za drugiego człowieka.", 50, 0);
        Publication publication1 = new Publication("Educational rationality and religious education in Polish public schools", "Maciej Karwowski, Boguslaw Milerski", "Journal of Beliefs and Values");
        Book book3 = new Book("Ostatnie życzenie", "Andrzej Sapkowski", "superNOWA", "Później mówiono, że człowiek ów nadszedł od północy, od Bramy Powroźniczej. Nie był stary, ale włosy miał zupełnie białe. Kiedy ściągnął płaszcz, okazało się, że na pasie za plecami ma miecz.\n" + "Białowłosego przywiodło do miasta królewskie orędzie: trzy tysiące orenów nagrody za odczarowanie nękającej mieszkańców Wyzimy strzygi.\n" + "Takie czasy nastały. Dawniej po lasach jeno wilki wyły, teraz namnożyło się rozmaitego paskudztwa – gdzie spojrzysz, tam upiory, bazyliszki, diaboły, żywiołaki, wiły i utopce plugawe. A i niebacznie uwolniony z amfory dżinn, potrafiący zamienić życie spokojnego miasta w koszmar, się trafi.\n" + "Tu nie wystarczą zwykłe czary ani osinowe kołki. Tu trzeba zawodowca.\n" + "WIEDŹMINA.\n" + "Mistrza magii i miecza. Tajemną sztuką wyuczonego, by strzec na świecie moralnej i biologicznej równowagi.");
        Book book4 = new Book("Mapy sensu: Architektura przekonan", "Jordan B. Peterson", "FREEDOM PUBLISHING", "„Mapy sensu” traktują o najgłębszym poziomie ludzkiej psychiki. Są wezwaniem do nowego sposobu istnienia, a jednocześnie do pojednania się z przeszłością. Na każdym człowieku spoczywa odpowiedzialność uratowania swojego ojca z zaświatów. To najstarsza opowieść ludzkości. Bez tego mamy tylko chaos. „Mapy sensu” łączą neuropsychologię ze starożytną mitologią, od Mezopotamii przez Egipt i Judaizm po chrześcijaństwo, jak również taoizm oraz inne systemy wierzeń. Silny wpływ na tę książkę miała myśl Carla Junga oraz jego ucznia, Ericha Neumanna, jak również Freuda, Rogersa, a także innych wielkich XX-wiecznych psychologów-myślicieli.\n" + "„Mapy sensu” są wezwaniem do religijnego przebudzenia dla współczesnego umysłu. Jordan Peterson wyjaśnia w nich, jak udało mu się dojść do właściwej i głębszej alternatywy dla ideologicznego opętania – zarówno prawicowego, jak i lewicowego – oraz szaleństwa, do jakiego takie opętanie prowadzi. Prace nad tą książką odcisnęły swoje piętno na jego zdrowiu i, chwilami, poczytalności. Opowiada ona o okropieństwach Auschwitz i stalinowskich koszmarach, oraz o złu, jakie wiecznie czai się w ludzkiej duszy.", 75, 0);
        Publication publication2 = new Publication("Effects of 12 Weeks of Omega-3 Fatty Acid Supplementation in Long-distance Runners", "Robert Urbanski, Maja Tomczyk, Maciej Chroboczek, Zbigniew Jost", "Medicine and Science in Sports and Exercise");
        Newspaper newspaper1 = new Newspaper("Daily Mail", "New York Daily News", LocalDate.of(1992, Month.FEBRUARY, 20), 30, 0);
        Newspaper newspaper2 = new Newspaper("Old World News", "Universality", LocalDate.of(1977, Month.APRIL, 27));
        User user1 = new User("Banan", "Paulina", LocalDate.of(2020, Month.FEBRUARY, 14), 608843929);
        User user2 = new User("Banan", "Mikolaj", LocalDate.of(2021, Month.FEBRUARY, 28), 987654321);
        User user3 = new User("Banan", "Mikolaj", LocalDate.of(2021, Month.FEBRUARY, 3), 345678912);
        User user4 = new User("Banan", "Mikolaj", LocalDate.of(2021, Month.FEBRUARY, 3), 345678912);
        User user5 = new User("Banan", "Mikolaj", LocalDate.of(2021, Month.FEBRUARY, 22), 345678912);
        book2.rentItem(user1);
        newspaper1.rentItem(user1);
        book2.rentItem(user2);
        newspaper1.rentItem(user2);
        book1.rentItem(user2);
        book2.returnItem(user1);
        book4.rentItem(user1);
        book4.rentItem(user2);
        publication1.rentItem(user5);
        publication2.rentItem(user5);
        Menu.start();
    }
}