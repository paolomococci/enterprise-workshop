<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>ateneo</title>
		<link rel="stylesheet" type="text/css" media="screen" href="{{ asset('css/app.css') }}">
		<link rel="stylesheet" type="text/css" media="screen" href="{{ asset('css/welcome.css') }}">
	</head>
	<body>
		<section class="content">
				<aside class="title m-b-md">
					<a href="/" title="home">ateneo</a>
				</aside>

				<aside class="links">
					<a href="/students">studests</a>
					<a href="/students/create">add student</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
				</aside>
				
				<section class="container">
					@yield('content')
				</section>
		</section>
		<script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
	</body>
</html>
