package com.example.apnaHotel.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.example.apnaHotel.exception.OurException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    private Storage storage;

    @PostConstruct
    public void initFirebase() throws Exception {
        InputStream serviceAccount = new FileInputStream("E:\\apnaHotel\\apnaHotel\\src\\main\\resources\\apnahotelstorage-firebase-adminsdk-hkdhr-e51fa74007.json"); // Path to your JSON
        storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setProjectId("apnahotelstorage")  // Firebase project ID from your JSON file
                .build()
                .getService();
    }

    public String saveImageToFirebase(MultipartFile photo) {
        try {
            String filename = UUID.randomUUID().toString() + "-" + photo.getOriginalFilename();
            InputStream inputStream = photo.getInputStream();

            // Firebase Storage bucket name from your JSON file
            BlobId blobId = BlobId.of("apnahotelstorage.appspot.com", filename);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                    .setContentType("image/jpeg")
                    .build();

            // Uploading the file to Firebase Storage
            storage.create(blobInfo, inputStream);

            // Returning the public URL of the uploaded image
            return "https://firebasestorage.googleapis.com/v0/b/apnahotelstorage.appspot.com/o/" + filename + "?alt=media";

        } catch (Exception e) {
            e.printStackTrace();
            throw new OurException("Unable to upload image to Firebase Storage: " + e.getMessage());
        }
    }
}
