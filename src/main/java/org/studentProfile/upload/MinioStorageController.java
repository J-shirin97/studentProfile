package org.studentProfile.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MinioStorageController {
    @Autowired
    ir.teherany.person.configuration.MinioAdapter minioAdapter;

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Map<String, String> uploadFile(@RequestPart(value = "file", required = false)
                                          MultipartFile files) throws IOException {
        String gKey = minioAdapter.uploadFile(files);
        Map<String, String> result = new HashMap<>();
        // result.put("key", files.getOriginalFilename());
        result.put("Generatedkey", gKey);
        return result;
    }

    @GetMapping(path = "/download")
    public ResponseEntity<ByteArrayResource> uploadFile(
            @RequestParam(value = "file") String file) throws IOException {
        byte[] data = minioAdapter.getFile(file);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition",
                        "attachment; filename=\"" + file + "\"")
                .body(resource);
    }
}