package home.jackking.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by e604847 on 6/28/2018.
 */
@Configuration
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location="upload-dir";
    private String imageLocation="upload-dir/images";


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
