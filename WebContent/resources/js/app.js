function Common() {
	this.move = function(t, x, y, z) {
		location.href = t + "/" + x + ".do?action=" + y + "&page=" + z;
	}
};

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
	this.loginValidation = function() {
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
		} else if (this.password === "") {
			alert("Please provide your pass!");
		} else {

		}
	}
};