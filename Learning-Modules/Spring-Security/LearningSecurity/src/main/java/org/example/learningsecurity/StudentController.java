package org.example.learningsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<StudentData> st = new ArrayList<>(List.of(
            new StudentData(1,"Alexa", 69),
            new StudentData(2, "Baby", 96)
    ));

    @GetMapping("/getAll")
    public List<StudentData> getst()
    {
        return st;
    }

    @GetMapping("/getToken")
    public CsrfToken getToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addStu")
    public String addStu(@RequestBody StudentData stu)
    {
        st.add(stu);
        return "Success";
    }
}
