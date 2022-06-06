package me.jackpan.osv.controllers;

import lombok.RequiredArgsConstructor;
import me.jackpan.osv.entities.Vulnerability;
import me.jackpan.osv.repositories.VulnerabilityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("vulnerabilities")
@RequiredArgsConstructor
public class VulnerabilitiesController {
    private final VulnerabilityRepository vulnerabilityRepository;

    @GetMapping(value = "")
    public Page<Vulnerability> index(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<String> ecosystem,
            @RequestParam Optional<String> updatedSince) {
        Sort sort = Sort.by("updatedAt").descending();
        PageRequest pageRequest = PageRequest.of(page.orElse(0), size.orElse(10), sort);
        if (ecosystem.isPresent() && updatedSince.isPresent()) {

            return vulnerabilityRepository.findByPackageEcosystemAndUpdatedAtAfter(
                    ecosystem.get(),
                    ZonedDateTime.parse(updatedSince.get()),
                    pageRequest);
        }
        if (ecosystem.isPresent()) {
            return vulnerabilityRepository.findByPackageEcosystem(ecosystem.get(), pageRequest);
        }
        return vulnerabilityRepository.findAll(pageRequest);
    }
}
