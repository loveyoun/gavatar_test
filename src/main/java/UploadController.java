import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/upload")
public class UploadController {

    private final FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity <FileDetail> post(@RequestPart("file")MultipartFile multipartFile){
        return ResponseEntity.ok(fileUploadService.save(multipartFile));
    }

}
