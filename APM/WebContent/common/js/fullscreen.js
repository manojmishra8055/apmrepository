 (function() {
    var
        fullScreenApi = {
            supportsFullScreen: false,
            nonNativeSupportsFullScreen: false,
            isFullScreen: function() { return false; },
            requestFullScreen: function() {},
            cancelFullScreen: function() {},
            fullScreenEventName: '',
            prefix: ''
        },
        browserPrefixes = 'webkit moz o ms khtml'.split(' ');
 
    // check for native support
    if (typeof document.cancelFullScreen != 'undefined') {
        fullScreenApi.supportsFullScreen = true;
    } else {
        // check for fullscreen support by vendor prefix
        for (var i = 0, il = browserPrefixes.length; i < il; i++ ) {
            fullScreenApi.prefix = browserPrefixes[i];
 
            if (typeof document[fullScreenApi.prefix + 'CancelFullScreen' ] != 'undefined' ) {
                fullScreenApi.supportsFullScreen = true;
 
                break;
            }
        }
    }
 
    // update methods to do something useful
    if (fullScreenApi.supportsFullScreen) {
        fullScreenApi.fullScreenEventName = fullScreenApi.prefix + 'fullscreenchange';
 
        fullScreenApi.isFullScreen = function() {
            switch (this.prefix) {
                case '':
                    return document.fullScreen;
                case 'webkit':
                    return document.webkitIsFullScreen;
                default:
                    return document[this.prefix + 'FullScreen'];
            }
        }
        fullScreenApi.requestFullScreen = function(el) {
            return (this.prefix === '') ? el.requestFullScreen() : el[this.prefix + 'RequestFullScreen']();
        }
        fullScreenApi.cancelFullScreen = function(el) {
            return (this.prefix === '') ? document.cancelFullScreen() : document[this.prefix + 'CancelFullScreen']();
        }
    }
    else if (typeof window.ActiveXObject !== "undefined") { // IE.
        fullScreenApi.nonNativeSupportsFullScreen = true;
        fullScreenApi.requestFullScreen = fullScreenApi.requestFullScreen = function (el) {
                var wscript = new ActiveXObject("WScript.Shell");
                if (wscript !== null) {
                    wscript.SendKeys("{F11}");
                }
        }
        fullScreenApi.isFullScreen = function() {
                return document.body.clientHeight == screen.height && document.body.clientWidth == screen.width;
        }
    }
 
    // jQuery plugin
    if (typeof jQuery != 'undefined') {
        jQuery.fn.requestFullScreen = function() {
 
            return this.each(function() {
                if (fullScreenApi.supportsFullScreen) {
                    fullScreenApi.requestFullScreen(this);
                }
            });
        };
    }
 
    // export api
    window.fullScreenApi = fullScreenApi;
})();



function getCurrentDate(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	
	if(dd<10) {
	    dd='0'+dd
	} 
	
	if(mm<10) {
	    mm='0'+mm
	} 
	
	today = yyyy+'/'+mm+'/'+dd;
	//document.write(today);

	return today;
}

function dateFormat(date){
	var tempDate = date.split("/");
	
	var dd = tempDate[0];
	var mm = tempDate[1]; //January is 0!
	var yyyy = tempDate[2];
	
	var result = yyyy+'/'+mm+'/'+dd;
	
	return result;
}


function getCurrentTime(){
	var d = new Date();
	var hh = d.getHours(); // => 9
	var mm = d.getMinutes(); // =>  30
	var ss = 0; // => 51
	
	
	if(hh<10) {
	    hh='0'+hh
	} 
	
	if(mm<10) {
	    mm='0'+mm
	} 
	
	if(ss<10) {
	    ss='0'+ss
	} 
	
	var result = hh+':'+mm+':'+ss;
	
	return result;

}


function getMonthName(cnt){

var result = "";
	var weekname=new Array(6);
		weekname[0]="Monday";
		weekname[1]="Tuesday";
		weekname[2]="Wednesday";
		weekname[3]="Thursday";
		weekname[4]="Friday";
		weekname[5]="Saturday";
		weekname[6]="Sunday";

	result = weekname[cnt]
	
	return result;
}


function read_cookie(key){
   	 	var result;
   	 	return (result = new RegExp('(^|; )' + encodeURIComponent(key) + '=([^;]*)').exec(document.cookie)) ? result[2] : null;
	}


