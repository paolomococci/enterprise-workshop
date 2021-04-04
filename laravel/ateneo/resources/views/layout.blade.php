<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>ateneo</title>
		<link rel="stylesheet" media="screen" href="{{ asset('css/app.css') }}">
	</head>
	<body>
		<div class="container">
			@yield('content')
		</div>
		<script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
	</body>
</html>
