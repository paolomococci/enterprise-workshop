<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>ateneo</title>
		<link rel="stylesheet" media="screen" href="{{ asset('css/app.css') }}">
	</head>
	<body>
		<section class="container">
			@yield('content')
		</section>
		<script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
	</body>
</html>
