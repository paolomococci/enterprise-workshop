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
		<form method="post" action="{{ route('tutors.update', $tutor->id) }}">
			<div class="form-group">
				@csrf
				@method('PATCH')
				<label for="name">name</label>
				<input 
					type="text" 
					class="form-control" 
					name="name" 
					value="{{ $tutor->name }}"/>
			</div>
			<div class="form-group">
				<label for="surname">surname</label>
				<input 
					type="text" 
					class="form-control" 
					name="surname" 
					value="{{ $tutor->surname }}"/>
			</div>
			<div class="form-group">
				<label for="email">email</label>
				<input 
					type="email" 
					class="form-control" 
					name="email" 
					value="{{ $tutor->email }}"/>
			</div>
			<div class="form-group">
				<label for="phone">phone</label>
				<input 
					type="tel" 
					class="form-control" 
					name="phone" 
					pattern="^(\+\d{1,2}\s?)?1?\-?\.?\s?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$" 
					value="{{ $tutor->phone }}"/>
			</div>
			<button type="submit" class="btn btn-block btn-danger">update tutor</button>
			<button type="button" onclick="window.location='/tutors'" class="btn btn-block btn-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
