package com.student.student_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.student.student_management.entity.Branch;
import com.student.student_management.service.BranchService;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService service;

    @GetMapping
    public List<Branch> getAllBranches() {
        return service.getAllBranches();
    }

    @PostMapping
    public Branch addBranch(@RequestBody Branch branch) {
        return service.saveBranch(branch);
    }
}
