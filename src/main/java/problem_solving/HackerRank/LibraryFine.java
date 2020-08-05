package problem_solving.HackerRank;

public class LibraryFine {
    public static void main(String[] args) {


        System.out.println(libraryFine(5, 5, 2014,23, 2, 2014));
    }

    static class DateWrapper{
        public final int day;
        public final int month;
        public final int year;

        DateWrapper(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        DateWrapper returnedDate = new DateWrapper(d1,m1,y1);
        DateWrapper dueDate = new DateWrapper(d2,m2,y2);
        int yearDist  = returnedDate.year  - dueDate.year;
        int monthDist = returnedDate.month - dueDate.month;
        int dayDist   = returnedDate.day   - dueDate.day;
        return yearDist > 0 ? 10_000 : yearDist < 0 ? 0 : monthDist > 0 ? monthDist * 500 :  monthDist < 0 ? 0 : dayDist > 0 ? dayDist * 15 : 0 ;
    }
}
