package com.bohdanllk.service;

import com.bohdanllk.dao.OsDAO;
import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.exception.NotFoundException;
import com.bohdanllk.mapper.HotkeyMapper;
import com.bohdanllk.mapper.OsMapper;
import com.bohdanllk.model.Os;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class OsServiceImpl implements OsService {

    private final OsMapper osMapper;

    private final OsDAO osDAO;

    public OsServiceImpl(OsMapper osMapper, OsDAO osDAO) {
        this.osMapper = osMapper;
        this.osDAO = osDAO;
    }

    @Override
    @Transactional
    public void add(OsDTO osDTO) {
        osDAO.add(osMapper.dtoToOs(osDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public OsDTO get(UUID id) {
        return Optional.ofNullable(osDAO.get(id))
                .map(osMapper::osToDTO)
                .orElseThrow(() -> new NotFoundException("os with id " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OsDTO> getAll() {
        return osMapper.osListToDTO(osDAO.getAll());
    }

    @Override
    @Transactional
    public OsDTO update(OsDTO osDTO) {
        osDAO.update(osMapper.dtoToOs(osDTO));
        return osDTO;
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        osDAO.delete(id);
    }
}
