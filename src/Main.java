
public class Main {
    public static void main(String[] args) {
        PopulationRegister populationRegister = new PopulationRegister();

        populationRegister.tree();
        populationRegister.add("Anna", new  String[]{"Nowak", "Rak"}, "324355873");
        populationRegister.add( "Kamil", new  String[]{"Bąk"}, "924355823");
        populationRegister.add( "Anna", new  String[]{"Nowak", "Kowalska"}, "724355843");
        populationRegister.add( "Emil", new  String[]{"Papuszka"}, "875385933");
        populationRegister.add( "Anna", new  String[]{"Kowalska"}, "524355933");
        populationRegister.add( "Anna", new  String[]{"Kowalska"}, "595355933");
        populationRegister.add( "Kamil", new  String[]{"Bąk"}, "824355823");
        populationRegister.add( "Emil", new  String[]{"Kanty"}, "415385933");
        populationRegister.add( "Kamil", new  String[]{"Stec"}, "824925823");
        populationRegister.add( "Aleksandra", new  String[]{"Nowak", "Kowalska"}, "924325843");
        populationRegister.add( "Aleksandra", new  String[]{"Nowak", "Kowalska"}, "864325843");
        populationRegister.add( "Kaja", new  String[]{"Kanty", "Kowalska", "Olech"}, "424385933");
        populationRegister.add( "Emil", new  String[]{"Kanty"}, "935385933");
        populationRegister.add( "Kaja", new  String[]{"Kot"}, "735385933");
        populationRegister.add( "Anna", new  String[]{"Kot"}, "945385933");
        populationRegister.add( "Emil", new  String[]{"Kot"}, "835385933");
        populationRegister.add("Mariusz", new String[]{"Mastalerz"}, "8863724938");

        System.out.println("\nWyświtlenie drzewa");
        populationRegister.tree();

        System.out.println("\nCzy istnieje \"Emil Kot 835385933\"?"
                + populationRegister.isExist("Emil", new  String[]{"Kot"}, "835385933"));

        System.out.println("\nWyświtlenie gałezi dla \"Anna\":");
        populationRegister.displayBranchForName("Anna");

        System.out.println("\nWyświtlenie gałezi dla \"Kaja Kanty Kowalska Olech\":");
        populationRegister.displayBranchForSurname("Kaja", new  String[]{"Kanty", "Kowalska", "Olech"});
        populationRegister.remove("Aleksandra", new  String[]{"Nowak", "Kowalska"}, "864325843");
        populationRegister.remove("Anna", new  String[]{"Kowalska"}, "524355933");
        populationRegister.remove("Emil", new  String[]{"Kot"}, "835385933");
        populationRegister.remove("Mariusz", new String[]{"Mastalerz"}, "8863724938");
        populationRegister.remove("Aleksandra", new  String[]{"Nowak", "Kowalska"}, "924325843");
        populationRegister.remove("Anna", new  String[]{"Kot"}, "945385933");
        populationRegister.remove( "Kaja", new  String[]{"Kot"}, "735385933");
        populationRegister.remove( "Kaja", new  String[]{"Kanty", "Kowalska", "Olech"}, "424385933");

        System.out.println("\nCzy istnieje \"Emil Kot 835385933\"?"
                + populationRegister.isExist("Emil", new  String[]{"Kot"}, "835385933"));

        System.out.println("\nWyświtlenie drzewa");
        populationRegister.tree();
    }
}