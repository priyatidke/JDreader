package io.litmusblox.jd.jdReader_mapKeywords_DB;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


import io.litmusblox.jd.dbreader.KeywordRepositoryDBImpl;
import io.litmusblox.jd.domain.JDBean;
import io.litmusblox.jd.storeResultinDB.ResultwriterImplDB;

public class JDKeywordAnalser {

	ResultwriterImplDB resultwriterImplDB= new ResultwriterImplDB();
	KeywordRepositoryDBImpl keywordRepository= new KeywordRepositoryDBImpl();
	
	public static void main(String[] args) {
		JDKeywordAnalser jDKeywordAnalser=  new JDKeywordAnalser();
		List<JDBean> jdBeans= jDKeywordAnalser.analyseAndStoreReults();
		jDKeywordAnalser.storeResult(jdBeans);
	}
	
	public void storeResult(List<JDBean> jdBeans){
		for(JDBean jdBean : jdBeans){
			this.resultwriterImplDB.storeResult(jdBean.getJd(), jdBean.getKeywordListCommaSep());
		}
	}
	
	public List<JDBean> analyseAndStoreReults(){
		List<String> keywords=this.keywordRepository.getKeywords();
		List<String> jds= this.keywordRepository.getjds();
		List<JDBean> jdBeans = new ArrayList<JDBean>();
		
		for(String jd : jds) { 
			List<String> matchedKeywords = new ArrayList<String>();
			for(String keyword: keywords ){
				if(jd.toLowerCase().contains(keyword.toLowerCase())){
					matchedKeywords.add(keyword);
					//System.out.println("matchedKeywords:"+matchedKeywords);
				}
			}
			String matchedLeywordList = StringUtils.join(matchedKeywords, ",");
			JDBean jDBean = new JDBean(jd,matchedLeywordList);
			jdBeans.add(jDBean);
		}
		return jdBeans;
	}

}
