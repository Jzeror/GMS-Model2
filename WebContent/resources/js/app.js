
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


/*
 * joinValidation : x=>{ if (x.getMemId() === "") { alert("Please provide your
 * id!"); return false; } else if (x.getPassword() === "") { alert("Please
 * provide your pass!"); return false; } else { return true; } }
 */

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

var member= (()=>{
	return{
		main : x=>{
			document.getElementById('loginFormBtn').addEventListener(
					'click',function() {
						var form = document.getElementById("user-login-form-id");
						var e = service.nullChecker([
							form.name.value,
							form.pass.value ]);
					if (e.checker) {
						var node = document.createElement("input");
						node.innerHTML= '<input type="hidden" name="action" value="login" />';
						form.appendChild(node);
						var node2 = document.createElement("input");
						node2.innerHTML= '<input type="hidden" name="page" value="retrieve" />';
						form.appendChild(node2);
						form.action = x+"/member.do";
						form.method = "post";
						form.submit();
					} else {
						alert(x.text);
					}
				});
			document.getElementById('join_form_btn')
				.addEventListener('click',()=> {
					var form = document.getElementById("join_form");
					var e = service.nullChecker([ form.memid.value,
						form.password.value, form.name.value,
						form.ssn.value ]);
					if (e.checker) {
						mem.join(form.ssn.value);
						var j = [ 
							{name : 'action',value : 'add'},
							{name : 'gender',value : mem.getGender()}, 
							{name : 'age',value : mem.getAge()},
							{name : 'page', value : 'seac2h'}
						];
						for ( var i in j) {
						var node = document.createElement('input');
							node.setAttribute('type', 'hidden');
							node.setAttribute('name', j[i].name);
							node.setAttribute('value', j[i].value);
							form.appendChild(node);
						}
						form.action = x+"/member.do";
						form.method = "post";
						form.submit();
					} else {
						alert(x.text);
					}
			});
		}
	};
})();

var common= (()=>{
	return{
		main : x=>{
			document.getElementById('goAdmin')
			.addEventListener('click', ()=>{ 
				var isAdmin = confirm('관리자니?');
				if(isAdmin){ 
					var password = prompt('관리자비번을 입력바랍니다');
					if(password == 3){
						router.move({ context : x, domain : 'admin', action : 'search', page : 'main'}); 
					}else{alert('이상한짓 하지마렴 준아');} 
				}else{
					alert('솔직하구나'); 
				}
			});
			
			

		}
	};
})();

var admin = (()=>{
	return{
		main : x=>{
			 document.getElementById('searchBtn').addEventListener('click',()=>{
				 var j = document.getElementById('searchOption');
				 var k = document.getElementById('searchWord');
				 location.href=(j.value==="userId")?x+'/member.do?action=retrieve&page=retrieve&searchWord='
						 +k.value+'&searchOption='+j.value
						 : x+'/member.do?action=search&page=search&searchOption='
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
					location.href=x+'/member.do?searchOption=userId&action=retrieve&page=retrieve&searchWord='+this.getAttribute('id');
				});
			}
			for(i of document.querySelectorAll(".pageNumber")){
				service.addClass(
						i,
						'fontColorBlue cursor ');
				 i.addEventListener('click',function(){
					 	 location.href = x +'/admin.do?action=search&page=main&pageNum='+this.getAttribute('id');
					 }		 
				 );
			 } 

		}
	};})();
