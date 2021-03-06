package zx.soft.words.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import zx.soft.words.model.Categories;
import zx.soft.words.service.CategoriesService;

@Controller
@RequestMapping("/category")
public class CategoriesController {

	@Inject
	private CategoriesService categoriesServer;

	/**
	 * 添加类别
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object addCategory(
			@RequestBody List<Categories> categories) {
		return categoriesServer.addCategory(categories);
	}

	/**
	 * 删除类别
	 */
	@RequestMapping(value = "/{cate_id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object delCategory(@PathVariable String cate_id) {
		return categoriesServer.delCategory(cate_id);
	}

	/**
	 * 根据城市名称查询所有类别
	 * 
	 * @throws UnsupportedEncodingException
	 *             解决传参中文乱码问题 new String(type.getBytes("ISO-8859-1"), "UTF-8")
	 */
	@RequestMapping(value = "/{type}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Categories> getCategories(
			@PathVariable String type) throws UnsupportedEncodingException {
		return categoriesServer.getCategories(type);
//				new String(type
//				.getBytes("ISO-8859-1"), "UTF-8"));
	}

	/**
	 * 修改类别
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object updateCategory(
			@RequestBody List<Categories> categories) {
		return categoriesServer.updateCategory(categories);
	}
}
