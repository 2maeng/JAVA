package ctrl;

import java.util.ArrayList;
import java.util.Random;

import model.BookMarkDAO;
import model.BookMarkVO;
import model.ChampDAO;
import model.ChampVO;
import model.ForbiddenWordDAO;
import model.ForbiddenWordVO;
import model.LineDAO;
import model.LineVO;
import model.MemberDAO;
import model.MemberVO;
import model.ReplyDAO;
import model.ReplyVO;
import view.AdminView;
import view.CommonView;
import view.UserView;

public class Ctrl {
   private MemberDAO mDAO;
   private ChampDAO cDAO;
   private ReplyDAO rDAO;
   private BookMarkDAO bDAO;
   private ForbiddenWordDAO fDAO;
   private LineDAO lDAO;
   private CommonView cView;
   private UserView uView;
   private AdminView aView;
   private MemberVO member; // 현재 로그인한 회원의 정보를 저장할 변수

   public Ctrl() {
      this.mDAO = new MemberDAO();
      this.lDAO = new LineDAO();
      this.cDAO = new ChampDAO();
      this.rDAO = new ReplyDAO();
      this.bDAO = new BookMarkDAO();
      this.fDAO = new ForbiddenWordDAO();
      this.cView = new CommonView();
      this.uView = new UserView();
      this.aView = new AdminView();
      this.member = null;
   }

   public void startApp() {
      final ChampVO cVOAll=new ChampVO("",0);
      cVOAll.setSelect("이름 검색");
      final ArrayList<ChampVO> cdatasAll=cDAO.selectAll(cVOAll);   // 챔프 전체출력
      ArrayList<ChampVO> cdatas;   // selectAll 할 때 챔프들을 담을 배열리스트
      ArrayList<MemberVO> mdatas;   // selectAll 할 때 회원들을 담을 배열리스트
      final ArrayList<LineVO> ldatasAll=lDAO.selectAll(null); // 라인 전체출력
      final ArrayList<ForbiddenWordVO> fdatasAll=fDAO.selectAll(null);

      while (true) { // 프로그램 전체 반복
         cView.startCommnets();
         int select=cView.getCommonMenu();
         if(select==3) {   // 챔피언 목록 출력
            int type=cView.getChampListType();
            if(type==1) {   // 전체목록
               cView.printChampList(cdatasAll,ldatasAll);

            }else if(type==2) {   // 라인입력 1.탑 2.정글 3.미드 4.원딜 5.서폿
               int line=cView.getLineList(ldatasAll);
               ChampVO cVO=new ChampVO(null, line, 0);
               cVO.setSelect("라인 검색");
               cdatas=cDAO.selectAll(cVO);
               cView.printChampList(cdatas,ldatasAll);

            }else if(type==3) {   // 티어입력
               int tier=cView.getTier();
               ChampVO cVO=new ChampVO(null, 0, tier);
               cVO.setSelect("티어 검색");
               cdatas=cDAO.selectAll(cVO);
               cView.printChampList(cdatas,ldatasAll);

            }
         }else if(select==4) {   // 챔피언 검색
            int type=cView.champSearchMenu();
            if(type==1) {   // 이름 검색
               String name=cView.ChampNameSearch();
               ChampVO cVO=new ChampVO(name, 0, 0);
               cVO.setSelect("이름 검색");
               cdatas=cDAO.selectAll(cVO);
               cView.printChampList(cdatas,ldatasAll);

            }else if(type==2) {   // 라인,티어 검색
               ChampVO cVO=cView.ChampSearch(ldatasAll);
               if(cVO==null) {
                  continue;
               }
               cdatas=cDAO.selectAll(cVO);
               cView.printChampList(cdatas,ldatasAll);
            }else if(type==0) {
               cView.printBackMenu();
               continue;
            }

         }else if(select==1) {   // 회원가입 
            MemberVO mVO=cView.signUp();
            if(!mDAO.insert(mVO)) {   // 멤버추가 실패
               cView.signUpFalse();
               continue;
            }
            cView.signUpTrue();

         }else if(select==2) {   // 로그인
            MemberVO mlogin=cView.login();
            mlogin.setSelect("로그인");
            member=mDAO.selectOne(mlogin);
            if(member==null) {   // 멤버 아이디 존재x
               cView.loginFalse();
               continue;
            }
            cView.loginTrue();
            /////////////////////////////////////////////관리자 모드 시작/////////////////////////////////////////////////

            if(member.isAdmin()) {   // 관리자모드 실행
               while(true) {
                  aView.StartUserCommnets();
                  select=aView.AdminMenu();
                  if(select==1) {   // 마이페이지(비밀번호 변경)
                     select = aView.AdminMyPageMenu();
                     if (select == 1) { // 관리자 정보 출력
                        if (cView.checkPW(member)) {
                           cView.printMemberInfo(member);
                        }

                     } else { // 관리자 비밀번호 변경
                        String newPW=cView.changePassword(member);
                        if(newPW==null) {      // 실패
                           cView.changePasswordFalse();
                           continue;
                        }
                        member.setTmpMpw(newPW);
                        member.setSelect("비번변경");
                        if(!mDAO.update(member)) {
                           cView.changePasswordFalse();
                           continue;
                        }
                        cView.changePasswordTrue();
                        member=null;
                        break;
                     }
                  }else if(select==2) {   // 챔피언 관리
                     int type=aView.AdminChampChangeMenu();
                     if(type==1) {   // 챔피언 이름 변경
                        String name=cView.ChampNameSearch();
                        ChampVO cVO=new ChampVO(name, 0);
                        cVO.setSelect("이름 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        int num=cView.getNum(1,cdatas.size());
                        name=cView.getName("변경할 챔피언 ");
                        if (name == null) {
                           continue;
                        }
                        ChampVO cdata=new ChampVO(cdatas.get(num-1).getNum(),name,0,0,0,0);
                        cdata.setSelect("이름 변경");
                        if(!cDAO.update(cdata)) {
                           aView.champChangeInfoFalse();
                           continue;
                        }
                        aView.champChangeInfoTrue();

                     }else if(type==2) {   // 챔피언 추가
                        String name = cView.getName("생성할 챔피언 ");
                        if(name==null) {
                           continue;
                        }
                        int line = cView.getLineList(ldatasAll);
                        int tier = cView.getTier();
                        ChampVO cVO=new ChampVO(name,line,tier);
                        if(!cDAO.insert(cVO)) {
                           aView.champAddFalse();
                        }
                        aView.champAddTrue();

                     }else if(type==3) {   // 티어 변경
                        String name=cView.getName("티어를 변경할 챔피언 ");
                        ChampVO cVO=new ChampVO(name, 0);
                        cVO.setSelect("이름 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        int num=cView.getNum(0,cdatas.size());
                        if(num==0) {
                           aView.returnManage();
                           continue;

                        }
                        int tier=cView.getTier();
                        ChampVO cdata=new ChampVO(cdatas.get(num-1).getNum(),null,0,tier,0,0);
                        cdata.setSelect("티어 변경");
                        if(!cDAO.update(cdata)) {
                           aView.tierChangeFalse();
                           continue;
                        }
                        aView.tierChangeTrue();

                     }else if(type==4) {
                        String name=aView.getCName();
                        ChampVO cVO=new ChampVO(name, 0);
                        cVO.setSelect("이름 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        if(cdatas.isEmpty()) {
                           aView.returnManage();
                           continue;
                        }
                        aView.printReturn();
                        int num=cView.getNum(0,cdatas.size());
                        if(num==0) {
                           aView.returnManage();
                           continue;
                        }
                        cVO.setNum(cdatas.get(num-1).getNum());
                        if(!cDAO.delete(cVO)) {
                           aView.champDeleteFalse();
                        }
                        aView.champDeleteTrue();
                     }else if(type==0) {
                        aView.returnManage();
                        continue;
                     }
                  }else if(select==3) {   // 회원 관리
                     select=aView.AdminMemberManagementMenu();
                     if(select==1) {   // 회원 삭제

                        int type=aView.getSearchType();
                        if(type==1) {   // 경고 카운트 3회이상 출력
                           MemberVO mVO=new MemberVO(null, null, null);
                           mVO.setSelect("경고누적");
                           mdatas=mDAO.selectAll(mVO);
                           aView.printUserList(mdatas);
                           aView.printReturn();
                           int num=cView.getNum(0,mdatas.size());
                           if(num==0) {
                              continue;
                           }
                           MemberVO mdata=new MemberVO(mdatas.get(num-1).getmId(),null, null);
                           if(!mDAO.delete(mdata)) {
                              aView.userDeleteFalse();
                              continue;
                           }
                           aView.userDeleteTrue();

                        }else if(type==2) {   // 이름검색 출력
                           String name=cView.getSearchName("회원");
                           MemberVO mVO=new MemberVO(null, name, null);
                           mVO.setSelect("이름검색");
                           mdatas=mDAO.selectAll(mVO);
                           aView.printUserList(mdatas);
                           aView.printReturn();
                           int num=cView.getNum(0,mdatas.size());
                           if(num==0) {
                              continue;
                           }
                           MemberVO mdata=new MemberVO(mdatas.get(num-1).getmId(),null, null);
                           if(!mDAO.delete(mdata)) {
                              aView.userDeleteFalse();
                              continue;
                           }
                           aView.userDeleteTrue();
                        }
                     }else if(select==2) {   // 관리자 권한 부여
                        int type=aView.adminEmpowermentr();
                        if(type==1) {   //관리자권한 부여
                           String mId=aView.getMId();
                           MemberVO mVO=new MemberVO(mId,null,null);
                           mVO.setSelect("자격부여");
                           if(!mDAO.update(mVO)) {
                              aView.adminPowerFalse();
                              continue;
                           }
                           aView.adminPowerTrue();
                        }else if(type==2) {      //관리자권한 박탈
                           String mId=aView.getMId();
                           MemberVO mVO=new MemberVO(mId,null,null);
                           mVO.setSelect("자격회수");
                           if(!mDAO.update(mVO)) {
                              aView.adminLostPowerFalse();
                              continue;
                           }
                           aView.adminLostPowerTrue();
                        }else if(type==0) {
                           aView.returnManage();
                           continue;
                        }
                     } else if (select == 3) { // 경고카운트 관리
                        MemberVO mVO=new MemberVO(null, null, null);
                        mVO.setSelect("회원목록");
                        mdatas=mDAO.selectAll(mVO);   // 사용자 회원
                        aView.printUserList(mdatas);
                        if(mdatas.isEmpty()) {
                           continue;
                        }
                        int num=cView.getNum(1, mdatas.size());
                        mVO.setmId(mdatas.get(num-1).getmId());
                        int type=aView.warnCountMenu();
                        if(type==1) {
                           mVO.setSelect("경고증가");
                           if(!mDAO.update(mVO)) {
                              aView.managementForbbidenFalse();
                              continue;
                           }
                           aView.managementForbbidenTrue();
                        }else if(type==2) {
                           mVO.setSelect("경고감소");
                           if(!mDAO.update(mVO)) {
                              aView.managementForbbidenFalse();
                              continue;
                           }
                           aView.managementForbbidenTrue();
                        }else if(type==0) {
                           aView.returnManage();
                           continue;
                        }


                     }
                  }else if(select==4) {   // 댓글 관리
                     int type=aView.AdminCommentsMenu();
                     if(type==1) {   // 댓글 삭제 회원 검색
                        String mId=aView.getMId();
                        ReplyVO rVO=new ReplyVO(0,mId,null);
                        rVO.setSelect("회원 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        MemberVO mVO = new MemberVO(mId,null,null);
                        mVO.setSelect("회원검색");
                        mVO = mDAO.selectOne(mVO);
                        cView.printReplyList(rdatas,cdatasAll);
                        uView.printReturn();
                        int num=cView.getNum(0,rdatas.size());
                        if(num==0) {
                           continue;
                        }
                        ReplyVO rdata=new ReplyVO(rdatas.get(num-1).getNum());
                        if(!rDAO.delete(rdata)) {
                           aView.commentsDeleteFalse();
                           continue;
                        }
                        aView.commentsDeleteTrue();
                     }
                     else if(type==2) {   // 미확인 댓글 검색
                        ReplyVO rVO= new ReplyVO(0,null,null);
                        rVO.setSelect("미확인댓글 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        cView.printReplyList(rdatas,cdatasAll);
                        for(int i=0; i<rdatas.size(); i++) {
                           rdatas.get(i).setSelect("댓글 확인");
                           rDAO.update(rdatas.get(i));
                        }
                        uView.printReturn();
                        int num=cView.getNum(0,rdatas.size());
                        if(num==0) {
                           continue;
                        }
                        ReplyVO rdata=new ReplyVO(rdatas.get(num-1).getNum());
                        MemberVO mVO=new MemberVO(rdatas.get(num-1).getmId(), null, null);
                        mVO.setSelect("경고증가");
                        if(!rDAO.delete(rdata)) {
                           aView.commentsDeleteFalse();
                           continue;
                        }
                        aView.commentsDeleteTrue();
                        if(!mDAO.update(mVO)) {   // 삭제성공후 업데이트실패시 삭제만 되는데 트랜잭션을 이용하면 해결가능
                           aView.managementForbbidenFalse();
                           continue;
                        }
                        aView.managementForbbidenTrue();
                     }

                  }else if(select==5) {   // 금지어 관리
                     int type=aView.AdminProhibitedWordsMenu();
                     if(type==1) {   // 금지어 목록 출력
                        ArrayList<ForbiddenWordVO> fdatas=fDAO.selectAll(null);
                        if(fdatas==null) {
                           aView.forbiddenWordPrintFalse();
                           continue;
                        }
                        aView.printForbiddenList(fdatas);
                     }else if(type==2) {   // 금지어 추가
                        String block=aView.getWord();
                        if (block == null) {
                           continue;
                        }
                        ForbiddenWordVO fdata=new ForbiddenWordVO(0, block);
                        if (!fDAO.insert(fdata)) {
                           aView.forbiddenWordAddFalse();                           
                        }
                        aView.forbiddenWordAddTrue();
                     }else if(type==3) {   // 금지어 삭제
                        ArrayList<ForbiddenWordVO> fdatas=fDAO.selectAll(null);
                        aView.printForbiddenList(fdatas);
                        int num=cView.getNum(1,fdatas.size());
                        ForbiddenWordVO fdata=new ForbiddenWordVO(fdatas.get(num-1).getNum(), null);
                        if(!fDAO.delete(fdata)) {
                           aView.forbiddenWordDeleteFalse();
                        }
                        aView.forbiddenWordDeleteTrue();
                     }
                  }else if(select==0) {   // 로그아웃
                     member=null;
                     break;
                  }
               } // 관리자모드 while
               /////////////////////////////////////////////관리자 모드 끝/////////////////////////////////////////////////
               /////////////////////////////////////////////사용자 모드 시작/////////////////////////////////////////////////
            } else {   // 사용자모드 실행
               while(true) {
                  uView.StartUserCommnets();
                  select=uView.userMenu();   //   메뉴 실행
                  if(select==1) {   // 챔피언 목록 출력
                     int type=cView.getChampListType();
                     if(type==1) {   // 전체목록
                        ChampVO cVO=new ChampVO(0,"",0,0,0,0);
                        cVO.setSelect("이름 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        int selectChamp=uView.getChampNum(cdatas.size());
                        cVO.setNum(cdatas.get(selectChamp-1).getNum());
                        ChampVO cdata=cDAO.selectOne(cVO);
                        ReplyVO rVO=new ReplyVO(cdata.getNum(),null,null);
                        rVO.setSelect("챔피언 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        uView.printChamp(cdata,ldatasAll,rdatas);
                        while(true) {
                           int infoMenu=uView.getChampMenu();
                           if(infoMenu==1) {   // 댓글 작성
                              String reply=uView.getReply();
                              ArrayList<ForbiddenWordVO> fdatas=new ArrayList<ForbiddenWordVO>();
                              boolean wordCheck = false;
                              for(int i=0; i<fdatasAll.size(); i++) {
                                 if(reply.contains(fdatasAll.get(i).getBlock())) {
                                    fdatas.add(fdatasAll.get(i));
                                    wordCheck=true;
                                 }
                              }
                              if(wordCheck) {
                                 uView.printReplyWord(fdatas);
                                 break;
                              }
                              ReplyVO rdata=new ReplyVO(cdata.getNum(),member.getmId(),reply);
                              if(!rDAO.insert(rdata)) {
                                 uView.printReplyFalse();
                                 continue;
                              }
                              uView.printReplyTrue();
                           }else if(infoMenu==2) {   // 즐겨찾기
                              ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(),0));
                              BookMarkVO bVO=new BookMarkVO(member.getmId(), cdata.getNum());
                              boolean duplicate=false;
                              for(int i=0; i<bdatas.size(); i++) {
                                 if(bdatas.get(i).getcNum()==cdata.getNum()) {
                                    uView.printBookMarkDuplicate();
                                    duplicate=true;
                                    break;
                                 }
                              }
                              if(duplicate) {
                                 continue;
                              }
                              if(!bDAO.insert(bVO)) {
                                 uView.bookMarkFalse();
                                 continue;
                              }
                              uView.bookMarkTrue();
                           }else if(infoMenu==0) {
                              uView.returnUser();
                              break;
                           }

                        }
                     }else if(type==2) {   // 라인입력 1.탑 2.정글 3.미드 4.원딜 5.서폿
                        int line=cView.getLineList(ldatasAll);
                        ChampVO cVO=new ChampVO(0,null,line, 0, 0, 0);
                        cVO.setSelect("라인 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        int selectChamp=uView.getChampNum(cdatas.size());
                        cVO.setNum(cdatas.get(selectChamp-1).getNum());
                        ChampVO cdata=cDAO.selectOne(cVO);
                        ReplyVO rVO=new ReplyVO(cdata.getNum(),null,null);
                        rVO.setSelect("챔피언 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        uView.printChamp(cdata,ldatasAll,rdatas);
                        while(true) {
                           int infoMenu=uView.getChampMenu();
                           if(infoMenu==1) {   // 댓글 작성
                              String reply=uView.getReply();
                              ArrayList<ForbiddenWordVO> fdatas=new ArrayList<ForbiddenWordVO>();
                              boolean wordCheck = false;
                              for(int i=0; i<fdatasAll.size(); i++) {
                                 if(reply.contains(fdatasAll.get(i).getBlock())) {
                                    fdatas.add(fdatasAll.get(i));
                                    wordCheck=true;
                                 }
                              }
                              if(wordCheck) {
                                 uView.printReplyWord(fdatas);
                                 break;
                              }
                              ReplyVO rdata=new ReplyVO(cdata.getNum(),member.getmId(),reply);
                              if(!rDAO.insert(rdata)) {
                                 uView.printReplyFalse();
                                 continue;
                              }
                              uView.printReplyTrue();
                           }else if(infoMenu==2) {   // 즐겨찾기
                              ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(),0));
                              BookMarkVO bVO=new BookMarkVO(member.getmId(), cdata.getNum());
                              boolean duplicate=false;
                              for(int i=0; i<bdatas.size(); i++) {
                                 if(bdatas.get(i).getcNum()==cdata.getNum()) {
                                    uView.printBookMarkDuplicate();
                                    duplicate=true;
                                    break;
                                 }
                              }
                              if(duplicate) {
                                 continue;
                              }
                              if(!bDAO.insert(bVO)) {
                                 uView.bookMarkFalse();
                                 continue;
                              }
                              uView.bookMarkTrue();
                           }else if(infoMenu==0) {
                              uView.returnUser();
                              break;
                           }
                        }
                     }else if(type==3) {   // 티어입력
                        int tier=cView.getTier();
                        ChampVO cVO=new ChampVO(0,null,0, tier, 0, 0);
                        cVO.setSelect("티어 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        int selectChamp=uView.getChampNum(cdatas.size());
                        cVO.setNum(cdatas.get(selectChamp-1).getNum());
                        ChampVO cdata=cDAO.selectOne(cVO);
                        ReplyVO rVO=new ReplyVO(cdata.getNum(),null,null);
                        rVO.setSelect("챔피언 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        uView.printChamp(cdata,ldatasAll,rdatas);
                        while(true) {
                           int infoMenu=uView.getChampMenu();
                           if(infoMenu==1) {   // 댓글 작성
                              String reply=uView.getReply();
                              ArrayList<ForbiddenWordVO> fdatas=new ArrayList<ForbiddenWordVO>();
                              boolean wordCheck = false;
                              for(int i=0; i<fdatasAll.size(); i++) {
                                 if(reply.contains(fdatasAll.get(i).getBlock())) {
                                    fdatas.add(fdatasAll.get(i));
                                    wordCheck=true;
                                 }
                              }
                              if(wordCheck) {
                                 uView.printReplyWord(fdatas);
                                 break;
                              }
                              ReplyVO rdata=new ReplyVO(cdata.getNum(),member.getmId(),reply);
                              if(!rDAO.insert(rdata)) {
                                 uView.printReplyFalse();
                                 continue;
                              }
                              uView.printReplyTrue();
                           }else if(infoMenu==2) {   // 즐겨찾기
                              ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(),0));
                              BookMarkVO bVO=new BookMarkVO(member.getmId(), cdata.getNum());
                              boolean duplicate=false;
                              for(int i=0; i<bdatas.size(); i++) {
                                 if(bdatas.get(i).getcNum()==cdata.getNum()) {
                                    uView.printBookMarkDuplicate();
                                    duplicate=true;
                                    break;
                                 }
                              }
                              if(duplicate) {
                                 continue;
                              }
                              if(!bDAO.insert(bVO)) {
                                 uView.bookMarkFalse();
                                 continue;
                              }
                              uView.bookMarkTrue();
                           }else if(infoMenu==0) {
                              uView.returnUser();
                              break;
                           }
                        }
                     }
                  }else if(select==2) {   // 챔피언 검색
                     int type=cView.champSearchMenu();
                     if(type==1) {   // 이름 검색
                        String name=cView.ChampNameSearch();
                        ChampVO cVO=new ChampVO(0,name,0,0,0,0);
                        cVO.setSelect("이름 검색");
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        if(cdatas.isEmpty()) {
                           continue;
                        }
                        int selectChamp=uView.getChampNum(cdatas.size());
                        cVO.setNum(cdatas.get(selectChamp-1).getNum());
                        ChampVO cdata=cDAO.selectOne(cVO);
                        ReplyVO rVO=new ReplyVO(cdata.getNum(),null,null);
                        rVO.setSelect("챔피언 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        uView.printChamp(cdata,ldatasAll,rdatas);
                        while(true) {
                           int infoMenu=uView.getChampMenu();
                           if(infoMenu==1) {   // 댓글 작성
                              String reply=uView.getReply();
                              ArrayList<ForbiddenWordVO> fdatas=new ArrayList<ForbiddenWordVO>();
                              boolean wordCheck = false;
                              for(int i=0; i<fdatasAll.size(); i++) {
                                 if(reply.contains(fdatasAll.get(i).getBlock())) {
                                    fdatas.add(fdatasAll.get(i));
                                    wordCheck=true;
                                 }
                              }
                              if(wordCheck) {
                                 uView.printReplyWord(fdatas);
                                 break;
                              }
                              ReplyVO rdata=new ReplyVO(cdata.getNum(),member.getmId(),reply);
                              if(!rDAO.insert(rdata)) {
                                 uView.printReplyFalse();
                                 continue;
                              }
                              uView.printReplyTrue();
                           }else if(infoMenu==2) {   // 즐겨찾기
                              ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(),0));
                              BookMarkVO bVO=new BookMarkVO(member.getmId(), cdata.getNum());
                              boolean duplicate=false;
                              for(int i=0; i<bdatas.size(); i++) {
                                 if(bdatas.get(i).getcNum()==cdata.getNum()) {
                                    uView.printBookMarkDuplicate();
                                    duplicate=true;
                                    break;
                                 }
                              }
                              if(duplicate) {
                                 continue;
                              }
                              if(!bDAO.insert(bVO)) {
                                 uView.bookMarkFalse();
                                 continue;
                              }
                              uView.bookMarkTrue();
                           }else if(infoMenu==0) {
                              uView.returnUser();
                              break;
                           }
                        }
                     }else if(type==2) {   // 라인,티어 검색
                        ChampVO cVO=cView.ChampSearch(ldatasAll);
                        if(cVO==null) {
                           uView.returnUser();
                           continue;
                        }
                        cdatas=cDAO.selectAll(cVO);
                        cView.printChampList(cdatas,ldatasAll);
                        if(cdatas.isEmpty()) {
                           continue;
                        }
                        int selectChamp=uView.getChampNum(cdatas.size());
                        cVO.setNum(cdatas.get(selectChamp-1).getNum());
                        ChampVO cdata=cDAO.selectOne(cVO);
                        ReplyVO rVO=new ReplyVO(cdata.getNum(),null,null);
                        rVO.setSelect("챔피언 검색");
                        ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                        uView.printChamp(cdata,ldatasAll,rdatas);
                        while(true) {

                           int infoMenu=uView.getChampMenu();
                           if(infoMenu==1) {   // 댓글 작성
                              String reply=uView.getReply();
                              ArrayList<ForbiddenWordVO> fdatas=new ArrayList<ForbiddenWordVO>();
                              boolean wordCheck = false;
                              for(int i=0; i<fdatasAll.size(); i++) {
                                 if(reply.contains(fdatasAll.get(i).getBlock())) {
                                    fdatas.add(fdatasAll.get(i));
                                    wordCheck=true;
                                 }
                              }
                              if(wordCheck) {
                                 uView.printReplyWord(fdatas);
                                 break;
                              }
                              ReplyVO rdata=new ReplyVO(cdata.getNum(),member.getmId(),reply);
                              if(!rDAO.insert(rdata)) {
                                 uView.printReplyFalse();
                                 continue;
                              }
                              uView.printReplyTrue();
                           }else if(infoMenu==2) {   // 즐겨찾기
                              ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(),0));
                              BookMarkVO bVO=new BookMarkVO(member.getmId(), cdata.getNum());
                              boolean duplicate=false;
                              for(int i=0; i<bdatas.size(); i++) {
                                 if(bdatas.get(i).getcNum()==cdata.getNum()) {
                                    uView.printBookMarkDuplicate();
                                    duplicate=true;
                                    break;
                                 }
                              }
                              if(duplicate) {
                                 continue;
                              }
                              if(!bDAO.insert(bVO)) {
                                 uView.bookMarkFalse();
                                 continue;
                              }
                              uView.bookMarkTrue();
                           }else if(infoMenu==0) {
                              uView.returnUser();
                              break;
                           }
                        }
                     }else if(type==0) {
                        continue;
                     }
                  }else if(select==3) {   // 게임하기
                     while(true) {

                        int line = cView.getLineList(ldatasAll);
                        ChampVO outcVO = new ChampVO(null, line);
                        outcVO.setSelect("라인 검색");
                        cdatas = cDAO.selectAll(outcVO);
                        cView.printChampList(cdatas, ldatasAll);
                        if(cdatas.isEmpty()) {
                           continue;
                        }
                        uView.printReturn();
                        int num = cView.getNum(0,cdatas.size());
                        if(num==0) {
                           break;
                        }
                        outcVO = cdatas.get(num-1);
                        Random rand = new Random();
                        outcVO.setSelect("게임");
                        int total = rand.nextInt(100);
                        int win = rand.nextInt(total);
                        int result = rand.nextInt(total);
                        outcVO.setPickCnt(outcVO.getPickCnt()+1);
                        if (result <= win)  {
                           outcVO.setWinCnt(outcVO.getWinCnt()+1);
                           result = 1;
                        }

                        if(!cDAO.update(outcVO)) {
                           uView.gameStartFalse();
                           break;
                        }

                        outcVO.setPickCnt(total);
                        outcVO.setWinCnt(win);
                        outcVO.setNum(result);
                        uView.printGameResult(outcVO); // 게임 결과 출력하는 메서드 추가 필요
                        break;
                     }
                  }else if(select==4) {   // 마이페이지
                     while(true) {
                        int type=uView.userMypageMenu();
                        if(type==1) {   // 즐겨찾기관리
                           int bookMarkType= uView.getSelectBookMark();
                           if(bookMarkType==1) {   // 즐겨찾기 챔피언 목록출력
                              ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(),0));
                              uView.printBookMark(bdatas,cdatasAll,ldatasAll);

                           }else if(bookMarkType==2) {   // 즐겨찾기 챔피언 삭제
                              int check=uView.bookMarkDeleteCheck();
                              if(check==1) {
                                 ArrayList<BookMarkVO> bdatas=bDAO.selectAll(new BookMarkVO(member.getmId(), 0));
                                 uView.printBookMark(bdatas,cdatasAll,ldatasAll);
                                 if(bdatas.isEmpty()) {
                                    uView.returnUser();
                                    continue;
                                 }
                                 uView.printReturn();
                                 int num=cView.getNum(0,bdatas.size());
                                 if(num==0) {
                                    uView.returnUser();
                                    continue;
                                 }
                                 BookMarkVO bVO=new BookMarkVO(member.getmId(), bdatas.get(num-1).getcNum());
                                 if(!bDAO.delete(bVO)) {
                                    uView.bookMarkDeleteFalse();
                                    continue;
                                 }
                                 uView.bookMarkDeleteTrue();
                              }else {
                                 uView.returnUser();
                                 continue;
                              }
                           }
                        }else if(type==2) {   // 댓글 관리
                           int replyMenu=uView.userReplyMenu();
                           if(replyMenu==1) {   // 댓글 목록출력
                              ReplyVO rVO=new ReplyVO(0, member.getmId(), null);
                              rVO.setSelect("회원 검색");
                              ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                              uView.printReply(rdatas,cdatasAll);
                           }else if(replyMenu==2) {   // 댓글 수정
                              ReplyVO rVO=new ReplyVO(0, member.getmId(), null);
                              rVO.setSelect("회원 검색");
                              ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                              uView.printReply(rdatas,cdatasAll);
                              if(rdatas.isEmpty()) {
                                 continue;
                              }
                              int replyNum=cView.getNum(0,rdatas.size());
                              uView.printReturn();
                              if(replyNum==0) {
                                 continue;
                              }
                              rVO.setNum(rdatas.get(replyNum-1).getNum());
                              String changeReply=uView.getChangeReply();
                              rVO.setComment(changeReply);
                              rVO.setSelect("댓글 수정");
                              if(!rDAO.update(rVO)) {
                                 uView.printReplyFalse();
                                 continue;
                              }
                              uView.printReplyTrue();
                           }else if(replyMenu==3) {   // 댓글 삭제
                              ReplyVO rVO=new ReplyVO(0, member.getmId(), null);
                              rVO.setSelect("회원 검색");
                              ArrayList<ReplyVO> rdatas=rDAO.selectAll(rVO);
                              uView.printReply(rdatas,cdatasAll);
                              if(rdatas.isEmpty()) {
                                 continue;
                              }
                              int replyNum=cView.getNum(0,rdatas.size());
                              uView.printReturn();
                              if(replyNum==0) {
                                 continue;
                              }
                              rVO.setNum(rdatas.get(replyNum-1).getNum());
                              if(!rDAO.delete(rVO)) {
                                 uView.replyDeleteFalse();
                                 continue;
                              }
                              uView.replyDeleteTrue();
                           }
                        }else if(type==3) {   // 비밀번호 변경
                           String mPw=cView.changePassword(member);
                           if(mPw==null) {
                              cView.changePasswordFalse();
                              continue;
                           }
                           member.setTmpMpw(mPw);
                           member.setSelect("비번변경");
                           if(!mDAO.update(member)) {
                              cView.changePasswordFalse();
                              continue;
                           }
                           cView.changePasswordTrue();
                        }else if(type==4) {   // 회원탈퇴
                           int check=uView.deleteUser(member);
                           if(check==1) {
                              if(!mDAO.delete(member)) {
                                 uView.deleteAccountFalse();
                                 continue;
                              }
                              member=null; 
                              uView.deleteAccountTrue();
                              break;
                           }
                        }else if(type==0) {   // 돌아가기
                           uView.returnUser();
                           break;
                        }
                     }
                  }else if(select==0) {   // 로그아웃
                     uView.printExitUser();
                     break;
                  }
                  if(member==null) {
                     break;
                  }
               } // 사용자모드 while
            } // 로그인 모드
         }else if(select==0) {   // 프로그램 종료
            cView.programExit();
            break;
         }
      } // 프로그램 전체 while

   }
}