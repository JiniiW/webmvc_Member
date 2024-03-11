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

    public MemberDTO get(String id) throws Exception {
        log.info("Service : get");
        MemberVO memberVO = memberDAO.getMemberById(id);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

    public int updateMember(MemberDTO memberDTO) throws Exception {
        log.info("Service : updateMember");
        int ack;
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        ack = memberDAO.updateMember(memberVO);
        return ack;
    }

    public int deleteMember(String id) throws Exception {
        log.info("Service : memberDelete");
        int ack;
        ack = memberDAO.deleteMember(id);
        return ack;
    }

    public MemberDTO login (String memberId, String memberPassword) throws Exception {
        log.info("Service : login()");
        MemberVO memberVo = memberDAO.getWithPassword(memberId, memberPassword);
        MemberDTO memberDTO = modelMapper.map(memberVo, MemberDTO.class);
        return memberDTO;
    }
}
