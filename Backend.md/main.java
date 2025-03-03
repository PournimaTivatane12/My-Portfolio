package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }
}

@Controller
class PortfolioController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Pournima Tivatane");
        model.addAttribute("title", "Cloud & DevOps Engineer");
        model.addAttribute("projects", List.of(
                new Project("EKS Cluster Deployment", "Deploying applications with AWS EKS", "https://github.com/PournimaTivatane12/EKS-Cluster-App-Deployment-w-Ingress"),
                new Project("Terraform Module Automation", "Automating Terraform configurations", "https://github.com/PournimaTivatane12/Terraform-Module-Automation"),
                new Project("PSF PII Masking Forms", "Securely handling PII data in forms", "https://github.com/PournimaTivatane12/PII-Data-Masking-Forms")
        ));
        return "index";
    }
}

class Project {
    private String name;
    private String description;
    private String link;

    public Project(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
}
