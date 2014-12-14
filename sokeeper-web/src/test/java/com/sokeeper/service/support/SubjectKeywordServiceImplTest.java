/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package com.sokeeper.service.support;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.sokeeper.service.SubjectKeywordService;

/**
 * @author XiXi Dai (daizhixia@gmail.com)
 */
public class SubjectKeywordServiceImplTest extends
        // org.springframework.test.AbstractTransactionalDataSourceSpringContextTests {
		//org.springframework.test.AbstractDependencyInjectionSpringContextTests {
        org.springframework.test.web.AbstractModelAndViewTests {
	
	protected String[] getConfigLocations() {		
		return new String[] { "spring-web.xml" };
	}

	@Autowired
	private SubjectKeywordService subjectKeywordService;

	public void test_getReader() throws Throwable {
		System.setProperty(ResourceHelper.DATA_FILE_BLACK_WORDS,"https://dl.dropboxusercontent.com/s/2cv2ly2nfo4wfvu/blackwords.dat");
		System.setProperty(ResourceHelper.DATA_FILE_SUBJECT,"https://dl.dropboxusercontent.com/s/bcq3lsqnip9sgov/subject.dat");
		System.setProperty(ResourceHelper.DATA_FILE_KEYWORD_SUBJECT,"https://dl.dropboxusercontent.com/s/nx5xza1xz7o916e/keysubject.dat");
		System.setProperty(ResourceHelper.IMAGE_HTTP_SERVER,"http://112.124.13.247" + ResourceHelper.IMAGE_HTTP_SERVER);
		BufferedReader reader = ResourceHelper.getInstance().getReader(ResourceHelper.DATA_FILE_BLACK_WORDS);
		String strLine = null;
		do {
			strLine = reader.readLine();
			System.out.println(strLine);
		} while (strLine != null);
	}
}
