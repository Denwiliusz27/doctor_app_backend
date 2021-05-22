package com.daniel.doctorappbackend.status;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/statusy-wizyt") // localhost:8080/statusy-wizyt
public class StatusController {
    public StatusDao statusDao;

    public StatusController(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    @GetMapping("wszystkie")
    public List<Status> getAllStatuses() {
        return statusDao.findAll();
    }

    @GetMapping("id/{statusId}")
    public Optional<Status> getStatusById(@PathVariable Long statusId){
        return statusDao.findStatusByIdStatusu(statusId);
    }

    @GetMapping("nazwa/{name}")
    public Optional<Status> getStatusByName(@PathVariable String name){
        return statusDao.findStatusByNazwa(name);
    }
}
