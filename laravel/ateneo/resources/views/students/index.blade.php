@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered students</h3>
	<table class="table" summary="list of registered students">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>name</td>
				<td>surname</td>
				<td>email</td>
				<td>phone</td>
				<td>registered</td>
				<td>updated</td>
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
				<td>{{$students->created_at}}</td>
				<td>{{$students->updated_at}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('students.edit', $students->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('students.destroy', $students->id)}}" method="post" style="display: inline-block">
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
