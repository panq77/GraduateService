package pq.empm.util;

import pq.empm.model.User;
import pq.empm.vo.LogData;

public class CheckNull {
    public static   Object check(Object str){
        if (str==null ) {
            str=-1;
        }
        return  str;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUid(1);
        user.setUname("222");
        System.out.println(CheckNull.check(user.getEducation()).toString());
        System.out.println((Integer) CheckNull.check(user.getAge()));
        new LogData(CheckNull.check(user.getEducation()).toString(),(Integer) CheckNull.check(user.getAge()));
        System.out.println();

    }
}
