@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered customers</h3>
	<table class="table" summary="list of registered customers">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>todo</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($customer as $customers)
			<tr>
				<td>{{$customers->id}}</td>
				<td>{{$customers->todo}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('customers.edit', $customers->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('customers.destroy', $customers->id)}}" method="post" style="display: inline-block">
							@csrf
							@method('DELETE')
							<button class="btn btn-danger btn-sm"" type="submit">delete</button>
						</form>
					</nobr>
				</td>
			</tr>
			@endforeach
		</tbody>
	</table>
</div>
@endsection
