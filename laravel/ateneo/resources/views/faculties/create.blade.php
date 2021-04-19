@extends('layouts.master')

@section('content')
<div class="card push-top">
	<div class="card-header">
		add faculty
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
		<form method="post" action="{{ route('faculties.store') }}">
			<div class="form-group">
				@csrf
				<label for="name">name</label>
				<input 
					type="text" 
					class="form-control" 
					name="name" 
					placeholder="Management Science and Engineering"/>
			</div>
			<button type="submit" class="btn btn-block btn-primary">create faculty</button>
			<button type="button" onclick="window.location='/faculties'" class="btn btn-block btn-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
