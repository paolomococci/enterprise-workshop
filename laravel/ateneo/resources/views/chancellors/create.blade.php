@extends('layouts.master')

@section('content')
<div class="card push-top">
	<div class="card-header">
		add chancellor
	</div>

	<div class="card-body">
		@if ($errors->any())
			<div class="alert alert-danger">
				<ul>
					@foreach ($errors->all() as $error)
						<li>{{ $error }}</li>
					@endforeach
				</ul>
			</div><br/>
		@endif
		<form method="post" action="{{ route('chancellors.store') }}">
			<div class="form-group">
				@csrf
				<label for="name">name</label>
				<input 
					type="text" 
					class="form-control" 
					name="name" 
					placeholder="John"/>
			</div>
			<div class="form-group">
				<label for="surname">surname</label>
				<input 
					type="text" 
					class="form-control" 
					name="surname" 
					placeholder="Doe"/>
			</div>
			<div class="form-group">
				<label for="email">email</label>
				<input 
					type="email" 
					class="form-control" 
					name="email" 
					placeholder="john.doe@example.local"/>
			</div>
			<div class="form-group">
				<label for="phone">phone</label>
				<input 
					type="tel" 
					class="form-control" 
					name="phone" 
					pattern="^(\+\d{1,2}\s?)?1?\-?\.?\s?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" 
					placeholder="+12 1234567890"/>
			</div>
			<button type="submit" class="btn btn-block btn-danger">create chancellor</button>
			<button type="button" onclick="window.location='/chancellors'" class="btn btn-block btn-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
