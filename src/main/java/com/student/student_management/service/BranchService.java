package com.student.student_management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.student_management.entity.Branch;
import com.student.student_management.repository.BranchRepository;

@Service
public class BranchService {

    @Autowired
    private BranchRepository repository;

    public List<Branch> getAllBranches() {
        return repository.findAll();
    }

    public Branch saveBranch(Branch branch) {
        return repository.save(branch);
    }
}
