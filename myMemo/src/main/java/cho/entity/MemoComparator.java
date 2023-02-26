package cho.entity;

import java.util.Comparator;

public class MemoComparator implements Comparator<Memo> {
	
	public int compare(Memo x , Memo y) {
		return(y.getMemoId() - x.getMemoId());
	}

}
