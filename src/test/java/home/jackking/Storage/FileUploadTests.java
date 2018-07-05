package home.jackking.Storage;

import home.jackking.storage.StorageFileNotFoundException;
import home.jackking.storage.service.StorageService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by e604847 on 7/3/2018.
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles(profiles="ss")
public class FileUploadTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StorageService storageService;

    @Test
    public void shouldSaveUploadFile() throws  Exception{
        MockMultipartFile file = new MockMultipartFile("file","test.txt","text/plain","Spring Framework".getBytes());
        this.mockMvc.perform(MockMvcRequestBuilders.multipart("/files").file(file))
                .andExpect(status().isFound())
        .andExpect(MockMvcResultMatchers.header().string("Location","/files"));
    }
    @Test
    public void shouldListAllFiles() throws Exception{
        given(storageService.loadAll())
                .willReturn(Stream.of(Paths.get("Notes.txt")));
        mockMvc.perform(get("/files")).andExpect(status().isOk())
                .andExpect(model().attribute("files", Matchers.contains("http://localhost/files/Notes.txt")));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void should404WhenMissingFile() throws Exception {
        given(this.storageService.loadAsResource("test.txt"))
                .willThrow(StorageFileNotFoundException.class);

        this.mockMvc.perform(get("/files/test.txt")).andExpect(status().isNotFound());
    }
}
