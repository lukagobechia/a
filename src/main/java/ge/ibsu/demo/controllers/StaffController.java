package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.RequestData;
import ge.ibsu.demo.dto.SearchCustomer;
import ge.ibsu.demo.dto.SearchStaff;
import ge.ibsu.demo.dto.projections.StaffInfo;
import ge.ibsu.demo.services.StaffService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController()
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping(value = "/searchStaff", method = RequestMethod.POST, produces = {"application/json"})
    public Page<StaffInfo> searchStaff(@RequestBody RequestData<SearchStaff> rd) throws Exception {
        GeneralUtil.checkRequiredProperties(rd.getData(), Arrays.asList("searchText"));
        return staffService.searchStaff(rd.getData(), rd.getPaging());
    }
}
