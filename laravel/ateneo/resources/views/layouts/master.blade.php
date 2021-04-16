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
						<a class="navbar-brand" href="/"><span class="badge rounded-pill bg-primary">ATENEO</span></a>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-link active">
								<a href="/students"><span class="badge rounded-pill bg-info text-dark">studests</span></a>
							</li>
							<li class="nav-link active">
								<a href="/students/create"><span class="badge rounded-pill bg-info text-dark">add student</span></a>
							</li>
							<li class="nav-link active">
								<a href="/tutors"><span class="badge rounded-pill bg-info text-dark">tutors</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/tutors/create"><span class="badge rounded-pill bg-info text-dark">add tutor</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/teachers"><span class="badge rounded-pill bg-info text-dark">teachers</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/teachers/create"><span class="badge rounded-pill bg-info text-dark">add teacher</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/employees"><span class="badge rounded-pill bg-info text-dark">employees</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/employees/create"><span class="badge rounded-pill bg-info text-dark">add employee</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/chancellors"><span class="badge rounded-pill bg-info text-dark">chancellors</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/chancellors/create"><span class="badge rounded-pill bg-info text-dark">add chancellor</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/faculties"><span class="badge rounded-pill bg-info text-dark">faculties</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/presidents"><span class="badge rounded-pill bg-info text-dark">presidents</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/presidents/create"><span class="badge rounded-pill bg-info text-dark">add president</span></a>						
							</li>
							<!--li class="nav-link disabled">
								<a href="#"><span class="badge rounded-pill bg-info text-dark">todo</span></a>						
							</li-->
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
