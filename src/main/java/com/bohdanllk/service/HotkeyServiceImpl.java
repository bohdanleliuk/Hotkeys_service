package com.bohdanllk.service;

import com.bohdanllk.dao.HotkeyDAO;
import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.mapper.HotkeyMapper;
import com.bohdanllk.model.Hotkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class HotkeyServiceImpl implements HotkeyService {


    HotkeyMapper hotkeyMapper = HotkeyMapper.INSTANCE;

    private final HotkeyDAO hotkeyDAO;

    public HotkeyServiceImpl(HotkeyDAO hotkeyDAO) {
        this.hotkeyDAO = hotkeyDAO;
    }

    @Override
    @Transactional
    public void add(HotkeyDTO hotkeyDTO) {
        hotkeyDAO.add(hotkeyMapper.dtoToHotkey(hotkeyDTO));
    }

    @Transactional
    public void addList(List<HotkeyDTO> hotkeyDTO) {
        hotkeyDAO.addList(hotkeyMapper.dtoToHotkeyList(hotkeyDTO));
    }

    @Override
    @Transactional
    public HotkeyDTO get(UUID id) {
        return hotkeyMapper.hotkeyToDTO(hotkeyDAO.get(id));
    }

    @Override
    @Transactional
    public List<HotkeyDTO> getAll() {
        return hotkeyMapper.hotkeyListToDTO(hotkeyDAO.getAll());
    }

    @Override
    @Transactional
    public HotkeyDTO update(HotkeyDTO hotkeyDTO) {
        hotkeyDAO.update(hotkeyMapper.dtoToHotkey(hotkeyDTO));
        return hotkeyDTO;
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        hotkeyDAO.delete(id);
    }
}
