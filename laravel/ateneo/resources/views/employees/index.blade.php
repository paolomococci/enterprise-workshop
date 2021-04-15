@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered employees</h3>
	<table class="table" summary="list of registered employees">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>name</td>
				<td>surname</td>
				<td>email</td>
				<td>phone</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($employee as $employees)
			<tr>
				<td>{{$employees->id}}</td>
				<td>{{$employees->name}}</td>
				<td>{{$employees->surname}}</td>
				<td>{{$employees->email}}</td>
				<td>{{$employees->phone}}</td>
				<td class="text-center">
					<a href="{{ route('employees.edit', $employees->id)}}" class="btn btn-primary btn-sm"">edit</a>
					<form action="{{ route('employees.destroy', $employees->id)}}" method="post" style="display: inline-block">
						@csrf
						@method('DELETE')
						<button class="btn btn-danger btn-sm"" type="submit">delete</button>
					</form>
				</td>
			</tr>
			@endforeach
		</tbody>
	</table>
</div>
@endsection
