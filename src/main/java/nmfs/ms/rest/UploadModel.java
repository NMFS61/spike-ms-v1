///https://www.mkyong.com/spring-boot/spring-boot-file-upload-example-ajax-and-rest/
package nmfs.ms.rest;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadModel {
    private String extraField;

    private MultipartFile[] files;

    
}