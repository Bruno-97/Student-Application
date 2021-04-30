package hr.tvz.pripeljas.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllCourses() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/course")
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(status().isOk());
                //.andDo(print());
    }

    @Test
    void getCourseByStudentJMBAG() throws Exception
    {
        //DAMIR SMRTIĆ
        this.mockMvc.perform(MockMvcRequestBuilders.get("/course").queryParam("jmbag", "0256423323")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("ADMIN")))
                .andExpect(status().isOk()).andDo(print());
    }
}