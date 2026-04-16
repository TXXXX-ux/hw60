package kg.attractor.lesson55lab.controller;

import kg.attractor.lesson55lab.dao.ResumeDao;
import kg.attractor.lesson55lab.dao.VacancyDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobController {

    private final VacancyDao vacancyDao;
    private final ResumeDao resumeDao;

    public JobController(VacancyDao vacancyDao, ResumeDao resumeDao) {
        this.vacancyDao = vacancyDao;
        this.resumeDao = resumeDao;
    }

    @GetMapping("/vacancies")
    public String vacanciesPage(Model model) {
        model.addAttribute("vacancies", vacancyDao.findAll());
        return "vacancies";
    }

    @GetMapping("/resumes")
    public String resumesPage(Model model) {
        model.addAttribute("resumes", resumeDao.findAll());
        return "resumes";
    }
}