package com.webmvc.service;

import com.webmvc.dao.MemberDAO;
import com.webmvc.domain.MemberVO;
import com.webmvc.dto.MemberDTO;
import com.webmvc.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {

    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService(){
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<MemberDTO> getAllMembersInfo() throws Exception {
        log.info("Service : getAllMembersInfo");
        List<MemberVO> voList = memberDAO.listMembers();
        List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    public int addMember(MemberDTO memberDTO) throws Exception {
        log.info("Service : addMember");
        int ack;
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        ack = memberDAO.addMember(memberVO);
        return ack;
    }
}
