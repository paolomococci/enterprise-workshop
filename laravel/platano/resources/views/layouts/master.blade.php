<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>platano</title>
		<link rel="stylesheet" type="text/css" media="screen" href="{{ asset('css/app.css') }}">
		<link rel="stylesheet" type="text/css" media="screen" href="{{ asset('css/welcome.css') }}">
	</head>
	<body>
		<section class="content">
				<aside class="title m-b-md">
					<a href="/" title="home">platano</a>
				</aside>

				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container-fluid">
						<a class="navbar-brand" href="/"><span class="badge rounded-pill bg-primary">Platano</span></a>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-link active">
								<a href="/customers"><span class="badge rounded-pill bg-info text-dark">customers</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/customers/create"><span class="badge rounded-pill bg-info text-dark">add customer</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/categories"><span class="badge rounded-pill bg-info text-dark">categories</span></a>
							</li>
							<li class="nav-link active">
								<a href="/categories/create"><span class="badge rounded-pill bg-info text-dark">add category</span></a>
							</li>
							<li class="nav-link active">
								<a href="/subcategories"><span class="badge rounded-pill bg-info text-dark">subcategories</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/subcategories/create"><span class="badge rounded-pill bg-info text-dark">add subcategory</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/items"><span class="badge rounded-pill bg-info text-dark">items</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/items/create"><span class="badge rounded-pill bg-info text-dark">add item</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/orders"><span class="badge rounded-pill bg-info text-dark">orders</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/orders/create"><span class="badge rounded-pill bg-info text-dark">add order</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/invoices"><span class="badge rounded-pill bg-info text-dark">invoices</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/invoices/create"><span class="badge rounded-pill bg-info text-dark">add invoice</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/transactions"><span class="badge rounded-pill bg-info text-dark">transactions</span></a>						
							</li>
							<li class="nav-link active">
								<a href="/transactions/create"><span class="badge rounded-pill bg-info text-dark">add transaction</span></a>						
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
