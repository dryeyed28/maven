package com.kitri.shop.seller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {
	@Resource(name = "sellerService")
	private Service service;

	@Resource(name = "adminService")
	private com.kitri.shop.admin.Service c_service;

	public static String basePath = "C:\\Users\\pc\\Desktop\\my\\workspace\\.metadata"
			+ "\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shopimg\\";

	public void setService(Service service) {
		this.service = service;
	}

	public void setC_service(com.kitri.shop.admin.Service c_service) {
		this.c_service = c_service;
	}

	@RequestMapping(value = "/seller/myList.do")
	public ModelAndView myList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("member/prodPage");
		HttpSession session = req.getSession(false);
		String seller_id = (String) session.getAttribute("id");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductBySellerId(seller_id);
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/seller/form.do")
	public String form() {
		return "seller/form";
	}

	public void saveImg(int num, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		if (fileName != null && !fileName.equals("")) {
			File dir = new File(basePath + num);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File f = new File(basePath + num + "\\" + fileName);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/seller/add.do")
	public String add(Product p) {
		int num = service.getNum();
		p.setNum(num);
		service.addProduct(p);
		saveImg(num, p.getFile1());
		saveImg(num, p.getFile2());
		saveImg(num, p.getFile3());
		return "member/main";
	}

	@RequestMapping(value = "/seller/itemView.do")
	public ModelAndView itemView(@RequestParam(value = "num") int num, 
			@RequestParam(value = "type") int type) {
		ModelAndView mav = new ModelAndView();
		if (type == 1) {
			mav.setViewName("seller/itemView");
		} else if (type == 2) {
			mav.setViewName("order/itemView");
		}
		Product p = service.getProductByNum(num);
		File shopDir = new File(basePath);
		String[] dirs = shopDir.list();
		for (int i = 0; i < dirs.length; i++) {
			if (dirs[i].equals(p.getNum() + "")) {
				File dir = new File(basePath + p.getNum() + "\\");
				String[] files = dir.list();
				for (int j = 0; j < files.length; j++) {
					mav.addObject("file" + j, "/shopimg/" + p.getNum() + "/" + files[j]);
				}
			}
		}
		mav.addObject("p", p);
		return mav;
	}

	@RequestMapping(value = "/seller/edit.do")
	public String edit(Product p) {
		service.editProduct(p);
		return "member/main";
	}

	@RequestMapping(value = "/seller/del.do")
	public String del(@RequestParam(value = "num") int num) {
		service.delProduct(num);
		File shopDir = new File(basePath);
		String[] dirs = shopDir.list();
		for (int i = 0; i < dirs.length; i++) {
			if (dirs[i].equals(num + "")) {
				File dir = new File(basePath + num + "\\");
				String[] files = dir.list();
				for (int j = 0; j < files.length; j++) {
					File f = new File(basePath + num + "\\" + files[j]);
					f.delete();
				}
				dir.delete();
			}
		}
		return "member/main";
	}

	@RequestMapping(value = "/seller/allList.do")
	public ModelAndView allList() {
		ModelAndView mav = new ModelAndView("seller/allList");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductAll();
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/seller/cateList.do")
	public ModelAndView cateList(@RequestParam(value = "c1", required = true) int c1,
			@RequestParam(value = "c2", required = false, defaultValue = "0") int c2,
			@RequestParam(value = "c3", required = false, defaultValue = "0") int c3) {
		ModelAndView mav = new ModelAndView("seller/allList");
		ArrayList<Product> list = null;
		if (c2 == 0) {
			list = (ArrayList<Product>) service.getProductByC1(c1);
		} else if (c3 == 0) {
			list = (ArrayList<Product>) service.getProductByC2(c2);
		} else {
			list = (ArrayList<Product>) service.getProductByC3(c3);
		}
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/seller/nameList.do")
	public ModelAndView nameList(@RequestParam(value = "name") String name) {
		ModelAndView mav = new ModelAndView("seller/allList");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductByName(name);
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/seller/priceList.do")
	public ModelAndView priceList(@RequestParam(value = "min") int min, 
			@RequestParam(value = "max") int max) {
		ModelAndView mav = new ModelAndView("seller/allList");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductByPrice(min, max);
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/seller/sellerList.do")
	public ModelAndView sellerList(@RequestParam(value = "seller_id") String seller_id) {
		ModelAndView mav = new ModelAndView("seller/allList");
		ArrayList<Product> list = (ArrayList<Product>) service.getProductBySellerId(seller_id);
		mav.addObject("list", list);
		return mav;
	}
}
