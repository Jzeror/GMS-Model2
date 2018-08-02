
var router = (()=> {
	return {move : x=> {
		location.href = x.context + "/" + x.domain + ".do?action=" + x.action + "&page=" + x.page;
	}};
})();

var service = (()=>{
	return {
		nullChecker : x=>{
			var i = 0;
			var j = {
					checker : true,
					text : '필수 입력 값이 없습니다.'
			};
			for(i in x){
				if(x[i]===""){
					j.checker = false;
				}
			};
			return j;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
			if(arr.indexOf(cName) == -1){
				dom.className += " " + cName;
			}
		}
	}
})();


/*joinValidation : x=>{
	if (x.getMemId() === "") {
		alert("Please provide your id!");
		return false;
	} else if (x.getPassword() === "") {
		alert("Please provide your pass!");
		return false;
	} else {
		return true;
	}
}*/

var mem=(()=> {
	var _memId, _ssn, _password, _name, _age, _gender, _roll, _teamId; 
	var setMemId = (memId)=> {this._memId = memId;}
	var setSsn = (ssn) =>{this._ssn = ssn;}
	var setPassword = (password)=> {this._password = password;}
	var setName = (name)=> {this._name = name;}
	var setAge = x=> {
		this._age = Number(new Date().getFullYear().toString().substr(2,2))-Number(x.substr(0,2))+101;
	}
	var setGender = x=> {
		this._gender = (x.split("-")[1]===('2'||'4'))?'여자':'남자';
	}
	var setRoll = (roll)=> {this._roll = roll;}
	var setTeamId = (teamId)=> {this._teamId = teamId;}
	var getMemId = ()=> {return this._memId;}
	var getSsn = ()=> {return this._ssn;}
	var getName = ()=> {return this._name;}
	var getPassword = ()=> {return this._password;}
	var getAge = ()=> {return this._age;}
	var getGender = ()=> {return this._gender;}
	var getRoll = ()=> {return this._roll;}
	var getTeamId = ()=> {return this._teamId;}
	return {
		setMemId : setMemId,
		setSsn : setSsn,
		setPassword : setPassword,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		setRoll : setRoll,
		setTeamId : setTeamId,
		getMemId : getMemId,
		getSsn : getSsn,
		getPassword : getPassword,
		getName : getName,
		getAge : getAge,
		getGender : getGender,
		getRoll : getRoll,
		getTeamId : getTeamId,
		join : x=>{
			mem.setAge(x);
			mem.setGender(x);
		}
	};
})();

var admin = (()=>{
	return{
		check : x=>{router.move({
			context : x,
			domain : 'admin',
			action : 'list',
			page : 'main'});
/*			var isAdmin = confirm('관리자니?');
			if(isAdmin){
				var password = prompt('관리자비번을 입력바랍니다');
				if(password == 3){
					router.move({
						context : x,
						domain : 'admin',
						action : 'list',
						page : 'main'});
				}else{alert('이상한짓 하지마렴 준아');}
			}else{
				alert('솔직하구나');
			}*/
		},
		main : x=>{

			 document.getElementById('searchBtn').addEventListener('click',function(){
				 var j = document.getElementById('searchOption');
				 var k = document.getElementById('searchWord');
				 location.href=(j.value==="userId")?x+'/admin.do?action=retrieve&page=memberDetail&searchWord='
						 +k.value+'&searchOption='+j.value
						 :
							 x+'/admin.do?action=retrieve&page=main&searchOption='
									 +j.value+'&searchWord='+k.value; 
			});
			service.addClass(
					document.getElementById('content_box'),
					'textAlignRight '
					);
			service.addClass(
					document.getElementById('contentBoxMeta'),
					'bgColorisYellow '
					);
			service.addClass(
					document.getElementById('contentBoxTab'),
					'width1000px marginAtuo '
					);


			for(i of document.querySelectorAll('.username') ){
				service.addClass(
						i,
						'fontColorBlue cursor ');
				i.addEventListener('click', function(){
					location.href=x+'/admin.do?searchOption=userId&action=retrieve&page=memberDetail&searchWord='+this.getAttribute('id');
				});
			}

		}
	};})();













