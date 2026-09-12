package practise;

public class date {

    private int day;
    private int month;
    private int year;

    public void setDate(int dd, int mm, int yy) {

        year = yy;
        if (month > 12) {
            month = 1;
            year++;
        }

        // Month validation
        if (mm < 1 || mm > 12) {
            month = 1;
        } else {
            month = mm;
        }

        // Assign day first
        day = dd;

        // 31-day months
        if (month == 1 || month == 3 || month == 5 ||
            month == 7 || month == 8 || month == 10 || month == 12) {

            if (day < 1 || day > 31) {
                day = 1;
            }
        }

        // 30-day months
        else if (month == 4 || month == 6 ||
                 month == 9 || month == 11) {

            if (day < 1 || day > 30) {
                day = 1;
            }
        }

        // February
        else if (month == 2) {

            // Leap year
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {

                if (day < 1 || day > 29) {
                    day = 1;
                }

            } else {

                if (day < 1 || day > 28) {
                    day = 1;
                }
            }
        }
    }

    

    // Getters

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
   
    public int getDaysInMonth() {

        if (month == 2) {

            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return 29;
            }

            return 28;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        return 31;
    }
public void addDays(int days) {

    for (int i = 0; i < days; i++) {

        day++;

        int daysInMonth = getDaysInMonth();

        if (day > daysInMonth) {
            day = 1;
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }
}
}
