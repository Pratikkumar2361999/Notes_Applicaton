
$(document).ready(function() {
	$('#des').autoResize({
		maxHeight: '256px'
	});
});


(function() {
		var grid;
		function init() {
			grid = new Minigrid({
				container : '.cards',
				item : '.card',
				gutter : 12
			});
			grid.mount();
		}

		// mount
		function update() {
			grid.mount();
		}

		document.addEventListener('DOMContentLoaded', init);
		window.addEventListener('resize', update);
	})();
	
	var b = false;
	function submitForm() {
		var title = document.getElementById("title").value;
		var des = document.getElementById("des").value;

		if (title != "" || des != "") {
			if (b == true) {
				document.getElementById("form").submit();
				// console.log(b);
			}

		}
		b = false;

	}
	function allowClick() {
		b = true;
	}
