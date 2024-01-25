package lab7.chapter11;
// 11.13

import java.util.ArrayList;

public class RemoveDuplicates {
    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> record = new ArrayList<>();

        for(int originElement: list){
            boolean duplicate = false;

            for(int recordElement: record){
                if (originElement == recordElement) {
                    duplicate = true;
                    break;
                }
            }

            if(!duplicate){
                record.add(originElement);
            }
        }

        list.clear();
        list.addAll(record);
    }
}
