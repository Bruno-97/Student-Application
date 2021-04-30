package hr.tvz.pripeljas.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.pripeljas.student.StudentCommand;
import hr.tvz.pripeljas.student.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private StudentService studentService;

    @Test
    public void getAllStudents() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student")
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(status().isOk());
        //.andDo(print());
    }

    @Test
    public void getStudentByJmbag() throws Exception
    {
        //DAMIR SMRTIĆ
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{JMBAG}", "0256423323")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(jsonPath("$.firstName").value("Damir"))
                .andExpect(jsonPath("$.lastName").value("Smrtić"))
                .andExpect(jsonPath("$.jmbag").value("0256423323"))
                .andExpect(jsonPath("$.numberOfECTS").value(105))
                .andExpect(status().isOk()); //.andDo(print());

        //ĐURO MIRIĆ-VUKAŠINOVIĆ
        /*this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{JMBAG}", "0256423324")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(jsonPath("$.firstName").value("Đuro"))
                .andExpect(jsonPath("$.lastName").value("Mirić-Vukašinović"))
                .andExpect(jsonPath("$.jmbag").value("0256423324"))
                .andExpect(jsonPath("$.numberOfECTS").value(173))
                .andExpect(status().isOk());

        //IVO SANADER
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{JMBAG}", "0246069994")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(jsonPath("$.firstName").value("Ivo"))
                .andExpect(jsonPath("$.lastName").value("Sanader"))
                .andExpect(jsonPath("$.jmbag").value("0246069994"))
                .andExpect(jsonPath("$.numberOfECTS").value(112))
                .andExpect(status().isOk());

        //MIRKO MARIĆ
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{JMBAG}", "1209876453")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(jsonPath("$.firstName").value("Mirko"))
                .andExpect(jsonPath("$.lastName").value("Marić"))
                .andExpect(jsonPath("$.jmbag").value("1209876453"))
                .andExpect(jsonPath("$.numberOfECTS").value(168))
                .andExpect(status().isOk());

        //EDI MARFI
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{JMBAG}", "3880071909")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(jsonPath("$.firstName").value("Edi"))
                .andExpect(jsonPath("$.lastName").value("Marfi"))
                .andExpect(jsonPath("$.jmbag").value("3880071909"))
                .andExpect(jsonPath("$.numberOfECTS").value(200))
                .andExpect(status().isOk());*/

        /*this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{JMBAG}", "0256423323")
                .accept(MediaType.APPLICATION_JSON)
                .with(user("admin").password("test").roles("USER", "ADMIN")))
                .andExpect(content().json("[{'firstName':'Damir','lastName':'Smrtić','jmbag':'0256423323','numberOfECTS':105}," +
                        "{'firstName':'Đuro','lastName':'Mirić-Vukašinović','jmbag':'0256423324','numberOfECTS':173}," +
                        "{'firstName':'Ivo','lastName':'Sanader','jmbag':'0246069994','numberOfECTS':112}," +
                        "{'firstName':'Mirko','lastName':'Marić','jmbag':'1209876453','numberOfECTS':168}," +
                        "{'firstName':'Edi','lastName':'Marfi','jmbag':'3880071909','numberOfECTS':200},]"))
                .andExpect(status().isOk());*/
    }

    @Test
    public void save() throws Exception
    {
        /*mockMvc.perform(post("/student")
                .with(user("admin").password("test").roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(student)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(student))
                .andDo(print());*/

        StudentCommand studentCommand = new StudentCommand();

        LocalDate birthDate = LocalDate.of(1964, Month.OCTOBER, 31);

        studentCommand.setJmbag("1133225544");
        studentCommand.setFirstName("Đoni");
        studentCommand.setLastName("Gitara");
        studentCommand.setNumberOfECTS(139);
        studentCommand.setDateOfBirth(birthDate);

        this.mockMvc.perform(post("/student").with(user("admin").password("test").roles("ADMIN"))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentCommand))
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.jmbag").value("1133225544"))
                        .andExpect(jsonPath("$.firstName").value("Đoni"))
                        .andExpect(jsonPath("$.lastName").value("Gitara"))
                        .andExpect(jsonPath("$.numberOfECTS").value(139))
                        .andDo(print());
    }

    @Test
    public void getNotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/1111423323")
                .with(user("admin").password("test").roles("ADMIN")))
                .andDo(print()).andExpect(status()
                .isNotFound());
    }

    /*@Test
    public void test_get_by_jmbag_fail_404_not_found() throws Exception
    {
        when(studentService.findStudentByJmbag("1111423323")).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/{jmbag}", "1111423323")
                .with(user("admin").password("test").roles("ADMIN")))
                .andExpect(status().isNotFound());
        verify(studentService, times(1)).findStudentByJmbag("1111423323");
        verifyNoMoreInteractions(studentService);
    }*/
}