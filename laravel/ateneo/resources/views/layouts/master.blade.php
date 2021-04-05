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

				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container-fluid">
						<a class="navbar-brand" href="/"><span class="badge rounded-pill bg-info text-dark">ATENEO</span></a>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-link active">
								<a href="/students">studests</a>
							</li>
							<li class="nav-link active">
								<a href="/students/create">add student</a>
							</li>
							<li class="nav-link disabled">
								<a href="#">tutors</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">add tutor</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">teachers</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">add teacher</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">employees</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">add employee</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">todo</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">chancellors</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">add chancellor</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">presidents</a>						
							</li>
							<li class="nav-link disabled">
								<a href="#">add president</a>						
							</li>
						</ul>
						<form class="d-flex">
							<input class="form-control me-2" type="search" placeholder="search" aria-label="search">
							<button class="btn btn-outline-success" type="submit">search</button>
						</form>
					</div>
				</nav>
				
				<section class="container">
					@yield('content')
				</section>
		</section>
		<script type="text/javascript" src="{{ asset('js/app.js') }}"></script>
	</body>
</html>
