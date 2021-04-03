<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="{{ url('css/welcome.css')}}" type="text/css" media="screen"/>
		<title>ateneo</title>
	</head>
	<body>
		<div class="flex-center position-ref full-height">
			@if (Route::has('login'))
				<div class="top-right links">
					@auth
						<a href="{{ url('/home') }}">Home</a>
					@else
						<a href="{{ route('login') }}">Login</a>
						@if (Route::has('register'))
							<a href="{{ route('register') }}">Register</a>
						@endif
					@endauth
				</div>
			@endif

			<div class="content">
				<div class="title m-b-md">
					ateneo
				</div>

				<div class="links">
					<a href="/students">studests</a>
					<a href="/students/create">add student</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
					<a href="#">todo</a>
				</div>
			</div>
		</div>
	</body>
</html>
