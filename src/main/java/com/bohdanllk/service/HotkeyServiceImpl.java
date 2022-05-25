package com.bohdanllk.service;

import com.bohdanllk.dao.HotkeyDAO;
import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.exception.NotFoundException;
import com.bohdanllk.mapper.HotkeyMapper;
import com.bohdanllk.model.Hotkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotkeyServiceImpl implements HotkeyService {

    private final HotkeyMapper hotkeyMapper;

    private final HotkeyDAO hotkeyDAO;

    public HotkeyServiceImpl(HotkeyDAO hotkeyDAO, HotkeyMapper hotkeyMapper) {
        this.hotkeyDAO = hotkeyDAO;
        this.hotkeyMapper = hotkeyMapper;
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
    @Transactional(readOnly = true)
    public HotkeyDTO get(UUID id) {
        return Optional.ofNullable(hotkeyDAO.get(id))
                .map(hotkeyMapper::hotkeyToDTO)
                .orElseThrow(() -> new NotFoundException("hotkey with id " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
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
