package main;

import classes.*;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Directory of files storing Items and Users data.
        File ItemsFile = new File("src/main/java/data/Items.ser");
        File UsersFile = new File("src/main/java/data/Users.ser");
        File SettingsFile = new File("src/main/java/data/Settings.txt");

        ////Loading
        //Items
        if(ItemsFile.exists()){
            try {
                FileInputStream readData = new FileInputStream(ItemsFile);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                Item.setItems((ArrayList<Item>) readStream.readObject());
                readStream.close();
                System.out.println("Items loaded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no file to load Items data from.\nCheck if had you provide correct direction.\nIgnore if it is the first time running the program!\n\n");
        }
        //Users
        if(UsersFile.exists()){
            try {
                FileInputStream readData = new FileInputStream(UsersFile);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                User.setUsers((ArrayList<User>) readStream.readObject());
                readStream.close();
                System.out.println("Users loaded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no file to load Users data from.\nCheck if had you provide correct direction.\nIgnore if it is the first time running the program!");
        }
        //Settings
        if(SettingsFile.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(SettingsFile));
                User.setMonthsForFree(Integer.parseInt(br.readLine()));
                User.setCostPerDayOfDelay(Double.parseDouble(br.readLine()));
                System.out.println("Settings loaded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no file to load Settings from.\nCheck if had you provide correct direction.\nIgnore if it is the first time running the program!");
        }
        /*Book book1 = new Book("Wesele", "Stanislaw Wyspianski", "Greg", "Wesele w serii Kolorowa Klasyka to najpiękniejsze kolorowe wydanie tej powieści na rynku! Książka zawiera wspaniałe, barwne ilustracje, jej atutem jest duża, ułatwiająca szybkie czytanie czcionka. Edycja na szlachetnym papierze, bardzo trwała i estetyczna.\n" + "W podkrakowskiej wsi Bronowice w roku 1900 odbyło się wesele Lucjana Rydla z chłopką Jadwigą Mikołajczykówną. Wydarzenie stało się kanwą do jednego z największych polskich dramatów - Wesela Stanisława Wyspiańskiego.\n" + "Na przełomie wieków Polska wciąż nie istniała na mapie Europy. Na weselu bawią się przedstawiciele różnych grup społecznych i nacji. Każda z nich ma inne problemy i inne marzenia, ale pamięć o niepodległej Polsce wciąż jeszcze jest żywa.\n" + "Wielki dramat mówiący o uczuciach Polaków, ich pragnieniach, marzeniach, bohaterach narodowych, ale i upiorach, które nie dają spokoju. Czy Polacy są jeszcze w stanie walczyć o niepodległość, czy pogrążą się w bezładnym chocholim tańcu?\n" + "Piękne wydanie zostało wzbogacone o reprodukcje dzieł z epoki - Teodora Axentowicza, Jacka Malczewskiego, Leona Wyczółkowskiego i samego Wyspiańskiego - oraz o niezwykle ciekawą „Plotkę o Weselu Wyspiańskiego” Tadeusza Boya-Żeleńskiego.", 20, 0);
        Book book2 = new Book("Maly Ksiaze", "Antoine De Saint-Exupery", "Wydawnictwo SBM", "Specjalna edycja klasyki literatury – Mały Książę Antoine’a de Saint- Exupéry – to książka, którą warto mieć w swojej domowej biblioteczce i do której warto wracać.\n" + "Niezwykłe spotkanie w środku pustyni – pilot, który wraz ze swym samolotem spadł z nieba, mały przybysz z nieznanej planety i tajemniczy lis. Oto opowieść o dorastaniu do wiernej miłości, przyjaźni, lojalności i odpowiedzialności za drugiego człowieka.", 50, 0);
        Publication publication1 = new Publication("Educational rationality and religious education in Polish public schools", "Journal of Beliefs and Values", 0, 0 );
        Book book3 = new Book("Ostatnie życzenie", "Andrzej Sapkowski", "superNOWA", "Później mówiono, że człowiek ów nadszedł od północy, od Bramy Powroźniczej. Nie był stary, ale włosy miał zupełnie białe. Kiedy ściągnął płaszcz, okazało się, że na pasie za plecami ma miecz.\n" + "Białowłosego przywiodło do miasta królewskie orędzie: trzy tysiące orenów nagrody za odczarowanie nękającej mieszkańców Wyzimy strzygi.\n" + "Takie czasy nastały. Dawniej po lasach jeno wilki wyły, teraz namnożyło się rozmaitego paskudztwa – gdzie spojrzysz, tam upiory, bazyliszki, diaboły, żywiołaki, wiły i utopce plugawe. A i niebacznie uwolniony z amfory dżinn, potrafiący zamienić życie spokojnego miasta w koszmar, się trafi.\n" + "Tu nie wystarczą zwykłe czary ani osinowe kołki. Tu trzeba zawodowca.\n" + "WIEDŹMINA.\n" + "Mistrza magii i miecza. Tajemną sztuką wyuczonego, by strzec na świecie moralnej i biologicznej równowagi.", 0, 0);
        Book book4 = new Book("Mapy sensu: Architektura przekonan", "Jordan B. Peterson", "FREEDOM PUBLISHING", "„Mapy sensu” traktują o najgłębszym poziomie ludzkiej psychiki. Są wezwaniem do nowego sposobu istnienia, a jednocześnie do pojednania się z przeszłością. Na każdym człowieku spoczywa odpowiedzialność uratowania swojego ojca z zaświatów. To najstarsza opowieść ludzkości. Bez tego mamy tylko chaos. „Mapy sensu” łączą neuropsychologię ze starożytną mitologią, od Mezopotamii przez Egipt i Judaizm po chrześcijaństwo, jak również taoizm oraz inne systemy wierzeń. Silny wpływ na tę książkę miała myśl Carla Junga oraz jego ucznia, Ericha Neumanna, jak również Freuda, Rogersa, a także innych wielkich XX-wiecznych psychologów-myślicieli.\n" + "„Mapy sensu” są wezwaniem do religijnego przebudzenia dla współczesnego umysłu. Jordan Peterson wyjaśnia w nich, jak udało mu się dojść do właściwej i głębszej alternatywy dla ideologicznego opętania – zarówno prawicowego, jak i lewicowego – oraz szaleństwa, do jakiego takie opętanie prowadzi. Prace nad tą książką odcisnęły swoje piętno na jego zdrowiu i, chwilami, poczytalności. Opowiada ona o okropieństwach Auschwitz i stalinowskich koszmarach, oraz o złu, jakie wiecznie czai się w ludzkiej duszy.", 75, 0);
        Publication publication2 = new Publication("Effects of 12 Weeks of Omega-3 Fatty Acid Supplementation in Long-distance Runners", "Medicine and Science in Sports and Exercise", 0, 0);
        Newspaper newspaper1 = new Newspaper("Daily Mail", "New York Daily News", LocalDate.of(1992, Month.FEBRUARY, 20), 30, 0);
        Newspaper newspaper2 = new Newspaper("Old World News", "Universality", LocalDate.of(1977, Month.APRIL, 27), 0, 0);
        publication1.addAuthor("Grzegorz Gregocki");
        publication1.addAuthor("Mateusz Matecki");
        publication1.addAuthor("Pualina Paulecka");
        publication2.addAuthor("Tadeusz Tadecki");
        publication2.addAuthor("Bartek Bartecki");
        publication2.addAuthor("Wojtek Wojtecki");
        User user = new User("Banan", "Mikolaj", 123456789);*/
        Menu.ManageItems();

        ////Saving
        //Items
        System.out.println("\n\n");
        try {
            FileOutputStream writeData = new FileOutputStream(ItemsFile);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(Item.getItemList());
            writeStream.flush();
            writeStream.close();
            System.out.println("Items saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Users
        try {
            FileOutputStream writeData = new FileOutputStream(UsersFile);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(User.getUserList());
            writeStream.flush();
            writeStream.close();
            System.out.println("Users saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Settings
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(SettingsFile));
            bw.write(User.getMonthsForFree() + "\n");
            bw.write(User.getCostPerDayOfDelay() + "\n");
            bw.flush();
            bw.close();
            System.out.println("Settings saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
        //TODO: change every 'member' to 'user', fix dates of renting and returning, reorganize all classes, make reasonable items and users for testing
    }
}