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
		<form method="post" action="{{ route('customers.update', $customer->id) }}">
			<div class="form-group">
				@csrf
				@method('PATCH')
				<label for="todo">todo</label>
				<input 
					type="text" 
					class="form-control" 
					name="todo" 
					value="{{ $customer->todo }}"/>
			</div>
			<button type="submit" class="btn btn-block btn-outline-danger">update customer</button>
			<button type="button" onclick="window.location='/customers'" class="btn btn-block btn-outline-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
