package com.ams.fin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        float   avg_rate_25     =       19;
        float   avg_rate_26     =       16;
        float   avg_rate_27     =       13;

//                avg_rate_25     +=       1.2f;
//                avg_rate_26     +=       1.2f;
//                avg_rate_27     +=       1.2f;
        avg_rate_25     +=       6.0f;
        avg_rate_26     +=       6.0f;
        avg_rate_27     +=       6.0f;

        float   depo_rate_25    =       21.5f;
        float   depo_rate_26    =       17f;
        float   depo_rate_27    =       14f;

        //-------------------------------------------------------------------------------------------------------------
        String ticket           =       "РОЛЬФ БО 001Р-04 с плавающим купоном (RU000A10A6W4)";

        float   kupon           =       0f;
        int     kupon_count     =       17;
        float   nkd             =       19.2f;

        float   cur_price       =       1003.0f;
        float   nominal         =       1000f;

        float commission        =       2 * 3.02f;

        LocalDateTime paym_date  =       LocalDateTime.of(2026,5,25,0,0);
        LocalDateTime start_date =       LocalDateTime.of(2025,1,24,0,0);
        //-------------------------------------------------------------------------------------------------------------

        LocalDateTime tmp_year26 =       LocalDateTime.of(2026,1,1,0,0);
        LocalDateTime tmp_year27 =       LocalDateTime.of(2027,1,1,0,0);

        long          days_betw  =       Duration.between(start_date, paym_date).toDays();
        long       days_in_year  =       0;

        if (paym_date.isAfter(tmp_year27)){
                    days_in_year =       Duration.between(tmp_year27, paym_date).toDays();
        } else if (paym_date.isAfter(tmp_year26)) {
                    days_in_year =       Duration.between(tmp_year26, paym_date).toDays();
        }


        float   income_per_one = (kupon * kupon_count) + (nominal - cur_price);

        float   clear_per_one = income_per_one - income_per_one * 0.13f - nkd - commission;

        float   clear_doh_k_pog =
                    clear_per_one * 100 / cur_price * 365/days_betw;

        float   day_percent = clear_doh_k_pog/days_betw;
        float   year_percent = day_percent * 365;

        System.out.println(income_per_one);
        System.out.println(clear_per_one);
        System.out.println(Duration.between(start_date, paym_date).toDays());
        System.out.println(days_in_year);

        System.out.println("-----------------------------------------------------");
        System.out.println("Basic strategy");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%s %n",ticket);
        System.out.printf(Locale.US, "kupon: %.2f | kupon_count: %d | nkd: %.2f | cur_price: %.2f | nominal: %.2f | commission: %.2f | start_date: ", kupon, kupon_count, nkd, cur_price, nominal, commission);
        System.out.print(start_date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.print(" | paym_date: ");
        System.out.println(paym_date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println();


        System.out.println("clear_doh_k_pog : " + clear_doh_k_pog);
        System.out.println("day_percent : " + day_percent);
        System.out.println("year_percent : " + year_percent);

        System.out.println("-----------------------------------------------------");
        System.out.println("Equals with floating point");
        System.out.println("-----------------------------------------------------");


        if (paym_date.isAfter(tmp_year27)){
            income_per_one =
                    cur_price * avg_rate_25/100 + cur_price * avg_rate_26/100 + cur_price * avg_rate_27/100 * days_in_year/365;
        } else if (paym_date.isAfter(tmp_year26)) {
            income_per_one =
                    cur_price * avg_rate_25/100 + cur_price * avg_rate_26/100 * days_in_year/365;
        }

        clear_per_one =
                income_per_one - income_per_one * 0.13f - nkd + 30;
        // + 5 в среднем удастся купить со скидкой от номинала

        clear_doh_k_pog =
                clear_per_one * 100/cur_price * 365/days_betw;

        day_percent = clear_doh_k_pog/days_betw;
        year_percent = day_percent * 365;

        System.out.println("clear_doh_k_pog : " + clear_doh_k_pog);
        System.out.println("day_percent : " + day_percent);
        System.out.println("year_percent : " + year_percent);


        System.out.println("-----------------------------------------------------");
        System.out.println("Equals with depo");
        System.out.println("-----------------------------------------------------");

        if (paym_date.isAfter(tmp_year27)){
            income_per_one =
                    cur_price * depo_rate_25/100 + cur_price * depo_rate_26/100 + cur_price * depo_rate_27/100 * days_in_year/365;
        } else if (paym_date.isAfter(tmp_year26)) {
            income_per_one =
                    cur_price * depo_rate_25/100 + cur_price * depo_rate_26/100 * days_in_year/365;
        }

        clear_per_one = income_per_one;

        clear_doh_k_pog =
                clear_per_one * 100/cur_price * 365/days_betw;

        day_percent = clear_doh_k_pog/days_betw;
        year_percent = day_percent * 365;

        System.out.println("clear_doh_k_pog : " + clear_doh_k_pog);
        System.out.println("day_percent : " + day_percent);
        System.out.println("year_percent : " + year_percent);



       /* int min_amout = findMinAmount(cur_price, nominal);

        if (min_amout < 0){
            throw new RuntimeException("stop the programm");
        }
        System.out.println("min_amout = " + min_amout);*/
    }

    public static int findMinAmount(float price, float nominal){
        float buf = 0;
        float minus = 0;

        for(int i=1; i<20; i++){
            buf = price * i;
            minus = i * nominal - buf;
            System.out.println(buf + " " + minus);

            if (minus <= 20f){
                return i;
            }else{
                continue;
            }
        }
        return -1;
    }

}
