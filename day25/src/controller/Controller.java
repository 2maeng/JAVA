package controller;

import java.util.ArrayList;

import model.MovieDAO;
import model.MovieVO;
import model.NewsVO;
import view.View;

public class Controller {

	private MovieDAO mDAO;
	private View view;

	public Controller() {
		this.mDAO = new MovieDAO();
		this.view = new View();
	}

	public void startApp() {

		// ================================================== INSERT START ==================================================

		// 사용자에게 크롤링한다는 사실 보여주고
		//		view.printMenu();
		//
		//		ArrayList<MovieVO> mdatas = Crawling.sample();
		//		for(int i = 0; i < mdatas.size(); i++) {
		//			MovieVO mdata = mdatas.get(i);
		//			boolean flag = mDAO.insert(mdata);
		//			if(!flag) {
		//				view.printFalse();
		//				return;
		//				// 실패하면 -실패
		//			}
		//		}
		//
		//		view.printTrue();
		// 성공하면 -성공
		// ================================================== INSERT END ==================================================


		// ================================================== DELETE START ==================================================
		//		int num = view.getMovieNum();
		//		
		//		MovieVO mVO = new MovieVO(num, null, null);
		//		MovieVO mdata = mDAO.selectOne(mVO);
		//		
		//		if(!mDAO.delete(mVO)) {
		//			view.printDelteFalse();
		//		}
		//		
		//		view.printDeleteTrue(mdata);

		// ================================================== DELTE END ==================================================

		// ================================================== UPDATE START ==================================================
//		int num = view.getMovieNum();
//		String name = view.getMovieName();
//		
//		MovieVO mVO = new MovieVO(num, name, null);
//
//
//		if(!mDAO.update(mVO)) {
//			view.printChangeNameFalse();;
//		}
//
//		view.printChangeNameTrue(mVO);
		// ================================================== UPDATE END ==================================================

		// ================================================== SELECTONE START ==================================================
		//		int num = view.getMovieNum();
		//		
		//		MovieVO mVO = new MovieVO(num, null, null);
		//		MovieVO mdata = mDAO.selectOne(mVO);
		//		
		//		view.printMovie(mdata);
		// ================================================== SELECTONE END ==================================================

		// ================================================== SELECTALL START ==================================================
		ArrayList<MovieVO> mdatas2 = mDAO.selectAll(null);
		if(mdatas2 == null) {
			view.printFalse();
			return;
		}
		view.printMovieList(mdatas2);
		
		String title = view.getSearchMovieName();
		MovieVO mVO = new MovieVO(0, title, null);
		ArrayList<MovieVO> mdatas3 = mDAO.selectAll(mVO);
		view.printMovieList(mdatas3);
		// ================================================== SELECTALL END ==================================================














































































	}
}
