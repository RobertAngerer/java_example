package com.example.demo.company;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.mapper.CompanyDtoMapper;
import com.example.demo.company.service.CompanyService;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    private CompanyService companyService;

    private CompanyDtoMapper companyDtoMapper;

    public CompanyController(CompanyService companyService, CompanyDtoMapper companyDtoMapper) {
        this.companyService = companyService;
        this.companyDtoMapper = companyDtoMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto create(@RequestBody CompanyDto companyDto) {
        return this.companyDtoMapper.modelToDto(this.companyService.save(this.companyDtoMapper.dtoToModel(companyDto)));
    }

    @GetMapping("{id}")
    public CompanyDto findById(@PathVariable("id") UUID id) {
        return this.companyDtoMapper.modelToDto(this.companyService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
        this.companyService.deleteById(id);
        return new ResponseEntity<>("nope", HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public CompanyDto putById(@PathVariable("id") UUID id, @RequestBody @Valid CompanyDto companyDto) {
        if (!this.companyService.existsById(id)) {
            throw new NotFoundException();
        }
        return this.companyDtoMapper.modelToDto(this.companyService.save(this.companyDtoMapper.dtoToModel(companyDto, id)));
    }

    @GetMapping
    public List<CompanyDto> getAll() {
        return this.companyService.findAll().stream().map(company -> this.companyDtoMapper.modelToDto(company)).collect(Collectors.toList());
    }
}
