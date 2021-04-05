@extends('layouts.master')

@section('content')
	<div class="push-top">
		@if(session()->get('success'))
			<div class="alert alert-success">
				{{ session()->get('success') }}
			</div><br/>
		@endif
		<table class="table">
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
			@foreach($student as $students)
				<tr>
					<td>{{$students->id}}</td>
					<td>{{$students->name}}</td>
					<td>{{$students->surname}}</td>
					<td>{{$students->email}}</td>
					<td>{{$students->phone}}</td>
					<td class="text-center">
						<a href="{{ route('students.edit', $students->id)}}" class="btn btn-primary btn-sm"">edit</a>
						<form action="{{ route('students.destroy', $students->id)}}" method="post" style="display: inline-block">
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
