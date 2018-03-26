package nmfs.ms.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse {

    String status; // OK , FAIL , PARTIAL
    List<ErrorList> errorList;
    List<Object> additionalInfo;

}
