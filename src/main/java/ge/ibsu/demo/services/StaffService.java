package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.Paging;
import ge.ibsu.demo.dto.SearchCustomer;
import ge.ibsu.demo.dto.SearchStaff;
import ge.ibsu.demo.dto.projections.StaffInfo;
import ge.ibsu.demo.repositories.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Page<StaffInfo> searchStaff(SearchStaff searchStaff, Paging paging) {
        String searchText = searchStaff.getSearchText() != null ? "%" + searchStaff.getSearchText() + "%" : "";
        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize(), Sort.by("id").descending());
        return staffRepository.searchStaff(searchText, pageable);
    }

}
