package test;

public class Test {
    public static String WHITE_LIST_NOTIFY_BODY = "\"Maliyyə Bələdçisi” xidməti artıq sizin üçün aktivdir! " +
            "Daxil olub avtomatik vergi ödənişi imkanından faydalanın." +
            " </p><p>Keçid: <a href=\"https://link.pashabank.az/EAHpxaSwr2\" rel=\"noopener noreferrer\" target=\"blank\">Bank - PASHA Bank</a>";


    String htmlString = "<p>\"Maliyyə Bələdçisi\" xidməti artıq sizin üçün aktivdir! " +
            "Daxil olub avtomatik vergi ödənişi imkanından faydalanın.</p>" +
            "<p>Keçid: <a href=\"https://link.pashabank.az/EAHpxaSwr2\" rel=\"noopener noreferrer\" target=\"_blank\">Bank - PASHA Bank</a></p>";

    public static void main(String[] args) {
        System.out.println(WHITE_LIST_NOTIFY_BODY);
    }
}
