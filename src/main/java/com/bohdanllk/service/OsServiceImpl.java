package com.bohdanllk.service;

import com.bohdanllk.dao.OsDAO;
import com.bohdanllk.dto.OsDTO;
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
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class OsServiceImpl implements OsService {

    OsMapper osMapper = OsMapper.INSTANCE;

    @Autowired
    private OsDAO osDAO;

    @Override
    public void add(OsDTO osDTO) {
        osDAO.add(osMapper.dtoToOs(osDTO));
    }

    @Override
    public OsDTO get(UUID id) {
        return osMapper.osToDTO(osDAO.get(id));
    }

    @Override
    public List<OsDTO> getAll() {
        return osMapper.osListToDTO(osDAO.getAll());
    }

    @Override
    public OsDTO update(OsDTO osDTO) {
        osDAO.update(osMapper.dtoToOs(osDTO));
        return osDTO;
    }

    @Override
    public void delete(UUID id) {
        osDAO.delete(id);
    }
}
