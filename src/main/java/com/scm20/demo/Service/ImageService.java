package com.scm20.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final Cloudinary cloudinary;

    public String uploadImage(MultipartFile picture,String fileName) {

        try {
            byte[] data = new byte[picture.getInputStream().available()];
            picture.getInputStream().read(data);
            cloudinary.uploader().upload(data,  ObjectUtils.asMap("public_id",fileName));
            return this.getUrlFromPublicID(fileName);
        } catch (IOException e) {
            e.printStackTrace();
         return null;
        }
    }

    public String getUrlFromPublicID(String publicID){
        return cloudinary.url()
                .transformation(new Transformation()
                        .crop("fill")
                        .height(500)
                        .width(500)
                )
                .generate(publicID);
    }
}
