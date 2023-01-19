import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FileDetail {

    private String id;
    private String name;
    private String format;
    private String path;
    private long bytes;

    public static FileDetail multipartOf(MultipartFile multipartFile){
        final String fileID = MultipartUtil.createFileID();
        final String format = MultipartUtil.getFormat(multipartFile.getContentType());
        return FileDetail.builder()
                .id(fileID)
                .name(multipartFile.getOriginalFilename())
                .format(format)
                .path(MultipartUtil.createPath(fileID, format))
                .bytes(multipartFile.getSize())
                .build();
    }

}
