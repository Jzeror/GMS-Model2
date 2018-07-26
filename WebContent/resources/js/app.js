var router = (()=> {
	return {move : x=> {
		location.href = x[0] + "/" + x[1] + ".do?action=" + x[2] + "&page=" + x[3];
	}};
})();

var service = (()=>{
	return {
		loginValidation : x=>{
			var ok = false;
			if (x[0] === "") {
				alert("Please provide your id!");
			} else if (x[1] === "") {
				alert("Please provide your pass!");
			} else {
				ok = ture;
			}
			return ok;
		},
		joinValidation : x=>{
			if (x.getMemId() === "") {
				alert("Please provide your id!");
				return false;
			} else if (x.getPassword() === "") {
				alert("Please provide your pass!");
				return false;
			} else {
				return true;
			}
		}
	};
})();

function Mem() {
	var memId, ssn, password; 
	this.setMemId = function(x) {
		this.memId = x;
	}
	this.setSsn = function(y) {
		this.ssn = y;
	}
	this.setPassword = function(z) {
		this.password = z;
	}
	this.getMemId = function() {
		return this.memId;
	}
	this.getSsn = function() {
		return this.ssn;
	}
	this.getPassword = function() {
		return this.password;
	}
	/*this.loginValidation = function() {
		var ok = false;
		if (this.memId === "") {
			alert("Please provide your id!");
		} else if (this.password === "") {
			alert("Please provide your pass!");
		} else {
			ok = ture;
		}
		return ok;
	}
	this.joinValidation = function() {
		if (this.memId === "") {
			alert("Please provide your id!");
			return false;
		} else if (this.password === "") {
			alert("Please provide your pass!");
			return false;
		} else {
			return true;
		}
	}*/
}
