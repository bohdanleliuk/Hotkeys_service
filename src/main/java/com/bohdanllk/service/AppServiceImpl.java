package com.bohdanllk.service;

import com.bohdanllk.dao.AppDAO;
import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.AppWithHotkeysDTO;
import com.bohdanllk.exception.NotFoundException;
import com.bohdanllk.mapper.AppMapper;
import com.bohdanllk.model.App;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppServiceImpl implements AppService {

    private final AppMapper appMapper;

    private final AppDAO appDAO;

    public AppServiceImpl(AppDAO appDAO, AppMapper appMapper) {
        this.appDAO = appDAO;
        this.appMapper = appMapper;
    }

    @Override
    @Transactional
    public void add(AppDTO appDTO) {
        App app = appMapper.dtoToApp(appDTO);
        appDAO.add(app);
    }

    @Override
    @Transactional(readOnly = true)
    public AppDTO get(UUID id) {
        return Optional.ofNullable(appDAO.get(id))
                .map(appMapper::appToDTO)
                .orElseThrow(() -> new NotFoundException("app with id " + id + " not found"));
    }

    @Transactional(readOnly = true)
    public AppWithHotkeysDTO getWithHotkeys(UUID id) {
        return Optional.ofNullable(appDAO.get(id))
                .map(appMapper::appToDTOWithHotkeys)
                .orElseThrow(() -> new NotFoundException("app with id " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppDTO> getAll() {
        return appMapper.appListToDTO(appDAO.getAll());
    }

    @Override
    @Transactional
    public AppDTO update(AppDTO appDTO) {
        appDAO.update(appMapper.dtoToApp(appDTO));
        return appDTO;
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        appDAO.delete(id);
    }
}

