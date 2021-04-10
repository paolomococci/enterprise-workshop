@extends('layouts.master')

@section('content')
<div class="card push-top">
	<div class="card-header">
		edit/update
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
		<form method="post" action="{{ route('faculties.update', $faculty->id) }}">
			<div class="form-group">
				@csrf
				@method('PATCH')
				<label for="name">name</label>
				<input 
					type="text" 
					class="form-control" 
					name="name" 
					value="{{ $faculty->name }}"/>
			</div>
			<button type="submit" class="btn btn-block btn-danger">update faculty</button>
		</form>
	</div>
</div>
@endsection
