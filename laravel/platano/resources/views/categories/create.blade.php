@extends('layouts.master')

@section('content')
<div class="card push-top">
	<div class="card-header">
		add category
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
		<form method="post" action="{{ route('categories.store') }}">
			<div class="form-group">
				@csrf
				<label for="name">name</label>
				<input 
					type="text" 
					class="form-control" 
					name="name" 
					placeholder="some category"/>
			</div>
			<button type="submit" class="btn btn-block btn-outline-primary">create category</button>
			<button type="button" onclick="window.location='/categories'" class="btn btn-block btn-outline-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
