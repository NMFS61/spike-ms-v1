package nmfs.ms.util;

import nmfs.ms.model.response.ErrorList;

import java.util.List;

public class ServiceUtils {

    public static List<ErrorList> combineErrorList(List<ErrorList> list1,List<ErrorList> list2) {

        list2.stream().forEach(errorList ->
        {
            list1.add(errorList);
        });

        return list1;
    }
}
