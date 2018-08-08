package proxy;



import lombok.Data;
import service.MemberServiceImpl;


@Data
public class Pagination implements Proxy{
	int pageSize , blockSize ,  beginPage ,  endPage ,
      pageCount ,  rowCount ,   blockCount,  beginRow ,
      endRow ,   pageNumber,   prevBlock,   nextBlock;
    boolean existPrev , existNext ;
	@Override
	public void carryOut(Object o) {
		this.pageNumber = (int)o;
		this.pageSize = 5;
		this.blockSize = 5;
		this.rowCount = MemberServiceImpl.getInstance().count();
		this.pageCount = (rowCount%pageSize==0)? rowCount/pageSize : rowCount/pageSize+1;
		this.blockCount = (pageCount%blockSize==0)? pageCount/blockSize : pageCount/blockSize+1;
		this.beginRow = (pageNumber-1)*pageSize +1;
		this.endRow = pageNumber*pageSize;
		this.beginPage = pageNumber - ((pageNumber-1)%blockSize);
		this.endPage = ((beginPage + pageSize -1)<pageCount)? beginPage+blockSize-1 : pageCount;
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev = (prevBlock >= 0);
		this.existNext = (nextBlock <= pageCount);
		
		
	}
    
}