package com.daniel.doctorappbackend.visitStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/statusy-wizyt") // localhost:8080/statusy-wizyt
public class VisitStatusController {
    public VisitStatusDao statusDao;

    public VisitStatusController(VisitStatusDao statusDao) {
        this.statusDao = statusDao;
    }

    @GetMapping("/wszystkie")
    public List<VisitStatus> getAllVisitStatuses() {
        return statusDao.findAll();
    }

    @GetMapping("/id/{statusId}")
    public Optional<VisitStatus> getVisitStatusById(@PathVariable Long statusId){
        return statusDao.findStatusByStatusId(statusId);
    }

    @GetMapping("/nazwa/{statusName}")
    public Optional<VisitStatus> getVisitStatusByName(@PathVariable String statusName){
        return statusDao.findStatusByStatusName(statusName);
    }
}
