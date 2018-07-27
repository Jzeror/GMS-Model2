var router = (()=> {
	return {move : x=> {
		location.href = x[0] + "/" + x[1] + ".do?action=" + x[2] + "&page=" + x[3];
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
