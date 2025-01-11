package pgdp.searchengine.util;

public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Der " + day + "." + month + "." + year + " ist kein valides Datum.");
            this.day = -1;
            this.month = -1;
            this.year = -1;
        }
    }

    public boolean equals(Date other) {
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    //Getter
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


    public boolean isLeapYear(int year){
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0 )){
            return true;
        }
        return false;
    }
    public int daysInYear(int year) {

        return isLeapYear(year) ? 366 : 365;
    }

    public int daysInMonth(int month, int year){
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year)){
            daysInMonth[1] = 29;
        }
        return daysInMonth[month-1];
    }
    public boolean isValidDate(int day, int month, int year){
        if (month < 1 || month > 12) {
            System.out.println("please enter month in range from 1-12");
        }
        return day >= 1 && day <= daysInMonth(month-1, year);
    }
    private boolean isValid() {
        if (day == -1 || month == -1 || year == -1) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
            return false;
        }
        return true;
    }

    public int daysLeftThisYear(){
        if(isValidDate(this.day,this.month,this.year)){
            int totalDays = daysInYear(this.year);
            return totalDays-daysPassedThisYear();
        }
        else
            return -1 ;
    }
    public int daysPassedThisYear(){
        int daysPassed = 0;
        if(isValidDate(this.day,this.month,this.year)) {
            for (int i = 0; i < month - 1; i++) {
                daysPassed += daysInMonth(month,year);
            }
            daysPassed += day;

        }
        return daysPassed;



    }
    public int yearsUntil(Date other){
        if (!isValid() || !other.isValid()) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
            return -1;
        }
        int diffInYears = other.year - this.year;
        if(other.month < this.month || (other.month == this.month || other.day < this.day)){
            diffInYears--;
        }

        return diffInYears;
    }
    public int daysUntil(Date other){
        if (!isValid() || !other.isValid()) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
            return -1;
        }
        if(this.equals(other)){
            return 0;
        }
        int daysOfThis = totalDaysSinceEpoch();
        int daysOfOther = other.totalDaysSinceEpoch();

        return daysOfOther - daysOfThis;
    }
    private int totalDaysSinceEpoch() {
        int days = 0;

        // Addiere die Tage für alle Jahre vor dem aktuellen Jahr
        for (int i = 0; i < this.year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }

        // Addiere die Tage für die Monate im aktuellen Jahr
        for (int i = 1; i < this.month; i++) {
            days += daysInMonth(i, this.year);
        }

        // Addiere die Tage im aktuellen Monat
        days += this.day;

        return days;
    }

    public Date dateMillisecondsAfterNewYear1970(long millis){
        return today();
    }

    public Date today(){;
        return dateMillisecondsAfterNewYear1970(0l);

    }






}