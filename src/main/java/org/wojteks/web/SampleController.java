/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wojteks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wojteks.domain.City;
import org.wojteks.service.CityService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SampleController {

	@Autowired
	private CityService cityService;

	@Autowired
	@Resource(name = "showExampleCity2")
	private City city;

	@RequestMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public ModelAndView helloWorld(HttpServletRequest request,
							 HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
// return this.cityService.getCity("Bath", "UK").getName();
		modelAndView.setViewName("sample");
		modelAndView.addObject("message", cityService.getCity("Bath", "UK").getName());
		modelAndView.addObject("city", city.getName());
		return modelAndView;

	}

}
