package problem_solving.HackerRank;

public class DayOfProgrammer {
    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(2200));
    }

    static String dayOfProgrammer(int year) {
        if (year==1918) return "26.09.1918";
        if(isLeapYear(year)){
            return "12.09."+String.valueOf(year);
        }
        return "13.09."+String.valueOf(year);
    }
    static boolean isLeapYear(int year){
        if( year % 4 != 0 ) return false;
        if( year > 1918 && year % 100 == 0 && year % 400 != 0 ) return false;
        return true;
    }
}
