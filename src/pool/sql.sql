알엑스

SELECT (count(*)/5)+case count(*) when count(*)/5=0 then '0'
						else '1' end 페이지수		
from member
;
--페이지 수를 구하는 쿼리.
--ROWNUM 구한뒤 페이지당 회원의 id만 보여주는 쿼리

SELECT case when count(*)/5=0 then count(*)/5
					else TRUNC(count(*)/5)+1 end 수웃자	
from member
;

select rownum "no.",a.*
from (SELECT * FROM MEMBER)a
;

select b.*
from (select rownum "no."
        ,a.*
from (SELECT * FROM MEMBER)a)b
where "no." between 6 AND 10;


--선생님 풀이
select rownum seq, m.*
from member m
;
select t.*
from (select rownum seq, m.*
from member m) t
;
select t.*
from (select rownum seq, m.*
from member m order by seq desc) t
;
select t.*
from (select rownum seq, m.*
from member m order by seq desc) t
where t.seq between 1 and 5
;   --이게 페이지 쿼리가 됨. 사용자는 페이지를 클릭하고 자바가 그 페이지에 해당하는 시작값과 끝값을 주면 됨