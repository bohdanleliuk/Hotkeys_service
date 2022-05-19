package com.bohdanllk.service;

import com.bohdanllk.dao.AppDAO;
import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.AppWithHotkeysDTO;
import com.bohdanllk.mapper.AppMapper;
import com.bohdanllk.model.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AppServiceImpl implements AppService {

    private AppMapper appMapper =AppMapper.INSTANCE;

    private final AppDAO appDAO;

    public AppServiceImpl(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public void add(AppDTO appDTO) {
        App app = appMapper.dtoToApp(appDTO);
        appDAO.add(app);
    }

    @Override
    public AppDTO get(UUID id) {
        AppDTO appDTO = appMapper.appToDTO(appDAO.get(id));
        return appDTO;
    }

    public AppWithHotkeysDTO getWithHotkeys(UUID id) {
        AppWithHotkeysDTO appWithHotkeysDTO = appMapper.appToDTOWithHotkeys(appDAO.get(id));
        return appWithHotkeysDTO;
    }

    @Override
    public List<AppDTO> getAll() {
        return appMapper.appListToDTO(appDAO.getAll());
    }

    @Override
    public AppDTO update(AppDTO appDTO) {
        appDAO.update(appMapper.dtoToApp(appDTO));
        return appDTO;
    }

    @Override
    public void delete(UUID id) {
        appDAO.delete(id);
    }
}

