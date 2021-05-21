@extends('layouts.master')

@section('content')
<div class="card push-top">
	<div class="card-header">
		add invoice
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
		<form method="post" action="{{ route('invoices.store') }}">
			<div class="form-group">
				@csrf
				<label for="todo">todo</label>
				<input 
					type="text" 
					class="form-control" 
					name="todo" 
					placeholder="todo"/>
			</div>
			<button type="submit" class="btn btn-block btn-outline-primary">create invoice</button>
			<button type="button" onclick="window.location='/invoices'" class="btn btn-block btn-outline-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
