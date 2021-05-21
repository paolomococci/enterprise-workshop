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
		<form method="post" action="{{ route('transactions.update', $transaction->id) }}">
			<div class="form-group">
				@csrf
				@method('PATCH')
				<label for="todo">todo</label>
				<input 
					type="text" 
					class="form-control" 
					name="todo" 
					value="{{ $transaction->todo }}"/>
			</div>
			<button type="submit" class="btn btn-block btn-outline-danger">update transaction</button>
			<button type="button" onclick="window.location='/transactions'" class="btn btn-block btn-outline-secondary">cancel</button>
		</form>
	</div>
</div>
@endsection
