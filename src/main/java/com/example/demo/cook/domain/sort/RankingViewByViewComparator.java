package com.example.demo.cook.domain.sort;

import java.util.Comparator;

import com.example.demo.cook.domain.RankingView;

public class RankingViewByViewComparator implements Comparator<RankingView> {  
	@Override    
	public int compare(RankingView f1, RankingView f2) {   
	if (f1.getViewCount_sum()> f2.getViewCount_sum()) {     
		return 1;       
	} else if (f1.getViewCount_sum() < f2.getViewCount_sum()) {          
		return -1;      
	}        
	return 0;    
	}
}